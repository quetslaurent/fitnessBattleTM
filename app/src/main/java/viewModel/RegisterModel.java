package viewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.example.projet.Register;
import java.util.List;
import model.UserFitness;
import repository.UserRepository;

public class RegisterModel extends ViewModel {

    private LiveData<List<UserFitness>>usersFitness;
    private UserRepository userRepository;
    private Context context;


    public RegisterModel(@NonNull Application application){
        super();
        userRepository = new UserRepository(application);
    }

    public LiveData<List<UserFitness>> getUsersFitness(){
        return userRepository.query();
    }

    public void createUser(UserFitness userFitness){
        userRepository.create(userFitness);

    }




}
