package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/qrcode/encoder/ByteMatrix.class */
public final class ByteMatrix {
    private final byte[][] bytes;
    private final int height;
    private final int width;

    public ByteMatrix(int i, int i2) {
        this.bytes = (byte[][]) Array.newInstance(Byte.TYPE, i2, i);
        this.width = i;
        this.height = i2;
    }

    public void clear(byte b) {
        byte[][] bArr = this.bytes;
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Arrays.fill(bArr[i2], b);
            i = i2 + 1;
        }
    }

    public byte get(int i, int i2) {
        return this.bytes[i2][i];
    }

    public byte[][] getArray() {
        return this.bytes;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void set(int i, int i2, byte b) {
        this.bytes[i2][i] = b;
    }

    public void set(int i, int i2, int i3) {
        this.bytes[i2][i] = (byte) i3;
    }

    public void set(int i, int i2, boolean z) {
        this.bytes[i2][i] = z ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.width * 2 * this.height) + 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.height) {
                return sb.toString();
            }
            byte[] bArr = this.bytes[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.width) {
                    byte b = bArr[i4];
                    if (b == 0) {
                        sb.append(" 0");
                    } else if (b != 1) {
                        sb.append("  ");
                    } else {
                        sb.append(" 1");
                    }
                    i3 = i4 + 1;
                }
            }
            sb.append('\n');
            i = i2 + 1;
        }
    }
}
