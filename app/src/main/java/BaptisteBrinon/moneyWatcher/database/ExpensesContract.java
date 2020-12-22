package BaptisteBrinon.moneyWatcher.database;

import android.provider.BaseColumns;

public class ExpensesContract {

    public static final class ExpensesEntry implements BaseColumns{
        public static final String TABLE_NAME = "expenses";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_CATEGORY = "category";
    }

}
