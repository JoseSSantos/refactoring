package com.kreitek.refactor.mal.Bean;

import com.kreitek.refactor.mal.Utils.TIPODOCUMENTO;

import java.util.Date;

public abstract class Documento {


    public TIPODOCUMENTO enumTipo;
    public String numDNI;
    public Date fchValidez;

    public Documento(TIPODOCUMENTO enumTipo, String numDNI, Date fchValidez) {
        this.enumTipo = enumTipo;
        this.numDNI = numDNI;
        this.fchValidez = fchValidez;
    }

    public TIPODOCUMENTO getEnumTipo() {
        return enumTipo;
    }

    public void setEnumTipo(TIPODOCUMENTO enumTipo) {
        this.enumTipo = enumTipo;
    }

    public String getNumDNI() {
        return numDNI;
    }

    public void setNumDNI(String numDNI) {
        this.numDNI = numDNI;
    }

    public Date getFchValidez() {
        return fchValidez;
    }

    public void setFchValidez(Date fchValidez) {
        this.fchValidez = fchValidez;
    }

}
