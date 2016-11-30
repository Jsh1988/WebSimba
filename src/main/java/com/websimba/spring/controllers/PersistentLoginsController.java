package com.websimba.spring.controllers;

import com.websimba.spring.entity.PersistentLogins;
import com.websimba.spring.service.interfaces.PersistentLoginsService;
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
public class PersistentLoginsController {

    private static final Logger logger = LoggerFactory.getLogger(PersistentLoginsController.class);

    @Autowired
    private PersistentLoginsService persistentLoginsService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/persistent", method = RequestMethod.GET)
    public String persistent(Map<String,Object> map, Locale locale){
        PersistentLogins persistent = new PersistentLogins();
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("user",messageSource.getMessage("user",null,locale) );
        map.put("series",messageSource.getMessage("series",null,locale) );

        map.put("persistent",persistent);
        map.put("persistentList",persistentLoginsService.getAllPersistentLogins());
        return "persistent";
    }

    @RequestMapping(value="/persistent.do", method=RequestMethod.POST)
    public String doPersistent(Locale locale, @ModelAttribute("persistent") PersistentLogins persistent, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            try {

                PersistentLogins persistentLoginsRes = new PersistentLogins();

                map.put("id",messageSource.getMessage("id",null,locale) );
                map.put("user",messageSource.getMessage("user",null,locale) );
                map.put("series",messageSource.getMessage("series",null,locale) );
                String s = action.toLowerCase();
                if (s.equals("delete")) {
//                    System.out.println(persistent.getUsername());
                    persistentLoginsService.delete(persistent.getUsername());
                    persistentLoginsRes = new PersistentLogins();
                } else {
                    map.put("error", messageSource.getMessage("page.from.errors", new String[]{messageSource.getMessage("persistentLogins", null, locale)}, locale));
                    return "persistent";
                }

                map.put("persistent", persistentLoginsRes);
                map.put("persistentList", persistentLoginsService.getAllPersistentLogins());
                map.put("ok", messageSource.getMessage("page.from.oks", new String[]{messageSource.getMessage("persistentLogins", null, locale)}, locale));

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error persistentLogins");
            }
            return "persistent";
        } else {
            map.put("error", messageSource.getMessage("page.from.errors", new String[]{messageSource.getMessage("persistentLogins", null, locale)}, locale));
            return "persistent";
        }
    }

}
