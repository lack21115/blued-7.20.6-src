package a.a.a.a.a.a.j;

import a.a.a.a.a.e.h;
import android.view.Surface;
import com.qiniu.pili.droid.streaming.PreviewAppearance;
import com.qiniu.pili.droid.streaming.StreamingPreviewCallback;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/f.class */
public abstract class f {
    public a.a.a.a.a.a.c v;
    public a w;
    public a x;
    public volatile a.a.a.a.a.f.c t = a.a.a.a.a.f.c.IDLE;
    public volatile a.a.a.a.a.f.a u = a.a.a.a.a.f.a.NONE;
    public long y = 0;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/f$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final a.a.a.a.a.a.i.c f1223a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1224c;
        public final int d;
        public final int e;
        public final int f;
        public final boolean g;
        public WatermarkSetting h;
        public final Object i;
        public final boolean j;
        public int k;
        public int l;
        public boolean m;
        public int n;
        public PreviewAppearance o;

        public a(a.a.a.a.a.a.i.c cVar, int i, int i2, int i3, boolean z, int i4, int i5, WatermarkSetting watermarkSetting, boolean z2) {
            this.g = z2;
            this.l = i3;
            this.f = i5;
            this.f1223a = cVar;
            this.b = i;
            this.f1224c = i2;
            this.d = ((i * i2) * 3) / 2;
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
            eVar.c("VideoTransfer", "srcWidth:" + i + ",srcHeight:" + i2 + ",srcSize:" + this.d);
            this.e = i4;
            this.j = false;
            this.m = b(z);
            this.h = watermarkSetting;
            this.i = null;
        }

        public a(a.a.a.a.a.a.i.c cVar, int i, int i2, int i3, boolean z, int i4, int i5, Object obj, WatermarkSetting watermarkSetting, boolean z2) {
            this.f1223a = cVar;
            this.i = obj;
            this.l = i3;
            this.g = z2;
            this.f = i5;
            this.b = i;
            this.f1224c = i2;
            this.j = true;
            a.a.a.a.a.e.f a2 = cVar.d().a();
            if (i5 == PLFourCC.FOURCC_ABGR) {
                this.d = a2.a() * a2.b() * 4;
            } else {
                this.d = (int) (a2.a() * a2.b() * 1.5d);
            }
            this.e = i4;
            this.m = b(z);
            this.h = watermarkSetting;
        }

        public void a(PreviewAppearance previewAppearance) {
            this.o = previewAppearance;
        }

        public void a(WatermarkSetting watermarkSetting) {
            this.h = watermarkSetting;
        }

        public void a(boolean z) {
            this.m = z;
        }

        public boolean b(boolean z) {
            if (!this.j) {
                z = !z;
            }
            return h.b(this.l) && z;
        }
    }

    public abstract void a(int i);

    public void a(int i, long j, boolean z) {
    }

    public void a(a.a.a.a.a.a.c cVar) {
        this.v = cVar;
    }

    public abstract void a(a aVar);

    public void a(StreamingPreviewCallback streamingPreviewCallback) {
    }

    public void a(WatermarkSetting watermarkSetting) {
    }

    public void a(ByteBuffer byteBuffer, int i, long j) {
    }

    public void a(byte[] bArr, long j) {
    }

    public boolean a(boolean z) {
        return false;
    }

    public Surface b(a aVar) {
        return null;
    }

    public abstract void b(boolean z);

    public void c(boolean z) {
    }

    public void e() {
        if (this.u == a.a.a.a.a.f.a.START) {
            a(this.x);
            this.u = a.a.a.a.a.f.a.NONE;
        } else if (this.u == a.a.a.a.a.f.a.STOP) {
            b(false);
            this.u = a.a.a.a.a.f.a.NONE;
        } else if (this.u == a.a.a.a.a.f.a.RESTART) {
            b(false);
            a(this.x);
        }
    }

    public boolean f() {
        boolean z;
        synchronized (this) {
            z = this.t == a.a.a.a.a.f.c.RUNNING;
        }
        return z;
    }
}
