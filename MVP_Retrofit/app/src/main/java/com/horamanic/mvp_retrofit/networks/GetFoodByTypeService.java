package com.horamanic.mvp_retrofit.networks;

import com.horamanic.mvp_retrofit.models.GetFoodByTypeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetFoodByTypeService {
    @GET("getFoodByType/{foodType}")
    Call<GetFoodByTypeResponse> getFoodByType(@Path("foodType") int foodType);
}
