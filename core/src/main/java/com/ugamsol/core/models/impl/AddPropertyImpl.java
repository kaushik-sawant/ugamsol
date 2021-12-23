package com.ugamsol.core.models.impl;

import com.day.cq.commons.date.DateUtil;
import com.day.cq.wcm.api.components.ComponentContext;
import com.ugamsol.core.models.AddProperty;
import com.ugamsol.core.utils.ResolverUtils;
import org.apache.sling.api.resource.*;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.Session;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = AddProperty.class, immediate = true)
public class AddPropertyImpl implements AddProperty{
    private static final Logger LOG = LoggerFactory.getLogger(AddPropertyImpl.class);
    @Reference
    ResourceResolverFactory resourceResolverFactory;

    String path = "/content/ugamsol/us/en/home-page/jcr:content/root/responsivegrid_786455242/displaydate";
    @Override
    public String doAWriteOperation(String path) {
        try{

            ResourceResolver serviceResourceResolver = ResolverUtils.newResolver(resourceResolverFactory);
            Session session = serviceResourceResolver.adaptTo(Session.class);
            Resource resource = serviceResourceResolver.getResource(path);
            Node node = resource.adaptTo(Node.class);
            node.setProperty("time" , DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance())));
            session.save();
            session.logout();
        } catch (Exception e) {
            LOG.info(e.getMessage());
        }
        return path;
    }
}
