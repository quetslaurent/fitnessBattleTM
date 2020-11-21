package repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import api.ApiClient;
import api.ITrainingDateService;
import model.TrainingDate;
import model.UserFitness;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainingDateRepository {

    private ITrainingDateService getITrainingDateService(){
        return ApiClient.getClient().create(ITrainingDateService.class);
    }

    /**
     * flux d'info que l'on peut observer
     * on peut pas le modifier ! mais le mutable oui
     * @return
     */
    public LiveData<List<TrainingDate>> query(){ //List d'oversable
        final MutableLiveData<List<TrainingDate>> mutableLiveData = new MutableLiveData<>();

        getITrainingDateService().getTrainingDate().enqueue(new Callback<List<TrainingDate>>() {
            @Override
            public void onResponse(Call<List<TrainingDate>> call, Response<List<TrainingDate>> response) {
                mutableLiveData.postValue(response.body()); //on envoit des données sur le flux d'information
                //verifier si tache synchrone
            }

            @Override
            public void onFailure(Call<List<TrainingDate>> call, Throwable t) {

            }
        });

        return  mutableLiveData;
    }
    public LiveData<TrainingDate> create(TrainingDate trainingDate){
        final MutableLiveData<TrainingDate> mutableLiveData = new MutableLiveData<>();
        getITrainingDateService().postTrainingDate(trainingDate).enqueue(new Callback<TrainingDate>() {
            @Override
            public void onResponse(Call<TrainingDate> call, Response<TrainingDate> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<TrainingDate> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
