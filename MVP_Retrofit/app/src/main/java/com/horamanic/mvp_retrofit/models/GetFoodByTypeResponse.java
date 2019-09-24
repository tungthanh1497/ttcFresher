package com.horamanic.mvp_retrofit.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetFoodByTypeResponse{

	@SerializedName("food")
	private List<FoodItem> food;

	public void setFood(List<FoodItem> food){
		this.food = food;
	}

	public List<FoodItem> getFood(){
		return food;
	}

	@Override
 	public String toString(){
		return 
			"GetFoodByTypeResponse{" + 
			"food = '" + food + '\'' + 
			"}";
		}
}