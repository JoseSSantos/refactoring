package com.kreitek.refactor.mal.Bean;

import com.kreitek.refactor.mal.Utils.TIPODOCUMENTO;

import java.util.Date;

public class NIE extends Documento{

    public NIE(TIPODOCUMENTO enumTipo, String numDNI, Date fchValidez) {
        super(enumTipo.NIE, numDNI, fchValidez);
    }

}
