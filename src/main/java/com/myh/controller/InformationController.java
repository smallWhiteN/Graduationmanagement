package com.myh.controller;

import com.github.pagehelper.PageInfo;
import com.myh.pojo.Graduate;
import com.myh.pojo.Information;
import com.myh.service.GraduateService;
import com.myh.service.InformationService;
import com.myh.vo.QueryVO;
import com.myh.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("information")
@ResponseBody
public class InformationController {
    @Resource
    private InformationService informationService;
    @RequestMapping(value = "all",method = RequestMethod.GET)
    public ResultVO<Information> queryAll(){
        return new ResultVO<>(informationService.queryAll());
    }


}
