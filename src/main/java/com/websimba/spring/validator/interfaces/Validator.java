package com.websimba.spring.validator.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

public interface Validator {
    public String ValidationMessages(String mes,String loc);
    public Date DateStr(String strDate,String format);
    public String getFileExtension(String fileName);
}
