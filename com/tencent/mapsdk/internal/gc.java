package com.tencent.mapsdk.internal;

import android.text.Spanned;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gc.class */
public class gc implements hc {
    private static final String h = "UTF-16LE";
    private ByteArrayOutputStream g = new ByteArrayOutputStream();

    public static String a(byte[] bArr, String str) {
        try {
            return new String(bArr, str).trim();
        } catch (Exception e) {
            return null;
        }
    }

    private void a(long j, int i) {
        while (true) {
            i--;
            if (i < 0) {
                return;
            }
            a((byte) ((j >> (i * 8)) & 255));
        }
    }

    private static void a(long j, int i, byte[] bArr) {
        int i2 = i;
        while (true) {
            int i3 = i2 - 1;
            if (i3 < 0) {
                return;
            }
            bArr[(i - i3) - 1] = (byte) ((j >> (i3 * 8)) & 255);
            i2 = i3;
        }
    }

    public static byte[] a(double d) {
        return b(Double.doubleToLongBits(d));
    }

    public static byte[] a(float f) {
        return d(Float.floatToIntBits(f));
    }

    public static boolean b(byte[] bArr) {
        boolean z = false;
        if (bArr[0] > 0) {
            z = true;
        }
        return z;
    }

    public static byte[] b(long j) {
        return new byte[]{(byte) j, (byte) (j >> 8), (byte) (j >> 16), (byte) (j >> 24), (byte) (j >> 32), (byte) (j >> 40), (byte) (j >> 48), (byte) (j >> 56)};
    }

    public static byte[] b(String str) {
        if (str != null) {
            try {
                return str.getBytes(h);
            } catch (Exception e) {
            }
        }
        return new byte[0];
    }

    public static double c(byte[] bArr) {
        return Double.longBitsToDouble(f(bArr));
    }

    public static byte[] c(int i) {
        byte[] bArr = new byte[4];
        a(i, 4, bArr);
        return bArr;
    }

    public static float d(byte[] bArr) {
        return Float.intBitsToFloat(e(bArr));
    }

    public static byte[] d(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    public static int e(byte[] bArr) {
        return ((bArr[3] << 24) & (-16777216)) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & Spanned.SPAN_PRIORITY);
    }

    public static long f(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 24) | ((bArr[4] & 255) << 32) | ((bArr[5] & 255) << 40) | ((bArr[6] & 255) << 48) | ((bArr[7] & 255) << 56);
    }

    public static String g(byte[] bArr) {
        try {
            return new String(bArr, h).trim();
        } catch (Exception e) {
            return null;
        }
    }

    public void a(byte b) {
        this.g.write(b);
    }

    public void a(char c2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return;
            }
            a((byte) ((c2 >> (i2 * 8)) & 255));
            i = i2 + 1;
        }
    }

    public void a(int i) {
        a(i, 4);
    }

    public void a(long j) {
        a(j, 8);
    }

    public void a(String str) {
        if (str == null) {
            return;
        }
        byte[] bytes = str.getBytes();
        b(bytes.length);
        a(bytes);
    }

    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    public void a(byte[] bArr) {
        this.g.write(bArr, 0, bArr.length);
    }

    public byte[] a() {
        byte[] bArr;
        try {
            this.g.close();
            bArr = this.g.toByteArray();
            try {
                this.g = null;
                return bArr;
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
                return bArr;
            }
        } catch (IOException e2) {
            e = e2;
            bArr = null;
        }
    }

    public void b(int i) {
        a(i, 2);
    }
}
