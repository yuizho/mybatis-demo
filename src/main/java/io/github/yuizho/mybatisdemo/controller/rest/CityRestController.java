package io.github.yuizho.mybatisdemo.controller.rest;

import io.github.yuizho.mybatisdemo.mybatis.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityRestController {
    @Autowired
    CityMapper cityMapper;

    @RequestMapping("/")
    public String city() {
        return cityMapper.findById(1L).toString();
    }
}
