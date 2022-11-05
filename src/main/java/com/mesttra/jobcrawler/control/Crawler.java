package com.mesttra.jobcrawler.control;

import com.mesttra.jobcrawler.model.Job;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Crawler {

    String url;

    public Crawler(String url) {
    	ObjectMapper parser = new ObjectMapper();
    	
    	String parsedUrl = "";
    	
    	try {
			JsonNode node = parser.readTree(url);
			parsedUrl = node.get("url").asText();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        this.url = parsedUrl;
    }

    public Job createJobFromElement (Element element, String jobName) {
    	String company = element.select(".job__company").text();
    	String typeOfWork = element.select(".jobview__container__status").text();
    	String link = "https://www.trabalhabrasil.com.br/" + element.select(".job__vacancy").attr("href");
    	
    	Elements jobDetails = element.getElementsByClass("job__detail");
    	String location = jobDetails.get(0).text();
    	
    	String salary = "Salário não informado";
    	
    	boolean hasSalaryInfo = jobDetails.size() == 2;
    	
    	if (hasSalaryInfo) {
    		salary = jobDetails.get(0).text();
    		
    		location = jobDetails.get(1).text();
    	}
    	
    	if (typeOfWork.isEmpty()) {
    		typeOfWork = "Não informado";
    	}
    	
    	Job foundJob = new Job(company, jobName, typeOfWork, location, salary, link);
    	
    	return foundJob;
    }
    
    public List<Job> getPageDevJobs() {
        List<Job> devJobs = new ArrayList<>();

        try {
            Document page = Jsoup.connect(this.url).get();

            List<Element> elementsList = page.body().getElementsByClass("jg__job");

            for (Element element : elementsList) {
                String jobName = element.select(".job__name").text();

                Pattern pattern = Pattern.compile("desenvolvedor|programador|desenvolvimento", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(jobName);

                if (matcher.find()) {
                	
                	Job foundJob = createJobFromElement(element, jobName);
                	
                	devJobs.add(foundJob);
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }

        return devJobs;
    }
}
