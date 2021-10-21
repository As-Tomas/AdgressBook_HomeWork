package com.adresuKnigute;

import java.util.Comparator;

public class Rusiavimas implements Comparator<Asmuo>
{
    @Override
    public int compare(Asmuo o1, Asmuo o2) {
        return o2.getPavarde().compareToIgnoreCase(o1.getPavarde());
    }
}

