package com.shinta.foodcatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataRecipe;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private FoodAdapter adapter;
    private ArrayList<Food> foods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FoodAdapter(this);

        final ListView listView = findViewById(R.id.lv_list1);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, foods.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent moveIntent = new Intent(MainActivity.this, DetailFoodActivity.class);
                moveIntent.putExtra(DetailFoodActivity.EXTRA_PERSON, foods.get(position));
                startActivity(moveIntent);

            }
        });
    }

    private void addItem() {
        // Memasukkan array kedalam adapter
        foods = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Food film = new Food();
            film.setPhoto(dataPhoto.getResourceId(i, -1));
            film.setName(dataName[i]);
            film.setDescription(dataDescription[i]);
            film.setRecipe(dataRecipe[i]);
            foods.add(film);
        }
        adapter.setFoods(foods);
    }

    private void prepare() {
        // Mengambil array dari string
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.dat_photo);
        dataRecipe = getResources().getStringArray(R.array.data_cast);
    }

}
