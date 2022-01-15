package com.sy.service.impl;

import com.sy.dao.DistrictDao;
import com.sy.model.District;
import com.sy.service.DistrictService;
import com.sy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictDao districtDao;
    @Override
    public Result findAll() throws Exception {
        List<District> all = districtDao.findAll();
        Result result = new Result();
        if(all != null){
            result.setCode(Result.CODE_SUCCESS);
            result.setData(all);
            result.setMsg(Result.MSG_SUCCESS);
        }else {
            result.setMsg(Result.MSG_ERROR);
            result.setCode(Result.CODE_ERROR);
        }
        return result;
    }
}
