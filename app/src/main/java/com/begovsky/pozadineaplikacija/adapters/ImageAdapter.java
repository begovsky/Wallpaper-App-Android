package com.begovsky.pozadineaplikacija.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.begovsky.pozadineaplikacija.R;
import com.begovsky.pozadineaplikacija.WallpaperActivity;
import com.begovsky.pozadineaplikacija.models.Image;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends
        RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private ArrayList<Image> ImageList = new ArrayList<Image>();
    Activity context;

    public ImageAdapter(Activity context) {
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.image_ticket, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(this.context, view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Image image = ImageList.get(position);
        viewHolder.setImageData(image);
        Picasso.get().load(image.getImageUrl()).into(viewHolder.image);
    }


    @Override
    public int getItemCount() {
        return ImageList.size();
    }

    public void insertAll(ArrayList<Image> imageList) {
        this.ImageList.clear();
        this.ImageList = imageList;
        notifyDataSetChanged();
    }

    public void appendAll(ArrayList<Image> imageList) {
        int size = this.ImageList.size();
        this.ImageList.addAll(imageList);
        notifyItemInserted(size - 1);
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public ImageView image;
        private Image imageData;
        Activity context;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(Activity context, View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            this.context = context;

            image = itemView.findViewById(R.id.image);

            image.setOnClickListener(this);
        }

        public void setImageData(Image imageData) {
            this.imageData = imageData;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(this.context, WallpaperActivity.class);
            Gson gson = new Gson();
            String json = gson.toJson(this.imageData);
            intent.putExtra("imageData", json);
            this.context.startActivity(intent);
        }
    }
}
