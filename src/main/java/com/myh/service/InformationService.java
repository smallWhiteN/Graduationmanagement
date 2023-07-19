package com.myh.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myh.mapper.*;
import com.myh.pojo.Graduate;
import com.myh.pojo.GraduateExample;
import com.myh.pojo.Information;
import com.myh.vo.QueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InformationService {
    @Resource
    private InformationMapper informationMapper;
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Information> queryAll(){
        return informationMapper.selectByExample(null);
    }


}
