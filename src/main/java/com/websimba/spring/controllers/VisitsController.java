package com.websimba.spring.controllers;

import com.websimba.spring.entity.Visits;
import com.websimba.spring.service.interfaces.VisitsService;
import com.websimba.spring.validator.interfaces.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@Controller
public class VisitsController {

    private static final Logger logger = LoggerFactory.getLogger(VisitsController.class);

    @Autowired
    private VisitsService visitsService;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private Validator validator;

    @RequestMapping(value = "/visits", method = RequestMethod.GET)
    public String visits(Map<String,Object> map, Locale locale){
        Visits visits = new Visits();
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("date",messageSource.getMessage("date",null,locale) );
        map.put("hosts",messageSource.getMessage("hosts",null,locale) );
        map.put("views",messageSource.getMessage("views",null,locale) );
        map.put("visits",visits);
        map.put("visitsList",visitsService.getAllVisits());
        return "visits";
    }
    @RequestMapping(value="/visits.do", method=RequestMethod.POST)
    public String doVisits(Locale locale, @ModelAttribute("visits") Visits visits, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            try {
                Date date = new Date();
                String s = action.toLowerCase();
                Visits visitsRes = new Visits();
                map.put("id", messageSource.getMessage("id", null, locale));
                map.put("date", messageSource.getMessage("date", null, locale));
                map.put("hosts", messageSource.getMessage("hosts", null, locale));
                map.put("views", messageSource.getMessage("views", null, locale));
                map.put("format_date", messageSource.getMessage("format_date", null, locale));

                if (s.equals("add")) {
                    visits.setDate(date);
                    visitsService.add(visits);
                    visitsRes = visits;
                } else if (s.equals("edit")) {

                    visits.setDate(validator.DateStr(visits.getStrDate(),"yyyy-MM-dd"));
                    visitsService.edit(visits);
                    visitsRes = visits;
                } else if (s.equals("delete")) {
                    visitsService.delete(visits.getId());
                    visitsRes = new Visits();
                } else if (s.equals("search")) {
                    Visits searchedVisits = visitsService.getVisits(visits.getId());
                    visitsRes = searchedVisits != null ? searchedVisits : new Visits();
                } else {
                    map.put("error", messageSource.getMessage("page.from.errors", new String[]{messageSource.getMessage("visits", null, locale)}, locale));
                    return "visits";
                }

                map.put("visits", visitsRes);
                map.put("visitsList", visitsService.getAllVisits());
                map.put("ok", messageSource.getMessage("page.from.oks", new String[]{messageSource.getMessage("visits", null, locale)}, locale));

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error visits");
            }
            return "visits";
        }else {
            map.put("error",messageSource.getMessage("page.from.errors",new String[]{messageSource.getMessage("visits",null,locale)},locale) );
            return "visits";
        }
    }
}
