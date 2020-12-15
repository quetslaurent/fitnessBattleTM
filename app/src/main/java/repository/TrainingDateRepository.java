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
     *
     * @param trainingDateInput , on envoie le trainingDate que l'on a creer au serveur
     * @return
     */

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

    /**
     * permet de creer  la date d'aujourd'hui
     * @return
     */
    public LiveData<TrainingDateInput> createToday(){
        final MutableLiveData<TrainingDateInput> mutableLiveData = new MutableLiveData<>();
        getITrainingDateService().postToday().enqueue(new Callback<TrainingDateInput>() {
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
