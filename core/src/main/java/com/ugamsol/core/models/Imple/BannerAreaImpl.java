package com.ugamsol.core.models.Imple;

import com.ugamsol.core.models.BannerArea;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = BannerArea.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class BannerAreaImpl implements BannerArea {

    @Inject
    String name;
    @Inject
    String link1;
    @Inject
    String link2;
    @Inject
    String path;
    @Override
    public String getBannerName() {
        return name;
    }

    @Override
    public String getBannerLink1() {
        return link1;
    }

    @Override
    public String getBannerLink2() {
        return link2;
    }

    @Override
    public String getPath() {
        return path;
    }
}
