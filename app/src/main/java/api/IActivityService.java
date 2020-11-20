package api;


import java.util.List;

import model.ActivitySport;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IActivityService {

    @GET("bd")
    Call<List<ActivitySport>> getActivitySport();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport
}
