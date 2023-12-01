package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/BaseVector.class */
public class BaseVector {

    /* renamed from: a  reason: collision with root package name */
    protected ByteBuffer f2849a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f2850c;
    private int d;

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i) {
        return this.b + (i * this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, int i2, ByteBuffer byteBuffer) {
        this.f2849a = byteBuffer;
        if (byteBuffer != null) {
            this.b = i;
            this.f2850c = byteBuffer.getInt(i - 4);
            this.d = i2;
            return;
        }
        this.b = 0;
        this.f2850c = 0;
        this.d = 0;
    }

    public int length() {
        return this.f2850c;
    }

    public void reset() {
        a(0, 0, null);
    }
}
