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



    public UserRepository() {

    }


    private IUserService getIUserService(){
        return ApiClient.getClient().create(IUserService.class);
    }



    /**
     * flux d'info que l'on peut observer
     * on peut pas le modifier ! mais le mutable oui
     * permet de revoyer la liste d'utilisateur
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

    /**
     *
     * @param userFitnessInput , Creer un userFitness et l'envoie a la DB
     * @return
     */
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

    /**
     * permet de recuperer les points d'un utilisateur via son ID
     * @return
     */
    public LiveData<Double> getPointById(){
        final MutableLiveData<Double> mutableLiveData = new MutableLiveData<>();
        getIUserService().getUserPoint(ApiClient.getToken()).enqueue(new Callback<Double>() {
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

    /**
     * permet de supprimer son compte définitivement.
     * en passant via son token
     * @return
     */
    public LiveData<String> deleteUser(){
        final MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        getIUserService().deleteUser(ApiClient.getToken()).enqueue(new Callback<String>() { // passage du token
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    mutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
    
}
