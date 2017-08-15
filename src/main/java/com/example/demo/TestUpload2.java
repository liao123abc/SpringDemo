package com.example.demo;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


/**
 * Created by thomasliao on 2017/6/21.
 */
public class TestUpload2 {

    public static void upload() throws Exception{

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost("http://api.polyv.net/v2/video/" + ParameterUtil.getUserId() + "/uploadPPT");

            ContentType contentType = ContentType.create("text/plain", Charset.forName("UTF-8"));

            File textFile = new File("/Volumes/hdd/test/txt");
            File pptFile = new File("/Volumes/hdd/test/ppt");
            FileBody textFileData = new FileBody(textFile);
            FileBody pptFileData = new FileBody(pptFile);

//            StringBody jsonrpc = new StringBody(json, contentType);
//            StringBody _writetoken = new StringBody(this.writetoken, ContentType.TEXT_PLAIN);
//            StringBody _cataid = new StringBody(cataid+"", ContentType.TEXT_PLAIN);
//            StringBody _hash = new StringBody(hash, ContentType.TEXT_PLAIN);

            String vidStr = ParameterUtil.getCurrentTime() + "_1";
            String ptimeStr = ParameterUtil.getCurrentTime();

            String signStr = "ptime=" + ptimeStr + "&vid="+ vidStr + ParameterUtil.getSecretKey();
            String shaSign = ParameterUtil.getUpperCaseSha1(signStr);

            StringBody vid = new StringBody(vidStr, ContentType.TEXT_PLAIN);//每次测试给新的id
            StringBody sign = new StringBody(shaSign, ContentType.TEXT_PLAIN);
            StringBody ptime = new StringBody(ptimeStr, ContentType.TEXT_PLAIN);

            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("ppt", pptFileData)
                    .addPart("txt", textFileData)
                    .addPart("vid", vid)
                    .addPart("sign", sign)
                    .addPart("ptime", ptime)
                    .build();

            httppost.setEntity(reqEntity);

            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    System.out.println(line);
                }
                HttpEntity resEntity = response.getEntity();
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
