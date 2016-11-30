package com.websimba.spring.controllers;

import com.websimba.spring.entity.Products;
import com.websimba.spring.service.interfaces.ProductsService;
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

import java.util.Date;
import java.util.Locale;
import java.util.Map;

@Controller
public class ProductsController {

    private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    private ProductsService productsService;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private Validator validator;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(Map<String,Object> map, Locale locale){
        Products products = new Products();
        map.put("id",messageSource.getMessage("id",null,locale) );
        map.put("title",messageSource.getMessage("title",null,locale) );
        map.put("alias",messageSource.getMessage("alias",null,locale) );
        map.put("parent",messageSource.getMessage("parent",null,locale) );
        map.put("description",messageSource.getMessage("description",null,locale) );
        map.put("content",messageSource.getMessage("content",null,locale) );
        map.put("images",messageSource.getMessage("images",null,locale) );
        map.put("price",messageSource.getMessage("price",null,locale) );
        map.put("keywords",messageSource.getMessage("keywords",null,locale) );
        map.put("date",messageSource.getMessage("date",null,locale) );
        map.put("hosts",messageSource.getMessage("hosts",null,locale) );
        map.put("views",messageSource.getMessage("views",null,locale) );

        map.put("products",products);
        map.put("productsList",productsService.getAllProducts());
        return "products";
    }

    @RequestMapping(value="/products.do", method=RequestMethod.POST)
    public String doProducts(Locale locale, @ModelAttribute("products") Products products, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            try {
                Date date = new Date();
                String s = action.toLowerCase();
                Products productsRes = new Products();

                map.put("id",messageSource.getMessage("id",null,locale) );
                map.put("title",messageSource.getMessage("title",null,locale) );
                map.put("alias",messageSource.getMessage("alias",null,locale) );
                map.put("parent",messageSource.getMessage("parent",null,locale) );
                map.put("description",messageSource.getMessage("description",null,locale) );
                map.put("content",messageSource.getMessage("content",null,locale) );
                map.put("images",messageSource.getMessage("images",null,locale) );
                map.put("price",messageSource.getMessage("price",null,locale) );
                map.put("keywords",messageSource.getMessage("keywords",null,locale) );
                map.put("date",messageSource.getMessage("date",null,locale) );
                map.put("hosts",messageSource.getMessage("hosts",null,locale) );
                map.put("views",messageSource.getMessage("views",null,locale) );

                if (s.equals("add")) {
                    products.setDate(date);
                    productsService.add(products);
                    productsRes = products;
                } else if (s.equals("edit")) {

                    products.setDate(validator.DateStr(products.getStrDate(),"yyyy-MM-dd"));
                    productsService.edit(products);
                    productsRes = products;
                } else if (s.equals("delete")) {
                    productsService.delete(products.getId());
                    productsRes = new Products();
                } else if (s.equals("search")) {
                    Products searchedProducts = productsService.getProducts(products.getId());
                    productsRes = searchedProducts != null ? searchedProducts : new Products();
                } else {
                    map.put("error", messageSource.getMessage("page.from.errors", new String[]{messageSource.getMessage("products", null, locale)}, locale));
                    return "products";
                }

                map.put("products", productsRes);
                map.put("productsList", productsService.getAllProducts());
                map.put("ok", messageSource.getMessage("page.from.oks", new String[]{messageSource.getMessage("products", null, locale)}, locale));

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error products");
            }
            return "products";
        } else {
            map.put("error", messageSource.getMessage("page.from.errors", new String[]{messageSource.getMessage("products", null, locale)}, locale));
            return "products";
        }
    }

}
