package com.websimba.spring.controllers;

import com.websimba.spring.entity.Comments;
import com.websimba.spring.service.interfaces.CommentsService;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@Controller
public class CommentsController {

    private static final Logger logger = LoggerFactory.getLogger(CommentsController.class);

    @Autowired
    private CommentsService commentsService;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private Validator validator;

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public String comments(Map<String,Object> map, Locale locale){
        Comments comments = new Comments();
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("first_name",messageSource.getMessage("first_name",null,locale) );
        map.put("sur_name",messageSource.getMessage("sur_name",null,locale) );
        map.put("content",messageSource.getMessage("content",null,locale) );
        map.put("parent",messageSource.getMessage("parent",null,locale) );
        map.put("idProduct",messageSource.getMessage("idProduct",null,locale) );
        map.put("approved",messageSource.getMessage("approved",null,locale) );
        map.put("date",messageSource.getMessage("date",null,locale) );
        map.put("admin",messageSource.getMessage("admin",null,locale) );
        map.put("comments",comments);
        map.put("commentsList",commentsService.getAllComments());
        return "comments";
    }

    @RequestMapping(value="/comments.do", method=RequestMethod.POST)
    public String doComments(Locale locale, @ModelAttribute("comments") Comments comments, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            try {
                Date date = new Date();
                String s = action.toLowerCase();
                Comments commentsRes = new Comments();
                map.put("id", messageSource.getMessage("id", null, locale));
                map.put("first_name", messageSource.getMessage("first_name", null, locale));
                map.put("sur_name", messageSource.getMessage("sur_name", null, locale));
                map.put("content", messageSource.getMessage("content", null, locale));
                map.put("parent", messageSource.getMessage("parent", null, locale));
                map.put("idProduct", messageSource.getMessage("idProduct", null, locale));
                map.put("approved", messageSource.getMessage("approved", null, locale));
                map.put("date", messageSource.getMessage("date", null, locale));
                map.put("admin", messageSource.getMessage("admin", null, locale));
                map.put("format_timestamp", messageSource.getMessage("format_timestamp", null, locale));

                if (s.equals("add")) {
                    comments.setDate(date);
                    commentsService.add(comments);
                    commentsRes = comments;
                } else if (s.equals("edit")) {

                    comments.setDate(validator.DateStr(comments.getStrDate(),"yyyy-MM-dd HH:mm:ss"));
                    commentsService.edit(comments);
                    commentsRes = comments;
                } else if (s.equals("delete")) {
                    commentsService.delete(comments.getId());
                    commentsRes = new Comments();
                } else if (s.equals("search")) {
                    Comments searchedComments = commentsService.getComments(comments.getId());
                    commentsRes = searchedComments != null ? searchedComments : new Comments();
                } else {
                    map.put("error", messageSource.getMessage("page.from.errors", new String[]{messageSource.getMessage("comments", null, locale)}, locale));
                    return "comments";
                }

                map.put("comments", commentsRes);
                map.put("commentsList", commentsService.getAllComments());
                map.put("ok", messageSource.getMessage("page.from.oks", new String[]{messageSource.getMessage("comments", null, locale)}, locale));

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error comments");
            }
            return "comments";
        } else {
            map.put("error", messageSource.getMessage("page.from.errors", new String[]{messageSource.getMessage("comments", null, locale)}, locale));
            return "comments";
        }
    }
}
