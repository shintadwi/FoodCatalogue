package com.shinta.foodcatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DetailFoodActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    TextView txtName,txtDescription;
    ImageView imageView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        txtName =  findViewById(R.id.txt_name);
        txtDescription = findViewById(R.id.txt_description);
        imageView = findViewById(R.id.img_photo);

        Food food = getIntent().getParcelableExtra(EXTRA_PERSON);

        txtName.setText(food.getName());
        txtDescription.setText(food.getDescription());
        imageView.setImageResource(food.getPhoto());

        listView = findViewById(R.id.lv_list_food);
        final String[] items = new String[]{food.getRecipe()};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.layout_recipe,R.id.text_food_list, items);
        listView.setAdapter(adapter);
    }
}
