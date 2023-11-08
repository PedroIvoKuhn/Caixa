package com.pedro.caixa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedro.caixa.domain.MonthlyAccounts;
import com.pedro.caixa.domain.User;
import com.pedro.caixa.repository.MonthlyAccountsRepository;
import com.pedro.caixa.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MonthlyAccountsRepository monthlyAccountsRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        monthlyAccountsRepository.deleteAll();

        User pedro = new User(null, "Pedro", "pedro@gmail.com", "servico");
        User marcele = new User(null, "Marcele", "marcele@gmail.com", "servico");
        User joao = new User(null, "Joao", "joao@gmail.com", "servico");

        userRepository.saveAll(Arrays.asList(pedro, marcele, joao));

        MonthlyAccounts conta1 = new MonthlyAccounts(null, pedro.getId(), "Novembro", null, null);
        
        monthlyAccountsRepository.saveAll(Arrays.asList(conta1));
        pedro.getMonthlyAccounts().add(conta1);

        userRepository.save(pedro);

    }
}