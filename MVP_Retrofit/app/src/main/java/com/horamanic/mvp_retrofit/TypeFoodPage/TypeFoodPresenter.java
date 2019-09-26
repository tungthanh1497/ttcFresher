package com.horamanic.mvp_retrofit.TypeFoodPage;

import android.util.Log;

import com.horamanic.mvp_retrofit.models.FoodItem;

import java.util.List;

public class TypeFoodPresenter implements TypeFoodContract.Presenter, TypeFoodContract.Model.OnFinishedListener {

    private static final String TAG = TypeFoodPresenter.class.toString();
    TypeFoodContract.View typeFoodView;
    TypeFoodContract.Model typeFoodModel;

    public TypeFoodPresenter(TypeFoodContract.View typeFoodView) {
        this.typeFoodView = typeFoodView;
        this.typeFoodModel = new TypeFoodModel();
    }

    @Override
    public void onDestroy() {
        typeFoodView = null;
    }

    @Override
    public void requestDataFromServer(int typeId) {
        if (typeFoodView != null) {
            typeFoodView.showProgress();
        }
        typeFoodModel.getFoodByType(this, typeId);

    }

    @Override
    public void searchFood(String foodName) {
        if (typeFoodView != null) {
            typeFoodView.showProgress();
        }
        typeFoodModel.searchFood(this, foodName);
    }

    @Override
    public void onFinished(List<FoodItem> foodList) {
        Log.d(TAG, "onFinished: "+foodList);
        typeFoodView.setDataToRecyclerView(foodList);
        if (typeFoodView != null) {
            typeFoodView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        typeFoodView.onResponseFailure(t);
        if (typeFoodView != null) {
            typeFoodView.hideProgress();
        }
    }
}
