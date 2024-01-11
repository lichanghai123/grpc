package com.mapper;


import org.apache.ibatis.annotations.Param;

import com.pojo.PortTrafficRaw;

import java.util.List;

public interface PortTrafficRawMapper {
    
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<PortTrafficRaw> trafficDatas);

}