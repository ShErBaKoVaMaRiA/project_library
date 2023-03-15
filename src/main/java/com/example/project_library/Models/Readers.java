package com.example.project_library.Models;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity
public class Readers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;
    @NotEmpty(message =  "Поле не может быть пустым")
    private String surname;
    @NotEmpty(message =  "Поле не может быть пустым")
    private String name;
    private String middlename;

    @NotNull(message =  "Поле не может быть пустым")
    private Date datebirthday;
    @NotEmpty(message =  "Поле не может быть пустым")
    @Size(min=10,max=11, message="Паспорт заполнен неверно")
    private String passport;
    @NotEmpty(message =  "Поле не может быть пустым")
    @Pattern(regexp="^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",message="Неверный формат")
    private String telefon;


    public Readers() {
    }

    public Readers(String surname, String name, String middlename, Date datebirthday, String passport, String telefon) {
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.datebirthday = datebirthday;
        this.passport = passport;
        this.telefon = telefon;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Date getDatebirthday() {
        return datebirthday;
    }

    public void setDatebirthday(Date datebirthday) {
        this.datebirthday = datebirthday;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
