package com.myh.service;

import com.myh.pojo.Manager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml"})
public class ManagerServiceTest {

    @Resource
    ManagerService managerService;
    @Test
    public void login() {
        Manager manager = managerService.login("myh", "3 or 1=1 ");
        System.out.println(manager);
    }
}