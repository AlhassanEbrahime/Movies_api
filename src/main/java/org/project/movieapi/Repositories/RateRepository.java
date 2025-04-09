package org.project.movieapi.Repositories;

import org.project.movieapi.Entites.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate, Long> {
}
