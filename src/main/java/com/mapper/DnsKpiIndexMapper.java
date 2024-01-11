package com.mapper;

import com.pojo.DnsKpiIndex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DnsKpiIndexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DnsKpiIndex record);

    DnsKpiIndex selectByPrimaryKey(Long id);

    List<DnsKpiIndex> selectAll();

    int updateByPrimaryKey(DnsKpiIndex record);
    
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<DnsKpiIndex> trafficDatas);
}