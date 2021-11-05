package com.adresuKnigute;

import javax.swing.*;
import java.util.Scanner;


class metodai{


    //1. Nurodytame mieste gyvenančių asmenų kiekio paieška;
    public void cityPopulation(Adresine knygute, String givenCity) {
        int kiekis=0;
        for( Asmuo i : knygute.getAsmenuKontaktai()){
            if(i.getMiestas().equals(givenCity)){
                kiekis++;
            }
        }
        System.out.println(" Siame mieste gyvena: " + kiekis + " gyventojai. ");
        System.out.println("\n");
    }

    //2. Paieška nurodžius vardą ir pavardę;
    public void searchByFirstNameAndLastName(Adresine knygute, String givenFirstName, String givenLastName) {
        boolean notFound = true;
        for( Asmuo i : knygute.getAsmenuKontaktai()){
            if(i.getVardas().equals(givenFirstName) && i.getPavarde().equals(givenLastName)){
                System.out.println(" Found: ");
                System.out.println(i.getVardas() +" " + i.getPavarde() + " " + i.getMiestas() + " " + i.getTelefonas());
                notFound = false;
            }
        }
        if(notFound){
            System.out.println(" Person not found in Adresu knygute");
        }
        System.out.println("\n");
    }

    //3. Paieška nurodžius vardą, pavardę ir miestą;
    public void searchByFirstNameAndLastNameAndCity( Adresine knygute, String givenFirstName, String givenLastName, String givenCity){

        boolean notFound1 = true;
        for (Asmuo i : knygute.getAsmenuKontaktai()) {
            if (i.getVardas().equals(givenFirstName) && i.getPavarde().equals(givenLastName) && i.getMiestas().equals(givenCity)) {
                System.out.println(" Found: ");
                System.out.println(i.getVardas() + " " + i.getPavarde() + " " + i.getMiestas() + " " + i.getTelefonas());
                notFound1 = false;
            }
        }
        if (notFound1) {
            System.out.println(" Person not found in Adresu knygute");
        }
        System.out.println("\n");
    }
    //3. Paieška nurodžius vardą, pavardę ir miestą UI
    public Adresine searchByFirstNameAndLastNameAndCityReturn( Adresine knygute, String givenFirstName, String givenLastName, String givenCity){
        Adresine paieskosRezultatai = new Adresine();
        boolean notFound1 = true;
        if ( givenLastName.equals("") && givenCity.equals("") ){
            for (Asmuo i : knygute.getAsmenuKontaktai()) {
                if (i.getVardas().equals(givenFirstName)) {
                    paieskosRezultatai.irasytiKontakta(i);
                    notFound1 = false;
                }
            }
        } else if (givenCity.equals("") ){
            for (Asmuo i : knygute.getAsmenuKontaktai()) {
                if (i.getVardas().equals(givenFirstName) && i.getPavarde().equals(givenLastName)) {
                    paieskosRezultatai.irasytiKontakta(i);
                    notFound1 = false;
                }
            }
        } else {
            for (Asmuo i : knygute.getAsmenuKontaktai()) {
                if (i.getVardas().equals(givenFirstName) && i.getPavarde().equals(givenLastName) && i.getMiestas().equals(givenCity)) {
                    paieskosRezultatai.irasytiKontakta(i);
                    notFound1 = false;
                }
            }
        }

        System.out.println("\n");
        return paieskosRezultatai;
    }

    //4. Rikiavimas
    public void rikiavimas(Adresine knygute){
        knygute.getAsmenuKontaktai().sort(new Rusiavimas().reversed());
    }
    //5. Failo nuskaitymas i adresine
    public void failoNuskaitymas(Adresine knygute){
        FailoNuskaitymas.nuskaityk(knygute);
    }

}

