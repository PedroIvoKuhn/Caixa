package com.pedro.caixa.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedro.caixa.domain.Account;
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

    @SuppressWarnings("null")
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
        userRepository.deleteAll();
        monthlyAccountsRepository.deleteAll();

        User pedro = new User(null, "Pedro", "pedro","123", "servico");
        User marcele = new User(null, "Marcele", "marcele@gmail.com", "456", "servico");
        User joao = new User(null, "Joao", "joao@gmail.com", "789", "servico");

        userRepository.saveAll(Arrays.asList(pedro, marcele, joao));

        MonthlyAccounts conta1 = new MonthlyAccounts(null, pedro.getId(), "Janeiro");
        conta1.setIncomming(new Account("Computador", new Date(), 1400F));
        conta1.setIncomming(new Account("Notebook", new Date(), 2000.50F));
        conta1.setExpense(new Account("onibus", sdf.parse("20/01/2024"), 5F));

        MonthlyAccounts conta3 = new MonthlyAccounts(null, pedro.getId(), "Fevereiro");
        conta3.setIncomming(new Account("Mesa", new Date(), 1650.99F));
        conta3.setIncomming(new Account("Cadeira", new Date(), 756.46F));
        conta3.setExpense(new Account("Garrafa", sdf.parse("22/02/2024"), 45F));

        MonthlyAccounts conta2 = new MonthlyAccounts(null, marcele.getId(), "Fevereiro");
        conta2.setIncomming(new Account("Mesa", new Date(), 350F));
        conta2.setExpense(new Account("Curso", sdf.parse("10/02/2024"), 500F));

        monthlyAccountsRepository.saveAll(Arrays.asList(conta1, conta2, conta3));
        pedro.getMonthlyAccounts().add(conta1);
        pedro.getMonthlyAccounts().add(conta3);
        marcele.getMonthlyAccounts().add(conta2);

        userRepository.save(pedro);
        userRepository.save(marcele);
    }
}