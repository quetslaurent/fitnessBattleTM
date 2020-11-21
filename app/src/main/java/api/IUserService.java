package api;

import java.util.List;

import model.UserFitness;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IUserService {


    @GET("users")
    Call<List<UserFitness>> getUser();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport


    @POST("users")
    Call<UserFitness>postUser(@Body UserFitness user);
}
