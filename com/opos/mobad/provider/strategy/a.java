package com.opos.mobad.provider.strategy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/strategy/a.class */
public class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private ReadWriteLock f27138a;

    public a(Context context) {
        super(context, "opos_mobad_app", null, 1);
        this.f27138a = new ReentrantReadWriteLock();
    }

    private void a(String str, long j) {
        try {
            int delete = getWritableDatabase().delete("pos", "appId=? and stgVer!=?", new String[]{str, String.valueOf(j)});
            com.opos.cmn.an.f.a.b("MobConfig", "remove " + delete);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("MobConfig", "remove pos fail", e);
        }
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00c8: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:39:0x00c8 */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.mobad.provider.strategy.AppInfo a() {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.provider.strategy.a.a():com.opos.mobad.provider.strategy.AppInfo");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.mobad.provider.strategy.AppInfo a(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.provider.strategy.a.a(java.lang.String):com.opos.mobad.provider.strategy.AppInfo");
    }

    public void a(String str, Bundle bundle, long j) {
        try {
            try {
                this.f27138a.writeLock().lock();
                getWritableDatabase().beginTransaction();
                for (String str2 : bundle.keySet()) {
                    byte[] byteArray = bundle.getByteArray(str2);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("appId", str);
                    contentValues.put("posId", str2);
                    contentValues.put("data", byteArray);
                    contentValues.put("stgVer", Long.valueOf(j));
                    getWritableDatabase().replace("pos", null, contentValues);
                }
                getWritableDatabase().setTransactionSuccessful();
            } catch (Exception e) {
                try {
                    com.opos.cmn.an.f.a.b("MobConfig", "add pos fail", e);
                    try {
                        getWritableDatabase().endTransaction();
                        a(str, j);
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("MobConfig", "end err", e2);
                    }
                } finally {
                }
            }
            try {
                try {
                    getWritableDatabase().endTransaction();
                    a(str, j);
                } catch (Exception e3) {
                    com.opos.cmn.an.f.a.b("MobConfig", "end err", e3);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                try {
                    getWritableDatabase().endTransaction();
                    a(str, j);
                } catch (Exception e4) {
                    com.opos.cmn.an.f.a.b("MobConfig", "end err", e4);
                }
                throw th;
            } finally {
            }
        }
    }

    public void a(String str, byte[] bArr, long j) {
        Lock writeLock = this.f27138a.writeLock();
        try {
            try {
                writeLock.lock();
                ContentValues contentValues = new ContentValues();
                contentValues.put("appId", str);
                contentValues.put("data", bArr);
                contentValues.put("expTime", Long.valueOf(j));
                contentValues.put("lmTime", Long.valueOf(System.currentTimeMillis()));
                getWritableDatabase().replace("app", null, contentValues);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("MobConfig", "add fail", e);
            }
        } finally {
            writeLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.Bundle b(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.provider.strategy.a.b(java.lang.String):android.os.Bundle");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table app(appId varchar primary key,data blob,expTime interger,lmTime interger);");
        sQLiteDatabase.execSQL("create table pos(posId varchar primary key,appId varchar,data blob,stgVer interger)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
