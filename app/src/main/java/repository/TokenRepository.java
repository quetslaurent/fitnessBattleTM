package repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import api.ApiClient;
import api.ITokenService;
import model.outputDataModel.UserFitnessOutputToken;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TokenRepository {

    private ITokenService getITokenService(){
        return ApiClient.getClient().create(ITokenService.class);
    }


    public LiveData<UserFitnessOutputToken> getUserFromToken(){
        final MutableLiveData<UserFitnessOutputToken> mutableLiveData = new MutableLiveData<>();
        getITokenService().getUserByToken(ApiClient.getToken()).enqueue(new Callback<UserFitnessOutputToken>() {
            @Override
            public void onResponse(Call<UserFitnessOutputToken> call, Response<UserFitnessOutputToken> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<UserFitnessOutputToken> call, Throwable t) {

            }

        });
        return mutableLiveData;
}
    }
