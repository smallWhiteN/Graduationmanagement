package com.myh.service;

import com.myh.mapper.DirectionMapper;
import com.myh.mapper.MajorMapper;
import com.myh.pojo.Direction;
import com.myh.pojo.Major;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DirectionService {
    @Resource
    DirectionMapper directionMapper;
    public List<Direction> queryAll(){
        return directionMapper.selectByExample(null);
    }
    public Direction queryById(int id){
        return directionMapper.selectByPrimaryKey(id);
    }
}
