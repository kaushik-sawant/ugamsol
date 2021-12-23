package com.ugamsol.core.models.impl;

import com.day.cq.commons.date.DateUtil;
import com.day.cq.replication.*;
import com.ugamsol.core.models.AddProperty;
import org.apache.sling.api.resource.*;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import com.ugamsol.core.utils.ResolverUtils;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.Session;
import java.util.Calendar;


@Component(immediate = true)
public class MyPreprocessorImpl implements Preprocessor {
    public static final Logger LOG = LoggerFactory.getLogger(MyPreprocessorImpl.class);
    @Reference
    ResourceResolverFactory resourceResolverFactory;
    @Reference
    Replicator replicator;
    @Reference
    AddProperty addProperty;
    String path1 = "/content/ugamsol/us/en/home-page/jcr:content/root/responsivegrid_786455242/displaydate";
    @Override
    public void preprocess(ReplicationAction replicationAction, ReplicationOptions replicationOptions) throws ReplicationException {
        LOG.info("\nInside Method");
        if (replicationAction == null || !ReplicationActionType.ACTIVATE.equals(replicationAction.getType())) {
            return;
        }
        String path = replicationAction.getPath();
        if (path.equals("/content/ugamsol/us/en/home-page")) {
            LOG.debug("\n home page path");

            try {
                ResourceResolver resourceResolver = ResolverUtils.newResolver(resourceResolverFactory);
                Session session = resourceResolver.adaptTo(Session.class);
                Resource resource = resourceResolver.getResource(path1);
                Node node = resource.adaptTo(Node.class);
                LOG.info("\n after node");
                //Calendar date = (Calendar)node.getProperty("date");
                Property date = node.getProperty("time");

                LOG.info("\n after date");
                if (date == DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance()))) {
                    LOG.info("\nInside IF");
                    replicator.replicate(session, ReplicationActionType.ACTIVATE, "/content/ugamsol/us/en/home-page");
                    LOG.info("Page Activated");
                } else {
                    LOG.info("\nInside Else");
                   addProperty.doAWriteOperation(path1);
                    replicator.replicate(session, ReplicationActionType.ACTIVATE, "/content/ugamsol/us/en/home-page");
                    session.save();
                    session.logout();
                }
                LOG.debug(path);
            } catch (Exception e) {
                LOG.info(e.getMessage());
            }
        }
    }

}

