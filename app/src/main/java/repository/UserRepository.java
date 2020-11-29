package repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import api.ApiClient;
import api.IUserService;
import modele.outputDataModel.UserFitnessOutput;
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



    /**
     * flux d'info que l'on peut observer
     * on peut pas le modifier ! mais le mutable oui
     * @return
     */
    public LiveData<List<UserFitnessOutput>> query(){ //List d'oversable //
        final MutableLiveData<List<UserFitnessOutput>> mutableLiveData = new MutableLiveData<>();

        getIUserService().getUsers().enqueue(new Callback<List<UserFitnessOutput>>() {
            @Override
            public void onResponse(Call<List<UserFitnessOutput>> call, Response<List<UserFitnessOutput>> response) {
                mutableLiveData.postValue(response.body()); //on envoit des données sur le flux d'information
                //verifier si tache synchrone
            }

            @Override
            public void onFailure(Call<List<UserFitnessOutput>> call, Throwable t) {

            }
        });

        return  mutableLiveData;
    }


    public LiveData<UserFitnessOutput> create(UserFitnessOutput userFitness){
        final MutableLiveData<UserFitnessOutput> mutableLiveData = new MutableLiveData<>();
        getIUserService().postUser(userFitness).enqueue(new Callback<UserFitnessOutput>() {
            @Override
            public void onResponse(Call<UserFitnessOutput> call, Response<UserFitnessOutput> response) {
                if(response.isSuccessful()){
                    mutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserFitnessOutput> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
    public LiveData<UserFitnessOutput> getById(int id){
        final MutableLiveData<UserFitnessOutput> mutableLiveData = new MutableLiveData<>();
        getIUserService().getUser(id).enqueue(new Callback<UserFitnessOutput>() {
            @Override
            public void onResponse(Call<UserFitnessOutput> call, Response<UserFitnessOutput> response) {

                UserFitnessOutput userFitnessOutput = response.body();
                mutableLiveData.postValue(userFitnessOutput);
            }

            @Override
            public void onFailure(Call<UserFitnessOutput> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
