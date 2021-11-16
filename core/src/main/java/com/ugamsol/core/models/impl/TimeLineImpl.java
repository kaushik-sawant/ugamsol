package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.TimeLine;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(
        adaptables = Resource.class,
        adapters = TimeLine.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = TimeLineImpl.RESOURCE_TYPE
)
@Exporter(name="jackson", extensions = "json", selector = "Time")
public class TimeLineImpl implements TimeLine{
    private static final Logger LOG = LoggerFactory.getLogger(TimeLineImpl.class);

    final protected static String RESOURCE_TYPE = "ugamsol/components/content/timeline";

    @ChildResource
    Resource timelinemultifield;
    @Override
    public List<Map<String, String>> getTimeLineDetails() {
        List<Map<String, String>> timeLineMap=new ArrayList<>();
        //try {
        // Resource factAreaDetail=componentResource.getChild("factareamulti");
        if(timelinemultifield!=null){
            for (Resource fact : timelinemultifield.getChildren()) {
                Map<String,String> timelinearea=new HashMap<>();
                timelinearea.put("title",fact.getValueMap().get("title",String.class));
                timelinearea.put("year",fact.getValueMap().get("year",String.class));
                timelinearea.put("result",fact.getValueMap().get("result",String.class));
                timeLineMap.add(timelinearea);
            }
        }
        // }catch (Exception e){
        //LOG.info("\n ERROR while getting Fact Area Details {} ",e.getMessage());
        //}
        // LOG.info("\n SIZE {} ",factAreaMap.size());
        return timeLineMap;
    }
}
