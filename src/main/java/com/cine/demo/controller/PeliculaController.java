package com.cine.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.demo.model.Pelicula;
import com.cine.demo.service.PeliculaService;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> getAllPeliculas() {
        return peliculaService.getPeliculas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPeliculaById(@PathVariable Integer id) {
        Optional<Pelicula> pelicula = peliculaService.getPeliculaById(id);
        if (pelicula.isPresent()) {
            return ResponseEntity.ok(pelicula.get());
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", "Pelicula no encontrada, quizás no es tan buena para estar en nuestra lista :(");
            map.put("status", "404");
            return ResponseEntity.status(200).body(map);
        }
    }

}
