package com.sy.controller;

import com.sy.service.DistrictService;
import com.sy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("District")
@CrossOrigin
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("list")
    public Result findAll()throws Exception{
        Result all = districtService.findAll();
        return all;
    }
}
