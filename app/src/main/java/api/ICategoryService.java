package api;

import java.util.List;

import modele.outputDataModel.Category;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ICategoryService {

    @GET("categories")
    Call<List<Category>> getCategory();//le call sert a contacter la db et recuperer ( dans ce cas ) a récuperer une liste de ActivitySport


    @POST("categories")
    Call<Category>postCategory(@Body Category category);
}
