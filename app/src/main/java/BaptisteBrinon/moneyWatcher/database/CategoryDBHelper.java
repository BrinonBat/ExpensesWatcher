package BaptisteBrinon.moneyWatcher.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CategoryDBHelper extends SQLiteOpenHelper {
    //database informations
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "categories.db";
    public static final String TABLE_NAME = "categories";
    //table
    public static final String COLUMN_NAME = "name";

    public CategoryDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //table holding data
        final String SQL_CREATE_TABLE ="CREATE TABLE " + TABLE_NAME +
                " ("+ COLUMN_NAME + " FLOAT PRIMARY KEY" + " ); ";
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //drop the table and create a new one when the version is changed
        // will be modified to "ALTER TABLE" in the future
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertName(String name){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    public List<String> getAllNames(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> list = new ArrayList<String>();

        //get datas
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
              list.add(cursor.getString(0)); // adding 1st column data (name)
            } while (cursor.moveToNext());
        }

        //return the result
        cursor.close();
        db.close();
        return list;
    }

    public void remove_category(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + " = " + name);
        //db.delete(TABLE_NAME, COLUMN_NAME+ "=" + name, null);


        boolean ok = db.delete(TABLE_NAME, COLUMN_NAME+ "=" + name, null) > 0;
        db.close();
        //return ok; // so I can handle some errors


    }

}