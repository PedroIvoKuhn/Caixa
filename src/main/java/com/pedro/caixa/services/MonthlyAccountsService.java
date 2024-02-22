package com.pedro.caixa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.caixa.domain.MonthlyAccounts;
import com.pedro.caixa.repository.MonthlyAccountsRepository;
import com.pedro.caixa.services.exception.ObjectNotFoundException;

@Service
public class MonthlyAccountsService {
    @Autowired
    private MonthlyAccountsRepository repo;

    public List<MonthlyAccounts> findAll(){
        return repo.findAll();
    }

    @SuppressWarnings("null")
    public MonthlyAccounts findById(String id){
        Optional<MonthlyAccounts> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }

    @SuppressWarnings("null")
    public MonthlyAccounts insert(MonthlyAccounts obj){
        return repo.insert(obj);
    }
}