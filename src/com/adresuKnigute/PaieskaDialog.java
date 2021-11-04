package com.adresuKnigute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaieskaDialog extends JDialog {

    //todo cia sukurti ne modalini langa

    interface SearchResultsOutput{
        //void outputSearchResults(Adresine adrRezults);
        void tempoutputSearchResults(String adrRezults);
    }
    SearchResultsOutput pagrindinisLangas;

    JTextField vardas=new JTextField();
    JTextField pavarde=new JTextField();
    JTextField miestas=new JTextField();

    /*public String getVardas(){
        return vardas.getText();
    }
    public String getpavarde(){
        return pavarde.getText();
    }
    public String getmiestas(){ return miestas.getText(); }*/

    PaieskaDialog(JFrame PagrindinisLangas, boolean arModalinis, boolean miestoFealdas) {
        super(PagrindinisLangas, "Paieskos dialogas", arModalinis); //tueru buti false


        Container cont = getContentPane();
        JPanel elementai = new JPanel();
        if (miestoFealdas) {
            elementai.setLayout(new GridLayout(4, 2, 20, 20));
            elementai.add(new JLabel("Vardas", SwingConstants.RIGHT));
            elementai.add(vardas);
            elementai.add(new JLabel("Pavarde", SwingConstants.RIGHT));
            elementai.add(pavarde);
            elementai.add(new JLabel("Miestas", SwingConstants.RIGHT));
            elementai.add(miestas);
        } else {
            elementai.setLayout(new GridLayout(3, 2, 20, 20));
            elementai.add(new JLabel("Vardas", SwingConstants.RIGHT));
            elementai.add(vardas);
            elementai.add(new JLabel("Pavarde", SwingConstants.RIGHT));
            elementai.add(pavarde);
        }
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        elementai.add(ok);
        elementai.add(cancel);

        ok.addActionListener(new OKPaspaudimas());
        cancel.addActionListener(new CancelPaspaudimas());

        cont.add(elementai,BorderLayout.CENTER);
        //Tuscios paneles del padding'u
        cont.add(new JPanel(),BorderLayout.NORTH);
        cont.add(new JPanel(),BorderLayout.SOUTH);
        cont.add(new JPanel(),BorderLayout.EAST);
        cont.add(new JPanel(),BorderLayout.WEST);

        setSize(250,150);

        pagrindinisLangas=(SearchResultsOutput)PagrindinisLangas;

    }

    class OKPaspaudimas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pagrindinisLangas.tempoutputSearchResults(vardas.getText());
            //dispose();
        }
    }

    class CancelPaspaudimas implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
