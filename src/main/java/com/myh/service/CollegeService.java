package com.myh.service;

import com.myh.mapper.CollegeMapper;
import com.myh.mapper.MajorMapper;
import com.myh.pojo.College;
import com.myh.pojo.Major;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollegeService {
    @Resource
    CollegeMapper collegeMapper;

    public List<College> queryAll(){
        return collegeMapper.selectByExample(null);
    }
    public College queryById(int id){
        return collegeMapper.selectByPrimaryKey(id);
    }
}
