package com.cine.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cine.demo.model.Pelicula;
import com.cine.demo.repository.PeliculaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService{
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> getAllPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Optional<Pelicula> getPeliculaById(Long id) {
        if (peliculaRepository.findById(id).isEmpty()) {
            return Optional.ofNullable(new Pelicula());
        }
        return peliculaRepository.findById(id);
    }
    
    
    
}