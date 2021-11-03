package com.adresuKnigute;

import java.util.Comparator;

public class RusiavimasPVarda implements Comparator<Asmuo>
{
    @Override
    public int compare(Asmuo o1, Asmuo o2) {
        return o2.getVardas().compareToIgnoreCase(o1.getVardas());
    }
}