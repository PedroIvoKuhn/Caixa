package com.pedro.caixa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pedro.caixa.domain.User;


public interface UserRepository extends MongoRepository<User, String> {
    @Query("{'email' : ?0 }")
    User findByEmail(String email);
}