package com.cjs.boot.controller;

import com.cjs.boot.request.LoginForm;
import com.cjs.boot.response.RespResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    private ObjectError error;

    @GetMapping("/index.html")
    public ModelAndView index() {
        return new ModelAndView("login");
    }

    @PostMapping("/login.json")
    @ResponseBody
    public RespResult login(@Valid LoginForm loginRequest, BindingResult bindingResult, Model model) {
        System.out.println(model);
        if (bindingResult.hasErrors()) {
            if (bindingResult.hasErrors()) {
                for (ObjectError error : bindingResult.getAllErrors()) {
                    return RespResult.failure(error.getDefaultMessage());
                }
            }
        }
        return RespResult.success();
    }
}
