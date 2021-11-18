package com.adresuKnigute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaieskaNeModalinisLangas extends JDialog {

    interface SearchResultsOutput2{
        void outputSearchResults2(String vardas, String pavarde, String miestas);
        void restoreContacts2();
    }
    SearchResultsOutput2 pagrindinisLang;

    private JTextField vardas = new JTextField();
    private JTextField pavarde = new JTextField();

    public String getVardas(){
        return vardas.getText();
    }
    public String getpavarde(){
        return pavarde.getText();
    }

    public void setVardas(){ vardas.setText(""); }
    public void setpavarde(){ pavarde.setText(""); }

    PaieskaNeModalinisLangas(JFrame parent, boolean doesItModal) {
        super(parent, "Paieskos ne modalinis langas", doesItModal);

        Container cnt = getContentPane();
        JPanel elements = new JPanel();
        elements.setLayout(new GridLayout(3,2,20,20));
        elements.add(new JLabel("Iveskite varda"));
        elements.add(vardas);
        elements.add(new JLabel("Iveskite pavarde"));
        elements.add(pavarde);

        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        ok.addActionListener(new okPress());
        cancel.addActionListener(new cancelPress());
        elements.add(ok);
        elements.add(cancel);

        cnt.add(elements,BorderLayout.CENTER);
        cnt.add(new JPanel(), BorderLayout.NORTH);
        cnt.add(new JPanel(), BorderLayout.SOUTH);
        cnt.add(new JPanel(), BorderLayout.WEST);
        cnt.add(new JPanel(), BorderLayout.EAST);

        pagrindinisLang =(SearchResultsOutput2)parent;
    }

    class okPress implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //doesItPressed = true;
            String miestas ="";
            pagrindinisLang.outputSearchResults2(getVardas(), getpavarde(), miestas);
            //dispose();
        }
    }

    class cancelPress implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            pagrindinisLang.restoreContacts2();
            dispose();
        }
    }

}
