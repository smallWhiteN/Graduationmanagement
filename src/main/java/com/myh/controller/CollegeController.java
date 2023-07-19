package com.myh.controller;

import com.myh.pojo.College;
import com.myh.pojo.Major;
import com.myh.service.CollegeService;
import com.myh.service.MajorService;
import com.myh.vo.ResultVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("college")
@ResponseBody
public class CollegeController {
    @Resource
    private CollegeService collegeService;
    @RequestMapping(value = "all" , method = RequestMethod.GET)
    public ResultVO<College> queryAll(){
        return new ResultVO<>(collegeService.queryAll());
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResultVO<College> queryById(@PathVariable("id")Integer id){
        return new ResultVO<>(collegeService.queryById(id));
    }
}
