package api;

import java.util.List;

import model.outputDataModel.UserFitnessOutputToken;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ITokenService {
    //utilisation du token
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("token/{token}")
    Call<UserFitnessOutputToken> getUserByToken(@Path("token") String token);


}
