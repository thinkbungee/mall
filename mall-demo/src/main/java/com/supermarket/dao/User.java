package com.supermarket.dao;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @version 1.0 created by chenyichang_fh on 2019/3/20 19:28
 */
@Component
@Data
public class User {
    private Integer id;
    private String name;
}
