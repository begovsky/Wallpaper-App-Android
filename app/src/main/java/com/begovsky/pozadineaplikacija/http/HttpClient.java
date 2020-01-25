package com.begovsky.pozadineaplikacija.http;

import android.os.AsyncTask;
import android.util.Log;

import com.begovsky.pozadineaplikacija.MainActivity;
import com.begovsky.pozadineaplikacija.models.Image;
import com.begovsky.pozadineaplikacija.models.ImageJsonObject;
import com.begovsky.pozadineaplikacija.services.SharedPref;
import com.google.gson.Gson;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpClient extends AsyncTask<String, Integer, ArrayList<Image>> {

    MainActivity context;
    SharedPref sharedPref;
    private String access_key = ""; // Unsplash access and secret key from api.unsplash.com
    private String secret_key = "";

    OkHttpClient client = new OkHttpClient();

    public HttpClient(MainActivity context) {
        this.context = context;
        sharedPref = new SharedPref(this.context);
    }

    @Override
    protected ArrayList<Image> doInBackground(String... strings) {
        try {
            Request request = new Request.Builder()
                    .url("https://api.unsplash.com/search/photos/?client_id=" + access_key + "&per_page=200" + "&query=" + strings[0] + "&page =" + strings[1])
                    .build();

            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            String json = response.body().string();
            ImageJsonObject jsonObject = gson.fromJson(json, ImageJsonObject.class);

            ArrayList<Image> imageList = new ArrayList<Image>();
            for (ImageJsonObject.Result result : jsonObject.getResults()) {
                String imageId = result.getId();
                String imageUrl = getImageByQuality(result.getUrls());
                imageList.add(new Image(imageId, imageUrl, strings[2]));
            }

            //

            return imageList;

        } catch (Exception ex) {
            Log.d("ex", ex.getMessage());
            return null;
        }
    }

    protected void onPostExecute(final ArrayList<Image> imageList) {
        try {
            if (imageList != null) {

                this.context.runOnUiThread(new Runnable() {
                    public void run() {
                        context.changeAdapterData(imageList);

//                        if (context.pageCount == 1)
//                            context.changeAdapterData(imageList);
//                        else
//                            context.appendAdapterData(imageList);
                    }
                });
            }

        } catch (Exception ex) {

        }
    }

    private String getImageByQuality(ImageJsonObject.Urls urls) {
        String imageQ = sharedPref.getImageQuality();

        switch (imageQ) {
            case "low":
                return urls.getSmall();
            case "high":
                return urls.getFull();
            default:
                return urls.getRegular();
        }
    }

}
