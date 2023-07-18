package com.weightTracker.weightTracker;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface WeightRepository extends MongoRepository<Weight, LocalDate> {

    @Query("{date:'?0'}")
    Weight findWeightByDate(LocalDate date);

    @Query(value="{weight:{ $gte: '?0' }}", fields="{'date' : 1, 'weight' : 1}")
    List<Weight> findAllWithWeightGreaterThanOrEqual(Double weight);

    public long count();

}

