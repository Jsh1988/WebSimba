package com.websimba.spring.controllers;

import com.websimba.spring.entity.Pages;
import com.websimba.spring.service.interfaces.PagesService;
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
public class PagesController {

    private static final Logger logger = LoggerFactory.getLogger(PagesController.class);

    @Autowired
    private PagesService pagesService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/pages", method = RequestMethod.GET)
    public String pages(Map<String,Object> map, Locale locale){
        Pages pages = new Pages();
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("title",messageSource.getMessage("title",null,locale) );
        map.put("alias",messageSource.getMessage("alias",null,locale) );
        map.put("description",messageSource.getMessage("description",null,locale) );
        map.put("keywords",messageSource.getMessage("keywords",null,locale) );
        map.put("content",messageSource.getMessage("content",null,locale) );
        map.put("images",messageSource.getMessage("images",null,locale) );
        map.put("position",messageSource.getMessage("position",null,locale) );

        map.put("pages",pages);
        map.put("pagesList",pagesService.getAllPages());
        return "pages";
    }

    @RequestMapping(value="/pages.do", method=RequestMethod.POST)
    public String doPages(Locale locale, @ModelAttribute("pages") Pages pages, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("title",messageSource.getMessage("title",null,locale) );
        map.put("alias",messageSource.getMessage("alias",null,locale) );
        map.put("description",messageSource.getMessage("description",null,locale) );
        map.put("keywords",messageSource.getMessage("keywords",null,locale) );
        map.put("content",messageSource.getMessage("content",null,locale) );
        map.put("images",messageSource.getMessage("images",null,locale) );
        map.put("position",messageSource.getMessage("position",null,locale) );
        if (!bindingResult.hasErrors()) {
            Pages pagesRes = new Pages();
            String s = action.toLowerCase();
            if (s.equals("add")) {
                pagesService.add(pages);
                pagesRes = pages;
            } else if (s.equals("edit")) {
                pagesService.edit(pages);
                pagesRes = pages;
            } else if (s.equals("delete")) {
                pagesService.delete(pages.getPageId());
                pagesRes = new Pages();
            } else if (s.equals("search")) {
                Pages searchedPages = pagesService.getPages(pages.getPageId());
                pagesRes = searchedPages != null ? searchedPages : new Pages();
            } else {
                return "redirect:/";
            }
            map.put("pages", pagesRes);
            map.put("pagesList", pagesService.getAllPages());
            map.put("ok",messageSource.getMessage("page.from.oks",new String[]{messageSource.getMessage("page",null,locale)},locale) );
            return "pages";
        } else {
            map.put("error",messageSource.getMessage("page.from.errors",new String[]{messageSource.getMessage("page",null,locale)},locale) );
            return "pages";
        }
    }

}
