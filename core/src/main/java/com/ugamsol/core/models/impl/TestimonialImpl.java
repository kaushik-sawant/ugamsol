package com.ugamsol.core.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.ugamsol.core.models.Testimonial;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Exporters;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Model(adaptables = Resource.class,
        adapters = Testimonial.class,
        resourceType = TestimonialImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

@Exporters({
    @Exporter(name="jackson", extensions = "json", selector="test"),
    @Exporter(name="geeksxml", extensions = "xml", selector = "geeksxml")
})
@JsonRootName("JsonMultiExporter")
@XmlRootElement(name="xml multi-exporter")
public class TestimonialImpl implements Testimonial {

    public static final String RESOURCE_TYPE = "ugamsol/components/content/testimonial";
    @Inject
    String name;
    @Inject
    String desc;
    @Inject
    String desg;

    @Override
    @XmlElement(name = "xml author name")
    @JsonProperty(value="json author name")
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
