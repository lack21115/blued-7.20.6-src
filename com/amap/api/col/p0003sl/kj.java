package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* renamed from: com.amap.api.col.3sl.kj  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kj.class */
public final class kj {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;

    public kj(Context context, String str, String str2, String str3) throws hn {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new hn("无效的参数 - IllegalArgumentException");
        }
        this.a = context.getApplicationContext();
        this.c = str;
        this.d = str2;
        this.b = str3;
    }

    private static byte[] a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private byte[] b(String str) {
        byte[] a;
        if (!TextUtils.isEmpty(str) && (a = ib.a(this.e)) != null) {
            return ib.a(a.length);
        }
        return new byte[]{0, 0};
    }

    public final void a(String str) throws hn {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new hn("无效的参数 - IllegalArgumentException");
        }
        this.e = str;
    }

    public final byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        int i = 0;
        byte[] bArr = new byte[0];
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th2) {
                byteArrayOutputStream = null;
                th = th2;
            }
            try {
                ib.a(byteArrayOutputStream, this.c);
                ib.a(byteArrayOutputStream, this.d);
                ib.a(byteArrayOutputStream, this.b);
                ib.a(byteArrayOutputStream, String.valueOf(hs.o(this.a)));
                try {
                    i = (int) (System.currentTimeMillis() / 1000);
                } catch (Throwable th3) {
                }
                byteArrayOutputStream.write(a(i));
                byteArrayOutputStream.write(b(this.e));
                byteArrayOutputStream.write(ib.a(this.e));
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th4) {
                th = th4;
                try {
                    iw.c(th, "se", "tds");
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return bArr;
                } catch (Throwable th5) {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    }
                    throw th5;
                }
            }
        } catch (Throwable th7) {
            th7.printStackTrace();
            return null;
        }
    }
}
