package com.qa.data;

public class Users {
	String name;
	String job;
	String id;
	String createdAt;


	public Users(){		
	}


	public Users(String namee,String jobb){
		this.name = namee;
		this.job = jobb;			
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	/////getter and setters method





}
