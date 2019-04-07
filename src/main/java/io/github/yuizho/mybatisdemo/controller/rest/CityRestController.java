package io.github.yuizho.mybatisdemo.controller.rest;

import io.github.yuizho.mybatisdemo.mybatis.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CityRestController {
    @Autowired
    CityMapper cityMapper;

    @RequestMapping("/")
    public String city() {
        return cityMapper.findById(1L).toString();
    }

    @PostMapping("/post")
    public void post() { System.out.println("hello!!"); }
}
