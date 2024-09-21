package com.cine.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cine.demo.model.Pelicula;
import com.cine.demo.service.PeliculaService;
import org.slf4j.Logger;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/peliculas")
public class PeliculasController {
    private static final Logger log = LoggerFactory.getLogger(Pelicula.class);


    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> getAllPeliculas(){
        log.info("GET /peliculas");
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPeliculaById(@PathVariable Long id) {
        log.info("GET /peliculas/{id}");
        Optional<Pelicula> pelicula = peliculaService.getPeliculaById(id);
        if (pelicula.get().getId()!= null) {
            EntityModel<Pelicula> resource = EntityModel.of(pelicula.get());
            resource.add(linkTo(methodOn(PeliculasController.class).getPeliculaById(id)).withSelfRel());
            resource.add(linkTo(methodOn(PeliculasController.class).getAllPeliculas()).withRel("all-peliculas"));
            return ResponseEntity.ok(resource);
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", "Pelicula no encontrada, quizás no es tan buena para estar en nuestra lista :(");
            map.put("status", "404");
            return ResponseEntity.status(200).body(map);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        log.info("PUT /peliculas/{id}");
        EntityModel<Pelicula> resource = EntityModel.of(pelicula);
        resource.add(linkTo(methodOn(PeliculasController.class).getPeliculaById(id)).withSelfRel());
        resource.add(linkTo(methodOn(PeliculasController.class).getAllPeliculas()).withRel("all-peliculas"));
        peliculaService.updatePelicula(id, pelicula);
        return ResponseEntity.ok(resource);
    }

    @PostMapping 
    public ResponseEntity<?> createPelicula(@RequestBody Pelicula pelicula) {
        log.info("POST /peliculas");
        Pelicula newPelicula = peliculaService.createPelicula(pelicula);
        EntityModel<Pelicula> resource = EntityModel.of(newPelicula);
        resource.add(linkTo(methodOn(PeliculasController.class).getPeliculaById(Long.valueOf(newPelicula.getId()))).withSelfRel());
        resource.add(linkTo(methodOn(PeliculasController.class).getAllPeliculas()).withRel("all-peliculas"));
        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable Long id) {
        log.info("DELETE /peliculas/{id}");
        peliculaService.deletePelicula(id);
    }


}