package com.sy.controller;

import com.sy.model.AirQualityIndex;
import com.sy.service.AirService;
import com.sy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Air")
@CrossOrigin
public class AirController {
    @Autowired
    private AirService airService;

    @RequestMapping(value = "list")
    public Result findAll(@RequestParam(defaultValue = "") Integer district_id, @RequestParam int pageNow, @RequestParam int pageSize) throws Exception {
        System.out.println(district_id+"==="+pageNow + "===" + pageSize);
        Result result = airService.findAll(district_id, pageNow, pageSize);
        System.out.println(result.getData());
        return result;
    }
//    @RequestMapping(value = "modify")
//    public Result modify(@RequestBody AirQualityIndex air_quality_index) throws Exception {
//        System.out.println(air_quality_index);
//        Result result = airService.modifyAll(air_quality_index);
//        return result;
//    }
//
//    @RequestMapping(value = "remove")
//    public Result removeBYId(@RequestParam int id) throws Exception {
////        System.out.println(air_quality_index);
//        Result result = airService.removeById(id);
//        return result;
//    }
//
//    @RequestMapping(value = "add")
//    public Result addAll(@RequestBody AirQualityIndex air_quality_index) throws Exception {
//        System.out.println(air_quality_index);
//        Result result = airService.addAll(air_quality_index);
//        return result;
//    }
}
