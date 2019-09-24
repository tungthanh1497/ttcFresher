package com.horamanic.mvp_retrofit.TypeFoodPage;

import android.util.Log;

import com.horamanic.mvp_retrofit.models.FoodItem;
import com.horamanic.mvp_retrofit.models.GetFoodByTypeResponse;
import com.horamanic.mvp_retrofit.networks.GetFoodByTypeService;
import com.horamanic.mvp_retrofit.networks.RetrofitFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TypeFoodModel implements TypeFoodContract.Model {
    private static final String TAG = TypeFoodModel.class.toString();

    @Override
    public void getFoodByType(final OnFinishedListener onFinishedListener, int typeId) {
        Log.d(TAG, "getFoodByType: ");
        final GetFoodByTypeService getFoodByTypeService = RetrofitFactory.getInstance().create(GetFoodByTypeService.class);
        getFoodByTypeService.getFoodByType(typeId).enqueue(new Callback<GetFoodByTypeResponse>() {
            @Override
            public void onResponse(Call<GetFoodByTypeResponse> call, Response<GetFoodByTypeResponse> response) {
                List<FoodItem> foodList = response.body().getFood();
                Log.d(TAG, "onResponse: " + foodList);
                onFinishedListener.onFinished(foodList);
            }

            @Override
            public void onFailure(Call<GetFoodByTypeResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t);
                onFinishedListener.onFailure(t);
            }
        });
    }
}
