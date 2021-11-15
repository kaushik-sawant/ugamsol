package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.BannerArea;
import com.ugamsol.core.models.Price;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class PriceImplTest {

    private final AemContext aemContext = new AemContext();
    Price price;

    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(PriceImpl.class);
        //aemContext.load().json(BannerAreaImpl.class.getResourceAsStream ("com/ugamsol/core/models/impl/Banner.json"),  "/component");
        aemContext.load().json("/Price.json", "/content");

    }

    @Test
    void getNumber() {
        Resource json = aemContext.currentResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("1", price.getNumber());

    }
    @Test
    void getHeading() {
        Resource json = aemContext.currentResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("Economy", price.getHeading());

    }

    @Test
    void getFeature1() {
        Resource json = aemContext.currentResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("For the individuals", price.getFeature1());

    }
    @Test
    void getFeature2() {
        Resource json = aemContext.currentResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("Secure Online Transfer", price.getFeature2());

    }
    @Test
    void getFeature3() {
        Resource json = aemContext.currentResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("Unlimited Styles for Interface", price.getFeature3());

    }
    @Test
    void getFeature4() {
        Resource json = aemContext.currentResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("Reliable Customer Service", price.getFeature4());

    }


}

