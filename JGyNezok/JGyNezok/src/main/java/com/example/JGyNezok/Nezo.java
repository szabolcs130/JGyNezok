package com.example.JGyNezok;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Nezo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nev;

    private Boolean ferfi;

    private Boolean berletes;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Boolean getFerfi() {
        return ferfi;
    }

    public void setFerfi(Boolean ferfi) {
        this.ferfi = ferfi;
    }

    public Boolean getBerletes() {
        return berletes;
    }

    public void setBerletes(Boolean berletes) {
        this.berletes = berletes;
    }
}
