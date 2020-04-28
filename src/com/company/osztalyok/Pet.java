package com.company.osztalyok;

import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Pet{

    private int id;
    private String nev;
    private String fajta;
    //private Year kor;
    private int kor;
    private boolean kedvencVagyokE;

    public Pet(int id, String nev, String fajta, int kor, boolean kedvencVagyokE) {
        this.id = id;
        this.nev = nev;
        this.fajta = fajta;
        this.kor = kor;
        this.kedvencVagyokE = kedvencVagyokE;
    }

    public Pet(String sor, boolean kedvencVagyokE) {

        String [] adatok = sor.split(",");

        this.id = Integer.parseInt(adatok[0]);
        this.nev = adatok[1];
        this.fajta = adatok[2];
        //DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy");
        //this.kor = Year.parse(adatok[3], format);
        this.kor = Integer.parseInt(adatok[3]);
        this.kedvencVagyokE = kedvencVagyokE;
    }

    public int getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    public String getFajta() {
        return fajta;
    }

    public int getKor() {
        return this.kor;
    }

    public boolean isKedvencVagyokE() {
        return kedvencVagyokE;
    }

    public boolean isOlderThanOwner(PetOwner p){
        boolean idosebbE = false;
        if (p.getEletkor() > this.kor) {
            idosebbE = true;
        }
        return idosebbE;
    }

    @Override
    public String toString() {
        return this.id + " " + this.nev + " " + this.fajta + " " + this.kor;
    }
}
