package api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiClient {

    private static final String BASE_URL_API_DEV ="http://10.0.2.2:5000/api/";


    public static Retrofit getClient(){
        return new Retrofit.Builder() //car on retourne une instance d'un retrofit
                .baseUrl(BASE_URL_API_DEV)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
