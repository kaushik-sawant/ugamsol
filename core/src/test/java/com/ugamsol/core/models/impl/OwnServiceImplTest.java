package com.ugamsol.core.models.impl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
class OwnServiceImplTest {
    private final AemContext aemContext = new AemContext();
    OwnServiceImpl configTest;
    private String serviceName;
    private int serviceCount;
    private boolean liveData;
    private String runModes;

    @BeforeEach
    void setUp() {
        configTest = aemContext.registerService(new OwnServiceImpl());
        OwnServiceImpl.ServiceConfig config = mock(OwnServiceImpl.ServiceConfig.class);
        when(config.serviceName()).thenReturn("qwerty");
        when(config.getServiceCount()).thenReturn(3);
        when(config.getLiveData()).thenReturn(true);
        when(config.getRunMode()).thenReturn("publish");
        configTest.activate(config);
    }

    @Test
    void activate() {

    }

    @Test
    void getServiceName() {
        assertEquals("qwerty",configTest.getServiceName());
    }

    @Test
    void getServiceCount() {
        assertEquals(3,configTest.getServiceCount());
    }

    @Test
    void isLiveData() {
        assertEquals(true,configTest.isLiveData());
    }

    @Test
    void getRunModes() {
        assertEquals("publish",configTest.getRunModes());
    }
}