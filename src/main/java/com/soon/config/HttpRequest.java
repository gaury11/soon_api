package com.soon.config;

import org.json.simple.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {


    // HttpUrlConnection 사용
    public JSONObject sendPost(String targetUrl, String jsonParam){
        URL url = null;
        HttpURLConnection conn = null;
        JSONObject response = null;

        OutputStream os = null;
        BufferedReader br = null;

        //StringBuffer response
        try{
            // HTTP 접속
            url = new URL(targetUrl);
            conn = (HttpURLConnection)url.openConnection();

            // 메소드 설정
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setConnectTimeout(5000);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            os = conn.getOutputStream();
            os.write(jsonParam.getBytes("UTF-8"));
            os.flush();

            int responseCode = conn.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));


            }

            // response
            //is = new BufferedInputStream(conn.getInputStream());
            //String result =


        }catch(IOException e){
            e.printStackTrace();
        }finally{

            conn.disconnect();
        }
        return response;
    }
}
