package api;

import java.util.List;

import model.TrainingDate;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ITrainingDateService {

    @GET("training-dates")
    Call<List<TrainingDate>> getTrainingDate();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport


    @POST("training-dates")
    Call<TrainingDate>postTrainingDate(@Body TrainingDate trainingDate);
}
