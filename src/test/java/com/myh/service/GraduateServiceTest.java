package com.myh.service;

import com.github.pagehelper.PageInfo;
import com.myh.pojo.Graduate;
import com.myh.vo.QueryVO;
import com.myh.vo.RateVO;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml"})
public class GraduateServiceTest extends TestCase {

    @Resource
    GraduateService graduateService;
    @Test
    public void testCalculateRate() {
        QueryVO vo = new QueryVO();
        vo.setCollege(0);
        vo.setMajor(0);
        vo.setGrade(2023);
        RateVO rateVO = graduateService.calculateRate(vo);
        System.out.println(rateVO);
    }

    @Test
    public void queryByPage() {
        PageInfo<Graduate> graduatePageInfo = graduateService.queryByPage(1, 5, null);
        System.out.println(graduatePageInfo.getList());
    }

    @Test
    public void addGraduate() {
//        System.out.println("addGraduate");
    }

    @Test
    public void queryByStuno() {
    }

    @Test
    public void updateGraduate() {
    }

    @Test
    public void deleteGraduate() {
    }

    @Test
    public void deleteGraduates() {
    }

    @Test
    public void countByDirection() {
    }

    @Test
    public void calculateRate() {
    }

    @Test
    public void countByDFC() {
    }

    @Test
    public void countByCompanyType() {
    }

    @Test
    public void countByCE() {
    }

    @Test
    public void login() {
    }

    @Test
    public void signUp() {
    }
}