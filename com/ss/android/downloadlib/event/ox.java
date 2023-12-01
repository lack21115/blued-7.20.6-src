package com.ss.android.downloadlib.event;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.exception.b;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/event/ox.class */
public class ox {
    private static volatile ox ox;
    private SQLiteDatabase mb;

    private ox() {
        try {
            this.mb = new mb(x.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            b.mb().mb(th, "ClickEventHelper");
        }
    }

    private void b(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.mb;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.mb.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ox mb() {
        if (ox == null) {
            synchronized (ox.class) {
                try {
                    if (ox == null) {
                        ox = new ox();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return ox;
    }

    public boolean b() {
        boolean z = false;
        if (DownloadSetting.obtainGlobal().optInt("click_event_switch", 0) == 2) {
            z = true;
        }
        return z;
    }

    public void mb(long j, String str) {
        String optString;
        SQLiteDatabase sQLiteDatabase = this.mb;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            optString = new JSONObject(str).optString("req_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad_id", Long.valueOf(j));
        contentValues.put("req_id", optString);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        this.mb.insert("click_event", null, contentValues);
        b(j, str);
    }

    public boolean ox() {
        boolean z = false;
        if (DownloadSetting.obtainGlobal().optInt("click_event_switch", 0) == 1) {
            z = true;
        }
        return z;
    }

    public boolean ox(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.mb;
        boolean z = false;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                String optString = new JSONObject(str).optString("req_id");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                Cursor query = this.mb.query("click_event", mb.mb, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString}, null, null, null, null);
                cursor = query;
                cursor2 = query;
                if (query.getCount() > 0) {
                    z = true;
                }
                if (query != null) {
                    query.close();
                }
                return z;
            } catch (Exception e) {
                cursor = cursor2;
                e.printStackTrace();
                if (cursor2 != null) {
                    cursor2.close();
                    return false;
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
