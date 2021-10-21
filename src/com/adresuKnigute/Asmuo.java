package com.adresuKnigute;

public class Asmuo {
    private
    String vardas, pavarde, miestas, telefonas;
    public
        // creates random contact
    Asmuo(){
        createContact();
    }

    // creates user intput contact
    Asmuo(String vardas, String pavarde, String miestas, String telefonas){
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.miestas = miestas;
        this.telefonas = telefonas;
    }

    public void setVardas(String vardas){
        this.vardas = vardas;
    }
    public void setPavarde(String pavarde){
        this.pavarde = pavarde;
    }
    public void setMiestas(String miestas){
        this.miestas = miestas;
    }
    public void setTelefonas(String telefonas){
        this.telefonas = telefonas;
    }

    public String getVardas(){
        return vardas;
    }
    public String getPavarde(){
        return pavarde;
    }
    public String getMiestas(){
        return miestas;
    }
    public String getTelefonas(){
        return telefonas;
    }

    // generate a person
    public void createContact(){
        Random_Kontaktu_Gen person = new Random_Kontaktu_Gen();
        setVardas(person.generateName());
        setPavarde(person.generateLastName());
        setTelefonas(person.generatePhoneNumber());
        setMiestas(person.randomCity());
    }
}
