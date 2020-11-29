package api;

import java.util.List;

import modele.outputDataModel.UserFitnessOutput;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IUserService {


    @GET("users")
    Call<List<UserFitnessOutput>> getUsers();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport

    @GET("users/{id}")
    Call<UserFitnessOutput> getUser(@Path("id")int id);

    @POST("users")
    Call<UserFitnessOutput>postUser(@Body UserFitnessOutput user);


}

