package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.MainBannerArea;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class MainBannerAreaImplTest {
    private final AemContext aemContext = new AemContext();
    private MainBannerArea mainBannerArea;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Mainbannerarea.json", "/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/mainbannerarea");
        MainBannerArea mainbannerarea = json.adaptTo(MainBannerArea.class);
        assertEquals("THIS IS ME", mainbannerarea.getTitle());
    }

    @Test
    void getTitle2() {
        Resource json = aemContext.currentResource("/content/mainbannerarea");
        MainBannerArea mainbannerarea = json.adaptTo(MainBannerArea.class);
        assertEquals("PHILIP GILBERT", mainbannerarea.getTitle2());
    }

    @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/mainbannerarea");
        MainBannerArea mainbannerarea = json.adaptTo(MainBannerArea.class);
        assertEquals("You will begin to realise why this exercise is called the Dickens Pattern with reference to the ghost showing Scrooge some different futures.", mainbannerarea.getText());
    }

    @Test
    void getImage() {
        Resource json = aemContext.currentResource("/content/mainbannerarea");
        MainBannerArea mainbannerarea = json.adaptTo(MainBannerArea.class);
        assertEquals("/content/dam/ugamsol/hero-img.png", mainbannerarea.getImage());
    }

    @Test
    void getButtonText() {
        Resource json = aemContext.currentResource("/content/mainbannerarea");
        MainBannerArea mainbannerarea = json.adaptTo(MainBannerArea.class);
        assertEquals("DISCOVER NOW", mainbannerarea.getButtonText());
    }

    @Test
    void getPath() {
        Resource json = aemContext.currentResource("/content/mainbannerarea");
        MainBannerArea mainbannerarea = json.adaptTo(MainBannerArea.class);
        assertEquals("/content/ugamsol/us/en/home-page", mainbannerarea.getPath());
    }
}