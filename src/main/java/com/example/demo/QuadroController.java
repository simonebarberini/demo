package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/quadri")
public class QuadroController {
    @Autowired
    QuadroRepository quadroRepository;
    
    @GetMapping
    public List<Quadro> getQuadri() {
        return quadroRepository.findAll();
    }

    @PostMapping
    public Quadro creaQuadro(@RequestBody Quadro quadro) {
        return quadroRepository.save(quadro);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<Quadro> getQuadroAuthor(@PathVariable String author) {
        Optional<Quadro> quadro = quadroRepository.findByAuthor(author);
        if(quadro.isPresent()){
            return ResponseEntity.ok(quadro.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<Quadro> getPaintingsByYear(@PathVariable int year) {
         Optional<Quadro> quadro = quadroRepository.findByYear(year);
        if(quadro.isPresent()){
            return ResponseEntity.ok(quadro.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    
}
