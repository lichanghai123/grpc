package com.mapper;

import com.pojo.PppoeKpiEvent;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PppoeKpiEventMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PppoeKpiEvent record);

    PppoeKpiEvent selectByPrimaryKey(Long id);

    List<PppoeKpiEvent> selectAll();

    int updateByPrimaryKey(PppoeKpiEvent record);
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<PppoeKpiEvent> trafficDatas);
}