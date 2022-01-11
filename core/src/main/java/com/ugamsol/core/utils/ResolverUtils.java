package com.ugamsol.core.utils;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.LoginException;
import java.util.HashMap;
import java.util.Map;

public class ResolverUtils {
    private ResolverUtils() {

    }

    public static final String TEST_USER = "testuser";

    public static ResourceResolver newResolver(ResourceResolverFactory resourceResolverFactory) throws LoginException{
        final Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(ResourceResolverFactory.SUBSERVICE, TEST_USER);
        return resourceResolverFactory.getServiceResourceResolver(paramMap);

    }
}