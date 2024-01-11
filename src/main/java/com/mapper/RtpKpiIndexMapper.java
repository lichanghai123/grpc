package com.mapper;

import com.pojo.RtpKpiIndex;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RtpKpiIndexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RtpKpiIndex record);

    RtpKpiIndex selectByPrimaryKey(Long id);

    List<RtpKpiIndex> selectAll();

    int updateByPrimaryKey(RtpKpiIndex record);
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<RtpKpiIndex> trafficDatas);
}