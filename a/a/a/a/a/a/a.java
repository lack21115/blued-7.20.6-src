package a.a.a.a.a.a;

import a.a.a.a.a.a.i.c;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.e.e;
import android.media.MediaCodec;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.encoder.PLAACEncoder;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/a.class */
public abstract class a implements c.d {

    /* renamed from: a  reason: collision with root package name */
    public a.a.a.a.a.a.i.c f1212a;
    public a.a.a.a.a.a.g.b b;

    /* renamed from: c  reason: collision with root package name */
    public int f1213c;

    public a(a.a.a.a.a.a.i.c cVar) {
        this.f1212a = cVar;
        a.a.a.a.a.a.j.a.a().a(cVar.d().r());
    }

    public void a() {
        a.a.a.a.a.a.g.b bVar = this.b;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void a(int i) {
        a.a.a.a.a.a.g.b bVar = this.b;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    public void a(WatermarkSetting watermarkSetting) {
        a.a.a.a.a.a.g.b bVar = this.b;
        if (bVar != null) {
            bVar.a(watermarkSetting);
        }
    }

    @Override // a.a.a.a.a.a.i.c.d
    public void a(PLAVFrame pLAVFrame, int i) {
        a.a.a.a.a.a.g.b bVar = this.b;
        if (bVar != null) {
            bVar.a(pLAVFrame, i);
        }
    }

    public void a(PLAVFrame pLAVFrame, f.a aVar, boolean z) {
        a.a.a.a.a.a.g.b bVar = this.b;
        if (bVar != null) {
            bVar.a(pLAVFrame, aVar, z);
        }
    }

    public void a(boolean z) {
        a.a.a.a.a.a.g.b bVar = this.b;
        if (bVar != null) {
            try {
                bVar.a(this.f1212a, z);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    public PLAVFrame b(int i) {
        a.a.a.a.a.a.g.b bVar = this.b;
        if (bVar != null) {
            return bVar.b(i);
        }
        return null;
    }

    public void b() {
        a.a.a.a.a.a.i.c cVar = this.f1212a;
        if (cVar != null) {
            cVar.b(this.f1213c);
        }
        a.a.a.a.a.a.g.b bVar = this.b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public MediaCodec c() {
        if (this.b.c() instanceof MediaCodec) {
            return (MediaCodec) this.b.c();
        }
        e.i.e("Encoder", "error, it's not a MediaCodec");
        return null;
    }

    public PLAACEncoder d() {
        if (this.b.c() instanceof PLAACEncoder) {
            return (PLAACEncoder) this.b.c();
        }
        e.i.e("Encoder", "error, it's not a PLAACEncoder");
        return null;
    }
}
