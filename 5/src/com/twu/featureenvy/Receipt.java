package com.twu.featureenvy;

public class Receipt {
    private final Taxi taxi;
    private double totalCost = 0d;
    private double fixedCharge = 50d;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public Receipt(Taxi taxi, double fixedCharge) {
        this.taxi = taxi;
        this.fixedCharge = fixedCharge;
    }

    public double totalCost() {

        // taxi charges
        int totalKms = taxi.getTotalKms();
        double peakTimeMultiple = taxi.isPeakTime() ? 1.2 : 1.0;
        if(taxi.isAirConditioned()) {
            totalCost += Math.min(10, totalKms) * 20 * peakTimeMultiple;
            totalCost += Math.max(0, totalKms - 10) * 17 * peakTimeMultiple;
            totalCost += fixedCharge;
        } else {
            totalCost += Math.min(10, totalKms) * 15 * peakTimeMultiple;
            totalCost += Math.max(0, totalKms - 10) * 12 * peakTimeMultiple;
            totalCost += fixedCharge;
        }

        return totalCost * (1 + 0.1);
    }
}
