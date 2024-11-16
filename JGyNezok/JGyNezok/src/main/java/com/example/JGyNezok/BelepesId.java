package com.example.JGyNezok;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BelepesId implements Serializable {

    private int nezoid;  // `Long` helyett `int`
    private int meccsid; // `Long` helyett `int`

    // Alapértelmezett konstruktor
    public BelepesId() {}

    // Paraméteres konstruktor
    public BelepesId(int nezoid, int meccsid) {
        this.nezoid = nezoid;
        this.meccsid = meccsid;
    }

    // Getters and setters
    public int getNezoid() {
        return nezoid;
    }

    public void setNezoid(int nezoid) {
        this.nezoid = nezoid;
    }

    public int getMeccsid() {
        return meccsid;
    }

    public void setMeccsid(int meccsid) {
        this.meccsid = meccsid;
    }

    // equals és hashCode metódusok
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BelepesId that = (BelepesId) o;

        if (nezoid != that.nezoid) return false;
        return meccsid == that.meccsid;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(nezoid);  // `hashCode` módosítása
        result = 31 * result + Integer.hashCode(meccsid);  // `hashCode` módosítása
        return result;
    }
}
