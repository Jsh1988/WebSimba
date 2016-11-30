package com.websimba.spring.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

@Component("validator")
public class Validator implements com.websimba.spring.validator.interfaces.Validator{

    private static final Logger logger = LoggerFactory.getLogger(Validator.class);

    @Override
    public String ValidationMessages(String mes,String loc){
        if(loc.equals("русский")){
            ResourceBundle res = ResourceBundle.getBundle("ValidationMessages_ru");
            return res.getString(mes);
        }else{
            ResourceBundle res = ResourceBundle.getBundle("ValidationMessages_en");
            return res.getString(mes);
        }
    }
    @Override
    public Date DateStr(String strDate,String format){
        Date date = new Date();
        if (strDate.equals("")) {
            return new Date();
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            try {
                 date = simpleDateFormat.parse(strDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }
    }

    //метод определения расширения файла
    @Override
    public String getFileExtension(String fileName) {
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".")+1);
        }else{
            // в противном случае возвращаем заглушку, то есть расширение не найдено
            return "";
        }
    }

}
