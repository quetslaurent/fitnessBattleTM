package api;

import java.util.List;

import model.inputDataModel.UserFitnessInput;
import model.outputDataModel.UserFitnessOutput;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IUserService {


    @GET("users")
    Call<List<UserFitnessOutput>> getUsers();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport

    @GET("users/{id}")
    Call<UserFitnessOutput> getUser(@Path("id")int id);

    @GET("users/points/{id}")
    Call<Double> getUserPoint(@Path("id")int id);

    @POST("users")
    Call<UserFitnessInput>postUser(@Body UserFitnessInput user);

}

