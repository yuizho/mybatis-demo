package io.github.yuizho.mybatisdemo.controller.view;

import io.github.yuizho.mybatisdemo.mybatis.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CityViewController {
    @Autowired
    CityMapper cityMapper;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("city", cityMapper.findById(1L).toString());
        return "greeting";
    }
}
