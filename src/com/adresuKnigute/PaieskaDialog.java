package com.adresuKnigute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaieskaDialog extends JDialog {

    // cia sukurtas ne modalinis langas

    interface SearchResultsOutput{
        void outputSearchResults(String vardas, String pavarde, String miestas);
        void restoreContacts();
    }
    SearchResultsOutput pagrindinisLangas;

    private JTextField vardas=new JTextField();
    private JTextField pavarde=new JTextField();
    private JTextField miestas=new JTextField();

    public String getVardas(){
        return vardas.getText();
    }
    public String getpavarde(){
        return pavarde.getText();
    }
    public String getmiestas(){ return miestas.getText(); }

    public void setVardas(){ vardas.setText(""); }
    public void setpavarde(){ pavarde.setText(""); }
    public void setMiestas(){ vardas.setText(""); }


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

        setSize(250,250);
        setLocationRelativeTo(null);

        pagrindinisLangas=(SearchResultsOutput)PagrindinisLangas;

    }

    class OKPaspaudimas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pagrindinisLangas.outputSearchResults(getVardas(), getpavarde(), getmiestas());
            //dispose();
        }
    }

    class CancelPaspaudimas implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            pagrindinisLangas.restoreContacts();
            dispose();
        }
    }
}
