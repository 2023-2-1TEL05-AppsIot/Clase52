package com.example.clase5.entity;

import java.io.Serializable;

public class Persona implements Serializable {

    private String dni;

    public Persona() {
    }

    public Persona(String dniStr) {
        this.dni = dniStr;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
