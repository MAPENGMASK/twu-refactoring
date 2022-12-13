package com.twu.refactor;

import static com.twu.refactor.MovieTypeEnum.NEW_RELEASE;

public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        double charge = 0;
        switch (this.movie.getTypeEnum()) {
            case REGULAR -> {
                charge += 2;
                if (this.daysRented > 2) {
                    charge += (this.daysRented - 2) * 1.5;
                }
            }
            case NEW_RELEASE -> charge += this.daysRented * 3;
            case CHILDRENS -> {
                charge += 1.5;
                if (this.daysRented > 3) {
                    charge += (this.daysRented - 3) * 1.5;
                }
            }
        }
        return charge;
    }

    public int getFrePoints() {
        if ((NEW_RELEASE.equals(this.movie.getTypeEnum()))
                && this.getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}