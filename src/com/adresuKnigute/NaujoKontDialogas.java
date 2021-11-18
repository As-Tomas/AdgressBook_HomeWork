package com.adresuKnigute;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NaujoKontDialogas extends JDialog {

    interface KontaktoSukurimas{
        void irasytiKontakta(String v, String p, String m, String t);
    }

    KontaktoSukurimas pagrindinisLangas;

    JTextField vardas=new JTextField();
    JTextField pavarde=new JTextField();
    JTextField miestas=new JTextField();
    JTextField telefonas=new JTextField();

    public String getVardas(){
        return vardas.getText();
    }
    public String getpavarde(){
        return pavarde.getText();
    }
    public String getmiestas(){ return miestas.getText(); }
    public String getTelefonas(){ return telefonas.getText(); }

    public void setVardas(){ vardas.setText(""); }
    public void setpavarde(){ pavarde.setText(""); }
    public void setMiestas(){ vardas.setText(""); }
    public void setTelefonas(){ telefonas.setText(""); }

    NaujoKontDialogas(JFrame parent, boolean ismodal){
        super(parent,false);

        Container cnt=getContentPane();
        JPanel elementai = new JPanel();
        elementai.setLayout(new GridLayout(5,5,20,20));
        elementai.add(new JLabel("Vardas"));
        elementai.add(vardas);
        elementai.add(new JLabel("Pavarde"));
        elementai.add(pavarde);
        elementai.add(new JLabel("Miestas"));
        elementai.add(miestas);
        elementai.add(new JLabel("Telefono nr"));
        elementai.add(telefonas);

        JButton save = new JButton("Save");
        elementai.add(save);
        JButton cancel= new JButton("Cancel");
        elementai.add(cancel);

        save.addActionListener(new OKPaspaudimas());
        cancel.addActionListener(new CancelPaspaudimas());

        cnt.add(elementai, BorderLayout.CENTER);
        //Tuscios paneles del padding'u
        cnt.add(new JPanel(),BorderLayout.NORTH);
        cnt.add(new JPanel(),BorderLayout.SOUTH);
        cnt.add(new JPanel(),BorderLayout.EAST);
        cnt.add(new JPanel(),BorderLayout.WEST);

        setSize(250, 300);
        setLocationRelativeTo(null);

        pagrindinisLangas=(KontaktoSukurimas)parent;

    }

    class OKPaspaudimas implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            pagrindinisLangas.irasytiKontakta(getVardas(), getpavarde(), getmiestas(), getTelefonas());
            dispose();
        }
    }

    class CancelPaspaudimas implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
