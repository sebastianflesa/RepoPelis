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

    @Override
    public Pelicula updatePelicula(Long id, Pelicula pelicula) {
       if(peliculaRepository.existsById(id)){
            pelicula.setId(id.intValue());
            return peliculaRepository.save(pelicula);
       }else{
            throw new IllegalArgumentException("Pelicula no encontrada");
       }
               
    }

    @Override
    public Pelicula createPelicula(Pelicula pelicula) {
        if (pelicula.getTitulo() == null || pelicula.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("titulo vacio");
        }
        if (pelicula.getDirector() == null || pelicula.getDirector().isEmpty()) {
            throw new IllegalArgumentException("director vacío");
        }
        if (pelicula.getAno() == 0) {
            throw new IllegalArgumentException("anho vacío");
        }
        if (pelicula.getGenero() == null || pelicula.getGenero().isEmpty()) {
            throw new IllegalArgumentException("genero vacío");
        }

        if (pelicula.getSinopsis() == null || pelicula.getSinopsis().isEmpty()) {
            throw new IllegalArgumentException("sinopsis vacío");
        }
       
    
        return peliculaRepository.save(pelicula);
    }

    @Override
    public void deletePelicula(Long id) {
        peliculaRepository.deleteById(id);
    }


    
    
    
}