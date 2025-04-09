package org.project.movieapi.Services.Impl;

import lombok.RequiredArgsConstructor;
import org.project.movieapi.DTOs.Requests.RateRequestDto;
import org.project.movieapi.Entites.Movie;
import org.project.movieapi.Entites.Rate;
import org.project.movieapi.Repositories.RateRepository;
import org.project.movieapi.Services.MovieService;
import org.project.movieapi.Services.RateService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;
    private final MovieService movieService;

//    private final UserService userService; TODO

    @Override
    public void addRate(RateRequestDto rateRequestDto) {
       Movie movie =  movieService.getMovieById(rateRequestDto.getMovieId());
       //TODO validate user

        Rate rate = Rate.builder()
                .rate(rateRequestDto.getRate())
                .user(null) //TODO
                .movie(movie)
                .build();

        rateRepository.save(rate);
    }
}
