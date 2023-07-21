package jackson.readtree;

import java.io.IOException;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.db.DbHost;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReadTree {
	
	@BeforeAll
	public static void initializeObject() {
		System.out.println("Init obj");
	}
	
	@BeforeAll
	public void initializeOther() {
		System.out.println("Init other");
	}
	
	@Test
	public void readJsonSubElements() {
		ObjectMapper o = new ObjectMapper();
		o.registerModule(new JavaTimeModule());
		try {
			DbHost db = o.readValue(ClassLoader.getSystemResourceAsStream("readjson/test3.json"), DbHost.class);
			
			System.out.println(db.toString());
			
			assertEquals("localhost", db.getServer());
			assertEquals(8001, db.getPort());
			
			assertEquals("admin", db.getDefaultUser().getLogin());
			assertEquals("adm1n$", db.getDefaultUser().getPassword());
			//assertEquals(5, db.getTimeoutDuration().toMillis());
			assertEquals(3, db.getLicenseDuration().getDays());
			assertEquals(2, db.getDatabases().size());
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
