package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/ByteVector.class */
public final class ByteVector extends BaseVector {
    public ByteVector __assign(int i, ByteBuffer byteBuffer) {
        a(i, 1, byteBuffer);
        return this;
    }

    public byte get(int i) {
        return this.f2801a.get(a(i));
    }

    public int getAsUnsigned(int i) {
        return get(i) & 255;
    }
}
