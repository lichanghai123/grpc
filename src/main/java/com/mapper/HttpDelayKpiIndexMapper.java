package com.mapper;

import com.pojo.HttpDelayKpiIndex;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HttpDelayKpiIndexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HttpDelayKpiIndex record);

    HttpDelayKpiIndex selectByPrimaryKey(Long id);

    List<HttpDelayKpiIndex> selectAll();

    int updateByPrimaryKey(HttpDelayKpiIndex record);
    
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<HttpDelayKpiIndex> trafficDatas);
}