package com.mapper;

import com.pojo.UserIdentityEvent;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserIdentityEventMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserIdentityEvent record);

    UserIdentityEvent selectByPrimaryKey(Long id);

    List<UserIdentityEvent> selectAll();

    int updateByPrimaryKey(UserIdentityEvent record);
    int batchInsert(@Param("tableName") String tableName, @Param("trafficDatas") List<UserIdentityEvent> trafficDatas);
}