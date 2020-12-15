package api;

import model.inputDataModel.UserFitnessInput;
import model.inputDataModel.UserFitnessInputLogin;
import model.outputDataModel.UserFitnessOutputLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IAuthService {

    //utiliser l'auth
    @POST("auth")
    Call<UserFitnessOutputLogin> loginUser(@Body UserFitnessInputLogin userFitnessInputLogin);
}
