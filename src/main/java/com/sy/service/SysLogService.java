package com.sy.service;

import com.sy.model.SysLog;
import com.sy.utils.Result;

public interface SysLogService {
    Result addLog(SysLog log) throws Exception;

    Result findPage(int pageNow,int pageSize) throws Exception;

}
