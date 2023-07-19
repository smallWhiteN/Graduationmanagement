package com.myh.controller;

import com.myh.pojo.Direction;
import com.myh.pojo.Major;
import com.myh.service.DirectionService;
import com.myh.service.MajorService;
import com.myh.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("direction")
@ResponseBody
public class DirectionController {
    @Resource
    private DirectionService directionService;
    @RequestMapping(value = "all" , method = RequestMethod.GET)
    public ResultVO<Direction> queryAll(){
        return new ResultVO<>(directionService.queryAll());
    }
}
