package api;

import java.util.List;

import model.inputDataModel.UnitInput;
import model.outputDataModel.UnitOutput;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IUnitsService {

    @GET("units")
    Call<List<UnitOutput>> getUnits();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport

    @POST("units")
    Call<UnitInput>postUnits(@Body UnitInput unit);
}
