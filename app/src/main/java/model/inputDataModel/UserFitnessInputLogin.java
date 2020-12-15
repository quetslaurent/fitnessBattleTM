package model.inputDataModel;

import model.UserFitness;
/**
 * Ca sera la classe qui sera envoyé au serveur lorsqu'un user se connecte
 * pour la simplifier elle herite de la classe UserFitness
 *
 */
public class UserFitnessInputLogin extends UserFitness {


    public UserFitnessInputLogin(String name, String password) {
        super(name, password);
    }

}
