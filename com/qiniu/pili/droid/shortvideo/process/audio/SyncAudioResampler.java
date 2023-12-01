package com.qiniu.pili.droid.shortvideo.process.audio;

import android.media.MediaFormat;
import com.qiniu.pili.droid.shortvideo.core.a;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.f;
import com.qiniu.pili.droid.shortvideo.f.h;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/audio/SyncAudioResampler.class */
public class SyncAudioResampler {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f14100a = h.a().c();
    private b n;
    private boolean o;
    private int q;
    private int r;
    private String s;
    private long mResamplerId = 0;
    private volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f14101c = false;
    private volatile boolean d = false;
    private volatile boolean e = false;
    private long f = 0;
    private long g = 0;
    private long h = 0;
    private int i = 0;
    private int j = 0;
    private boolean k = false;
    private double l = 1.0d;
    private com.qiniu.pili.droid.shortvideo.core.a m = new com.qiniu.pili.droid.shortvideo.core.a();
    private Object p = new Object();

    private void e() {
        b bVar = this.n;
        if (bVar != null) {
            if (!bVar.c()) {
                e eVar = e.r;
                eVar.c("SyncAudioResampler", "stopExtractor : already stop, release native " + this.s);
                release();
                this.d = false;
                this.f14101c = false;
            }
            this.n = null;
        }
        e eVar2 = e.r;
        eVar2.c("SyncAudioResampler", "stopExtractor : " + this.s);
    }

    private native boolean init(int i, int i2, int i3, int i4, int i5);

    private native int read(ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean release();

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean write(ByteBuffer byteBuffer, int i, long j, boolean z);

    public int a(ByteBuffer byteBuffer) {
        if (!this.b) {
            e.r.c("resample not started or canceled !");
            return -1;
        }
        int read = read(byteBuffer);
        if (read <= 0) {
            this.e = true;
            return -1;
        }
        long j = this.h + read;
        this.h = j;
        this.f = ((int) ((((((float) (j * 1000000)) * 8.0f) / 16.0f) / this.i) / this.j)) + this.g;
        e eVar = e.r;
        eVar.a("getSampleData, ts = " + this.f);
        return read;
    }

    public void a() {
        e eVar = e.r;
        eVar.c("SyncAudioResampler", "cancel +" + this.s);
        this.f14101c = true;
        e();
        this.b = false;
        e eVar2 = e.r;
        eVar2.c("SyncAudioResampler", "cancel - " + this.s);
    }

    public void a(double d) {
        this.l = d;
        this.m.a(d);
        this.m.a(new a.InterfaceC0573a() { // from class: com.qiniu.pili.droid.shortvideo.process.audio.SyncAudioResampler.1
            @Override // com.qiniu.pili.droid.shortvideo.core.a.InterfaceC0573a
            public void a(ByteBuffer byteBuffer, int i, long j) {
                SyncAudioResampler.this.write(byteBuffer, i, j, false);
            }
        });
    }

    public void a(boolean z) {
        this.k = z;
    }

    public boolean a(String str, long j, long j2, int i, int i2, int i3) {
        if (!f14100a) {
            e.r.c("can't found pldroid_amix.so !");
            return false;
        } else if (this.b) {
            e.r.c("resample already started !");
            return false;
        } else if (i <= 0 || i2 <= 0 || i3 <= 0) {
            e.r.d("invalid params !");
            return false;
        } else {
            this.f14101c = false;
            this.d = false;
            this.e = false;
            this.g = j > 0 ? j : 0L;
            this.h = 0L;
            this.i = i;
            this.j = i2;
            this.s = str;
            final f fVar = new f(str, false, true);
            b bVar = new b(fVar.d(), fVar.f());
            this.n = bVar;
            bVar.a(str);
            this.n.a(new b.c() { // from class: com.qiniu.pili.droid.shortvideo.process.audio.SyncAudioResampler.2
                @Override // com.qiniu.pili.droid.shortvideo.d.b.c
                public void a(ByteBuffer byteBuffer, int i4, long j3, long j4, boolean z) {
                    if (SyncAudioResampler.this.f14101c || SyncAudioResampler.this.d) {
                        return;
                    }
                    if (!z) {
                        SyncAudioResampler.this.m.c(byteBuffer, i4, j3);
                        return;
                    }
                    SyncAudioResampler syncAudioResampler = SyncAudioResampler.this;
                    syncAudioResampler.write(byteBuffer, i4, (long) (j3 / syncAudioResampler.l), z);
                }
            });
            this.n.a(new b.d() { // from class: com.qiniu.pili.droid.shortvideo.process.audio.SyncAudioResampler.3
                @Override // com.qiniu.pili.droid.shortvideo.d.b.d
                public void a(MediaFormat mediaFormat) {
                    SyncAudioResampler.this.q = mediaFormat.containsKey(MediaFormat.KEY_SAMPLE_RATE) ? mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE) : fVar.o();
                    SyncAudioResampler.this.r = mediaFormat.containsKey(MediaFormat.KEY_CHANNEL_COUNT) ? mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT) : fVar.n();
                    synchronized (SyncAudioResampler.this.p) {
                        SyncAudioResampler.this.o = true;
                        SyncAudioResampler.this.p.notify();
                    }
                }
            });
            this.n.a(new b.InterfaceC0574b() { // from class: com.qiniu.pili.droid.shortvideo.process.audio.SyncAudioResampler.4
                @Override // com.qiniu.pili.droid.shortvideo.d.b.InterfaceC0574b
                public void a() {
                    if (SyncAudioResampler.this.f14101c || SyncAudioResampler.this.d) {
                        SyncAudioResampler.this.release();
                        SyncAudioResampler.this.d = false;
                        SyncAudioResampler.this.f14101c = false;
                        e eVar = e.r;
                        eVar.c("SyncAudioResampler", "onExtractorStop : release native " + SyncAudioResampler.this.s);
                    }
                    e eVar2 = e.r;
                    eVar2.c("SyncAudioResampler", "onExtractorStop " + SyncAudioResampler.this.s);
                }
            });
            this.n.a(j, j2);
            this.n.a(this.k);
            synchronized (this.p) {
                while (!this.o) {
                    try {
                        this.p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (!init(this.q, this.r, i, i2, i3)) {
                e.r.d("failed to init !");
                return false;
            }
            this.b = true;
            e eVar = e.r;
            eVar.b("audio resample started: " + str);
            return true;
        }
    }

    public void b() {
        e eVar = e.r;
        eVar.c("SyncAudioResampler", "destroy +" + this.s);
        this.d = true;
        e();
        this.b = false;
        e eVar2 = e.r;
        eVar2.c("SyncAudioResampler", "destroy -" + this.s);
    }

    public boolean c() {
        return this.e;
    }

    public long d() {
        return this.f;
    }
}
