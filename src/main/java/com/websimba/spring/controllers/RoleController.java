package com.websimba.spring.controllers;

import com.websimba.spring.entity.Role;
import com.websimba.spring.service.interfaces.RoleService;
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

import java.util.Locale;
import java.util.Map;

@Controller
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public String role(Map<String,Object> map, Locale locale){
        Role role = new Role();
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("first_name",messageSource.getMessage("first_name",null,locale) );

        map.put("role",role);
        map.put("roleList",roleService.getAllRole());
        return "role";
    }

    @RequestMapping(value="/role.do", method=RequestMethod.POST)
    public String doRole(Locale locale, @ModelAttribute("role") Role role, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("first_name",messageSource.getMessage("first_name",null,locale) );
        if (!bindingResult.hasErrors()) {
            Role roleRes = new Role();
            String s = action.toLowerCase();
            if (s.equals("add")) {
                roleService.add(role);
                roleRes = role;
            } else if (s.equals("edit")) {
                roleService.edit(role);
                roleRes = role;
            } else if (s.equals("delete")) {
                roleService.delete(role.getId());
                roleRes = new Role();
            } else if (s.equals("search")) {
                Role searchedRole = roleService.getRole(role.getId());
                roleRes = searchedRole != null ? searchedRole : new Role();
            } else {
                return "redirect:/";
            }
            map.put("role", roleRes);
            map.put("roleList", roleService.getAllRole());
            map.put("ok",messageSource.getMessage("page.from.oks",new String[]{messageSource.getMessage("role",null,locale)},locale) );
            return "role";
        } else {
            map.put("error",messageSource.getMessage("page.from.errors",new String[]{messageSource.getMessage("role",null,locale)},locale) );
            return "role";
        }
    }

}
