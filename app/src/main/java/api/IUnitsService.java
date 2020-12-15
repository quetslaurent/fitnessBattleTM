package api;

import java.util.List;

import model.inputDataModel.UnitInput;
import model.outputDataModel.UnitOutput;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IUnitsService {
    //recuperer les units
    @GET("units")
    Call<List<UnitOutput>> getUnits();

    //ajout d'un unit
    @POST("units")
    Call<UnitInput>postUnits(@Body UnitInput unit);
}
