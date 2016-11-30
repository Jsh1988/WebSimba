package com.websimba.spring.object;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.websimba.spring.entity.Users;
import com.websimba.spring.object.interfaces.ConverterJsonFile;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class Converter implements ConverterJsonFile {

    private static final Logger logger = LoggerFactory.getLogger(Converter.class);

    //запись в файл json
    @Override
    public  void toJSON(Object obj,String str) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(str), obj);
    }

    //читать с файла json
    @Override
    public  Object toJavaObject(Object obj,String str) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(str), Users.class);
    }

    //парсить json
    @Override
    public String JSONObject(String json,String result) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);
        JSONObject jsonObj = (JSONObject) obj;
        return (String) jsonObj.get(result);
    }

    //проверка файла
    @Override
    public void exists(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }

    //читать файл
    @Override
    public String read(String fileName) throws IOException {
        //Этот спец. объект для построения строки
        StringBuilder stringBuilder = new StringBuilder();

        exists(fileName);

        try {
            File file = new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    stringBuilder.append(str);
                    stringBuilder.append("\n");
                }
            } finally {
                bufferedReader.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    //обновить файл
    @Override
    public void update(String nameFile, String newText, int noOfLines) throws IOException {
        File file = new File(nameFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            //для обновления файла нужно инициализировать FileWriter с помощью этого конструктора
            fileWriter = new FileWriter(file,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(int i = 0; i < noOfLines; i++){
                bufferedWriter.newLine();
                //теперь мы можем использовать метод write или метод append
                bufferedWriter.write(newText);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //удалить файл
    @Override
    public void delete(String nameFile) throws IOException {
        exists(nameFile);
        new File(nameFile).delete();
    }


}
