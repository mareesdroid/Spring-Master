package com.mars.entity;

public class Response {

	private int status;
	private String response;
	private long timeStamp;
	
	
	public Response() {
		
	}
	
	public Response(int status, String response, long timeStamp) {
		this.status = status;
		this.response = response;
		this.timeStamp = timeStamp;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public String getResponse() {
		return response;
	}

	public long getTimeStamp() {
		return timeStamp;
	}
	
	

}
