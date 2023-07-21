package jackson.testread;

import java.io.IOException;

import model.library.Book;
import model.library.Books;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlRead {

	public static void main(String[] args) {
		XmlMapper o = new XmlMapper();
		try {
			Book b = o.readValue(ClassLoader.getSystemResourceAsStream("readxml/test1.xml"), Book.class);
			System.out.println(b.getTitle());
			
			Books bs = o.readValue(ClassLoader.getSystemResourceAsStream("readxml/test2.xml"), Books.class);
			System.out.println(bs.getBooks().size());
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
