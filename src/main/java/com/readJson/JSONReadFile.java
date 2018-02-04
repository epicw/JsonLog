package com.readJson;

import java.util.*;
import java.io.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.alert.EventAlert;
import com.alert.Output;


public class JSONReadFile {

	private static JSONParser parser = new JSONParser();
	private static BufferedReader bufferReader;
	
	public Event getEvent(String json) throws ParseException {
		JSONObject jsonObject;
		
		jsonObject = (JSONObject) parser.parse(json);
		String id = (String)jsonObject.get("id");
        String state = (String) jsonObject.get("state");
        String type = (String) jsonObject.get("type");
        String host = (String) jsonObject.get("host");
        long timestamp = (long) jsonObject.get("timestamp");
		
        return new Event(id, state, type, host, timestamp);
	}
	
	public List<Event> readFromFile(String fileName) throws IOException, ParseException {
		ClassLoader classLoader = this.getClass().getClassLoader();
    	File file = new File(classLoader.getResource(fileName).getFile());
    		
		bufferReader = new BufferedReader(new FileReader(file));
        String readLine = "";
        List<Event> eventList = new ArrayList<>();
        
        System.out.println("Reading file using Buffered Reader");
        
        while ((readLine = bufferReader.readLine()) != null) {
        	String line = readLine.replace("type", "\"type\"")
        					.replace("host", "\"host\"");
            //System.out.println(line);
            eventList.add(getEvent(line));
        }
        
        return eventList;
	}
	
	
	public static void main(String[] args) {
    
		JSONReadFile j = new JSONReadFile();
		
        try {
        	List<Event> eventList = j.readFromFile("test.json");
        	/*if (eventList != null) {
        		for (Event e: eventList) {
        			System.out.println(e);
        		}
        	}*/
        	
        	EventAlert alert = new EventAlert();
        	List<Output> outputList = alert.longestEvent(eventList);
        	
        	if (outputList != null) {
        		for (Output o: outputList) {
        			System.out.println(o);
        		}
        	}

        } catch (IOException e) {
            e.printStackTrace();
            
        } catch (ParseException e) {
			e.printStackTrace();
		}

    }

}