package com.supermarket.service;

import com.supermarket.dto.UmsAdminParam;
import com.supermarket.model.UmsAdmin;
import com.supermarket.model.UmsPermission;
import com.supermarket.model.UmsRole;

import java.util.List;

/**
 * 后台管理员service
 * @version 1.0 created by chenyichang_fh on 2019/3/22 15:29
 */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册
     * @param umsAdminParam
     * @return
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 登录
     * @param username
     * @param password
     * @return 生成token
     */
    String login(String username, String password);


    /**
     * 刷新token
     * @param oldToken
     * @return
     */
    String refreshToken(String oldToken);

    /**
     * 根据用户id获取用户
     * @param id
     * @return
     */
    UmsAdmin getUserById(Long id);


    /**
     * 根据用户名或者昵称分页查询用户
     * @param name
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsAdmin> list(String name, Integer pageSize, Integer pageNum);

    /**
     * 更新指定用户信息
     * @param id
     * @param admin
     * @return
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 删除指定用户
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 修改用户角色关系
     * @param adminId
     * @param roleIds
     * @return
     */
    // TODO 应该加上事务管理
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 获取用户对应的角色
     * @return
     */
    List<UmsRole> getRoleList(Long adminId);


    /**
     * 修改用户的权限
     * @param adminId
     * @param permissionIds
     * @return
     */
    //TODO 应该加上事务管理
    int updatePermission(Long adminId, List<Long> permissionIds);

    /**
     * 获取用户的所有权限（包括角色权限和 增删权限）
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);


}
