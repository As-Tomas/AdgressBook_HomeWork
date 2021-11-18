package com.adresuKnigute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class PopUpGenerateNumContacts extends JDialog {

    public boolean doesItPressed = false;
    JTextField numContacts = new JTextField();

    public int getNumContacts(){
        int number = 0;
        return number = Integer.parseInt( numContacts.getText());
    }

    PopUpGenerateNumContacts(JFrame pagrindoLangas, boolean arModalinis){
        super(pagrindoLangas, "Iveskite norima kontaktu skaiciu", arModalinis );

        Container cnt = getContentPane();
        JPanel elements = new JPanel();
        elements.setLayout(new GridLayout(2,2,20,20));
        elements.add(new JLabel("Iveskite skaiciu"));
        elements.add(numContacts);

        JButton ok = new JButton("Ok");
        ok.setMnemonic(KeyEvent.VK_ENTER);
        elements.add(ok);

        JButton cancel = new JButton("Cancel");
        elements.add(cancel);

        ok.addActionListener(new okPress());
        cancel.addActionListener(new cancelPress());

        cnt.add(elements, BorderLayout.CENTER);
        cnt.add(new JPanel(), BorderLayout.NORTH);
        cnt.add(new JPanel(), BorderLayout.SOUTH);
        cnt.add(new JPanel(), BorderLayout.NORTH);
        cnt.add(new JPanel(), BorderLayout.WEST);
    }

    class okPress implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            doesItPressed = true;
            dispose();
        }
    }

    class cancelPress implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }


}
