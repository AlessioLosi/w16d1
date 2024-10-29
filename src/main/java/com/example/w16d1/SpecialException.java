package com.example.w16d1;

public class SpecialException extends RuntimeException {
    public SpecialException(int id) {
        super("Il record con id " + id + " non è stato trovato");
    }
}
