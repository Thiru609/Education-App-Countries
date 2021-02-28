package com.example.country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("{id}/")
    Call<List<CountriesDetail>> getCountries(
            @Path("id") String name
    );

}
