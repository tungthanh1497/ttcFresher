package com.horamanic.mvp_retrofit.models;

import com.google.gson.annotations.SerializedName;

public class CookItem{

	@SerializedName("image")
	private String image;

	@SerializedName("note")
	private String note;

	@SerializedName("_id")
	private String id;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setNote(String note){
		this.note = note;
	}

	public String getNote(){
		return note;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"CookItem{" + 
			"image = '" + image + '\'' + 
			",note = '" + note + '\'' + 
			",_id = '" + id + '\'' + 
			"}";
		}
}