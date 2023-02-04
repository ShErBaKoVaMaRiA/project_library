package com.example.project_library.Models;

import javax.persistence.*;

@Entity
public class BooksLibrary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private int numberrack;
    private int numbershelf;
    private int count;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Books books;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Sections sections;

    public BooksLibrary() {
    }


    public BooksLibrary(int numberrack, int numbershelf, int count, Books books, Sections sections) {
        this.numberrack = numberrack;
        this.numbershelf = numbershelf;
        this.count = count;
        this.books = books;
        this.sections = sections;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public int getNumberrack() {
        return numberrack;
    }

    public void setNumberrack(int numberrack) {
        this.numberrack = numberrack;
    }

    public int getNumbershelf() {
        return numbershelf;
    }

    public void setNumbershelf(int numbershelf) {
        this.numbershelf = numbershelf;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Sections getSections() {
        return sections;
    }

    public void setSections(Sections sections) {
        this.sections = sections;
    }
}
