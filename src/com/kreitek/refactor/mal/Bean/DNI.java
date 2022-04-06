package com.kreitek.refactor.mal.Bean;

import com.kreitek.refactor.mal.TIPODNI;

import java.util.Date;

public class DNI extends Documento{


    public DNI(TIPODNI enumTipo, String numDNI, Date fchValidez) {
        super(enumTipo.DNI, numDNI, fchValidez);

    }
}
