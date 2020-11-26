package api;


import java.util.List;

import model.ActivitySport;
import model.UserFitness;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IActivityService {

    @GET("activity")
    Call<List<ActivitySport>> getActivitySport();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport

    @GET("activity/{id}")
    Call<ActivitySport> getActivity(@Path("id")int id);

    @POST("activity")
    Call<ActivitySport>postActivity(@Body ActivitySport activitySport);

}
