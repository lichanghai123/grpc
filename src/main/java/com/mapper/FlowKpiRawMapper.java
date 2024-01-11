package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.FlowKpiRaw;


public interface FlowKpiRawMapper {
	 int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<FlowKpiRaw> trafficDatas);
}
