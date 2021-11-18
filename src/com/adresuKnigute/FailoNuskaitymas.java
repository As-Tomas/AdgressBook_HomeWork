package com.adresuKnigute;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FailoNuskaitymas {
    public static void nuskaityk(Adresine knygute) {
        String vardas, pavarde, miestas, telefonas1, telefonas2, telefonas3;
        try {
            File myObj = new File("C:\\Users\\kalia\\IdeaProjects\\AdresuKnigute_1_Sav-Darbas\\out\\KontaktuSarasas.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                vardas = myReader.next();
                pavarde = myReader.next();
                miestas = myReader.next();
                telefonas1 = myReader.next();
                telefonas2 = myReader.next();
                telefonas3 = myReader.next();
                Asmuo asm = new Asmuo(vardas, pavarde, miestas, telefonas1+" " + telefonas2 + " " +telefonas3);
                knygute.irasytiKontakta(asm);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

