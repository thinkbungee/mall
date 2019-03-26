package com.supermarket.contoller;

import com.supermarket.dto.CommonResult;
import com.supermarket.dto.UmsAdminLoginParam;
import com.supermarket.dto.UmsAdminParam;
import com.supermarket.model.UmsAdmin;
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
}
