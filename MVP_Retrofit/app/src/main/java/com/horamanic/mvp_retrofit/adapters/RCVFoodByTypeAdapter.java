package com.horamanic.mvp_retrofit.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.horamanic.mvp_retrofit.R;
import com.horamanic.mvp_retrofit.models.FoodItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RCVFoodByTypeAdapter extends RecyclerView.Adapter<RCVFoodByTypeAdapter.ViewHolder> {

    private static final String TAG = RCVFoodByTypeAdapter.class.toString();
    List<FoodItem> foodList;

    public RCVFoodByTypeAdapter(List<FoodItem> foodList) {
        this.foodList = foodList;
        Log.d(TAG, "RCVFoodByTypeAdapter: " + foodList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + foodList.get(position));
        Picasso.get().load(foodList.get(position).getImageShow()).into(holder.iv);
        holder.tvTitle.setText(foodList.get(position).getName());
        holder.tvAuthor.setText(foodList.get(position).getAuthorName());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView iv;
        public TextView tvTitle;
        public TextView tvAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_image);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }

}
