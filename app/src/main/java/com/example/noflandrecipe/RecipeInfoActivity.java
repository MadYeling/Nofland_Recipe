package com.example.noflandrecipe;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.noflandrecipe.nofland_recipe_core.EncodeFileName;
import com.example.noflandrecipe.nofland_recipe_core.model.Recipe;

import java.util.List;

public class RecipeInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info);
        Recipe recipe = (Recipe) getIntent().getSerializableExtra("recipe");
        ImageView imageView = findViewById(R.id.activity_recipe_info_recipe_pic_image_view);
        TextView textView = findViewById(R.id.activity_recipe_info_recipe_name_text_view);
        ListView listView = findViewById(R.id.activity_recipe_info_recipe_item_list_view);
        imageView.setImageResource(getResources().getIdentifier(EncodeFileName.encode(recipe.getName()), "drawable", getPackageName()));
        textView.setText(recipe.getName());

        RecipeInfoListAdapter adapter = new RecipeInfoListAdapter(this, recipe.getRecipeItem(), R.layout.recipe_info_list_item);
        listView.setAdapter(adapter);
    }
}