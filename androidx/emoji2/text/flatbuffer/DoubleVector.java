package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/DoubleVector.class */
public final class DoubleVector extends BaseVector {
    public DoubleVector __assign(int i, ByteBuffer byteBuffer) {
        a(i, 8, byteBuffer);
        return this;
    }

    public double get(int i) {
        return this.f2801a.getDouble(a(i));
    }
}
