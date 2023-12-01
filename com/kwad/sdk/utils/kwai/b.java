package com.kwad.sdk.utils.kwai;

import android.view.View;
import java.nio.charset.Charset;
import okio.Utf8;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/kwai/b.class */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private char[] aBN;
    public byte[] aBO;
    public int position;

    public b(int i) {
        this(new byte[i], 0);
    }

    public b(byte[] bArr) {
        this(bArr, 0);
    }

    public b(byte[] bArr, int i) {
        this.aBN = null;
        this.aBO = bArr;
        this.position = i;
    }

    public static int ck(int i) {
        if ((i >> 7) == 0) {
            return 1;
        }
        if ((i >> 14) == 0) {
            return 2;
        }
        if ((i >> 21) == 0) {
            return 3;
        }
        return (i >> 28) == 0 ? 4 : 5;
    }

    private char[] cm(int i) {
        char[] cArr = this.aBN;
        if (cArr == null) {
            if (i <= 256) {
                this.aBN = new char[256];
            } else {
                this.aBN = new char[2048];
            }
        } else if (cArr.length < i) {
            this.aBN = new char[2048];
        }
        return this.aBN;
    }

    private String cn(int i) {
        if (i > 2048) {
            return new String(this.aBO, this.position, i, UTF_8);
        }
        char[] cm = cm(i);
        byte[] bArr = this.aBO;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cm[i4] = (char) (b ^ 1);
                i2 = i5;
                i4++;
            } else if (b < -32) {
                cm[i4] = (char) (((b & 31) << 6) | (bArr[i5] & 63));
                i2 = i5 + 1;
                i4++;
            } else if (b < -16) {
                int i6 = i5 + 1;
                cm[i4] = (char) (((b & 15) << 12) | ((bArr[i5] & 63) << 6) | (bArr[i6] & 63));
                i2 = i6 + 1;
                i4++;
            } else {
                int i7 = i5 + 1;
                byte b2 = bArr[i5];
                int i8 = i7 + 1;
                int i9 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((bArr[i7] & 63) << 6) | (bArr[i8] & 63);
                int i10 = i4 + 1;
                cm[i4] = (char) ((i9 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i4 = i10 + 1;
                cm[i10] = (char) ((i9 & 1023) + 56320);
                i2 = i8 + 1;
            }
        }
        if (i2 <= i3) {
            return new String(cm, 0, i4);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private String co(int i) {
        if (i > 2048) {
            return new String(this.aBO, this.position, i, UTF_8);
        }
        char[] cm = cm(i);
        byte[] bArr = this.aBO;
        int i2 = this.position;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cm[i4] = (char) b;
                i2 = i5;
                i4++;
            } else if (b < -32) {
                cm[i4] = (char) (((b & 31) << 6) | (bArr[i5] & 63));
                i2 = i5 + 1;
                i4++;
            } else if (b < -16) {
                int i6 = i5 + 1;
                cm[i4] = (char) (((b & 15) << 12) | ((bArr[i5] & 63) << 6) | (bArr[i6] & 63));
                i2 = i6 + 1;
                i4++;
            } else {
                int i7 = i5 + 1;
                byte b2 = bArr[i5];
                int i8 = i7 + 1;
                int i9 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((bArr[i7] & 63) << 6) | (bArr[i8] & 63);
                int i10 = i4 + 1;
                cm[i4] = (char) ((i9 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i4 = i10 + 1;
                cm[i10] = (char) ((i9 & 1023) + 56320);
                i2 = i8 + 1;
            }
        }
        if (i2 <= i3) {
            return new String(cm, 0, i4);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    public static int eY(String str) {
        int i;
        int i2;
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                i = i4;
                i2 = 1;
            } else if (charAt < 2048) {
                i = i4;
                i2 = 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i = i4;
                i2 = 3;
            } else {
                i3 = i5 + 1;
                i4 += 4;
            }
            i4 = i + i2;
            i3 = i5;
        }
        return i4;
    }

    private void eZ(String str) {
        byte[] bArr = this.aBO;
        int i = this.position;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                bArr[i] = (byte) (charAt ^ 1);
                i2 = i3;
                i++;
            } else if (charAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((charAt >>> 6) | 192);
                i = i4 + 1;
                bArr[i4] = (byte) ((charAt & '?') | 128);
                i2 = i3;
            } else if (charAt < 55296 || charAt > 57343) {
                int i5 = i + 1;
                bArr[i] = (byte) ((charAt >>> '\f') | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((charAt >>> 6) & 63) | 128);
                bArr[i6] = (byte) ((charAt & '?') | 128);
                i2 = i3;
                i = i6 + 1;
            } else {
                int charAt2 = ((charAt << '\n') + str.charAt(i3)) - 56613888;
                int i7 = i + 1;
                bArr[i] = (byte) ((charAt2 >>> 18) | 240);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i = i9 + 1;
                bArr[i9] = (byte) ((charAt2 & 63) | 128);
                i2 = i3 + 1;
            }
        }
        this.position = i;
    }

    public static byte[] fa(String str) {
        byte[] bArr = new byte[eY(str)];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt < 128) {
                bArr[i2] = (byte) (charAt ^ 1);
                i = i3;
                i2++;
            } else if (charAt < 2048) {
                int i4 = i2 + 1;
                bArr[i2] = (byte) ((charAt >>> 6) | 192);
                i2 = i4 + 1;
                bArr[i4] = (byte) ((charAt & '?') | 128);
                i = i3;
            } else if (charAt < 55296 || charAt > 57343) {
                int i5 = i2 + 1;
                bArr[i2] = (byte) ((charAt >>> '\f') | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((charAt >>> 6) & 63) | 128);
                bArr[i6] = (byte) ((charAt & '?') | 128);
                i = i3;
                i2 = i6 + 1;
            } else {
                int charAt2 = ((charAt << '\n') + str.charAt(i3)) - 56613888;
                int i7 = i2 + 1;
                bArr[i2] = (byte) ((charAt2 >>> 18) | 240);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i2 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 & 63) | 128);
                i = i3 + 1;
            }
        }
        return bArr;
    }

    private long getLong(int i) {
        byte[] bArr = this.aBO;
        int i2 = i + 1;
        long j = bArr[i];
        int i3 = i2 + 1;
        long j2 = bArr[i2];
        int i4 = i3 + 1;
        long j3 = bArr[i3];
        int i5 = i4 + 1;
        long j4 = bArr[i4];
        int i6 = i5 + 1;
        long j5 = bArr[i5];
        int i7 = i6 + 1;
        return (j & 255) | ((j2 & 255) << 8) | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((j5 & 255) << 32) | ((bArr[i6] & 255) << 40) | ((255 & bArr[i7]) << 48) | (bArr[i7 + 1] << 56);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j(byte[] bArr, int i) {
        char[] cArr = new char[bArr.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                cArr[i3] = (char) (b ^ 1);
                i2 = i4;
                i3++;
            } else if (b < -32) {
                cArr[i3] = (char) (((b & 31) << 6) | (bArr[i4] & 63));
                i2 = i4 + 1;
                i3++;
            } else if (b < -16) {
                int i5 = i4 + 1;
                cArr[i3] = (char) (((b & 15) << 12) | ((bArr[i4] & 63) << 6) | (bArr[i5] & 63));
                i2 = i5 + 1;
                i3++;
            } else {
                int i6 = i4 + 1;
                byte b2 = bArr[i4];
                int i7 = i6 + 1;
                int i8 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((bArr[i6] & 63) << 6) | (bArr[i7] & 63);
                int i9 = i3 + 1;
                cArr[i3] = (char) ((i8 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i3 = i9 + 1;
                cArr[i9] = (char) ((i8 & 1023) + 56320);
                i2 = i7 + 1;
            }
        }
        if (i2 <= i) {
            return new String(cArr, 0, i3);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private int w(int i, int i2) {
        while ((i2 & (-128)) != 0) {
            this.aBO[i] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i++;
        }
        this.aBO[i] = (byte) i2;
        return i + 1;
    }

    public final int Fc() {
        byte[] bArr = this.aBO;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        byte b = bArr[i];
        if ((b >> 7) == 0) {
            return b;
        }
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = (b & Byte.MAX_VALUE) | (bArr[i2] << 7);
        if ((i4 >> 14) == 0) {
            return i4;
        }
        int i5 = i3 + 1;
        this.position = i5;
        int i6 = (i4 & View.PUBLIC_STATUS_BAR_VISIBILITY_MASK) | (bArr[i3] << 14);
        if ((i6 >> 21) == 0) {
            return i6;
        }
        int i7 = i5 + 1;
        this.position = i7;
        int i8 = (i6 & 2097151) | (bArr[i5] << 21);
        if ((i8 >> 28) == 0) {
            return i8;
        }
        this.position = i7 + 1;
        return (bArr[i7] << 28) | (i8 & 268435455);
    }

    public final void a(short s) {
        byte[] bArr = this.aBO;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        bArr[i] = (byte) s;
        this.position = i2 + 1;
        bArr[i2] = (byte) (s >> 8);
    }

    public final void ai(long j) {
        d(this.position, j);
        this.position += 8;
    }

    public final void b(byte b) {
        byte[] bArr = this.aBO;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public final void ci(int i) {
        byte[] bArr = this.aBO;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) i;
        int i4 = i3 + 1;
        this.position = i4;
        bArr[i3] = (byte) (i >> 8);
        int i5 = i4 + 1;
        this.position = i5;
        bArr[i4] = (byte) (i >> 16);
        this.position = i5 + 1;
        bArr[i5] = (byte) (i >> 24);
    }

    public final void cj(int i) {
        this.position = w(this.position, i);
    }

    public final String cl(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String co = co(i);
        this.position += i;
        return co;
    }

    public final void d(int i, long j) {
        byte[] bArr = this.aBO;
        int i2 = i + 1;
        bArr[i] = (byte) j;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j >> 8);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j >> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j >> 24);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j >> 32);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j >> 40);
        bArr[i7] = (byte) (j >> 48);
        bArr[i7 + 1] = (byte) (j >> 56);
    }

    public final void eX(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        eZ(str);
    }

    public final byte get() {
        byte[] bArr = this.aBO;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }

    public final byte[] getBytes(int i) {
        byte[] bArr = new byte[i];
        System.arraycopy((Object) this.aBO, this.position, (Object) bArr, 0, i);
        this.position += i;
        return bArr;
    }

    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public final int getInt() {
        byte[] bArr = this.aBO;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        byte b = bArr[i];
        int i3 = i2 + 1;
        this.position = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.position = i4;
        byte b3 = bArr[i3];
        this.position = i4 + 1;
        return (bArr[i4] << 24) | (b & 255) | ((b2 & 255) << 8) | ((b3 & 255) << 16);
    }

    public final long getLong() {
        long j = getLong(this.position);
        this.position += 8;
        return j;
    }

    public final short getShort() {
        byte[] bArr = this.aBO;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        byte b = bArr[i];
        this.position = i2 + 1;
        return (short) ((bArr[i2] << 8) | (b & 255));
    }

    public final String getString(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String cn2 = cn(i);
        this.position += i;
        return cn2;
    }

    public final void n(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy((Object) bArr, 0, (Object) this.aBO, this.position, length);
            this.position += length;
        }
    }

    public final void v(int i, int i2) {
        byte[] bArr = this.aBO;
        int i3 = i + 1;
        bArr[i] = (byte) i2;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >> 8);
        bArr[i4] = (byte) (i2 >> 16);
        bArr[i4 + 1] = (byte) (i2 >> 24);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long x(int i, int i2) {
        long j = 0;
        if (i2 <= 0) {
            return 0L;
        }
        int i3 = i;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= (i2 >> 3)) {
                break;
            }
            j ^= getLong(i3);
            i3 += 8;
            i4 = i5 + 1;
        }
        int i6 = 0;
        while (i6 < ((i2 & 7) << 3)) {
            j ^= (this.aBO[i3] & 255) << i6;
            i6 += 8;
            i3++;
        }
        int i7 = (i & 7) << 3;
        return (j >>> (64 - i7)) | (j << i7);
    }
}
