package com.sy.service;


import com.sy.model.User;
import com.sy.utils.Result;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Administrator
 * @Date: 2021/12/30 15:28
 * @Version 1.0
 */
public interface UserService{



    Result findPage(int pageNow,int pageSize) throws Exception;

    Result login(User user) throws Exception;
}
