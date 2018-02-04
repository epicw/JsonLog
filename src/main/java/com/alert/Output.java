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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Output other = (Output) obj;
		if (alert != other.alert)
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
