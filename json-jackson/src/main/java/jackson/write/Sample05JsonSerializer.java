package jackson.write;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import model.library.Book;
import model.library.Books;
import model.library.LibraryHelper;

import java.io.IOException;

/**
 * Un exemple d'utilisation d'un serializer Jackson.
 */
public class Sample05JsonSerializer {

    public static class MyJsonSerializer extends JsonSerializer<Object> {

        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            System.out.println(value);
            gen.writeString("COUCOU");
        }

    }

    public static void main(String[] args) throws JsonProcessingException {
        Book b = new Book();
        b.setAuthor("Jared Diamond");
        b.setPublisher("Gallimard");
        b.setTitle("Effondrement");

        Books bks = LibraryHelper.buildSampleLibrary();

        ObjectMapper om = new ObjectMapper();

        SimpleModule m = new SimpleModule();
        m.addSerializer(Book.class, new MyJsonSerializer());
        
        ObjectWriter writer = om.registerModule(m).writerFor(Books.class);

        System.out.println(writer.writeValueAsString(bks));


        //om.getTypeFactory().constructMapType()


    }


}
