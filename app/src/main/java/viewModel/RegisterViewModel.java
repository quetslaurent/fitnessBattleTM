package viewModel;

import androidx.lifecycle.LiveData;

import androidx.lifecycle.ViewModel;

import java.util.List;


import model.inputDataModel.UserFitnessInput;
import model.outputDataModel.UserFitnessOutput;
import repository.UserRepository;
/**
 * VIEW MODEL , elle va instancier l'objet ici
 * et appeler ses méthodes
 */
public class RegisterViewModel extends ViewModel {

    //cree une instance de UserRepository
    private UserRepository userRepository = new UserRepository();


    //appelle la methode createUser de userRepository
    public void createUser(UserFitnessInput userFitness){
        userRepository.create(userFitness);

    }






}
