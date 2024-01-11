package com.mapper;

import com.pojo.OnuLocalInfo;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OnuLocalInfoMapper {

    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<OnuLocalInfo> trafficDatas);
}