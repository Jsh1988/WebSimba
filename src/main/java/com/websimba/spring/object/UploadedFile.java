package com.websimba.spring.object;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {

    private static final Logger logger = LoggerFactory.getLogger(UploadedFile.class);

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }
    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
