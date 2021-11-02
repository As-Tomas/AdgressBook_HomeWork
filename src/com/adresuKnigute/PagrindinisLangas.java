package com.adresuKnigute;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class PagrindinisLangas extends JFrame implements ActionListener{

    JTable lentele;//lentele, kur perziurimi failo duomenys
    //Tai lenteles modelio (kiek ir kokie stulpeliai, be to, galima nurodyti ir lenteles turini
    DefaultTableModel lentelesModelis;

    PagrindinisLangas(){
        Container cont=getContentPane();
        cont.setLayout(new BorderLayout());

        JMenuBar pagrindinisMeniu=new JMenuBar();//meniu juosta
        JMenu failas=new JMenu("Failas");//Meniu komandu grupe
        failas.setMnemonic(KeyEvent.VK_F);//Spartieji klavisai, veiks su Alt+F

        JMenuItem katalog=new JMenuItem("Atidaryti kataloga...");//Atskira komanda
        katalog.addActionListener(this);//pacio Pagrindinio lango actionPerformed() apdoros
        katalog.setMnemonic(KeyEvent.VK_O);

        JMenuItem close=new JMenuItem("Baigti darba");
        close.addActionListener(this);

        //I failas meniu komandu grupe idedam "Atidaryti kataloga...", separatoriu ir "Baigti darba"
        failas.add(katalog);
        failas.addSeparator();
        failas.add(close);

        pagrindinisMeniu.add(failas);//i meniu juosta idedam faila
        setJMenuBar(pagrindinisMeniu);//idedam meniu juosta i langa

        //Lentele
        String stulpeliuVardai[]=new String[5];
        stulpeliuVardai[0]="Numeris";
        stulpeliuVardai[1]="Vardas";
        stulpeliuVardai[2]="Pavarde";
        stulpeliuVardai[3]="Miestas";
        stulpeliuVardai[4]="Telfono Nr.";

        Object duomenys[][]=new Object[0][0];//sukuriame kolkas tuscia masyva, kur bus laikomi lenteles duomenys
        lentelesModelis = new DefaultTableModel(duomenys,stulpeliuVardai);//sukuriame lenteles modeli, paduodame lenteles turinio masyva (dvimati) ir lenteles stulpeliu masyva
        lentele=new JTable(lentelesModelis);

        //Jei norime prasukti elementa, dedam ji i JScrollPane objekta
        JScrollPane scrollPane=new JScrollPane(lentele);
        cont.add(scrollPane,BorderLayout.CENTER);

        //Naujo katalogo sukurimas
        //File dir=new File("C:\\Users\\Studentas\\Desktop\\ManoNaujasKatalogas");
        //if(!dir.exists())
        //dir.mkdir();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){

            case "Atidaryti kataloga...":
                //Failu atidarymo dialogo langas
                JFileChooser fc = new JFileChooser();
                fc.setCurrentDirectory(new java.io.File(".")); // start at application current directory
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);//nustatom kad rinksimes tik katalogus
                int returnVal = fc.showOpenDialog(this);//rodomas failu atidarymo katalogas
                if(returnVal == JFileChooser.APPROVE_OPTION) {//reiskia pasirinkom faila ir paspaudem ok
                    File yourFolder = fc.getSelectedFile();//pasiimam kataloga, kuri pasirinkom

                    //--------------
                    Adresine adresTmp = new Adresine();
                    FailoNuskaitymas.nuskaityk(adresTmp);//
                    //--------------

                    //Trinam senus lenteles duomenis, jei tokiu yra
                    for(int i=lentelesModelis.getRowCount()-1;i>=0;i--)//einame per kiekviena eilute nuo galo ir ja triname
                    {
                        lentelesModelis.removeRow(i);//trinam nuo paskutines eilutes
                    }
                    for(int i=0;i<adresTmp.getAsmenuKontaktai().size();i++){
                        String vardas=adresTmp.getAsmenuKontaktai().get(i).getVardas();
                        String Pavarde=adresTmp.getAsmenuKontaktai().get(i).getPavarde();
                        String Miestas=adresTmp.getAsmenuKontaktai().get(i).getMiestas();
                        String Telefonas=adresTmp.getAsmenuKontaktai().get(i).getTelefonas();

                        Object eil[]=new Object[5];//cia eilutes masyvas
                        //uzpildom eilute
                        int nr=i+1;//kad ne nuo 0 numeruotu
                        eil[0]=nr;
                        eil[1]=vardas;
                        eil[2]=Pavarde;
                        eil[3]=Miestas;
                        eil[4]=Telefonas;
                        lentelesModelis.insertRow(i, eil);
                    }
                }
                break;

            case "Baigti darba":
                System.exit(0);
            default:
                break;
        }
    }
}