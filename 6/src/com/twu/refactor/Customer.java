package com.twu.refactor;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentalList = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        int index = 0;
        StringBuilder result = new StringBuilder();

        printHeader(result);
        while (index < rentalList.size()) {
            Rental next = rentalList.get(index);
            printContent(result, rentalList.get(index).getCharge(), next);
            index++;
        }
        
        printFooter(result, getTotalAmount(), getTotalFrePoints());
        return result.toString();
    }

    private int getTotalFrePoints() {
        int totalFrePoints = 0;
        for (Rental rental : this.rentalList) {
            totalFrePoints += rental.getFrePoints();
        }
        return totalFrePoints;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : this.rentalList) {
            totalAmount += rental.getCharge();
        }
        return totalAmount;
    }

    private void printFooter(StringBuilder result, double totalAmount, int frequentRenterPoints) {
        result.append("Amount owed is ");
        result.append(totalAmount);
        result.append("\n");
        result.append("You earned ");
        result.append(frequentRenterPoints);
        result.append(" frequent renter points");
    }

    private void printContent(StringBuilder result, double thisAmount, Rental rental) {
        result.append("\t");
        result.append(rental.getMovie().getTitle());
        result.append("\t");
        result.append(thisAmount);
        result.append("\n");
    }

    private void printHeader(StringBuilder result) {
        result.append("Rental Record for ");
        result.append(this.name);
        result.append("\n");
    }

}
