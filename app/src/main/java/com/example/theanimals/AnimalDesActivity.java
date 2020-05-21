package com.example.theanimals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AnimalDesActivity extends AppCompatActivity {

    TextView nameTextView;
    ImageView imageView, back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animaldes);

        nameTextView = findViewById(R.id.textView_nameHome);
        imageView = findViewById(R.id.imageViewHome);
        back = findViewById(R.id.ButtonBack);

        final Intent i = getIntent();
        if(i.getExtras() != null)
        {
            int urlImage = i.getIntExtra("ImageURL", R.drawable.home);
            String animalN = i.getStringExtra("AnimalName");

            nameTextView.setText(animalN);
            imageView.setImageResource(urlImage);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimalDesActivity.this.finish();
            }
        });
    }
}
