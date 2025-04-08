package org.project.movieapi.Services;


import org.project.movieapi.DTOs.Responses.MovieResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {

    Page<MovieResponseDto> getAllMovies(Pageable pageable);


}
