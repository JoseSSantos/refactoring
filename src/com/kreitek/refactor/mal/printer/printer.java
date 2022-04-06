package com.kreitek.refactor.mal.printer;

import com.kreitek.refactor.mal.Bean.DNI;
import com.kreitek.refactor.mal.Bean.Documento;

public class printer {

    public void printBanner(){
        System.out.println("=====================");
        System.out.println("Vamos a refactorizar!");
        System.out.println("=====================");
    }

    public void printDocument(Documento documento, boolean correct){

        System.out.println( documento.getEnumTipo() + documento.numDNI + " es: " + correct);

    }

}
