package org.project.movieapi.Services;

import org.project.movieapi.DTOs.Requests.RateRequestDto;
import org.project.movieapi.Entites.Rate;

public interface RateService {
    void addRate(RateRequestDto rate);
}
