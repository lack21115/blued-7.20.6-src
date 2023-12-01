package com.google.zxing;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/LuminanceSource.class */
public abstract class LuminanceSource {
    private final int height;
    private final int width;

    /* JADX INFO: Access modifiers changed from: protected */
    public LuminanceSource(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int getHeight() {
        return this.height;
    }

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i, byte[] bArr);

    public final int getWidth() {
        return this.width;
    }

    public LuminanceSource invert() {
        return new InvertedLuminanceSource(this);
    }

    public boolean isCropSupported() {
        return false;
    }

    public boolean isRotateSupported() {
        return false;
    }

    public LuminanceSource rotateCounterClockwise() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public LuminanceSource rotateCounterClockwise45() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        int i = this.width;
        byte[] bArr = new byte[i];
        StringBuilder sb = new StringBuilder(this.height * (i + 1));
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.height) {
                return sb.toString();
            }
            bArr = getRow(i3, bArr);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < this.width) {
                    int i6 = bArr[i5] & 255;
                    sb.append(i6 < 64 ? '#' : i6 < 128 ? '+' : i6 < 192 ? '.' : ' ');
                    i4 = i5 + 1;
                }
            }
            sb.append('\n');
            i2 = i3 + 1;
        }
    }
}
