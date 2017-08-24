package com.example.demo.demoone;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomasliao on 2017/6/21.
 */
public class Test {

    public static void testPostMain(){
        String ptime = ParameterUtil.getCurrentTime();
        String secretkey = ParameterUtil.getSecretKey();
        String vids ="2d939377c23a37d2b0a2428006755627_2,2d939377c23ebcfe8b4ff3dadcabfbbf_2";
        String str = "ptime=" + ptime + "&vids="+vids + secretkey;
        String sign = ParameterUtil.getUpperCaseSha1(str);
        String url="http://api.polyv.net/v2/video/"+ ParameterUtil.getUserId()+"/info";
        System.out.println(testPost(url,sign,ptime,vids));

    }

    private static String testPost(String url,String sign,String ptime,String vids) {

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        try {

            List<BasicNameValuePair> formparams = new ArrayList<>();
            //设置参数
            formparams.add(new BasicNameValuePair("sign", sign));
            formparams.add(new BasicNameValuePair("ptime", ptime));
            formparams.add(new BasicNameValuePair("vids", vids));

            post.setEntity(new UrlEncodedFormEntity(formparams));

            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "adfadsf";
    }
}
