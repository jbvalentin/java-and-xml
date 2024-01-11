package jackson.write;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;

import java.util.Map;

public class Sample06JsonFormatVisitor {

    public static void main(String[] args) {
        ObjectMapper om = new ObjectMapper();

        JsonFormatVisitorWrapper v = new JsonFormatVisitorWrapper.Base() {

        };

        try {
            om.acceptJsonFormatVisitor(Map.class, v);


        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        }
    }
}
