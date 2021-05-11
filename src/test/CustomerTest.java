package test;

import main.Customer;
import main.Movie;
import main.Rental;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Movie testMovie;
    private Rental testRental;
    private Customer testCustomer;
    private Customer testStatementCustomer;

    @Before
    public void setUp(){
        testMovie = new Movie("TestTitle", Movie.REGULAR);
        testRental = new Rental(testMovie, 5);
        testCustomer = new Customer("Jon");
        testStatementCustomer = new Customer("Jon");
    }

    @Test
    public void getName(){
        assertEquals(testCustomer.getName(), "Jon");
    }

    @Test
    public void addRental(){
        testCustomer.addRental(testRental);
    }

    @Test
    public void getStatement(){
        testStatementCustomer.addRental(testRental);
        assertEquals(testStatementCustomer.statement(), "Rental Record for Jon\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tTestTitle\t\t5\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points");
    }
}
