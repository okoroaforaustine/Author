/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.decagon.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author austine.okoroafor
 */
public class HttpUtil {

    private final String USER_AGENT = "Mozilla/5.0";

    public List<String> sendGet(String url) {
        List<String> data = new ArrayList();
        System.out.println("url" + url);

        String urlCall = url;

        try {
            URL obj = new URL(urlCall);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            con.setUseCaches(false);
            int responseCode = con.getResponseCode();
            System.out.println("nSending 'GET' request to URL : " + urlCall);
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("respnse "+response);

            data.add(response.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public String getHighestCount(String url) {
        String newResponse = null;

        String urlCall = url;

        try {
            URL obj = new URL(urlCall);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            con.setUseCaches(false);
            int responseCode = con.getResponseCode();
            System.out.println("nSending 'GET' request to URL : " + urlCall);
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            newResponse = response.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return newResponse;
    }

}
