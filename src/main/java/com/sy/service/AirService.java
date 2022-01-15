package com.sy.service;

import com.sy.dao.AirDao;
import com.sy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface AirService {

    Result findAll(Integer district_id, int pageNow, int pageSize)throws Exception;



}
