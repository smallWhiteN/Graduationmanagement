package com.myh.mapper;

import com.myh.pojo.Companytype;
import com.myh.pojo.CompanytypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanytypeMapper {
    long countByExample(CompanytypeExample example);

    int deleteByExample(CompanytypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Companytype record);

    int insertSelective(Companytype record);

    List<Companytype> selectByExample(CompanytypeExample example);

    Companytype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Companytype record, @Param("example") CompanytypeExample example);

    int updateByExample(@Param("record") Companytype record, @Param("example") CompanytypeExample example);

    int updateByPrimaryKeySelective(Companytype record);

    int updateByPrimaryKey(Companytype record);
}