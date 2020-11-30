package repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import api.ApiClient;
import api.IUnitsService;
import model.inputDataModel.UnitInput;
import model.outputDataModel.UnitOutput;
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
    public LiveData<List<UnitOutput>> query(){ //List d'oversable
        final MutableLiveData<List<UnitOutput>> mutableLiveData = new MutableLiveData<>();

        getIUnitService().getUnits().enqueue(new Callback<List<UnitOutput>>() {
            @Override
            public void onResponse(Call<List<UnitOutput>> call, Response<List<UnitOutput>> response) {
                mutableLiveData.postValue(response.body()); //on envoit des données sur le flux d'information
                //verifier si tache synchrone
            }

            @Override
            public void onFailure(Call<List<UnitOutput>> call, Throwable t) {

            }
        });

        return  mutableLiveData;
    }
    public LiveData<UnitInput> create(UnitInput unit){
        final MutableLiveData<UnitInput> mutableLiveData = new MutableLiveData<>();
        getIUnitService().postUnits(unit).enqueue(new Callback<UnitInput>() {
            @Override
            public void onResponse(Call<UnitInput> call, Response<UnitInput> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<UnitInput> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
