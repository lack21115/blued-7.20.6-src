package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/BooleanVector.class */
public final class BooleanVector extends BaseVector {
    public BooleanVector __assign(int i, ByteBuffer byteBuffer) {
        a(i, 1, byteBuffer);
        return this;
    }

    public boolean get(int i) {
        return this.f2801a.get(a(i)) != 0;
    }
}
