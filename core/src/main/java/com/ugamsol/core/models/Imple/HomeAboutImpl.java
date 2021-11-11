package com.ugamsol.core.models.Imple;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.ugamsol.core.models.HomeAbout;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = HomeAbout.class,
        resourceType = HomeAboutImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

@Exporter(name="jackson", extensions = "json", selector = "mydemo",
options = {
        @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value ="true")
}
)
@JsonRootName("NEW ROOT NAME")
public class HomeAboutImpl implements HomeAbout {


    public static final String RESOURCE_TYPE = "ugamsol/components/content/homeabout";
    @Inject
    String title;
    @Inject
    String title2;
    @Inject
    String text;
    @Inject
    String image;
    @Inject
    String buttontext;
    @Inject
    String path;

    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getTitle2() {
        return title2;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    @JsonIgnore
    public String getImage() {
        return image;
    }

    @Override
    @JsonProperty(value = "TEXT INSIDE BUTTON")
    public String getButtonText() {
        return buttontext;
    }

    @Override
    public String getPath() {
        return path;
    }
}
