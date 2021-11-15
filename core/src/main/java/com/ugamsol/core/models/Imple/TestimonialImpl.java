package com.ugamsol.core.models.Imple;

import com.ugamsol.core.models.Testimonial;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Testimonial.class,
        resourceType = TestimonialImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

@Exporter(name="jackson", extensions = "json", selector="test")
public class TestimonialImpl implements Testimonial {

    public static final String RESOURCE_TYPE = "ugamsol/components/content/testimonial";
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
