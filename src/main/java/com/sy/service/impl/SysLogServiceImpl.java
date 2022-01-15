package com.sy.service.impl;

import com.sy.dao.SysLogDao;
import com.sy.model.SysLog;
import com.sy.service.SysLogService;
import com.sy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    @Transactional
    @Override
    public Result addLog(SysLog log) throws Exception {
        SysLog save = sysLogDao.saveAndFlush(log);
        Result result = new Result();
        if(save.getId() != null){
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
        }else{
            result.setCode(Result.CODE_ERROR);
            result.setMsg(Result.MSG_ERROR);
        }
        return result;
    }

    @Override
    public Result findPage(int pageNow, int pageSize) throws Exception {
        PageRequest p = PageRequest.of((pageNow - 1)*pageSize, pageSize);
        Page<SysLog> all = sysLogDao.findAll(p);
        Result result = new Result();
        result.setCode(Result.CODE_SUCCESS);
        result.setMsg(Result.MSG_SUCCESS);
        result.setData(all.getContent());
        return result;
    }
}
