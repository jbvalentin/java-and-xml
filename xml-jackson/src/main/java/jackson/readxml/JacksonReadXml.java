package jackson.readxml;

import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import model.library.Book;
import model.library.Books;

public class JacksonReadXml {

    public static void main(String[] args) {
        XmlMapper o = new XmlMapper();
		try {
			Book b = o.readValue(ClassLoader.getSystemResourceAsStream("readxml/test1.xml"), Book.class);
			System.out.println(b.getTitle());
			
			Books bs = o.readValue(ClassLoader.getSystemResourceAsStream("readxml/test2.xml"), Books.class);
			System.out.println(bs.getBooks().size());
			
		} catch (IOException e) {
			e.printStackTrace();
		}


    }
}
