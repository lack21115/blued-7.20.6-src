package android.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/provider/UserDictionary.class */
public class UserDictionary {
    public static final String AUTHORITY = "user_dictionary";
    public static final Uri CONTENT_URI = Uri.parse("content://user_dictionary");
    private static final int FREQUENCY_MAX = 255;
    private static final int FREQUENCY_MIN = 0;

    /* loaded from: source-9557208-dex2jar.jar:android/provider/UserDictionary$Words.class */
    public static class Words implements BaseColumns {
        public static final String APP_ID = "appid";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.userword";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.userword";
        public static final Uri CONTENT_URI = Uri.parse("content://user_dictionary/words");
        public static final String DEFAULT_SORT_ORDER = "frequency DESC";
        public static final String FREQUENCY = "frequency";
        public static final String LOCALE = "locale";
        @Deprecated
        public static final int LOCALE_TYPE_ALL = 0;
        @Deprecated
        public static final int LOCALE_TYPE_CURRENT = 1;
        public static final String SHORTCUT = "shortcut";
        public static final String WORD = "word";
        public static final String _ID = "_id";

        @Deprecated
        public static void addWord(Context context, String str, int i, int i2) {
            if (i2 == 0 || i2 == 1) {
                addWord(context, str, i, null, i2 == 1 ? Locale.getDefault() : null);
            }
        }

        public static void addWord(Context context, String str, int i, String str2, Locale locale) {
            ContentResolver contentResolver = context.getContentResolver();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i2 = i;
            if (i < 0) {
                i2 = 0;
            }
            int i3 = i2;
            if (i2 > 255) {
                i3 = 255;
            }
            ContentValues contentValues = new ContentValues(5);
            contentValues.put(WORD, str);
            contentValues.put("frequency", Integer.valueOf(i3));
            contentValues.put(LOCALE, locale == null ? null : locale.toString());
            contentValues.put("appid", (Integer) 0);
            contentValues.put("shortcut", str2);
            contentResolver.insert(CONTENT_URI, contentValues);
        }
    }
}
