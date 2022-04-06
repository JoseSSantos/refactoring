package com.kreitek.refactor.mal.Bean;

import com.kreitek.refactor.mal.Utils.TIPODOCUMENTO;

import java.util.Date;

public class DNI extends Documento{


    public DNI(TIPODOCUMENTO enumTipo, String numDNI, Date fchValidez) {
        super(enumTipo.DNI, numDNI, fchValidez);

    }
}
