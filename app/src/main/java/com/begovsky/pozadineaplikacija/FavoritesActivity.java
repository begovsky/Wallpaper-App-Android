package com.begovsky.pozadineaplikacija;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.begovsky.pozadineaplikacija.adapters.ImageAdapter;
import com.begovsky.pozadineaplikacija.models.Image;
import com.begovsky.pozadineaplikacija.services.DatabaseManager;
import com.begovsky.pozadineaplikacija.services.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    RecyclerView rvImages;
    EndlessRecyclerViewScrollListener scrollListener;
    StaggeredGridLayoutManager sGridLayoutManager;
    GridLayoutManager gridLayoutManager;

    Toolbar toolbar;
    ImageAdapter adapter;

    DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        initalizeComponents();
        initToolbar();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            ArrayList<Image> listaSlika = dbManager.getAllImages();
            if (listaSlika != null)
                adapter.insertAll(new ArrayList<>(listaSlika));

            dbManager.close();

        } catch (Exception ex) {
            Log.d("errorloading", ex.getMessage());
        }
    }

    private void initalizeComponents() {
        rvImages = findViewById(R.id.rvImages);
        toolbar = findViewById(R.id.toolbar);

        dbManager = new DatabaseManager(this);

        gridLayoutManager = new GridLayoutManager(this, 2);

        rvImages.setLayoutManager(gridLayoutManager);
        adapter = new ImageAdapter(this);

        rvImages.setAdapter(adapter);

        scrollListener = new EndlessRecyclerViewScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

            }
        };
        rvImages.addOnScrollListener(scrollListener);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Favorite Wallpapers");
    }
}
