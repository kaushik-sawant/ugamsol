package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.PortfolioArea;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = PortfolioArea.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PortfolioAreaImpl implements PortfolioArea {

    @Inject
    String image;
    @Inject
    String heading1;
    @Inject
    String heading2;
    @Inject
    String hoverimage;

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getHeading1() {
        return heading1;
    }
    @Override
    public String getHeading2() {
        return heading2;
    }
    @Override
    public String getHoverImage(){return hoverimage;}
}
