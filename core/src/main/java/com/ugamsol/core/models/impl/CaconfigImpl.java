package com.ugamsol.core.models.impl;
import com.day.cq.wcm.api.Page;

import com.ugamsol.core.models.Caconfig;
import com.ugamsol.core.models.Contextawareconfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.caconfig.ConfigurationResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.*;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
@Model(adaptables = SlingHttpServletRequest.class,
        adapters = Caconfig.class,
        resourceType = {CaconfigImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)


public class CaconfigImpl implements Caconfig {

    protected static final String RESOURCE_TYPE = "";
    @SlingObject
    ResourceResolver resourceResolver;
    @ScriptVariable
    Page currentPage;
    @OSGiService
    ConfigurationResolver configurationResolver;
    private String siteCountry;
    private String siteLocale;

    @Override
    public String getSiteCountry() {
        return siteCountry;
    }

    @Override
    public String getSiteLocale() {
        return siteLocale;
    }


    @PostConstruct
    public void postConstruct() {
        Contextawareconfig caConfig = getContextAwareConfig(currentPage.getPath(), resourceResolver);
        siteCountry = caConfig.siteCountry();
        siteLocale = caConfig.siteLocale();
    }

    public Contextawareconfig getContextAwareConfig(String currentPage, ResourceResolver resourceResolver) {
        String currentPath = StringUtils.isNoneBlank(currentPage) ? currentPage : StringUtils.EMPTY;
        Resource contentResource = resourceResolver.getResource(currentPath);
        if (contentResource != null) {
            ConfigurationBuilder configurationBuilder = contentResource.adaptTo(ConfigurationBuilder.class);
            if (configurationBuilder != null) {
                return configurationBuilder.as(Contextawareconfig.class);
            }
        }

        return null;
    }
}