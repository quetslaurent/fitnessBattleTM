package repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import api.ApiClient;
import api.ICategoryService;
import model.outputDataModel.ActivitiesByCategorieOutput;
import model.inputDataModel.CategoryInput;
import model.outputDataModel.CategoryOutput;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {


    private ICategoryService getICategoryService(){
        return ApiClient.getClient().create(ICategoryService.class);
    }

    /**
     * flux d'info que l'on peut observer
     * on peut pas le modifier ! mais le mutable oui
     * @return
     */
    public LiveData<List<CategoryOutput>> query(){ //List d'oversable
        final MutableLiveData<List<CategoryOutput>> mutableLiveData = new MutableLiveData<>();

        getICategoryService().getCategory().enqueue(new Callback<List<CategoryOutput>>() {
            @Override
            public void onResponse(Call<List<CategoryOutput>> call, Response<List<CategoryOutput>> response) {
                mutableLiveData.postValue(response.body()); //on envoit des données sur le flux d'information
                //verifier si tache synchrone
            }

            @Override
            public void onFailure(Call<List<CategoryOutput>> call, Throwable t) {

            }
        });

        return  mutableLiveData;
    }
    public LiveData<CategoryInput> create(CategoryInput categoryInput){
        final MutableLiveData<CategoryInput> mutableLiveData = new MutableLiveData<>();
        getICategoryService().postCategory(categoryInput).enqueue(new Callback<CategoryInput>() {
            @Override
            public void onResponse(Call<CategoryInput> call, Response<CategoryInput> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<CategoryInput> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }

    public LiveData<List<ActivitiesByCategorieOutput>>queryCategoriesActivities(){ //List d'oversable
        final MutableLiveData<List<ActivitiesByCategorieOutput>> mutableLiveData = new MutableLiveData<>();

        getICategoryService().getActivitiesByCategory().enqueue(new Callback<List<ActivitiesByCategorieOutput>>() {

            @Override
            public void onResponse(Call<List<ActivitiesByCategorieOutput>> call, Response<List<ActivitiesByCategorieOutput>> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ActivitiesByCategorieOutput>> call, Throwable t) {

            }
        });

        return  mutableLiveData;
    }



}
