package com.example.project_library.Models;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;


@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;
    @NotNull(message =  "Поле не может быть пустым")
    private String surname;
    @NotNull(message =  "Поле не может быть пустым")
    private String name;
    private String middlename;
    @NotNull(message =  "Поле не может быть пустым")
    @Past(message="Значение должно бть прошедшего времени")
    private Date datebirthday;
    @NotNull(message =  "Поле не может быть пустым")
    private String passport;
    @Pattern(regexp="^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",message="Неверный формат")
    @NotNull(message =  "Поле не может быть пустым")
    private String telefon;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Divisions divisions;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Positions positions;

    public Employees() {
    }

    public Employees(String surname, String name, String middlename, Date datebirthday, String passport, String telefon, Divisions divisions,Positions positions) {
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.datebirthday = datebirthday;
        this.passport = passport;
        this.telefon = telefon;
        this.positions = positions;
        this.divisions = divisions;
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

    public Positions getPositions() {
        return positions;
    }

    public void setPositions(Positions positions) {
        this.positions = positions;
    }

    public Divisions getDivisions() {
        return divisions;
    }

    public void setDivisions(Divisions divisions) {
        this.divisions = divisions;
    }
}
