package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.OwnService;
import com.ugamsol.core.models.OwnServiceModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = OwnServiceModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)


public class OwnServiceModelImpl implements OwnServiceModel{
    @OSGiService
    OwnService ownService;


    @Override
    public String getServiceName() {
        return ownService.getServiceName();
    }

    @Override
    public int getServiceCount() {
        return ownService.getServiceCount();
    }

    @Override
    public boolean isLiveData() {
        return ownService.isLiveData();
    }

    @Override
    public String getRunModes() {
        return ownService.getRunModes();
    }
}
