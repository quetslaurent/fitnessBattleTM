package viewModel;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import model.UserFitness;
import repository.UserRepository;

public class ProfileViewModel extends ViewModel {

    private UserRepository userRepository = new UserRepository();
    private LiveData<UserFitness> user;
    public LiveData<UserFitness> getUserlive(){
    return user=userRepository.getById(1);
   }

}
