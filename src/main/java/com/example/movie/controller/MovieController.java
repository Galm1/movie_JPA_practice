package com.example.movie.controller;

import com.example.movie.domain.Movie;
import com.example.movie.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    private ObjectMapper objectMapper = new ObjectMapper();


    @PostMapping("/api/movie")
    public String addMovie(@RequestBody String json) throws IOException {
        Movie movie = objectMapper.readValue(json, Movie.class);
        movieService.add(movie);

        return "ok";
    }

    @PutMapping("/api/movie/{id}")
    public String updateMovie(@PathVariable("id") Integer id, @RequestBody String json) throws IOException {
        Movie movie = objectMapper.readValue(json, Movie.class);
        movie.setId(id);
        movieService.update(movie);
        return "ok";
    }

    @GetMapping("/api/movies")
    public List<Movie> getAll(Model model) {
        return movieService.get();
    }

}
