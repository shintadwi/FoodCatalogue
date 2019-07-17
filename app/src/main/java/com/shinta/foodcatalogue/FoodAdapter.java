package com.shinta.foodcatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Food> foods;

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;

    }

    public FoodAdapter(Context context) {
        this.context = context;
        foods = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Object getItem(int position) {
        return foods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);
        Food food = (Food) getItem(position);
        viewHolder.bind(food);
        return convertView;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;


        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);

        }

        void bind(Food food) {
            txtName.setText(food.getName());
            txtDescription.setText(food.getDescription());
            imgPhoto.setImageResource(food.getPhoto());

        }
    }
}
