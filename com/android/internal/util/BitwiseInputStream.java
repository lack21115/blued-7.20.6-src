package com.android.internal.util;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/BitwiseInputStream.class */
public class BitwiseInputStream {
    private byte[] mBuf;
    private int mEnd;
    private int mPos = 0;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/BitwiseInputStream$AccessException.class */
    public static class AccessException extends Exception {
        public AccessException(String str) {
            super("BitwiseInputStream access failed: " + str);
        }
    }

    public BitwiseInputStream(byte[] bArr) {
        this.mBuf = bArr;
        this.mEnd = bArr.length << 3;
    }

    public int available() {
        return this.mEnd - this.mPos;
    }

    public int read(int i) throws AccessException {
        int i2 = this.mPos >>> 3;
        int i3 = (16 - (this.mPos & 7)) - i;
        if (i < 0 || i > 8 || this.mPos + i > this.mEnd) {
            throw new AccessException("illegal read (pos " + this.mPos + ", end " + this.mEnd + ", bits " + i + ")");
        }
        int i4 = (this.mBuf[i2] & 255) << 8;
        int i5 = i4;
        if (i3 < 8) {
            i5 = i4 | (this.mBuf[i2 + 1] & 255);
        }
        this.mPos += i;
        return (i5 >>> i3) & ((-1) >>> (32 - i));
    }

    public byte[] readByteArray(int i) throws AccessException {
        int i2 = (i >>> 3) + ((i & 7) > 0 ? 1 : 0);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return bArr;
            }
            int min = Math.min(8, i - (i4 << 3));
            bArr[i4] = (byte) (read(min) << (8 - min));
            i3 = i4 + 1;
        }
    }

    public void skip(int i) throws AccessException {
        if (this.mPos + i > this.mEnd) {
            throw new AccessException("illegal skip (pos " + this.mPos + ", end " + this.mEnd + ", bits " + i + ")");
        }
        this.mPos += i;
    }
}
