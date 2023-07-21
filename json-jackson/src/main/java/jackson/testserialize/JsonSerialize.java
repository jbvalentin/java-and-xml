package jackson.testserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.library.Books;
import model.library.LibraryHelper;

public class JsonSerialize {

    public static void main(String[] args) {
        Books bks = LibraryHelper.buildSampleLibrary();


        System.out.println(toJsonBasic(bks));
        System.out.println(toJsonIndented(bks));

    }

    public static String toJsonBasic(Object o) {
        ObjectMapper m = new ObjectMapper();
        try {
            return m.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static String toJsonWithoutNulls(Object o) {
//        ObjectMapper m = new ObjectMapper();
//        m.configure(SerializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        return "";
//    }


    public static String toJsonIndented(Object o) {
        ObjectMapper m = new ObjectMapper();
        m.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            return m.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

    }
}
