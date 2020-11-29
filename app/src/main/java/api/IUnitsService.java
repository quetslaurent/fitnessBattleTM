package api;

import java.util.List;

import modele.outputDataModel.UnitOutput;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IUnitsService {

    @GET("units")
    Call<List<UnitOutput>> getUnits();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport

    @POST("units")
    Call<UnitOutput>postUnits(@Body UnitOutput unit);
}
