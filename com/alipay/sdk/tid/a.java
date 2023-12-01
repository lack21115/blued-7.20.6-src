package com.alipay.sdk.tid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alipay.sdk.util.c;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/tid/a.class */
public final class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4652a = "msp.db";
    private static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Context> f4653c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(context, f4652a, null, 1);
        this.f4653c = new WeakReference<>(context);
    }

    private String c(String str, String str2) {
        return str + str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r12.isOpen() != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.a.a(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        SQLiteDatabase writableDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
                sQLiteDatabase2 = writableDatabase;
                sQLiteDatabase = writableDatabase;
                writableDatabase.execSQL("drop table if exists tb_tid");
            } catch (Exception e) {
                c.a(e);
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
            }
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            sQLiteDatabase = writableDatabase;
            sQLiteDatabase.close();
        } catch (Throwable th) {
            if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                sQLiteDatabase2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r12.isOpen() != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 193
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.a.b(java.lang.String, java.lang.String):java.lang.String");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("drop table if exists tb_tid");
    }
}
