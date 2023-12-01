package a.a.a.a.a.i;

import a.a.a.a.a.b.b;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import android.content.Context;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.SharedLibraryNameHelper;
import com.qiniu.pili.droid.streaming.SurfaceTextureCallback;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/i/a.class */
public final class a implements SurfaceTextureCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f1383a = SharedLibraryNameHelper.getInstance().d();
    public InterfaceC0010a b;

    /* renamed from: c  reason: collision with root package name */
    public a.a.a.a.a.i.b.c.a f1384c;
    public Context d;
    public CameraStreamingSetting e;
    public CameraStreamingSetting.VIDEO_FILTER_TYPE f;
    public boolean g;
    public boolean h;
    public ByteBuffer j;
    public byte[] k;
    public int l;
    public boolean i = false;
    public final Object m = new Object();
    public boolean n = false;

    /* renamed from: a.a.a.a.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/i/a$a.class */
    public interface InterfaceC0010a {
        void a(byte[] bArr, int i, int i2, int i3, long j, boolean z);
    }

    public a(Context context, CameraStreamingSetting cameraStreamingSetting, boolean z, InterfaceC0010a interfaceC0010a) {
        this.f = CameraStreamingSetting.VIDEO_FILTER_TYPE.VIDEO_FILTER_NONE;
        if (SharedLibraryNameHelper.d(true) && cameraStreamingSetting.e()) {
            e.h.c("ProcessingManager", "using the built-in fb");
            this.f1384c = new a.a.a.a.a.i.b.c.a();
        }
        this.d = context.getApplicationContext();
        this.e = cameraStreamingSetting;
        this.g = z;
        this.h = a.a.a.a.a.f.e.a().c();
        this.b = interfaceC0010a;
        this.f = cameraStreamingSetting.getVideoFilterType();
    }

    public void a() {
        this.i = true;
    }

    public final void a(int i, int i2, long j, boolean z) {
        synchronized (this.m) {
            if (this.f1384c != null) {
                if (this.l == 0) {
                    this.l = ((i * i2) * 3) / 2;
                }
                if (this.j == null) {
                    this.j = ByteBuffer.allocateDirect(this.l);
                }
                this.j.clear();
                boolean a2 = this.f1384c.a(this.j, this.l);
                if (this.b != null && a2) {
                    if (this.k == null) {
                        this.k = new byte[this.l];
                    }
                    this.j.get(this.k, 0, this.l);
                    this.b.a(this.k, i, i2, PLFourCC.FOURCC_NV21, j, z);
                }
            }
        }
    }

    public void a(CameraStreamingSetting.FaceBeautySetting faceBeautySetting) {
        if (this.f1384c == null) {
            return;
        }
        if (faceBeautySetting == null) {
            e.h.d("ProcessingManager", "Invalid FB setting");
            return;
        }
        e.h.c("ProcessingManager", "mFilterType:" + this.f);
        if (this.f != CameraStreamingSetting.VIDEO_FILTER_TYPE.VIDEO_FILTER_BEAUTY) {
            this.f1384c.a(0.0f);
            return;
        }
        this.f1384c.a(faceBeautySetting.beautyLevel);
        float f = faceBeautySetting.whiten;
        float f2 = f;
        if (f > 1.0f) {
            f2 = 1.0f;
        }
        this.f1384c.b(f2 / 2.0f);
        this.f1384c.c(faceBeautySetting.redden);
    }

    public void a(CameraStreamingSetting.VIDEO_FILTER_TYPE video_filter_type) {
        if (this.f1384c != null) {
            this.f = video_filter_type;
            a(this.e.getFaceBeautySetting());
        }
    }

    public void a(boolean z) {
        this.n = z;
    }

    public void b() {
        this.i = false;
        f();
    }

    public void c() {
        a.a.a.a.a.i.b.c.a aVar = this.f1384c;
        if (aVar != null) {
            aVar.a();
            f();
        }
    }

    public void d() {
        this.b = null;
    }

    public void e() {
        a.a.a.a.a.i.b.c.a aVar = this.f1384c;
        if (aVar != null) {
            aVar.b(!h.c(this.d));
        }
    }

    public final void f() {
        synchronized (this.m) {
            this.l = 0;
            this.k = null;
            this.j = null;
        }
    }

    public final void g() {
        a.a.a.a.a.i.b.c.a aVar = this.f1384c;
        if (aVar != null) {
            aVar.a();
            this.f1384c.a(this.d.getApplicationContext(), h.f(this.d), !this.g ? 1 : 0);
            this.f1384c.b(!h.c(this.d));
            a(this.e.getFaceBeautySetting());
        }
    }

    @Override // com.qiniu.pili.droid.streaming.SurfaceTextureCallback
    public int onDrawFrame(int i, int i2, int i3, float[] fArr) {
        int i4 = i;
        if (this.f1384c != null) {
            i4 = i;
            if (i2 != 0) {
                i4 = i;
                if (i3 != 0) {
                    long nanoTime = System.nanoTime();
                    int a2 = this.f1384c.a(i, i2, i3);
                    boolean z = this.i && !this.g && this.n;
                    i4 = a2;
                    if (this.h) {
                        a(i2, i3, nanoTime, z);
                        i4 = a2;
                    }
                }
            }
        }
        return i4;
    }

    @Override // com.qiniu.pili.droid.streaming.SurfaceTextureCallback
    public void onSurfaceChanged(int i, int i2) {
        a.a.a.a.a.i.b.c.a aVar = this.f1384c;
        if (aVar != null) {
            aVar.b(this.d.getApplicationContext(), i, i2);
            this.f1384c.a(b.a().c());
            boolean z = false;
            if (b.a().c()) {
                z = b.a().b().orientation == 90;
            }
            this.f1384c.c(z);
        }
    }

    @Override // com.qiniu.pili.droid.streaming.SurfaceTextureCallback
    public void onSurfaceCreated() {
        g();
    }

    @Override // com.qiniu.pili.droid.streaming.SurfaceTextureCallback
    public void onSurfaceDestroyed() {
        a.a.a.a.a.i.b.c.a aVar = this.f1384c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
