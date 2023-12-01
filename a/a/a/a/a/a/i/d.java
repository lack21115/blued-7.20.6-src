package a.a.a.a.a.a.i;

import a.a.a.a.a.a.b;
import a.a.a.a.a.a.i.c;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import com.anythink.expressad.video.module.a.a.m;
import com.huawei.openalliance.ad.constant.bc;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.core.PLDroidStreamingCore;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/i/d.class */
public class d extends c {
    public long S;
    public long T;
    public long U;
    public long V;
    public long W;
    public long X;
    public long Y;
    public boolean Z;

    /* renamed from: a  reason: collision with root package name */
    public long f1252a;

    public d() {
        super(1);
        this.Z = false;
    }

    public d(int i) {
        super(i);
        this.Z = false;
    }

    public final void a(int i, int i2, PLAVFrame pLAVFrame) {
        e().m++;
        a(i, pLAVFrame, i2);
        e.f.d("PLVideoMuxer", "GOP dropping, non I frame dropped.");
    }

    @Override // a.a.a.a.a.a.i.c
    public void a(int i, int i2, PLAVFrame pLAVFrame, PLBufferInfo pLBufferInfo) {
        PLAVFrame a2;
        super.a(i, i2, pLAVFrame, pLBufferInfo);
        synchronized (this.h) {
            if (this.i) {
                e eVar = e.f;
                eVar.a("PLVideoMuxer", "writeSampleData ====" + String.valueOf(i) + ",frame.mBuffer:" + pLAVFrame.mBuffer.toString());
                if (b(i, i2, pLAVFrame, pLBufferInfo)) {
                    return;
                }
                t();
                w();
                if (b(i, i2, pLAVFrame, pLBufferInfo)) {
                    return;
                }
                if (h.c() && i == 1 && !h.b(pLBufferInfo)) {
                    a(i, i2, pLAVFrame);
                    v();
                    return;
                }
                try {
                    if (h.a(pLBufferInfo)) {
                        synchronized (this.I) {
                            e.f.a("PLVideoMuxer", "key frame.....");
                            a2 = this.I.a(pLAVFrame.mBuffer.capacity());
                        }
                    } else {
                        synchronized (this.H) {
                            a2 = this.H.get(i).a(pLAVFrame.mBuffer.capacity());
                        }
                    }
                    a2.mBuffer.clear();
                    a2.mBuffer.put(pLAVFrame.mBuffer);
                    a2.mBuffer.position(0);
                    a(i, pLAVFrame, i2);
                    if (this.C && h.c(pLBufferInfo)) {
                        e.f.d("PLVideoMuxer", "ignore the eos frame when streaming paused");
                        return;
                    }
                    e(new c.g(i, i2, a2, pLBufferInfo));
                } catch (OutOfMemoryError e) {
                    e.f.e("PLVideoMuxer", "OOM exception!");
                    a(i, pLAVFrame, i2);
                }
            } else {
                e.f.d("PLVideoMuxer", "Dropping frame because Muxer not ready!");
                a(i, pLAVFrame, i2);
            }
        }
    }

    @Override // a.a.a.a.a.a.i.c
    public void a(PLBufferInfo pLBufferInfo, PLAVFrame pLAVFrame, int i, int i2) {
        synchronized (this.n) {
            if (!this.o) {
                e.f.a("PLVideoMuxer", "releaseOutputBufer encodedData.clear()!");
                pLAVFrame.mBuffer.clear();
                if (h.a(pLBufferInfo)) {
                    e eVar = e.f;
                    eVar.a("PLVideoMuxer", "mMuxerInputKeyFrameQueue.add encodedData:" + pLAVFrame.mBuffer);
                    this.I.a(pLAVFrame);
                } else {
                    synchronized (this.H) {
                        this.H.get(i2).a(pLAVFrame);
                    }
                }
            }
        }
    }

    @Override // a.a.a.a.a.a.i.c
    public boolean a(a.a.a.a.a.a.b bVar) {
        e.f.c("PLVideoMuxer", bc.b.Code);
        if (this.C) {
            e.f.c("PLVideoMuxer", "mStreamingPaused");
            return false;
        }
        super.a(bVar);
        d().a(b.c.PREPARING, null);
        r();
        this.X = 0L;
        u();
        s();
        a("PLVideoMuxer");
        return !this.k;
    }

    public int a_(c.g gVar) {
        return 0;
    }

    @Override // a.a.a.a.a.a.i.c
    public void b() {
        while (true) {
            e.f.a("PLVideoMuxer", "working mStop:" + this.m + ",mStreamingPaused:" + this.C);
            c.g j = j();
            if (this.m || j.d == null) {
                return;
            }
            e.f.a("PLVideoMuxer", "consume packet:" + j);
            if (c(j) < 0) {
                return;
            }
            if (h.b(j.f1250a)) {
                e.f.c("PLVideoMuxer", "handling BUFFER_FLAG_CODEC_CONFIG for track " + j.b);
                if (j.f1250a.size <= 0) {
                    e.f.e("PLVideoMuxer", "error config buffer");
                    return;
                }
                b(j);
            } else {
                if (g()) {
                    a(j.f1250a, j.d, j.f1251c, j.b);
                } else {
                    int i = -1;
                    long currentTimeMillis = System.currentTimeMillis();
                    int i2 = j.b;
                    if (i2 == 0) {
                        i = a_(j);
                    } else if (i2 == 1) {
                        i = d(j);
                    }
                    e((int) (System.currentTimeMillis() - currentTimeMillis));
                    a(j.f1250a, j.d, j.f1251c, j.b);
                    if (!d(i)) {
                        return;
                    }
                }
                if (!this.C && g()) {
                    e.f.c("PLVideoMuxer", "Shutting down on last frame");
                    return;
                }
            }
        }
    }

