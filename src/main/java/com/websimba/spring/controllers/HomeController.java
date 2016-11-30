package com.websimba.spring.controllers;


import com.websimba.spring.entity.Users;
import com.websimba.spring.object.interfaces.ConverterJsonFile;
import com.websimba.spring.service.interfaces.UsersService;
import com.websimba.spring.validator.interfaces.Validator;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UsersService usersService;
    @Autowired
    private Validator validator;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private ConverterJsonFile converterJsonFile;

    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    public ModelAndView home(@ModelAttribute Users user, HttpSession session, Model model,Locale locale ){
        ModelAndView modelAndView = new ModelAndView();
        user.setCheck(true);
        modelAndView.setViewName("home");
        modelAndView.addObject("user",user);
        modelAndView.addObject("login",messageSource.getMessage("login",null,locale));
        modelAndView.addObject("password",messageSource.getMessage("password",null,locale));
        modelAndView.addObject("entrance",messageSource.getMessage("entrance",null,locale));
        return modelAndView;
    }

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    public String menu(@ModelAttribute("user") Users user, BindingResult bindingResult, Model model, Locale locale) {
        model.addAttribute("login",messageSource.getMessage("login",null,locale));
        model.addAttribute("password",messageSource.getMessage("password",null,locale));
        model.addAttribute("entrance",messageSource.getMessage("entrance",null,locale));
        model.addAttribute("upload",messageSource.getMessage("upload",null,locale));
        Users inspection = usersService.getUsers(3);
        if(DigestUtils.md5Hex(user.getPassword()).equals(inspection.getPassword()) && user.getLogin().equals(inspection.getLogin()) ){
            if(!bindingResult.hasErrors()){
                if(user.getCheck() == true ){
                    model.addAttribute("login_ok",validator.ValidationMessages("easy_login.form.ok",locale.getDisplayLanguage()));
                }

                String reading = null;
                try {
                    converterJsonFile.toJSON((Users)user,"D:\\\\Examples\\\\WebSimba\\\\src\\\\main\\\\webapp\\\\resources\\\\json\\\\json.json");

                    reading = converterJsonFile.read("D:\\\\Examples\\\\WebSimba\\\\src\\\\main\\\\webapp\\\\resources\\\\json\\\\json.json");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("reading : " + reading);
                String jsonRes = null;
                try {
                    jsonRes = converterJsonFile.JSONObject(reading,"login");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println("jsonRes : " + jsonRes);

                return "menu";
            }else{
                return "home";
            }
        }else {
            model.addAttribute("npe",validator.ValidationMessages("name.pass.error",locale.getDisplayLanguage()));
            return "home";
        }
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView error(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("404","404");
        return modelAndView;
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accesssDenied(Users user,Locale locale) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("page_error", " Error 403 : " + validator.ValidationMessages("page.access.error",locale.getDisplayLanguage()));
        } else {
            model.addObject("page_error", validator.ValidationMessages("page.access.error",locale.getDisplayLanguage()));
        }
        model.setViewName("/error403");
        return model;

    }



}
