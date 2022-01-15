package com.sy.dao;

import com.sy.model.AirQualityIndex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AirDao extends JpaRepository<AirQualityIndex,Integer>, JpaSpecificationExecutor<AirQualityIndex> {

}
