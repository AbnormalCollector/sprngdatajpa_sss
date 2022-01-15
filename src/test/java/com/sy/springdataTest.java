package com.sy;

import com.sy.dao.AirDao;
import com.sy.dao.PhColockinUserDao;
import com.sy.dao.SysLogDao;
import com.sy.dao.UserDao;
import com.sy.model.AirQualityIndex;
import com.sy.model.PhColockinUser;
import com.sy.model.SysLog;
import com.sy.service.SysLogService;
import com.sy.utils.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class springdataTest {
    @Autowired
    private SysLogDao sysLogDao;
    @Autowired
    private SysLogService sysLogService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private AirDao airDao;
    @Autowired
    private PhColockinUserDao phColockinUserDao;
    @Test
    public void find(){
        List<SysLog> all = sysLogDao.findAll();
        System.out.println(all);
    }
    @Test
    public void findPage()throws Exception{
        Result page = sysLogService.findPage(1, 3);
        System.out.println(page.getData());
    }

    @Test
    public void deleteTest()throws Exception{
        userDao.deleteByUser(34);
    }

    @Test
    public void findAirAll()throws Exception{
        AirQualityIndex airQualityIndex = new AirQualityIndex();
        airQualityIndex.setDistrictId(1);
        Example<AirQualityIndex> of = Example.of(airQualityIndex);
        List<AirQualityIndex> all = airDao.findAll(of);
        System.out.println(all);
    }

    @Test
    public void findByStation(){
        AirQualityIndex airQualityIndex = new AirQualityIndex();
        airQualityIndex.setMonitoringStation("站");
        ExampleMatcher matcher = ExampleMatcher.matching()
                // ExampleMatcher.GenericPropertyMatcher::contains  lambda表达式
                //contains()  全部模糊匹配  startsWith()  前部精确后部模糊   endsWith()  后部精确前部模糊
                //propertyPath 参数是指表字段 大写自动转下划线
                .withMatcher("monitoringStation",ExampleMatcher.GenericPropertyMatchers.endsWith())
                //.withIgnorePaths()  忽略字段，不管输入什么值都不加入查询条件
                //.withIgnoreNullValues()  忽略空值
                .withIgnoreNullValues();
        Example<AirQualityIndex> example = Example.of(airQualityIndex,matcher);
        List<AirQualityIndex> all = airDao.findAll(example);
        System.out.println(all);
    }
    @Test
    public void findTest()throws Exception{
//        PhColockinUser phColockinUser = new PhColockinUser();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
//        Date date = simpleDateFormat.parse(format);
//        phColockinUser.setMorningColock(date);
//        System.out.println(phColockinUser.getMorningColock());
        PhColockinUser byMorningColock = phColockinUserDao.findByMorningColock(format);
        System.out.println(byMorningColock);
    }
}
