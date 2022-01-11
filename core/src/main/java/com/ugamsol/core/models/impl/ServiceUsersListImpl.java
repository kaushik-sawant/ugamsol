package com.ugamsol.core.models.impl;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.ugamsol.core.models.ServiceUsersList;
import com.ugamsol.core.utils.ResolverUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.Session;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = ServiceUsersList.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServiceUsersListImpl implements ServiceUsersList {
    @Inject
    private ResourceResolverFactory resourceResolverFactory;

    final Logger log = LoggerFactory.getLogger(ServiceUsersListImpl.class);

    @Inject
    QueryBuilder queryBuilder;
    String listofusers = " ";
    @PostConstruct
    protected void init(){
        log.info("\n logs");
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
            ResourceResolver serviceResourceResolver = ResolverUtils.newResolver(resourceResolverFactory);

            Session session = serviceResourceResolver.adaptTo(Session.class);
            Query userQuery = queryBuilder.createQuery(PredicateGroup.create(map), session);
            SearchResult result = userQuery.getResult();
            List<Hit> Hits = result.getHits();
            for (Hit hit : Hits) {

                listofusers = listofusers + "\r\n" + hit.getProperties().get("rep:principalName", String.class);
            }
        } catch (Exception e) {
           e.getStackTrace();
        }
        return listofusers;
    }

}
