package control;

import java.io.IOException;
import java.util.List;
import java.util.regex.*;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class Crawler {

    String url;

    public Crawler(String url) {
        this.url = url;
    }

    public Elements getPageDevJobs() {
        Elements devJobs = new Elements();

        try {
            Document page = Jsoup.connect(this.url).get();

            List<Element> elementsList = page.body().getElementsByClass("jg__job");

            for (Element element : elementsList) {
                String jobName = element.select(".job__name").text();

                Pattern pattern = Pattern.compile("desenvolvedor|programador|desenvolvimento", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(jobName);

                if (matcher.find()) {
                    devJobs.add(element);
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }

        return devJobs;
    }
}
