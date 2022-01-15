package com.sy.dao;


import com.sy.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DistrictDao extends JpaRepository<District,Integer>, JpaSpecificationExecutor<District> {
}
