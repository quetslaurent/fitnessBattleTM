package api;

import java.util.List;

import model.inputDataModel.TrainingInput;
import model.outputDataModel.TrainingOutput;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ITrainingService {

    @GET("training")
    Call<List<TrainingOutput>> getTraining();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de training
    //recuperer les training d'un user grace a son token
    @GET("training/user/{token}")
    Call<List<TrainingOutput>> getTrainingbyUserId(@Path("token")String token);
    //ajout d'un training
    @POST("training")
    Call<TrainingInput>postTraining(@Body TrainingInput trainingInput);

}
