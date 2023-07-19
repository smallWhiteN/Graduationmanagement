package com.myh.test;

import com.github.pagehelper.PageInfo;
import com.myh.mapper.CollegeMapper;
import com.myh.mapper.GraduateMapper;
import com.myh.pojo.Graduate;
import com.myh.service.GraduateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml"})
public class TestMapper {
    @Resource
    private GraduateMapper graduateMapper;
    @Resource
    private GraduateService graduateService;
    @Resource
    private CollegeMapper collegeMapper;

    @Test
    public void test02(){
        PageInfo<Graduate> graduatePageInfo = graduateService.queryByPage(1, 5, null);
        System.out.println(graduatePageInfo);
    }
    @Test
    public void test01(){
        Graduate graduate = graduateMapper.selectByPrimaryKey("1");
        System.out.println(graduate);
    }
}
