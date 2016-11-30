package com.websimba.spring.interceptions;


import com.websimba.spring.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckUserInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(CheckUserInterceptor.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /*уточняем что надо перехватить*/
        if(request.getRequestURI().contains("menu")) {
            Users user = (Users) modelAndView.getModel().get("user");
            if ( user.getCheck() == false ){
                response.sendRedirect(request.getContextPath() + "/login");
            }
        }
    }

}
