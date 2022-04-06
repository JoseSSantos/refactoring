package com.kreitek.refactor.mal.validators;

import com.kreitek.refactor.mal.Bean.Documento;
import com.kreitek.refactor.mal.TipoUltCaracter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorCIF extends Validator{

    TipoUltCaracter tipUltCar;
    Integer total;
    Integer numControl;

    @Override
    public boolean validate(Documento document){

        String CIF = document.numDNI;
        final String cifUP = CIF.toUpperCase();
        final char primerCar = cifUP.charAt(0);
        final char ultimoCar = cifUP.charAt(cifUP.length() - 1);
        final String digitos = cifUP.substring(1, cifUP.length() - 1);

            isPatterOk(cifUP);

            if(isFinalLetter(primerCar,ultimoCar,tipUltCar)){
                return false;
            }else if(isFinalNumber(primerCar,ultimoCar,tipUltCar)){
                return false;
            }
            numerocontrol(digitos);

            if(finalCheck(ultimoCar)){
                return true;
            }else{return false;}


                }


    private boolean isPatterOk(String cifUP){

        if ("ABCDEFGHJKLMNPQRSUVW".indexOf(cifUP.charAt(0)) == -1) {
            return false;
        }

        final Pattern mask = Pattern
                .compile("[ABCDEFGHJKLMNPQRSUVW][0-9]{7}[A-Z[0-9]]{1}");
        final Matcher matcher = mask.matcher(cifUP);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    private boolean isFinalLetter(char primerCar,char ultimoCar, TipoUltCaracter tipUltCar){
        if (primerCar == 'P' || primerCar == 'Q' || primerCar == 'S' || primerCar == 'K' || primerCar == 'W') {
            tipUltCar = TipoUltCaracter.LETRA;
            if (!(ultimoCar >= 'A' && ultimoCar <= 'Z')) {
                return true;
            }
    }
        return false;
    }
    private boolean isFinalNumber(char primerCar,char ultimoCar, TipoUltCaracter tipUltCar){
            if (primerCar == 'A' || primerCar == 'B' || primerCar == 'E'
                    || primerCar == 'H') {
                tipUltCar = TipoUltCaracter.NUMERO;
                if (!(ultimoCar >= '0' && ultimoCar <= '9')) {
                    return true; // no es un número --> casco!
                }
            } else {
                tipUltCar = TipoUltCaracter.AMBOS;
            }
        return false;
    }
    private int sumas(String digitos){

        Integer sumaPares = 0;
        for (int i = 1; i <= digitos.length() - 1; i = i + 2) {
            sumaPares += Integer.parseInt(digitos.substring(i, i + 1));
        }

        Integer sumaImpares = 0;
        for (int i = 0; i <= digitos.length() - 1; i = i + 2) {
            Integer cal = Integer.parseInt(digitos.substring(i, i + 1)) * 2;
            if (cal.toString().length() > 1) {
                cal = Integer.parseInt(cal.toString().substring(0, 1))
                        + Integer.parseInt(cal.toString().substring(1, 2));
            }
            sumaImpares += cal;
        }

        this.total = sumaPares + sumaImpares;
        return this.total;
    }
    private void numerocontrol(String digitos){
        this.numControl = 10 - (sumas(digitos) % 10);

    }

    private boolean finalCheck(char ultimoCar) {

        int pos = numControl == 10 ? 0 : numControl;
        final char carControl = "JABCDEFGHI".charAt(pos);

        Integer ultCar = null;

        isNumber(ultCar,ultimoCar,pos);
        isLetter(carControl,ultimoCar);


            if(findOcurrences(ultimoCar,carControl, pos)){
                return true;
            }

        return false;
    }

    private boolean isNumber(Integer ultCar,char ultimoCar, int pos){
        if (tipUltCar == TipoUltCaracter.NUMERO) {

            ultCar = Integer.parseInt(Character
                    .toString(ultimoCar));
            if (pos != ultCar.intValue()) {
            }
        }

        return false;
    }
    private boolean isLetter(char carControl, char ultimoCar){
        if (tipUltCar == TipoUltCaracter.LETRA) {
            if (carControl != ultimoCar) {
                return false;
            }

        }
        return true;
    }
    private boolean findOcurrences(char ultimoCar,char carControl, int pos){
        Integer ultCar = -1;

        ultCar = "JABCDEFGHI".indexOf(ultimoCar);

        if (ultCar < 0){
            ultCar = Integer.parseInt(Character.toString(ultimoCar));
            if (pos != ultCar.intValue()) {
                return false;
            }
        }
        if ((pos != ultCar.intValue()) && (carControl != ultimoCar)) {
            return false;
        }
        return true;
    }

}