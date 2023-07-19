package com.myh.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myh.mapper.*;
import com.myh.pojo.*;
import com.myh.vo.QueryVO;
import com.myh.vo.RateVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.*;

@Service
public class GraduateService {
    @Resource
    private GraduateMapper graduateMapper;
    @Resource
    private CollegeMapper collegeMapper;
    @Resource
    private MajorMapper majorMapper;
    @Resource
    private DirectionMapper directionMapper;
    @Resource
    private CompanytypeMapper companytypeMapper;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public PageInfo<Graduate> queryByPage(Integer pageNum, Integer pageSize, QueryVO vo){
        GraduateExample example = new GraduateExample();
        GraduateExample.Criteria criteria = example.createCriteria();
        if(vo!=null){
            if(vo.getStuno()!=null && !"".equals(vo.getStuno().trim())){
                criteria.andStunoEqualTo(vo.getStuno());
            }
            if(vo.getStuname()!=null && !"".equals(vo.getStuname().trim())){
                criteria.andStunameLike("%"+vo.getStuname()+"%");
            }
            if(vo.getGrade()!=null){
                criteria.andGradeEqualTo(vo.getGrade());
            }
            if(vo.getCollege()!=null && vo.getCollege()!=0){
                criteria.andCollegeEqualTo(vo.getCollege());
            }
            if(vo.getMajor()!=null && vo.getMajor()!=0){
                criteria.andMajorEqualTo(vo.getMajor());
            }
            if(vo.getDirection()!=null && vo.getDirection()!=-1){
                criteria.andDirectionEqualTo(vo.getDirection());
            }
            if(vo.getIsInProvince()!=null && vo.getIsInProvince()!=-1){
                criteria.andIsInProvinceEqualTo(vo.getIsInProvince());
            }
            if(vo.getIsCrossExam()!=null && vo.getIsCrossExam()!=-1){
                criteria.andIsCrossExamEqualTo(vo.getIsCrossExam());
            }
            if(vo.getIsDFC()!=null && vo.getIsDFC()!=-1){
                criteria.andIsDFCEqualTo(vo.getIsDFC());
            }
            if(vo.getCompanyType()!=null && vo.getCompanyType()!=0){
                criteria.andCompanyIdEqualTo(vo.getCompanyType());
            }
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Graduate> graduates = graduateMapper.selectByExample(example);
        for(int i=0;i<graduates.size();i++){
            graduates.get(i).setC(collegeMapper.selectByPrimaryKey(graduates.get(i).getCollege()));
            graduates.get(i).setM(majorMapper.selectByPrimaryKey(graduates.get(i).getMajor()));
            graduates.get(i).setD(directionMapper.selectByPrimaryKey(graduates.get(i).getDirection()));
        }
        return new PageInfo<>(graduates);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public int addGraduate(Graduate graduate){
        return graduateMapper.insertSelective(graduate);
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Graduate queryByStuno(String stuno){
        Graduate graduate = graduateMapper.selectByPrimaryKey(stuno);
        graduate.setC(collegeMapper.selectByPrimaryKey(graduate.getCollege()));
        graduate.setM(majorMapper.selectByPrimaryKey(graduate.getMajor()));
        graduate.setD(directionMapper.selectByPrimaryKey(graduate.getDirection()));
        return graduate;
    }
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public int updateGraduate(Graduate graduate){
        if(graduate.getDirection()==1 || graduate.getDirection()==2){
            graduate.setIsCrossExam(null);
            graduate.setIsDFC(null);
        }
        if(graduate.getDirection()==3){
            graduate.setCompanyId(null);
        }
        if(graduate.getLastSaveTime()==null){
            graduate.setLastSaveTime(new Date());
        }
        return graduateMapper.updateByPrimaryKey(graduate);
    }
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public int deleteGraduate(String stuno){
        return graduateMapper.deleteByPrimaryKey(stuno);
    }
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public int deleteGraduates(String[] stunoList){
        int i=-1;
        for(String stuno:stunoList){
            i=graduateMapper.deleteByPrimaryKey(stuno);
            if(i!=1)return i;
        }
        return i;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Integer countByDirection(QueryVO vo, Integer directionId ){
        GraduateExample example = new GraduateExample();
        GraduateExample.Criteria criteria = example.createCriteria();
        if(vo!=null){
            if(vo.getGrade()!=null && vo.getGrade()!=0){
                criteria.andGradeEqualTo(vo.getGrade());
            }
            if(vo.getCollege()!=null && vo.getCollege()!=0){
                criteria.andCollegeEqualTo(vo.getCollege());
            }
            if(vo.getMajor()!=null && vo.getMajor()!=0){
                criteria.andMajorEqualTo(vo.getMajor());
            }
            if(vo.getIsInProvince()!=null && vo.getIsInProvince()!=-1){
                criteria.andIsInProvinceEqualTo(vo.getIsInProvince());
            }
        }
        criteria.andDirectionEqualTo(directionId);
        return new Integer((int)graduateMapper.countByExample(example));
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public RateVO calculateRate(QueryVO vo){
        GraduateExample example = new GraduateExample();
        RateVO rateVO = new RateVO();
        GraduateExample.Criteria criteria = example.createCriteria();
        if(vo!=null){
            if(vo.getGrade()!=null && vo.getGrade()!=0){
                criteria.andGradeEqualTo(vo.getGrade());
            }
            if(vo.getCollege()!=null && vo.getCollege()!=0){
                criteria.andCollegeEqualTo(vo.getCollege());
            }
            if(vo.getMajor()!=null && vo.getMajor()!=0){
                criteria.andMajorEqualTo(vo.getMajor());
            }
            if(vo.getIsInProvince()!=null && vo.getIsInProvince()!=-1){
                criteria.andIsInProvinceEqualTo(vo.getIsInProvince());
            }
            rateVO.setTotalOfQueryVO((int)graduateMapper.countByExample(example));
        }
        int total = (int)graduateMapper.countByExample(example);
        rateVO.setTotal(total);
        Map<String ,Integer> countMap=new HashMap<>();
        Map<String ,Double> rateMap=new HashMap<>();
        List<Direction> directions = directionMapper.selectByExample(null);
        for(int i =0;i<directions.size();i++){
            Direction direction = directions.get(i);
            Integer count= countByDirection(vo, direction.getId());
            countMap.put(direction.getDirection(), count);
            rateMap.put(direction.getDirection(),Double.parseDouble(new DecimalFormat("#.00").format(count*1.0/total)));
        }
        rateVO.setCount(countMap);
        rateVO.setRate(rateMap);
        rateVO.setCountOfDFC(countByDFC(vo, 1));
        rateVO.setCountOfNDFC(countByDFC(vo, 0));
        rateVO.setCountOfCE(countByCE(vo, 1));
        rateVO.setCountOfNCE(countByCE(vo, 0));
        List<Companytype> companytypes =companytypeMapper.selectByExample(null);
        Map<String ,Integer> companyTypeMap=new HashMap<>();
        for(int i =0;i<companytypes.size();i++){
            Companytype companytype = companytypes.get(i);
            Integer count= countByCompanyType(vo, companytype.getId());
            companyTypeMap.put(companytype.getCompanyType(), count);
        }
        rateVO.setCountByCompanyType(companyTypeMap);
        return rateVO;
    }
    public Integer countByDFC(QueryVO vo, Integer i){
        GraduateExample example = new GraduateExample();
        GraduateExample.Criteria criteria = example.createCriteria();
        if(vo!=null){
            if(vo.getGrade()!=null && vo.getGrade()!=0){
                criteria.andGradeEqualTo(vo.getGrade());
            }
            if(vo.getCollege()!=null && vo.getCollege()!=0){
                criteria.andCollegeEqualTo(vo.getCollege());
            }
            if(vo.getMajor()!=null && vo.getMajor()!=0){
                criteria.andMajorEqualTo(vo.getMajor());
            }
            if(vo.getIsInProvince()!=null && vo.getIsInProvince()!=-1){
                criteria.andIsInProvinceEqualTo(vo.getIsInProvince());
            }
        }
        criteria.andDirectionEqualTo(3);
        criteria.andIsDFCEqualTo(i);
        return new Integer((int)graduateMapper.countByExample(example));
    }
    public Integer countByCompanyType(QueryVO vo, Integer i){
        GraduateExample example = new GraduateExample();
        GraduateExample.Criteria criteria = example.createCriteria();
        if(vo!=null){
            if(vo.getGrade()!=null && vo.getGrade()!=0){
                criteria.andGradeEqualTo(vo.getGrade());
            }
            if(vo.getCollege()!=null && vo.getCollege()!=0){
                criteria.andCollegeEqualTo(vo.getCollege());
            }
            if(vo.getMajor()!=null && vo.getMajor()!=0){
                criteria.andMajorEqualTo(vo.getMajor());
            }
            if(vo.getIsInProvince()!=null && vo.getIsInProvince()!=-1){
                criteria.andIsInProvinceEqualTo(vo.getIsInProvince());
            }
        }
        List<Integer> d = new ArrayList<>();
        d.add(1);d.add(2);
        criteria.andDirectionIn(d);
        criteria.andCompanyIdEqualTo(i);
        return new Integer((int)graduateMapper.countByExample(example));
    }
    public Integer countByCE(QueryVO vo, Integer i){
        GraduateExample example = new GraduateExample();
        GraduateExample.Criteria criteria = example.createCriteria();
        if(vo!=null){
            if(vo.getGrade()!=null && vo.getGrade()!=0){
                criteria.andGradeEqualTo(vo.getGrade());
            }
            if(vo.getCollege()!=null && vo.getCollege()!=0){
                criteria.andCollegeEqualTo(vo.getCollege());
            }
            if(vo.getMajor()!=null && vo.getMajor()!=0){
                criteria.andMajorEqualTo(vo.getMajor());
            }
            if(vo.getIsInProvince()!=null && vo.getIsInProvince()!=-1){
                criteria.andIsInProvinceEqualTo(vo.getIsInProvince());
            }
        }
        criteria.andDirectionEqualTo(3);
        criteria.andIsCrossExamEqualTo(i);
        return new Integer((int)graduateMapper.countByExample(example));
    }
    public Integer login(String stuno, String password){
        GraduateExample example = new GraduateExample();
        GraduateExample.Criteria criteria = example.createCriteria();
        criteria.andStunoEqualTo(stuno);
        criteria.andPasswordEqualTo(password);
        List<Graduate> graduates = graduateMapper.selectByExample(example);
        return graduates.size();
    }

    public int signUp(Graduate graduate){
        Graduate graduate1 = graduateMapper.selectByPrimaryKey(graduate.getStuno());
        if(graduate1==null)return -1;
        if(graduate1.getPassword()==null || graduate1.getPassword().equals("")){
            return  graduateMapper.updateByPrimaryKey(graduate);
        }else{
            return 0;
        }
    }


}
