package com.ugamsol.core.servlets;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(AemContextExtension.class)
class calculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() throws Exception{

    }

    @Test
    void doGet(AemContext aemContext) throws IOException {
        MockSlingHttpServletRequest request = aemContext.request();
        MockSlingHttpServletResponse response = aemContext.response();
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("firstNumber", 45);
        parameterMap.put("secondNumber", 40);
        request.setParameterMap(parameterMap);
        calculator.doGet(request, response);
        assertEquals(85,Integer.parseInt(response.getOutputAsString()));
    }
}