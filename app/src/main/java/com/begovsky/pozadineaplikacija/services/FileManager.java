package com.begovsky.pozadineaplikacija.services;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;

import androidx.core.content.FileProvider;

import com.begovsky.pozadineaplikacija.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {
    File path;
    Context context;

    public FileManager(Context context) {
        this.context = context;
        path = new File(context.getFilesDir(), this.context.getString(R.string.app_name) + File.separator + "Images");
        if (!path.exists()) {
            path.mkdirs();
        }
    }

    public String getImagePath(String imageId) {
        return path + "/" + imageId + ".jpeg";
    }


    private void saveImage(Bitmap bm, String imageName) {
        try {

            Bitmap bitmap = bm;

            File outFile = new File(path, imageName + ".jpeg");
            FileOutputStream outputStream = new FileOutputStream(outFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.close();

        } catch (FileNotFoundException e) {
            Log.e("error458923", "Saving received message failed with", e);
        } catch (IOException e) {
            Log.e("eror13213", "Saving received message failed with", e);
        }
    }

    public void shareImage(Bitmap bm, String imageId) {

        try {
            saveImage(bm, imageId);

            Intent share = new Intent(Intent.ACTION_SEND);

            // If you want to share a png image only, you can do:
            // setType("image/png"); OR for jpeg: setType("image/jpeg");
            share.setType("image/*");

            // Make sure you put example png image named myImage.png in your
            // directory

            File imageFile = new File(getImagePath(imageId));

            Uri uri = FileProvider.getUriForFile(
                    this.context,
                    "com.begovsky.pozadineaplikacija.provider", //(use your app signature + ".provider" )
                    imageFile);

            share.putExtra(Intent.EXTRA_STREAM, uri);

            this.context.startActivity(Intent.createChooser(share, "Share Image!"));

        } catch (Exception ex) {
            Log.e("eror1322312313", ex.getMessage());
        }

    }


}
