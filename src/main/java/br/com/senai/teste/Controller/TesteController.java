package br.com.senai.teste.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class TesteController {
    @GetMapping("/teste")
    public String teste() {
        return "Backend Rodando Na Porta 8080";
    }
}
