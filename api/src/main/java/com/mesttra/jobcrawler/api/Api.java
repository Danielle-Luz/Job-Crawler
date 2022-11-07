package com.mesttra.jobcrawler.api;

import com.mesttra.jobcrawler.control.*;
import com.mesttra.jobcrawler.model.Job;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class Api {
	
    @Autowired
    Email sendEmail;
    List<Job> jobList = null;
	
	
	@RequestMapping(value = "/trabalhos", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    @ResponseBody
    @CrossOrigin(origins = "*")
    public List<Job> getJobsFromUrl (@RequestBody String url) {
        Crawler crawler = new Crawler(url);
        List<Job> foundJobs = crawler.getPageDevJobs();
        
        jobList = foundJobs;
        
        return foundJobs;
    }
	
	@RequestMapping(value = "/email", produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping
    @ResponseBody
    @CrossOrigin(origins = "*")
	public HashMap<String, Boolean> getEmail (@RequestBody String email) {
		HashMap<String, Boolean> status = new HashMap<>();
		
		try {
			if (jobList != null) {
				sendEmail.setEmail(email);
				
				status.put("sucess", true);
				
				if (sendEmail.receivesEmails()) {
					sendEmail.sendFoundJobsRelatory(jobList);
				}
				
				return status;				
			} else {
				throw new Exception();
			}
		} catch (Exception ex) {
			status.put("sucess", false);
			
			return status;
		}
	}
}

