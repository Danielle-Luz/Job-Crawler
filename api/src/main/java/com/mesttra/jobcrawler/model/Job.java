package com.mesttra.jobcrawler.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Job {
	@JsonProperty("id")
	int id;
	@JsonProperty("description")
	String description;
	@JsonProperty("stack")
	String stack;
	@JsonProperty("company")
	String company;
	@JsonProperty("jobName")
	String jobName;
	@JsonProperty("loaction")
	String location;
	@JsonProperty("typeOfWork")
	String typeOfWork;
	@JsonProperty("salary")
	double salary;
	@JsonProperty("link")
	String link;
	
	public Job () {
		
	}
	
	public Job(int id, String description, String stack, String company, String jobName, String typeOfWork, String location, double salary, String link) {
		this.id= id;
		this.description = description;
		this.stack = stack;
		this.company = company;
		this.jobName = jobName;
		this.location = location;
		this.typeOfWork = typeOfWork;
		this.salary = salary;
		this.link = link;
	}
	
	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getStack() {
		return stack;
	}

	public String getCompany() {
		return company;
	}

	public String getJobName() {
		return jobName;
	}

	public String getLocation() {
		return location;
	}

	public String getTypeOfWork() {
		return typeOfWork;
	}

	public double getSalary() {
		return salary;
	}

	public String getLink() {
		return link;
	}

}
