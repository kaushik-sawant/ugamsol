package com.ugamsol.core.models.impl;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.ugamsol.core.models.ServiceUserList;
import com.ugamsol.core.utils.ResolverUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import org.apache.sling.api.resource.LoginException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = ServiceUserList.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServiceUserListImpl implements ServiceUserList{
    @Inject
    private ResourceResolverFactory resourceResolverFactory;

    final Logger LOG = LoggerFactory.getLogger(ServiceUserListImpl.class);

    @Inject
    QueryBuilder queryBuilder;
    String listofuser = " ";
    @PostConstruct
    protected void init(){
        LOG.info("\n logs");
    }

    @Override
    public String getUsersList() {
        Map<String, String> map = new HashMap<>();
        map.put("p.hits", "selective");
        map.put("p.limit", "-1");
        map.put("property", "jcr:primaryType");
        map.put("property.value", "rep:User");
        map.put("path", "/home/users");
        map.put("type", "rep:User");
        map.put("p.properties", "rep:principalName");
        try{
            ResourceResolver serviceResourceResolver = ResolverUtil.newResolver(resourceResolverFactory);

            Session session = serviceResourceResolver.adaptTo(Session.class);
            Query userQuery = queryBuilder.createQuery(PredicateGroup.create(map), session);
            SearchResult result = userQuery.getResult();
            List<Hit> Hits = result.getHits();
            for (Hit hit : Hits) {

                listofuser = listofuser + "\r\n" + hit.getProperties().get("rep:principalName", String.class);
            }
        } catch (Exception e) {
            LOG.info("error message",e.getMessage());
        }
        return listofuser;
    }

}
