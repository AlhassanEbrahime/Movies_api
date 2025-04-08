package org.project.movieapi.Controllers;


import lombok.RequiredArgsConstructor;
import org.project.movieapi.DTOs.Responses.MovieResponseDto;
import org.project.movieapi.Services.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/movies")
public class UserMovieController{

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<Page<MovieResponseDto>> getAllMovies(@PageableDefault Pageable pageable){
        Page<MovieResponseDto> movies = movieService.getAllMovies(pageable);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }



}
