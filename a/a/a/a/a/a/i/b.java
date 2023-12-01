package a.a.a.a.a.a.i;

import a.a.a.a.a.a.b;
import a.a.a.a.a.a.i.c;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import com.huawei.openalliance.ad.constant.bc;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.core.PLDroidStreamingCore;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/i/b.class */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public a.a.a.a.a.a.f.a f1240a;

    public b() {
        super(1);
    }

    @Override // a.a.a.a.a.a.i.c
    public int a(c.g gVar) {
        if (!d().t()) {
            d().a(b.c.STREAMING, null);
        }
        return super.a(gVar);
    }

    @Override // a.a.a.a.a.a.i.c
    public void a() {
        e.f.c("PLAudioMuxer", "forceStop");
        if (this.i) {
            this.m = true;
            e(new c.g(0, 0, null, null));
            return;
        }
        e eVar = e.f;
        eVar.c("PLAudioMuxer", "forceStop return immediately:mReady=" + this.i);
    }

    @Override // a.a.a.a.a.a.i.c
    public void a(int i, int i2, PLAVFrame pLAVFrame, PLBufferInfo pLBufferInfo) {
        PLAVFrame a2;
        super.a(i, i2, pLAVFrame, pLBufferInfo);
        synchronized (this.h) {
            if (this.i) {
                e eVar = e.f;
                eVar.a("PLAudioMuxer", "writeSampleData ====" + String.valueOf(i) + ",frame.mBuffer:" + pLAVFrame.mBuffer.toString());
                try {
                    synchronized (this.f1240a) {
                        a2 = this.f1240a.a(pLAVFrame.mBuffer.capacity());
                    }
                    a2.mBuffer.clear();
                    a2.mBuffer.put(pLAVFrame.mBuffer);
                    a2.mBuffer.position(0);
                    a(i, pLAVFrame, i2);
                    e(new c.g(i, i2, a2, pLBufferInfo));
                } catch (OutOfMemoryError e) {
                    e.f.e("PLAudioMuxer", "OOM exception!");
                    a(i, pLAVFrame, i2);
                }
            } else {
                e.f.d("PLAudioMuxer", "Dropping frame because Muxer not ready!");
                a(i, pLAVFrame, i2);
            }
        }
    }

    @Override // a.a.a.a.a.a.i.c
    public void a(PLBufferInfo pLBufferInfo, PLAVFrame pLAVFrame, int i, int i2) {
        synchronized (this.n) {
            if (!this.o) {
                e.f.a("PLAudioMuxer", " releaseOutputBufer encodedData.clear()!");
                pLAVFrame.mBuffer.clear();
                synchronized (this.f1240a) {
                    this.f1240a.a(pLAVFrame);
                }
            }
        }
    }

    @Override // a.a.a.a.a.a.i.c
    public boolean a(a.a.a.a.a.a.b bVar) {
        e.f.c("PLAudioMuxer", bc.b.Code);
        super.a(bVar);
        d().a(b.c.PREPARING, null);
        this.i = false;
        this.q = null;
        if (i()) {
            this.f = new byte[1024];
        }
        if (this.f1240a == null) {
            this.f1240a = new a.a.a.a.a.a.f.a(10);
        }
        a("PLAudioMuxer");
        return !this.k;
    }

    @Override // a.a.a.a.a.a.i.c
    public void b() {
        while (true) {
            c.g j = j();
            if (this.m || j.d == null || c(j) < 0) {
                return;
            }
            if (h.b(j.f1250a)) {
                e eVar = e.f;
                eVar.c("PLAudioMuxer", "handling BUFFER_FLAG_CODEC_CONFIG for track " + j.b);
                if (j.f1250a.size <= 0) {
                    e.f.e("PLAudioMuxer", "error config buffer");
                    return;
                }
                b(j);
            } else {
                if (g() || !h()) {
                    a(j.f1250a, j.d, j.f1251c, j.b);
                } else {
                    int a2 = a(j);
                    a(j.f1250a, j.d, j.f1251c, j.b);
                    if (!d(a2)) {
                        return;
                    }
                }
                if (!this.C && g()) {
                    e.f.c("PLAudioMuxer", "Shutting down on last frame");
                    return;
                }
            }
        }
    }

    public final void b(c.g gVar) {
        a(gVar.d.mBuffer, gVar.f1250a);
        e eVar = e.f;
        eVar.b("PLAudioMuxer", "AUDIO CONFIG LENGTH: " + this.q.length);
        PLDroidStreamingCore pLDroidStreamingCore = this.g;
        byte[] bArr = this.q;
        pLDroidStreamingCore.writeAudioSeqHeader(bArr, bArr.length, gVar.f1250a.presentationTimeUs / 1000);
        if (this.q != null) {
            d().a(b.c.CONNECTING, null);
            e eVar2 = e.f;
            eVar2.c("PLAudioMuxer", "writeHeader :mIsNeedUpdateAVOption=" + this.D);
        }
        a(gVar.f1250a, gVar.d, gVar.f1251c, gVar.b);
    }
}
