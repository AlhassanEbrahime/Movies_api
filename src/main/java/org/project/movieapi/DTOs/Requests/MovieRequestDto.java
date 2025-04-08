package org.project.movieapi.DTOs.Requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MovieRequestDto {
    private Long id;
    private String imdbId;
    private String title;
    private String type;
    private String plot;
    private String released;
    private String rated;
    private String runtime;
    private String genre;
    private String director;
    private String actors;
    private String writer;
    private String language;
    private String country;
    private String poster;
    private String imdbRating;
}
