package com.sy.dao;


import com.sy.model.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName StudentDao
 * @Description TODO
 * @Author Administrator
 * @Date: 2022/1/5 15:25
 * @Version 1.0
 */
public interface SysLogDao extends JpaRepository<SysLog,Integer>, JpaSpecificationExecutor<SysLog> {
}
