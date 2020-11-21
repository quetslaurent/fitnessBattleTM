package repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import api.ApiClient;
import api.IUnitsService;
import model.Unit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UnitRepository {

    private IUnitsService getIUnitService(){
        return ApiClient.getClient().create(IUnitsService.class);
    }

    /**
     * flux d'info que l'on peut observer
     * on peut pas le modifier ! mais le mutable oui
     * @return
     */
    public LiveData<List<Unit>> query(){ //List d'oversable
        final MutableLiveData<List<Unit>> mutableLiveData = new MutableLiveData<>();

        getIUnitService().getUnits().enqueue(new Callback<List<Unit>>() {
            @Override
            public void onResponse(Call<List<Unit>> call, Response<List<Unit>> response) {
                mutableLiveData.postValue(response.body()); //on envoit des données sur le flux d'information
                //verifier si tache synchrone
            }

            @Override
            public void onFailure(Call<List<Unit>> call, Throwable t) {

            }
        });

        return  mutableLiveData;
    }
    public LiveData<Unit> create(Unit unit){
        final MutableLiveData<Unit> mutableLiveData = new MutableLiveData<>();
        getIUnitService().postUnits(unit).enqueue(new Callback<Unit>() {
            @Override
            public void onResponse(Call<Unit> call, Response<Unit> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Unit> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
