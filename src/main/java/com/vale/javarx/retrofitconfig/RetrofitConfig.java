package com.vale.javarx.retrofitconfig;


import com.vale.javarx.clientapi.GhibliClientApi;
import com.vale.javarx.clientapi.NobelClientApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
    @Bean
    GhibliClientApi ghibliClientApi(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://ghibliapi.herokuapp.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(GhibliClientApi.class);
    }

    @Bean
    NobelClientApi nobelClientApi(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://api.nobelprize.org/2.0/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(NobelClientApi.class);
    }
}
