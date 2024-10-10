package com.mansur.first_spring_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mansur.first_spring_app.domain.User;
import com.mansur.first_spring_app.service.HelloWorldService;


//API STATEFULL-> o estado de cada cliente é mantido no servidor / token para se indentificar em toda requisição
//API STATELESS -> a cada nova requisição, recebo todas as informações que eu preciso para fazer aquela funcionalidade que o cliente está pedindo 
@RestController
@RequestMapping("/hello-world")

public class HelloWorldController {

    //Esse atributo tem que ser automaticamente injeta na minha classe
    @Autowired
    private HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    // GET /hello-world -> estamos dizendo que esse método vai responder as requisições GET no endpoint /hello-world
    @GetMapping
    public String helloWorld() {
        return helloWorldService.helloWorld("Sofia");
    }

    /* 
     *@PostMapping("")
     * public String helloWorldPost(@RequestBody User body) //Injeta nesse parâmetro(body) tudo que vier no RequestBody dessa requisição {
     *   return "Hello World Post " + body.getName();
     * }
    */

    /*
     *@PostMapping("/{id}")
     *public String helloWorldPost(@PathVariable("id") String id, @RequestBody User body) {
     *   return "Hello World Post " + body.getName() + " " + id;
    * }
    */

    @PostMapping("/{id}")
     public String helloWorldPost(@PathVariable("id") String id, @RequestParam(value = "filter", defaultValue = "nenhum") String filter, @RequestBody User body) {
        return "Hello World Post " + filter;
     }

}
