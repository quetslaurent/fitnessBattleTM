package api;

import java.util.List;

import model.Training;
import model.UserFitness;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ITrainingService {

    @GET("training")
    Call<List<Training>> getTraining();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport


    @POST("training")
    Call<Training>postTraining(@Body Training training);

}
