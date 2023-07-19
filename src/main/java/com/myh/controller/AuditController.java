package com.myh.controller;

import com.github.pagehelper.PageInfo;
import com.myh.pojo.Audit;
import com.myh.pojo.Graduate;
import com.myh.service.AuditService;
import com.myh.vo.QueryVO;
import com.myh.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("audit")
@ResponseBody
public class AuditController {
    @Resource
    AuditService auditService;
    @RequestMapping(value = "{stuno}", method = RequestMethod.POST)
    public ResultVO<String> upLoad(@RequestParam("certificate")MultipartFile file,
                           HttpServletRequest request,
                           @PathVariable("stuno")String stuno){
        String path = request.getServletContext().getRealPath("/img/certificates/");
        String originalFilename = file.getOriginalFilename();
        String randomName = UUID.randomUUID().toString().replace("-", "");
        int index = originalFilename.lastIndexOf(".");
        String hz = originalFilename.substring(index);
        String logoName=randomName+hz;
        try {
            file.transferTo(new File(path+"/"+logoName));
            System.out.println(logoName+" 上传成功");

//            int i = auditService.upLoad(stuno, logoName);
////            if(i==0){
//                return new ResultVO<String>(500,"上传失败");
//            }else{
                return new ResultVO<String>(logoName);
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResultVO<Audit> submit( Audit audit){
        int i = auditService.submit(audit);
        if(i==0) return new ResultVO(500,"提交失败");
        return new ResultVO(200, "提交成功");
    }
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultVO<Audit> queryByPage(Integer pageNum, Integer pageSize){
        if(pageNum==null || pageNum<=0){
            pageNum=1;
        }
        if(pageSize==null || pageSize<=0){
            pageSize=5;
        }
        PageInfo<Audit> auditPageInfo = auditService.queryByPage(pageNum, pageSize);
        return new ResultVO<>(auditPageInfo);
    }
    @RequestMapping(value = "{stuno}", method = RequestMethod.DELETE)
    public ResultVO<Audit> reject(@PathVariable String stuno, String msg){
        System.out.println("reject---"+stuno +" "+msg);
        Integer i = auditService.reject(stuno, msg);
        if(i==0)return new ResultVO<>(500, "驳回失败");
        return new ResultVO<>(200, "驳回成功");
    }
    @RequestMapping(value = "{stuno}", method = RequestMethod.PUT)
    public ResultVO<Audit> accept(@PathVariable String stuno){
        System.out.println(stuno);
        Integer i = auditService.accept(stuno);
        if(i==0)return new ResultVO<>(500, "审核失败");
        return new ResultVO<>(200, "审核成功");
    }
    @RequestMapping(value = "{stuno}", method = RequestMethod.GET)
    public ResultVO<Audit> queryByStuno(@PathVariable("stuno")String stuno){
        return new ResultVO<>(auditService.queryByStuno(stuno));
    }
}
