package com.pedro.caixa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.caixa.domain.User;
import com.pedro.caixa.repository.UserRepository;
import com.pedro.caixa.services.exception.ObjectNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
    
    @SuppressWarnings("null")
    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado."));
    }

    @SuppressWarnings("null")
    public User insert(User obj){
        return repo.insert(obj);
    }

    public User login(String email, String password){
        User obj = repo.findByEmail(email);
        if (obj != null) {
           if (obj.checkPassword(password)) {
            return obj;
            } 
        }
        
        throw new ObjectNotFoundException("Usuario ou senha incorretos.");
    }
}