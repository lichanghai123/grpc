package com.mapper;

import com.pojo.OnuLineQuality;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OnuLineQualityMapper {
	int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<OnuLineQuality> trafficDatas);

}