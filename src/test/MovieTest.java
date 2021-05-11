package test;

import main.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    private Movie regularTestMovie;

    @Before
    public void setUp(){
        regularTestMovie = new Movie("RegularMovieTitle", Movie.REGULAR);
    }

    @Test
    public void getTitle(){
        assertEquals(regularTestMovie.getTitle(), "RegularMovieTitle" );
    }

    @Test
    public void getPriceCode(){
        assertEquals(regularTestMovie.getPriceCode(), Movie.REGULAR);
    }

    @Test
    public void setPriceCode(){
        regularTestMovie.setPriceCode(Movie.REGULAR);
        assertEquals(regularTestMovie.getPriceCode(), Movie.REGULAR);
    }
}
