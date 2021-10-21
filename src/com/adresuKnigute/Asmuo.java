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

    void setVardas(String vardas){
        this.vardas = vardas;
    }
    void setPavarde(String pavarde){
        this.pavarde = pavarde;
    }
    void setMiestas(String miestas){
        this.miestas = miestas;
    }
    void setTelefonas(String telefonas){
        this.telefonas = telefonas;
    }

    String getVardas(){
        return vardas;
    }
    String getPavarde(){
        return pavarde;
    }
    String getMiestas(){
        return miestas;
    }
    String getTelefonas(){
        return telefonas;
    }

    // generate a person
    void createContact(){
        Random_Kontaktu_Gen person = new Random_Kontaktu_Gen();
        setVardas(person.generateName());
        setPavarde(person.generateLastName());
        setTelefonas(person.generatePhoneNumber());
        setMiestas(person.randomCity());
    }
}
