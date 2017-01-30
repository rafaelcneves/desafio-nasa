package com.rafael.desafio;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class NasaController {

    @RequestMapping("/")
    public String home () {
        String body = "";
        Nasa nasa = new Nasa("MMRMMRMM");
        try {
            nasa.execute();
            body = nasa.getPosition();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return body;
    }
}
