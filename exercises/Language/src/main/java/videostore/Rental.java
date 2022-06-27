/*
 * This example adapted from 'Refactoring' by Martin Fowler
 *
 */
package videostore;

import static videostore.PriceCode.NEW_RELEASE;

public class Rental {
    private Movie movie;
    private int daysRented;

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

    double calcAmount() {
        double amount = 0;
        switch (getMovie().getPriceCode()) {
            case REGULAR:
                amount += 2;
                if (getDaysRented() > 2)
                    amount += (getDaysRented() - 2) * 1.5;
                break;
            case NEW_RELEASE:
                amount += getDaysRented() * 3;
                break;
            case CHILDRENS:
                amount += 1.5;
                if (getDaysRented() > 3)
                    amount += (getDaysRented() - 3) * 1.5;
                break;
        }
        return amount;
    }

    int calcPoints() {
        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == NEW_RELEASE)
                && getDaysRented() > 1)
            return 2;
        return 1;
    }
}
