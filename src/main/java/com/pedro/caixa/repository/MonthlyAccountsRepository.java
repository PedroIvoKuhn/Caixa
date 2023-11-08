package com.pedro.caixa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedro.caixa.domain.MonthlyAccounts;

public interface MonthlyAccountsRepository extends MongoRepository<MonthlyAccounts, String> {
    
}