package repository;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.projet.LoginActivity;

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

    /**
     * Permet de recuperer un utilisateur via son token lorsqu'il s'identifie.
     * Renvoie un UserFitnessOutputToken
     * @return
     */
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
