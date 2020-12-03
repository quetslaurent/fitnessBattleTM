package repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import api.ApiClient;
import api.IAuthService;
import model.inputDataModel.UserFitnessInputLogin;
import model.outputDataModel.UserFitnessOutputLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {

    private IAuthService getIAuthService(){
        return ApiClient.getClient().create(IAuthService.class);
    }

    public LiveData<UserFitnessOutputLogin> loginUser(UserFitnessInputLogin userFitnessInputLogin){
        final MutableLiveData<UserFitnessOutputLogin>mutableLiveData = new MutableLiveData<>();

        getIAuthService().loginUser(userFitnessInputLogin).enqueue(new Callback<UserFitnessOutputLogin>() {
            @Override
            public void onResponse(Call<UserFitnessOutputLogin> call, Response<UserFitnessOutputLogin> response) {
                    mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<UserFitnessOutputLogin> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
