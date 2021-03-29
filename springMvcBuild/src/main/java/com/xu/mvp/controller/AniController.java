package com.xu.mvp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
//@RequestBody
public class AniController {
    @RequestMapping("/b")
    public String h5(Model model) {
        model.addAttribute("msg", "hello");
        return "hello";
    }

    public String json() {
        return "hello";
    }


}
