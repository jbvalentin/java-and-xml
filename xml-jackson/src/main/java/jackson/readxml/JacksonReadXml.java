package jackson.readxml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.library.Book;
import model.library.Books;
import model.library.Shelf;

import java.io.IOException;

public class JacksonReadXml {

    public static void main(String[] args) {
        XmlMapper o = new XmlMapper();
        try {
            Book b = o.readValue(ClassLoader.getSystemResourceAsStream("readxml/test1.xml"), Book.class);
            System.out.println(b.getTitle());

            // Read a list of books
            Books bs = o.readValue(ClassLoader.getSystemResourceAsStream("readxml/test2.xml"), Books.class);
            System.out.println(bs.getBooks().size());

            Shelf s = o.readValue(ClassLoader.getSystemResourceAsStream("readxml/shelf.xml"), Shelf.class);
            s.getBook().forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
