package com.mapper;

import com.pojo.OnuTransceiver;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OnuTransceiverMapper {

    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<OnuTransceiver> trafficDatas);
}