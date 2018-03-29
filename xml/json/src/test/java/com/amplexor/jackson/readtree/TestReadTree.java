package com.amplexor.jackson.readtree;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amplexor.beans.db.DbHost;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertEquals;

public class TestReadTree {
	
	@BeforeClass
	public static void initializeObject() {
		System.out.println("Init obj");
	}
	
	@Before
	public void initializeOther() {
		System.out.println("Init other");
	}
	
	@Test
	public void readJsonSubElements() {
		ObjectMapper o = new ObjectMapper();
		try {
			DbHost db = o.readValue(ClassLoader.getSystemResourceAsStream("readjson/test3.json"), DbHost.class);
			
			System.out.println(db.toString());
			
			assertEquals("localhost", db.getServer());
			assertEquals(8001, db.getPort());
			
			assertEquals("admin", db.getDefaultUser().getLogin());
			assertEquals("adm1n$", db.getDefaultUser().getPassword());
			
			assertEquals(2, db.getDatabases().size());
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void stupidTest() {
		assertEquals(true, true);
	}
	

}
