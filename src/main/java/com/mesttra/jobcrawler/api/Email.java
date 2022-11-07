package com.mesttra.jobcrawler.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mesttra.jobcrawler.model.Job;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class Email {
	private boolean receivesEmails = false;
	private String email = "";
	
	 @Autowired
	private JavaMailSender sender;
	
	public String setFoundJobsRelatory (List<Job> foundJobs) {
		String fullEmail = 
				"<!DOCTYPE html>\r\n"
				+ "<html lang=\"pt-br\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Job Crawler</title>\r\n"
				+ "    <style>\r\n"
				+ "      @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap');\r\n"
				+ "\r\n"
				+ "      * {\r\n"
				+ "        box-sizing: border-box;\r\n"
				+ "        font-family: 'Poppins', sans-serif;\r\n"
				+ "        margin: 0;\r\n"
				+ "        padding: 0;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      body {\r\n"
				+ "        padding: var(--spacing-1) var(--spacing-3);\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      :root {\r\n"
				+ "        --color-brand: #2D6ED0;\r\n"
				+ "        --color-grey-1: #1E1E1E;\r\n"
				+ "        --color-grey-2: #495057;\r\n"
				+ "        --color-grey-3: #868E96;\r\n"
				+ "        --color-grey-4: #DEE2E6;\r\n"
				+ "        --color-grey-5: #F1F3F5;\r\n"
				+ "        --color-grey-6: #F8F9FA;\r\n"
				+ "\r\n"
				+ "        --size-1: 1.875rem; /* 30px */ \r\n"
				+ "        --size-2: 1.375rem; /* 22px */\r\n"
				+ "        --size-3: 1rem; /* 16px */\r\n"
				+ "        --size-4: 0.875rem; /* 14px */\r\n"
				+ "\r\n"
				+ "        --spacing-1: 2.375rem; /* 38px */\r\n"
				+ "        --spacing-2: 1.75rem; /* 28px */\r\n"
				+ "        --spacing-3: 1.125rem; /* 18px */\r\n"
				+ "        --spacing-4: 0.75rem; /* 13px */\r\n"
				+ "\r\n"
				+ "        --radius-1: 0.5rem;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .container {\r\n"
				+ "        max-width: 820px;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .card-container {\r\n"
				+ "        margin-top: calc(var(--spacing-2)*2);\r\n"
				+ "        row-gap: var(--spacing-1);\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .card {\r\n"
				+ "        background-color: var(--color-grey-6);\r\n"
				+ "        border-radius: var(--radius-1);\r\n"
				+ "        padding: var(--spacing-1) var(--spacing-3);\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .card ul {\r\n"
				+ "        list-style: none;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .card .button-brand {\r\n"
				+ "        padding: 0.4375rem 1.75rem;\r\n"
				+ "        text-decoration: none;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .card .title-size-2  {\r\n"
				+ "        margin-bottom: var(--spacing-3);\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .card .text-size-1 {\r\n"
				+ "        display: block; \r\n"
				+ "        display: -webkit-box;\r\n"
				+ "        overflow: hidden;\r\n"
				+ "        text-overflow: ellipsis;\r\n"
				+ "        -webkit-line-clamp: 3;\r\n"
				+ "        -webkit-box-orient: vertical;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .card-content {\r\n"
				+ "        gap: var(--spacing-2);\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .card-label {\r\n"
				+ "        background-color: var(--color-grey-4);\r\n"
				+ "        border-radius: var(--radius-1);\r\n"
				+ "        padding: 0.25rem var(--spacing-4);\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      @media (min-width: 560px) {\r\n"
				+ "        .card footer {\r\n"
				+ "          flex-direction: row;\r\n"
				+ "        }\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .align-center {\r\n"
				+ "        align-items: center;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .d-flex {\r\n"
				+ "        display: flex;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .flex-column {\r\n"
				+ "        flex-direction: column;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .justify-center {\r\n"
				+ "        justify-content: center;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .justify-between {\r\n"
				+ "        justify-content: space-between;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .button-brand {\r\n"
				+ "        background-color: var(--color-brand);\r\n"
				+ "        border: none;\r\n"
				+ "        border-radius: var(--radius-1);\r\n"
				+ "        color: var(--color-grey-6);\r\n"
				+ "        padding: 0.375rem 1.5rem;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .full-width {\r\n"
				+ "        width: 100%;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .fit-height {\r\n"
				+ "        height: fit-content;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .title {\r\n"
				+ "        color: var(--color-grey-1);\r\n"
				+ "        font-weight: 600;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .title-size-1 {\r\n"
				+ "        font-size: var(--size-1);\r\n"
				+ "        margin-bottom: var(--spacing-1);\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .title-size-2 {\r\n"
				+ "        font-size: var(--size-2);\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .text {\r\n"
				+ "        color: var(--color-grey-2);\r\n"
				+ "        font-weight: 400;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .text-size-1 {\r\n"
				+ "        font-size: var(--size-3);\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .text-size-2 {\r\n"
				+ "        font-size: var(--size-4);\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      .text-center {\r\n"
				+ "        text-align: center;\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "    </style>\r\n"
				+ "  </head>\r\n"
				+ "  <body class=\"align-center d-flex full-width justify-center\">\r\n"
				+ "    <div class=\"container full-width\">\r\n"
				+ "      <header class=\"full-width\">\r\n"
				+ "        <h1 class=\"text-center title title-size-1\">Job Crawler</h1>\r\n"
				+ "      </header>\r\n"
				+ "      <main class=\"card-container full-width\">";
		
		for (Job job : foundJobs) {
			String salary = job.getSalary() != 0 ? "R$" + job.getSalary() : "Salário não informado";
			
			String jobHtml = "<article class=\"card card-content d-flex flex-column full-width\">\r\n"
					+ "          <header>\r\n"
					+ "            <h2 class=\"title title-size-2\">"+ job.getJobName()+"</h2>\r\n"
					+ "            <ul class=\"card-content d-flex\">\r\n"
					+ "              <li class=\"text-size-2\">"+job.getCompany()+"</li>\r\n"
					+ "              <li class=\"text-size-2\">"+job.getLocation()+"</li>\r\n"
					+ "            </ul>\r\n"
					+ "          </header>\r\n"
					+ "          <main>\r\n"
					+ "            <p class=\"text text-size-1\">\r\n"
					+ "            </p>\r\n"
					+ "          </main>\r\n"
					+ "          <footer class=\"card-content d-flex flex-column justify-between\">\r\n"
					+ "            <ul class=\"align-center card-content d-flex\">\r\n"
					+ "              <li class=\"card-label fit-height text-size-2 text-center\">"+salary+"</li>\r\n"
					+ "              <li class=\"card-label fit-height text-size-2 text-center\">"+job.getTypeOfWork()+"</li>\r\n"
					+ "            </ul>\r\n"
					+ "            <a class=\"button-brand text-center\" href=\""+job.getLink()+"\">Acessar a vaga</a>\r\n"
					+ "          </footer>\r\n"
					+ "        </article>";
			
			fullEmail += jobHtml;
		}
		
		fullEmail += "      </main>\r\n"
				+ "    </div>\r\n"
				+ "  </body>\r\n"
				+ "</html>";
		return fullEmail;
	}
	
	public void sendFoundJobsRelatory (List<Job>foundJobs) {
		String jobsRelatory = setFoundJobsRelatory(foundJobs);
		
		try {
			MimeMessage mime = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mime);
			
            helper.setTo(this.email);
            helper.setSubject("Relatório de vagas para desenvolvedor da Job Crawler");
            helper.setText(jobsRelatory, true);
            
            sender.send(mime);
            
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean receivesEmails() {
		return receivesEmails;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) throws Exception {
		ObjectMapper parser = new ObjectMapper();
    	JsonNode node;
    	
    	String emailData = "";
    	
    	node = parser.readTree(email);
    	emailData = node.get("email").asText();
		
    	this.email = emailData;
    	this.receivesEmails = true;
	}
}
