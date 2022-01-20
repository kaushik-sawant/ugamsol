package com.ugamsol.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public final class Network {
    private static final Logger LOG = LoggerFactory.getLogger(Network.class);
    private static HttpURLConnection conn;
    public static String readJson(String url) {


        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();
        try{
            LOG.info("inside try of new");
            URL jsonlink = new URL(url);
            conn = (HttpURLConnection) jsonlink.openConnection();

            // Request setup
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            // Test if the response from the server is successful
            int status = conn.getResponseCode();

            if (status >= 300) {
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                LOG.info(line);
                reader.close();
            }
            else {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                LOG.info("above line");
                LOG.info(line);
                reader.close();
            }
            LOG.info("response code: " + status);
            LOG.info(responseContent.toString());

            return responseContent.toString();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            conn.disconnect();
        }


        return "";

    }

}
