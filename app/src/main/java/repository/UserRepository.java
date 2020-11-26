package repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.projet.RegisterActivity;

import java.util.List;

import api.ApiClient;
import api.IUserService;
import model.UserFitness;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private Application application;

    public UserRepository(Application application) {
        this.application=application;
    }

    public UserRepository() {

    }


    private IUserService getIUserService(){
        return ApiClient.getClient().create(IUserService.class);
    }

    private RegisterActivity registerActivity;
    /**
     * flux d'info que l'on peut observer
     * on peut pas le modifier ! mais le mutable oui
     * @return
     */
    public LiveData<List<UserFitness>> query(){ //List d'oversable
        final MutableLiveData<List<UserFitness>> mutableLiveData = new MutableLiveData<>();

        getIUserService().getUser().enqueue(new Callback<List<UserFitness>>() {
            @Override
            public void onResponse(Call<List<UserFitness>> call, Response<List<UserFitness>> response) {
                mutableLiveData.postValue(response.body()); //on envoit des données sur le flux d'information
                //verifier si tache synchrone
            }

            @Override
            public void onFailure(Call<List<UserFitness>> call, Throwable t) {

            }
        });

        return  mutableLiveData;
    }


    public LiveData<UserFitness> create(UserFitness userFitness){
        final MutableLiveData<UserFitness> mutableLiveData = new MutableLiveData<>();
        getIUserService().postUser(userFitness).enqueue(new Callback<UserFitness>() {
            @Override
            public void onResponse(Call<UserFitness> call, Response<UserFitness> response) {
                if(response.isSuccessful()){
                    mutableLiveData.postValue(response.body());
                }
               /* else{

                }*/
            }

            @Override
            public void onFailure(Call<UserFitness> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
