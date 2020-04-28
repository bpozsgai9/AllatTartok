package com.company.osztalyok;

import java.time.Year;
import java.time.format.DateTimeFormatter;

public class PetOwner {

    private String nev;
    //private Year eletkor;
    private int eletkor;
    private String nem;
    private int[] kedvencIdk;
    private Pet kedvencAllat;

    public PetOwner(String nev, int eletkor, String nem, int[] kedvencIdk, Pet kedvencAllat) {
        this.nev = nev;
        this.eletkor = eletkor;
        this.nem = nem;
        this.kedvencIdk = kedvencIdk;
        this.kedvencAllat = kedvencAllat;
    }

    public PetOwner(String sor, Pet kedvencAllat) {
        String [] adatok = sor.split(",");

        this.nev = adatok[0];
        //DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy");
        //this.eletkor = Year.parse(adatok[1], format);
        this.eletkor = Integer.parseInt(adatok[1]);
        this.nem = adatok[2];
        this.kedvencIdk = new int[adatok.length - 3];
        int kedvencI = 0;
        for (int i = 3; i < adatok.length; i++) {
            this.kedvencIdk[kedvencI] = Integer.parseInt(adatok[i]);
            kedvencI++;
        }
        this.kedvencAllat = kedvencAllat;
    }

    public String getNev() {
        return nev;
    }

    public int getEletkor() {
        return eletkor;
    }

    public String getNem() {
        return nem;
    }

    public int[] getKedvencIdk() {
        return kedvencIdk;
    }

    public Pet getKedvencAllat() {
        return kedvencAllat;
    }

    @Override
    public String toString() {

        String s = "";
        s += this.nev + " " + this.eletkor + " " + this.nem + " [ ";
        for (int i = 0; i < this.kedvencIdk.length; i++) {
            s += this.kedvencIdk[i] + "; ";
        }
        s += " ]";
        return s;
    }
}
