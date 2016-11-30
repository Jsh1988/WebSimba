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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.Valid;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

@Controller
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersService usersService;

    @Autowired
    private Country country;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(Map<String,Object> map, Locale locale){
        Users users = new Users();

        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("login",messageSource.getMessage("login",null,locale) );
        map.put("password",messageSource.getMessage("password",null,locale) );
        map.put("email",messageSource.getMessage("email",null,locale) );
        map.put("first_name",messageSource.getMessage("first_name",null,locale) );
        map.put("surname",messageSource.getMessage("sur_name",null,locale) );
        map.put("phone",messageSource.getMessage("phone",null,locale) );
        map.put("region",messageSource.getMessage("region",null,locale) );
        map.put("city",messageSource.getMessage("city",null,locale) );
        map.put("index",messageSource.getMessage("index",null,locale) );
        map.put("phone",messageSource.getMessage("phone",null,locale) );
        map.put("street",messageSource.getMessage("street",null,locale) );
        map.put("house",messageSource.getMessage("house",null,locale) );
        map.put("admin",messageSource.getMessage("admin",null,locale) );
        map.put("add",messageSource.getMessage("add",null,locale) );
        map.put("delete",messageSource.getMessage("delete",null,locale) );
        map.put("search",messageSource.getMessage("search",null,locale) );
        map.put("edit",messageSource.getMessage("edit",null,locale) );
        map.put("country",country.CountryArray());
        map.put("users",users);
        map.put("usersList",usersService.getAllUsers());
        return "users";
    }

    @RequestMapping(value="/users.do", method=RequestMethod.POST)
    public String doUsers(@Valid @ModelAttribute("users") Users users, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map, RedirectAttributes redirectAttributes, Locale locale) {

        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("login",messageSource.getMessage("login",null,locale) );
        map.put("password",messageSource.getMessage("password",null,locale) );
        map.put("email",messageSource.getMessage("email",null,locale) );
        map.put("first_name",messageSource.getMessage("first_name",null,locale) );
        map.put("surname",messageSource.getMessage("sur_name",null,locale) );
        map.put("phone",messageSource.getMessage("phone",null,locale) );
        map.put("region",messageSource.getMessage("region",null,locale) );
        map.put("city",messageSource.getMessage("city",null,locale) );
        map.put("index",messageSource.getMessage("index",null,locale) );
        map.put("phone",messageSource.getMessage("phone",null,locale) );
        map.put("street",messageSource.getMessage("street",null,locale) );
        map.put("house",messageSource.getMessage("house",null,locale) );
        map.put("admin",messageSource.getMessage("admin",null,locale) );
        map.put("country",country.CountryArray());

        if (!bindingResult.hasErrors()) {
            Users usersRes = new Users();
            UserReg userReg = new UserReg();
            String s = action.toLowerCase();
            if (s.equals("add")) {
                userReg.setId(users.getId());
                userReg.setLogin(users.getLogin());
                userReg.setPassword(DigestUtils.md5Hex(users.getPassword()));
                userReg.setEmail(users.getEmail());
                userReg.setCountry(users.getCountry());
                userReg.setConfirmPassword(users.getConfirmPassword());
                userReg.setCheck(users.getCheck());
                usersService.addReg(userReg);
                usersRes = users;
            } else if (s.equals("edit")) {
                usersService.edit(users);
                usersRes = users;
            } else if (s.equals("delete")) {
                usersService.delete(users.getId());
                usersRes = new Users();
            } else if (s.equals("search")) {
                Users searchedUsers = usersService.getUsers(users.getId());
                usersRes = searchedUsers != null ? searchedUsers : new Users();
            } else {
                return "redirect:/error";
            }

            map.put("users", usersRes);
            map.put("usersList", usersService.getAllUsers());
            map.put("ok",messageSource.getMessage("page.from.oks",new String[]{messageSource.getMessage("user",null,locale)},locale) );
            return "users";
        } else {
            map.put("users", users);
            map.put("usersList", usersService.getAllUsers());
            map.put("error",messageSource.getMessage("page.from.errors",new String[]{messageSource.getMessage("user",null,locale)},locale) );
            return "users";
        }
    }
}
