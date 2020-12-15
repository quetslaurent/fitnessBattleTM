package api;

import java.util.List;

import model.inputDataModel.TrainingDateInput;
import model.outputDataModel.TrainingDateOutput;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ITrainingDateService {


    @GET("training-dates")
    Call<List<TrainingDateOutput>> getTrainingDate();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de training date
    //ajout d'une training date
    @POST("training-dates")
    Call<TrainingDateInput>postTrainingDate(@Body TrainingDateInput trainingDateInput);

    //ajout d'une training date à l'instant ou on l'appelle
    @POST("training-dates/today")
    Call<TrainingDateInput>postToday();
}
