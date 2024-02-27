package com.pedro.caixa.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pedro.caixa.domain.MonthlyAccounts;


public interface MonthlyAccountsRepository extends MongoRepository<MonthlyAccounts, String> {
    @Query("{'userId' : ?0 }")
    Optional<MonthlyAccounts> findByUserId(String userId);
}