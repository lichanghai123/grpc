package com.mapper;


import org.apache.ibatis.annotations.Param;

import com.pojo.EthernetKpiRaw;

import java.util.List;

public interface EthernetKpiRawMapper {
    
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<EthernetKpiRaw> trafficDatas);

}