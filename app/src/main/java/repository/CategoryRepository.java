package repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import api.ApiClient;
import api.ICategoryService;
import modele.outputDataModel.Category;
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
    public LiveData<List<Category>> query(){ //List d'oversable
        final MutableLiveData<List<Category>> mutableLiveData = new MutableLiveData<>();

        getICategoryService().getCategory().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                mutableLiveData.postValue(response.body()); //on envoit des données sur le flux d'information
                //verifier si tache synchrone
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });

        return  mutableLiveData;
    }
    public LiveData<Category> create(Category category){
        final MutableLiveData<Category> mutableLiveData = new MutableLiveData<>();
        getICategoryService().postCategory(category).enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }

}
