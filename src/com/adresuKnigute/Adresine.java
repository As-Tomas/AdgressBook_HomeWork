package com.adresuKnigute;

import java.util.ArrayList;

public class Adresine {
    private
    ArrayList<Asmuo> asmenuKontaktai = new ArrayList();
    private
    int kontaktuSkaicius;

    public
    Adresine() {
        kontaktuSkaicius = 0;
    }

    public ArrayList<Asmuo> getAsmenuKontaktai() {
        return asmenuKontaktai;
    }

    public void setKontaktuSkaicius(int kiek) {kontaktuSkaicius = kiek;}
    public int getKontaktuSkaicius(){ return kontaktuSkaicius;}


    public void irasytiKontakta(Asmuo asmensKontaktas) {
        this.asmenuKontaktai.add(kontaktuSkaicius, asmensKontaktas);
        kontaktuSkaicius++;
    }

    public void istryntiKontakta(int indekas){
        asmenuKontaktai.get(indekas).setVardas("") ;
        asmenuKontaktai.get(indekas).setPavarde("");
        asmenuKontaktai.get(indekas).setTelefonas("");
        asmenuKontaktai.get(indekas).setMiestas("") ;
    }
    //    void pagalPavarde(){
//        Arrays.sort(asmenuKontaktai.get().getPavarde());
//    }

//    //4. Rikiavimas pagal pavardę ir miestą.
//    void sortByLastNameAndCity() {
//        Arrays.sort(kontaktuSkaicius.);
//        for (int i = 0; i < kontaktuSkaicius; i++) {
//            for (int j = i + 1; j < kontaktuSkaicius; j++) {
//                if (asmenuKontaktai.get(i).getPavarde().compareTo(asmenuKontaktai.get(j).getPavarde()) ) {
//                    Collections.swap(asmenuKontaktai, i, j);
//                }
//                if (asmenuKontaktai[i].getMiestas() > asmenuKontaktai[j].getMiestas()) {
//                    Collections.swap(asmenuKontaktai, i, j);
//                }
//            }
//        }
//    }

    //4. Rikiavimas pagal pavardę ir miestą.
//    void sortByLastNameAndCity() {
//        for (int i = 0; i < kontaktuSkaicius; i++) {
//            for (int j = i + 1; j < kontaktuSkaicius; j++) {
//                if (asmenuKontaktai.get(i).getPavarde() > asmenuKontaktai.get(j).getPavarde()) {
//                    swap(asmenuKontaktai[i], asmenuKontaktai[j]);
//                }
//                if (asmenuKontaktai[i].getMiestas() > asmenuKontaktai[j].getMiestas()) {
//                    swap(asmenuKontaktai[i], asmenuKontaktai[j]);
//                }
//            }
//        }
//    }
//
//    void isvestis() {
//        for (int i = 0; i < kontaktuSkaicius; i++) {
//            cout << asmenuKontaktai[i].getVardas() << " " << asmenuKontaktai[i].getPavarde() << " "
//                    << asmenuKontaktai[i].getMiestas() << endl;
//        }
//    }
//    //2. Paieška nurodžius vardą ir pavardę;
//    void searchByFirstNameAndLastName(string givenFirstName, string givenLastName) {
//        bool notFound = true;
//        for (int i = 0; i < kontaktuSkaicius; i++) {
//            if (asmenuKontaktai[i].getVardas() == givenFirstName && asmenuKontaktai[i].getPavarde() == givenLastName) {
//                notFound = false;
//                cout << asmenuKontaktai[i].getVardas() << " ";
//                cout << asmenuKontaktai[i].getPavarde() << endl;
//                cout << asmenuKontaktai[i].getMiestas() << endl;
//                cout << asmenuKontaktai[i].getTelefonas() << "\n" << endl;
//            }
//        }
//        if (notFound) {
//            cout << "Asmuo tokiu vardu ir pavarde nerastas! \n " << endl;
//        }
//    }
//
//    //1. Nurodytame mieste gyvenančių asmenų kiekio paieška;
//    int cityPopulation(string givenCity) {
//        int count = 0;
//        for (int i = 0; i < kontaktuSkaicius; i++) {
//            if (asmenuKontaktai[i].getMiestas() == givenCity) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    //3. Paieška nurodžius vardą, pavardę ir miestą;
//    void searchByFirstNameAndLastNameAndCity(string givenFirstName, string givenLastName, string givenCity) {
//        bool notFound = true;
//        for (int i = 0; i < kontaktuSkaicius; i++) {
//            if (asmenuKontaktai[i].getVardas() == givenFirstName && asmenuKontaktai[i].getPavarde() == givenLastName &&
//                    asmenuKontaktai[i].getMiestas() == givenCity) {
//                notFound = false;
//                cout << asmenuKontaktai[i].getVardas() << " ";
//                cout << asmenuKontaktai[i].getPavarde() << endl;
//                cout << asmenuKontaktai[i].getMiestas() << endl;
//                cout << asmenuKontaktai[i].getTelefonas() << "\n" << endl;
//            }
//        }
//        if (notFound) {
//            cout << "Asmuo tokiu vardu ir pavarde nerastas mieste: " << givenCity << "\n" << endl;
//        }
//    }
//
//    void exportuotiIFaila() {
//        FailoIrasymas failas("Exported_Contacts.txt");
//        for (int i = 0; i < kontaktuSkaicius; i++) {
//            failas.irasytiZodi(asmenuKontaktai[i].getVardas());
//            failas.tarpas();
//            failas.irasytiZodi(asmenuKontaktai[i].getPavarde());
//            failas.tarpas();
//            failas.irasytiZodi(asmenuKontaktai[i].getMiestas());
//            failas.tarpas();
//            failas.irasytiZodi(asmenuKontaktai[i].getTelefonas());
//            failas.naujaEilute();
//        }
//    };
//
//  };
}
