package org.project.movieapi.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.project.movieapi.DTOs.Requests.MovieRequestDto;
import org.project.movieapi.DTOs.Responses.MovieDetailedResponseDto;
import org.project.movieapi.DTOs.Responses.MovieResponseDto;
import org.project.movieapi.Entites.Movie;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface MovieMapper{

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    Movie toEntity(MovieRequestDto movieRequestDto);

    MovieResponseDto toMovieResponseDto(Movie movie);

    MovieDetailedResponseDto toMovieDetailedResponseDto(Movie movie);


}
