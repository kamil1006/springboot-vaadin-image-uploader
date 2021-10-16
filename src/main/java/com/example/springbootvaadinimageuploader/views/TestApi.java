package com.example.springbootvaadinimageuploader.views;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @GetMapping("/test1")
    public String Test1(){
        return "test1";
    }
    @GetMapping("/test2")
    public String Test2(){
        return "test2";
    }
    @GetMapping("/test3")
    public String Test3(){
        return "test3";
    }
    @GetMapping("/test4")
    public String Test4(){
        return "test4";
    }


}
