package com.myh.mapper;

import com.myh.pojo.Direction;
import com.myh.pojo.DirectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DirectionMapper {
    long countByExample(DirectionExample example);

    int deleteByExample(DirectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Direction record);

    int insertSelective(Direction record);

    List<Direction> selectByExample(DirectionExample example);

    Direction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Direction record, @Param("example") DirectionExample example);

    int updateByExample(@Param("record") Direction record, @Param("example") DirectionExample example);

    int updateByPrimaryKeySelective(Direction record);

    int updateByPrimaryKey(Direction record);
}