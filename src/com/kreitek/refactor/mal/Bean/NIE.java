package com.kreitek.refactor.mal.Bean;

import com.kreitek.refactor.mal.TIPODNI;

import java.util.Date;

public class NIE extends Documento{

    public NIE(TIPODNI enumTipo, String numDNI, Date fchValidez) {
        super(enumTipo.NIE, numDNI, fchValidez);
    }

}
