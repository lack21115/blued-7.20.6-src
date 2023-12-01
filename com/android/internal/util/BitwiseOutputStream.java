package com.android.internal.util;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/BitwiseOutputStream.class */
public class BitwiseOutputStream {
    private byte[] mBuf;
    private int mEnd;
    private int mPos = 0;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/BitwiseOutputStream$AccessException.class */
    public static class AccessException extends Exception {
        public AccessException(String str) {
            super("BitwiseOutputStream access failed: " + str);
        }
    }

    public BitwiseOutputStream(int i) {
        this.mBuf = new byte[i];
        this.mEnd = i << 3;
    }

    private void possExpand(int i) {
        if (this.mPos + i < this.mEnd) {
            return;
        }
        byte[] bArr = new byte[(this.mPos + i) >>> 2];
        System.arraycopy(this.mBuf, 0, bArr, 0, this.mEnd >>> 3);
        this.mBuf = bArr;
        this.mEnd = bArr.length << 3;
    }

    public void skip(int i) {
        possExpand(i);
        this.mPos += i;
    }

    public byte[] toByteArray() {
        int i = (this.mPos >>> 3) + ((this.mPos & 7) > 0 ? 1 : 0);
        byte[] bArr = new byte[i];
        System.arraycopy(this.mBuf, 0, bArr, 0, i);
        return bArr;
    }

    public void write(int i, int i2) throws AccessException {
        if (i < 0 || i > 8) {
            throw new AccessException("illegal write (" + i + " bits)");
        }
        possExpand(i);
        int i3 = this.mPos >>> 3;
        int i4 = (16 - (this.mPos & 7)) - i;
        int i5 = (i2 & ((-1) >>> (32 - i))) << i4;
        this.mPos += i;
        byte[] bArr = this.mBuf;
        bArr[i3] = (byte) (bArr[i3] | (i5 >>> 8));
        if (i4 < 8) {
            byte[] bArr2 = this.mBuf;
            int i6 = i3 + 1;
            bArr2[i6] = (byte) (bArr2[i6] | (i5 & 255));
        }
    }

    public void writeByteArray(int i, byte[] bArr) throws AccessException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= bArr.length) {
                return;
            }
            int min = Math.min(8, i - (i3 << 3));
            if (min > 0) {
                write(min, (byte) (bArr[i3] >>> (8 - min)));
            }
            i2 = i3 + 1;
        }
    }
}
