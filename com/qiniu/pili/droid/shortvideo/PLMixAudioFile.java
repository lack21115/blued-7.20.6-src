package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.e.a;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.g;
import com.qiniu.pili.droid.shortvideo.f.j;
import com.qiniu.pili.droid.shortvideo.process.audio.SyncAudioResampler;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.d;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLMixAudioFile.class */
public class PLMixAudioFile {

    /* renamed from: a  reason: collision with root package name */
    private String f13805a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f13806c;
    private long d;
    private float e;
    private long f;
    private double g;
    private boolean h;
    private boolean i;
    private SyncAudioResampler j;
    private ByteBuffer k;
    private a l;

    public PLMixAudioFile(String str) throws IOException {
        this(str, true);
    }

    public PLMixAudioFile(String str, boolean z) {
        this.b = 0L;
        this.f13806c = 0L;
        this.d = 0L;
        this.e = 1.0f;
        this.f = 0L;
        this.g = 1.0d;
        this.h = false;
        this.i = true;
        this.f13805a = str;
        long a2 = g.a((Object) str) * 1000;
        this.d = a2;
        this.f = a2;
        if (z) {
            h();
        }
    }

    private void g() {
        d dVar = new d(this.f13806c / 1000, this.d / 1000);
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(dVar);
        }
    }

    private void h() {
        a aVar = new a();
        this.l = aVar;
        aVar.a(this.f13805a);
        this.l.a(this.e);
        this.l.a(this.h);
    }

    public a a() {
        return this.l;
    }

    public boolean a(long j) {
        boolean z = j < this.b;
        long j2 = this.f;
        return (z || ((j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) != 0 && (j > (this.b + j2) ? 1 : (j == (this.b + j2) ? 0 : -1)) > 0)) ? false : true;
    }

    public long b(long j) {
        long j2 = (j - this.b) / 1000;
        long j3 = this.d - this.f13806c;
        long j4 = 0;
        if (j3 > 0) {
            j4 = j2 % (j3 / 1000);
        }
        return (this.f13806c / 1000) + j4;
    }

    public SyncAudioResampler b() {
        if (this.j == null) {
            SyncAudioResampler syncAudioResampler = new SyncAudioResampler();
            this.j = syncAudioResampler;
            syncAudioResampler.a(this.g);
            if (this.h) {
                this.j.a(true);
            }
        }
        return this.j;
    }

    public void c() {
        SyncAudioResampler syncAudioResampler = this.j;
        if (syncAudioResampler != null) {
            syncAudioResampler.b();
            this.j = null;
        }
    }

    public void d() {
        SyncAudioResampler syncAudioResampler = this.j;
        if (syncAudioResampler != null) {
            syncAudioResampler.a();
            this.j = null;
        }
    }

    public ByteBuffer e() {
        if (this.k == null) {
            this.k = ByteBuffer.allocateDirect(2048);
        }
        return this.k;
    }

    public boolean f() {
        return this.i;
    }

    public long getEndTime() {
        return this.d;
    }

    public String getFilepath() {
        return this.f13805a;
    }

    public long getOffsetInVideo() {
        return this.b;
    }

    public long getStartTime() {
        return this.f13806c;
    }

    public float getVolume() {
        return this.e;
    }

    public boolean isLooping() {
        return this.h;
    }

    public PLMixAudioFile setDurationInVideo(long j) {
        this.f = j;
        return this;
    }

    public PLMixAudioFile setEndTime(long j) {
        if (j < this.f13806c) {
            e.q.e("PLMixAudioFile", "end time must bigger than start time !");
            return this;
        }
        this.d = j;
        g();
        return this;
    }

    public PLMixAudioFile setLooping(boolean z) {
        this.h = z;
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(z);
        }
        return this;
    }

    public void setNeedUpdatePosition(boolean z) {
        this.i = z;
    }

    public PLMixAudioFile setOffsetInVideo(long j) {
        this.b = j;
        return this;
    }

    public PLMixAudioFile setSpeed(double d) {
        if (j.a(d)) {
            e eVar = e.q;
            eVar.c("PLMixAudioFile", "set speed to: " + d);
            this.g = d;
            SyncAudioResampler syncAudioResampler = this.j;
            if (syncAudioResampler != null) {
                syncAudioResampler.a(d);
                return this;
            }
        } else {
            e.q.d("PLMixAudioFile", "only support multiple of 2 !!!");
        }
        return this;
    }

    public PLMixAudioFile setStartTime(long j) {
        this.f13806c = j;
        g();
        return this;
    }

    public PLMixAudioFile setVolume(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("The volume range is 0.0f~1.0f !");
        }
        this.e = f;
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(f);
        }
        return this;
    }
}
