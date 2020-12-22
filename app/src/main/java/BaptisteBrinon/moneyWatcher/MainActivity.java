package BaptisteBrinon.moneyWatcher;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import BaptisteBrinon.moneyWatcher.database.DBHelper;
import BaptisteBrinon.moneyWatcher.database.ExpensesContract;

public class MainActivity extends AppCompatActivity {
    static final int ADD_EXPENSE_REQUEST = 1;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //database management
        DBHelper db_helper = new DBHelper(this);
        database = db_helper.getWritableDatabase();
        Cursor cursor = get_all_tasks();

    }

    private Cursor get_all_tasks() {
        return database.query(
                ExpensesContract.ExpensesEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    private boolean remove_expense(long id) {
        return database.delete(ExpensesContract.ExpensesEntry.TABLE_NAME, ExpensesContract.ExpensesEntry._ID + "=" + id, null) > 0;
    }

}
