package com.myh.controller;

import com.github.pagehelper.PageInfo;
import com.myh.pojo.Graduate;
import com.myh.pojo.Information;
import com.myh.pojo.Manager;
import com.myh.service.GraduateService;
import com.myh.service.ManagerService;
import com.myh.vo.QueryVO;
import com.myh.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("manager")
@ResponseBody
public class ManagerController {
    @Resource
    private ManagerService managerService;
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResultVO<Manager> login(String user, String password){
        return new ResultVO<>(managerService.login(user, password));
    }
}
