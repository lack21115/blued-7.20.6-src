package java.nio;

import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:java/nio/FloatBuffer.class */
public abstract class FloatBuffer extends Buffer implements Comparable<FloatBuffer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatBuffer(int i, long j) {
        super(2, i, j);
    }

    public static FloatBuffer allocate(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity < 0: " + i);
        }
        return new FloatArrayBuffer(new float[i]);
    }

    public static FloatBuffer wrap(float[] fArr) {
        return wrap(fArr, 0, fArr.length);
    }

    public static FloatBuffer wrap(float[] fArr, int i, int i2) {
        Arrays.checkOffsetAndCount(fArr.length, i, i2);
        FloatArrayBuffer floatArrayBuffer = new FloatArrayBuffer(fArr);
        floatArrayBuffer.position = i;
        floatArrayBuffer.limit = i + i2;
        return floatArrayBuffer;
    }

    @Override // java.nio.Buffer
    public final float[] array() {
        return protectedArray();
    }

    @Override // java.nio.Buffer
    public final int arrayOffset() {
        return protectedArrayOffset();
    }

    public abstract FloatBuffer asReadOnlyBuffer();

    public abstract FloatBuffer compact();

    @Override // java.lang.Comparable
    public int compareTo(FloatBuffer floatBuffer) {
        int i = this.position;
        int i2 = floatBuffer.position;
        for (int remaining = remaining() < floatBuffer.remaining() ? remaining() : floatBuffer.remaining(); remaining > 0; remaining--) {
            float f = get(i);
            float f2 = floatBuffer.get(i2);
            if (f != f2 && (f == f || f2 == f2)) {
                return f < f2 ? -1 : 1;
            }
            i++;
            i2++;
        }
        return remaining() - floatBuffer.remaining();
    }

    public abstract FloatBuffer duplicate();

    public boolean equals(Object obj) {
        if (obj instanceof FloatBuffer) {
            FloatBuffer floatBuffer = (FloatBuffer) obj;
            if (remaining() == floatBuffer.remaining()) {
                int i = floatBuffer.position;
                boolean z = true;
                for (int i2 = this.position; z && i2 < this.limit; i2++) {
                    float f = get(i2);
                    float f2 = floatBuffer.get(i);
                    z = f == f2 || !(f == f || f2 == f2);
                    i++;
                }
                return z;
            }
            return false;
        }
        return false;
    }

    public abstract float get();

    public abstract float get(int i);

    public FloatBuffer get(float[] fArr) {
        return get(fArr, 0, fArr.length);
    }

    public FloatBuffer get(float[] fArr, int i, int i2) {
        Arrays.checkOffsetAndCount(fArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferUnderflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            fArr[i4] = get();
            i3 = i4 + 1;
        }
    }

    @Override // java.nio.Buffer
    public final boolean hasArray() {
        return protectedHasArray();
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = this.position; i2 < this.limit; i2++) {
            i += Float.floatToIntBits(get(i2));
        }
        return i;
    }

    @Override // java.nio.Buffer
    public abstract boolean isDirect();

    public abstract ByteOrder order();

    abstract float[] protectedArray();

    abstract int protectedArrayOffset();

    abstract boolean protectedHasArray();

    public abstract FloatBuffer put(float f);

    public abstract FloatBuffer put(int i, float f);

    public FloatBuffer put(FloatBuffer floatBuffer) {
        if (isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (floatBuffer == this) {
            throw new IllegalArgumentException("src == this");
        }
        if (floatBuffer.remaining() > remaining()) {
            throw new BufferOverflowException();
        }
        float[] fArr = new float[floatBuffer.remaining()];
        floatBuffer.get(fArr);
        put(fArr);
        return this;
    }

    public final FloatBuffer put(float[] fArr) {
        return put(fArr, 0, fArr.length);
    }

    public FloatBuffer put(float[] fArr, int i, int i2) {
        Arrays.checkOffsetAndCount(fArr.length, i, i2);
        if (i2 > remaining()) {
            throw new BufferOverflowException();
        }
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i + i2) {
                return this;
            }
            put(fArr[i4]);
            i3 = i4 + 1;
        }
    }

    public abstract FloatBuffer slice();
}
