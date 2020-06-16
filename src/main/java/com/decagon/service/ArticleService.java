/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.decagon.service;

import com.decagon.util.HttpUtil;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author austine.okoroafor
 */
public class ArticleService {

    public static List<String> getUsernames(int threshold) {
        HttpUtil util = new HttpUtil();
        String url = "https://jsonmock.hackerrank.com/api/article_users/search?page=" + threshold;

        List<String> response = util.sendGet(url);

        return response;

    }

    public static String getUsernameWithHighestCommentCount() {
        HttpUtil util = new HttpUtil();
        String url = "https://jsonmock.hackerrank.com/api/article_users";
        String highestUsername = "";
      HashMap<String, Integer> map=new HashMap();
        String response = util.getHighestCount(url);
        JSONObject object = new JSONObject(response);
        JSONArray jsonArray = object.getJSONArray("data");
        int max = 0;
        for (int i = 0; i < jsonArray.length(); i++) {
            

            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            int comment_count = jsonObject1.getInt("comment_count");
            String username = jsonObject1.get("username").toString();
              map.put(username, comment_count);
            
               max = Math.max(max, comment_count);
               
             
                
           

        }
         
         for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue()==max) {
                highestUsername=entry.getKey();
            }
        }
         
         
       
        

        return highestUsername;
    }

    public static List<String> getUsernamesSortedByRecordDate(int threshold) {
        HttpUtil util = new HttpUtil();
        List<String> data = new ArrayList();
        String url = "https://jsonmock.hackerrank.com/api/article_users/search?page/"+threshold;
        String response = util.getHighestCount(url);
        HashMap hmap = new HashMap();
        JSONObject object = new JSONObject(response);
        JSONArray jsonArray = object.getJSONArray("data");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            int created_date = jsonObject1.getInt("created_at");
            String username = jsonObject1.get("username").toString();
            hmap.put(created_date, username);
        }
        Map<Integer, String> map = new TreeMap<Integer, String>(hmap);
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator2.next();

            data.add(me2.getValue().toString());
        }
        return data;
    }

}
