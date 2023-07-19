package com.myh.service;

import com.myh.mapper.MajorMapper;
import com.myh.pojo.Major;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MajorService {
    @Resource
    MajorMapper majorMapper;

    public List<Major> queryAll(){
        return majorMapper.selectByExample(null);
    }

    public Major queryById(int id){
        return majorMapper.selectByPrimaryKey(id);
    }
}
