package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.FactArea;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = FactArea.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FactAreaImpl implements FactArea {
    private static final Logger LOG = LoggerFactory.getLogger(FactAreaImpl.class);
    @ChildResource
    Resource factareamultifield;
    @Override
    public List<Map<String, String>> getFactAreaDetails() {
        List<Map<String, String>> factAreaMap=new ArrayList<>();
        //try {
        // Resource factAreaDetail=componentResource.getChild("factareamulti");
        if(factareamultifield!=null){
            for (Resource fact : factareamultifield.getChildren()) {
                Map<String,String> factarea=new HashMap<>();
                factarea.put("value",fact.getValueMap().get("value",String.class));
                factarea.put("text",fact.getValueMap().get("text",String.class));
                factAreaMap.add(factarea);
            }
        }

        return factAreaMap;
    }
}
