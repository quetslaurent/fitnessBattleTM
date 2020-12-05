package repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import api.ApiClient;
import api.IUserService;
import model.inputDataModel.UserFitnessInput;
import model.outputDataModel.UserFitnessOutput;
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


    public LiveData<UserFitnessInput> create(UserFitnessInput userFitnessInput){
        final MutableLiveData<UserFitnessInput> mutableLiveData = new MutableLiveData<>();
        getIUserService().postUser(userFitnessInput).enqueue(new Callback<UserFitnessInput>() {
            @Override
            public void onResponse(Call<UserFitnessInput> call, Response<UserFitnessInput> response) {
                if(response.isSuccessful()){
                    mutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserFitnessInput> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
    public LiveData<UserFitnessOutput> getById(int id){
        final MutableLiveData<UserFitnessOutput> mutableLiveData = new MutableLiveData<>();
        getIUserService().getUserById(id).enqueue(new Callback<UserFitnessOutput>() {
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

    public LiveData<Double> getPointById(int id){
        final MutableLiveData<Double> mutableLiveData = new MutableLiveData<>();
        getIUserService().getUserPoint(id).enqueue(new Callback<Double>() {
            @Override
            public void onResponse(Call<Double> call, Response<Double> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Double> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }


    public LiveData<UserFitnessInput> update(int id,UserFitnessInput userFitnessInput){
        final MutableLiveData<UserFitnessInput> mutableLiveData = new MutableLiveData<>();
        getIUserService().update(id, userFitnessInput).enqueue(new Callback<UserFitnessInput>() {
            @Override
            public void onResponse(Call<UserFitnessInput> call, Response<UserFitnessInput> response) {
                if(response.isSuccessful()){
                    mutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserFitnessInput> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
