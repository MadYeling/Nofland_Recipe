package com.example.noflandrecipe;

import android.content.SearchRecentSuggestionsProvider;

public class MySearchRecentSuggestionsProvider extends SearchRecentSuggestionsProvider {
    public final static String AUTHORITY = "com.example.noflandrecipe.MySearchRecentSuggestionsProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public MySearchRecentSuggestionsProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}
