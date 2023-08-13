package com.example.salesman_final.repository;

import com.example.salesman_final.entities.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesmanRepository extends JpaRepository<Salesman, Long> {

}
