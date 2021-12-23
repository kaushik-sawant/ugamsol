package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.AddProperty;
import com.ugamsol.core.models.SchedulerConf;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, service = Runnable.class)
@Designate(ocd = SchedulerConf.class)
public class SchedulerImpl implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(SchedulerImpl.class);
    private int schedulerId;
    String path = "/content/ugamsol/us/en/home-page/jcr:content/root/responsivegrid_786455242/displaydate";
    @Reference
    private Scheduler schedulerConf;

    @Reference
    private AddProperty addProperty;

    @OSGiService
    ResourceResolverFactory resourceResolverFactory;

    @Activate
    protected void activate(SchedulerConf config){
        schedulerId = config.schedulerName().hashCode();
        addScheduler(config);
    }

    @Deactivate
    protected void deactivate (SchedulerConf config){
        removeScheduler();
    }

    private void removeScheduler(){
        schedulerConf.unschedule(String.valueOf(schedulerId));
    }

    private void addScheduler(SchedulerConf config) {
        ScheduleOptions scheduleOptions = schedulerConf.EXPR(config.cronExpression());
        scheduleOptions.name(String.valueOf(schedulerId));
        scheduleOptions.canRunConcurrently(false);
        schedulerConf.schedule(this, scheduleOptions);
        LOG.info("\n---scheduleradded");
    }
    public void run() {
        LOG.info("\n run method executing");
        addProperty.doAWriteOperation(path);
    }
}

