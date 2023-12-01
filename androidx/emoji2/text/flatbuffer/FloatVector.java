package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/FloatVector.class */
public final class FloatVector extends BaseVector {
    public FloatVector __assign(int i, ByteBuffer byteBuffer) {
        a(i, 4, byteBuffer);
        return this;
    }

    public float get(int i) {
        return this.f2849a.getFloat(a(i));
    }
}
