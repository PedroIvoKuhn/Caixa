package com.pedro.caixa.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pedro.caixa.domain.MonthlyAccounts;
import com.pedro.caixa.services.MonthlyAccountsService;

@RestController
@RequestMapping(value = "/accounts")
public class MonthlyAccountsResource {
    @Autowired
    private MonthlyAccountsService service;
    
    @GetMapping
    public ResponseEntity<List<MonthlyAccounts>> findAll(){
        List<MonthlyAccounts> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MonthlyAccounts> findById(@PathVariable String id){
        MonthlyAccounts obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody MonthlyAccounts acc){
        acc = service.insert(acc);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(acc.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}