package com.begovsky.pozadineaplikacija;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.begovsky.pozadineaplikacija.models.Image;
import com.begovsky.pozadineaplikacija.services.DatabaseManager;
import com.begovsky.pozadineaplikacija.services.FileManager;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class WallpaperActivity extends AppCompatActivity {


    ImageView image;
    Button btnSave;
    Toolbar toolbar;

    DatabaseManager dbManager;
    Gson gson;

    Boolean isFavorite = false;
    Image imageData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        btnSave = findViewById(R.id.btnSave);

        initToolbar();

        image = findViewById(R.id.wallpaperImage);
        gson = new Gson();

        getData(savedInstanceState);

    }

    public void btnSetWallpaperEvent(View view) {

        try {

            if (imageData == null) return;

            image.buildDrawingCache();
            Bitmap bitmap = image.getDrawingCache();
            WallpaperManager manager = WallpaperManager.getInstance(this);
            try {
                manager.setBitmap(bitmap);
                Toast.makeText(this, "Wallpaper is updated!", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception ex) {
            Log.d("wallpapererror", ex.getMessage());
        }

    }

    public void btnSaveEvent(View view) {
        try {
            if (isFavorite) {
                dbManager.deleteImage(imageData);
                Toast.makeText(this, "Deleted!", Toast.LENGTH_LONG).show();
                isFavorite = false;
                dbManager.close();
            } else {
                dbManager.addImage(imageData);
                Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
                isFavorite = true;
                dbManager.close();
            }

            buttonToggle();

        } catch (Exception ex) {
            Log.d("saveerror", ex.getMessage());
        }

    }

    public void btnShareEvent(View view) {
        try {

            image.buildDrawingCache();
            Bitmap bitmap = image.getDrawingCache();

            FileManager fileManager = new FileManager(this);
            fileManager.shareImage(bitmap, imageData.getImageId());


        } catch (Exception ex) {
            Log.d("shareerror", ex.getMessage());
        }
    }


    private void getData(Bundle savedInstanceState) {

        try {
            if (savedInstanceState == null) {
                Bundle extras = getIntent().getExtras();
                if (extras == null) {
                    imageData = null;
                } else {
                    Image jsonObject = gson.fromJson(extras.getString("imageData"), Image.class);
                    if (jsonObject != null)
                        imageData = new Image(jsonObject.getImageId(), jsonObject.getImageUrl(), jsonObject.getCategory());
                    else
                        imageData = null;
                }
            } else {
                String json = (String) savedInstanceState.getSerializable("imageData");
                Image jsonObject = gson.fromJson(json, Image.class);
                if (jsonObject != null)
                    imageData = jsonObject;
                else
                    imageData = null;
            }

            if (imageData != null) {
                Picasso.get().load(imageData.getImageUrl()).into(image);
                toolbar.setTitle(imageData.getCategory());
                dbManager = new DatabaseManager(this);
                Image image = dbManager.getImage(imageData.getImageId());

                if (image != null) {
                    isFavorite = true;
                    buttonToggle();
                }
            }

        } catch (Exception ex) {
            Log.d("xczxc", ex.getMessage());
        }
    }

    private void buttonToggle() {
        if (isFavorite) {
            btnSave.setBackgroundColor(getResources().getColor(R.color.red));
            btnSave.setText("Saved");
        } else {
            btnSave.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btnSave.setText("Save");
        }
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
