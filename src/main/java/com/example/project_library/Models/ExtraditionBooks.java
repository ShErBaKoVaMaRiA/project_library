package com.example.project_library.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class ExtraditionBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private Date dateextradition;
    private Date datereturn;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Books books;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private LibraryCards libraryCards;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Employees employees;

    public ExtraditionBooks() {
    }


    public ExtraditionBooks(Date dateextradition, Date datereturn, Books books, LibraryCards libraryCards, Employees employees) {
        this.dateextradition = dateextradition;
        this.datereturn = datereturn;
        this.books = books;
        this.libraryCards = libraryCards;
        this.employees = employees;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public Date getDateextradition() {
        return dateextradition;
    }

    public void setDateextradition(Date dateextradition) {
        this.dateextradition = dateextradition;
    }

    public Date getDatereturn() {
        return datereturn;
    }

    public void setDatereturn(Date datereturn) {
        this.datereturn = datereturn;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public LibraryCards getLibraryCards() {
        return libraryCards;
    }

    public void setLibraryCards(LibraryCards libraryCards) {
        this.libraryCards = libraryCards;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
}
