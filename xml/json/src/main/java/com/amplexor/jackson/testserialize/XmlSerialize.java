package com.amplexor.jackson.testserialize;

import java.util.Arrays;

import com.amplexor.beans.library.Book;
import com.amplexor.beans.library.Books;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlSerialize {

	public static void main(String[] args) {
		
		Books bks = new Books();
		Book b1 = new Book();
		b1.setAuthor("author 1");
		b1.setTitle("title 1");
		
		Book b2 = new Book();
		b2.setAuthor("author 2");
		b2.setTitle("title 2");

		bks.setBooks(Arrays.asList(b1, b2));
		
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
