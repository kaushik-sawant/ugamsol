package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.BannerArea;
import com.ugamsol.core.models.Service;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class serviceImpleTest {
    private final AemContext aemContext = new AemContext();
    private Service service;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Service.json", "/content");

    }

    @Test
    void getServiceTitle() {
        Resource json = aemContext.currentResource("/content/service");
        Service serv = json.adaptTo(Service.class);
        assertEquals("Web Design", serv.getServiceTitle());
    }

    @Test
    void getServiceText() {
        Resource json = aemContext.currentResource("/content/service");
        Service serv = json.adaptTo(Service.class);
        assertEquals("“It is not because things are difficult that we do not dare; it is because we do not dare that they are difficult.”", serv.getServiceText());
    }
}