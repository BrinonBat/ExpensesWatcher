package BaptisteBrinon.moneyWatcher;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import BaptisteBrinon.moneyWatcher.database.ExpenseDBHelper;
import BaptisteBrinon.moneyWatcher.database.ExpensesContract;

public class MainActivity extends AppCompatActivity {
    static final int ADD_EXPENSE_REQUEST = 1;
    private SQLiteDatabase expenses_db;
    private SQLiteDatabase categories_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //expenses database
        ExpenseDBHelper db_helper = new ExpenseDBHelper(this);
        expenses_db = db_helper.getWritableDatabase();
        Cursor cursor = get_all_expenses();

    }

    private Cursor get_all_expenses() {
        return expenses_db.query(
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
        return expenses_db.delete(ExpensesContract.ExpensesEntry.TABLE_NAME, ExpensesContract.ExpensesEntry._ID + "=" + id, null) > 0;
    }

}
