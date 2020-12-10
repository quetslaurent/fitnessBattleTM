package viewModel;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import model.inputDataModel.UserFitnessInputLogin;
import model.outputDataModel.UserFitnessOutputLogin;
import repository.AuthRepository;
import repository.UserRepository;

public class LoginViewModel extends ViewModel {

    private AuthRepository authRepository = new AuthRepository();
    private LiveData<UserFitnessOutputLogin> userFitnessOutputLoginLiveData;

    public LiveData<UserFitnessOutputLogin>login(UserFitnessInputLogin userFitnessInputLogin){
        return userFitnessOutputLoginLiveData = authRepository.loginUser(userFitnessInputLogin);
    }
}
