package com.ugamsol.core.models.impl;

import com.ugamsol.core.models.ApiUser;
import com.ugamsol.core.models.OsgiApiUserList;
import com.ugamsol.core.utils.Network;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class,
        adapters = ApiUser.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ApiUserImpl implements ApiUser {
    final Logger LOG = LoggerFactory.getLogger(ApiUserImpl.class);

    @Inject
    String url;
    private String message;
    private String email;
    private String firstname;
    private String lastname;
    private String image;

    @OSGiService
    OsgiApiUserList osgiApiUserList;

    @Override
    public String getUrl() {
        return osgiApiUserList.getSingleUser()+url;

    }

    @Override
    public String getMessage() throws JSONException {

        String response = Network.readJson(osgiApiUserList.getSingleUser()+url);
        JSONObject jsonObject =  new JSONObject(response);
        Iterator x = jsonObject.keys();
        JSONArray jsonArray = new JSONArray();
        while (x.hasNext()){
            String key = (String) x.next();
            jsonArray.put(jsonObject.get(key));
        }
        email = jsonArray.getJSONObject(0).getString("email");
        firstname = jsonArray.getJSONObject(0).getString("first_name");
        lastname = jsonArray.getJSONObject(0).getString("last_name");
        image = jsonArray.getJSONObject(0).getString("avatar");
        return response;

    }

    public String getFirstName(){
        return firstname;
    }

    @Override
    public String getLastName() {
        return lastname;
    }

    @Override
    public String getImage() {
        //String myIcon = image.replaceAll("https://reqres.in/img/faces/","/content/dam/ugamsol/");
        //LOG.info(myIcon);
        //return myIcon;

        String original = image;
        String reqres = "https://reqres.in/img/faces/";
        String dam = "/content/dam/ugamsol/";

        for(;;) {
            int i = original.indexOf(reqres);
            LOG.info("\n"+i);
            if (i == -1) {
                break;
            }
            original = original.substring(0, i) + dam + original.substring(i + reqres.length());
            LOG.info("original" + original);
        }
        LOG.info("\n" + original);
        return original;
       /* String org= image;
        String [] temp=org.split("");
        int len=temp.length;
        String ne = "";
        for(int i=0;i<len;i++)
        {
            if(temp[i].matches("https://reqres.in/img/faces/"))
                temp[i]="/content/dam/ugamsol/";
            ne=ne+temp[i];

        }
        LOG.info(ne);
        System.out.println(ne);
        return ne;*/
    }

    @Override
    public String getEmail() {
        return email;
    }


}
