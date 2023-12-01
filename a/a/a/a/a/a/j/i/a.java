package a.a.a.a.a.a.j.i;

import a.a.a.a.a.a.b;
import a.a.a.a.a.a.g.d;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.e.e;
import android.graphics.Point;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.av.encoder.PLH264Encoder;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/i/a.class */
public class a extends a.a.a.a.a.a.a implements a.a.a.a.a.a.g.a {
    public a(f.a aVar) {
        super(aVar.f1271a);
        aVar.f1271a.a(this);
        b d = aVar.f1271a.d();
        e eVar = e.f;
        eVar.c("PLSoftVideoEncoderCore", "encodingSize.width:" + d.a().a() + ", encodingSize.height:" + d.a().b() + ",rotation:" + aVar.e);
        int a2 = d.a().a();
        int b = d.a().b();
        Point c2 = d.c();
        a.a.a.a.a.e.f b2 = d.b();
        d dVar = new d(new PLH264Encoder.Parameters(aVar.b, aVar.f1272c, aVar.d, c2.x, c2.y, b2.a(), b2.b(), a2, b, d.r(), d.d(), d.p(), aVar.m, aVar.e, aVar.f, d.f().getEncoderRCMode(), d.f().getCPUWorkload(), d.f().getVideoProfile().getH264Profile(), aVar.j ? null : aVar.h, d.f().b()));
        this.b = dVar;
        dVar.a(this);
        this.b.d();
        this.f1213c = 1;
    }

    @Override // a.a.a.a.a.a.g.a
    public void a(PLAVFrame pLAVFrame, PLBufferInfo pLBufferInfo) {
        this.b.a(this.f1212a, pLAVFrame, pLBufferInfo, false);
    }
}
