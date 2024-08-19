package com.cine.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.cine.demo.model.Pelicula;

@Service
public class PeliculaService {
    private List<Pelicula> pelis = new ArrayList<>();

    public PeliculaService() {
        // Cargar algunas películas en memoria
        pelis.add(new Pelicula(1, "El Padrino", 1972, "Francis Ford Coppola", "Drama", "Historia de la familia Corleone."));
        pelis.add(new Pelicula(2, "El Caballero Oscuro", 2008, "Christopher Nolan", "Acción", "Batman lucha contra el Joker."));
        pelis.add(new Pelicula(3, "Pulp Fiction", 1994, "Quentin Tarantino", "Crimen", "Varias historias de crimen entrelazadas."));
        pelis.add(new Pelicula(4, "El Señor de los Anillos: El Retorno del Rey", 2003, "Peter Jackson", "Aventura", "La última batalla por la Tierra Media."));
        pelis.add(new Pelicula(5, "El Señor de los Anillos: La Comunidad del Anillo", 2001, "Peter Jackson", "Aventura", "El comienzo de la épica trilogía de El Señor de los Anillos."));
        pelis.add(new Pelicula(6, "Forrest Gump", 1994, "Robert Zemeckis", "Drama", "La historia de un hombre simple que influye en varios eventos históricos."));
        pelis.add(new Pelicula(7, "Inception", 2010, "Christopher Nolan", "Ciencia Ficción", "Un ladrón que roba secretos corporativos a través del uso de la tecnología de sueños compartidos."));
        pelis.add(new Pelicula(8, "Star Wars: Episodio V - El Imperio Contraataca", 1980, "Irvin Kershner", "Ciencia Ficción", "La Rebelión lucha contra el Imperio Galáctico."));
        pelis.add(new Pelicula(9, "El Señor de los Anillos: Las Dos Torres", 2002, "Peter Jackson", "Aventura", "La segunda parte de la trilogía de El Señor de los Anillos."));
        pelis.add(new Pelicula(10, "El Club de la Pelea", 1999, "David Fincher", "Drama", "Un narrador insomne forma un club secreto de lucha con un vendedor de jabón."));
        pelis.add(new Pelicula(11, "El Origen", 2010, "Christopher Nolan", "Ciencia Ficción", "Un experto en el arte de robar secretos a través de los sueños."));
        pelis.add(new Pelicula(12, "Forrest Gump", 1994, "Robert Zemeckis", "Drama", "La extraordinaria vida de un hombre simple."));
        pelis.add(new Pelicula(13, "El Bueno, el Malo y el Feo", 1966, "Sergio Leone", "Western", "Tres hombres buscan un tesoro en medio de la Guerra Civil Americana."));
        pelis.add(new Pelicula(14, "La Lista de Schindler", 1993, "Steven Spielberg", "Historia", "La historia real de cómo un empresario salvó a más de mil judíos durante el Holocausto."));
        pelis.add(new Pelicula(15, "12 Hombres en Pugna", 1957, "Sidney Lumet", "Drama", "Un jurado intenta llegar a un veredicto en un caso de asesinato."));
        pelis.add(new Pelicula(16, "El Señor de los Anillos: La Comunidad del Anillo", 2001, "Peter Jackson", "Aventura", "Un hobbit se embarca en una aventura para destruir un anillo poderoso."));
        pelis.add(new Pelicula(17, "El Caballero Oscuro: La Leyenda Renace", 2012, "Christopher Nolan", "Acción", "Batman regresa a Gotham después de ocho años para enfrentarse a un nuevo enemigo."));
        pelis.add(new Pelicula(18, "El Origen", 2010, "Christopher Nolan", "Ciencia Ficción", "Un experto en el arte de robar secretos a través de los sueños."));
        pelis.add(new Pelicula(19, "Star Wars: Episodio IV - Una Nueva Esperanza", 1977, "George Lucas", "Ciencia Ficción", "La primera entrega de la saga de Star Wars."));
        pelis.add(new Pelicula(20, "El Silencio de los Inocentes", 1991, "Jonathan Demme", "Thriller", "Un agente del FBI busca la ayuda de un asesino caníbal para atrapar a otro asesino en serie."));
        pelis.add(new Pelicula(21, "Salvar al Soldado Ryan", 1998, "Steven Spielberg", "Guerra", "La misión de un grupo de soldados para rescatar a un soldado en la Segunda Guerra Mundial."));
        pelis.add(new Pelicula(22, "Los Siete Samuráis", 1954, "Akira Kurosawa", "Acción", "Siete samuráis ayudan a proteger una aldea de bandidos."));
        pelis.add(new Pelicula(23, "La Vida es Bella", 1997, "Roberto Benigni", "Drama", "Un padre utiliza su imaginación para proteger a su hijo de los horrores de un campo de concentración."));
        pelis.add(new Pelicula(24, "Ciudad de Dios", 2002, "Fernando Meirelles", "Crimen", "La vida en las favelas de Río de Janeiro."));
    
    }
    public List<Pelicula> getPeliculas() {
        return pelis;
    }

    public Optional<Pelicula> getPeliculaById(Integer id) {
        return pelis.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

}
