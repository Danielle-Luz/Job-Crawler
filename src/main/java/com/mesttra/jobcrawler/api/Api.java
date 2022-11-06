package com.mesttra.jobcrawler.api;

import com.mesttra.jobcrawler.control.*;
import com.mesttra.jobcrawler.model.Job;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@RequestMapping(value = "/trabalhos", produces = MediaType.APPLICATION_JSON_VALUE)
public class Api {

    @PostMapping
    @ResponseBody
    @CrossOrigin( origins = "http://localhost:8080")
    public List<Job> getJobsFromUrl (@RequestBody String url, HttpServletRequest request, HttpServletResponse response) {
    	response.setHeader("Access-Control-Allow-Origin", request.getHeader(HttpHeaders.ORIGIN));
    	
        Crawler crawler = new Crawler(url);
        return crawler.getPageDevJobs();
    }
}

