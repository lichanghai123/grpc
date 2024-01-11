package com.mapper;

import com.pojo.OltTransceiver;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OltTransceiverMapper {
	int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<OltTransceiver> trafficDatas);
}