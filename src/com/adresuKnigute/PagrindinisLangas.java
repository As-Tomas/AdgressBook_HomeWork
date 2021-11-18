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

class PagrindinisLangas extends JFrame implements ActionListener, PaieskaDialog.SearchResultsOutput, NaujoKontDialogas.KontaktoSukurimas, PaieskaNeModalinisLangas.SearchResultsOutput2{

    PaieskaDialog no_modalWindow = new PaieskaDialog(this,false, true);
    PaieskaNeModalinisLangas no_modalSerchWindow = new PaieskaNeModalinisLangas(this,false);
    NaujoKontDialogas no_modal_ivedimas = new NaujoKontDialogas(this, false);

//    PopUpGenerateNumContacts popUPHovMuchGenerate = new PopUpGenerateNumContacts(this,true);

    JTable lentele;//lentele, kur perziurimi failo duomenys
    //Tai lenteles modelio (kiek ir kokie stulpeliai, be to, galima nurodyti ir lenteles turini
    DefaultTableModel lentelesModelis;
    JButton genContacts;
    JLabel statusText;
    Adresine knygute = new Adresine();
    JButton paieska;
    JButton irasytiKontakta;
    JRadioButton rusiavimasPV = new JRadioButton("Varda", false);
    JRadioButton rusiavimasPP = new JRadioButton("Pavarde", false);
    JRadioButton rusiavimasPM = new JRadioButton("Miesta", false);
    int genContactsNumer = 0;


    PagrindinisLangas(){
        Container cont=getContentPane();
        cont.setLayout(new BorderLayout());

        genContacts = new JButton("Generate Contacts");
        genContacts.addActionListener(new PopUpGenNumContacts());
        //genContacts.addActionListener(this);

        paieska = new JButton("Paieska");
        paieska.addActionListener(this);

        irasytiKontakta = new JButton("Sukurti kontakta");
        irasytiKontakta.addActionListener(this);

        //Pasirinkimo mygtukai (RadioButton)
        //Sukuriam mygtuku grupe bei panelis, kur jie bus talpinami
        ButtonGroup rusiavimoGrupe = new ButtonGroup();
        JPanel radioSort = new JPanel();
        //Uzduodamas paneliui remelis su pavadinimu
        radioSort.setBorder(new TitledBorder("Rusiavimas pagal:"));
        //radiobutton mygtukus sujungiam i grupe
        rusiavimoGrupe.add(rusiavimasPV);
        rusiavimoGrupe.add(rusiavimasPP);
        rusiavimoGrupe.add(rusiavimasPM);
        //radiobutton mygtukus idedam i paneli
        radioSort.add(rusiavimasPV);
        radioSort.add(rusiavimasPP);
        radioSort.add(rusiavimasPM);
        rusiavimasPV.addActionListener(this);
        rusiavimasPP.addActionListener(this);
        rusiavimasPM.addActionListener(this);
        cont.add(radioSort,BorderLayout.NORTH);



        JPanel kaireVirsus = new JPanel();
        kaireVirsus.setLayout(new GridLayout(4,1,10,10));
        kaireVirsus.add(genContacts);
        kaireVirsus.add(irasytiKontakta);
        kaireVirsus.add(paieska);


        JPanel kaire = new JPanel();
        kaire.setLayout(new BorderLayout());
        kaire.add(kaireVirsus,BorderLayout.NORTH);
        kaire.setBorder(new EtchedBorder());
        cont.add(kaire, BorderLayout.WEST);

        JPanel statusBar = new JPanel();
        statusBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
        statusText = new JLabel("Ready...");
        statusBar.add(statusText);
        statusBar.setLayout(new BoxLayout(statusBar,BoxLayout.X_AXIS));
        cont.add(statusBar,BorderLayout.SOUTH);





//------Meniu from top
        JMenuBar pagrindinisMeniu=new JMenuBar();//meniu juosta
        JMenu failas=new JMenu("Failas");//Meniu komandu grupe
        JMenu paieska=new JMenu("Paieska");
        failas.setMnemonic(KeyEvent.VK_F);//Spartieji klavisai, veiks su Alt+F
        paieska.setMnemonic(KeyEvent.VK_P);

        JMenuItem katalog=new JMenuItem("Importuoti is failo");//Atskira komanda
        katalog.addActionListener(this);//pacio Pagrindinio lango actionPerformed() apdoros
        katalog.setMnemonic(KeyEvent.VK_O);

        JMenuItem pagVardPav=new JMenuItem("Pagal varda ir pavarde");
        JMenuItem pagVardPavMie=new JMenuItem("Pagal varda, pavarde ir miesta - Modalinis");
        //pagVardPav.addActionListener(this); Skirtas realiai Case skiriui kad iskviestu @NR1
        //pagVardPavMie.addActionListener(this); Net nera case sukurta

        JMenuItem close=new JMenuItem("Baigti darba");
        close.addActionListener(this);

        //I failas meniu komandu grupe idedam "Atidaryti kataloga...", separatoriu ir "Baigti darba"
        failas.add(katalog);
        failas.addSeparator();
        failas.add(close);

        paieska.add(pagVardPav);
        paieska.add(pagVardPavMie);
        pagVardPavMie.addActionListener(new pasirenkamasModalinioAtidarymas(true));
        pagVardPav.addActionListener(new No_modalFromMeniuSerachButonOpener());


        pagrindinisMeniu.add(failas);//i meniu juosta idedam faila
        pagrindinisMeniu.add(paieska);
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
        //ikeliam i pagrindini langa
        cont.add(scrollPane,BorderLayout.CENTER);

        //Naujo katalogo sukurimas
        //File dir=new File("C:\\Users\\Studentas\\Desktop\\ManoNaujasKatalogas");
        //if(!dir.exists())
        //dir.mkdir();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){

            case "Importuoti is failo":
                int existingContacts = 0;
                //Failu atidarymo dialogo langas
                JFileChooser fc = new JFileChooser();
                fc.setCurrentDirectory(new java.io.File(".")); // start at application current directory
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);//nustatom kad rinksimes tik katalogus
                int returnVal = fc.showOpenDialog(this);//rodomas failu atidarymo katalogas
                if(returnVal == JFileChooser.APPROVE_OPTION) {//reiskia pasirinkom faila ir paspaudem ok
                    File yourFolder = fc.getSelectedFile();//pasiimam kataloga, kuri pasirinkom

                    //--------------
                    existingContacts = knygute.getKontaktuSkaicius();

                    FailoNuskaitymas.nuskaityk(knygute);//
                    //--------------

                    UiMetods metodas4 = new UiMetods();
                    metodas4.adresatuSarasas(lentelesModelis,knygute);

                }
                statusText.setText((knygute.getKontaktuSkaicius() - existingContacts) + " new contacts imported. Tottal: " + knygute.getKontaktuSkaicius());
                break;
//            case "Generate Contacts":
//                existingContacts = knygute.getKontaktuSkaicius();
//
//                for( int i=0; i<10; i++){
//                    Asmuo asmuo = new Asmuo();
//                    knygute.irasytiKontakta(asmuo);
//                }
//
//                UiMetods metodas3 = new UiMetods();
//                metodas3.adresatuSarasas(lentelesModelis,knygute);
//
//                statusText.setText((knygute.getKontaktuSkaicius() - existingContacts) + " new contacts imported. Tottal: " + knygute.getKontaktuSkaicius());
//
//                break;
            case "Generate Contacts":
//                popUPHovMuchGenerate.setSize(250,180);
//                popUPHovMuchGenerate.setVisible(true);

