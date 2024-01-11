package com.mapper;

import com.pojo.TcpConnectIndex;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TcpConnectIndexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TcpConnectIndex record);

    TcpConnectIndex selectByPrimaryKey(Long id);

    List<TcpConnectIndex> selectAll();

    int updateByPrimaryKey(TcpConnectIndex record);
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<TcpConnectIndex> trafficDatas);
}