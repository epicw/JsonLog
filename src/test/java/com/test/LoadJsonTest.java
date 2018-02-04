package com.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.junit.BeforeClass;
import org.junit.Test;

import com.readJson.Event;
import com.readJson.JSONReadFile;

public class LoadJsonTest {
	private static final Logger logger = LogManager.getLogger("LoadJsonTest");
	
	private static JSONReadFile reader;
	
	@BeforeClass
	public static void init() {
		reader = new JSONReadFile();
	} 
	
	@Test
	public void testReadFromFile() {
		String fileName = "test.json";
		try {
			List<Event> eventList = reader.readFromFile(fileName);
			for (Event event: eventList) {
				logger.info(event);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetEvent() {
		String json = "{\"id\":\"scsmbstgra\", " + 
				"\"state\":\"STARTED\", " + 
				"\"type\":\"APPLICATION_LOG\", " + 
				"\"timestamp\":1491377495212}";
		
		Event result = new Event("scsmbstgra", "STARTED", "APPLICATION_LOG", null, 1491377495212L);
		
		try {
			Event event = reader.getEvent(json);
			assertEquals(result, event);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
