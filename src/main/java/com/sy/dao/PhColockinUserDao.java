package com.sy.dao;

import com.sy.model.PhColockinUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface PhColockinUserDao extends JpaRepository<PhColockinUser,Integer>, JpaSpecificationExecutor<PhColockinUser> {


    @Query(value = "select * from ph_colockin_user p where DATE_FORMAT(p.morning_colock,'%Y-%m-%d')= ?1",nativeQuery = true)
    PhColockinUser findByMorningColock(String date);
}
