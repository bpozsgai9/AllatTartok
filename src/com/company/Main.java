package com.company;

import com.company.osztalyok.Feladatok;

public class Main {

    public static void main(String[] args) {
        Feladatok f = new Feladatok(
                "src/com/company/forras/petowners.txt",
                "src/com/company/forras/pets.txt");

        //System.out.println(f);
        f.elsoFeladat();
        System.out.println();

        f.masodikFeladat();
        System.out.println();

        f.harmadikFeladat();
        System.out.println();

        f.negyedikFeladat();
        System.out.println();

        f.otodikFeladat();
        System.out.println();

        f.hatodikFeladat();
        System.out.println();

        System.out.println(f.getPopuparFirstLetter());
        System.out.println();




    }
}
