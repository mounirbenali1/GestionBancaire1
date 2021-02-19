package com.example.gestionbancaire1.model;

import java.time.LocalDate;


public class Operation {
    private Integer num;
    private String montant;
    private String date;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Operation(Integer num, String montant, String date) {
        this.num = num;
        this.montant = montant;
        this.date = date;
    }
}
