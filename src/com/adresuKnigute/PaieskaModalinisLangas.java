package com.adresuKnigute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaieskaModalinisLangas extends JDialog {



    public boolean arPaspaustaOK = false;

    JTextField vardas=new JTextField();
    JTextField pavarde=new JTextField();
    JTextField miestas=new JTextField();

    public String getVardas(){
        return vardas.getText();
    }
    public String getpavarde(){
        return pavarde.getText();
    }
    public String getmiestas(){
        return miestas.getText();
    }

    PaieskaModalinisLangas(JFrame PagrindinisLangas, boolean arModalinis, boolean miestoFealdas) {
        super(PagrindinisLangas, "Paieskos dialogas", arModalinis);


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



    }

    class OKPaspaudimas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            arPaspaustaOK=true;
            dispose();
        }
    }

    class CancelPaspaudimas implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            arPaspaustaOK=false;
            dispose();
        }
    }
}

