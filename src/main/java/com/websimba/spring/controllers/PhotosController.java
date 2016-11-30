package com.websimba.spring.controllers;

import com.websimba.spring.entity.Photos;
import com.websimba.spring.service.interfaces.PhotosService;
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
public class PhotosController {

    private static final Logger logger = LoggerFactory.getLogger(PhotosController.class);

    @Autowired
    private PhotosService photosService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/photos", method = RequestMethod.GET)
    public String photos(Map<String,Object> map, Locale locale){
        Photos photos = new Photos();

        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("title",messageSource.getMessage("title",null,locale) );
        map.put("images",messageSource.getMessage("images",null,locale) );
        map.put("parent",messageSource.getMessage("parent",null,locale) );
        map.put("photoDescription",messageSource.getMessage("photoDescription",null,locale) );
        map.put("link",messageSource.getMessage("link",null,locale) );
        map.put("mark",messageSource.getMessage("mark",null,locale) );

        map.put("photos",photos);
        map.put("photosList",photosService.getAllPhotos());
        return "photos";
    }

    @RequestMapping(value="/photos.do", method=RequestMethod.POST)
    public String doPhotos(Locale locale, @ModelAttribute("photos") Photos photos, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("title",messageSource.getMessage("title",null,locale) );
        map.put("images",messageSource.getMessage("images",null,locale) );
        map.put("parent",messageSource.getMessage("parent",null,locale) );
        map.put("photoDescription",messageSource.getMessage("photoDescription",null,locale) );
        map.put("link",messageSource.getMessage("link",null,locale) );
        map.put("mark",messageSource.getMessage("mark",null,locale) );
        if (!bindingResult.hasErrors()) {
            Photos photosRes = new Photos();
            String s = action.toLowerCase();
            if (s.equals("add")) {
                photosService.add(photos);
                photosRes = photos;
            } else if (s.equals("edit")) {
                photosService.edit(photos);
                photosRes = photos;
            } else if (s.equals("delete")) {
                photosService.delete(photos.getIdPhoto());
                photosRes = new Photos();
            } else if (s.equals("search")) {
                Photos searchedPhotos = photosService.getPhotos(photos.getIdPhoto());
                photosRes = searchedPhotos != null ? searchedPhotos : new Photos();
            } else {
                return "redirect:/";
            }
            map.put("photos", photosRes);
            map.put("photosList", photosService.getAllPhotos());
            map.put("ok",messageSource.getMessage("page.from.oks",new String[]{messageSource.getMessage("images",null,locale)},locale) );
            return "photos";
        } else {
            map.put("error",messageSource.getMessage("page.from.errors",new String[]{messageSource.getMessage("images",null,locale)},locale) );
            return "photos";
        }
    }

}
