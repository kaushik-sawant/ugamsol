package com.ugamsol.core.models.Imple;

import com.ugamsol.core.models.TitleText;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = TitleText.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TitleTextImpl implements TitleText {
    @Inject
    String title;
    @Inject
    String text;
    @Inject
    Boolean paddingbottom;
    @Inject
    Boolean sectiongap;
    @Inject
    Boolean color;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Boolean getPaddingBottom() {
        return paddingbottom;
    }

    @Override
    public Boolean getSectionGap() {
        return sectiongap;
    }

    @Override
    public Boolean getColor() {
        return color;
    }


}
