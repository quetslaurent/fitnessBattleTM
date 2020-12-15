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

    //recuperer les users
    @GET("users")
    Call<List<UserFitnessOutput>> getUsers();

    //recuperer un user par un id grace a son token
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("users/{token}")
    Call<UserFitnessOutput> getUserById(@Path("token")String token);

    //recuperer les points d'un user grace a son token
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("users/points/{token}")
    Call<Double> getUserPoint(@Path("token")String token);

    //ajout d'un user
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("users")
    Call<UserFitnessInput>postUser(@Body UserFitnessInput user);

    //update un user
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @PUT("users/{token}")
    Call<UserFitnessInput>update(@Path("token")String token,@Body UserFitnessInput user);

    //supprimer un user
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @DELETE("users/{token}")
    Call<String> deleteUser(@Path("token")String token);

}

