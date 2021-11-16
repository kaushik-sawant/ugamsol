package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.BannerArea;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class BannerAreaImplTest {

    private final AemContext aemContext = new AemContext();
    private BannerArea banner;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Banner.json", "/content");
    }

    @Test
    void getBannerName() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea bannerarea = json.adaptTo(BannerArea.class);
        assertEquals("About Me", bannerarea.getBannerName());
    }

    @Test
    void getPath() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea bannerarea = json.adaptTo(BannerArea.class);
        assertEquals("/content/ugamsol/us/en/home-page", bannerarea.getPath());
    }

    @Test
    void getBannerLink1() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea bannerarea = json.adaptTo(BannerArea.class);
        assertEquals("Home", bannerarea.getBannerLink1());
    }

    @Test
    void getBannerLink2() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea bannerarea = json.adaptTo(BannerArea.class);
        assertEquals("About Me", bannerarea.getBannerLink2());
    }


}