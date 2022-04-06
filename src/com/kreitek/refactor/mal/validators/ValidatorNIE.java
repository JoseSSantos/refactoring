package com.kreitek.refactor.mal.validators;
import com.kreitek.refactor.mal.Bean.Documento;




public class ValidatorNIE extends Validator{

    private boolean esValido = false;

    @Override
    public boolean validate(Documento document) {

        String nie = document.numDNI;

        if (isLenghtAndCharacterOk(nie)) {

            esValido(nie);
        }

        CharacterConcat(nie);
        moduloNIE(nie);

        return finalCheck();
    }

    private boolean isLenghtAndCharacterOk(String nie){

        if(nie.length() == 9 && Character.isLetter(nie.charAt(8))
                && nie.substring(0,1).toUpperCase().equals("X")
                || nie.substring(0,1).toUpperCase().equals("Y")
                || nie.substring(0,1).toUpperCase().equals("Z"))
        {
            return true;
        }else{return false;}
    }

    private void moduloNIE(String nie){
        char letra = ' ';
        int miNIE = 0;
        int resto = 0;
        char[] asignacionLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        if(this.esValido) {
            letra = Character.toUpperCase(nie.charAt(8));
            miNIE = Integer.parseInt(nie.substring(1,8));
            resto = miNIE % 23;
            this.esValido = (letra == asignacionLetra[resto]);
        }
    }

    private boolean finalCheck(){

        if (esValido) {
            return true;
        } else {
            return false;
        }
    }

    private void CharacterConcat(String nie){

        if(this.esValido && nie.substring(0,1).toUpperCase().equals("X")) {
            nie = "0" + nie.substring(1,9);
        } else if(this.esValido && nie.substring(0,1).toUpperCase().equals("Y")) {
            nie = "1" + nie.substring(1,9);
        } else if(this.esValido && nie.substring(0,1).toUpperCase().equals("Z")) {
            nie = "2" + nie.substring(1,9);
        }
    }
    private void esValido(String nie){
        int numLetra = 1;
        int caracterASCII = 0;
                do {
            caracterASCII = nie.codePointAt(numLetra);
            this.esValido = (caracterASCII > 47 && caracterASCII < 58);
            numLetra++;
        } while(numLetra < nie.length() - 1 && this.esValido);

    }

}
