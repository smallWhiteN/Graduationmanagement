package com.myh.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myh.controller.AuditController;
import com.myh.mapper.*;
import com.myh.pojo.Audit;
import com.myh.pojo.AuditExample;
import com.myh.pojo.Graduate;
import com.myh.pojo.GraduateExample;
import com.myh.vo.QueryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AuditService {

    @Resource
    AuditMapper auditMapper;
    @Resource
    GraduateMapper graduateMapper;
    @Resource
    private CollegeMapper collegeMapper;
    @Resource
    private MajorMapper majorMapper;
    @Resource
    private DirectionMapper directionMapper;


    public int upLoad(String stuno, String fileName){
        Audit audit = auditMapper.selectByPrimaryKey(stuno);
        if(audit==null){
            audit = new Audit();
            audit.setStuno(stuno);
            audit.setUrl(fileName);
            return auditMapper.insert(audit);
        }else{
            audit.setUrl(fileName);
            return auditMapper.updateByPrimaryKeySelective(audit);
        }
    }
    public int submit(Audit audit){
        audit.setState(0);
        audit.setLastSaveTime(new Date());
        Audit a = auditMapper.selectByPrimaryKey(audit.getStuno());
        if(a==null){
            return auditMapper.insertSelective(audit);
        }else{
            return auditMapper.updateByPrimaryKeySelective(audit);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<Audit> queryByPage(Integer pageNum, Integer pageSize){
        AuditExample auditExample = new AuditExample();
        AuditExample.Criteria criteria = auditExample.createCriteria();
        criteria.andStateEqualTo(0);
        PageHelper.startPage(pageNum, pageSize);
        List<Audit> audits = auditMapper.selectByExample(auditExample);
        for(int i=0;i<audits.size();i++){
            audits.get(i).setC(collegeMapper.selectByPrimaryKey(audits.get(i).getCollege()));
            audits.get(i).setM(majorMapper.selectByPrimaryKey(audits.get(i).getMajor()));
            audits.get(i).setD(directionMapper.selectByPrimaryKey(audits.get(i).getDirection()));
        }
        return new PageInfo<>(audits);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public Integer accept(String stuno){
        Audit audit = new Audit();
        audit.setStuno(stuno);
        audit.setState(1);
        int i = auditMapper.updateByPrimaryKeySelective(audit);
        Graduate graduate=(Graduate) auditMapper.selectByPrimaryKey(stuno);
        int j=graduateMapper.updateByPrimaryKey(graduate);
        if(i==1 && j==1)return 1;
        else return 0;
    }
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public Integer reject(String stuno, String msg){
        Audit audit = new Audit();
        audit.setStuno(stuno);
        audit.setState(-1);
        audit.setMsg(msg);
        return auditMapper.updateByPrimaryKeySelective(audit);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Audit queryByStuno(String stuno){
        Audit audit = auditMapper.selectByPrimaryKey(stuno);
        audit.setC(collegeMapper.selectByPrimaryKey(audit.getCollege()));
        audit.setM(majorMapper.selectByPrimaryKey(audit.getMajor()));
        audit.setD(directionMapper.selectByPrimaryKey(audit.getDirection()));
        return audit;
    }
}
