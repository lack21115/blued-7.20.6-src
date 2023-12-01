package com.opos.mobad.provider.ad;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/provider/ad/b.class */
public class b extends SQLiteOpenHelper {
    public b(Context context) {
        super(context, "opos_mobad_ad", null, 1);
    }

    private void b(String str) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            int delete = writableDatabase.delete("mobad_ad", "posId=" + str, new String[0]);
            com.opos.cmn.an.f.a.b("", ShareConstants.RES_DEL_TITLE + str + ",result:" + delete);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("", "", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.mobad.provider.ad.AdEntity a(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.provider.ad.b.a(java.lang.String):com.opos.mobad.provider.ad.AdEntity");
    }

    public void a(String str, AdEntity adEntity) {
        synchronized (this) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("posId", str);
            contentValues.put("data", adEntity.b);
            contentValues.put("validTime", Long.valueOf(adEntity.f13423c));
            contentValues.put("posData", adEntity.f13422a);
            getWritableDatabase().replace("mobad_ad", null, contentValues);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE mobad_ad(posId TEXT PRIMARY KEY,data BLOB,posData BLOB,validTime INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
