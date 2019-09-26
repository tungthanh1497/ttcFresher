package com.horamanic.mvp_retrofit.GithubAPIPage;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.horamanic.mvp_retrofit.R;
import com.horamanic.mvp_retrofit.models.GetGithubAPIResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class GithubAPIFragment extends Fragment implements GithubAPIContract.View {

    TextView tv;
    GithubAPIPresenter presenter;

    public GithubAPIFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_github_api, container, false);

        initViews(view);
        presenter.getAPIs();

        return view;
    }

    private void initViews(View view) {
        tv = view.findViewById(R.id.tv_text_view);
        presenter = new GithubAPIPresenter(this);
    }

    @Override
    public void updateList(GetGithubAPIResponse githubAPIResponse) {
        tv.setText(githubAPIResponse.toString());
    }

    @Override
    public void onFailure(Throwable throwable) {
        Toast.makeText(getContext(), throwable.toString(), Toast.LENGTH_LONG).show();
    }
}
