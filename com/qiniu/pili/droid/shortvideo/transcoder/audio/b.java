package com.qiniu.pili.droid.shortvideo.transcoder.audio;

import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.h;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/transcoder/audio/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f14124a = h.a().c();
    private AudioTransformer b;

    /* renamed from: c  reason: collision with root package name */
    private ByteBuffer f14125c;
    private a d;
    private int e = 0;
    private long f = 0;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/transcoder/audio/b$a.class */
    public interface a {
        void a(ByteBuffer byteBuffer, int i);
    }

    public void a() {
        if (!f14124a) {
            e.r.e("AudioResampler", "AudioResampler is not available");
            return;
        }
        AudioTransformer audioTransformer = this.b;
        if (audioTransformer != null) {
            audioTransformer.destroy(this.f);
            this.b = null;
            this.f = 0L;
            this.f14125c.clear();
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (!f14124a) {
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
        if (!f14124a) {
            e.r.e("AudioResampler", "AudioResampler is not available");
            return;
        }
        if (this.f14125c == null) {
            this.f14125c = ByteBuffer.allocateDirect(byteBuffer.capacity() * 4);
            e eVar = e.q;
            eVar.c("AudioResampler", "init mResampledFramesBuffer with size: " + byteBuffer.capacity());
        }
        AudioTransformer audioTransformer = this.b;
        long j = this.f;
        ByteBuffer byteBuffer2 = this.f14125c;
        int resample = audioTransformer.resample(j, byteBuffer, i, i2, byteBuffer2, byteBuffer2.position(), 0);
        ByteBuffer byteBuffer3 = this.f14125c;
        byteBuffer3.position(byteBuffer3.position() + resample);
        while (this.f14125c.position() >= this.e) {
            int position = this.f14125c.position();
            int i3 = this.e;
            this.f14125c.flip();
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(this.f14125c, this.e);
            }
            this.f14125c.clear();
            ByteBuffer byteBuffer4 = this.f14125c;
            byteBuffer4.put(byteBuffer4.array(), this.f14125c.arrayOffset() + this.e, position - i3);
        }
    }
}
