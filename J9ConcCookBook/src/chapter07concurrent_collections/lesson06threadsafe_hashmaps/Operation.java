package chapter07concurrent_collections.lesson06threadsafe_hashmaps;

import java.util.Date;

public class Operation {
	public String user;
	public String operation;
	public Date time;

	public String getUser() {
		return user;
	}

	public String getOperation() {
		return operation;
	}

	public Date getTime() {
		return time;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
