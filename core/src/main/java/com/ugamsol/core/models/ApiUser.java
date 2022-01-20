package com.ugamsol.core.models;

import org.json.JSONException;

public interface ApiUser {
   public String getMessage() throws JSONException;
   public String getUrl();
   public String getFirstName();
   public String getLastName();
   public String getImage();
   public String getEmail();
}
