package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/Struct.class */
public class Struct {

    /* renamed from: a  reason: collision with root package name */
    protected int f2822a;
    protected ByteBuffer b;

    public void __reset() {
        a(0, null);
    }

    protected void a(int i, ByteBuffer byteBuffer) {
        this.b = byteBuffer;
        if (byteBuffer != null) {
            this.f2822a = i;
        } else {
            this.f2822a = 0;
        }
    }
}
