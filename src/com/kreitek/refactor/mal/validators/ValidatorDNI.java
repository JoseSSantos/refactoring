package com.kreitek.refactor.mal.validators;
import com.kreitek.refactor.mal.Bean.DNI;
import com.kreitek.refactor.mal.Bean.Documento;

import static com.kreitek.refactor.mal.Utils.operaciones.isNumeric;

public class ValidatorDNI extends Validator{

    private String dniChars = "TRWAGMYFPDXBNJZSQVHLCKE";

    @Override
    public boolean validate(Documento document) {

        if(isLengthOk(document) && isNumericOk(document) && isModuloOk(document)){
            return true;
        }else{
            return false;
        }
    }


    private String getNumbersDNI(Documento document){
        String intPartDNI = document.numDNI.trim().replaceAll(" ", "").substring(0, 8);
        return intPartDNI;
    }
    private char getLetterDNI(Documento document){
        char ltrDNI = document.numDNI.charAt(8);
        return ltrDNI;
    }
    private int getmoduloDNI(Documento document){

        int valNumDni = Integer.parseInt(getNumbersDNI(document)) % 23;
        return valNumDni;

    }
    private boolean isLengthOk(Documento document){
        if(document.numDNI.length() != 9){
            return false;
        }else{
            return true;
        }
    }
    private boolean isNumericOk(Documento document){

        if(isNumeric(getNumbersDNI(document)) == false)
        {
            return false;
        }else
        {return true;
        }
    }
    private boolean isModuloOk(Documento document){

        if(dniChars.charAt(getmoduloDNI(document)) != getLetterDNI(document)){
            return false;
        }else{
            return true;
        }
    }

}
