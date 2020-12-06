package viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import model.outputDataModel.UserFitnessOutput;
import model.outputDataModel.UserFitnessOutputToken;
import repository.TokenRepository;
import repository.UserRepository;

public class ProfileViewModel extends ViewModel {

    private TokenRepository tokenRepository = new TokenRepository();
    private LiveData<UserFitnessOutputToken> user;
    public LiveData<UserFitnessOutputToken> getUserToken(){
        return user = tokenRepository.getUserFromToken();
   }

}
