package com.tencent.qimei.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.nio.charset.Charset;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/i/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f38332a;
    public static byte[] b = {33, 94, 120, 74, 111, 43, 35};

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f38333c;
    public SharedPreferences.Editor d;
    public Lock e = new ReentrantLock();

    public b() {
        new a(this);
        Context J = com.tencent.qimei.u.d.b().J();
        if (J != null) {
            this.f38333c = J.getSharedPreferences("DENGTA_META", 0);
        }
    }

    public static b b() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f38332a == null) {
                    f38332a = new b();
                }
                bVar = f38332a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public String a(String str, String str2) {
        String string;
        synchronized (this) {
            string = this.f38333c.getString(str, str2);
        }
        return string;
    }

    public String a(String str, String str2, String str3) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.f38333c;
            String string = sharedPreferences.getString(str, "");
            if (string != null && !string.trim().equals("")) {
                byte[] bytes = string.getBytes(Charset.defaultCharset());
                int i = 0;
                for (int i2 = 0; i2 < bytes.length; i2++) {
                    byte b2 = bytes[i2];
                    byte[] bArr = b;
                    bytes[i2] = (byte) (b2 ^ bArr[i]);
                    i = (i + 1) % bArr.length;
                }
                sharedPreferences.edit().remove(str).putString(str2, Base64.encodeToString(bytes, 2)).commit();
                return string;
            }
            String string2 = sharedPreferences.getString(str2, "");
            if (string2 == null || string2.trim().equals("")) {
                return str3;
            }
            byte[] decode = Base64.decode(string2, 2);
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= decode.length) {
                    return new String(decode, Charset.defaultCharset());
                }
                byte b3 = decode[i5];
                byte[] bArr2 = b;
                decode[i5] = (byte) (b3 ^ bArr2[i3]);
                i3 = (i3 + 1) % bArr2.length;
                i4 = i5 + 1;
            }
        }
    }

    public final void a() {
        synchronized (this) {
            if (this.e.tryLock()) {
                this.d.commit();
                this.e.unlock();
            }
        }
    }
}