public class Main {
    public static void main(String[] args) {

        //        Asmuo asm = new Asmuo("tomas", "bance", "kns", "+370 670 44112");
//        System.out.println(asm.getMiestas());
//        asm.createContact();
//        System.out.println(asm.getMiestas());
//
//// generates 100 contats list
//        ArrayList <Asmuo> uzrasine = new ArrayList(100);
//        for(int i=0; i<100; i++){
//            Asmuo kont = new Asmuo();
//            uzrasine.add(kont);
//        }
//
//        for( int i=0; i<10; i++){
//            System.out.println(uzrasine.get(i).getVardas());
//        }
// generates 100 in adresine
//        Adresine knygute = new Adresine();
//        for( int i=0; i<10; i++){
//            Asmuo asmuo = new Asmuo();
//            knygute.irasytiKontakta(asmuo);
//        }

////Rusiavimas
//        knygute.getAsmenuKontaktai().sort(new Rusiavimas().reversed());
//
//// Nurodytame mieste gyvenančių asmenų kiekio paieška
//        String uzklausosMiestas = "Kaunas";
//        int kiekis=0;
//        for( Asmuo i : knygute.getAsmenuKontaktai()){
//            if(i.getMiestas() == uzklausosMiestas){
//                kiekis++;
//            }
//        }
//        System.out.println(" Siame mieste gyvena: " + kiekis + " gyventojai. ");
//// Paieška nurodžius vardą ir pavardę;
//        String paieskomasV = "Jackson";
//        String paieskomasP = "Johnson";
//        boolean notFound = true;
//        for( Asmuo i : knygute.getAsmenuKontaktai()){
//            if(i.getVardas() == paieskomasV && i.getPavarde() == paieskomasP){
//                System.out.println(" Found: ");
//                System.out.println(i.getVardas() +" " + i.getPavarde() + " " + i.getMiestas() + " " + i.getTelefonas());
//                notFound = false;
//            }
//        }
//        if(notFound){
//            System.out.println(" Person not found in Adresu knygute");
//        }
//// Paieška nurodžius vardą, pavardę ir miestą;
//        String givenFirstName = "Jackson";
//        String givenLastName = "Johnson";
//        String givenCity = "Kaunas";
//        boolean notFound1 = true;
//        for( Asmuo i : knygute.getAsmenuKontaktai()){
//            if(i.getVardas() == givenFirstName && i.getPavarde() == givenLastName && i.getMiestas() == givenCity){
//                System.out.println(" Found: ");
//                System.out.println(i.getVardas() +" " + i.getPavarde() + " " + i.getMiestas() + " " + i.getTelefonas());
//                notFound1 = false;
//            }
//        }
//        if(notFound1){
//            System.out.println(" Person not found in Adresu knygute");
//        }

        PagrindinisLangas langas = new PagrindinisLangas();
        langas.setTitle("Uzrasu knygute");
        langas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        langas.setSize(640,480);
        langas.setVisible(true);
        langas.setLocationRelativeTo(null);

        Adresine knygute = new Adresine();

        while(true){
            System.out.println("1- Adresatu random sugeneravimas ir perziura \n2- Atvaizduoti Adresine \n3- Nurodytame " +
                    "mieste gyvenančių asmenų kiekio skaiciavimas \n4- Paieška nurodžius vardą ir pavardę \n5- Paieška " +
                    "nurodžius vardą, pavardę ir miestą \n6- Rikiavimas pagal pavarde \n7- Nuskaitymas is failo \n0- Baigti darba ");
            Scanner klaviatura = new Scanner(System.in);
            int punktas = klaviatura.nextInt();
            if (punktas == 1){
                System.out.println("Iveskite norima adresatu skaiciu!");
                klaviatura=new Scanner(System.in);
                int kiek = klaviatura.nextInt();
                for( int i=0; i<kiek; i++){
                    Asmuo asmuo = new Asmuo();
                    knygute.irasytiKontakta(asmuo);
                }
                for( int i=0; i<kiek; i++){
                    System.out.println( "irasomi kontaktai: " + knygute.getAsmenuKontaktai().get(i).getVardas() + " "
                            + knygute.getAsmenuKontaktai().get(i).getPavarde() + " " +
                            knygute.getAsmenuKontaktai().get(i).getMiestas() + " " +
                            knygute.getAsmenuKontaktai().get(i).getTelefonas());
                }
                System.out.println("\n");
            } else if (punktas == 2){
                System.out.println("Atvaizduojama Adresine");
                for( int i=0; i<knygute.getAsmenuKontaktai().size(); i++){
                    System.out.println( knygute.getAsmenuKontaktai().get(i).getVardas() + " "
                            + knygute.getAsmenuKontaktai().get(i).getPavarde() + " " +
                            knygute.getAsmenuKontaktai().get(i).getMiestas() + " " +
                            knygute.getAsmenuKontaktai().get(i).getTelefonas());
                }
                System.out.println("\n");
            } else if (punktas == 3){
                System.out.println(" Iveskite Miesta");
                klaviatura=new Scanner(System.in);
                String givenCity = klaviatura.nextLine();
                metodai met2 = new metodai();
                met2.cityPopulation(knygute, givenCity);
                System.out.println("\n");
            } else if (punktas == 4) {
                System.out.println("Iveskite varda ir pavarde");
                klaviatura = new Scanner(System.in);
                String givenFirstName = klaviatura.nextLine();
                String givenLastName = klaviatura.nextLine();
                metodai met3 = new metodai();
                met3.searchByFirstNameAndLastName(knygute, givenFirstName, givenLastName);
            } else if (punktas == 5) {
                System.out.println("Iveskite varda ir pavarde ir miesta");
                klaviatura = new Scanner(System.in);
                String givenFirstName = klaviatura.nextLine();
                String givenLastName = klaviatura.nextLine();
                String givenCity = klaviatura.nextLine();
                metodai met4 = new metodai();
                met4.searchByFirstNameAndLastNameAndCity(knygute, givenFirstName, givenLastName, givenCity);
            } else if (punktas == 6) {
                metodai met1 = new metodai();
                met1.rikiavimas(knygute);
                System.out.println("Rikiavimas atliktas \n");
            } else if (punktas == 7) {
                metodai met5 = new metodai();
                met5.failoNuskaitymas(knygute);
            } else if (punktas == 0) {
                break;
            }
        }
        //                    cout << "Adresatu random sugeneravimas ir perziura" << endl;
//                    randomKontoaktuGeneravimas(*adresuKnyga);
//                    break;
//                case 2:
//                    cout << "Adresatu nuskaitymas is failo ir perziura" << endl;
//                    kontaktuIvedimasIsFailo(*adresuKnyga);
//                    break;
//                case 3:
//                    cout << "Nurodytame mieste gyvenanciu asmenu kiekio paieska" << endl;
//                    asmenuSkaiciavimas(*adresuKnyga);
//                    break;
//                case 4:
//                    cout << "Paieska nurodzius varda ir pavarde" << endl;
//                    paieskaPagalVardasPavarde(*adresuKnyga);
//                    break;
//                case 5:
//                    cout << "Paieska nurodzius varda, pavarde ir miesta" << endl;
//                    paieskaPagalVardasPavardeMiestas(*adresuKnyga);
//                    break;
//                case 6:
//                    cout << "Rikiavimas pagal pavarde ir miesta" << endl;
//                    rikiavimasPagalVardasaMiestas(*adresuKnyga);
//                    //adresuKnyga->exportuotiIFaila(); kontaktu EXPORTAVIMAS i faila
//
//                    break;
//                case 7:
//                    cout << "Programa baigia darba" << endl;
//                    break;
//                default:
//                    cout << "Pasirinktas variantas negalimas prasau pasirinkti is naujo" << endl;
//                    break;



//        String givenFirstName = "Jackson";
//        String givenLastName = "Johnson";
//        String givenCity = "Kaunas";
//
//        metodai met1 = new metodai();
//        met1.rikiavimas(knygute);
//
//        metodai met2 = new metodai();
//        met2.cityPopulation(knygute, givenCity);
//
//        metodai met3 = new metodai();
//        met3.searchByFirstNameAndLastName(knygute, givenFirstName, givenLastName);
//
//        metodai met4 = new metodai();
//        met4.searchByFirstNameAndLastNameAndCity(knygute, givenFirstName, givenLastName, givenCity);
//
//        metodai met5 = new metodai();
//        met5.failoNuskaitymas();



//        for( int i=0; i<10; i++){
//            System.out.println( "irasomi kontaktai: " + knygute.asmenuKontaktai.get(i).getVardas() + " " + knygute.asmenuKontaktai.get(i).getPavarde()
//            + " " + knygute.asmenuKontaktai.get(i).getMiestas() + " " + knygute.asmenuKontaktai.get(i).getTelefonas()); }
    }

}



