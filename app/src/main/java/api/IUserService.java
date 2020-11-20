package api;

import java.util.List;

import model.ActivitySport;
import model.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IUserService {


    @GET("bd")
    Call<List<User>> getUser();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport

}
