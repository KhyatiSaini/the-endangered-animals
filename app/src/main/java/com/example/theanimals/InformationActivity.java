package com.example.theanimals;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InformationActivity extends AppCompatActivity {

    TextView animalName, description;
    ImageView animalImageView, backButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        animalName = findViewById(R.id.textViewName);
        description = findViewById(R.id.textViewBody);
        animalImageView = findViewById(R.id.imageViewAnimal);
        backButton = findViewById(R.id.imageButtonBack);

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

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InformationActivity.this.finish();
            }
        });

        animalImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationActivity.this, ImageActivity.class);
                intent.putExtra("Image", i.getIntExtra("ImageURL", R.drawable.home));
                Log.e("InformationActivity", "selected Image: " + i.getStringExtra("AnimalName"));
                startActivity(intent);
            }
        });
    }
}
