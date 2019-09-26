package com.horamanic.mvp_retrofit.GithubAPIPage;

import android.util.Log;

import com.horamanic.mvp_retrofit.models.GetGithubAPIResponse;
import com.horamanic.mvp_retrofit.networks.GetGithubAPIService;
import com.horamanic.mvp_retrofit.networks.RetrofitFactory;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GithubAPIModel implements GithubAPIContract.Model {
    private static final String TAG = GithubAPIModel.class.toString();

    @Override
    public void getAPIList(final OnFinishedListener onFinishedListener) {
        GetGithubAPIService getGithubAPIService = RetrofitFactory.getInstance().create(GetGithubAPIService.class);
        Observable<GetGithubAPIResponse> githubAPIResponseObservable = getGithubAPIService.getAPIs();
        githubAPIResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetGithubAPIResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(GetGithubAPIResponse githubAPIResponses) {
                        Log.d(TAG, "onNext: " + githubAPIResponses);
                        onFinishedListener.onFinish(githubAPIResponses);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e);
                        onFinishedListener.onFailure(e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }
}
