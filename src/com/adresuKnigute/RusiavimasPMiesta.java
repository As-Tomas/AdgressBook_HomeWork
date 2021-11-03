package com.adresuKnigute;

import java.util.Comparator;

public class RusiavimasPMiesta implements Comparator<Asmuo>
{
    @Override
    public int compare(Asmuo o1, Asmuo o2) {
        return o2.getMiestas().compareToIgnoreCase(o1.getMiestas());
    }
}
