package chapter01thread_management.lesson06daemon_thread;

import java.util.Date;

public class Event {
	private Date date;
	private String event;

	public Date getDate() {
		return date;
	}

	public String getEvent() {
		return event;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setEvent(String event) {
		this.event = event;
	}

}
