package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.QueueKpiRaw;


public interface QueueKpiRawMapper {
	 int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<QueueKpiRaw> trafficDatas);
}
