package com.horamanic.mvp_retrofit.TypeFoodPage;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.horamanic.mvp_retrofit.R;
import com.horamanic.mvp_retrofit.adapters.RCVFoodByTypeAdapter;
import com.horamanic.mvp_retrofit.models.FoodItem;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TypeFoodFragment extends Fragment implements TypeFoodContract.View, View.OnClickListener {

    private static final String TAG = TypeFoodFragment.class.toString();
    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    RCVFoodByTypeAdapter adapter;
    List<FoodItem> foodList;
    ProgressBar pbProgress;
    Button btn1, btn2, btn3, btn4, btn5;
    TypeFoodPresenter presenter;
    EditText etFoodName;
    Button btnSearch;

    public TypeFoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_type_food, container, false);

        initView(view);
        registerListeners();

        presenter.requestDataFromServer(1);

        return view;
    }

    private void registerListeners() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
    }

    private void initView(View view) {
        presenter = new TypeFoodPresenter(this);
        rv = view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(lm);
        foodList = new ArrayList<>();
        adapter = new RCVFoodByTypeAdapter(foodList);
        rv.setAdapter(adapter);
        pbProgress = view.findViewById(R.id.pb_progress);
        btn1 = view.findViewById(R.id.btn_1);
        btn2 = view.findViewById(R.id.btn_2);
        btn3 = view.findViewById(R.id.btn_3);
        btn4 = view.findViewById(R.id.btn_4);
        btn5 = view.findViewById(R.id.btn_5);
        etFoodName = view.findViewById(R.id.et_food_name);
        btnSearch = view.findViewById(R.id.btn_search);
    }

    @Override
    public void showProgress() {
        pbProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbProgress.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerView(List<FoodItem> foodList) {
        Log.d(TAG, "setDataToRecyclerView: " + foodList);
//        this.foodList = new ArrayList<>();
        this.foodList.clear();
        this.foodList.addAll(foodList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Log.e(TAG, "onResponseFailure: " + throwable);
        Toast.makeText(getContext(), throwable.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if (v == btn1) {
            presenter.requestDataFromServer(1);
        } else if (v == btn2) {
            presenter.requestDataFromServer(2);
        } else if (v == btn3) {
            presenter.requestDataFromServer(3);
        } else if (v == btn4) {
            presenter.requestDataFromServer(4);
        } else if (v == btn5) {
            presenter.requestDataFromServer(5);
        } else if (v == btnSearch) {
            presenter.searchFood(etFoodName.getText().toString().trim());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
