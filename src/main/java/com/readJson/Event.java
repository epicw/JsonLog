package com.readJson;

public class Event {
	private String id;
	private String state;
	private String type;
	private String host;
	private Long timestamp;
	
	public Event(String id, String state, String type, String host, Long timestamp) {
		this.id = id;
		this.state = state;
		this.type = type;
		this.host = host;
		this.timestamp = timestamp;
	}
	
	public String getId() {
		return id;
	}
	
	public String getState() {
		return state;
	}
		
	public String getType() {
		return type;
	}
		
	public String getHost() {
		return host;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", state=" + state + ", type=" + type + ", host=" + host + ", timestamp=" + timestamp
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
}
