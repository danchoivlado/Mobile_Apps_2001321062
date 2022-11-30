package com.example.jordanstore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.widget.Toast;
import android.database.Cursor;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private  static final String DATABASE_NAME = "CarStore.db";
    private  static final int DATABASE_VERSION = 1;

    private  static final String TABLE_NAME = "cars";
    private  static final String COLUMN_ID = "_id";
    private  static final String COLUMN_BRAND = "car_brand";
    private  static final String COLUMN_MODEL = "car_model";
    private  static final String COLUMN_POWER = "car_power";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_BRAND + " TEXT, " +
                COLUMN_MODEL + " TEXT, " +
                COLUMN_POWER + " INTEGER);";
        sqLiteDatabase.execSQL(query);
    }



    public void clearList(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    void addCar(String brand, String model, int power){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues(); //This class is used to store a set of values

        cv.put(COLUMN_BRAND, brand);
        cv.put(COLUMN_MODEL, model);
        cv.put(COLUMN_POWER, power);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show(); //A toast is a view containing a quick little message for the user.
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();//A toast is a view containing a quick little message for the user.
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
