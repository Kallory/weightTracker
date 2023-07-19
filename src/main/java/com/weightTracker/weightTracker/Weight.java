package com.weightTracker.weightTracker;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("weight")
public class Weight {
    @Id
    private String id;

    private LocalDate localDate;
    private double amountWeighed;

    public Weight(String id, LocalDate localDate, double amountWeighed) {
        super();
        this.id = id;
        this.localDate = localDate;
        this.amountWeighed = amountWeighed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public double getAmountWeighed() {
        return amountWeighed;
    }

    public void setAmountWeighed(double amountWeighed) {
        this.amountWeighed = amountWeighed;
    }

}
