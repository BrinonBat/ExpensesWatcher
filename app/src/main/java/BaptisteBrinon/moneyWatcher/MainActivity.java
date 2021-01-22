package BaptisteBrinon.moneyWatcher;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import BaptisteBrinon.moneyWatcher.database.CategoryDBHelper;
import BaptisteBrinon.moneyWatcher.database.ExpenseDBHelper;
import BaptisteBrinon.moneyWatcher.database.ExpensesContract;

public class MainActivity extends AppCompatActivity {
    //static final int ADD_EXPENSE_REQUEST = 1;
    static final int MANAGE_CATEGORIES_REQUEST = 2;
    private Spinner spin_categories;
    private Button btn_Ok;
    private EditText amount_entry;
    //private SQLiteDatabase expenses_db;
    //private SQLiteDatabase categories_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*****categories database*****/
        spin_categories = (Spinner) findViewById(R.id.categories);
        //get datas
        CategoryDBHelper cdb_helper = new CategoryDBHelper(this);
        List<String> labels = cdb_helper.getAllNames();
        //set adapters
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.spinner_cat_item, labels);
        dataAdapter.setDropDownViewResource(R.layout.spinner_cat_dropdownitem);
        spin_categories.setAdapter(dataAdapter);

        cdb_helper.insertName("test5");
        cdb_helper.insertName("test2");
        cdb_helper.insertName("test4");
        dataAdapter.notifyDataSetChanged();
        //cdb_helper.remove_category("test2"); <==== BUG A REGLER
        //https://www.javatpoint.com/android-sqlite-example-with-spinner

        /*****expenses database*****/
        //ExpenseDBHelper edb_helper = new ExpenseDBHelper(this);
        //expenses_db = edb_helper.getWritableDatabase();
        //Cursor expenses_curs = get_all_expenses();


        btn_Ok = (Button) findViewById(R.id.Ok);
        /*btn_Ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String label = amount_entry.getText().toString();

                if (label.trim().length() > 0) {
                    ExpenseDBHelper db = new CategoryDBHelper(getApplicationContext());
                    db.insertName(label);

                    // making input filed text to blank
                    inputLabel.setText("");

                    // Hiding the keyboard
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(inputLabel.getWindowToken(), 0);
                    // loading spinner with newly added data
                    loadSpinnerData();
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter label name",
                            Toast.LENGTH_SHORT).show();
                }

            }
         */

        }



/*
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
*/
}
