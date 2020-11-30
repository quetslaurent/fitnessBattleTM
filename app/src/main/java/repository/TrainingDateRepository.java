package repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import api.ApiClient;
import api.ITrainingDateService;
import model.inputDataModel.TrainingDateInput;
import model.outputDataModel.TrainingDateOutput;
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
    public LiveData<List<TrainingDateOutput>> query(){ //List d'oversable
        final MutableLiveData<List<TrainingDateOutput>> mutableLiveData = new MutableLiveData<>();

        getITrainingDateService().getTrainingDate().enqueue(new Callback<List<TrainingDateOutput>>() {
            @Override
            public void onResponse(Call<List<TrainingDateOutput>> call, Response<List<TrainingDateOutput>> response) {
                mutableLiveData.postValue(response.body()); //on envoit des données sur le flux d'information
                //verifier si tache synchrone
            }

            @Override
            public void onFailure(Call<List<TrainingDateOutput>> call, Throwable t) {

            }
        });

        return  mutableLiveData;
    }
    public LiveData<TrainingDateInput> create(TrainingDateInput trainingDateInput){
        final MutableLiveData<TrainingDateInput> mutableLiveData = new MutableLiveData<>();
        getITrainingDateService().postTrainingDate(trainingDateInput).enqueue(new Callback<TrainingDateInput>() {
            @Override
            public void onResponse(Call<TrainingDateInput> call, Response<TrainingDateInput> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<TrainingDateInput> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
