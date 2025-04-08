package org.project.movieapi.Controllers;

import org.project.movieapi.DTOs.Responses.MovieSearchResponseDto;
import org.project.movieapi.Services.Impl.OMDbClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/movies")
public class OMDbClientController {

    private final OMDbClientService omDbClientService;


    public OMDbClientController(OMDbClientService omDbClientService) {
        this.omDbClientService = omDbClientService;
    }


    @GetMapping("/search")
    public ResponseEntity<MovieSearchResponseDto> searchMovies(
            @RequestParam String query) {
        return ResponseEntity.ok(omDbClientService.searchMovie(query));
    }
}
