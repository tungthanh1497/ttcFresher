package com.horamanic.mvp_retrofit.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FoodItem{

	@SerializedName("sets")
	private int sets;

	@SerializedName("level")
	private String level;

	@SerializedName("author")
	private String author;

	@SerializedName("cook")
	private List<CookItem> cook;

	@SerializedName("rating")
	private double rating;

	@SerializedName("type")
	private int type;

	@SerializedName("listRate")
	private List<Object> listRate;

	@SerializedName("material")
	private List<MaterialItem> material;

	@SerializedName("authorName")
	private String authorName;

	@SerializedName("__v")
	private int V;

	@SerializedName("name")
	private String name;

	@SerializedName("rateNum")
	private int rateNum;

	@SerializedName("_id")
	private String id;

	@SerializedName("time")
	private String time;

	@SerializedName("imageShow")
	private String imageShow;

	public void setSets(int sets){
		this.sets = sets;
	}

	public int getSets(){
		return sets;
	}

	public void setLevel(String level){
		this.level = level;
	}

	public String getLevel(){
		return level;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setCook(List<CookItem> cook){
		this.cook = cook;
	}

	public List<CookItem> getCook(){
		return cook;
	}

	public void setRating(double rating){
		this.rating = rating;
	}

	public double getRating(){
		return rating;
	}

	public void setType(int type){
		this.type = type;
	}

	public int getType(){
		return type;
	}

	public void setListRate(List<Object> listRate){
		this.listRate = listRate;
	}

	public List<Object> getListRate(){
		return listRate;
	}

	public void setMaterial(List<MaterialItem> material){
		this.material = material;
	}

	public List<MaterialItem> getMaterial(){
		return material;
	}

	public void setAuthorName(String authorName){
		this.authorName = authorName;
	}

	public String getAuthorName(){
		return authorName;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRateNum(int rateNum){
		this.rateNum = rateNum;
	}

	public int getRateNum(){
		return rateNum;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setImageShow(String imageShow){
		this.imageShow = imageShow;
	}

	public String getImageShow(){
		return imageShow;
	}

	@Override
 	public String toString(){
		return 
			"FoodItem{" + 
			"sets = '" + sets + '\'' + 
			",level = '" + level + '\'' + 
			",author = '" + author + '\'' + 
			",cook = '" + cook + '\'' + 
			",rating = '" + rating + '\'' + 
			",type = '" + type + '\'' + 
			",listRate = '" + listRate + '\'' + 
			",material = '" + material + '\'' + 
			",authorName = '" + authorName + '\'' + 
			",__v = '" + V + '\'' + 
			",name = '" + name + '\'' + 
			",rateNum = '" + rateNum + '\'' + 
			",_id = '" + id + '\'' + 
			",time = '" + time + '\'' + 
			",imageShow = '" + imageShow + '\'' + 
			"}";
		}
}