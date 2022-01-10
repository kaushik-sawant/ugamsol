package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.BannerArea;
import com.ugamsol.core.models.HomeAbout;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class HomeAboutImplTest {
    private final AemContext aemContext = new AemContext();
    private HomeAbout homeabout;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Homeabout.json", "/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/homeabout");
        HomeAbout homeabout = json.adaptTo(HomeAbout.class);
        assertEquals("About asdqwerty", homeabout.getTitle());
    }

    @Test
    void getTitle2() {
        Resource json = aemContext.currentResource("/content/homeabout");
        HomeAbout homeabout = json.adaptTo(HomeAbout.class);
        assertEquals("Personal Details", homeabout.getTitle2());

    }

    @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/homeabout");
        HomeAbout homeabout = json.adaptTo(HomeAbout.class);
        assertEquals("Here, I focus on a range of items and features that we use in life without giving them a second thought. such as Coca Cola. Dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.",
                homeabout.getText());
    }

    @Test
    void getImage() {
        Resource json = aemContext.currentResource("/content/homeabout");
        HomeAbout homeabout = json.adaptTo(HomeAbout.class);
        assertEquals("/content/dam/ugamsol/about-img.png", homeabout.getImage());
    }

    @Test
    void getButtonText() {
        Resource json = aemContext.currentResource("/content/homeabout");
        HomeAbout homeabout = json.adaptTo(HomeAbout.class);
        assertEquals("View Full Details", homeabout.getButtonText());
    }

    @Test
    void getPath() {
        Resource json = aemContext.currentResource("/content/homeabout");
        HomeAbout homeabout = json.adaptTo(HomeAbout.class);
        assertEquals("/content/ugamsol/us/en/portfolio", homeabout.getPath());
    }
}