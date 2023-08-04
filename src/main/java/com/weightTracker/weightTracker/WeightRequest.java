package com.weightTracker.weightTracker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WeightRequest {
//    private LocalDate date;
//    private String dateString;
    private double weightAmount;
//    private boolean optionKG;
//    private boolean optionLBs;
//    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
//    public WeightRequest(String dateString, double weightAmount) {
//        this.date = LocalDate.parse(dateString, dateTimeFormatter);
//        this.weightAmount = weightAmount;
//    }

    public WeightRequest(double weightAmount) {
        this.weightAmount = weightAmount;
    }

    public WeightRequest() {

    }

//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
    public double getWeightAmount() {
        return weightAmount;
    }

    public void setWeightAmount(double weightAmount) {
        this.weightAmount = weightAmount;
    }
//
//    public boolean isOptionKG() {
//        return optionKG;
//    }
//
//    public void setOptionKG(boolean optionKG) {
//        this.optionKG = optionKG;
//    }
//
//    public boolean isOptionLBs() {
//        return optionLBs;
//    }
//
//    public void setOptionLBs(boolean optionLBs) {
//        this.optionLBs = optionLBs;
//    }
}
