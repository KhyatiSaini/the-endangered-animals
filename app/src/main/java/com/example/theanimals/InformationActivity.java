package com.example.theanimals;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InformationActivity extends AppCompatActivity {

    TextView animalName, description;
    ImageView animalImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        animalName = findViewById(R.id.textViewName);
        description = findViewById(R.id.textViewBody);
        animalImageView = findViewById(R.id.imageViewAnimal);

        final Intent i = getIntent();
        if(i.getExtras() != null)
        {
            int ImageUrl = i.getIntExtra("ImageURL", R.drawable.home);
            String name = i.getStringExtra("AnimalName");
            String des = i.getStringExtra("AnimalInfo");

            animalName.setText(name);
            description.setText(des);
            animalImageView.setImageResource(ImageUrl);
        }
    }
}
