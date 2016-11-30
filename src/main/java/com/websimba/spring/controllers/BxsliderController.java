package com.websimba.spring.controllers;

import com.websimba.spring.entity.Bxslider;
import com.websimba.spring.service.interfaces.BxsliderService;
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
public class BxsliderController {

    private static final Logger logger = LoggerFactory.getLogger(BxsliderController.class);

    @Autowired
    private BxsliderService bxsliderService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/bxslider", method = RequestMethod.GET)
    public String bxslider(Map<String,Object> map, Locale locale){
        Bxslider bxslider = new Bxslider();
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("title",messageSource.getMessage("title",null,locale) );
        map.put("images",messageSource.getMessage("images",null,locale) );
        map.put("url",messageSource.getMessage("url",null,locale) );
        map.put("bxslider",bxslider);
        map.put("bxsliderList",bxsliderService.getAllBxslider());
        return "bxslider";
    }

    @RequestMapping(value="/bxslider.do", method=RequestMethod.POST)
    public String doBxslider(Locale locale, @ModelAttribute("bxslider") Bxslider bxslider, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("title",messageSource.getMessage("title",null,locale) );
        map.put("images",messageSource.getMessage("images",null,locale) );
        map.put("url",messageSource.getMessage("url",null,locale) );
        if (!bindingResult.hasErrors()) {
            Bxslider bxsliderRes = new Bxslider();
            String s = action.toLowerCase();
            if (s.equals("add")) {
                bxsliderService.add(bxslider);
                bxsliderRes = bxslider;
            } else if (s.equals("edit")) {
                bxsliderService.edit(bxslider);
                bxsliderRes = bxslider;
            } else if (s.equals("delete")) {
                bxsliderService.delete(bxslider.getId());
                bxsliderRes = new Bxslider();
            } else if (s.equals("search")) {
                Bxslider searchedBxslider = bxsliderService.getBxslider(bxslider.getId());
                bxsliderRes = searchedBxslider != null ? searchedBxslider : new Bxslider();
            } else {
                return "redirect:/";
            }
            map.put("bxslider", bxsliderRes);
            map.put("bxsliderList", bxsliderService.getAllBxslider());
            map.put("ok",messageSource.getMessage("page.from.oks",new String[]{messageSource.getMessage("slider",null,locale)},locale) );
            return "bxslider";
        } else {
            map.put("error",messageSource.getMessage("page.from.errors",new String[]{messageSource.getMessage("slider",null,locale)},locale) );
            return "bxslider";
        }
    }

}
