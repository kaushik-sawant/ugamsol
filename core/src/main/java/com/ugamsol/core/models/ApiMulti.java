package com.ugamsol.core.models;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ApiMulti {
    public List<Map<String,String>> getMemberList() throws JSONException, IOException;
    public String getUrl();
}
