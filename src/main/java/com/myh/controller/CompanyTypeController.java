package com.myh.controller;

import com.myh.pojo.College;
import com.myh.pojo.Companytype;
import com.myh.service.CollegeService;
import com.myh.service.CompanyTypeService;
import com.myh.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("companytype")
@ResponseBody
public class CompanyTypeController {
    @Resource
    private CompanyTypeService companyTypeService;
    @RequestMapping(value = "all" , method = RequestMethod.GET)
    public ResultVO<Companytype> queryAll(){
        return new ResultVO<>(companyTypeService.queryAll());
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResultVO<Companytype> queryById(@PathVariable("id")Integer id){
        return new ResultVO<>(companyTypeService.queryById(id));
    }
}
