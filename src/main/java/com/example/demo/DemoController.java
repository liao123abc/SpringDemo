package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thomasliao on 2017/6/21.
 */
@RestController
@RequestMapping("/")
public class DemoController {

    @RequestMapping("/demo")
    private String demo() {
        //TestNewCate.testNewCate2();
        return "this is spring boot demo";
    }

    @RequestMapping("/info")
    private String info() {
//        TestInfo.testInfo2();
        //Test.testPostMain();
        return "this is spring boot info";
    }

    @RequestMapping("/upload")
    private String upload() {
//        try {
//            TestUpload2.upload();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return "this is spring boot upload";
    }
}
