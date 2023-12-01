package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/StringVector.class */
public final class StringVector extends BaseVector {
    private Utf8 b = Utf8.getDefault();

    public StringVector __assign(int i, int i2, ByteBuffer byteBuffer) {
        a(i, i2, byteBuffer);
        return this;
    }

    public String get(int i) {
        return Table.a(a(i), this.f2849a, this.b);
    }
}
