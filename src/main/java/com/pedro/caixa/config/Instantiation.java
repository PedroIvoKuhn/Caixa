package com.pedro.caixa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedro.caixa.domain.User;
import com.pedro.caixa.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User pedro = new User(null, "Pedro", "pedro@gmail.com", "servico");
        User marcele = new User(null, "Marcele", "marcele@gmail.com", "servico");
        User joao = new User(null, "Joao", "joao@gmail.com", "servico");

        userRepository.saveAll(Arrays.asList(pedro, marcele, joao));
    }
}