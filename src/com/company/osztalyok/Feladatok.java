package com.company.osztalyok;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Feladatok {

    private List<PetOwner> tulajLista;
    private List<Pet> allatLista;

    public Feladatok(String tulajFajlNev, String allatFajlNev) {

        this.tulajLista = new LinkedList<>();
        this.allatLista = new LinkedList<>();

        //pets.txt
        try{
            FileReader fr = new FileReader(allatFajlNev);
            BufferedReader br = new BufferedReader(fr);

            String sor = br.readLine();
            int szamlalo = 0;
            while (sor != null){
                boolean kedvencVagyokE = szamlalo == 0;
                this.allatLista.add(new Pet(sor, kedvencVagyokE));
                sor = br.readLine();
                szamlalo = 1;
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Hiba: " + e);
            e.printStackTrace();
        }

        //petowners.txt
        try{
            FileReader fr = new FileReader(tulajFajlNev);
            BufferedReader br = new BufferedReader(fr);

            String sor = br.readLine();
            while (sor != null){

                this.tulajLista.add(new PetOwner(sor, this.allatLista.get(0)));
                sor = br.readLine();
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Hiba: " + e);
            e.printStackTrace();
        }

    }

    public List<PetOwner> getTulajLista() {
        return tulajLista;
    }

    public List<Pet> getAllatLista() {
        return allatLista;
    }

    public void elsoFeladat(){
        System.out.println("1. feladat: ");

        List<PetOwner> rendezett = this.tulajLista.stream()
                .sorted(Comparator.comparing(PetOwner::getEletkor))
                .collect(Collectors.toList());

        for (PetOwner i : rendezett) {
            System.out.println(i.getNev());
            for (Pet p : this.allatLista) {
                if (IntStream.of(i.getKedvencIdk()).anyMatch(x -> x == p.getId())) {
                    System.out.println("\t" + p.getNev());
                }
            }
        }
    }

    public void masodikFeladat(){
        System.out.println("2. feladat: ");

        List<Pet> rendezett = this.allatLista.stream()
                .sorted(Comparator.comparing(Pet::getKor))
                .collect(Collectors.toList());

        for (Pet p : rendezett) {
            System.out.println(p.getNev());
            for (PetOwner po : this.tulajLista) {
                if (IntStream.of(po.getKedvencIdk()).anyMatch(x -> x == p.getId())) {
                    System.out.println("\t" + po.getNev());
                }
            }
        }

    }

    public void harmadikFeladat(){
        System.out.println("3. feladat: ");

        List<String> lista = new ArrayList<>();

        for (PetOwner p : this.tulajLista) {
            for (Pet po : this.allatLista) {
                if (p.getEletkor() > po.getKor()) {
                    if (!lista.contains(p.getNev())){
                        lista.add(p.getNev());
                    }
                }
            }
        }
        for (String s : lista) {
            System.out.println(s);
        }
    }

    public void negyedikFeladat(){ //VISSZA!!!
        System.out.println("4. feladat: ");
        boolean ertek = false;

        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Kérem adja meg egy háziállat nevét: ");
            String megadottNev = sc.nextLine();

            for (Pet p : this.allatLista) {
                if (p.getNev().equals(megadottNev)){
                    ertek = true;
                    for (PetOwner po : this.tulajLista) {
                        if (IntStream.of(po.getKedvencIdk()).anyMatch(x -> x == p.getId())) {
                            System.out.println(po.getNev());
                        }
                    }
                }

            }
            if (!ertek) System.out.println("Nincs ilyen név!");
        } while (!ertek);
    }

    public void otodikFeladat(){
        System.out.println("5. feladat: ");
        boolean ertek = false;

        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Kérem adja meg egy gazda nevét: ");
            String megadottNev = sc.nextLine();

            for (PetOwner po : this.tulajLista) {
                if (po.getNev().equals(megadottNev)){
                    ertek = true;
                    for (Pet p : this.allatLista) {
                        if (IntStream.of(po.getKedvencIdk()).anyMatch(x -> x == p.getId())) {
                            System.out.println(p.getNev());
                        }
                    }
                }
            }
            if (!ertek) System.out.println("Nincs ilyen név!");
        } while (!ertek);
    }

    public void hatodikFeladat(){
        System.out.println("6. feladat: ");

        PetOwner legtobbTulaj = this.tulajLista.get(0);
        for (PetOwner p : this.tulajLista) {
            if (p.getKedvencIdk().length > legtobbTulaj.getKedvencIdk().length) {
                legtobbTulaj = p;
            }
        }
        System.out.println(legtobbTulaj.getNev());
    }

    public int getPetCount(PetOwner szemely){
        return szemely.getKedvencIdk().length;
    }

    public void nyolcadikFeladat(){
        System.out.println("8. feladat: ");

        PetOwner legidosebbAllattalRendelkezo = this.tulajLista.get(0);
        for (PetOwner po : this.tulajLista) {
            if (po.getKedvencAllat().getKor() > legidosebbAllattalRendelkezo.getKedvencAllat().getKor()) {
                legidosebbAllattalRendelkezo = po;
            }
        }
        System.out.println(legidosebbAllattalRendelkezo.getNev());

        PetOwner legfiatalabbAllattalRendelkezo = this.tulajLista.get(0);
        for (PetOwner po : this.tulajLista) {
            if (po.getKedvencAllat().getKor() < legfiatalabbAllattalRendelkezo.getKedvencAllat().getKor()) {
                legfiatalabbAllattalRendelkezo = po;
            }
        }
        System.out.println(legfiatalabbAllattalRendelkezo.getNev());
    }

    public String getPopuparFirstLetter(){

        List<String> lista = this.allatLista.stream()
                .map(Pet::getNev)
                .collect(Collectors.toList());

        Map<String, Long> keszMap = lista.stream()
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));

        String leggyakoribbSzo = "";
        long szamlalo = 0;
        for (Map.Entry<String, Long> i : keszMap.entrySet()) {
            if (szamlalo < i.getValue()) {
                    szamlalo = i.getValue();
                    leggyakoribbSzo = i.getKey();
            }
        }
        String leggyakoribbBetu = String.valueOf(leggyakoribbSzo.charAt(0));
        return leggyakoribbBetu;
    }

    @Override
    public String toString() {

        String s = "";
        for (PetOwner i : this.tulajLista) {
            s += i + "\n";
            for (Pet p : this.allatLista) {
                if (IntStream.of(i.getKedvencIdk()).anyMatch(x -> x == p.getId())) {
                    s += "\t" + p + "\n";
                }
            }
            s += "\n";
        }
        return s;
    }
}
