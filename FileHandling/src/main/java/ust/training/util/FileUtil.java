package ust.training.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import ust.training.model.Person;

import java.io.File;
import java.io.IOException;

public class FileUtil {

     static ObjectMapper objectMapper = new ObjectMapper();
     private static final String FILE_PATH = "src/main/resources/static/data.json";

    private static final String OUTPUT_FILE_PATH = "src/main/resources/static/output.json";

     public static Person readJsonFile() throws IOException{
         return objectMapper.readValue(new File(FILE_PATH), Person.class);

     }

     public static void writeJsonFile(Person person) throws IOException
     {
         objectMapper.writeValue(new File(OUTPUT_FILE_PATH),person);
     }
}
