package com.getui.gtc.dim.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.crypt.CryptTools;
import com.getui.gtc.base.crypt.SecureCryptTools;
import com.getui.gtc.base.db.AbstractTable;
import com.getui.gtc.dim.b.f;
import com.getui.gtc.dim.e.c;
import java.io.File;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/a/b.class */
public class b extends AbstractTable {
    public final f a(String str) {
        f fVar;
        f fVar2;
        Cursor cursor = null;
        try {
            Cursor query = getReadableDatabase().query("d", new String[]{"t", "b"}, "a=?", new String[]{String.valueOf(str)}, null, null, null);
            fVar = null;
            if (query != null) {
                fVar = null;
                try {
                    if (query.moveToNext()) {
                        String string = query.getString(query.getColumnIndex("b"));
                        fVar = new f(null, query.getLong(query.getColumnIndex("t")));
                        try {
                            query.close();
                            if (!TextUtils.isEmpty(string)) {
                                String str2 = string;
                                if (string.equals("-1")) {
                                    File file = new File(GtcProvider.context().getCacheDir(), CryptTools.digestToHexString("MD5", (str + com.umeng.analytics.process.a.d).getBytes()));
                                    str2 = string;
                                    if (file.exists()) {
                                        str2 = new String(c.a(file));
                                    }
                                }
                                fVar.f21942a = c.a(SecureCryptTools.getInstance().decrypt(Base64.decode(str2, 0)));
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = query;
                            try {
                                com.getui.gtc.dim.e.b.a(th);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                fVar2 = fVar;
                                return fVar2;
                            } catch (Throwable th2) {
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th2;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fVar = null;
                }
            }
            fVar2 = fVar;
            if (query != null) {
                query.close();
                return fVar;
            }
        } catch (Throwable th4) {
            th = th4;
            fVar = null;
        }
        return fVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ac A[Catch: all -> 0x019f, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x019f, blocks: (B:5:0x0067, B:7:0x0071, B:8:0x0093, B:14:0x00ac, B:18:0x00c2, B:21:0x00d0, B:22:0x00db, B:26:0x0172), top: B:50:0x0067 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.dim.a.b.a():void");
    }

    public final boolean a(String str, Object obj) {
        try {
            String encodeToString = Base64.encodeToString(SecureCryptTools.getInstance().encrypt(c.b(obj)), 0);
            String str2 = encodeToString;
            if (encodeToString.length() > 5120) {
                byte[] bytes = encodeToString.getBytes();
                File cacheDir = GtcProvider.context().getCacheDir();
                c.a(bytes, new File(cacheDir, CryptTools.digestToHexString("MD5", (str + com.umeng.analytics.process.a.d).getBytes())));
                str2 = "-1";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("a", str);
            contentValues.put("t", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("b", str2);
            com.getui.gtc.dim.e.b.a(str + " update dim storage cache = " + str2);
            return replace(null, contentValues) != -1;
        }
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public String createSql() {
        return "CREATE TABLE IF NOT EXISTS d (a TEXT PRIMARY KEY, t TEXT, b TEXT)";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public String getTableName() {
        return "d";
    }
}
