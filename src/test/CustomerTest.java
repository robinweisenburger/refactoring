package test;

import main.Customer;
import main.Movie;
import main.Rental;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Movie regularMovie;
    private Movie childrenMovie;
    private Movie newMovie;
    private Rental testRental;
    private Customer testCustomer;

    @Before
    public void setUp(){
        regularMovie = new Movie("RegularMovieTitle", Movie.REGULAR);
        childrenMovie = new Movie("ChildrenMovieTitle", Movie.CHILDRENS);
        newMovie = new Movie("NewMovieTitle", Movie.NEW_RELEASE);
        testRental = new Rental(regularMovie, 5);
        testCustomer = new Customer("Jon");
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
        //Test regular movie
        Customer testStatementCustomer = new Customer("Jon");
        testStatementCustomer.addRental(new Rental(regularMovie, 5));
        assertEquals(testStatementCustomer.statement(), "Rental Record for Jon\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tRegularMovieTitle\t\t5\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points");

        //Test children movie
        testStatementCustomer = new Customer("Jon");
        testStatementCustomer.addRental(new Rental(childrenMovie, 5));
        assertEquals(testStatementCustomer.statement(), "Rental Record for Jon\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tChildrenMovieTitle\t\t5\t4.5\n" +
                "Amount owed is 4.5\n" +
                "You earned 1 frequent renter points");

        //Test new release movie
        testStatementCustomer = new Customer("Jon");
        testStatementCustomer.addRental(new Rental(newMovie, 5));
        assertEquals(testStatementCustomer.statement(), "Rental Record for Jon\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tNewMovieTitle\t\t5\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points");
    }
}
