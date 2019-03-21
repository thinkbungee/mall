package com.supermarket.mapper;

import com.supermarket.dao.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @version 1.0 created by chenyichang_fh on 2019/3/20 19:31
 */
@Mapper
public interface UserMapper {

    User getById(Integer id);
}
