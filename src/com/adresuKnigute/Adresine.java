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
}
