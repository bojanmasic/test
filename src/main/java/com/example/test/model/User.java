package com.example.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="korisnici")
public class User {

    @Id
    private int id;
    private String ime;
    private String prezime;
    private Date datum_rodjenja;
    private String email;
    private String telefonski_broj;
    private Date datum_uclanjenja;

    public User(int id, String ime, String prezime, Date datum_rodjenja, String email, String telefonski_broj, Date datum_uclanjenja) {
        super();
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodjenja = datum_rodjenja;
        this.email = email;
        this.telefonski_broj = telefonski_broj;
        this.datum_uclanjenja = datum_uclanjenja;
    }

    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonski_broj() {
        return telefonski_broj;
    }

    public void setTelefonski_broj(String telefonski_broj) {
        this.telefonski_broj = telefonski_broj;
    }

    public Date getDatum_uclanjenja() {
        return datum_uclanjenja;
    }

    public void setDatum_uclanjenja(Date datum_uclanjenja) {
        this.datum_uclanjenja = datum_uclanjenja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(ime, user.ime) &&
                Objects.equals(prezime, user.prezime) &&
                Objects.equals(datum_rodjenja, user.datum_rodjenja) &&
                Objects.equals(email, user.email) &&
                Objects.equals(telefonski_broj, user.telefonski_broj) &&
                Objects.equals(datum_uclanjenja, user.datum_uclanjenja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime, datum_rodjenja, email, telefonski_broj, datum_uclanjenja);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", datumRodjenja=" + datum_rodjenja +
                ", email='" + email + '\'' +
                ", telefonskiBroj='" + telefonski_broj + '\'' +
                ", datumUclanjenja=" + datum_uclanjenja +
                '}';
    }
    public boolean compare(String ime, String prezime, String email, String telefonskiBroj) {
        return Objects.equals(this.ime, ime) &&
                Objects.equals(this.prezime, prezime) &&
                Objects.equals(this.email, email) &&
                Objects.equals(this.telefonski_broj, telefonskiBroj);
    }
}