package com.supermarket.contoller;

import com.supermarket.mapper.OmsOrderMapper;
import com.supermarket.model.OmsOrder;
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
    OmsOrderMapper omsOrderMapper;

    @RequestMapping("/demo")
    public OmsOrder demo() {

        OmsOrder omsOrder = omsOrderMapper.selectByPrimaryKey(12L);
        return omsOrder;
    }

}
