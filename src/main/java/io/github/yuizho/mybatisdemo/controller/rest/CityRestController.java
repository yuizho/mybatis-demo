package io.github.yuizho.mybatisdemo.controller.rest;

import io.github.yuizho.mybatisdemo.mybatis.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public void post(@RequestParam(value = "created", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date created) {
        if (created == null) {
            created = new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(sdf.format(created));
    }
}
