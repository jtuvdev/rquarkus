package org.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.jboss.logging.Logger;

@Path("/bookFaultTolerance")
public class BookRepository {

    public static Logger LOGGER = Logger.getLogger(BookRepository.class.getName());

    @GET
    @Path("/retry")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getRetryBook() {
        return getRetryFailingBooks();
    }

    @Retry(maxRetries = 4, delay = 1000L)
    public List<Book> getRetryFailingBooks() {
        final boolean fail = new Random().nextBoolean();
        if (fail) {
            LOGGER.info("Couldn't connect to database");
        }
        return Arrays.asList(new Book("Book1", "Author1"), new Book("Book2", "Author2"), new Book("Book3", "Author3"));
    }

    @GET
    @Path("/timeout")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout()
    public List<Book> getTimeOutBook() {
        return getTimeOutFailingBooks();
    }

    @Timeout(3000)
    public List<Book> getTimeOutFailingBooks() {
        final boolean fail = new Random().nextBoolean();
        if (fail) {
            LOGGER.info("Couldn't connect to database");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return Arrays.asList(new Book("Book1", "Author1"), new Book("Book2", "Author2"), new Book("Book3", "Author3"));
    }

    @GET
    @Path("/fallback")
    @Produces(MediaType.APPLICATION_JSON)
    @Fallback(
        fallbackMethod = "getFallbackFailingBooks"
    )
    @CircuitBreaker(
        failureRatio=0.5,
        failOn = RuntimeException.class,
        delay = 20000L
    )
    public List<Book> getFallbackBooks(@QueryParam("id") String id) {
         final boolean fail = new Random().nextBoolean();
        if (fail) {
            LOGGER.info("Couldn't connect to database");
            throw new RuntimeException("Couldn't connect to database");
        }
        return Arrays.asList(new Book("Book1", "Author1"), new Book("Book2", "Author2"), new Book("Book3", "Author3"));

    }

    /*
    If fail then Fallback books.
    */
    public List<Book> getFallbackFailingBooks(@QueryParam("id") String id) {
        LOGGER.info("Id is " + id);
        return Arrays.asList(new Book("Fallback Book1", "Author1"), new Book("Fallback Book2", "Author2"), new Book("Fallback Book3", "Author3"));
    }
}