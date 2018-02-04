package com.alert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.readJson.Event;

public class EventAlert {

	public List<Output> longestEvent(List<Event> list) {
		if (list == null || list.size() == 0) {
			return new ArrayList<Output>();
		}

		List<Output> res = new ArrayList<>();
		HashMap<String, List<Event>> record = new HashMap<>();

		for (Event event : list) {
			List<Event> eventList = record.getOrDefault(event.getId(), new ArrayList<>());
			eventList.add(event);
			record.put(event.getId(), eventList);
		}

		for (Entry<String, List<Event>> entry : record.entrySet()) {
			List<Event> tempList = entry.getValue();
			if (tempList.size() != 2) {
				continue;
			}
			
			if ((Math.abs(tempList.get(0).getTimestamp() - tempList.get(1).getTimestamp()) > 4)) {
				long duration = Math.abs(tempList.get(0).getTimestamp() - tempList.get(1).getTimestamp());
				Output output = new Output(entry.getKey(), duration, true);

				if (tempList.get(0).getHost() != null || tempList.get(0).getType() != null) {
					output.setHost(tempList.get(0).getHost());
					output.setType(tempList.get(0).getType());
				}

				res.add(output);
			}
		}
		return res;

	}

}
