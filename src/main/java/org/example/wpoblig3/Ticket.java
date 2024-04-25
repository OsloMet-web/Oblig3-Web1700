package org.example.wpoblig3;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String filmName;
    private String forNavn;
    private String etterNavn;
    private int count;
    private String email;
    private String telNummer;

    public Ticket() {}

    public Ticket(String filmName, String forNavn, String etterNavn, int count, String email) {
        this.filmName = filmName;
        this.forNavn = forNavn;
        this.etterNavn = etterNavn;
        this.count = count;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFilmName() {
        return filmName;
    }
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
    public String getForNavn() {
        return forNavn;
    }
    public void setForNavn(String forNavn) {
        this.forNavn = forNavn;
    }
    public String getEtterNavn() {
        return etterNavn;
    }
    public void setEtterNavn(String etterNavn) {
        this.etterNavn = etterNavn;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelNummer() {
        return telNummer;
    }
    public void setTelNummer(String telNummer) {
        this.telNummer = telNummer;
    }

}
