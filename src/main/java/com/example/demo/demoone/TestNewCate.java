package com.example.demo.demoone;

import com.example.demo.model.NewCategory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by thomasliao on 2017/6/21.
 */
public class TestNewCate {
    private static final String url = "http://api.polyv.net/v2/video/{userid}/addCata";

    public static void testNewCategory() {

        NewCategory newCategory = new NewCategory();
        newCategory.setCataname("新增测试");
        newCategory.setParentid("1");
        long now = System.currentTimeMillis();//已经是13位
        newCategory.setPtime(now + "");
        String sign = "cataname=" + newCategory.getCataname() +
                "&parentid=1&ptime=" + newCategory.getPtime() + "GQ8iHtcbkV";
        String shaSign = ParameterUtil.getUpperCaseSha1(sign);
        newCategory.setSign(shaSign);
        System.out.println(newCategory);

        RestTemplate restTemplate = new RestTemplate();

        /**
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         */
        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> params = new HashMap<String, String>();
        params.put("userid", "e4e92c8c43");

        //NewCategory类转JSON
        String json = null;
        try {
            json = mapper.writeValueAsString(newCategory);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(json, headers);

        String result = restTemplate.postForObject(url, newCategory, String.class, params);

        System.out.println(result);
    }

    public static String testNewCate2() {
        NewCategory newCategory = new NewCategory();
        newCategory.setCataname("新增测试");
        newCategory.setParentid("1");
        long now = System.currentTimeMillis();//已经是13位
        newCategory.setPtime(now + "");
        String sign = "cataname=" + newCategory.getCataname() +
                "&parentid=1&ptime=" + newCategory.getPtime() + "GQ8iHtcbkV";
        String shaSign = ParameterUtil.getUpperCaseSha1(sign);
        newCategory.setSign(shaSign);
        System.out.println(newCategory);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("sign", shaSign);
        map.add("ptime", newCategory.getPtime());
        map.add("cataname", newCategory.getCataname());
        map.add("parentid", newCategory.getParentid());

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


