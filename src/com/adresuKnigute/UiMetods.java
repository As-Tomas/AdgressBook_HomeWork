package com.adresuKnigute;

import javax.swing.table.DefaultTableModel;

public class UiMetods {
    //UI adresines atvaizdavimo metodas
    public DefaultTableModel adresatuSarasas(DefaultTableModel lentelesModelis, Adresine knygute ){

        for(int i=lentelesModelis.getRowCount()-1;i>=0;i--)//einame per kiekviena eilute nuo galo ir ja triname
        {
            lentelesModelis.removeRow(i);//trinam nuo paskutines eilutes
        }
        for(int i=0;i<knygute.getAsmenuKontaktai().size();i++){
            String vardas=knygute.getAsmenuKontaktai().get(i).getVardas();
            String Pavarde=knygute.getAsmenuKontaktai().get(i).getPavarde();
            String Miestas=knygute.getAsmenuKontaktai().get(i).getMiestas();
            String Telefonas=knygute.getAsmenuKontaktai().get(i).getTelefonas();

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

        return lentelesModelis;
    }
}
