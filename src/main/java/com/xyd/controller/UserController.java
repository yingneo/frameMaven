package com.xyd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyd.common.LoginInterceptor;
import com.xyd.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController extends LoginInterceptor{
    
    public static final Logger LOGGER = Logger.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/userController")
    public void test(HttpServletRequest request, HttpServletResponse response) {
        try {
            String result = userService.userQuery();
            response.getWriter().print(result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}