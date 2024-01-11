package com.mapper;

import com.pojo.OnuRemoteInfo;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OnuRemoteInfoMapper {

    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<OnuRemoteInfo> trafficDatas);
}