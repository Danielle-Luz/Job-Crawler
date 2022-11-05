package com.mesttra.jobcrawler.model;

public class Job {
	String company;
	String jobName;
	String location;
	String typeOfWork;
	Double salary;
	String link;
	
	public Job(String company, String jobName, String typeOfWork, String location, double salary, String link) {
		this.company = company;
		this.jobName = jobName;
		this.location = location;
		this.typeOfWork = typeOfWork;
		this.salary = salary;
		this.link = link;
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

	public Double getSalary() {
		return salary;
	}

	public String getLink() {
		return link;
	}

}
