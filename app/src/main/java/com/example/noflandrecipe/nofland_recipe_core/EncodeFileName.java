package com.example.noflandrecipe.nofland_recipe_core;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public class EncodeFileName {
    public static String encode(String name) {
        try {
            return URLEncoder.encode(name, "UTF-8").replace("%", "g").toLowerCase(Locale.ROOT);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

