package com.sxh.user.controller;

import com.sxh.user.model.User;
import com.sxh.user.model.base.ResponseJson;
import com.sxh.user.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Created by yantao.chen on 2019-07-06
 */
@RestController
@RequestMapping("demo")
@Validated
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("test1")
    public ResponseJson demoQuery(@Validated @RequestBody User user){
        ResponseJson response = new ResponseJson(demoService.demoMethod(user.getId()));
        return response;
    }
    @RequestMapping("test2")
    public ResponseJson demoValidate(@NotNull(message = "用户id不能为空") String  userId){
        ResponseJson response = new ResponseJson();
        return response;
    }
}
