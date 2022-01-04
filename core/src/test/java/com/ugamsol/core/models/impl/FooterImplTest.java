package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.BannerArea;
import com.ugamsol.core.models.Footer;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class FooterImplTest {
    private final AemContext aemContext = new AemContext();
    private Footer footer;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Footer.json", "/content");
    }
    @Test
    void getTitle1() {
        Resource json = aemContext.currentResource("/content/footer");
        Footer foo = json.adaptTo(Footer.class);
        assertEquals("About Me", foo.getTitle1());
    }

    @Test
    void getTitle2() {
        Resource json = aemContext.currentResource("/content/footer");
        Footer foo = json.adaptTo(Footer.class);
        assertEquals("News Letter", foo.getTitle2());

    }

    @Test
    void getTitle3() {
        Resource json = aemContext.currentResource("/content/footer");
        Footer foo = json.adaptTo(Footer.class);
        assertEquals("Follow me", foo.getTitle3());
    }

    @Test
    void getText1() {
        Resource json = aemContext.currentResource("/content/footer");
        Footer foo = json.adaptTo(Footer.class);
        assertEquals("We have tested a number of registry fix and clean utilities and present our top 3 list on our side", foo.getText1());
    }

    @Test
    void getText2() {
        Resource json = aemContext.currentResource("/content/footer");
        Footer foo = json.adaptTo(Footer.class);
        assertEquals("Stay Updated with our latest trends", foo.getText2());
    }

    @Test
    void getText3() {
        Resource json = aemContext.currentResource("/content/footer");
        Footer foo = json.adaptTo(Footer.class);
        assertEquals("lets be social", foo.getText3());
    }


}