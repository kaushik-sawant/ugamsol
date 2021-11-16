package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.TimeLine;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class TimeLineImplTest {
    private final AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);
    private TimeLine timeline;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Timeline.json", "/content");
    }

    @Test
    void getTimeLineDetails() {
        Resource json = aemContext.currentResource("/content/timeline");
        TimeLine timeline = json.adaptTo(TimeLine.class);
        assertNotNull(timeline.getTimeLineDetails());
    }
}

