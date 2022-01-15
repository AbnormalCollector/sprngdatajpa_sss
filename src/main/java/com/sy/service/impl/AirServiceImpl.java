package com.sy.service.impl;

import com.sy.dao.AirDao;
import com.sy.model.AirQualityIndex;
import com.sy.service.AirService;
import com.sy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AirServiceImpl implements AirService {
    @Autowired
    private AirDao airDao;
    @Override
    public Result findAll(Integer district_id, int pageNow, int pageSize) throws Exception {

        AirQualityIndex airQualityIndex = new AirQualityIndex();
        airQualityIndex.setDistrictId(district_id);
        Example<AirQualityIndex> of = Example.of(airQualityIndex);
        PageRequest p = PageRequest.of(pageNow - 1, pageSize);
        Page<AirQualityIndex> all = airDao.findAll(of, p);
        Result result = new Result();
        result.setCode(Result.CODE_SUCCESS);
        result.setMsg(Result.MSG_SUCCESS);
        result.setData(all.getContent());
        result.setCount(all.getTotalElements());
        return result;
    }

}
