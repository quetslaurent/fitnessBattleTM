package api;

import java.util.List;

import model.inputDataModel.UserFitnessInput;
import model.outputDataModel.UserFitnessOutput;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IUserService {


    @GET("users")
    Call<List<UserFitnessOutput>> getUsers();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("users/{token}")
    Call<UserFitnessOutput> getUserById(@Path("token")String token);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("users/points/{token}")
    Call<Double> getUserPoint(@Path("token")String token);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("users")
    Call<UserFitnessInput>postUser(@Body UserFitnessInput user);

    @POST("users/login")
    Call<String>login(@Body UserFitnessInput user);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @PUT("users/{token}")
    Call<UserFitnessInput>update(@Path("token")String token,@Body UserFitnessInput user);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @DELETE("users/{token}")
    Call<UserFitnessInput>deleteUser(@Path("token")String token);


}

