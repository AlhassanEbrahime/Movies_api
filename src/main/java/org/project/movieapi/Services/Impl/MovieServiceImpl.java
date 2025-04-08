package org.project.movieapi.Services.Impl;

import lombok.RequiredArgsConstructor;
import org.project.movieapi.DTOs.Responses.MovieResponseDto;
import org.project.movieapi.Entites.Movie;
import org.project.movieapi.Mappers.MovieMapper;
import org.project.movieapi.Repositories.MovieRepository;
import org.project.movieapi.Services.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

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
}
