package api;

import java.util.List;

import modele.outputDataModel.TrainingDateOutput;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ITrainingDateService {

    @GET("training-dates")
    Call<List<TrainingDateOutput>> getTrainingDate();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de training date


    @POST("training-dates")
    Call<TrainingDateOutput>postTrainingDate(@Body TrainingDateOutput trainingDateOutput);
}
