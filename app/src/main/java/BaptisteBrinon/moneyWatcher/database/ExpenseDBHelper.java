package BaptisteBrinon.moneyWatcher.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ExpenseDBHelper extends SQLiteOpenHelper {
    //database infos
    private static final String DATABASE_NAME = "expenses.db";
    private static final int DATABASE_VERSION = 1;

    public ExpenseDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //table holding data
        final String SQL_CREATE_WAITLIST_TABLE ="CREATE TABLE " +
                ExpensesContract.ExpensesEntry.TABLE_NAME + " ("+
                ExpensesContract.ExpensesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ExpensesContract.ExpensesEntry.COLUMN_AMOUNT + " FLOAT NOT NULL, " +
               ExpensesContract.ExpensesEntry.COLUMN_CATEGORY + " STRING NOT NULL " +
                "); ";
        System.out.println(SQL_CREATE_WAITLIST_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //drop the table and create a new one when the version is changed
        // will be modified to "ALTER TABLE" in the future
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ExpensesContract.ExpensesEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}

