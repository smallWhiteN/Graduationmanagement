package com.myh.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myh.mapper.*;
import com.myh.pojo.*;
import com.myh.vo.QueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagerService {
    @Resource
    private ManagerMapper managerMapper;

    public Manager login(String user, String password){
        ManagerExample example = new ManagerExample();
        ManagerExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(user);
        criteria.andPasswordEqualTo(password);
        List<Manager> managers = managerMapper.selectByExample(example);
        return managers.isEmpty()?null:managers.get(0);
    }
}
