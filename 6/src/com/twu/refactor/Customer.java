package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.twu.refactor.MovieTypeEnum.NEW_RELEASE;

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
            double thisAmount = calculateOneRentalAmount(next);
            frequentRenterPoints += getFrequentRenterPoints(next);
            totalAmount += thisAmount;
            printContent(result, thisAmount, next);
        }
        printFooter(totalAmount, frequentRenterPoints, result);
        return result.toString();
    }

    private int getFrequentRenterPoints(Rental each) {
        int frequentRenterPoint = 0;
        if ((NEW_RELEASE.equals(each.getMovie().getTypeEnum()))
                && each.getDaysRented() > 1) {
            return frequentRenterPoint + 2;
        } else {
            return frequentRenterPoint + 1;
        }
    }

    private double calculateOneRentalAmount(Rental rental) {
        double thisAmount = 0;
        switch (rental.getMovie().getTypeEnum()) {
            case REGULAR -> {
                thisAmount += 2;
                if (rental.getDaysRented() > 2) {
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                }
            }
            case NEW_RELEASE -> thisAmount += rental.getDaysRented() * 3;
            case CHILDRENS -> {
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3) {
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                }
            }
        }
        return thisAmount;
    }

    private void printFooter(double totalAmount, int frequentRenterPoints, StringBuilder result) {
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
