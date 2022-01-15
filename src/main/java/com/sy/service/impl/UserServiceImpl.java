package com.sy.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sy.dao.UserDao;
import com.sy.log.LogAnnotation;
import com.sy.model.SysLog;
import com.sy.model.User;
import com.sy.service.UserService;
import com.sy.utils.JwtConstant;
import com.sy.utils.JwtTokenUtil;
import com.sy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private JwtTokenUtil tokenUtil;
    @Autowired
    private UserDao userDao;
    @Override
    public Result findPage(int pageNow, int pageSize) throws Exception {
        PageRequest p = PageRequest.of(pageNow - 1, pageSize);
        Page<User> all = userDao.findAll(p);
        Result result = new Result();
        result.setCode(Result.CODE_SUCCESS);
        result.setMsg(Result.MSG_SUCCESS);
        result.setData(all.getContent());
        result.setCount(all.getTotalElements());
        return result;
    }
    @Override
    public Result login(User user) throws Exception {
        Result result = new Result();
        User findUser = userDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(findUser!=null){
            findUser.setPassword(null);//java--json--JSONobject->map
            result.setData(findUser);
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
            JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(findUser));
            Map<String, Object> claim = jsonObject.getInnerMap();
            String subject = findUser.getId().toString();

            claim.put(JwtConstant.JWT_USER_NAME,findUser.getUsername());
            String jwt = tokenUtil.getAccessToken(subject, claim);
            result.setToken(jwt);
        }else{
            result.setCode(Result.CODE_ERROR);
            result.setMsg("用户名或密码错误");
        }
        return result;
    }
}
