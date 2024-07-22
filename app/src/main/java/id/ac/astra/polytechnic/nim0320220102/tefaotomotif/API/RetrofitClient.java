package id.ac.astra.polytechnic.nim0320220102.tefaotomotif.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient
{
    public static Retrofit sRetrofit = null;

    public static Retrofit getClient(String url){
        if(sRetrofit == null){
            sRetrofit = new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return sRetrofit;
    }
}
