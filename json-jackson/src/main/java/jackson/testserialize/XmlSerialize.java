package jackson.testserialize;

import model.library.Book;
import model.library.Books;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.library.LibraryHelper;

public class XmlSerialize {

	public static void main(String[] args) {
		
		Books bks = LibraryHelper.buildSampleLibrary();
		
		ObjectMapper xmlMapper = new XmlMapper();
		try {
			String xml = xmlMapper.writeValueAsString(bks);
			System.out.println(xml);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
