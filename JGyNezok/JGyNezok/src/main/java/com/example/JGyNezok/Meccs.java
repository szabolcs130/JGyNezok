package com.example.JGyNezok;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Meccs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate datum;

    private LocalTime kezdes;

    private Double belepo;

    private String tipus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalTime getKezdes() {
        return kezdes;
    }

    public void setKezdes(LocalTime kezdes) {
        this.kezdes = kezdes;
    }

    public Double getBelepo() {
        return belepo;
    }

    public void setBelepo(Double belepo) {
        this.belepo = belepo;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
}
