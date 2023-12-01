package com.tencent.tinker.android.dx.instruction;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dx/instruction/ShortArrayCodeOutput.class */
public final class ShortArrayCodeOutput extends CodeCursor {
    private short[] array;

    public ShortArrayCodeOutput(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("initSize < 0");
        }
        this.array = new short[i];
    }

    public ShortArrayCodeOutput(short[] sArr) {
        if (sArr == null) {
            throw new IllegalArgumentException("array is null.");
        }
        this.array = sArr;
    }

    private void ensureArrayLength(int i) {
        int cursor = cursor();
        short[] sArr = this.array;
        if (sArr.length - cursor < i) {
            short[] sArr2 = new short[sArr.length + (sArr.length >> 1)];
            System.arraycopy((Object) sArr, 0, (Object) sArr2, 0, cursor);
            this.array = sArr2;
        }
    }

    public short[] getArray() {
        int cursor = cursor();
        short[] sArr = this.array;
        if (cursor == sArr.length) {
            return sArr;
        }
        short[] sArr2 = new short[cursor];
        System.arraycopy((Object) sArr, 0, (Object) sArr2, 0, cursor);
        return sArr2;
    }

    public void write(short s) {
        ensureArrayLength(1);
        this.array[cursor()] = s;
        advance(1);
    }

    public void write(short s, short s2) {
        write(s);
        write(s2);
    }

    public void write(short s, short s2, short s3) {
        write(s);
        write(s2);
        write(s3);
    }

    public void write(short s, short s2, short s3, short s4) {
        write(s);
        write(s2);
        write(s3);
        write(s4);
    }

    public void write(short s, short s2, short s3, short s4, short s5) {
        write(s);
        write(s2);
        write(s3);
        write(s4);
        write(s5);
    }

    public void write(byte[] bArr) {
        boolean z;
        boolean z2 = true;
        int i = 0;
        for (byte b : bArr) {
            if (z2) {
                i = b & 255;
                z = false;
            } else {
                i = (b << 8) | i;
                write((short) i);
                z = true;
            }
            z2 = z;
        }
        if (z2) {
            return;
        }
        write((short) i);
    }

    public void write(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            writeInt(iArr[i2]);
            i = i2 + 1;
        }
    }

    public void write(long[] jArr) {
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            writeLong(jArr[i2]);
            i = i2 + 1;
        }
    }

    public void write(short[] sArr) {
        int length = sArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            write(sArr[i2]);
            i = i2 + 1;
        }
    }

    public void writeInt(int i) {
        write((short) i);
        write((short) (i >> 16));
    }

    public void writeLong(long j) {
        write((short) j);
        write((short) (j >> 16));
        write((short) (j >> 32));
        write((short) (j >> 48));
    }
}
