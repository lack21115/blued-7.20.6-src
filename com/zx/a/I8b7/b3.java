package com.zx.a.I8b7;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import com.youzan.androidsdk.tool.AppSigning;
import com.zx.a.I8b7.u1;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/b3.class */
public class b3 extends c {
    public SQLiteDatabase b = null;

    @Override // com.zx.a.I8b7.c
    public String a() {
        return "CREATE TABLE IF NOT EXISTS zx_table (key integer primary key, value text)";
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00de, code lost:
        if (r13 == null) goto L30;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(int r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.b3.a(int):java.lang.String");
    }

    public JSONObject a(IvParameterSpec ivParameterSpec, SecretKey secretKey) {
        Cursor cursor;
        Cursor query;
        try {
            query = b().query("zx_table", new String[]{"key", "value"}, "key=18", null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        JSONObject jSONObject = new JSONObject(new String(k.a(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD, secretKey, ivParameterSpec, Base64.decode(query.getString(query.getColumnIndex("value")), 0)), StandardCharsets.UTF_8));
                        query.close();
                        return jSONObject;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    try {
                        z1.a(th);
                        if (cursor == null) {
                            return null;
                        }
                        cursor.close();
                        return null;
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
            cursor = null;
        }
        if (query != null) {
            cursor = query;
            cursor.close();
            return null;
        }
        return null;
    }

    public final void a(int i, String str, boolean z) {
        String str2;
        if (this.b == null) {
            this.b = d();
        }
        if (z) {
            try {
                str2 = new String(Base64.encode(k.b(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD, t2.s, t2.t, str.getBytes()), 0), StandardCharsets.UTF_8);
            } catch (Exception e) {
                z1.b("ZXID updateDBValue valueID:" + i + ",value:" + str + ",error:" + e.toString());
                return;
            }
        } else {
            str2 = str;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", Integer.valueOf(i));
        contentValues.put("value", str2);
        long replace = this.b.replace("zx_table", null, contentValues);
        z1.a("replace resultId = " + replace);
    }

    @Override // com.zx.a.I8b7.c
    public void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        z1.a("ZXID数据库升级, drop zx_table表");
        try {
            sQLiteDatabase.execSQL("drop table if exists zx_table");
        } catch (Exception e) {
            z1.a(e);
        }
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS zx_table (key integer primary key, value text)");
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void a(String str) {
        IvParameterSpec g;
        SecretKey i;
        JSONObject a2;
        Cursor cursor = null;
        try {
            g = g();
            i = i();
            a2 = a(g, i);
        } catch (Throwable th) {
            try {
                z1.a(th);
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th2;
            }
        }
        if (a2 == null) {
            return;
        }
        String string = a2.getString("mainVersion");
        String string2 = a2.getString("checksum");
        if (TextUtils.equals(string, str)) {
            Cursor query = b().query("zx_table", new String[]{"key", "value"}, "key=17", null, null, null, null);
            if (query != null && query.moveToNext()) {
                byte[] a3 = k.a(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD, i, g, Base64.decode(query.getString(query.getColumnIndex("value")), 0));
                if (!TextUtils.equals(string2, k.a(k.a(AppSigning.SHA256, a3)))) {
                    throw new IOException("zx checksum1 exception");
                }
                a(str, a3);
            }
            if (query != null) {
                cursor = query;
                cursor.close();
            }
        }
    }

    public final void a(String str, byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        File file = new File(t2.f42201a.getFilesDir().getAbsolutePath() + File.separator + "zx-core-" + str + ".zip");
        if (!file.createNewFile()) {
            throw new IOException("zx createNewFile exception");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        byte[] bArr2 = new byte[2048];
        while (true) {
            int read = byteArrayInputStream.read(bArr2);
            if (read == -1) {
                fileOutputStream.close();
                byteArrayInputStream.close();
                return;
            }
            fileOutputStream.write(bArr2, 0, read);
        }
    }

    public void a(byte[] bArr) {
        String str = new String(Base64.encode(bArr, 0), StandardCharsets.UTF_8);
        a(9, str + "", false);
        z1.a("ZXID saveSecretKey secretStr:" + str);
    }

    public void b(int i) {
        if (i != t2.o) {
            t2.o = i;
            t2.q = -1;
            a(14, t2.o + "", false);
            a(7, t2.q + "", false);
        }
    }

    @Override // com.zx.a.I8b7.c
    public String c() {
        return "zx_table";
    }

    public void c(int i) {
        if (i != t2.q) {
            t2.q = i;
            a(7, t2.q + "", false);
        }
    }

    public void d(int i) {
        if (i != t2.k) {
            t2.k = i;
            b3 b3Var = u1.a.f42208a.f42207a;
            b3Var.a(3, t2.k + "", false);
            z1.a("syncId had changed refresh:" + i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
        if (r10 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int e() {
        /*
            r9 = this;
            r0 = 0
            r10 = r0
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.b()     // Catch: java.lang.Throwable -> L51
            r1 = r9
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L51
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L51
            r3 = r2
            r4 = 0
            java.lang.String r5 = "key"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L51
            r3 = r2
            r4 = 1
            java.lang.String r5 = "value"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L51
            java.lang.String r3 = "key=20"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L51
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L48
            r0 = r11
            r10 = r0
            r0 = r11
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L48
            r0 = r11
            r10 = r0
            r0 = r11
            r1 = r11
            java.lang.String r2 = "value"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L51
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L51
            com.zx.a.I8b7.t2.p = r0     // Catch: java.lang.Throwable -> L51
        L48:
            r0 = r11
            if (r0 == 0) goto L60
            r0 = r11
            r10 = r0
            goto L5a
        L51:
            r11 = move-exception
            r0 = r11
            com.zx.a.I8b7.z1.a(r0)     // Catch: java.lang.Throwable -> L64
            r0 = r10
            if (r0 == 0) goto L60
        L5a:
            r0 = r10
            r0.close()
        L60:
            int r0 = com.zx.a.I8b7.t2.p
            return r0
        L64:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L6f
            r0 = r10
            r0.close()
        L6f:
            r0 = r11
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.b3.e():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
        if (r10 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int f() {
        /*
            r9 = this;
            r0 = 0
            r10 = r0
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.b()     // Catch: java.lang.Throwable -> L51
            r1 = r9
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L51
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L51
            r3 = r2
            r4 = 0
            java.lang.String r5 = "key"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L51
            r3 = r2
            r4 = 1
            java.lang.String r5 = "value"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L51
            java.lang.String r3 = "key=14"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L51
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L48
            r0 = r11
            r10 = r0
            r0 = r11
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L48
            r0 = r11
            r10 = r0
            r0 = r11
            r1 = r11
            java.lang.String r2 = "value"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L51
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L51
            com.zx.a.I8b7.t2.o = r0     // Catch: java.lang.Throwable -> L51
        L48:
            r0 = r11
            if (r0 == 0) goto L60
            r0 = r11
            r10 = r0
            goto L5a
        L51:
            r11 = move-exception
            r0 = r11
            com.zx.a.I8b7.z1.a(r0)     // Catch: java.lang.Throwable -> L64
            r0 = r10
            if (r0 == 0) goto L60
        L5a:
            r0 = r10
            r0.close()
        L60:
            int r0 = com.zx.a.I8b7.t2.o
            return r0
        L64:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L6f
            r0 = r10
            r0.close()
        L6f:
            r0 = r11
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.b3.f():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0060, code lost:
        if (r12 != null) goto L19;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public javax.crypto.spec.IvParameterSpec g() {
        /*
            r9 = this;
            r0 = 0
            r13 = r0
            r0 = 0
            r14 = r0
            r0 = 0
            r11 = r0
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.b()     // Catch: java.lang.Throwable -> L66
            r1 = r9
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L66
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L66
            r3 = r2
            r4 = 0
            java.lang.String r5 = "key"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L66
            r3 = r2
            r4 = 1
            java.lang.String r5 = "value"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L66
            java.lang.String r3 = "key=10"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L66
            r12 = r0
            r0 = r11
            r10 = r0
            r0 = r12
            if (r0 == 0) goto L5d
            r0 = r11
            r10 = r0
            r0 = r12
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L5d
            javax.crypto.spec.IvParameterSpec r0 = new javax.crypto.spec.IvParameterSpec     // Catch: java.lang.Throwable -> L57
            r1 = r0
            r2 = r12
            r3 = r12
            java.lang.String r4 = "value"
            int r3 = r3.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L57
            java.lang.String r2 = r2.getString(r3)     // Catch: java.lang.Throwable -> L57
            r3 = 0
            byte[] r2 = android.util.Base64.decode(r2, r3)     // Catch: java.lang.Throwable -> L57
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L57
            r10 = r0
            goto L5d
        L57:
            r11 = move-exception
            r0 = r12
            r10 = r0
            goto L69
        L5d:
            r0 = r10
            r11 = r0
            r0 = r12
            if (r0 == 0) goto L81
            goto L79
        L66:
            r11 = move-exception
            r0 = 0
            r10 = r0
        L69:
            r0 = r11
            com.zx.a.I8b7.z1.a(r0)     // Catch: java.lang.Throwable -> L83
            r0 = r14
            r11 = r0
            r0 = r10
            if (r0 == 0) goto L81
            r0 = r10
            r12 = r0
            r0 = r13
            r10 = r0
        L79:
            r0 = r12
            r0.close()
            r0 = r10
            r11 = r0
        L81:
            r0 = r11
            return r0
        L83:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L8e
            r0 = r10
            r0.close()
        L8e:
            r0 = r11
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.b3.g():javax.crypto.spec.IvParameterSpec");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
        if (r10 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int h() {
        /*
            r9 = this;
            r0 = 0
            r10 = r0
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.b()     // Catch: java.lang.Throwable -> L51
            r1 = r9
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L51
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L51
            r3 = r2
            r4 = 0
            java.lang.String r5 = "key"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L51
            r3 = r2
            r4 = 1
            java.lang.String r5 = "value"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L51
            java.lang.String r3 = "key=7"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L51
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L48
            r0 = r11
            r10 = r0
            r0 = r11
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L48
            r0 = r11
            r10 = r0
            r0 = r11
            r1 = r11
            java.lang.String r2 = "value"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L51
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L51
            com.zx.a.I8b7.t2.q = r0     // Catch: java.lang.Throwable -> L51
        L48:
            r0 = r11
            if (r0 == 0) goto L60
            r0 = r11
            r10 = r0
            goto L5a
        L51:
            r11 = move-exception
            r0 = r11
            com.zx.a.I8b7.z1.a(r0)     // Catch: java.lang.Throwable -> L64
            r0 = r10
            if (r0 == 0) goto L60
        L5a:
            r0 = r10
            r0.close()
        L60:
            int r0 = com.zx.a.I8b7.t2.q
            return r0
        L64:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L6f
            r0 = r10
            r0.close()
        L6f:
            r0 = r11
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.b3.h():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0069, code lost:
        if (r12 != null) goto L19;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public javax.crypto.SecretKey i() {
        /*
            r9 = this;
            r0 = 0
            r13 = r0
            r0 = 0
            r14 = r0
            r0 = 0
            r11 = r0
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = r0.b()     // Catch: java.lang.Throwable -> L6f
            r1 = r9
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L6f
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L6f
            r3 = r2
            r4 = 0
            java.lang.String r5 = "key"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L6f
            r3 = r2
            r4 = 1
            java.lang.String r5 = "value"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L6f
            java.lang.String r3 = "key=9"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L6f
            r12 = r0
            r0 = r11
            r10 = r0
            r0 = r12
            if (r0 == 0) goto L66
            r0 = r11
            r10 = r0
            r0 = r12
            boolean r0 = r0.moveToNext()     // Catch: java.lang.Throwable -> L60
            if (r0 == 0) goto L66
            r0 = r12
            r1 = r12
            java.lang.String r2 = "value"
            int r1 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L60
            java.lang.String r0 = r0.getString(r1)     // Catch: java.lang.Throwable -> L60
            r1 = 0
            byte[] r0 = android.util.Base64.decode(r0, r1)     // Catch: java.lang.Throwable -> L60
            r10 = r0
            java.security.SecureRandom r0 = com.zx.a.I8b7.k.f42141a     // Catch: java.lang.Throwable -> L60
            r11 = r0
            javax.crypto.spec.SecretKeySpec r0 = new javax.crypto.spec.SecretKeySpec     // Catch: java.lang.Throwable -> L60
            r1 = r0
            r2 = r10
            java.lang.String r3 = "AES"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L60
            r10 = r0
            goto L66
        L60:
            r11 = move-exception
            r0 = r12
            r10 = r0
            goto L72
        L66:
            r0 = r10
            r11 = r0
            r0 = r12
            if (r0 == 0) goto L8a
            goto L82
        L6f:
            r11 = move-exception
            r0 = 0
            r10 = r0
        L72:
            r0 = r11
            com.zx.a.I8b7.z1.a(r0)     // Catch: java.lang.Throwable -> L8c
            r0 = r14
            r11 = r0
            r0 = r10
            if (r0 == 0) goto L8a
            r0 = r10
            r12 = r0
            r0 = r13
            r10 = r0
        L82:
            r0 = r12
            r0.close()
            r0 = r10
            r11 = r0
        L8a:
            r0 = r11
            return r0
        L8c:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L97
            r0 = r10
            r0.close()
        L97:
            r0 = r11
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zx.a.I8b7.b3.i():javax.crypto.SecretKey");
    }
}
