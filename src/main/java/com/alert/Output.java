package com.alert;

public class Output {
	String id;
	
	Long duration;
	
	String type;
	
	String host;
	
	boolean alert;
	
	
	public Output(String id, Long duration, boolean alert) {
	
		this.id = id;
	
		this.duration = duration;
	
		this.alert = alert;
	
	}


	@Override
	public String toString() {
		return "Output [id=" + id + ", duration=" + duration + ", type=" + type + ", host=" + host + ", alert=" + alert
				+ "]";
	}

}
