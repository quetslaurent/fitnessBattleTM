package repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import api.ApiClient;
import api.IActivityService;
import api.IUserService;
import model.ActivitySport;
import model.UserFitness;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityRepository {

    private IActivityService getIActivityService(){
        return ApiClient.getClient().create(IActivityService.class);
    }

    /**
     * flux d'info que l'on peut observer
     * on peut pas le modifier ! mais le mutable oui
     * @return
     */
    public LiveData<List<ActivitySport>> query(){ //List d'oversable
        final MutableLiveData<List<ActivitySport>> mutableLiveData = new MutableLiveData<>();

        getIActivityService().getActivitySport().enqueue(new Callback<List<ActivitySport>>() {
            @Override
            public void onResponse(Call<List<ActivitySport>> call, Response<List<ActivitySport>> response) {
                mutableLiveData.postValue(response.body()); //on envoit des données sur le flux d'information
                //verifier si tache synchrone
            }

            @Override
            public void onFailure(Call<List<ActivitySport>> call, Throwable t) {

            }
        });

        return  mutableLiveData;
    }
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


    public LiveData<ActivitySport> getById(int id) {
        final MutableLiveData<ActivitySport> mutableLiveData = new MutableLiveData<>();
        getIActivityService().getActivity(id).enqueue(new Callback<ActivitySport>() {
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

}
