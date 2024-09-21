package com.cine.demo.service;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cine.demo.model.Pelicula;
import com.cine.demo.repository.PeliculaRepository;

public class PeliculaServiceTest {
    @Mock
    private PeliculaRepository peliculaRepository;

    @InjectMocks
    private PeliculaServiceImpl peliculaService;

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        Pelicula pelicula = new Pelicula();
        pelicula.setId(1);
        pelicula.setTitulo("Titanic");
        pelicula.setDirector("James Cameron");
        pelicula.setAño(1997);
        pelicula.setGenero("Romance");
        pelicula.setSinopsis("Un joven pobre se enamora de una joven rica y se suben a un barco que se hunde");
        when(peliculaRepository.findById(1L)).thenReturn(Optional.of(pelicula));
        when(peliculaRepository.save(any(Pelicula.class))).thenReturn(pelicula);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testCreatePelicula() {
        Pelicula nuevaPelicula = new Pelicula();
        nuevaPelicula.setId(1);
        nuevaPelicula.setTitulo("Titanic");
        nuevaPelicula.setDirector("James Cameron");
        nuevaPelicula.setAño(1997);
        nuevaPelicula.setGenero("Romance");
        nuevaPelicula.setSinopsis("Un joven pobre se enamora de una joven rica y se suben a un barco que se hunde");
        Pelicula result = peliculaService.createPelicula(nuevaPelicula);
        assertNotNull(result);
        assertEquals("Titanic", result.getTitulo());
    }

    @Test
    public void testGetPeliculaById() {
        Optional<Pelicula> result = peliculaService.getPeliculaById(1L);
        assertTrue(result.isPresent());
        assertEquals("Titanic", result.get().getTitulo());
    }
}
