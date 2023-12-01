package com.tencent.tmsbeacon.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.tmsbeacon.a.c.c;
import java.nio.charset.Charset;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/b/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f39490a;
    private static byte[] b = {33, 94, 120, 74, 111, 43, 35};

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f39491c;
    private SharedPreferences.Editor d;
    private Lock e = new ReentrantLock();
    private Runnable f = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/b/a/b$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b();
        }
    }

    public b() {
        Context c2 = c.d().c();
        if (c2 != null) {
            this.f39491c = c2.getSharedPreferences("DENGTA_META", 0);
        }
    }

    public static b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f39490a == null) {
                    f39490a = new b();
                }
                bVar = f39490a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private static String a(String str) {
        byte[] decode = Base64.decode(str, 2);
        int i = 0;
        for (int i2 = 0; i2 < decode.length; i2++) {
            byte b2 = decode[i2];
            byte[] bArr = b;
            decode[i2] = (byte) (b2 ^ bArr[i]);
            i = (i + 1) % bArr.length;
        }
        return new String(decode, Charset.defaultCharset());
    }

    private static String b(String str) {
        byte[] bytes = str.getBytes(Charset.defaultCharset());
        int i = 0;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            byte b2 = bytes[i2];
            byte[] bArr = b;
            bytes[i2] = (byte) (b2 ^ bArr[i]);
            i = (i + 1) % bArr.length;
        }
        return Base64.encodeToString(bytes, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        synchronized (this) {
            if (this.e.tryLock()) {
                this.d.commit();
                this.e.unlock();
            }
        }
    }

    public String a(String str, String str2) {
        String string;
        synchronized (this) {
            string = this.f39491c.getString(str, str2);
        }
        return string;
    }

    public String a(String str, String str2, String str3) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.f39491c;
            String string = sharedPreferences.getString(str, "");
            if (string != null && !string.trim().equals("")) {
                String b2 = b(string);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (com.tencent.tmsbeacon.base.util.b.a(edit)) {
                    edit.remove(str).putString(str2, b2).commit();
                }
                return string;
            }
            String string2 = sharedPreferences.getString(str2, "");
            if (string2 == null || string2.trim().equals("")) {
                return str3;
            }
            return a(string2);
        }
    }
}
