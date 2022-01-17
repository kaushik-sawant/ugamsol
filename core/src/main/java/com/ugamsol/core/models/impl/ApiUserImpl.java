package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.ApiUser;
import com.ugamsol.core.utils.Network;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = ApiUser.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ApiUserImpl implements ApiUser {
    final Logger LOG = LoggerFactory.getLogger(ApiUserImpl.class);

    @Inject
    String url;
    private String message;

    @Override
    public String getUrl() {
        return "https://reqres.in/api/users/"+url;

    }

    @Override
    public String getMessage(){

        String response = Network.readJson("https://reqres.in/api/users/"+url);
        return response;

    }
}
