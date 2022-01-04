package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.BannerArea;
import com.ugamsol.core.models.PortfolioArea;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class PortfolioAreaImplTest {
    private final AemContext aemContext = new AemContext();
    private PortfolioArea portfolioArea;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Portfolioarea.json", "/content");
    }

    @Test
    void getImage() {
        Resource json = aemContext.currentResource("/content/portfolioarea");
        PortfolioArea portfolioArea = json.adaptTo(PortfolioArea.class);
        assertEquals("/content/dam/ugamsol/p2.jpg", portfolioArea.getImage());
    }

    @Test
    void getHeading1() {
        Resource json = aemContext.currentResource("/content/portfolioarea");
        PortfolioArea portfolioArea = json.adaptTo(PortfolioArea.class);
        assertEquals("2D Vinyl Design", portfolioArea.getHeading1());
    }

    @Test
    void getHeading2() {
        Resource json = aemContext.currentResource("/content/portfolioarea");
        PortfolioArea portfolioArea = json.adaptTo(PortfolioArea.class);
        assertEquals("vector", portfolioArea.getHeading2());
    }

    @Test
    void getHoverImage() {
        Resource json = aemContext.currentResource("/content/portfolioarea");
        PortfolioArea portfolioArea = json.adaptTo(PortfolioArea.class);
        assertEquals("/content/dam/ugamsol/preview.png", portfolioArea.getHoverImage());
    }
}