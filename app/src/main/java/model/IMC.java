package model;

public class IMC {


    private  static double OBESITE_SEVERE = 40;
    private   static double FAMINE = 16.5;
    private   static double MAIGREUR = 18.5;
    private   static double NORMALE = 25;
    private   static double SURPOIDS = 30;
    private  static double OBESITE_MODERE = 35;


    public String valeurImc(float pValue,float tValue){

        String imcString=null;
        float imc = pValue / tValue;

        if(imc <FAMINE){
            imcString = ("Votre IMC est de " + imc +"\nVous êtes en famine.");
        }
        else if(imc >=FAMINE && imc <MAIGREUR){
            imcString =("Votre IMC est de " + imc +"\nVous êtes en maigreur.");
        }
        else if(imc >=MAIGREUR && imc <NORMALE){
            imcString =("Votre IMC est de "+ imc +"\nVous êtes en corpulence normale.");
        }
        else if(imc >=NORMALE && imc <SURPOIDS){
            imcString =("Votre IMC est de " + imc +"\nVous êtes en surpoids.");
        }
        else if(imc >=SURPOIDS && imc <OBESITE_MODERE){
            imcString =("Votre IMC est de " + imc +"\nVous êtes en obésité modérée.");
        }
        else if(imc >= OBESITE_MODERE && imc <OBESITE_SEVERE){
            imcString =("Votre IMC est de " + imc +"\nVous êtes en obésité sévère.");
        }
        else{
            imcString =("Votre IMC est de " + imc +"\nVous êtes en obésité massive.");
        }
        return imcString;
    }

}
