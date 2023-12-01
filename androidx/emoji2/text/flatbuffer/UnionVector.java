package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/UnionVector.class */
public final class UnionVector extends BaseVector {
    public UnionVector __assign(int i, int i2, ByteBuffer byteBuffer) {
        a(i, i2, byteBuffer);
        return this;
    }

    public Table get(Table table, int i) {
        return Table.a(table, a(i), this.f2801a);
    }
}
