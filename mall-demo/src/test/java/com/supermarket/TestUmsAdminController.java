package com.supermarket;

import com.supermarket.dto.UmsAdminParam;
import com.supermarket.model.UmsAdmin;
import com.supermarket.service.UmsAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0 created by chenyichang_fh on 2019/3/22 16:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    /**
     * UmsAdminService的方法测试
     */
    @Test
    public void testUmsAdminService() {

//        UmsAdmin adminByUsername = umsAdminService.getAdminByUsername("test");
//        System.out.println(adminByUsername);

        UmsAdminParam umsAdmin = new UmsAdminParam();
        umsAdmin.setUsername("tom");
        umsAdmin.setPassword("tom");
        umsAdmin.setEmail("tom@qq.com");
        umsAdmin.setIcon("我是一张图");
        umsAdmin.setNote("我是备注");
        System.out.println(umsAdminService.register(umsAdmin));

    }

    @Test
    public void testUmsAdminLogin(){
        String login = umsAdminService.login("tom", "tom");
        System.out.println(login);
    }

}
