package com.example.theanimals;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView nameTextView, infoTextView, statusTextView, otherTextView;
    ImageView imageView, back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        nameTextView = findViewById(R.id.textView_nameHome);
        infoTextView = findViewById(R.id.textViewInfo);
        statusTextView = findViewById(R.id.textViewStatus);
        otherTextView = findViewById(R.id.textViewWhyTheyMatter);
        imageView = findViewById(R.id.imageViewHome);
        back = findViewById(R.id.ButtonBack);

        final Intent i = getIntent();
        if(i.getExtras() != null)
        {
            int urlImage = i.getIntExtra("ImageURL", R.drawable.home);
            String animalN = i.getStringExtra("AnimalName");
            String animal_info = i.getStringExtra("AnimalInfo");
            String status = i.getStringExtra("AnimalStatus");
            String other = i.getStringExtra("AnimalOtherInfo");

            nameTextView.setText(animalN);
            imageView.setImageResource(urlImage);
            infoTextView.setText(animal_info);
            otherTextView.setText(other);
            statusTextView.setText(status);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoActivity.this.finish();
            }
        });
    }

}
