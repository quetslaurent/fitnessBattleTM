package api;


import java.util.List;

import model.ActivitySport;
import model.UserFitness;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IActivityService {

    @GET("activity")
    Call<List<ActivitySport>> getActivitySport();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport

    @POST("activity")
    Call<ActivitySport>postActivity(@Body ActivitySport activitySport);
}
