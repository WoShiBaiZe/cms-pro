package com.baize.cms.portal.controller.admin;

import com.baize.cms.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


//    @GetMapping("test")
//    public String test(){
//       return "/admin/test/index";
//    }

//    @GetMapping("test")
//    public void test(){
//        redisTemplate.opsForValue().set("abc","asdfsadf");
//    }
}
