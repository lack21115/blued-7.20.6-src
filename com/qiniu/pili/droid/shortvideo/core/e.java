package com.qiniu.pili.droid.shortvideo.core;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.encode.a;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/e.class */
public abstract class e extends j {

    /* renamed from: a  reason: collision with root package name */
    protected volatile Surface f13856a;
    protected com.qiniu.pili.droid.shortvideo.encode.a b;

    /* renamed from: c  reason: collision with root package name */
    protected PLVideoEncodeSetting f13857c;
    protected volatile boolean d;
    protected volatile boolean e;
    protected a.InterfaceC0575a f = new a.InterfaceC0575a() { // from class: com.qiniu.pili.droid.shortvideo.core.e.1
        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(MediaFormat mediaFormat) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
            String a2 = e.this.a();
            eVar.c(a2, "got video format:" + mediaFormat.toString());
            e.this.r.a(mediaFormat);
            e.this.e = true;
            e.this.r();
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(Surface surface) {
            com.qiniu.pili.droid.shortvideo.f.e.d.c(e.this.a(), "video encode surface created");
            e.this.f13856a = surface;
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (e.this.l) {
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
                String a2 = e.this.a();
                eVar.b(a2, "video encoded frame size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
                e.this.r.a(byteBuffer, bufferInfo);
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void a(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
            String a2 = e.this.a();
            eVar.c(a2, "video encoder started: " + z);
            e.this.d = z;
            if (z) {
                e.this.b();
            } else if (e.this.s != null) {
                e.this.i = false;
                e.this.s.onError(6);
                QosManager.a().a(6);
            }
        }

        @Override // com.qiniu.pili.droid.shortvideo.encode.a.InterfaceC0575a
        public void b(boolean z) {
            com.qiniu.pili.droid.shortvideo.f.e.d.c(e.this.a(), "video encode stopped");
            e.this.d = false;
            e.this.e = false;
            e.this.s();
        }
    };

    protected abstract String a();

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public void a(boolean z) {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.d;
        String a2 = a();
        eVar.c(a2, "mute: " + z);
        this.q.a(z);
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public boolean a(String str) {
        boolean a2;
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.d.c(a(), "beginSection");
            a2 = super.a(str);
            if (a2) {
                this.b.a(this.t);
                this.b.a();
            }
        }
        return a2;
    }

    protected abstract void b();

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public boolean c() {
        boolean c2;
        synchronized (this) {
            com.qiniu.pili.droid.shortvideo.f.e.d.c(a(), "endSection");
            c2 = super.c();
            if (c2) {
                this.d = false;
                this.b.c();
            }
        }
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiniu.pili.droid.shortvideo.core.j
    public boolean d() {
        return this.d && this.j;
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    protected boolean e() {
        return this.e && this.k;
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    protected boolean f() {
        return (this.e || this.k) ? false : true;
    }

    @Override // com.qiniu.pili.droid.shortvideo.core.j
    protected i g() {
        return new i(this.m, this.n, this.p, this.f13857c);
    }
}
