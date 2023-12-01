package a.a.a.a.a.a.e.e;

import a.a.a.a.a.a.e.c;
import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.av.encoder.PLAACEncoder;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/e/e/b.class */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public Object f1224a = new Object();
    public volatile PLAACEncoder b = null;

    /* renamed from: c  reason: collision with root package name */
    public volatile a f1225c;
    public ByteBuffer d;

    @Override // a.a.a.a.a.a.e.c
    public void a() {
        e.f.c("SoftMicrophoneTransfer", "stopEncoding");
        synchronized (this.f1224a) {
            if (this.f1225c != null) {
                this.f1225c.a();
                this.f1225c.a(true);
                this.f1225c.b();
                this.f1225c = null;
                this.b = null;
            }
        }
    }

    @Override // a.a.a.a.a.a.e.c
    public void a(a.a.a.a.a.a.i.c cVar) {
        e.f.c("SoftMicrophoneTransfer", "startEncoding");
        synchronized (this.f1224a) {
            this.f1225c = new a(cVar);
            this.b = this.f1225c.d();
        }
    }

    @Override // a.a.a.a.a.a.e.c
    public void a(ByteBuffer byteBuffer, int i, long j, boolean z) {
        synchronized (this.f1224a) {
            if (this.b != null) {
                this.b.encode(byteBuffer, i, j);
            }
        }
    }

    @Override // a.a.a.a.a.a.e.c
    public void a(byte[] bArr, long j, boolean z) {
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer == null || byteBuffer.capacity() < bArr.length) {
            this.d = ByteBuffer.allocateDirect(bArr.length);
        }
        this.d.clear();
        this.d.put(bArr);
        a(this.d, bArr.length, j, z);
    }
}
