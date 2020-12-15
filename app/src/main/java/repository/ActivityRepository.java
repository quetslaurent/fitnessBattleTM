package repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import api.ApiClient;
import api.IActivityService;
import model.outputDataModel.ActivitySport;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityRepository {


    /**
     *
     *On recupère l'instance de l'activity service
     */
    private IActivityService getIActivityService(){
        return ApiClient.getClient().create(IActivityService.class);
    }


     /**
      *-------------------------------------
      *  Permet de creer une Activité
      * ---------------------------------
      */

    public LiveData<ActivitySport> create(ActivitySport activitySport){
        final MutableLiveData<ActivitySport> mutableLiveData = new MutableLiveData<>();
        getIActivityService().postActivity(activitySport).enqueue(new Callback<ActivitySport>() {
            @Override
            public void onResponse(Call<ActivitySport> call, Response<ActivitySport> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ActivitySport> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }


    /**
     *-------------------------------------
     *  Recuperer une activité grace son ID
     * ---------------------------------
     */
    public MutableLiveData<List<ActivitySport>> getById(int id) {
        final MutableLiveData<List<ActivitySport>> mutableLiveData = new MutableLiveData<>();

        getIActivityService().getActivity(id).enqueue(new Callback<List<ActivitySport>>() {
            @Override
            public void onResponse(Call<List<ActivitySport>> call, Response<List<ActivitySport>> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ActivitySport>> call, Throwable t) {

            }
        });

        return  mutableLiveData;


    }
}
