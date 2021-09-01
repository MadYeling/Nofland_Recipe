package com.example.noflandrecipe;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.noflandrecipe.nofland_recipe_core.EncodeFileName;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.image1);
        String file = EncodeFileName.encode("不老冰").replace("%", "g").toLowerCase(Locale.ROOT);
        imageView.setImageResource(getResources().getIdentifier(file, "drawable", getPackageName()));
    }
}