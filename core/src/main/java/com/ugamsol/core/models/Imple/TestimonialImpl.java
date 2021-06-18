package com.ugamsol.core.models.Imple;

import com.ugamsol.core.models.Testimonial;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Testimonial.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestimonialImpl implements Testimonial {

    @Inject
    String name;
    @Inject
    String desc;
    @Inject
    String desg;

    @Override
    public String getTestimonialName() {
        return name;
    }

    @Override
    public String getTestimonialDescription() {
        return desc;
    }

    @Override
    public String getTestimonialDesignation() {
        return desg;
    }
}
