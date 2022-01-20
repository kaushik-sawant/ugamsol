package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.OsgiApiUserList;
import com.ugamsol.core.models.OwnService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = OsgiApiUserList.class, immediate = true)
@Designate(ocd = OsgiApiUserListImpl.ApiConfig.class)

public class OsgiApiUserListImpl implements OsgiApiUserList {

    @ObjectClassDefinition(name = "API OSGI - OSGI CONFIGURATION",
            description = "API osgi config.")

    public @interface ApiConfig {
        @AttributeDefinition(
                name = "API SINGLE USER LINK",
                description = "API LINK SINGLE",
                type = AttributeType.STRING)
        public String singleuserurl() default "https://reqres.in/api/users/";

        @AttributeDefinition(
                name = "API MULTI USER LINK",
                description = "API LINK MULTI",
                type = AttributeType.STRING)
        public String multiuserurl() default "https://reqres.in/api/users?page=";


    }

    private String singleuser;
    private String multiuser;

    @Activate
    protected void activate(ApiConfig apiConfig) {
        singleuser = apiConfig.singleuserurl();
        multiuser = apiConfig.multiuserurl();
    }

        @Override
        public String getSingleUser(){
            return singleuser;
        }

        @Override
        public String getMultiUser(){
            return multiuser;
        }
    }
