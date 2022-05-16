package org.ilri.adggcatalogue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroInterface {

    @GET("topAnimals")
    Call<List<TopAnimals>> getTopAnimals();

    @GET("bullsemen")
    Call<List<BullSemen>> getBullSemen();

    @GET("topAnimalsIdOnly")
    Call<List<TopAnimalsIdOnly>> getTopAnimalsIdOnly();
}
