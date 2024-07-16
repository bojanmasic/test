package com.example.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="treneri")
public class Trainer {

    @Id
    private int id;
    private String ime;
    private String prezime;
    private Date datum_pocetka_rada;
    private String licenca;

    public Trainer(int id, String ime, String prezime, Date datum_pocetka_rada, String licenca) {
        super();
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datum_pocetka_rada = datum_pocetka_rada;
        this.licenca = licenca;
    }

    public Trainer() {
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

    public Date getDatum_pocetka_rada() {
        return datum_pocetka_rada;
    }

    public void setDatum_pocetka_rada(Date datum_pocetka_rada) {
        this.datum_pocetka_rada = datum_pocetka_rada;
    }

    public String getLicenca() {
        return licenca;
    }

    public void setLicenca(String licenca) {
        this.licenca = licenca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return id == trainer.id &&
                Objects.equals(ime, trainer.ime) &&
                Objects.equals(prezime, trainer.prezime) &&
                Objects.equals(datum_pocetka_rada, trainer.datum_pocetka_rada) &&
                Objects.equals(licenca, trainer.licenca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime, datum_pocetka_rada, licenca);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", datumPocetkaRada=" + datum_pocetka_rada +
                ", licenca='" + licenca + '\'' +
                '}';
    }

    public boolean compare(String ime, String prezime, String licenca) {
        return Objects.equals(this.ime, ime) &&
                Objects.equals(this.prezime, prezime) &&
                Objects.equals(this.licenca, licenca);
    }
}
