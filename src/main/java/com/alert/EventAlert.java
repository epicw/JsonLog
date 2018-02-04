package com.alert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.readJson.Event;

public class EventAlert {

	public List<Output> longestEvent(List<Event> list) {	

		if(list == null || list.size() == 0) {

			return new ArrayList<Output>();

		}

		

		List<Output> res = new ArrayList<>();

		

		HashMap<String, List<Event>> record = new HashMap<>();

		

		for(Event event : list) {

			

			if(!record.containsKey(event.getId())) {

				record.put(event.getId(), new ArrayList<Event>());

			}

			record.get(event.getId()).add(event);

		}

		

		for(Entry<String, List<Event>> entry : record.entrySet()) {

			List<Event> tempList = entry.getValue();

			if((Math.abs(tempList.get(0).getTimestamp() - tempList.get(1).getTimestamp()) > 4)) {

				long duration = Math.abs(tempList.get(0).getTimestamp() - tempList.get(1).getTimestamp());

				Output output = new Output(entry.getKey(), duration, true);

				

				if(tempList.get(0).getHost() != null || tempList.get(0).getType() != null) {

					output.host = tempList.get(0).getHost();

					output.type = tempList.get(0).getType();

				}

				

				res.add(output);

			}

		}

		

		return res;

		

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
