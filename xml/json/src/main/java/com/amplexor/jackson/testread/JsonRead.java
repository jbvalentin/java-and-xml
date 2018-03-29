package com.amplexor.jackson.testread;

import java.io.IOException;

import com.amplexor.beans.library.Book;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRead {

	public static void main(String[] args) {
		ObjectMapper o = new ObjectMapper();
		try {
			Book b = o.readValue(ClassLoader.getSystemResourceAsStream("readjson/test1.json"), Book.class);
			System.out.println(b.getTitle());
			
			Book[] bArray = o.readValue(ClassLoader.getSystemResourceAsStream("readjson/test2.json"), Book[].class);
			System.out.println(bArray.length);
			
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
