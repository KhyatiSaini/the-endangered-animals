package com.example.theanimals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageActivity extends AppCompatActivity {

    ImageView image;
    ImageButton back, save;
    private static final int PERMISSION_CODE = 1001;
    private BitmapDrawable drawable;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        image = findViewById(R.id.imageViewFull);
        back = findViewById(R.id.imageButtonLast);
        save = findViewById(R.id.imageButtonSave);

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

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                        //permission not granted,request it
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        //show popup for runtime permission
                         requestPermissions(permissions, PERMISSION_CODE);
                    }
                    else{
                        //permission already granted
                        downloadImage();
                    }
                }
                else{
                    //system os is less than marshmallow
                    downloadImage();
                }
            }
        });
    }

    private void downloadImage(){
        drawable = (BitmapDrawable) image.getDrawable();
        bitmap = drawable.getBitmap();

        FileOutputStream fileOutputStream = null;

        // accessing the sdcard of the device
        File sdCard = Environment.getExternalStorageDirectory();
        // declaring a directory with a specific name
        File directory = new File(sdCard.getAbsolutePath() + "/Animals");
        // creating the directory
        directory.mkdir();
        // name with which the file will get saved as
        String fileName = String.format("%d.jpg", System.currentTimeMillis());
        // creating output file
        File outputFile = new File(directory, fileName);
        Toast.makeText(getApplicationContext(), "Image Saved", Toast.LENGTH_SHORT).show();

        try {
            fileOutputStream = new FileOutputStream(outputFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();

            // to show the image in gallery
            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            intent.setData(Uri.fromFile(outputFile));
            sendBroadcast(intent);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //handling result of runtime permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    //permission granted
                    downloadImage();
                }
                else{
                    //permission not granted
                    Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
