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
     *
     * @param unit , permet de creer une unité et l'envoie au serveur
     * @return
     */
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
