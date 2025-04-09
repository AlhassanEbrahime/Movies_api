package org.project.movieapi.DTOs.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class RateRequestDto {
    private Long userId;
    private Long movieId;
    private float rate;
}
