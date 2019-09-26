package com.horamanic.mvp_retrofit.GithubAPIPage;

import com.horamanic.mvp_retrofit.models.GetGithubAPIResponse;

public class GithubAPIPresenter implements GithubAPIContract.Presenter , GithubAPIContract.Model.OnFinishedListener {
    GetGithubAPIResponse githubAPIResponse;
    GithubAPIContract.Model githubAPIModel;
    GithubAPIContract.View githubAPIView;

    public GithubAPIPresenter(GithubAPIContract.View view) {
        githubAPIResponse = new GetGithubAPIResponse();
        githubAPIModel = new GithubAPIModel();
        githubAPIView = view;
    }

    @Override
    public void getAPIs() {
        githubAPIModel.getAPIList(this);
    }

    @Override
    public void onFinish(GetGithubAPIResponse githubAPIResponses) {
        this.githubAPIResponse = githubAPIResponses;
        githubAPIView.updateList(this.githubAPIResponse);
    }

    @Override
    public void onFailure(Throwable throwable) {
        githubAPIView.onFailure(throwable);
    }
}
