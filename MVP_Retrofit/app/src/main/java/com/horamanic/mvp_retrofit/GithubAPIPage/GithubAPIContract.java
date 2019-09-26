package com.horamanic.mvp_retrofit.GithubAPIPage;

import com.horamanic.mvp_retrofit.models.GetGithubAPIResponse;

import java.util.List;

public interface GithubAPIContract {
    interface Model{
        interface OnFinishedListener{
            void onFinish(GetGithubAPIResponse githubAPIResponses);
            void onFailure(Throwable throwable);
        }
        void getAPIList(OnFinishedListener onFinishedListener);
    }
    interface View{
        void updateList(GetGithubAPIResponse githubAPIResponse);
        void onFailure(Throwable throwable);
    }
    interface Presenter{
        void getAPIs();
    }
}
