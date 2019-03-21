package com.supermarket.contoller;

import com.supermarket.dao.User;
import com.supermarket.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0 created by chenyichang_fh on 2019/3/20 18:17
 */
@RestController
public class DemoController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/demo")
    public User demo() {
        User byId = userMapper.getById(3);
        return byId;
    }

}
