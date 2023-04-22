package com.jdbc.springjdbc.controller;


import com.jdbc.springjdbc.service.JDBCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JDBCController {

    JDBCService service;


    public JDBCController(JDBCService service) {
        this.service = service;
    }


    @GetMapping("/products/fetch-product")
    public ResponseEntity getNames(@RequestParam("name") String name){
        return ResponseEntity.ok(service.getProductName(name));
    }
}
