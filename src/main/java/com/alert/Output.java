package com.alert;

public class Output {
	private String id;	
	private Long duration;	
	private String type;	
	private String host;	
	private boolean alert;	
	
	public Output(String id, Long duration, boolean alert) {	
		this.id = id;	
		this.duration = duration;	
		this.alert = alert;	
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getId() {
		return id;
	}

	public Long getDuration() {
		return duration;
	}

	public boolean isAlert() {
		return alert;
	}

	@Override
	public String toString() {
		return "Output [id=" + id + ", duration=" + duration + ", type=" + type + ", host=" + host + ", alert=" + alert
				+ "]";
	}

}
