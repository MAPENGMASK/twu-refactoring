package com.twu.featureenvy;

public class Receipt {
    public static final double SALES_TAX = 1.1;
    private final Taxi taxi;
    private double fixedCharge = 50d;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public Receipt(Taxi taxi, double fixedCharge) {
        this.taxi = taxi;
        this.fixedCharge = fixedCharge;
    }

    public double totalCost() {
        return (fixedCharge + calculateAirConditioningCost(taxi.getTotalKms()) * getPeakTimeTax(taxi.isPeakTime())) * SALES_TAX;
    }

    private double getPeakTimeTax(boolean peakTime) {
        return peakTime ? 1.2 : 1.0;
    }

    private double calculateAirConditioningCost(int totalKms) {
        if(taxi.isAirConditioned()) {
            return (double) Math.min(10, totalKms) * 20  + (double) Math.max(0, totalKms - 10) * 17;
        } else {
            return (double) Math.min(10, totalKms) * 15 + (double) Math.max(0, totalKms - 10) * 12;
        }
    }
}
