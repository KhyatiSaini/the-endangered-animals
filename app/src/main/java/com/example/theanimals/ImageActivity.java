package com.example.theanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    ImageView image;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        image = findViewById(R.id.imageViewFull);
        back = findViewById(R.id.imageButtonLast);

        final Intent i = getIntent();
        if(i.getExtras() != null)
        {
            int imageResource = i.getIntExtra("Image", R.drawable.javanrhino);
            image.setImageResource(imageResource);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageActivity.this.finish();
            }
        });

    }
}
