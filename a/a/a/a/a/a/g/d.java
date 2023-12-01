package a.a.a.a.a.a.g;

import a.a.a.a.a.a.j.f;
import android.view.Surface;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.av.encoder.PLAACEncoder;
import com.qiniu.pili.droid.streaming.av.encoder.PLH264Encoder;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/g/d.class */
public class d extends b {
    public PLH264Encoder b;

    /* renamed from: c  reason: collision with root package name */
    public PLAACEncoder f1230c;

    public d(PLAACEncoder.Parameters parameters) {
        this.f1230c = new PLAACEncoder(parameters);
    }

    public d(PLH264Encoder.Parameters parameters) {
        PLH264Encoder pLH264Encoder = new PLH264Encoder();
        this.b = pLH264Encoder;
        pLH264Encoder.a(parameters);
    }

    @Override // a.a.a.a.a.a.g.b
    public void a() {
        PLH264Encoder pLH264Encoder = this.b;
        if (pLH264Encoder != null) {
            pLH264Encoder.a();
            return;
        }
        PLAACEncoder pLAACEncoder = this.f1230c;
        if (pLAACEncoder != null) {
            pLAACEncoder.release();
        }
    }

    @Override // a.a.a.a.a.a.g.b
    public void a(int i) {
        PLH264Encoder pLH264Encoder = this.b;
        if (pLH264Encoder != null) {
            pLH264Encoder.a(i);
        }
    }

    @Override // a.a.a.a.a.a.g.b
    public void a(a aVar) {
        PLH264Encoder pLH264Encoder = this.b;
        if (pLH264Encoder != null) {
            pLH264Encoder.a(aVar);
            return;
        }
        PLAACEncoder pLAACEncoder = this.f1230c;
        if (pLAACEncoder != null) {
            pLAACEncoder.a(aVar);
        }
    }

    @Override // a.a.a.a.a.a.g.b
    public void a(a.a.a.a.a.a.i.c cVar, PLAVFrame pLAVFrame, PLBufferInfo pLBufferInfo, boolean z) {
        a.a.a.a.a.e.e.i.a("PLSWEncoder", "drainEncoder + endOfStream:" + z);
        if (this.b != null) {
            if (!z) {
                if ((pLBufferInfo.flags & 2) != 0) {
                    cVar.a(1);
                }
                cVar.a(1, pLAVFrame.mSize, pLAVFrame, pLBufferInfo);
            } else if (pLAVFrame == null) {
                cVar.a();
            } else {
                pLBufferInfo.flags |= 4;
                cVar.a(1, pLAVFrame.mSize, pLAVFrame, pLBufferInfo);
            }
        } else if (this.f1230c != null) {
            if (!z) {
                if ((pLBufferInfo.flags & 2) != 0) {
                    cVar.a(0);
                }
                cVar.a(0, pLAVFrame.mSize, pLAVFrame, pLBufferInfo);
            } else if (pLAVFrame == null) {
                cVar.a();
            } else {
                pLBufferInfo.flags |= 4;
                cVar.a(0, pLAVFrame.mSize, pLAVFrame, pLBufferInfo);
            }
        }
        a.a.a.a.a.e.e.i.a("PLSWEncoder", "drainEncoder -");
    }

    @Override // a.a.a.a.a.a.g.b
    public void a(a.a.a.a.a.a.i.c cVar, boolean z) {
        if (z) {
            cVar.a();
        }
    }

    @Override // a.a.a.a.a.a.g.b
    public void a(WatermarkSetting watermarkSetting) {
        PLH264Encoder pLH264Encoder = this.b;
        if (pLH264Encoder != null) {
            pLH264Encoder.a(watermarkSetting);
        }
    }

    @Override // a.a.a.a.a.a.g.b
    public void a(PLAVFrame pLAVFrame, int i) {
        pLAVFrame.mBuffer.limit(0);
        pLAVFrame.mBuffer.clear();
        PLH264Encoder pLH264Encoder = this.b;
        if (pLH264Encoder != null) {
            pLH264Encoder.c(pLAVFrame);
            return;
        }
        PLAACEncoder pLAACEncoder = this.f1230c;
        if (pLAACEncoder != null) {
            pLAACEncoder.b(pLAVFrame);
        }
    }

    @Override // a.a.a.a.a.a.g.b
    public void a(PLAVFrame pLAVFrame, f.a aVar, boolean z) {
        PLH264Encoder pLH264Encoder = this.b;
        if (pLH264Encoder != null) {
            pLH264Encoder.a(pLAVFrame, aVar, z);
        }
    }

    @Override // a.a.a.a.a.a.g.b
    public PLAVFrame b(int i) {
        PLH264Encoder pLH264Encoder = this.b;
        if (pLH264Encoder != null) {
            return pLH264Encoder.b(i);
        }
        return null;
    }

    @Override // a.a.a.a.a.a.g.b
    public void b() {
        a.a.a.a.a.e.e.i.c("PLSWEncoder", "signalEndOfStream");
    }

    @Override // a.a.a.a.a.a.g.b
    public Object c() {
        PLH264Encoder pLH264Encoder = this.b;
        if (pLH264Encoder != null) {
            return pLH264Encoder;
        }
        PLAACEncoder pLAACEncoder = this.f1230c;
        if (pLAACEncoder != null) {
            return pLAACEncoder;
        }
        return null;
    }

    @Override // a.a.a.a.a.a.g.b
    public void d() {
        PLH264Encoder pLH264Encoder = this.b;
        if (pLH264Encoder != null) {
            pLH264Encoder.b();
        }
    }

    @Override // a.a.a.a.a.a.g.b
    public Surface e() {
        return null;
    }
}
