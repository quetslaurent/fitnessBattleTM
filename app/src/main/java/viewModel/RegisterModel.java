package viewModel;

import androidx.lifecycle.LiveData;

import androidx.lifecycle.ViewModel;

import java.util.List;


import model.UserFitness;
import repository.UserRepository;

public class RegisterModel extends ViewModel {


    private UserRepository userRepository = new UserRepository();

    public LiveData<List<UserFitness>> getUsersFitness(){
        return userRepository.query();
    }

    public void createUser(UserFitness userFitness){
        userRepository.create(userFitness);

    }





}
