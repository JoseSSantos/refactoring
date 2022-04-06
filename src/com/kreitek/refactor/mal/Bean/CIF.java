package com.kreitek.refactor.mal.Bean;

import com.kreitek.refactor.mal.Utils.TIPODOCUMENTO;

import java.util.Date;

public class CIF extends Documento{


    public CIF(TIPODOCUMENTO enumTipo, String numDNI, Date fchValidez) {
        super(enumTipo.CIF, numDNI, fchValidez);
    }
}
