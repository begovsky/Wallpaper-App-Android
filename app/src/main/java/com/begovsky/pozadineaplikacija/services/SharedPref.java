package com.begovsky.pozadineaplikacija.services;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPref {

    Activity context;
    SharedPreferences prefs;

    public SharedPref(Activity context) {
        this.context = context;
        prefs = PreferenceManager.getDefaultSharedPreferences(this.context);
    }

    public String getImageQuality() {
        return prefs.getString("pref_imagequality", "");
    }

    public String getFirstCategory() {
        return prefs.getString("pref_showimagesonstart", "");
    }

    public String getFirstCategoryTitle() {
        String cat = prefs.getString("pref_showimagesonstart", "");

        switch (cat) {
            case "animals":
                return "Animals";
            case "nature":
                return "Nature";
            case "love":
                return "Love";
            case "car":
                return "Car";
            case "adventure":
                return "Adventure";
            case "food":
                return "Food";
            case "child":
                return "Child";
            case "people":
                return "People";
            default:
                return "";
        }
    }

}

