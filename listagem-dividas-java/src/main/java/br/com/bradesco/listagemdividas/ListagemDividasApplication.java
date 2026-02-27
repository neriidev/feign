package br.com.bradesco.listagemdividas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ListagemDividasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListagemDividasApplication.class, args);
    }
}