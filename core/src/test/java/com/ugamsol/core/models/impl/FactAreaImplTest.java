package com.ugamsol.core.models.impl;


import com.ugamsol.core.models.FactArea;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class FactAreaImplTest {
    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/factarea.json", "/content");
    }

    @Test
    void getFactAreaDetails() {
        Resource resource = aemContext.currentResource("/content");
        //FactArea factArea = resource.adaptTo(FactArea.class);
        FactArea factArea = aemContext.request().adaptTo(FactArea.class);
        assertEquals("2536", factArea.getFactAreaDetails().get(0).get("value"));
        assertEquals("Projects Completed", factArea.getFactAreaDetails().get(0).get("text"));

    }
}