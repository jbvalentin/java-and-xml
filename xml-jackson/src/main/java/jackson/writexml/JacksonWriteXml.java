package jackson.writexml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import model.library.Books;
import model.library.LibraryHelper;

public class JacksonWriteXml {

	public static void main(String[] args) {
		
		Books bks = LibraryHelper.buildSampleLibrary();
		
		XmlMapper xmlMapper = new XmlMapper();
		try {
			String xml = xmlMapper.writeValueAsString(bks);
			System.out.println(xml);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
	}



}
