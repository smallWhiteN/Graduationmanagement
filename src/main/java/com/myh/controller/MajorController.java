package com.myh.controller;

import com.myh.mapper.MajorMapper;
import com.myh.pojo.Major;
import com.myh.service.MajorService;
import com.myh.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("major")
@ResponseBody
public class MajorController {
    @Resource
    private MajorService majorService;
    @RequestMapping(value = "all" , method = RequestMethod.GET)
    public ResultVO<Major> queryAll(){
        return new ResultVO<>(majorService.queryAll());
    }
}
