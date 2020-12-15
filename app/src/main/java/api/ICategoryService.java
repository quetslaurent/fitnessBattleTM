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

    //recuperer les categories
    @GET("categories")
    Call<List<CategoryOutput>> getCategory();
    //ajouter une categorie
    @POST("categories")
    Call<CategoryInput>postCategory(@Body CategoryInput categoryInput);
    //recuperer la liste de categories avec leur activites
    @GET("categories/activities")
    Call<List<ActivitiesByCategorieOutput>> getActivitiesByCategory();
}
