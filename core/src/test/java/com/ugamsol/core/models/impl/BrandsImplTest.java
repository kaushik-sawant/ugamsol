package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.Brands;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BrandsImplTest {
    private final AemContext aemContext = new AemContext();
    private Brands brands;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Brands.json", "/content");
    }

    @Test
    void getImgPath() {
        Resource json = aemContext.currentResource("/content/brands");
        Brands brand = json.adaptTo(Brands.class);
        assertNotNull(brand.getImgPath());
    }

    @Test
    void getNoBrands(){
        Resource json = aemContext.currentResource("/content/nobrands");
        Brands brand = json.adaptTo(Brands.class);
        assertEquals(0, brand.getImgPath().size());
    }
}