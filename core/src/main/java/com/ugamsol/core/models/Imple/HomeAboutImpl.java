package com.ugamsol.core.models.Imple;

import com.ugamsol.core.models.HomeAbout;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = HomeAbout.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HomeAboutImpl implements HomeAbout {


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
    public String getImage() {
        return image;
    }

    @Override
    public String getButtonText() {
        return buttontext;
    }

    @Override
    public String getPath() {
        return path;
    }
}
