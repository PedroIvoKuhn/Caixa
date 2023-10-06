package com.pedro.caixa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedro.caixa.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
    
}