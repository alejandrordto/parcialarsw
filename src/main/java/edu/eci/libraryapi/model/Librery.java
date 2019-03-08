package edu.eci.libraryapi.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;

/**
 *
 * @author cristian
 */
public class Librery {
    private Integer id;
    private String name;
    private String address;
    private Integer number;
    private List <Book> books;
   
    
    
    public Librery(){}

    public Librery(Integer id, String name, String address, Integer number, List<Book> books) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    public void addBook(Book book){
        books.add(book);
    }
    
    
    

}
