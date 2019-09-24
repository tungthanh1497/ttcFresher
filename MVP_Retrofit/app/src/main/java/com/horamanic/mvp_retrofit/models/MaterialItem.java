package com.horamanic.mvp_retrofit.models;

import com.google.gson.annotations.SerializedName;

public class MaterialItem{

	@SerializedName("_id")
	private String id;

	@SerializedName("matQuantum")
	private String matQuantum;

	@SerializedName("matName")
	private String matName;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setMatQuantum(String matQuantum){
		this.matQuantum = matQuantum;
	}

	public String getMatQuantum(){
		return matQuantum;
	}

	public void setMatName(String matName){
		this.matName = matName;
	}

	public String getMatName(){
		return matName;
	}

	@Override
 	public String toString(){
		return 
			"MaterialItem{" + 
			"_id = '" + id + '\'' + 
			",matQuantum = '" + matQuantum + '\'' + 
			",matName = '" + matName + '\'' + 
			"}";
		}
}