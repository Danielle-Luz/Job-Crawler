package com.mesttra.jobcrawler.model;

public class Job {
	String company;
	String jobName;
	String location;
	String typeOfWork;
	Double salary;
	String link;
	
	public Job(String company, String jobName, String typeOfWork, String location, double salaryNumber, String link) {
		this.company = company;
		this.jobName = jobName;
		this.location = location;
		this.typeOfWork = typeOfWork;
		this.salary = salary;
		this.link = link;
	}

}
