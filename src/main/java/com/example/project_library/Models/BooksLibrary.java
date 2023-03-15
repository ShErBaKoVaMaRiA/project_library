package com.example.project_library.Models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class BooksLibrary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;
    @NotNull(message =  "Поле не может быть пустым")
    @Min(value=1, message="Значение в поле не может быть меньше 1")
    private int numberrack;
    @NotNull(message =  "Поле не может быть пустым")
    @Min(value=1, message="Значение в поле не может быть меньше 1")
    private int numbershelf;
    @NotNull(message =  "Поле не может быть пустым")
    @Min(value=0, message="Значение в поле не может быть меньше 0")
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
