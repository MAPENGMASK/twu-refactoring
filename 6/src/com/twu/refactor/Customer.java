package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;
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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = rentalList.iterator();
        StringBuilder result = new StringBuilder();
        printHeader(result);
        while (rentals.hasNext()) {
            Rental next = rentals.next();
            double thisAmount = next.getCharge();
            frequentRenterPoints += next.getFrePoints();
            totalAmount += thisAmount;
            printContent(result, thisAmount, next);
        }
        printFooter(result, totalAmount, frequentRenterPoints);
        return result.toString();
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
