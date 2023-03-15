package com.example.project_library.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
public class LibraryCards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;
    @NotNull(message =  "Поле не может быть пустым")
    private Date date_open;
    @NotNull(message =  "Поле не может быть пустым")
    private Date date_close;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Readers readers;

    public LibraryCards() {
    }

    public LibraryCards(Date date_open, Date date_close, Readers readers) {
        this.date_open = date_open;
        this.date_close = date_close;
        this.readers = readers;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public Date getDate_open() {
        return date_open;
    }

    public void setDate_open(Date date_open) {
        this.date_open = date_open;
    }

    public Date getDate_close() {
        return date_close;
    }

    public void setDate_close(Date date_close) {
        this.date_close = date_close;
    }

    public Readers getReaders() {
        return readers;
    }

    public void setReaders(Readers readers) {
        this.readers = readers;
    }
}
