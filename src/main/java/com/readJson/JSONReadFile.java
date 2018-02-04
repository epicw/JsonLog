package com.readJson;

import java.util.*;
import java.io.*;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.alert.EventAlert;
import com.alert.Output;
import com.persistence.HSQLDBUtility;


public class JSONReadFile {
	private static final Logger logger = LogManager.getLogger("JSONReadFile");
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
		File file = new File(fileName);
		bufferReader = new BufferedReader(new FileReader(file));
        String readLine = "";
        List<Event> eventList = new ArrayList<>();
        
        logger.info("Reading file using Buffered Reader");
        
        while ((readLine = bufferReader.readLine()) != null) {
        	String line = readLine.replace("type", "\"type\"")
        					.replace("host", "\"host\"");
        	
            eventList.add(getEvent(line));
        }
        
        return eventList;
	}
	
	
	public static void main(String[] args) {
    
		JSONReadFile j = new JSONReadFile();
		
		if (args == null || args.length == 0) {
			System.out.println("Please type a file name!");
		} 
		
		String fileName = args[0];
		
        try {
        	List<Event> eventList = j.readFromFile(fileName);
        	
        	EventAlert alert = new EventAlert();
        	List<Output> outputList = alert.longestEvent(eventList);
        	
        	if (outputList != null && outputList.size() != 0) {
        		HSQLDBUtility utility = new HSQLDBUtility();
        		
        		if (utility.getConnection() == null) {
        			utility.createTable();
        		}
        		
        		for (Output o: outputList) {
        			logger.info(o);
        			utility.saveEvent(o);
        		}
        		
        		logger.info("Save Event alert to HSQLDB successfully!");
        		
        		utility.closeConnection();
        	}

        } catch (IOException e) {
            e.printStackTrace();
            
        } catch (ParseException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

    }

}