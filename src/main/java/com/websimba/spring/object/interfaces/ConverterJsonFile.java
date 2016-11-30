package com.websimba.spring.object.interfaces;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface ConverterJsonFile {
    public  void toJSON(Object obj,String str) throws IOException;
    public  Object toJavaObject(Object obj,String str) throws IOException;
    public String JSONObject(String json,String result) throws ParseException;
    public void exists(String fileName) throws IOException;
    public String read(String fileName) throws IOException;
    public void update(String nameFile, String newText, int noOfLines) throws IOException;
    public void delete(String nameFile) throws IOException;
}
