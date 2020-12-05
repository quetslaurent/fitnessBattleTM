package api;
        import java.io.IOException;

        import okhttp3.Interceptor;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import okhttp3.Response;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;
public class ApiClient {

    private static final String BASE_URL_API_DEV ="http://10.0.2.2:5000/api/";

    private static  String token = null;
    static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            return chain.proceed(newRequest);
        }
    }).build();


    public static Retrofit getClient(){
        return new Retrofit.Builder() //car on retourne une instance d'un retrofit
                .client(client)
                .baseUrl(BASE_URL_API_DEV)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static void setToken(String token) {
        ApiClient.token = token;
    }

    public static String getToken() {
        return token;
    }
}
