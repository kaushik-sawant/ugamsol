package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.BannerArea;
import com.ugamsol.core.models.BlogArea;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BlogAreaImplTest {
    private final AemContext aemContext = new AemContext();
    private BlogArea blogarea;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Blogarea.json", "/content");
    }

    @Test
    void getImage() {
        Resource json = aemContext.currentResource("/content/blogarea");
        BlogArea blog = json.adaptTo(BlogArea.class);
        assertEquals("/content/dam/ugamsol/b1.jpg", blog.getImage());
    }

    @Test
    void getHeading1() {
        Resource json = aemContext.currentResource("/content/blogarea");
        BlogArea blog = json.adaptTo(BlogArea.class);
        assertEquals("Break Throgh Self Doubt and Fear", blog.getHeading1());
    }

    @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/blogarea");
        BlogArea blog = json.adaptTo(BlogArea.class);
        assertEquals("Dream interpretation has many forms; it can be done be done for the sake of fun, hobby or can be taken up as a serious career.", blog.getText());
    }
}