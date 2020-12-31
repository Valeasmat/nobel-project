package com.vale.javarx.clientapi;


import com.vale.javarx.entity.LaureateInfo;
import com.vale.javarx.entity.NobelPrize;
import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface NobelClientApi {

    @GET("nobelPrize/{category}/{year}")
    Observable<List<NobelPrize>> getNobelByCategoryandYear(@Path("category") String category, @Path("year") Integer year);

    @GET("laureate/{id}")
    Observable<List<LaureateInfo>> getLaureateInfo(@Path("id") Integer id);
}
