package com.xiaomi.push.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.umeng.analytics.pro.d;
import com.xiaomi.push.gz;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/providers/TrafficProvider.class */
public class TrafficProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final UriMatcher f41563a;

    /* renamed from: a  reason: collision with other field name */
    public static final Uri f901a = Uri.parse("content://com.xiaomi.push.providers.TrafficProvider/traffic");

    /* renamed from: a  reason: collision with other field name */
    private SQLiteOpenHelper f902a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f41563a = uriMatcher;
        uriMatcher.addURI("com.xiaomi.push.providers.TrafficProvider", d.F, 1);
        f41563a.addURI("com.xiaomi.push.providers.TrafficProvider", "update_imsi", 2);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (f41563a.match(uri) == 1) {
            return "vnd.android.cursor.dir/vnd.xiaomi.push.traffic";
        }
        throw new IllegalArgumentException("Unknown URI ".concat(String.valueOf(uri)));
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f902a = new a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query;
        synchronized (a.f903a) {
            if (f41563a.match(uri) != 1) {
                throw new IllegalArgumentException("Unknown URI ".concat(String.valueOf(uri)));
            }
            query = this.f902a.getReadableDatabase().query(d.F, strArr, str, strArr2, null, null, str2);
        }
        return query;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (f41563a.match(uri) == 2 && contentValues != null && contentValues.containsKey("imsi")) {
            gz.m11840a(contentValues.getAsString("imsi"));
            return 0;
        }
        return 0;
    }
}
