package org.data;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/bookFaultTolerance")
public class BookRepository {
    

    @GET
    public List <Book> getBook(){
        return Arrays.asList(
            new Book ("Book1","Author1"),
            new Book ("Book2","Author2"),
            new Book ("Book3", "Author3")
        );  
    }

}