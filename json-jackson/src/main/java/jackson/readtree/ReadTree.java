package jackson.readtree;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.db.DbHost;

import java.io.IOException;

public class ReadTree {

    public static void main(String[] args) {
        ObjectMapper o = new ObjectMapper();
        o.registerModule(new JavaTimeModule());
        try {
            DbHost db = o.readValue(ClassLoader.getSystemResourceAsStream("readjson/test3.json"), DbHost.class);
            System.out.println(db.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
