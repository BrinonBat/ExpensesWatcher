package BaptisteBrinon.moneyWatcher;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import BaptisteBrinon.moneyWatcher.database.CategoryDBHelper;
import BaptisteBrinon.moneyWatcher.database.ExpenseDBHelper;
import BaptisteBrinon.moneyWatcher.database.ExpensesContract;

public class MainActivity extends AppCompatActivity {
    //static final int ADD_EXPENSE_REQUEST = 1;
    static final int MANAGE_CATEGORIES_REQUEST = 2;
    private Spinner spin_categories;
    private SQLiteDatabase expenses_db;
    private SQLiteDatabase categories_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin_categories = findViewById(R.id.categories);
        /*****categories database*****/
        CategoryDBHelper cdb_helper = new CategoryDBHelper(this);
        List<String> labels = cdb_helper.getAllNames();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spin_categories.setAdapter(dataAdapter);

        //https://www.javatpoint.com/android-sqlite-example-with-spinner
        /* cours
        categories_db = cdb_helper.getWritableDatabase();
        Cursor categories_curs = get_all_categories();
        */

        /*****expenses database*****/
        ExpenseDBHelper edb_helper = new ExpenseDBHelper(this);
        expenses_db = edb_helper.getWritableDatabase();
        Cursor expenses_curs = get_all_expenses();

        //Spinner management
        spin_categories = (Spinner) findViewById(R.id.categories);
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
