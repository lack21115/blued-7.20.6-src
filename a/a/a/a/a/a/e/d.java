package a.a.a.a.a.a.e;

import a.a.a.a.a.e.e;
import android.media.MediaCodec;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/e/d.class */
public class d extends c {

    /* renamed from: a  reason: collision with root package name */
    public MediaCodec f1175a = null;
    public volatile b b;

    @Override // a.a.a.a.a.a.e.c
    public void a() {
        if (this.b != null) {
            this.b.a();
            this.b.a(true);
            this.b.b();
        }
    }

    @Override // a.a.a.a.a.a.e.c
    public void a(a.a.a.a.a.a.i.c cVar) {
        e.f.c("MicrophoneTransfer", "startRecording");
        this.b = new b(cVar);
        this.f1175a = this.b.c();
    }

    @Override // a.a.a.a.a.a.e.c
    public void a(ByteBuffer byteBuffer, int i, long j, boolean z) {
        a(byteBuffer, i, null, j, z);
    }

    public final void a(ByteBuffer byteBuffer, int i, byte[] bArr, long j, boolean z) {
        if (this.b == null) {
            return;
        }
        if (!z) {
            try {
                this.b.a(z);
            } catch (Throwable th) {
                e.f.e("MicrophoneTransfer", "_offerAudioEncoder exception");
                th.printStackTrace();
                return;
            }
        }
        ByteBuffer[] inputBuffers = this.f1175a.getInputBuffers();
        int dequeueInputBuffer = this.f1175a.dequeueInputBuffer(-1L);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
            byteBuffer2.clear();
            if (byteBuffer != null) {
                byteBuffer.position(0);
                byteBuffer.limit(i);
                byteBuffer2.put(byteBuffer);
            } else if (bArr == null) {
                throw new IllegalStateException("Illegal buffer state.");
            } else {
                byteBuffer2.put(bArr);
                i = bArr.length;
            }
            if (!z) {
                this.f1175a.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
                return;
            }
            e.f.a("MicrophoneTransfer", "EOS received in sendAudioToEncoder");
            this.f1175a.queueInputBuffer(dequeueInputBuffer, 0, i, j, 4);
        }
    }

    @Override // a.a.a.a.a.a.e.c
    public void a(byte[] bArr, long j, boolean z) {
        a(null, 0, bArr, j, z);
    }
}
