package com.pedro.caixa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.caixa.domain.MonthlyAccounts;
import com.pedro.caixa.repository.MonthlyAccountsRepository;
import com.pedro.caixa.services.exception.ObjectNotFoundException;

@Service
@SuppressWarnings("null")
public class MonthlyAccountsService {
    @Autowired
    private MonthlyAccountsRepository repo;

    public List<MonthlyAccounts> findAll(){
        return repo.findAll();
    }

    public MonthlyAccounts findById(String id){
        Optional<MonthlyAccounts> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }

    public MonthlyAccounts findByUserId(String userId){
        Optional<MonthlyAccounts> obj = repo.findByUserId(userId);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }

    public MonthlyAccounts insert(MonthlyAccounts obj){
        return repo.insert(obj);
    }
}