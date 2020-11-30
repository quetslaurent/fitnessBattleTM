package viewModel;

import androidx.lifecycle.LiveData;

import androidx.lifecycle.ViewModel;

import java.util.List;


import model.inputDataModel.UserFitnessInput;
import model.outputDataModel.UserFitnessOutput;
import repository.UserRepository;

public class RegisterViewModel extends ViewModel {


    private UserRepository userRepository = new UserRepository();

    public LiveData<List<UserFitnessOutput>> getUsersFitness(){

        return userRepository.query();
    }

    public void createUser(UserFitnessInput userFitness){
        userRepository.create(userFitness);

    }





}
