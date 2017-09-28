package com.example.movie.service;


import com.example.movie.domain.Movie;
import com.example.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;

    @Transactional
    @Override
    public Movie add(Movie movie){
        return (Movie) movieRepository.save(movie);
    }

    @Transactional
    @Override
    public void add(List<Movie> movies) {
        for (Movie movie: movies){
            movieRepository.save(movie);
        }
    }

    @Transactional
    @Override
    public Movie getById(int id) {
        return (Movie) movieRepository.findOne(id);
    }

    @Override
    public List<Movie> get() {
        return movieRepository.findAll();
    }

    @Override
    public void update(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void delete(int id) {
        movieRepository.delete(id);
    }
}
