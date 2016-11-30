package com.websimba.spring.controllers;

import com.websimba.spring.entity.Acategories;
import com.websimba.spring.service.interfaces.AcategoriesService;
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
public class AcategoriesController {

    private static final Logger logger = LoggerFactory.getLogger(AcategoriesController.class);

    @Autowired
    private AcategoriesService acategoriesService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/acategories", method = RequestMethod.GET)
    public String acategories(Map<String,Object> map,Locale locale){
        Acategories acategories = new Acategories();
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("title",messageSource.getMessage("title",null,locale) );
        map.put("alias",messageSource.getMessage("alias",null,locale) );
        map.put("parent",messageSource.getMessage("parent",null,locale) );
        map.put("acategories",acategories);
        map.put("acategoriesList",acategoriesService.getAllAcategories());
        return "acategories";
    }

    @RequestMapping(value="/acategories.do", method=RequestMethod.POST)
    public String doAcategories(Locale locale, @ModelAttribute("acategories") Acategories acategories, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("title",messageSource.getMessage("title",null,locale) );
        map.put("alias",messageSource.getMessage("alias",null,locale) );
        map.put("parent",messageSource.getMessage("parent",null,locale) );
        if (!bindingResult.hasErrors()) {
            Acategories acategoriesRes = new Acategories();
            String s = action.toLowerCase();
            if (s.equals("add")) {
                acategoriesService.add(acategories);
                acategoriesRes = acategories;
            } else if (s.equals("edit")) {
                acategoriesService.edit(acategories);
                acategoriesRes = acategories;
            } else if (s.equals("delete")) {
                acategoriesService.delete(acategories.getId());
                acategoriesRes = new Acategories();
            } else if (s.equals("search")) {
                Acategories searchedAcategories = acategoriesService.getAcategories(acategories.getId());
                acategoriesRes = searchedAcategories != null ? searchedAcategories : new Acategories();
            } else {
                return "redirect:/";
            }
            map.put("acategories", acategoriesRes);
            map.put("acategoriesList", acategoriesService.getAllAcategories());
            map.put("ok",messageSource.getMessage("page.from.oks",new String[]{messageSource.getMessage("acategories",null,locale)},locale) );
            return "acategories";

        } else {
            map.put("error",messageSource.getMessage("page.from.errors",new String[]{messageSource.getMessage("acategories",null,locale)},locale) );
            return "acategories";
        }
    }

}
