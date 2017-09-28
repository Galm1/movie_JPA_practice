package com.example.movie.controller;

import com.example.movie.domain.Movie;
import com.example.movie.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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

}
