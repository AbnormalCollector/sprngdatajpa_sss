package com.sy.controller;


import com.sy.log.LogAnnotation;
import com.sy.model.User;
import com.sy.service.UserService;
import com.sy.utils.JwtTokenUtil;
import com.sy.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Administrator
 * @Date: 2021/12/30 15:31
 * @Version 1.0
 */
@Api(value = "UserController",description = "用户登录登出汇总",tags = "UserController")
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "passwd", value = "密码", required = true ,dataType = "string")
    })
    @RequestMapping("/login")
    public Result login(@RequestBody User user) throws Exception{
        System.out.println(user);
        return userService.login(user);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNow", value = "当前页", required = true ,dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "当页容量", required = true ,dataType = "int")
    })
    @LogAnnotation(title = "用户模块",action = "用户查询")
    @RequestMapping("/page")
    public Result findAll(@RequestParam int pageNow,@RequestParam int pageSize) throws Exception{
        return userService.findPage(pageNow,pageSize);
    }

}
