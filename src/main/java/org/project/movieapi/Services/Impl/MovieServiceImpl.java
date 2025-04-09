package org.project.movieapi.Services.Impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.project.movieapi.DTOs.Requests.MovieRequestDto;
import org.project.movieapi.DTOs.Responses.MovieResponseDto;
import org.project.movieapi.Entites.Movie;
import org.project.movieapi.Mappers.MovieMapper;
import org.project.movieapi.Repositories.MovieRepository;
import org.project.movieapi.Services.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public Page<MovieResponseDto> getAllMovies(Pageable pageable) {
        Page<Movie> page = movieRepository.findAll(pageable);
        return page.map(movieMapper::toMovieResponseDto);
    }

    @Override
    public String addMovie(MovieRequestDto movieRequestDto) {
        Movie movie = movieMapper.toEntity(movieRequestDto);
        movieRepository.save(movie);
        return "success";
    }

    @Override
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(()-> new EntityNotFoundException("Movie not found with id "+ movieId));
    }

    @Override
    public void deleteMovie(Long movieId){
        Movie existingMovie=getMovieById(movieId);
        movieRepository.delete(existingMovie);
    }

    @Override
    public void batchDeleteMovies(List<Long> ids) {
        //TODO
    }

    @Override
    public void batchAddMovies(List<MovieRequestDto> movies) {

        //TODO
    }


}
