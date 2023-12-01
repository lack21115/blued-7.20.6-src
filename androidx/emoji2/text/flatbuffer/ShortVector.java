package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/ShortVector.class */
public final class ShortVector extends BaseVector {
    public ShortVector __assign(int i, ByteBuffer byteBuffer) {
        a(i, 2, byteBuffer);
        return this;
    }

    public short get(int i) {
        return this.f2801a.getShort(a(i));
    }

    public int getAsUnsigned(int i) {
        return get(i) & 65535;
    }
}
