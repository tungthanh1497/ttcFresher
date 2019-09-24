package com.horamanic.mvp_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.horamanic.mvp_retrofit.TypeFoodPage.TypeFoodFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        registerListener();
    }

    private void registerListener() {
        btnOpen.setOnClickListener(this);
    }

    private void initView() {
        btnOpen = findViewById(R.id.btn_open);
    }

    @Override
    public void onClick(View v) {
        if (v == btnOpen) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.rl_container, new TypeFoodFragment());
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
