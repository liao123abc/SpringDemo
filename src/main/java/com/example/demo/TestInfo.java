package com.example.demo;

import com.example.demo.model.InfoPa;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thomasliao on 2017/6/21.
 */
public class TestInfo {

    private static final String url = "http://api.polyv.net/v2/video/{userid}/info";

    public static String testInfo() {

        String ptime = ParameterUtil.getCurrentTime();
        String vids="2d939377c23a37d2b0a2428006755627_2,2d939377c23ebcfe8b4ff3dadcabfbbf_2";
        String sign = "ptime=" + ptime + "&vids="+vids + "3OmoLbTlHu";
        String shaSign = ParameterUtil.getUpperCaseSha1(sign);

        Map<String, String> params = new HashMap<String, String>();
        params.put("userid", "2d939377c2");

        InfoPa info = new InfoPa();
        info.setSign(shaSign);
        info.setPtime(ptime);
        info.setVids(vids);

        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
        String result = restTemplate.postForObject(url, info, String.class, params);

        System.out.println(result);
        return result;
    }

    public static String testInfo2() {
        String ptime = ParameterUtil.getCurrentTime();
        String vids="2d939377c23a37d2b0a2428006755627_2,2d939377c23ebcfe8b4ff3dadcabfbbf_2";
        String sign = "ptime=" + ptime + "&vids="+vids + "GQ8iHtcbkV";
        String shaSign = ParameterUtil.getUpperCaseSha1(sign);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("sign", shaSign);
        map.add("ptime", ptime);
        map.add("vids", vids);

        Map<String, String> params = new HashMap<String, String>();
        params.put("userid", "e4e92c8c43");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        restTemplate.getMessageConverters().add(jsonHttpMessageConverter);

        ResponseEntity<String> response = restTemplate.postForEntity( url, request, String.class, params);
        System.out.println(response);
        return response.toString();
    }

}