                break;

            case "Varda" :
                knygute.getAsmenuKontaktai().sort(new RusiavimasPVarda().reversed());
                statusText.setText("Surusiuota pagal Varda ");

                UiMetods metodas2 = new UiMetods();
                metodas2.adresatuSarasas(lentelesModelis,knygute);

                break;

            case "Pavarde" :
                knygute.getAsmenuKontaktai().sort(new Rusiavimas().reversed());
                statusText.setText("Surusiuota pagal Pavarde ");

                UiMetods metodas1 = new UiMetods();
                metodas1.adresatuSarasas(lentelesModelis,knygute);

                break;

            case "Miesta" :
                knygute.getAsmenuKontaktai().sort(new RusiavimasPMiesta().reversed());
                statusText.setText("Surusiuota pagal Miesta ");

                UiMetods metodas0 = new UiMetods();
                metodas0.adresatuSarasas(lentelesModelis,knygute);

                break;

            case "Paieska":
                // sukurtas modalinis langas
                no_modalWindow.setVardas();
                no_modalWindow.setpavarde();
                no_modalWindow.setMiestas();
                no_modalWindow.setVisible(true);

                statusText.setText("Vikdoma paieska... ");
                break;

            case "Sukurti kontakta":
                // sukurtas modalinis langas
                no_modal_ivedimas.setVardas();
                no_modal_ivedimas.setpavarde();
                no_modal_ivedimas.setMiestas();
                no_modal_ivedimas.setTelefonas();
                no_modal_ivedimas.setVisible(true);