    public void b(c.g gVar) {
        if (gVar.b == 1) {
            e.f.b("PLVideoMuxer", "Capture SPS + PPS");
            c(gVar.d.mBuffer, gVar.f1250a);
            PLDroidStreamingCore pLDroidStreamingCore = this.g;
            byte[] bArr = this.p;
            pLDroidStreamingCore.writeVideoSeqHeader(bArr, bArr.length, gVar.f1250a.presentationTimeUs / 1000);
        }
        if (this.p != null) {
            d().a(b.c.CONNECTING, null);
            e eVar = e.f;
            eVar.c("PLVideoMuxer", "writeHeader :mIsNeedUpdateAVOption=" + this.D);
        }
        a(gVar.f1250a, gVar.d, gVar.f1251c, gVar.b);
    }

    public final boolean b(int i, int i2, PLAVFrame pLAVFrame, PLBufferInfo pLBufferInfo) {
        if (this.Z) {
            if (!h.a(pLBufferInfo)) {
                a(i, i2, pLAVFrame);
                return true;
            }
            this.Z = false;
            e.f.d("PLVideoMuxer", "GOP dropping done, met next I frame.");
            return false;
        }
        return false;
    }

    public void r() {
        this.i = false;
        this.p = null;
        this.q = null;
        this.F = -1;
        this.o = false;
        this.Z = false;
        a.a.a.a.a.m.a.a().b();
        a.a.a.a.a.m.a.a().a(d().f().a());
    }

    public void s() {
        e eVar = e.f;
        eVar.c("PLVideoMuxer", "mMuxerAVFrameInputPool:" + this.H + ",mMuxerInputKeyFramePool:" + this.I);
        try {
            this.H.clear();
        } catch (NullPointerException e) {
            e.f.d("PLVideoMuxer", "mPacketDataQueue or mMuxerInputQueue is null");
        }
        ArrayList<a.a.a.a.a.a.f.a> arrayList = this.H;
        if (arrayList == null) {
            this.H = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        if (this.I == null) {
            this.I = new a.a.a.a.a.a.f.a(3);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return;
            }
            this.H.add(new a.a.a.a.a.a.f.a(10));
            i = i2 + 1;
        }
    }

    public void t() {
        if (System.currentTimeMillis() - this.S < 1000) {
            return;
        }
        this.S = System.currentTimeMillis();
        try {
            c.g peekFirst = this.G.peekFirst();
            c.g peekLast = this.G.peekLast();
            if (peekFirst == null || peekLast == null) {
                return;
            }
            this.Y = peekLast.f1250a.presentationTimeUs - peekFirst.f1250a.presentationTimeUs;
            if (h.b()) {
                e.f.d("PLVideoMuxer", "Drop frame due to low memory.");
                d().a(b.c.FRAME_QUEUE_FULL, null);
                this.G.removeLast();
                v();
                this.X = 0L;
            } else if (this.Y > 0 && this.Y <= this.T) {
                if (this.X == 0) {
                    this.X = peekLast.e;
                }
                if (peekLast.e - this.X >= this.W) {
                    e.f.c("PLVideoMuxer", "11 Gooooooooooooooooooooooood");
                    this.X = 0L;
                    d().a(b.c.FRAME_QUEUE_HAS_FEW_ELEMENTS, null);
                }
            } else if (this.Y >= this.T && this.Y < this.U) {
                this.X = 0L;
                e eVar = e.f;
                eVar.c("PLVideoMuxer", "Baaaaaaaaaaaaaaaaaaaaaaaaaaad:" + this.G.size());
                d().a(b.c.FRAME_QUEUE_HAS_MANY_ELEMENTS, null);
            } else if (this.Y < this.V) {
                this.X = 0L;
            } else {
                e.f.d("PLVideoMuxer", "Drop frame due to buffer time level full.");
                d().a(b.c.FRAME_QUEUE_FULL, null);
                this.G.removeLast();
                v();
                this.X = 0L;
            }
        } catch (NoSuchElementException e) {
            e eVar2 = e.f;
            eVar2.d("PLVideoMuxer", "No Such Element." + e.getMessage());
        }
    }

    public void u() {
        this.f1252a = 0L;
        this.S = 0L;
        try {
            StreamingProfile.SendingBufferProfile sendingBufferInfo = d().f().getSendingBufferInfo();
            this.T = sendingBufferInfo.getLowThreshold() * 1000.0f;
            this.U = sendingBufferInfo.getHighThreshold() * 1000.0f;
            this.V = sendingBufferInfo.getDurationLimit() * 1000.0f;
            this.W = sendingBufferInfo.getLowThresholdTimeout();
        } catch (NullPointerException e) {
            e.f.d("PLVideoMuxer", "NPE. Use the default sendingBufferInfo values!");
            this.T = 200L;
            this.U = 800L;
            this.V = m.ag;
            this.W = 60000L;
        }
        e eVar = e.f;
        eVar.c("PLVideoMuxer", "mBufferTimeLevelLow:" + this.T + ",mBufferTimeLevelHigh:" + this.U + ",mBufferTimeLevelFull:" + this.V + ",mBufferTimeLevelLowTimeout:" + this.W);
    }

    public final void v() {
        this.Z = true;
        e.f.d("PLVideoMuxer", "GOP dropping start.");
    }

    public final void w() {
        if (System.currentTimeMillis() - this.f1252a < 1000) {
            return;
        }
        a.a.a.a.a.m.a.a().a(d());
        this.f1252a = System.currentTimeMillis();
    }
}
