package com.websimba.spring.controllers;

import com.websimba.spring.entity.UserReg;
import com.websimba.spring.entity.Users;
import com.websimba.spring.object.Country;
import com.websimba.spring.service.interfaces.UsersService;
import com.websimba.spring.validator.interfaces.Validator;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private static final int WEAK_STRENGTH = 1;
    private static final int FEAR_STRENGTH = 7;
    private static final int STRONG_STRENGTH = 12;

    private static final String WEAK_COLOR = "#FF0000";
    private static final String FEAR_COLOR = "#FF9900";
    private static final String STRONG_COLOR = "#0099CC";

    @Autowired
    private UsersService usersService;

    @Autowired
    private Country country;
    @Autowired
    private Validator validator;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(@ModelAttribute Users user, Model model, Locale locale){
        model.addAttribute("reg_user",new Users());
        model.addAttribute("country",country.CountryArray());
        model.addAttribute("login",messageSource.getMessage("login",null,locale) );
        model.addAttribute("password",messageSource.getMessage("password",null,locale) );
        model.addAttribute("confirm_password",messageSource.getMessage("confirm_password",null,locale) );
        model.addAttribute("email",messageSource.getMessage("email",null,locale) );
        model.addAttribute("registration",messageSource.getMessage("registration",null,locale) );
        return "registration";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String doRegistration(@Valid @ModelAttribute("reg_user") Users user, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, Locale locale){
        UserReg userReg = new UserReg();
        model.addAttribute("login",messageSource.getMessage("login",null,locale) );
        model.addAttribute("password",messageSource.getMessage("password",null,locale) );
        model.addAttribute("confirm_password",messageSource.getMessage("confirm_password",null,locale) );
        model.addAttribute("email",messageSource.getMessage("email",null,locale) );
        model.addAttribute("registration",messageSource.getMessage("registration",null,locale) );
        if(user.getConfirmPassword().equals(user.getPassword())){
            if(!bindingResult.hasErrors()){
                userReg.setId(user.getId());
                userReg.setLogin(user.getLogin());
                userReg.setPassword(DigestUtils.md5Hex(user.getPassword()));
                userReg.setEmail(user.getEmail());
                userReg.setCountry(user.getCountry());
                userReg.setConfirmPassword(user.getConfirmPassword());
                userReg.setCheck(user.getCheck());
                usersService.addReg(userReg);
                redirectAttributes.addFlashAttribute("country",country.CountryArray());
                redirectAttributes.addFlashAttribute("reg_ok",validator.ValidationMessages("registration.form.ok",locale.getDisplayLanguage()));
                return "redirect:/registration";
            }else{
                model.addAttribute("country",country.CountryArray());
                model.addAttribute("error",validator.ValidationMessages("registration.form.error",locale.getDisplayLanguage()));
                return "registration";
            }
        }else{
            model.addAttribute("country",country.CountryArray());
            model.addAttribute("confirm_password_error",validator.ValidationMessages("confirm.password.error",locale.getDisplayLanguage()));
            return "registration";
        }
    }

//    проверить прочность
    @RequestMapping(value = "/checkStrength", method = RequestMethod.GET, produces = { "text/html; charset=UTF-8" })
    public @ResponseBody
    String checkStrength(@RequestParam String password,Locale locale) {
        String result = "<span class=\"strength\" style=\"color:%s;\">%s</span>";

        if (password.length() >= WEAK_STRENGTH & password.length() < FEAR_STRENGTH) {
            return String.format(result, WEAK_COLOR, messageSource.getMessage("weak",null,locale));
        } else if (password.length() >= FEAR_STRENGTH & password.length() < STRONG_STRENGTH) {
            return String.format(result, FEAR_COLOR, messageSource.getMessage("average",null,locale));
        } else if (password.length() >= STRONG_STRENGTH) {
            return String.format(result, STRONG_COLOR, messageSource.getMessage("strong",null,locale));
        }
        return "";
    }

}
