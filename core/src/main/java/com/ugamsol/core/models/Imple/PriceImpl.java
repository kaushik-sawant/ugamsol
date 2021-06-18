package com.ugamsol.core.models.Imple;

import com.ugamsol.core.models.Price;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Price.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PriceImpl implements Price {
    @Inject
    String number;
    @Inject
    String heading;
    @Inject
    String feature1;
    @Inject
    String feature2;
    @Inject
    String feature3;
    @Inject
    String feature4;
    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getHeading() {
        return heading;
    }

    @Override
    public String getFeature1() {
        return feature1;
    }

    @Override
    public String getFeature2() {
        return feature2;
    }

    @Override
    public String getFeature3() {
        return feature3;
    }

    @Override
    public String getFeature4() {
        return feature4;
    }
}
