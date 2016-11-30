package com.websimba.spring.controllers;

import com.websimba.spring.entity.Categories;
import com.websimba.spring.service.interfaces.CategoriesService;
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
public class CategoriesController {

    private static final Logger logger = LoggerFactory.getLogger(CategoriesController.class);

    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String categories(Map<String,Object> map,Locale locale){
        Categories categories = new Categories();
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("title",messageSource.getMessage("title",null,locale) );
        map.put("alias",messageSource.getMessage("alias",null,locale) );
        map.put("parent",messageSource.getMessage("parent",null,locale) );
        map.put("categories",categories);
        map.put("categoriesList",categoriesService.getAllCategories());
        return "categories";
    }

    @RequestMapping(value="/categories.do", method=RequestMethod.POST)
    public String doCategories(Locale locale, @ModelAttribute("categories") Categories categories, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("title",messageSource.getMessage("title",null,locale) );
        map.put("alias",messageSource.getMessage("alias",null,locale) );
        map.put("parent",messageSource.getMessage("parent",null,locale) );
        if (!bindingResult.hasErrors()) {
            //redirectAttributes.addFlashAttribute("redirect",true);
            Categories categoriesRes = new Categories();
            String s = action.toLowerCase();
            if (s.equals("add")) {
                categoriesService.add(categories);
                categoriesRes = categories;
            } else if (s.equals("edit")) {
                categoriesService.edit(categories);
                categoriesRes = categories;
            } else if (s.equals("delete")) {
                categoriesService.delete(categories.getId());
                categoriesRes = new Categories();
            } else if (s.equals("search")) {
                Categories searchedCategories = categoriesService.getCategories(categories.getId());
                categoriesRes = searchedCategories != null ? searchedCategories : new Categories();
            } else {
                return "redirect:/";
            }
            map.put("categories", categoriesRes);
            map.put("categoriesList", categoriesService.getAllCategories());
            map.put("ok",messageSource.getMessage("page.from.oks",new String[]{messageSource.getMessage("categories",null,locale)},locale) );
            return "categories";

        } else {
            map.put("error",messageSource.getMessage("page.from.errors",new String[]{messageSource.getMessage("categories",null,locale)},locale) );
            return "categories";
        }
    }

}
