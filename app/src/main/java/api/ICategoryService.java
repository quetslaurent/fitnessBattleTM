package api;

import java.util.List;

import model.inputDataModel.CategoryInput;
import model.outputDataModel.CategoryOutput;
import model.outputDataModel.ActivitiesByCategorieOutput;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ICategoryService {

    @GET("categories")
    Call<List<CategoryOutput>> getCategory();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport


    @POST("categories")
    Call<CategoryInput>postCategory(@Body CategoryInput categoryInput);

    @GET("categories/activities")
    Call<List<ActivitiesByCategorieOutput>> getActivitiesByCategory();
}
