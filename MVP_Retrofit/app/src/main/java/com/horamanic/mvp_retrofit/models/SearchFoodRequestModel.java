package com.horamanic.mvp_retrofit.models;

import com.google.gson.annotations.SerializedName;

public class SearchFoodRequestModel{

	@SerializedName("keySearch")
	private String keySearch;

	public void setKeySearch(String keySearch){
		this.keySearch = keySearch;
	}

	public String getKeySearch(){
		return keySearch;
	}

	public SearchFoodRequestModel(String keySearch) {
		this.keySearch = keySearch;
	}

	@Override
 	public String toString(){
		return 
			"SearchFoodRequestModel{" + 
			"keySearch = '" + keySearch + '\'' + 
			"}";
		}
}