package com.weightTracker.weightTracker;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WeightRepository extends MongoRepository<Weight, String> {
    Optional<Weight> findWeightByLocalDate(LocalDate localDate);
    Optional<Weight> findTopByOrderByLocalDateAsc();
    List<Weight> findAllByAmountWeighedGreaterThanEqual(Double weight);
    long count();
    boolean existsByLocalDate(LocalDate localDate);
}



