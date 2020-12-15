package api;


import java.util.List;

import model.outputDataModel.ActivitySport;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IActivityService {

    //requete du get Activity
    @GET("activity")
    Call<List<ActivitySport>> getActivitySport();

    //ajout d'une activity
    @POST("activity")
    Call<ActivitySport>postActivity(@Body ActivitySport activitySport);

    //recuperer une activity par son id
    @GET("activity/{id}")
    Call<List<ActivitySport>> getActivity(@Path("id")int id);

}
