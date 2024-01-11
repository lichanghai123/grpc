package com.mapper;

import com.pojo.PppoeEvent;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PppoeEventMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PppoeEvent record);

    PppoeEvent selectByPrimaryKey(Long id);

    List<PppoeEvent> selectAll();

    int updateByPrimaryKey(PppoeEvent record);
    
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<PppoeEvent> trafficDatas);
}