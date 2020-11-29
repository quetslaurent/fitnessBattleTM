package viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import modele.outputDataModel.UserFitnessOutput;
import repository.UserRepository;

public class ProfileViewModel extends ViewModel {

    private UserRepository userRepository = new UserRepository();
    private LiveData<UserFitnessOutput> user;
    public LiveData<UserFitnessOutput> getUserlive(){
    return user=userRepository.getById(1);
   }

}
