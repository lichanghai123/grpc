package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.OnuTrafficRaw;


public interface OnuTrafficRawMapper {
	 int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<OnuTrafficRaw> trafficDatas);
}
