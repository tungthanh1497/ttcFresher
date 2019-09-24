package com.horamanic.mvp_retrofit.TypeFoodPage;

import com.horamanic.mvp_retrofit.models.FoodItem;
import com.horamanic.mvp_retrofit.models.GetFoodByTypeResponse;

import java.util.List;

public interface TypeFoodContract {
    interface Model {
        interface OnFinishedListener {
            void onFinished(List<FoodItem> foodList);

            void onFailure(Throwable t);
        }

        void getFoodByType(OnFinishedListener onFinishedListener, int typeId);
    }

    interface View {
        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<FoodItem> foodList);

        void onResponseFailure(Throwable throwable);
    }

    interface Presenter {
        void onDestroy();

        void requestDataFromServer(int typeId);
    }
}
