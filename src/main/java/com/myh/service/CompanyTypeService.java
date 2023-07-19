package com.myh.service;

import com.myh.mapper.CollegeMapper;
import com.myh.mapper.CompanytypeMapper;
import com.myh.pojo.College;
import com.myh.pojo.Companytype;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyTypeService {
    @Resource
    CompanytypeMapper companytypeMapper;
    public List<Companytype> queryAll(){
        return companytypeMapper.selectByExample(null);
    }
    public Companytype queryById(Integer id){
        return companytypeMapper.selectByPrimaryKey(id);
    }
}
