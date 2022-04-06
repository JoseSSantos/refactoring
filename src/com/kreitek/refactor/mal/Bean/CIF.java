package com.kreitek.refactor.mal.Bean;

import com.kreitek.refactor.mal.TIPODNI;

import java.util.Date;

public class CIF extends Documento{


    public CIF(TIPODNI enumTipo, String numDNI, Date fchValidez) {
        super(enumTipo.CIF, numDNI, fchValidez);
    }
}
