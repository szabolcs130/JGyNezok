package com.example.JGyNezok;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
public class Belepes implements Serializable {

    @EmbeddedId
    private BelepesId id;

    @ManyToOne
    @JoinColumn(name = "nezoid", insertable = false, updatable = false)
    private Nezo nezo;

    @ManyToOne
    @JoinColumn(name = "meccsid", insertable = false, updatable = false)
    private Meccs meccs;

    private LocalTime idopont;

    public BelepesId getId() {
        return id;
    }

    public void setId(BelepesId id) {
        this.id = id;
    }

    public LocalTime getIdopont() {
        return idopont;
    }

    public void setIdopont(LocalTime idopont) {
        this.idopont = idopont;
    }

    public Nezo getNezo() {
        return nezo;
    }

    public void setNezo(Nezo nezo) {
        this.nezo = nezo;
    }

    public Meccs getMeccs() {
        return meccs;
    }

    public void setMeccs(Meccs meccs) {
        this.meccs = meccs;
    }
}
