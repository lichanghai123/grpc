package com.mapper;

import com.pojo.TerminalEvent;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TerminalEventMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TerminalEvent record);

    TerminalEvent selectByPrimaryKey(Long id);

    List<TerminalEvent> selectAll();

    int updateByPrimaryKey(TerminalEvent record);
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<TerminalEvent> trafficDatas);
}