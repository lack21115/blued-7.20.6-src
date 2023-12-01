package a.a.a.a.a.a.i;

import a.a.a.a.a.a.b;
import a.a.a.a.a.a.i.c;
import a.a.a.a.a.e.e;
import com.huawei.openalliance.ad.constant.bc;
import com.qiniu.pili.droid.streaming.core.PLDroidStreamingCore;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/i/a.class */
public class a extends d {
    public a() {
        super(2);
    }

    @Override // a.a.a.a.a.a.i.d, a.a.a.a.a.a.i.c
    public boolean a(a.a.a.a.a.a.b bVar) {
        e.f.c("PLAVMuxer", bc.b.Code);
        if (this.C) {
            e.f.c("PLAVMuxer", "mStreamingPaused");
            return false;
        }
        b(bVar);
        d().a(b.c.PREPARING, null);
        r();
        this.X = 0L;
        u();
        if (i()) {
            this.f = new byte[1024];
        }
        s();
        a("PLAVMuxer");
        return !this.k;
    }

    @Override // a.a.a.a.a.a.i.d
    public int a_(c.g gVar) {
        return super.a(gVar);
    }

    @Override // a.a.a.a.a.a.i.d
    public void b(c.g gVar) {
        if (gVar.b == 1) {
            e.f.b("PLAVMuxer", "Capture SPS + PPS");
            c(gVar.d.mBuffer, gVar.f1250a);
            e eVar = e.f;
            eVar.b("PLAVMuxer", "VIDEO CONFIG LENGTH: " + this.p.length + ", pts:" + (gVar.f1250a.presentationTimeUs / 1000));
            PLDroidStreamingCore pLDroidStreamingCore = this.g;
            byte[] bArr = this.p;
            pLDroidStreamingCore.writeVideoSeqHeader(bArr, bArr.length, gVar.f1250a.presentationTimeUs / 1000);
        } else {
            a(gVar.d.mBuffer, gVar.f1250a);
            e eVar2 = e.f;
            eVar2.b("PLAVMuxer", "AUDIO CONFIG LENGTH: " + this.q.length + ", pts:" + (gVar.f1250a.presentationTimeUs / 1000));
            PLDroidStreamingCore pLDroidStreamingCore2 = this.g;
            byte[] bArr2 = this.q;
            pLDroidStreamingCore2.writeAudioSeqHeader(bArr2, bArr2.length, gVar.f1250a.presentationTimeUs / 1000);
        }
        if (this.p != null && this.q != null && d().s() != b.c.STREAMING) {
            d().a(b.c.CONNECTING, null);
            e eVar3 = e.f;
            eVar3.c("PLAVMuxer", "writeHeader :mIsNeedUpdateAVOption=" + this.D);
        }
        a(gVar.f1250a, gVar.d, gVar.f1251c, gVar.b);
    }
}
