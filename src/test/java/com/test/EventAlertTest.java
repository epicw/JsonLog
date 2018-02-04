package com.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.alert.EventAlert;
import com.alert.Output;
import com.readJson.Event;

public class EventAlertTest {
	private static EventAlert eventAlert;
	
	@BeforeClass
	public static void init() {
		eventAlert = new EventAlert();
	}
	
	@Test
	public void testOne() {
		List<Event> eventList = new ArrayList<>();
		Event e1 = new Event("scsmbstgra", "STARTED", "APPLICATION_LOG", null, 1491377495212L);
		Event e2 = new Event("scsmbstgra", "FINISHED", "APPLICATION_LOG", null, 1491377495212L);
		
		eventList.add(e1);
		eventList.add(e2);
		
		List<Output> resultList = new ArrayList<>();
		Output o = new Output("scsmbstgra", 5L, true);
		o.setType("APPLICATION_LOG");
		
		List<Output> outputList = eventAlert.longestEvent(eventList);
		
		assertEquals(resultList, outputList);
	}
	
	@Test
	public void testTwo() {
		List<Event> eventList = new ArrayList<>();
		Event e1 = new Event("scsmbstgra", "STARTED", "APPLICATION_LOG", null, 1491377495212L);
		Event e2 = new Event("scsmbstgra", "FINISHED", "APPLICATION_LOG", null, 1491377495212L);
		Event e3 = new Event("scsmbstgrb", "STARTED", "APPLICATION_LOG", null, 1491377495217L);
		
		eventList.add(e1);
		eventList.add(e2);
		eventList.add(e3);
		
		List<Output> resultList = new ArrayList<>();
		Output o = new Output("scsmbstgra", 5L, true);
		o.setType("APPLICATION_LOG");
		
		List<Output> outputList = eventAlert.longestEvent(eventList);
		
		for (Output output: outputList) {
			System.out.println(output);
		}
		
		assertEquals(resultList, outputList);
	}
}
