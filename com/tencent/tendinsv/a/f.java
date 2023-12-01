package com.tencent.tendinsv.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/a/f.class */
public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38995a = "login_device";
    public static final String b = "login_behavior";

    /* renamed from: c  reason: collision with root package name */
    private static final int f38996c = 1;
    private static final String d = "login_sdk_report";
    private static volatile f e;

    private f(Context context) {
        super(context, "login_sdk_report.db", null, 1, true);
    }

    public static f a(Context context) {
        if (e == null) {
            synchronized (f.class) {
                try {
                    if (e == null) {
                        e = new f(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    @Override // com.tencent.tendinsv.a.a, android.database.sqlite.SQLiteOpenHelper
    public /* bridge */ /* synthetic */ SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override // com.tencent.tendinsv.a.a, android.database.sqlite.SQLiteOpenHelper
    public /* bridge */ /* synthetic */ SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override // com.tencent.tendinsv.a.a, android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        super.onCreate(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS login_device(DID text UNIQUE,IMEI text,IMSI text,ICCID text,MAC text,appPlatform text,device text,deviceName text,oaid text)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS login_behavior(id INTEGER PRIMARY KEY AUTOINCREMENT,DID text,telcom text,sdkMode text,osVersion text,romVersion text,sdkVersion text,uuid text,ip text,network text,dbm text,wifidbm text,processName text,method text,beginTime text,costTime INTEGER ,stepTime INTEGER ,status text,resCode text,resDesc text,innerCode text,innerDesc text,count INTEGER,sid text)");
    }

    @Override // com.tencent.tendinsv.a.a, android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        super.onUpgrade(sQLiteDatabase, i, i2);
    }
}
