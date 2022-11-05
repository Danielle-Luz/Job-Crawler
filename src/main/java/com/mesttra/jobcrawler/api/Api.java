package com.mesttra.jobcrawler.api;

import com.mesttra.jobcrawler.control.*;
import com.mesttra.jobcrawler.model.Job;

import java.util.List;

import org.jsoup.select.Elements;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping(value = "/trabalhos", produces = MediaType.APPLICATION_JSON_VALUE)
public class Api {

    @PostMapping
    @ResponseBody
    public Elements getJobsFromUrl (@RequestBody String url) {
        Crawler crawler = new Crawler(url);
        return crawler.getPageDevJobs();
    }
}

