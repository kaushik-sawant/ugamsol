package com.ugamsol.core.models;
import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;
@Configuration(label="",description = "")
public @interface Contextawareconfig {

    @Property(label = "siteCountry",
            description = "Site Name")
    String siteCountry() default "us";
    @Property(label = "siteLocale",
            description = "Site Lang")
    String siteLocale() default "en";

}
