package api;

import java.util.List;

import modele.inputDataModel.TrainingInput;
import modele.outputDataModel.TrainingOutput;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ITrainingService {

    @GET("training")
    Call<List<TrainingOutput>> getTraining();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport


    @GET("training/user/{id}")
    Call<List<TrainingOutput>> getTrainingbyUserId(@Path("id")int id);//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport


    @POST("training")
    Call<TrainingInput>postTraining(@Body TrainingInput trainingInput);

}
