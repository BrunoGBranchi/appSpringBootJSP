package br.com.branchi.teste.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping
    public String index() {
    	System.out.println("teste");
        return "index/index";
    }
}

