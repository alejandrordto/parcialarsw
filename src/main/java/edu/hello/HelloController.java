package edu.hello;

import edu.eci.libraryapi.model.Book;
import edu.eci.libraryapi.model.Librery;
import edu.eci.libraryapi.services.LibraryServices;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController

public class HelloController {
    
     LibraryServices servicio=new  LibraryServices();
    @GetMapping("/libraries")
    public ArrayList<Librery> index()  {
        return servicio.getAllLibreries();
    }
    @GetMapping("/libraries/{id}")
    public Librery getLibery(@PathVariable Integer id){
        return servicio.getByid(id);
    }
    @GetMapping("/libraries/{id}/{bid}")
    public Book getBook(@PathVariable Integer id,@PathVariable Integer bid){
        return servicio.getByidBook(id, bid);
    }
    @DeleteMapping("/libraries/{id}")
    public void delete(@PathVariable Integer id){
        servicio.delete(id);
    }
    @PostMapping("/libraries/{id}/{mail}")
    public void addLibrari(@RequestBody Book o,@PathVariable Integer id,@PathVariable String mail){
        servicio.addBook(o, id, mail);
    }
    @GetMapping("/libraries/{id}/books")
    public ResponseEntity<?> getBooks(@PathVariable Integer id){
        List<Book>resp=servicio.getBooks(id);
        return new ResponseEntity<>(resp,HttpStatus.ACCEPTED);
}
}
