package viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import model.outputDataModel.UserFitnessOutput;
import model.outputDataModel.UserFitnessOutputToken;
import repository.TokenRepository;
import repository.UserRepository;
/**
 * VIEW MODEL , elle va instancier l'objet ici
 * et appeler ses méthodes
 */
public class ProfileViewModel extends ViewModel {

    private TokenRepository tokenRepository = new TokenRepository();
    private UserRepository userRepository = new UserRepository();
    private LiveData<UserFitnessOutputToken> user;
    public LiveData<UserFitnessOutputToken> getUserToken(){
        return user = tokenRepository.getUserFromToken();
   }
   public LiveData<String> deleteUser(){
        return  userRepository.deleteUser();
   }

}
