package com.websimba.spring.controllers;

import com.websimba.spring.entity.Ips;
import com.websimba.spring.service.interfaces.IpsService;
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
public class IpsController {

    private static final Logger logger = LoggerFactory.getLogger(IpsController.class);

    @Autowired
    private IpsService ipsService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/ips", method = RequestMethod.GET)
    public String ips(Map<String,Object> map, Locale locale){
        Ips ips = new Ips();
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("ip_adress",messageSource.getMessage("ip_adress",null,locale) );
        map.put("ips",ips);
        map.put("ipsList",ipsService.getAllIps());
        return "ips";
    }

    @RequestMapping(value="/ips.do", method=RequestMethod.POST)
    public String doIps(Locale locale, @ModelAttribute("ips") Ips ips, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("ip_adress",messageSource.getMessage("ip_adress",null,locale) );
        if (!bindingResult.hasErrors()) {
            Ips ipsRes = new Ips();
            String s = action.toLowerCase();
            if (s.equals("add")) {
                ipsService.add(ips);
                ipsRes = ips;
            } else if (s.equals("edit")) {
                ipsService.edit(ips);
                ipsRes = ips;
            } else if (s.equals("delete")) {
                ipsService.delete(ips.getId());
                ipsRes = new Ips();
            } else if (s.equals("search")) {
                Ips searchedIps = ipsService.getIps(ips.getId());
                ipsRes = searchedIps != null ? searchedIps : new Ips();
            } else {
                return "redirect:/";
            }
            map.put("ips", ipsRes);
            map.put("ipsList", ipsService.getAllIps());
            map.put("ok",messageSource.getMessage("page.from.oks",new String[]{messageSource.getMessage("ip_adress",null,locale)},locale) );
            return "ips";
        } else {
            map.put("error",messageSource.getMessage("page.from.errors",new String[]{messageSource.getMessage("ip_adress",null,locale)},locale) );
            return "ips";
        }
    }

}
