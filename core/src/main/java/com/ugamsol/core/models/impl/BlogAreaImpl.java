package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.BlogArea;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = BlogArea.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BlogAreaImpl implements BlogArea {
    @Inject
    String image;
    @Inject
    String heading1;
    @Inject
    String text;


    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getHeading1() {
        return heading1;
    }

    @Override
    public String getText() {
        return text;
    }
}
