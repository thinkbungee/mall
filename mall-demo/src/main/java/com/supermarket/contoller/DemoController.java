package com.supermarket.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0 created by chenyichang_fh on 2019/3/20 18:17
 */
@RestController
public class DemoController {

    @RequestMapping("/demo")
    public String demo() {
        System.out.println("====");
        return "hello,world";
    }

}
