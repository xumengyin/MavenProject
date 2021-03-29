package com.xu.mvp.controller;

import com.xu.mvp.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestfulController {

    /**
     * restful 风格
     * @param v1
     * @param v2
     * @param model
     * @return
     */
    @RequestMapping(value = "/dd/{params1}/{params2}",method = RequestMethod.GET) //只允许get方法
    public String testRest(@PathVariable("params1") String v1, @PathVariable("params2")String v2, Model model) {
        String key=v1+"----"+v2;
        model.addAttribute("msg",key);
        return "hello";
    }
    //区分大小写
    @GetMapping("/EE")
    public String restful2(Model model)
    {
        String key="----";
        model.addAttribute("msg",key);
        return "hello";
    }
    //拼接参数参数名一致
    @GetMapping("/cc")
    public String restful3(String value,Model model)
    {
        model.addAttribute("msg",value);
        System.out.println("value:==========="+value);
        return "hello";
    }
    //拼接参数,参数名不一致
    @GetMapping("/ff")
    public String restful4(@RequestParam("name") String value, Model model)
    {
        model.addAttribute("msg",value);
        System.out.println("value:==========="+value);
        return "hello";
    }
    //拼接参数,参数名不一致
    @GetMapping("/gg")
    public String restful5(Model model, User user)
    {
        model.addAttribute("msg",user);
        return "hello";
    }
}
