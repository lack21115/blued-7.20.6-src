package com.qiniu.pili.droid.streaming.microphone;

import a.a.a.a.a.d.b;
import a.a.a.a.a.e.e;
import a.a.a.a.a.g.a;
import com.qiniu.pili.droid.streaming.SharedLibraryNameHelper;
import com.qiniu.pili.droid.streaming.microphone.OnAudioMixListener;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/microphone/AudioMixer.class */
public class AudioMixer {
    public static final boolean s = SharedLibraryNameHelper.getInstance().b();

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f14157c;
    public ByteBuffer d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public OnAudioMixListener p;

    /* renamed from: a  reason: collision with root package name */
    public a f14156a = new a();
    public AudioTransformer b = new AudioTransformer();
    public float n = 1.0f;
    public float o = 1.0f;
    public long q = 0;
    public long r = 0;

    public final int a(int i) {
        return (int) (((i * 1.0d) / this.j) * this.i);
    }

    public void a() {
        synchronized (this) {
            e.h.c("PLAudioMixer", "amix destroy");
            stop();
            this.f14156a.h();
            this.b.destroy(this.r);
            destroy(this.q);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (!SharedLibraryNameHelper.b(true)) {
            e.h.e("PLAudioMixer", "init failed : audio mix so load unsuccessfully !");
            return;
        }
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = i * i2 * (i3 / 8);
        e eVar = e.h;
        eVar.c("PLAudioMixer", "incoming data parameters will be sampleRate:" + i + " channels:" + i2 + " sampleSize:" + i3 + " maxBytes:" + i4 + " bytesPerSecond:" + this.i);
        this.q = init(i4);
    }

    public void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        int limit;
        synchronized (this) {
            while (this.d.remaining() < i) {
                ByteBuffer f = this.f14156a.f();
                if (f != null) {
                    int remaining = f.remaining();
                    ByteBuffer byteBuffer3 = this.f14157c;
                    if (byteBuffer3 != null && byteBuffer3.capacity() >= remaining) {
                        this.f14157c.clear();
                        this.f14157c.put(f);
                        this.f14157c.flip();
                        AudioTransformer audioTransformer = this.b;
                        long j = this.r;
                        ByteBuffer byteBuffer4 = this.f14157c;
                        int position = byteBuffer4.position();
                        ByteBuffer byteBuffer5 = this.d;
                        limit = audioTransformer.resample(j, byteBuffer4, position, remaining, byteBuffer5, byteBuffer5.limit());
                    }
                    this.f14157c = ByteBuffer.allocateDirect(remaining);
                    this.f14157c.put(f);
                    this.f14157c.flip();
                    AudioTransformer audioTransformer2 = this.b;
                    long j2 = this.r;
                    ByteBuffer byteBuffer42 = this.f14157c;
                    int position2 = byteBuffer42.position();
                    ByteBuffer byteBuffer52 = this.d;
                    limit = audioTransformer2.resample(j2, byteBuffer42, position2, remaining, byteBuffer52, byteBuffer52.limit());
                } else {
                    e.h.c("PLAudioMixer", "returns null means EOF, stop it.");
                    stop();
                    OnAudioMixListener onAudioMixListener = this.p;
                    if (onAudioMixListener != null) {
                        onAudioMixListener.onStatusChanged(OnAudioMixListener.MixStatus.Finish);
                    }
                    limit = i - this.d.limit();
                }
                ByteBuffer byteBuffer6 = this.d;
                byteBuffer6.limit(byteBuffer6.limit() + limit);
                this.f14156a.g();
            }
            if (!this.m) {
                long j3 = this.q;
                int position3 = byteBuffer.position();
                float f2 = this.n;
                ByteBuffer byteBuffer7 = this.d;
                mix(j3, byteBuffer, position3, f2, byteBuffer7, byteBuffer7.position(), this.o, byteBuffer2, byteBuffer2.position(), this.g, i);
            }
            int remaining2 = this.d.remaining() - i;
            this.d.clear();
            if (remaining2 > 0) {
                ByteBuffer byteBuffer8 = this.d;
                byteBuffer8.put(byteBuffer8.array(), this.d.arrayOffset() + this.d.position() + i, remaining2);
            }
            this.d.flip();
        }
    }

    public void a(boolean z) {
        e.h.c("PLAudioMixer", "amix is decode only!");
        this.m = z;
    }

    public final boolean b() {
        if (!this.k) {
            e.h.d("PLAudioMixer", "file for mixing not setup yet!!!");
        }
        return this.k;
    }

    public final native void destroy(long j);

    public long getDuration() {
        return this.f14156a.b();
    }

    public final native long init(int i);

    public boolean isRunning() {
        return this.l;
    }

    public final native boolean mix(long j, ByteBuffer byteBuffer, int i, float f, ByteBuffer byteBuffer2, int i2, float f2, ByteBuffer byteBuffer3, int i3, int i4, int i5);

    public boolean pause() {
        if (b()) {
            this.l = false;
            b.q();
            return true;
        }
        return false;
    }

    public boolean play() {
        if (b()) {
            this.l = true;
            return true;
        }
        return false;
    }

    public boolean seek(float f) {
        if (b()) {
            this.f14156a.a(((float) getDuration()) * f);
            return true;
        }
        return false;
    }

    public boolean setFile(String str, boolean z) throws IOException {
        synchronized (this) {
            this.f14156a.h();
            boolean a2 = this.f14156a.a(str, z);
            boolean z2 = false;
            if (!a2) {
                e.h.e("PLAudioMixer", "setup decoder for " + str + " failed");
                return false;
            }
            int d = this.f14156a.d();
            int e = this.f14156a.e();
            int c2 = this.f14156a.c();
            this.j = d * e * (c2 / 8);
            e.h.c("PLAudioMixer", "decode data parameters will be sampleRate:" + d + " channels:" + e + " sampleSize:" + c2 + " bytesPerSecond:" + this.j);
            int a3 = a(this.f14156a.a());
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(a3 * ((int) Math.ceil((((double) this.h) * 1.0d) / ((double) a3))) * 2);
            this.d = allocateDirect;
            allocateDirect.limit(0);
            e eVar = e.h;
            StringBuilder sb = new StringBuilder();
            sb.append("mResampledFrames cap:");
            sb.append(this.d.capacity());
            eVar.c("PLAudioMixer", sb.toString());
            long init = this.b.init(d, e, c2, this.e, this.f, this.g);
            this.r = init;
            if (init != -1) {
                z2 = true;
            }
            this.k = z2;
            b.p();
            return this.k;
        }
    }

    public void setOnAudioMixListener(OnAudioMixListener onAudioMixListener) {
        this.p = onAudioMixListener;
        this.f14156a.a(onAudioMixListener);
    }

    public void setVolume(float f, float f2) {
        this.n = f;
        this.o = f2;
    }

    public boolean stop() {
        if (pause()) {
            this.f14156a.a(0L);
            return true;
        }
        return false;
    }
}
