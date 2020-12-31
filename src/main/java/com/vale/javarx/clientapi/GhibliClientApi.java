package com.vale.javarx.clientapi;


import com.vale.javarx.entity.GhibliMovie;
import com.vale.javarx.entity.GhibliPerson;
import retrofit2.http.GET;

import java.util.List;

public interface GhibliClientApi {

    @GET("/films")
    List<GhibliMovie> getAllMovies();

    @GET("/people")
    List<GhibliPerson> getAllPeople();
}
