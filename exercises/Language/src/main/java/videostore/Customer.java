/*
 * This example adapted from 'Refactoring' by Martin Fowler
 *
 */
package videostore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    private double totalAmount() {
        //add cost of this rental to total cost
        return rentals
                .stream()
                .mapToDouble(Rental::calcAmount)
                .sum();
    }

    private int totalPoints() {
        return rentals
                .stream()
                .mapToInt(Rental::calcPoints)
                .sum();
    }

    public String statement() {
        var header = format("\nRental Record for %s\n", getName());
        var rentalLines = rentalLines();
        var footer1 = format("Amount owed is %.2f\n", totalAmount());
        var footer2 = format("You earned %d frequent renter points\n", totalPoints());

        return header + rentalLines + footer1 + footer2;
    }

    private String rentalLines() {
        return rentals
                .stream()
                .map(this::formatLine)
                .collect(Collectors.joining());
    }

    private String formatLine(Rental each) {
        return format(
                "\t%d\t%s\t%.2f\n",
                each.getDaysRented(),
                each.getMovie().getTitle(),
                each.calcAmount());
    }

}
