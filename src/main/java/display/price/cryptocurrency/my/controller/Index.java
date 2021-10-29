package display.price.cryptocurrency.my.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class Index {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Price Service!";
    }
}
