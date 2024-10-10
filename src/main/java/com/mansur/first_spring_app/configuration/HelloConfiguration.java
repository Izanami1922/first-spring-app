package com.mansur.first_spring_app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class HelloConfiguration {

    //Ela é usada para indicar para o Spring que ele deve gerenciar o retorno desse método como um Bean lá no contexto da aplicação

    //Basicamente criar instancias de classes que não podem ser gerenciadas pelo Spring automaticamente-> classes que vem de bibliotecas de terceiros ou que eu preciso
    //de um controle específico sobre a implementação dessa classe 
    @Bean
    public String helloWorld() {
        return "Hello World!";
    }


    /*EXEMPLO */

    /* public Transport myService() {
     *     return new Car();
     * }
    */ 

    // Tranport -> interface
    //Car -> implementação da classe Transport

}   
