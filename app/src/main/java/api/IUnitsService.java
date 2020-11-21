package api;

import java.util.List;

import model.Unit;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IUnitsService {

    @GET("units")
    Call<List<Unit>> getUnits();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport

    @POST("units")
    Call<Unit>postUnits(@Body Unit unit);
}
