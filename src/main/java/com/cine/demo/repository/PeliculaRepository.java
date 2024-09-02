package com.cine.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cine.demo.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
    
}