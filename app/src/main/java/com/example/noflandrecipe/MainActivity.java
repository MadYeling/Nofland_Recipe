package com.example.noflandrecipe;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.noflandrecipe.nofland_recipe_core.EncodeFileName;
import com.example.noflandrecipe.nofland_recipe_core.Initialization;
import com.example.noflandrecipe.nofland_recipe_core.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.main_activity_recipe_list_view);
        EditText editText = findViewById(R.id.main_activity_item_name_edit_text);
        Button button = findViewById(R.id.main_activity_search_button);
        RecipeListAdapter adapter = new RecipeListAdapter(this, new ArrayList<>(), R.layout.recipe_list_item);
        listView.setAdapter(adapter);

        button.setOnClickListener(v -> {
            String itemName = editText.getText().toString();
            List<Recipe> recipes = Initialization.findRecipeByItem(itemName);
            if (recipes.size() == 0) {
                Toast.makeText(MainActivity.this, "没有找到匹配的配方呢QAQ，是不是打错字了？", Toast.LENGTH_LONG).show();
                listView.setAdapter(adapter);
                listView.invalidate();
                return;
            }
            RecipeListAdapter adapter1 = new RecipeListAdapter(this, recipes, R.layout.recipe_list_item);
            listView.setAdapter(adapter1);
            listView.invalidate();
        });
    }
}