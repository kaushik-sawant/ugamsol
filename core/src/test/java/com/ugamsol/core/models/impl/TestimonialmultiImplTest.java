package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.Testimonialmulti;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TestimonialmultiImplTest {
    private final AemContext aemContext = new AemContext();
    @BeforeEach
    void setUp() {
        aemContext.load().json("/Testimonialmulti.json", "/content");
    }

    @Test
    void getTestimonialDetails() {
        Resource resource = aemContext.currentResource("/content");
        //Testimonialmulti testimonial = resource.adaptTo(Testimonialmulti.class);
        Testimonialmulti testimonial = aemContext.request().adaptTo(Testimonialmulti.class);
        assertEquals("Do you want to be even more successful? Learn to love learning and growth. The more effort you put into improving your skills, the bigger the payoff you.", testimonial.getTestimonialDetails().get(0).get("description"));
    }
}