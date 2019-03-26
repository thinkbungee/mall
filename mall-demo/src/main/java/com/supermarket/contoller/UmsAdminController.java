package com.supermarket.contoller;

import com.supermarket.dto.CommonResult;
import com.supermarket.dto.UmsAdminLoginParam;
import com.supermarket.dto.UmsAdminParam;
import com.supermarket.model.UmsAdmin;
import com.supermarket.model.UmsPermission;
import com.supermarket.model.UmsRole;
import com.supermarket.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户管理
 * @version 1.0 created by chenyichang_fh on 2019/3/22 15:04
 */
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RestController("/admin")
public class UmsAdminController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @Autowired
    private UmsAdminService umsAdminService;


    @ResponseBody
    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(@RequestBody UmsAdminParam umsAdminParam, BindingResult bindingResult) {
        UmsAdmin register = umsAdminService.register(umsAdminParam);
        if (register == null) {
            return new CommonResult().failed();
        }
        return new CommonResult().success(register);
    }


    @ResponseBody
    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult bindingResult) {
        String token = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return new CommonResult().validateFailed("用户名或密码错误");
        }
        Map<String ,String > tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return new CommonResult().success(tokenMap);
    }

    @ResponseBody
    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/token/refresh", method = RequestMethod.GET)
    public Object refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = umsAdminService.refreshToken(token);
        if (refreshToken == null) {
            return new CommonResult().failed();
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return new CommonResult().success(tokenMap);
    }

    @ResponseBody
    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Object getAdminInfo(Principal principal) {
        String username = principal.getName();
        UmsAdmin adminByUsername = umsAdminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", adminByUsername.getUsername());
        data.put("roles", new String[]{"test"});
        data.put("icon", adminByUsername.getIcon());
        return new CommonResult().success(data);
    }

    @ResponseBody
    @ApiOperation(value = "登出")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Object logout() {
        return new CommonResult().success(null);
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsAdmin> list = umsAdminService.list(name, pageSize, pageNum);
        return new CommonResult().pageSuccess(list);
    }

    @ApiOperation("获取指定用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getItem(@PathVariable("id") Long id) {
        UmsAdmin userById = umsAdminService.getUserById(id);
        return new CommonResult().success(userById);
    }

    @ApiOperation("修改指定用户信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Object update(@PathVariable Long id, @RequestBody UmsAdmin admin) {
        int update = umsAdminService.update(id, admin);
        if (update > 0) {
            return new CommonResult().success(update);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除指定用户信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@PathVariable() Long id) {
        int delete = umsAdminService.delete(id);
        if (delete > 0) {
            return new CommonResult().success(delete);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("给用户分配角色")
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    @ResponseBody
    public Object updateRole(@RequestParam("adminId") Long adminId,
                             @RequestParam("rolesIds") List<Long> roleIds) {
        int i = umsAdminService.updateRole(adminId, roleIds);
        if (i >= 0) {
            return new CommonResult().success(i);
        }
        return new CommonResult().failed();

    }

    @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.GET)
    public Object getRoleList(@PathVariable Long adminId) {
        List<UmsRole> roleList = umsAdminService.getRoleList(adminId);
        return new CommonResult().success(roleList);
    }

    @ApiOperation("给用户分配权限")
    @RequestMapping(value = "/permission/update", method = RequestMethod.POST)
    @ResponseBody
    public Object updatePermission(@RequestParam Long adminId,
                                   @RequestParam("permissionIds") List<Long> permissionIds) {
        int i = umsAdminService.updatePermission(adminId, permissionIds);
        if (i >= 0) {
            return new CommonResult().success(i);
        }
        return new CommonResult().failed();
    }


    @ApiOperation("获取用户所有权限")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getPermissionList(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = umsAdminService.getPermissionList(adminId);
        return new CommonResult().success(permissionList);

    }


}
