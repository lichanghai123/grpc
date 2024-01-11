package com.mapper;

import com.pojo.HttpKpiIndex;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HttpKpiIndexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HttpKpiIndex record);

    HttpKpiIndex selectByPrimaryKey(Long id);

    List<HttpKpiIndex> selectAll();

    int updateByPrimaryKey(HttpKpiIndex record);
    
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<HttpKpiIndex> trafficDatas);
}