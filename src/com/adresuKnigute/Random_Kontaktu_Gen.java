package com.adresuKnigute;
import java.util.concurrent.ThreadLocalRandom;

public class Random_Kontaktu_Gen {
    static String firstNames[] = {"Emma","Noah","Olivia","Liam","Ava","William","Sophia","Mason","Isabella","James","Mia","Benjamin","Charlotte","Jacob","Abigail","Michael","Emily","Elijah","Harper","Ethan","Amelia","Alexander","Evelyn","Oliver","Elizabeth","Daniel","Sofia","Lucas","Madison","Matthew","Avery","Aiden","Ella","Jackson","Scarlett","Logan","Grace","David","Chloe","Joseph","Victoria","Samuel","Riley","Henry","Aria","Owen","Lily","Sebastian","Aubrey","Gabriel","Zoey","Carter","Penelope","Jayden","Lillian","John","Addison","Luke","Layla","Anthony","Natalie","Isaac","Camila","Dylan","Hannah","Wyatt","Brooklyn","Andrew","Zoe","Joshua","Nora","Christopher","Leah","Grayson","Savannah","Jack","Audrey","Julian","Claire","Ryan","Eleanor","Jaxon","Skylar","Levi","Ellie","Nathan","Samantha","Caleb","Stella","Hunter","Paisley","Christian","Violet","Isaiah","Mila","Thomas","Allison","Aaron","Alexa","Lincoln"};

//Num of lastnames 61
    static String lastNames[] = {"Smith","Jones","Brown","Johnson","Williams","Miller","Taylor","Wilson","Davis","White","Clark","Hall","Thomas","Thompson","Moore","Hill","Walker","Anderson","Wright","Martin","Wood","Allen","Robinson","Lewis","Scott","Young","Jackson","Adams","Tryniski","Green","Evans","King","Baker","John","Harris","Roberts","Campbell","James","Stewart","Lee","County","Turner","Parker","Cook","Mc","Edwards","Morris","Mitchell","Bell","Ward","Watson","Morgan","Davies","Cooper","Phillips","Rogers","Gray","Hughes","Harrison","Carter","Murphy"};

//Num of cities 11
    static String cities[] = {"Vilnius", "Kaunas", "Klaipeda", "Siauliai", "Alytus", "Utena", "Prienai", "Druskininkai", "Palanga", "Elektrenai", "Ukmerge"};


//---------------------------------------------------------------------

    // generate a random number between min and max

    public int randomNr(int min, int max) {
        int randomNumber;
        do{
            randomNumber = ThreadLocalRandom.current().nextInt(min, max);
        } while (!(min <= randomNumber && max >= randomNumber));
        return randomNumber;
    }

    // generate a name
    public String generateName1(String firstNames[], String lastNames[] ){
        return firstNames[randomNr(0, 10)] + lastNames[randomNr(0, 10)];
    }

    // generate a first name
    public String generateName(){
        return firstNames[randomNr(0, 99)];
    }

    // generate a last name
    public String generateLastName(){
        String lastName;
        return lastName = lastNames[randomNr(0, 10)];
    }

    // generate phone number +xxx xxx xxxxx
    public String generatePhoneNumber(){
        String phoneApendix = "+";
        String contryCode = "370 ";
        String networkCode = (randomNr(100, 999)) + " ";
        String number = (randomNr(10000, 99999)) + " ";
        return phoneApendix + contryCode + networkCode + number;
    }
    // generate city
    public String randomCity(){
        return cities[randomNr(0, 10)];
    }

}
