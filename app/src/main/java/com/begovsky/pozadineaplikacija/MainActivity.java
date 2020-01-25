package com.begovsky.pozadineaplikacija;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.begovsky.pozadineaplikacija.adapters.ImageAdapter;
import com.begovsky.pozadineaplikacija.http.HttpClient;
import com.begovsky.pozadineaplikacija.models.Image;
import com.begovsky.pozadineaplikacija.services.DatabaseManager;
import com.begovsky.pozadineaplikacija.services.EndlessRecyclerViewScrollListener;
import com.begovsky.pozadineaplikacija.services.SharedPref;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView rvImages;
    EndlessRecyclerViewScrollListener scrollListener;
    StaggeredGridLayoutManager sGridLayoutManager;
    GridLayoutManager gridLayoutManager;
    HttpClient httpClient;
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ImageAdapter adapter;

    public Integer pageCount = 1;

    DatabaseManager dbManager;
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initalizeComponents();

            setFirstCategoryImages();


        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void setFirstCategoryImages() {
        String firstCategory = sharedPref.getFirstCategory();

        if (!firstCategory.isEmpty()) {
            httpClient.execute(firstCategory, String.valueOf(pageCount), sharedPref.getFirstCategoryTitle());
            int id;

            switch (firstCategory) {
                case "nature":
                    id = R.id.nature;
                    break;
                case "love":
                    id = R.id.love;
                    break;
                case "car":
                    id = R.id.car;
                    break;
                case "adventure":
                    id = R.id.adventure;
                    break;
                case "food":
                    id = R.id.food;
                    break;
                case "child":
                    id = R.id.child;
                    break;
                case "people":
                    id = R.id.people;
                    break;
                default:
                    id = R.id.animals;
                    break;
            }
            navigationView.setCheckedItem(id);
            toolbar.setTitle(sharedPref.getFirstCategoryTitle());
        } else {
            httpClient.execute("animals", String.valueOf(pageCount), "Animals");
            navigationView.setCheckedItem(R.id.animals);
            toolbar.setTitle("Animals");
        }
    }

    private void initalizeComponents() {
        rvImages = findViewById(R.id.rvImages);
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);


        initDrawerMenu();

        httpClient = new HttpClient(this);
        dbManager = new DatabaseManager(this);
        sharedPref = new SharedPref(this);

        //sGridLayoutManager = new StaggeredGridLayoutManager(2,
        //        StaggeredGridLayoutManager.VERTICAL);

        gridLayoutManager = new GridLayoutManager(this, 2);

        rvImages.setLayoutManager(gridLayoutManager);
        adapter = new ImageAdapter(this);

        rvImages.setAdapter(adapter);

        scrollListener = new EndlessRecyclerViewScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                loadNextDataFromApi();
            }
        };
        rvImages.addOnScrollListener(scrollListener);
    }

    private void initDrawerMenu() {
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        try {
            httpClient = new HttpClient(this);
            String category = getResources().getResourceEntryName(item.getItemId());

            if (navigationView.getCheckedItem() != item)
                pageCount = 1;

            String title = (String) item.getTitle();
            httpClient.execute(category, String.valueOf(pageCount), title);
            navigationView.setCheckedItem(item);
            toolbar.setTitle(title);
            drawer.closeDrawers();

        } catch (Exception ex) {
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item != null) {
            switch (item.getItemId()) {
                case R.id.menu_favorites:
                    Intent intent = new Intent(this, FavoritesActivity.class);
                    startActivity(intent);
                    break;

                case R.id.menu_settings:
                    Intent i = new Intent(this, PrefsActivity.class);
                    startActivity(i);
                    break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeAdapterData(ArrayList<Image> imageList) {
        adapter.insertAll(imageList);
        rvImages.scrollToPosition(0);
        scrollListener.resetState();
    }

    public void appendAdapterData(ArrayList<Image> imageList) {
        adapter.appendAll(imageList);
    }

    public void loadNextDataFromApi() {

//        try {
//            httpClient = new HttpClient(this);
//
//            pageCount ++ ;
//
//            String category = getResources().getResourceEntryName(navigationView.getCheckedItem().getItemId());
//
//            httpClient.execute(category,String.valueOf(pageCount));
//
//        }catch (Exception ex){
//
//        }

    }
}
