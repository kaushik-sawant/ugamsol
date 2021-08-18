package com.ugamsol.core.models.Imple;


import com.ugamsol.core.models.Testimonialmulti;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = Testimonialmulti.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TestimonialmultiImpl implements Testimonialmulti {
    @ChildResource
    Resource Testimonialmultifield;
    @Override
    public List<Map<String, String>> getTestimonialDetails() {
        List<Map<String, String>> testimonialArea=new ArrayList<>();

        if(Testimonialmultifield!=null){
            for (Resource fact : Testimonialmultifield.getChildren()) {
                Map<String,String> testimonial=new HashMap<>();
                testimonial.put("description",fact.getValueMap().get("description",String.class));
                testimonial.put("name",fact.getValueMap().get("name",String.class));
                testimonial.put("designation",fact.getValueMap().get("designation",String.class));
                testimonialArea.add(testimonial);
            }
        }
        return testimonialArea;
    }
}
