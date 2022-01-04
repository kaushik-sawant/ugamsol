package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.BannerArea;
import com.ugamsol.core.models.TitleText;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class TitleTextImplTest {
    private final AemContext aemContext = new AemContext();
    private TitleTextImpl title;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Title.json", "/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/title");
        TitleText titletext = json.adaptTo(TitleText.class);
        assertEquals("My offered services", titletext.getTitle());
    }

    @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/title");
        TitleText titletext = json.adaptTo(TitleText.class);
        assertEquals("At about this time of year, some months after New Year’s resolutions have been made and kept, or made and neglected.", titletext.getText());
    }


    @Test
    void getPaddingBottom() {
        Resource json = aemContext.currentResource("/content/title");
        TitleText titletext = json.adaptTo(TitleText.class);
        assertEquals(false, titletext.getPaddingBottom());

    }

    @Test
    void getSectionGap() {
        Resource json = aemContext.currentResource("/content/title");
        TitleText titletext = json.adaptTo(TitleText.class);
        assertEquals(true, titletext.getSectionGap());
    }

    /*@Test
    void getColor() {

    }*/
}
