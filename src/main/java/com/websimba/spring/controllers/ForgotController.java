package com.websimba.spring.controllers;

import com.websimba.spring.entity.Forgot;
import com.websimba.spring.service.interfaces.ForgotService;
import com.websimba.spring.validator.interfaces.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Locale;
import java.util.Map;

@Controller
public class ForgotController {

    private static final Logger logger = LoggerFactory.getLogger(ForgotController.class);

    @Autowired
    private ForgotService forgotService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/forgot", method = RequestMethod.GET)
    public String forgot(Map<String,Object> map, Locale locale){
        Forgot forgot = new Forgot();
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("hash",messageSource.getMessage("hash",null,locale) );
        map.put("expire",messageSource.getMessage("expire",null,locale) );
        map.put("email",messageSource.getMessage("email",null,locale) );
        map.put("forgot",forgot);
        map.put("forgotList",forgotService.getAllForgot());
        return "forgot";
    }

    @RequestMapping(value="/forgot.do", method=RequestMethod.POST)
    public String doForgot(Locale locale, @Valid @ModelAttribute("forgot") Forgot forgot, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("hash",messageSource.getMessage("hash",null,locale) );
        map.put("expire",messageSource.getMessage("expire",null,locale) );
        map.put("email",messageSource.getMessage("email",null,locale) );
        if (!bindingResult.hasErrors()) {
            Forgot forgotRes = new Forgot();
            String s = action.toLowerCase();
            if (s.equals("add")) {
                forgotService.add(forgot);
                forgotRes = forgot;
            } else if (s.equals("edit")) {
                forgotService.edit(forgot);
                forgotRes = forgot;
            } else if (s.equals("delete")) {
                forgotService.delete(forgot.getId());
                forgotRes = new Forgot();
            } else if (s.equals("search")) {
                Forgot searchedForgot = forgotService.getForgot(forgot.getId());
                forgotRes = searchedForgot != null ? searchedForgot : new Forgot();
            } else {
                return "redirect:/";
            }
            map.put("forgot", forgotRes);
            map.put("forgotList", forgotService.getAllForgot());
            map.put("ok",messageSource.getMessage("page.from.oks",new String[]{messageSource.getMessage("forgot",null,locale)},locale) );
            return "forgot";
        } else {
            map.put("error",messageSource.getMessage("page.from.errors",new String[]{messageSource.getMessage("forgot",null,locale)},locale) );
            return "forgot";
        }

    }

}
