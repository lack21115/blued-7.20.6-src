package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/LongVector.class */
public final class LongVector extends BaseVector {
    public LongVector __assign(int i, ByteBuffer byteBuffer) {
        a(i, 8, byteBuffer);
        return this;
    }

    public long get(int i) {
        return this.f2849a.getLong(a(i));
    }
}
