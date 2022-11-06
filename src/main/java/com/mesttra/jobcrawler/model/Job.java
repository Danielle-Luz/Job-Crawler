package com.mesttra.jobcrawler.model;

public class Job {
	int id;
	String description;
	String stack;
	String company;
	String jobName;
	String location;
	String typeOfWork;
	String salary;
	String link;
	
	public Job(int id, String description, String stack, String company, String jobName, String typeOfWork, String location, String salary, String link) {
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

	public String getSalary() {
		return salary;
	}

	public String getLink() {
		return link;
	}

}
