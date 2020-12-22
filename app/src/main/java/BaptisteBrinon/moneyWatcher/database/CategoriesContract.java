package BaptisteBrinon.moneyWatcher.database;

import android.provider.BaseColumns;

public class CategoriesContract implements BaseColumns {

    public static final class CategoriesEntry implements BaseColumns{
        public static final String TABLE_NAME = "categories";
        public static final String COLUMN_NAME = "name";
    }
}
