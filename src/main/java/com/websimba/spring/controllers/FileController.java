package com.websimba.spring.controllers;

import com.websimba.spring.exceptions.BadFileException;
import com.websimba.spring.object.UploadedFile;
import com.websimba.spring.validator.FileValidator;
import com.websimba.spring.validator.interfaces.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

@Controller
@SessionAttributes(value={"filename"})
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileValidator fileValidator;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private Validator validator;

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView images(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("upload");
        return modelAndView;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView uploadFile(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult bindingResult, Locale locale) throws IOException, BadFileException {

        ModelAndView modelAndView = new ModelAndView();

        String fileName = null;

        MultipartFile file = uploadedFile.getFile();
        fileValidator.validate(uploadedFile, bindingResult);

        if (bindingResult.hasErrors()) {
            throw new BadFileException(messageSource.getMessage("file.not.selected",null,locale));
        } else {

                byte[] bytes = file.getBytes();

                fileName = file.getOriginalFilename();

                String rootPath = "D:\\Examples\\WebSimba\\src\\main\\webapp\\resources"; //System.getProperty("");
                File dir = null;
                if(validator.getFileExtension(fileName).equals("png")){
                     dir = new File( rootPath + File.separator + "images" + File.separator + "png");
                }else{
                     dir = new File( rootPath );
                }

                //существует
                //mkdir() - создает каталог, если до него в пути уже созданы родительские папки
                //mkdirs() - создает всю иерархию , если родительских папок не было , он создаст их.
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File loadFile = new File(dir.getAbsolutePath() + File.separator + fileName);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile));
                stream.write(bytes);
                stream.flush();
                stream.close();

                logger.info("uploaded: " + loadFile.getAbsolutePath());

                RedirectView redirectView = new RedirectView("fileuploaded");
                redirectView.setStatusCode(HttpStatus.FOUND);
                modelAndView.setView(redirectView);
                modelAndView.addObject("filename", fileName);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/fileuploaded", method = RequestMethod.GET)
    public String fileUploaded() {
        return "upload";
    }


}
