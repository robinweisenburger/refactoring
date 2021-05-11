package test;

import main.Movie;
import main.Rental;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalTest {

    private Movie testMovie;
    private Rental testRental;

    @Before
    public void setUp(){
        testMovie = new Movie("TestTitle", Movie.REGULAR);
        testRental = new Rental(testMovie, 5);
    }

    @Test
    public void getDaysRented(){
        assertEquals(testRental.getDaysRented(), 5);
    }

    @Test
    public void getMovie(){
        assertEquals(testRental.getMovie().getTitle(), testMovie.getTitle());
        assertEquals(testRental.getMovie().getPriceCode(), testMovie.getPriceCode());
    }
}
