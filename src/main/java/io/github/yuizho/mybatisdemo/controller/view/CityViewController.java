package io.github.yuizho.mybatisdemo.controller.view;

import io.github.yuizho.mybatisdemo.mybatis.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Controller
@Validated
public class CityViewController {
    @Autowired
    CityMapper cityMapper;

    @GetMapping("/greeting/{name}")
    public String greeting(@NotNull
                               @Size(min = 1, max = 10)
                               @Pattern(regexp = "^[a-zA-Z]+$")
                               @PathVariable(name="name") String name,
                           Model model) {
        model.addAttribute("name", name);
        model.addAttribute("city", cityMapper.findById(1L).toString());
        return "greeting";
    }
}
