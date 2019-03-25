package com.supermarket.dao;

import com.supermarket.model.UmsAdminPermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户权限
 * @version 1.0 created by chenyichang_fh on 2019/3/22 16:25
 */
public interface UmsAdminPermissionRelationDao {


    int insertList(@Param("list") List<UmsAdminPermissionRelation> list);
}
