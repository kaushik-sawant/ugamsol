package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.OwnService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.*;

@Component(service = OwnService.class, immediate = true)
@Designate(ocd = OwnServiceImpl.ServiceConfig.class)

public class OwnServiceImpl implements OwnService{

    @ObjectClassDefinition(name = "Own OSGI - OSGI CONFIGURATION",
                        description = "own osgi config.")

    public @interface ServiceConfig{
        @AttributeDefinition(
                name="Name",
                description = "Enter Name",
                type = AttributeType.STRING)
        public String serviceName() default "add name here";

        @AttributeDefinition(
                name="Count",
                description = "COunt",
                type = AttributeType.INTEGER)
        int getServiceCount() default 10;

        @AttributeDefinition(
                name = "Check Mark",
                description = "Add tick mark.",
                type = AttributeType.BOOLEAN)
        boolean getLiveData() default false;

        @AttributeDefinition(
                name = "Instance",
                description = "Select Instance",
                options = {
                        @Option(label = "Author",value = "author"),
                        @Option(label = "Publish",value = "publish"),
                        @Option(label = "Both",value = "both")
                },
                type = AttributeType.STRING)
        String getRunMode() default "both";

    }
    private String serviceName;
    private int serviceCount;
    private boolean liveData;
    private String runModes;

    @Activate
    protected void activate(ServiceConfig serviceConfig){
        serviceName=serviceConfig.serviceName();
        serviceCount=serviceConfig.getServiceCount();
        liveData=serviceConfig.getLiveData();
        runModes=serviceConfig.getRunMode();
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public int getServiceCount() {
        return serviceCount;
    }

    @Override
    public boolean isLiveData() {
        return liveData;
    }

    @Override
    public String getRunModes() {
        return runModes;
    }

}
