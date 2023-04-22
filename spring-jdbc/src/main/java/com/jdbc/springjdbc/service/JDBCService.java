package com.jdbc.springjdbc.service;

import com.jdbc.springjdbc.entitty.Product;
import com.jdbc.springjdbc.repository.JDBCRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCService {

    JDBCRepository repository;

    public JDBCService(JDBCRepository repository) {
        this.repository = repository;
    }

    public List<Product> getProductName(String username){
        return repository.selectByName(username);
    }

}
