package com.begovsky.pozadineaplikacija.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.begovsky.pozadineaplikacija.models.Image;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "wallpapers";
    private static final String TABLE_CONTACTS = "images";
    private static final String KEY_ID = "id";
    private static final String KEY_URL = "url";
    private static final String KEY_CATEGORY = "category";

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                    + KEY_ID + " TEXT PRIMARY KEY," + KEY_URL + " TEXT,"
                    + KEY_CATEGORY + " TEXT" + ")";
            db.execSQL(CREATE_CONTACTS_TABLE);
        } catch (Exception ex) {
            Log.d("createtableerror", ex.getMessage());
        }
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    // code to add the new contact
    public void addImage(Image image) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(KEY_ID, image.getImageId()); // Contact Name
            values.put(KEY_URL, image.getImageUrl()); // Contact Name
            values.put(KEY_CATEGORY, image.getCategory()); // Contact Phone

            // Inserting Row
            db.insert(TABLE_CONTACTS, null, values);
            //2nd argument is String containing nullColumnHack
            db.close(); // Closing database connection
        } catch (Exception ex) {
            Log.d("inserttableerror", ex.getMessage());
        }
    }

    // code to get the single contact
    public Image getImage(String id) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_ID,
                            KEY_URL, KEY_CATEGORY}, KEY_ID + "=?",
                    new String[]{id}, null, null, null, null);
            if (cursor != null)
                cursor.moveToFirst();

            Image image = new Image(cursor.getString(0), cursor.getString(1), cursor.getString(2));
            // return contact
            return image;
        } catch (Exception ex) {
            Log.d("geterror", ex.getMessage());
            return null;
        }
    }

    // code to get all contacts in a list view
    public ArrayList<Image> getAllImages() {
        try {
            ArrayList<Image> contactList = new ArrayList<Image>();
            // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Image image = new Image(cursor.getString(0), cursor.getString(1), cursor.getString(2));

                    // Adding contact to list
                    contactList.add(image);
                } while (cursor.moveToNext());
            }

            // return contact list
            return contactList;
        } catch (Exception ex) {
            Log.d("getallerror", ex.getMessage());
            return null;
        }
    }

//    // code to update the single contact
//    public int updateContact(Image contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, contact.getName());
//        values.put(KEY_PH_NO, contact.getPhoneNumber());
//
//        // updating row
//        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
//                new String[]{String.valueOf(contact.getID())});
//    }

    // Deleting single contact
    public void deleteImage(Image image) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                    new String[]{String.valueOf(image.getImageId())});
            db.close();
        } catch (Exception ex) {
            Log.d("deleteerror", ex.getMessage());
        }
    }

//    // Getting contacts Count
//    public int getContactsCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();
//
//        // return count
//        return cursor.getCount();
//    }

}