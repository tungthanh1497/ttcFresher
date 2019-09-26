package com.horamanic.mvp_retrofit.networks;

import com.horamanic.mvp_retrofit.models.GetGithubAPIResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GetGithubAPIService {
    @GET("https://api.github.com/")
    Observable<GetGithubAPIResponse> getAPIs();
}
