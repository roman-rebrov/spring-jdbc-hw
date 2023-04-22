package com.jdbc.springjdbc.repository;

import com.jdbc.springjdbc.entitty.Product;
import com.jdbc.springjdbc.util.RequestReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;

import java.util.List;
import java.util.Map;


@Repository
public class JDBCRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;
    @Autowired
    private DataSource source;
    private String queryScript;

    public JDBCRepository() {
        queryScript = RequestReader.read("/data.sql");
    }


    public List<Product> selectByName(String username) {

        List<Product> products = null;
        Map<String, String> namedQuery = Map.of("name", username);

        products = template.query(
                queryScript,
                namedQuery,
                (ResultSet rs, int rowNum) -> {
                    Product prod = new Product(rs.getString("name"));
                    return prod;
                }
        );
        return products;
    }
}
