package com.cine.demo.controller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.cine.demo.model.Pelicula;
import com.cine.demo.service.PeliculaService;

@WebMvcTest(PeliculasController.class)
public class PeliculasControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeliculaService peliculaServiceMock;

    @Test
    public void testGetAllPeliculasTest() throws Exception {
        Pelicula pelicula1 = new Pelicula();
        Pelicula pelicula2 = new Pelicula();
        pelicula1.setId(1);
        pelicula1.setTitulo("Titanic");
        pelicula1.setDirector("James Cameron");
        pelicula1.setAño(1997);
        pelicula1.setGenero("Romance");
        pelicula1.setSinopsis("Un joven pobre se enamora de una joven rica y se suben a un barco que se hunde");

        pelicula2.setId(2);
        pelicula2.setTitulo("El Padrino");
        pelicula2.setDirector("Francis Ford Coppola");
        pelicula2.setAño(1972);
        pelicula2.setGenero("Drama");
        pelicula2.setSinopsis("Historia de la familia Corleone y su imperio de la mafia");

        List<Pelicula> peliculas = List.of(pelicula1,pelicula2);

        when(peliculaServiceMock.getAllPeliculas()).thenReturn(peliculas);
        /*Mock de get peliculas */
        mockMvc.perform(get("/peliculas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].titulo").value("Titanic"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].titulo").value("El Padrino"));
    }

    @Test
    public void testGetPeliculaById() throws Exception {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(1);
        pelicula.setTitulo("Titanic");
        pelicula.setDirector("James Cameron");
        pelicula.setAño(1997);
        pelicula.setGenero("Romance");
        pelicula.setSinopsis("Un joven pobre se enamora de una joven rica y se suben a un barco que se hunde");

        when(peliculaServiceMock.getPeliculaById(1L)).thenReturn(Optional.of(pelicula));

        mockMvc.perform(get("/peliculas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.titulo").value("Titanic"));
    }

    @AfterEach
    public void tearDown() {
        reset(peliculaServiceMock);
    }

    @BeforeEach
    public void setUp() {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(1);
        pelicula.setTitulo("Titanic");
        pelicula.setDirector("James Cameron");
        pelicula.setAño(1997);
        pelicula.setGenero("Romance");
        pelicula.setSinopsis("Un joven pobre se enamora de una joven rica y se suben a un barco que se hunde");
        when(peliculaServiceMock.getPeliculaById(1L)).thenReturn(Optional.of(pelicula));
    }

}