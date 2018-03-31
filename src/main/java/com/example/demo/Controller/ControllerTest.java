package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTest {

    @GetMapping("/createCuaHang")
    public String createCuaHang(){
        return "createCuaHang";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String web(){
        return "home";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @GetMapping("/")
    public String adminn(){
        return "SanPham";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @GetMapping("/allStore")
    public String allStore(){
        return "allStore";
    }
    @GetMapping("/createCuaHang/step=2")
    public  String createCuaHangstep2(){
        return "createCuaHangStep2";
    }
    @GetMapping("/createCuaHang/Step=3")
    public String createCuaHangStep3(){
        return "createCuaHangStep3";
    }



}
