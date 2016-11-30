package com.websimba.spring.controllers;

import com.websimba.spring.entity.Users;
import com.websimba.spring.object.Country;
import com.websimba.spring.service.interfaces.UsersService;
import com.websimba.spring.validator.interfaces.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private Validator validator;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, Model model, Locale locale) {
        if (error != null) {
            model.addAttribute("error",validator.ValidationMessages("name.pass.error",locale.getDisplayLanguage()) );
        }
        model.addAttribute("login",messageSource.getMessage("login",null,locale) );
        model.addAttribute("password",messageSource.getMessage("password",null,locale) );
        model.addAttribute("entrance",messageSource.getMessage("entrance",null,locale) );
        return "login";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(RedirectAttributes redirectAttributes,Locale locale,Model model) {
        Users users = new Users();
        model.addAttribute("user",users);
        model.addAttribute("login_ok",validator.ValidationMessages("login.form.ok",locale.getDisplayLanguage()));
        return "menu";
    }

//    private String getPrincipal(){
//        String userName = null;
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            userName = ((UserDetails)principal).getUsername();
//        } else {
//            userName = principal.toString();
//        }
//        return userName;
//    }
}
