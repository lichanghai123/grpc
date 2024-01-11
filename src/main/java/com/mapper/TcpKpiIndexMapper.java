package com.mapper;

import com.pojo.TcpKpiIndex;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TcpKpiIndexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TcpKpiIndex record);

    TcpKpiIndex selectByPrimaryKey(Long id);

    List<TcpKpiIndex> selectAll();

    int updateByPrimaryKey(TcpKpiIndex record);
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<TcpKpiIndex> trafficDatas);
}