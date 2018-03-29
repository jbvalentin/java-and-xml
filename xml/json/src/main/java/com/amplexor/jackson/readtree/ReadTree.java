package com.amplexor.jackson.readtree;

import java.io.IOException;

import com.amplexor.beans.db.DbHost;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadTree {

	public static void main(String[] args) {
		ObjectMapper o = new ObjectMapper();
		try {
			DbHost db = o.readValue(ClassLoader.getSystemResourceAsStream("readjson/test3.json"), DbHost.class);
			
			System.out.println(db.toString());
			
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
