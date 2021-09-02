package com.example.noflandrecipe;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.noflandrecipe.nofland_recipe_core.Initialization;
import com.example.noflandrecipe.nofland_recipe_core.model.Item;
import com.example.noflandrecipe.nofland_recipe_core.model.Recipe;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<Recipe> recipes = new ArrayList<>();
    private SearchView searchView;
    private Toolbar toolbar;
    private ListView listView;
    private RecipeListAdapter recipeListAdapter;
    private ImageView welcomeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recipeListAdapter = new RecipeListAdapter(this, recipes, findViewById(R.id.welcome), R.layout.recipe_list_item);
        listView = findViewById(R.id.main_activity_recipe_list_view);
        listView.setAdapter(recipeListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        //找到searchView
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) searchItem.getActionView();
        initSearchView();
        return super.onCreateOptionsMenu(menu);
    }

    private void initSearchView() {
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("输入物品名称");
        int id = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView = searchView.findViewById(id);
        textView.setTextColor(MainActivity.this.getResources().getColor(R.color.white, null));
        textView.setHintTextColor(MainActivity.this.getResources().getColor(R.color.white_0, null));

        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        SearchSuggestionAdapter searchSuggestionAdapter = new SearchSuggestionAdapter(this, null, 0);
        System.out.println("此处绑定了Adapter");
        searchView.setSuggestionsAdapter(searchSuggestionAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                recipes.clear();
                recipes.addAll(Initialization.findRecipeByItem(query));
                if (recipes.size() == 0) {
                    Toast.makeText(MainActivity.this, "没有找到匹配的配方呢QAQ，是不是打错字了？", Toast.LENGTH_LONG).show();
                }
                recipeListAdapter.notifyDataSetChanged();
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recipes.clear();
                recipes.addAll(Initialization.findRecipeByItem(newText));
                recipeListAdapter.notifyDataSetChanged();
                List<Item> items = Initialization.DarkSearchItemsByName(newText);
                Cursor cursor = getSuggestions(items, newText);
                searchSuggestionAdapter.swapCursor(cursor);
                searchSuggestionAdapter.setSuggestionList(items);
                return false;
            }
        });

        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionSelect(int position) {
                return false;
            }

            @Override
            public boolean onSuggestionClick(int position) {
                searchView.setQuery(searchSuggestionAdapter.getSuggestionText(position), true);
                return true;
            }
        });
    }

    public Cursor getSuggestions(List<Item> items, String nextText) {
        if ((items.size() == 1) && items.get(0).getName().equals(nextText))
            return null;
        MatrixCursor cursor = new MatrixCursor(new String[]{"_id", "DarkSearch"});
        for (int i = 0; i < items.size(); i++) {
            cursor.addRow(new String[]{i + "", items.get(i).getName()});
        }
        return cursor;
    }
}