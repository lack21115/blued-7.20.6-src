package a.a.a.a.a.a.e.e;

import a.a.a.a.a.a.g.d;
import a.a.a.a.a.a.i.c;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.av.encoder.PLAACEncoder;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/e/e/a.class */
public class a extends a.a.a.a.a.a.a implements a.a.a.a.a.a.g.a {
    public a(c cVar) {
        super(cVar);
        cVar.b(this);
        a.a.a.a.a.a.e.a j = cVar.d().j();
        d dVar = new d(new PLAACEncoder.Parameters(j.c(), j.a(), j.b(), 16));
        this.b = dVar;
        dVar.d();
        this.b.a(this);
        this.f1165c = 0;
    }

    @Override // a.a.a.a.a.a.g.a
    public void a(PLAVFrame pLAVFrame, PLBufferInfo pLBufferInfo) {
        this.b.a(this.f1164a, pLAVFrame, pLBufferInfo, false);
    }
}
