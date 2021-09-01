package com.example.noflandrecipe;

import android.content.Intent;
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
    private List<Recipe> recipes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.main_activity_recipe_list_view);
        SearchView searchView = findViewById(R.id.main_activity_item_name_search_view);
        RecipeListAdapter adapter = new RecipeListAdapter(this, recipes, R.layout.recipe_list_item);
        listView.setAdapter(adapter);
        searchView.setSubmitButtonEnabled(true);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                recipes.clear();
                recipes.addAll(Initialization.findRecipeByItem(query));
                if (recipes.size() == 0) {
                    Toast.makeText(MainActivity.this, "没有找到匹配的配方呢QAQ，是不是打错字了？", Toast.LENGTH_LONG).show();
                    adapter.notifyDataSetChanged();
                    return false;
                }
                adapter.notifyDataSetChanged();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

//        editText.setOnClickListener(v -> MainActivity.this.startActivity(new Intent(MainActivity.this, DarkSearchActivity.class)));
//        editText.setOnLongClickListener(v -> {
//            MainActivity.this.startActivity(new Intent(MainActivity.this, DarkSearchActivity.class));
//            return true;
//        });

//        button.setOnClickListener(v -> {
//            recipes.clear();
//            String itemName = editText.getText().toString();
//            recipes.addAll(Initialization.findRecipeByItem(itemName));
//            if (recipes.size() == 0) {
//                Toast.makeText(MainActivity.this, "没有找到匹配的配方呢QAQ，是不是打错字了？", Toast.LENGTH_LONG).show();
//                adapter.notifyDataSetChanged();
//                return;
//            }
//            adapter.notifyDataSetChanged();
//        });
    }
}