package com.mapper;

import com.pojo.UdpKpiIndex;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UdpKpiIndexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UdpKpiIndex record);

    UdpKpiIndex selectByPrimaryKey(Long id);

    List<UdpKpiIndex> selectAll();

    int updateByPrimaryKey(UdpKpiIndex record);
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<UdpKpiIndex> trafficDatas);
}