package com.yida.outerimgpath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(value = {"", "/index"})
    public String indexPage(Model model) {
        model.addAttribute("imgPath1", "/img/photo1.jpg");
        model.addAttribute("imgPath2", "/image/photo2.jpg");
        return "index";
    }
}
