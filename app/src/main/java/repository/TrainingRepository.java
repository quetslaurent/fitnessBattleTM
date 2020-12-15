package repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import api.ApiClient;
import api.ITrainingService;
import model.inputDataModel.TrainingInput;
import model.outputDataModel.TrainingOutput;
import model.outputDataModel.UserFitnessOutput;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainingRepository {


    private ITrainingService getITrainingService(){
        return ApiClient.getClient().create(ITrainingService.class);
    }

    /**
     *
     * @param trainingInput
     * @return
     */
    public LiveData<TrainingInput> create(TrainingInput trainingInput){
        final MutableLiveData<TrainingInput> mutableLiveData = new MutableLiveData<>();
        getITrainingService().postTraining(trainingInput).enqueue(new Callback<TrainingInput>() {
            @Override
            public void onResponse(Call<TrainingInput> call, Response<TrainingInput> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<TrainingInput> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
    public LiveData<List<TrainingOutput>> getTrainingByuserId(){
        final MutableLiveData<List<TrainingOutput>> mutableLiveData = new MutableLiveData<>();
        getITrainingService().getTrainingbyUserId(ApiClient.getToken()).enqueue(new Callback<List<TrainingOutput>>() {
            @Override
            public void onResponse(Call<List<TrainingOutput>> call, Response<List<TrainingOutput>> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<TrainingOutput>> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }




}
