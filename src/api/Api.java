package api;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/trabalhos", produces = MediaType.APPLICATION_JSON_VALUE)
public class Api {

}
