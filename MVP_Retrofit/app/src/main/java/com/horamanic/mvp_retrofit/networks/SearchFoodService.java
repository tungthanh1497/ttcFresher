package com.horamanic.mvp_retrofit.networks;

import com.horamanic.mvp_retrofit.models.GetFoodByTypeResponse;
import com.horamanic.mvp_retrofit.models.SearchFoodRequestModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SearchFoodService {
    @POST("searching")
    Call<GetFoodByTypeResponse> searchFood(@Body SearchFoodRequestModel searchFoodRequestModel);
}
