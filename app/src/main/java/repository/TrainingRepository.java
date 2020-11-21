package repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import api.ApiClient;
import api.ITrainingService;
import api.IUserService;
import model.Training;
import model.UserFitness;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainingRepository {


    private ITrainingService getITrainingService(){
        return ApiClient.getClient().create(ITrainingService.class);
    }

    /**
     * flux d'info que l'on peut observer
     * on peut pas le modifier ! mais le mutable oui
     * @return
     */
    public LiveData<List<Training>> query(){ //List d'oversable
        final MutableLiveData<List<Training>> mutableLiveData = new MutableLiveData<>();

        getITrainingService().getTraining().enqueue(new Callback<List<Training>>() {
            @Override
            public void onResponse(Call<List<Training>> call, Response<List<Training>> response) {
                mutableLiveData.postValue(response.body()); //on envoit des données sur le flux d'information
                //verifier si tache synchrone
            }

            @Override
            public void onFailure(Call<List<Training>> call, Throwable t) {

            }
        });

        return  mutableLiveData;
    }

    public LiveData<Training> create(Training training){
        final MutableLiveData<Training> mutableLiveData = new MutableLiveData<>();
        getITrainingService().postTraining(training).enqueue(new Callback<Training>() {
            @Override
            public void onResponse(Call<Training> call, Response<Training> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Training> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
