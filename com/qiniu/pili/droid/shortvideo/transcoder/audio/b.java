package com.qiniu.pili.droid.shortvideo.transcoder.audio;

import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.h;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/transcoder/audio/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f27812a = h.a().c();
    private AudioTransformer b;

    /* renamed from: c  reason: collision with root package name */
    private ByteBuffer f27813c;
    private a d;
    private int e = 0;
    private long f = 0;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/transcoder/audio/b$a.class */
    public interface a {
        void a(ByteBuffer byteBuffer, int i);
    }

    public void a() {
        if (!f27812a) {
            e.r.e("AudioResampler", "AudioResampler is not available");
            return;
        }
        AudioTransformer audioTransformer = this.b;
        if (audioTransformer != null) {
            audioTransformer.destroy(this.f);
            this.b = null;
            this.f = 0L;
            this.f27813c.clear();
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (!f27812a) {
            e.r.e("AudioResampler", "AudioResampler is not available");
            return;
        }
        AudioTransformer audioTransformer = new AudioTransformer();
        this.b = audioTransformer;
        this.f = audioTransformer.init(i, i2, i3, i4, i5, i6);
        this.e = 2048 * i5;
        e eVar = e.r;
        eVar.c("AudioResampler", "from parameters sampleRate:" + i + " channels:" + i2);
        e eVar2 = e.r;
        eVar2.c("AudioResampler", "to parameters sampleRate:" + i4 + " channels:" + i5);
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void a(ByteBuffer byteBuffer, int i, int i2) {
        if (!f27812a) {
            e.r.e("AudioResampler", "AudioResampler is not available");
            return;
        }
        if (this.f27813c == null) {
            this.f27813c = ByteBuffer.allocateDirect(byteBuffer.capacity() * 4);
            e eVar = e.q;
            eVar.c("AudioResampler", "init mResampledFramesBuffer with size: " + byteBuffer.capacity());
        }
        AudioTransformer audioTransformer = this.b;
        long j = this.f;
        ByteBuffer byteBuffer2 = this.f27813c;
        int resample = audioTransformer.resample(j, byteBuffer, i, i2, byteBuffer2, byteBuffer2.position(), 0);
        ByteBuffer byteBuffer3 = this.f27813c;
        byteBuffer3.position(byteBuffer3.position() + resample);
        while (this.f27813c.position() >= this.e) {
            int position = this.f27813c.position();
            int i3 = this.e;
            this.f27813c.flip();
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(this.f27813c, this.e);
            }
            this.f27813c.clear();
            ByteBuffer byteBuffer4 = this.f27813c;
            byteBuffer4.put(byteBuffer4.array(), this.f27813c.arrayOffset() + this.e, position - i3);
        }
    }
}
