package com.myh.controller;

import com.github.pagehelper.PageInfo;
import com.myh.pojo.Graduate;
import com.myh.pojo.Information;
import com.myh.service.GraduateService;
import com.myh.vo.QueryVO;
import com.myh.vo.RateVO;
import com.myh.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("graduate")
@ResponseBody
public class GraduateController {
    @Resource
    private GraduateService graduateService;
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultVO<Graduate> queryByPage(Integer pageNum, Integer pageSize, QueryVO vo){
        if(pageNum==null || pageNum<=0){
            pageNum=1;
        }
        if(pageSize==null || pageSize<=0){
            pageSize=5;
        }
        PageInfo<Graduate> graduatePageInfo = graduateService.queryByPage(pageNum, pageSize, vo);
        return new ResultVO<>(graduatePageInfo);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultVO<Graduate> addGraduate(Graduate graduate){
        if(graduate.getCollege()==0)graduate.setCollege(null);
        if(graduate.getMajor()==0)graduate.setMajor(null);
        int i = graduateService.addGraduate(graduate);
        if(i==1){
            return new ResultVO<>();
        }
        return new ResultVO<>(500, "添加失败:服务器内部异常");
    }
    @RequestMapping(value = "{stuno}", method = RequestMethod.GET)
    public ResultVO<Graduate> queryByStuno(@PathVariable("stuno") String stuno){
        Graduate graduate = graduateService.queryByStuno(stuno);
        return new ResultVO<>(graduate);
    }
    @RequestMapping(value = "{stuno}",method = RequestMethod.PUT)
    public ResultVO<Graduate> updateGraduate(@PathVariable("stuno")String stuno, Graduate graduate){
        graduate.setStuno(stuno);
        int i = graduateService.updateGraduate(graduate);
        if(i==1){
            return new ResultVO<>();
        }
        return new ResultVO<>(500, "添加失败:服务器内部异常");
    }

    @RequestMapping(value = "{stuno}", method = RequestMethod.DELETE)
    public ResultVO<Graduate> deleteGraduate(@PathVariable("stuno") String stuno){
        int i = graduateService.deleteGraduate(stuno);
        if(i==1){
            return new ResultVO<>();
        }
        return new ResultVO<>(500, "添加失败:服务器内部异常");
    }
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResultVO<Graduate> deleteGraduates(@PathVariable("stunoList") String[] stunoList){
        int i = graduateService.deleteGraduates(stunoList);
        if(i==1){
            return new ResultVO<>();
        }
        return new ResultVO<>(500, "添加失败:服务器内部异常");
    }
    @RequestMapping(value="rate", method=RequestMethod.GET)
    public ResultVO<RateVO> calculateRate(QueryVO vo){
        RateVO rateVO = graduateService.calculateRate(vo);
        System.out.println(rateVO);
        return new ResultVO<>(rateVO);
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResultVO login(String stuno, String password){
        Integer i= graduateService.login(stuno, password);
        if(i==0)return new ResultVO(500, "密码错误");
        return new ResultVO<>(200, "登陆成功");
    }
    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    public ResultVO signUp(Graduate graduate){
        int i = graduateService.signUp(graduate);
        if(i==0){
            return new ResultVO(500, "该用户已注册，请登录");
        }else if(i==1) {
            return new ResultVO(200, "注册成功");
        }else{
            return new ResultVO(500, "该学号无效，请联系管理员");
        }
    }
}