                break;
//            //@NR1
//            case "Pagal varda ir pavarde":
//                no_modalSerchWindow.setVisible(true);
//                break;

            case "Baigti darba":
                System.exit(0);
            default:
                break;
        }
    }

    @Override
    public void outputSearchResults(String v, String p, String m) {
        System.out.println(v);
        metodai met4 = new metodai();
        Adresine contactsFount = new Adresine();
        contactsFount = met4.searchByFirstNameAndLastNameAndCityReturn(knygute, v, p, m);

        UiMetods metodas = new UiMetods();
        metodas.adresatuSarasas(lentelesModelis,contactsFount);

        int total = contactsFount.getKontaktuSkaicius();
        if(total == 0){
                        JOptionPane.showMessageDialog(null, " Person not found in Adresu knygute");
                    }
        statusText.setText( "Rasta: " + total );
    }

    public void restoreContacts(){
        UiMetods metodas = new UiMetods();
        metodas.adresatuSarasas(lentelesModelis,knygute);
    }

    @Override
    public void outputSearchResults2(String vardas, String pavarde, String miestas) {
        outputSearchResults(vardas, pavarde, miestas);
        System.out.println(vardas);
    }

    @Override
    public void restoreContacts2() {
        UiMetods metodas = new UiMetods();
        metodas.adresatuSarasas(lentelesModelis,knygute);
    }

    @Override
    public void irasytiKontakta(String v, String p, String m, String t) {
        Asmuo asmuo = new Asmuo(v, p, m, t);
        knygute.irasytiKontakta(asmuo);
        statusText.setText( "Kontakstas issaugotas " );
        UiMetods metodas = new UiMetods();
        metodas.adresatuSarasas(lentelesModelis,knygute);
    }


    class PopUpGenNumContacts implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            PopUpGenerateNumContacts askNum = new PopUpGenerateNumContacts(null, true);
            askNum.setSize(280,120);
            askNum.setLocationRelativeTo(null);
            askNum.setVisible(true);

            if (askNum.doesItPressed){
                genContactsNumer = askNum.getNumContacts();

                int existingContacts = knygute.getKontaktuSkaicius();

                for( int i=0; i<genContactsNumer; i++){
                    Asmuo asmuo = new Asmuo();
                    knygute.irasytiKontakta(asmuo);
                }

                UiMetods metodas3 = new UiMetods();
                metodas3.adresatuSarasas(lentelesModelis,knygute);

                statusText.setText((knygute.getKontaktuSkaicius() - existingContacts) + " new contacts imported. Tottal: " + knygute.getKontaktuSkaicius());


            }
        }
    }

    class pasirenkamasModalinioAtidarymas implements ActionListener{

        private boolean cityFeald;

        pasirenkamasModalinioAtidarymas(boolean cityFeald){
            this.cityFeald = cityFeald;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            PaieskaModalinisLangas paieskosDialogoLangas;
            PaieskaNeModalinisLangas paieskosDialogoLangasN;
            if (cityFeald) {
                paieskosDialogoLangas = new PaieskaModalinisLangas(null, true, true);
                paieskosDialogoLangas.setSize(250,240);


                paieskosDialogoLangas.setLocationRelativeTo(null);
                paieskosDialogoLangas.setVisible(true);

                if (paieskosDialogoLangas.arPaspaustaOK == true){
                    String vardas = paieskosDialogoLangas.getVardas();
                    String pavarde = paieskosDialogoLangas.getpavarde();
                    String miestas = paieskosDialogoLangas.getmiestas();

                    //----------
                    outputSearchResults(vardas,pavarde,miestas);
                    //todo adjust to take effect and not modal window
                    //----------
            } else {
                paieskosDialogoLangasN = new PaieskaNeModalinisLangas(null, false);
                paieskosDialogoLangasN.setSize(250,180);
                paieskosDialogoLangasN.setVardas();
                paieskosDialogoLangasN.setpavarde();
            }
            }

        }
    }

    class No_modalFromMeniuSerachButonOpener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            no_modalSerchWindow.setSize(250, 180);
            no_modalSerchWindow.setLocationRelativeTo(null);
            no_modalSerchWindow.setVisible(true);
            no_modalSerchWindow.setVardas();
            no_modalSerchWindow.setpavarde();

//            if (no_modalSerchWindow.doesItPressed){
//                String v = no_modalSerchWindow.vardas.toString();
//                String p = no_modalSerchWindow.pavarde.toString();
//                String m ="";
//                outputSearchResults(v,p,m);
//            }
        }
    }
}