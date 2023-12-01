package com.tencent.tinker.android.dx.instruction;

import java.io.EOFException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/android/dx/instruction/ShortArrayCodeInput.class */
public final class ShortArrayCodeInput extends CodeCursor {
    private final short[] array;

    public ShortArrayCodeInput(short[] sArr) {
        if (sArr == null) {
            throw new NullPointerException("array == null");
        }
        this.array = sArr;
    }

    public boolean hasMore() {
        return cursor() < this.array.length;
    }

    public int read() throws EOFException {
        try {
            short s = this.array[cursor()];
            advance(1);
            return s & 65535;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new EOFException();
        }
    }

    public int readInt() throws EOFException {
        return read() | (read() << 16);
    }

    public long readLong() throws EOFException {
        return read() | (read() << 16) | (read() << 32) | (read() << 48);
    }
}
