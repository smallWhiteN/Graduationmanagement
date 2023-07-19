package com.myh.mapper;

import com.myh.pojo.Graduate;
import com.myh.pojo.GraduateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GraduateMapper {
    long countByExample(GraduateExample example);

    int deleteByExample(GraduateExample example);

    int deleteByPrimaryKey(String stuno);

    int insert(Graduate record);

    int insertSelective(Graduate record);

    List<Graduate> selectByExample(GraduateExample example);

    Graduate selectByPrimaryKey(String stuno);

    int updateByExampleSelective(@Param("record") Graduate record, @Param("example") GraduateExample example);

    int updateByExample(@Param("record") Graduate record, @Param("example") GraduateExample example);

    int updateByPrimaryKeySelective(Graduate record);

    int updateByPrimaryKey(Graduate record);
}