package com.example.theanimals;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class InformationActivity extends AppCompatActivity {

    TextView animalName, description;
    ImageView animalImageView;
    ImageButton backButton, speak;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        animalName = findViewById(R.id.textViewName);
        description = findViewById(R.id.textViewBody);
        animalImageView = findViewById(R.id.imageViewAnimal);
        backButton = findViewById(R.id.imageButtonBack);
        speak = findViewById(R.id.imageButtonSpeech);

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

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS)
                {
                    int result = textToSpeech.setLanguage(Locale.US);

                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                    {
                        Log.e("TTS", "onInit: " + "Language not supported");
                    }
                    else
                    {
                        speak.setEnabled(true);
                    }
                }
                else
                {
                    Log.e("TTS", "onInit: " + "Initialization failed");
                }
            }
        });

        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakText();
            }
        });
    }

    private void speakText() {
        String text = description.getText().toString();
        float speed = 1f;
        float pitch = 1f;
        textToSpeech.setSpeechRate(speed);
        textToSpeech.setPitch(pitch);

        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onDestroy() {
        if(textToSpeech != null)
            textToSpeech.stop();
            textToSpeech.shutdown();

        super.onDestroy();
    }
}
