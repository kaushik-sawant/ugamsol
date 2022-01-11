package com.ugamsol.core.models;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(
        name = "my scheduler",
        description = "sling scheduler"

)
public @interface SchedulerConf {

    @AttributeDefinition(
            name = "Name",
            description = "add here",
            type = AttributeType.STRING
    )

    public String schedulerName() default "custom scheduler";

    @AttributeDefinition(
            name = "Cron",
            description = "scheduler cron expression",
            type = AttributeType.STRING)
    public String cronExpression() default "0/20 * * * * ?";

    // 0/20 * * * * ?

}