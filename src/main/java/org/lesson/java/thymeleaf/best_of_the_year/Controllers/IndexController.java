package org.lesson.java.thymeleaf.best_of_the_year.Controllers;

import java.util.Arrays;
import java.util.List;
import org.lesson.java.thymeleaf.best_of_the_year.Classes.Movie;
import org.lesson.java.thymeleaf.best_of_the_year.Classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("name", "Andrea");
        
        return "index";
    }

    @GetMapping("/movies")
    public String showMovies(Model model) {

        List<Movie> movies = getBestMovies();
        model.addAttribute("movies", movies);

        return "movies";
    }

    @GetMapping("/songs")
    public String showSongs(Model model) {

        List<Song> songs = getBestSongs();
        model.addAttribute("songs", songs);

        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(@PathVariable int id, Model model) {

    List<Movie> movies = getBestMovies();
    Movie foundMovie = null;

    for (Movie movie : movies) {
        if (movie.getId() == id) {
            foundMovie = movie;
            break;
        }
    }

    if (foundMovie != null) {
        model.addAttribute("title", foundMovie.getTitle());
    } else {
        model.addAttribute("title", "Film non trovato");
    }

        return "movie-detail";
    }

    @GetMapping("/songs/{id}")
    public String getSongById(@PathVariable int id, Model model) {

    List<Song> songs = getBestSongs();
    Song foundSong = null;

    for (Song song : songs) {
        if (song.getId() == id) {
            foundSong = song;
            break;
        }
    }

    if (foundSong != null) {
        model.addAttribute("title", foundSong.getTitle());
    } else {
        model.addAttribute("title", "Canzone non trovata");
    }

        return "song-detail";
    }
    
    private List<Movie> getBestMovies() {
        return Arrays.asList(
            new Movie(1,"Inception"),
            new Movie(2,"Interstellar"),
            new Movie(3,"V per Vendetta"),
            new Movie(4,"Shutter Island")
            );
    }

    private List<Song> getBestSongs() {
        return Arrays.asList(
            new Song(1,"Sweet Child O' Mine"),
            new Song(2,"Let It Be"),
            new Song(3,"Don't Look Back in Anger"),
            new Song(4,"Tommaso")
        );
        
    }
}

