package com.qiniu.pili.droid.shortvideo.transcoder.audio;

import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.h;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/transcoder/audio/AudioMixer.class */
public class AudioMixer {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f14120a = h.a().c();
    private AudioTransformer b;

    /* renamed from: c  reason: collision with root package name */
    private ByteBuffer f14121c;
    private float d = 1.0f;
    private float e = 1.0f;
    private long f = 0;
    private long g = 0;

    private native void destroy(long j);

    private native long init(int i);

    private native boolean mix(long j, ByteBuffer byteBuffer, int i, float f, ByteBuffer byteBuffer2, int i2, float f2, ByteBuffer byteBuffer3, int i3, int i4, int i5);

    public void a(float f, float f2) {
        this.d = f;
        this.e = f2;
    }

    public boolean a() {
        if (!f14120a) {
            e.q.e("AudioMixer", "AudioMixer is not available");
            return false;
        }
        this.b.destroy(this.g);
        this.b = null;
        this.g = 0L;
        this.f14121c = null;
        destroy(this.f);
        this.f = 0L;
        return true;
    }

    public boolean a(int i, int i2, int i3, int i4) {
        if (!f14120a) {
            e.q.e("AudioMixer", "AudioMixer is not available");
            return false;
        }
        e eVar = e.q;
        eVar.c("AudioMixer", "main parameters sampleRate:" + i + " channels:" + i2);
        e eVar2 = e.q;
        eVar2.c("AudioMixer", "music parameters sampleRate:" + i3 + " channels:" + i4);
        AudioTransformer audioTransformer = new AudioTransformer();
        this.b = audioTransformer;
        this.g = audioTransformer.init(i3, i4, 16, i, i2, 16);
        return true;
    }

    public boolean a(ByteBuffer byteBuffer, int i) {
        if (!f14120a) {
            e.q.e("AudioMixer", "AudioMixer is not available");
            return true;
        }
        if (this.f == 0) {
            this.f = init(byteBuffer.capacity());
            e eVar = e.q;
            eVar.c("AudioMixer", "init AudioMixer with buffer size: " + byteBuffer.capacity());
        }
        if (this.f14121c == null) {
            this.f14121c = ByteBuffer.allocateDirect(byteBuffer.capacity() * 4);
            e eVar2 = e.q;
            eVar2.c("AudioMixer", "init mResampledMainFramesBuffer with size: " + this.f14121c.capacity());
        }
        if (this.f14121c.position() < i) {
            e eVar3 = e.q;
            eVar3.b("AudioMixer", "not enough frames in buffer, remaining: " + this.f14121c.position() + " require: " + i);
            return false;
        }
        mix(this.f, byteBuffer, 0, this.d, this.f14121c, 0, this.e, byteBuffer, 0, 16, i);
        int position = this.f14121c.position();
        int i2 = position - i;
        this.f14121c.clear();
        ByteBuffer byteBuffer2 = this.f14121c;
        byteBuffer2.put(byteBuffer2.array(), this.f14121c.arrayOffset() + i, i2);
        e eVar4 = e.q;
        eVar4.b("AudioMixer", "mixed frames with buffer, origin: " + position + " remaining: " + i2 + " consumed: " + i);
        return true;
    }

    public void b(ByteBuffer byteBuffer, int i) {
        if (!f14120a) {
            e.q.e("AudioMixer", "AudioMixer is not available");
            return;
        }
        AudioTransformer audioTransformer = this.b;
        long j = this.g;
        int position = byteBuffer.position();
        ByteBuffer byteBuffer2 = this.f14121c;
        int resample = audioTransformer.resample(j, byteBuffer, position, i, byteBuffer2, byteBuffer2.position(), 0);
        ByteBuffer byteBuffer3 = this.f14121c;
        byteBuffer3.position(byteBuffer3.position() + resample);
        e eVar = e.q;
        eVar.b("AudioMixer", "resample music frames: " + i + " to main frames: " + resample + " and saved");
    }
}
