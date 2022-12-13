package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.twu.refactor.MovieTypeEnum.NEW_RELEASE;

public class Customer {

	private String name;
	private List<Rental> rentalList = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		StringBuilder result = new StringBuilder();
		result.append("Rental Record for ");
		result.append(getName());
		result.append("\n");
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();

			// determine amounts for each line
			switch (each.getMovie().getTypeEnum()) {
			case REGULAR:
				thisAmount += 2;
				if (each.getDaysRented() > 2)
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				break;
			case NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3;
				break;
			case CHILDRENS:
				thisAmount += 1.5;
				if (each.getDaysRented() > 3)
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;

			}

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((NEW_RELEASE.equals(each.getMovie().getTypeEnum()))
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;

			// show figures for this rental
			result.append("\t");
			result.append(each.getMovie().getTitle());
			result.append("\t");
			result.append(thisAmount);
			result.append("\n");
			totalAmount += thisAmount;

		}
		// add footer lines
		result.append("Amount owed is ");
		result.append(totalAmount);
		result.append("\n");
		result.append("You earned ");
		result.append(frequentRenterPoints);
		result.append(" frequent renter points");
		return result.toString();
	}

}
