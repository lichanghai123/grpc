package com.mapper;

import com.pojo.PortTrafficStatisticIndex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PortTrafficStatisticsMapper {
  /*  int deleteByPrimaryKey(Long id);

    int insert(PortTrafficStatistics record);

    PortTrafficStatistics selectByPrimaryKey(Long id);

    List<PortTrafficStatistics> selectAll();

    int updateByPrimaryKey(PortTrafficStatistics record);*/
    
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<PortTrafficStatisticIndex> trafficDatas);
}