package com.example.movie.service;

import com.example.movie.domain.Movie;

import java.util.List;

public interface MovieService {

    Movie add(Movie movie);
    void add(List<Movie> movies);
    Movie getById(int id);
    List<Movie> get();
    void update(Movie movie);
    void delete(int id);

}
