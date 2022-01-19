package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.ApiMulti;
import com.ugamsol.core.utils.Network;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,
        adapters = ApiMulti.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ApiMultiImpl implements ApiMulti {

    @Inject
    String pageNo;

    @Override
    public List<Map<String, String>> getMemberList() throws JSONException, IOException {

        String response = Network.readJson(getUrl());
        JSONObject jsonObject =  new JSONObject(response);

        JSONArray jsondataarray = jsonObject.getJSONArray("data");

        List<Map<String, String>> multiList = new ArrayList<>();
        for (int i=0;i<jsondataarray.length();i++){
            Map<String,String> listmembers =new HashMap<>();
            listmembers.put("firstname",jsondataarray.getJSONObject(i).getString("first_name"));
            listmembers.put("lastname",jsondataarray.getJSONObject(i).getString("last_name"));
            listmembers.put("email",jsondataarray.getJSONObject(i).getString("email"));
            listmembers.put("image",jsondataarray.getJSONObject(i).getString("avatar"));
            multiList.add(listmembers);
        }

        return multiList;
    }


    @Override
    public String getUrl() {
        return "https://reqres.in/api/users?page="+pageNo;
    }
}
