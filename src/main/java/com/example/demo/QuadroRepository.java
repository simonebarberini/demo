package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuadroRepository extends JpaRepository<Quadro, Long>{
    Optional<Quadro> findByAuthor(String author);
    Optional<Quadro> findByYear(int year);
    
    
}
