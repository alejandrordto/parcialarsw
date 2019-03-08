package edu.eci.libraryapi.services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.eci.libraryapi.model.Book;
import edu.eci.libraryapi.model.Librery;
import edu.eci.treahd;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristian
 */
public class LibraryServices {

    ArrayList<Librery> librerias = new ArrayList();

    public LibraryServices() {
        Book b1 = new Book(5676, "festin de cuervos", "r.r martin", "los dragones vienen");
        Book b2 = new Book(5689, "la trampa", "geaorge owel", "abogado luchara contra todo");
        List<Book> lb1 = new ArrayList<>();
        List<Book> lb2 = new ArrayList<>();
        lb1.add(b1);
        lb2.add(b2);
        Librery x = new Librery(124, "libreria palma", "cll 165a no 58-62", 3345767, lb1);
        Librery y = new Librery(123, "libreria gloria", "cll 127 cbis no 67-30", 964867, lb2);
        librerias.add(y);
        librerias.add(x);
    }

    public ArrayList<Librery> getAllLibreries() {
        return librerias;

    }

    public void addBook(Book book,Integer id, String mail) {
         Librery temp = null;
        for (Librery i : librerias) {
            if (i.getId() == id) {
                i.addBook(book);
                treahd x=new treahd(mail);
                x.run();
            }
        }
    }

    public Book getByidBook(Integer id, Integer bid) {
        Book temp = null;
        for (Librery i : librerias) {
            if (i.getId() == id) {
                for (Book x : i.getBooks()) {
               
                    if (x.getId().toString().equals(bid.toString())) {
                        temp = x;

                    }
                }
            }
        }
        return temp;
    }

    public Librery getByid(Integer id) {
        Librery temp = null;
        for (Librery i : librerias) {
            if (i.getId() == id) {
                temp = i;
            }
        }
        return temp;
    }
    public void delete(Integer id){
        int x=0;
        for (int i = 0; i < librerias.size(); i++) {
            if (librerias.get(i).getId() == id) {
                x = i;
            }
            
        }
        librerias.remove(x);
    }
    public List<Book >getBooks(Integer id){
        Librery temp=null;
        for (int i = 0; i < librerias.size(); i++) {
            
            if (librerias.get(i).getId() == id) {
                temp=librerias.get(i);
            }
            
        }
        return temp.getBooks();
    }
}
