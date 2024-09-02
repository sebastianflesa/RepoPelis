package com.cine.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.cine.demo.model.Pelicula;

@Service
public interface PeliculaService {
    List<Pelicula> getAllPeliculas();
    Optional<Pelicula> getPeliculaById(Long id);

}
