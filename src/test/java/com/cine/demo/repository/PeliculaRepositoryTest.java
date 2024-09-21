package com.cine.demo.repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cine.demo.model.Pelicula;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaRepositoryTest {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @BeforeEach
    public void setUp() {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(1);
        pelicula.setTitulo("Titanic");
        pelicula.setDirector("James Cameron");
        pelicula.setAño(1997);
        pelicula.setGenero("Romance");
        pelicula.setSinopsis("Un joven pobre se enamora de una joven rica y se suben a un barco que se hunde");
        peliculaRepository.save(pelicula);
    }

    @AfterEach
    public void tearDown() {
        peliculaRepository.deleteAll();
    }

    @Test
    public void testGetPeliculaById() {
        Optional<Pelicula> result = peliculaRepository.findById(1L);
        assertTrue(result.isPresent());
        assertEquals("Titanic", result.get().getTitulo());
    }

    @Test
    public void testGetAllPeliculas() {
        List<Pelicula> peliculas = peliculaRepository.findAll();
        assertFalse(peliculas.isEmpty());
        assertEquals(24, peliculas.size());
    }
}
