package com.kreitek.refactor.mal;

import com.kreitek.refactor.mal.Bean.CIF;
import com.kreitek.refactor.mal.Bean.DNI;
import com.kreitek.refactor.mal.Bean.Documento;
import com.kreitek.refactor.mal.Bean.NIE;
import com.kreitek.refactor.mal.Utils.TIPODOCUMENTO;
import com.kreitek.refactor.mal.printer.*;
import com.kreitek.refactor.mal.validators.ValidatorCIF;
import com.kreitek.refactor.mal.validators.ValidatorDNI;
import com.kreitek.refactor.mal.validators.ValidatorNIE;

class  Main
{
    public static void main(String args[])
    {
        printer printer = new printer();
        printer.printBanner();
        ValidatorDNI dniValidator = new ValidatorDNI();
        ValidatorNIE NIEValidator = new ValidatorNIE();
        ValidatorCIF CIFValidator = new ValidatorCIF();

        Documento dniCorrecto = new DNI(TIPODOCUMENTO.DNI, "11111111H", null);
        Documento dniIncorrecto01 = new DNI(TIPODOCUMENTO.DNI, "24324356A", null);
        Documento nieCorrecto = new NIE(TIPODOCUMENTO.NIE,"X0932707B", null);
        Documento nieIncorrecto = new DNI(TIPODOCUMENTO.NIE, "Z2691139Z", null);
        Documento cifCorrecto = new CIF(TIPODOCUMENTO.CIF, "W9696294I", null);
        Documento cifIncorrecto = new CIF(TIPODOCUMENTO.CIF, "W9696294A", null);

        printer.printDocument(dniCorrecto, dniValidator.validate(dniCorrecto));
        printer.printDocument(dniIncorrecto01,dniValidator.validate(dniIncorrecto01));
        printer.printDocument(nieCorrecto,NIEValidator.validate(nieCorrecto));
        printer.printDocument(nieIncorrecto,NIEValidator.validate(nieIncorrecto));
        printer.printDocument(cifCorrecto,CIFValidator.validate(cifCorrecto));
        printer.printDocument(cifIncorrecto,CIFValidator.validate(cifIncorrecto));

    }

}