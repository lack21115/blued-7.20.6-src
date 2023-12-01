package a.a.a.a.a.b;

import a.a.a.a.a.b.a;
import a.a.a.a.a.b.b;
import a.a.a.a.a.b.g;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.FrameCapturedCallback;
import com.qiniu.pili.droid.streaming.PreviewAppearance;
import com.qiniu.pili.droid.streaming.StreamingPreviewCallback;
import com.qiniu.pili.droid.streaming.StreamingState;
import com.qiniu.pili.droid.streaming.SurfaceTextureCallback;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import com.qiniu.pili.droid.streaming.widget.AspectFrameLayout;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c.class */
public class c implements g.a, SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback {
    public Camera.Parameters D;
    public final Object M;
    public volatile boolean N;
    public volatile boolean O;
    public FrameCapturedCallback P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public a.a.a.a.a.a.b U;
    public j V;
    public j W;
    public List<SurfaceTextureCallback> X;

    /* renamed from: a  reason: collision with root package name */
    public GLSurfaceView f1287a;
    public a.a.a.a.a.b.e b;

    /* renamed from: c  reason: collision with root package name */
    public b.d f1288c;
    public AspectFrameLayout e;
    public ViewGroup f;
    public View g;
    public Context h;
    public a.a.a.a.a.b.g i;
    public CameraStreamingSetting j;
    public PreviewAppearance k;
    public WatermarkSetting l;
    public m m;
    public l n;
    public StreamingPreviewCallback o;
    public boolean p;
    public i q;
    public boolean t;
    public final Object d = new Object();
    public boolean r = false;
    public boolean s = false;
    public volatile boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public ByteBuffer y = null;
    public int z = 0;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public boolean E = false;
    public boolean F = false;
    public boolean G = false;
    public boolean H = false;
    public boolean I = false;
    public long J = 0;
    public long K = 0;
    public final h L = new h(this, null);

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$a.class */
    public class a implements a.InterfaceC0005a {
        public a() {
        }

        @Override // a.a.a.a.a.b.a.InterfaceC0005a
        public void a(boolean z, Camera camera) {
            if (c.this.i == null) {
                c.this.E();
            }
            c.this.i.c(z);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$b.class */
    public class b implements j {
        public b(c cVar) {
        }

        @Override // a.a.a.a.a.b.c.j
        public void a(int i) {
        }

        @Override // a.a.a.a.a.b.c.j
        public void a(int i, long j, boolean z) {
        }

        @Override // a.a.a.a.a.b.c.j
        public void a(Camera.Size size) {
        }

        @Override // a.a.a.a.a.b.c.j
        public void a(byte[] bArr, int i, int i2, int i3, int i4, long j, boolean z) {
        }

        @Override // a.a.a.a.a.b.c.j
        public void b() {
        }

        @Override // a.a.a.a.a.b.c.j
        public void c() {
        }

        @Override // a.a.a.a.a.b.c.j
        public void e() {
        }

        @Override // a.a.a.a.a.b.c.j
        public void f() {
        }

        @Override // a.a.a.a.a.b.c.j
        public int onPreviewFpsSelected(List<int[]> list) {
            return -1;
        }

        @Override // a.a.a.a.a.b.c.j
        public Camera.Size onPreviewSizeSelected(List<Camera.Size> list) {
            return null;
        }

        @Override // a.a.a.a.a.b.c.j
        public void onStateChanged(StreamingState streamingState, Object obj) {
        }
    }

    /* renamed from: a.a.a.a.a.b.c$c  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$c.class */
    public class RunnableC0007c implements Runnable {
        public RunnableC0007c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.b != null) {
                c.this.b.d();
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$d.class */
    public class d implements Camera.PreviewCallback {
        public d() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (bArr != null) {
                c.this.a(bArr);
            } else {
                c.this.P.onFrameCaptured(null);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$e.class */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.b != null) {
                c.this.b.c();
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$f.class */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.x();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$g.class */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.e();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$h.class */
    public final class h implements Camera.AutoFocusCallback {
        public h() {
        }

        public /* synthetic */ h(c cVar, a aVar) {
            this();
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            c.this.J = System.currentTimeMillis() - c.this.K;
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
            eVar.a("CameraManager", "mAutoFocusTime = " + c.this.J + "ms");
            c.this.i.b(z);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$i.class */
    public static class i extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<c> f1296a;

        public i(Looper looper, c cVar) {
            super(looper);
            this.f1296a = new WeakReference<>(cVar);
        }

        public void a() {
            getLooper().quit();
            this.f1296a.clear();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
            eVar.b("CameraManager", "CameraHandler [" + this + "]: what=" + message.what);
            c cVar = this.f1296a.get();
            if (cVar == null) {
                a.a.a.a.a.e.e.g.d("CameraManager", "CameraHandler.handleMessage: mananger is null");
                return;
            }
            int i = message.what;
            if (i == 0) {
                cVar.a((m) message.obj);
            } else if (i == 1) {
                cVar.z();
            } else if (i == 2) {
                cVar.D();
            } else if (i == 3) {
                cVar.a((Bitmap) message.obj);
            } else if (i == 4) {
                cVar.a((ByteBuffer) message.obj);
            } else {
                throw new RuntimeException("unknown msg " + message.what);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$j.class */
    public interface j {
        void a(int i);

        void a(int i, long j, boolean z);

        void a(Camera.Size size);

        void a(byte[] bArr, int i, int i2, int i3, int i4, long j, boolean z);

        void b();

        void c();

        void e();

        void f();

        int onPreviewFpsSelected(List<int[]> list);

        Camera.Size onPreviewSizeSelected(List<Camera.Size> list);

        void onStateChanged(StreamingState streamingState, Object obj);
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$k.class */
    public static class k implements b.e {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<c> f1297a;

        public k(c cVar) {
            this.f1297a = new WeakReference<>(cVar);
        }

        @Override // a.a.a.a.a.b.b.e
        public void a(Camera.Parameters parameters) {
            c cVar = this.f1297a.get();
            if (cVar == null) {
                a.a.a.a.a.e.e.g.d("CameraManager", "onParametersChanged: mananger is null");
            } else {
                cVar.D = parameters;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$l.class */
    public class l extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a.a.a.a.a.a.b f1298a;

        /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$l$a.class */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.a(cVar.j.getReqCameraId(), l.this.f1298a);
            }
        }

        public l(a.a.a.a.a.a.b bVar) {
            this.f1298a = bVar;
            setName("CameraStartUp");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            c.this.q.removeCallbacksAndMessages(null);
            c.this.q.post(new a());
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/c$m.class */
    public static class m {

        /* renamed from: a  reason: collision with root package name */
        public SurfaceTexture f1300a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public Object f1301c;

        public m(SurfaceTexture surfaceTexture, int i, Object obj) {
            this.f1300a = surfaceTexture;
            this.b = i;
            this.f1301c = obj;
        }
    }

    public c(Context context, AspectFrameLayout aspectFrameLayout, GLSurfaceView gLSurfaceView, j jVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.M = new a.a.a.a.a.b.a(new a());
        } else {
            this.M = null;
        }
        this.N = false;
        this.O = false;
        this.Q = 0;
        this.R = 0;
        this.S = false;
        this.T = false;
        b bVar = new b(this);
        this.V = bVar;
        this.W = bVar;
        this.X = new ArrayList();
        this.h = context.getApplicationContext();
        this.e = aspectFrameLayout;
        this.f1287a = gLSurfaceView;
        HandlerThread handlerThread = new HandlerThread("CameraManagerHt");
        handlerThread.start();
        this.q = new i(handlerThread.getLooper(), this);
        if (jVar != null) {
            this.W = jVar;
        }
        a.a.a.a.a.b.b.a().a(new k(this));
    }

    public final void A() {
        w();
        this.f1288c.a(this.z);
        if (!this.A) {
            this.j.a(this.z);
        }
        a.a.a.a.a.b.g gVar = this.i;
        if (gVar != null) {
            gVar.a(this.z);
            AspectFrameLayout aspectFrameLayout = this.e;
            if (aspectFrameLayout != null) {
                this.i.a(aspectFrameLayout.getWidth(), this.e.getHeight());
            } else {
                this.i.a(this.f1287a.getWidth(), this.f1287a.getHeight());
            }
        }
    }

    public final boolean B() {
        boolean z;
        if (a.a.a.a.a.e.c.a().c()) {
            synchronized (this.d) {
                a.a.a.a.a.e.e.g.c("CameraManager", "isSupportedTorch getParameters");
                Camera.Parameters d2 = this.f1288c.d();
                z = false;
                if (d2.getSupportedFlashModes() != null) {
                    z = false;
                    if (d2.getSupportedFlashModes().contains("torch")) {
                        z = true;
                    }
                }
            }
            return z;
        }
        return false;
    }

    public final void C() {
        synchronized (this.d) {
            if (this.f1288c != null) {
                this.v = false;
                this.f1288c.a();
                this.u = true;
                this.f1288c = null;
                this.D = null;
                this.r = false;
                a.a.a.a.a.e.e.g.c("CameraManager", "releaseCamera -- done");
            }
            if (this.i != null) {
                this.i.c();
            }
        }
    }

    public final void D() {
        a.a.a.a.a.e.e.g.c("CameraManager", "handleCameraPreviewReady");
        this.n = null;
        if (this.u) {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
            eVar.e("CameraManager", "Error occurs in handleCameraPreviewReady, mIsCameraReleased=" + this.u + ",mCameraManagerListener=" + this.W);
            return;
        }
        F();
        if (this.v) {
            this.W.onStateChanged(StreamingState.CAMERA_SWITCHED, Integer.valueOf(this.j.getReqCameraId()));
        }
        try {
            boolean B = B();
            this.W.onStateChanged(StreamingState.TORCH_INFO, Boolean.valueOf(B));
            this.s = true;
            if (B && this.t) {
                new Thread(new g()).start();
            }
            this.v = false;
        } catch (NullPointerException e2) {
            a.a.a.a.a.e.e.g.e("CameraManager", "parameter is null");
        }
    }

    public final void E() {
        String[] strArr = {"auto", "continuous-picture", "continuous-video"};
        this.i = new a.a.a.a.a.b.g(this.j, strArr, this.f, this.f1288c.d(), this, a.a.a.a.a.b.b.a().c(), this.h.getMainLooper(), this.g);
    }

    public final void F() {
        a.a.a.a.a.b.g gVar = this.i;
        if (gVar == null) {
            E();
        } else {
            gVar.a(a.a.a.a.a.b.b.a().c());
            this.i.a(this.f1288c.d());
        }
        AspectFrameLayout aspectFrameLayout = this.e;
        if (aspectFrameLayout != null) {
            this.i.a(aspectFrameLayout.getWidth(), this.e.getHeight());
        } else {
            this.i.a(this.f1287a.getWidth(), this.f1287a.getHeight());
        }
    }

    public final void G() {
        b.d dVar = this.f1288c;
        if (dVar == null) {
            return;
        }
        Camera.Parameters d2 = dVar.d();
        if (d2 == null) {
            a.a.a.a.a.e.e.g.d("CameraManager", "param is null while getParameters");
            return;
        }
        if (this.G) {
            d2.setAutoExposureLock(this.i.j());
        }
        if (this.H) {
            d2.setAutoWhiteBalanceLock(this.i.j());
        }
        if (this.E) {
            d2.setFocusAreas(this.i.e());
        }
        if (this.F) {
            d2.setMeteringAreas(this.i.f());
        }
        d2.setFocusMode(this.i.d());
        c(d2);
        this.f1288c.a(d2);
    }

    public final boolean H() {
        return this.j.isPreviewSizeOptimize() && this.A;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005d, code lost:
        if (r0 == 270) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap a(android.graphics.Bitmap r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.b.c.a(android.graphics.Bitmap, boolean):android.graphics.Bitmap");
    }

    public final Camera.Size a(Camera.Parameters parameters, int i2) {
        Camera.Size size;
        Camera.Size size2;
        Iterator<Camera.Size> it = a.a.a.a.a.b.f.a(a.a.a.a.a.b.f.a(parameters.getSupportedPreviewSizes(), this.j.getPrvSizeRatio())).iterator();
        while (true) {
            if (!it.hasNext()) {
                size = null;
                break;
            }
            size = it.next();
            if (size.width * size.height >= i2) {
                break;
            }
        }
        Camera.Size size3 = size;
        if (size == null) {
            List<Camera.Size> a2 = a.a.a.a.a.b.f.a(parameters.getSupportedPreviewSizes());
            Iterator<Camera.Size> it2 = a2.iterator();
            do {
                size2 = size;
                if (!it2.hasNext()) {
                    break;
                }
                size2 = it2.next();
            } while (size2.width * size2.height < i2);
            size3 = size2;
            if (size2 == null) {
                size3 = a2.get(a2.size() - 1);
            }
        }
        this.j.a(a.a.a.a.a.b.f.a(size3.width, size3.height));
        a.a.a.a.a.e.e.g.c("CameraManager", "adjust preview size to " + size3.width + "x" + size3.height);
        return size3;
    }

    public PreviewAppearance a() {
        return this.k;
    }

    public void a(int i2) {
        synchronized (this.d) {
            if (this.f1288c != null && this.r) {
                Camera.Parameters d2 = this.f1288c.d();
                if (d2 == null) {
                    a.a.a.a.a.e.e.g.e("CameraManager", "parameters is null");
                    return;
                } else if (d2.getMinExposureCompensation() == 0 && d2.getMaxExposureCompensation() == 0) {
                    a.a.a.a.a.e.e.g.e("CameraManager", "Exposure compensation is not supported");
                    return;
                } else {
                    d2.setExposureCompensation(i2);
                    this.f1288c.a(d2);
                    return;
                }
            }
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
            eVar.e("CameraManager", "mCamera:" + this.f1288c + ",mIsPreviewReady:" + this.r);
        }
    }

    public void a(int i2, int i3) {
        a.a.a.a.a.b.g gVar;
        if (this.f1288c == null || !this.r) {
            return;
        }
        if ((this.E || this.F) && (gVar = this.i) != null) {
            gVar.b(i2, i3);
        }
    }

    public final void a(m mVar) {
        synchronized (this.d) {
            a.a.a.a.a.e.e.g.c("CameraManager", "handleSetSurfaceTexture");
            if (mVar != null && this.f1288c != null && mVar.f1300a != null) {
                this.m = mVar;
                F();
                this.i.h();
                this.f1288c.c();
                this.m.f1300a.setOnFrameAvailableListener(this);
                this.f1288c.a(this.m.f1300a);
                this.f1288c.b();
                q();
                this.i.a();
                return;
            }
            a.a.a.a.a.e.e.g.d("CameraManager", "st/camera is null while handleSetSurfaceTexture");
        }
    }

    public final void a(Bitmap bitmap) {
        FrameCapturedCallback frameCapturedCallback = this.P;
        if (frameCapturedCallback != null) {
            frameCapturedCallback.onFrameCaptured(bitmap);
        }
    }

    public final void a(Camera.Parameters parameters) {
        Camera.Size size;
        Camera.Size size2;
        if (parameters == null) {
            a.a.a.a.a.e.e.g.e("CameraManager", "updateCameraPrvSize paras is null");
            return;
        }
        boolean H = H();
        a.a.a.a.a.e.e.g.c("CameraManager", "level:" + this.j.getPrvSizeLevel() + ",ratio:" + this.j.getPrvSizeRatio() + ",prvSizeOptEnabled:" + H);
        if (H) {
            size = null;
        } else if (this.j.g()) {
            size = this.W.onPreviewSizeSelected(a.a.a.a.a.b.f.a(a.a.a.a.a.b.f.a(parameters.getSupportedPreviewSizes(), this.j.getPrvSizeRatio())));
        } else {
            Camera.Size onPreviewSizeSelected = this.W.onPreviewSizeSelected(a.a.a.a.a.b.f.a(parameters.getSupportedPreviewSizes()));
            size = onPreviewSizeSelected;
            if (onPreviewSizeSelected != null) {
                this.j.a(a.a.a.a.a.b.f.a(onPreviewSizeSelected.width, onPreviewSizeSelected.height));
                size = onPreviewSizeSelected;
            }
        }
        Camera.Size size3 = size;
        if (size == null) {
            if (!this.j.g()) {
                this.j.a(a.a.a.a.a.e.d.f1359c);
            }
            Camera.Size a2 = a.a.a.a.a.b.f.a(parameters, this.j.getPrvSizeRatio(), this.j.getPrvSizeLevel());
            size3 = a2;
            if (H) {
                Camera.Size size4 = a2;
                if (a2 != null) {
                    size4 = a2;
                    if (a2.height > 480) {
                        Camera.Size b2 = a.a.a.a.a.b.f.b(parameters.getSupportedPreviewSizes(), this.j.getPrvSizeRatio(), 480);
                        size4 = b2;
                        if (b2 != null) {
                            a.a.a.a.a.e.e.g.c("CameraManager", "optimized preview size to width: " + b2.width + " height: " + b2.height);
                            size4 = b2;
                        }
                    }
                }
                size3 = size4;
                if (size4 == null) {
                    Camera.Size a3 = a.a.a.a.a.b.f.a(parameters.getSupportedPreviewSizes(), this.j.getPrvSizeRatio(), 480);
                    Camera.Size size5 = a3;
                    if (a3 == null) {
                        List<Camera.Size> a4 = a.a.a.a.a.b.f.a(a.a.a.a.a.b.f.a(parameters.getSupportedPreviewSizes(), 480));
                        List<Camera.Size> a5 = a.a.a.a.a.b.f.a(a.a.a.a.a.b.f.b(parameters.getSupportedPreviewSizes(), 480));
                        if (a4.isEmpty()) {
                            size5 = a3;
                            if (!a5.isEmpty()) {
                                size2 = a5.get(a5.size() - 1);
                            }
                        } else {
                            size2 = a4.get(0);
                        }
                        size5 = size2;
                    }
                    size3 = size5;
                    if (size5 != null) {
                        parameters.setPreviewSize(size5.width, size5.height);
                        double a6 = a.a.a.a.a.b.f.a(this.j.getPrvSizeRatio());
                        int i2 = size5.width;
                        int i3 = (int) (i2 / a6);
                        a.a.a.a.a.e.e.g.c("CameraManager", "crop optimized preview size width: " + size5.width + " height: " + size5.height + " to width:" + i2 + " height: " + i3);
                        this.j.a(i2, i3);
                        this.j.a(true);
                        size3 = size5;
                    }
                }
            }
        }
        this.T = false;
        Camera.Size size6 = size3;
        if (size3 == null) {
            size6 = parameters.getPreviewSize();
            this.T = true;
            a.a.a.a.a.e.e.g.c("CameraManager", "Error! Didn't find the specific preview size. Choose the default size:" + size6.width + "x" + size6.height);
            this.W.onStateChanged(StreamingState.NO_SUPPORTED_PREVIEW_SIZE, size6);
        }
        a.a.a.a.a.e.f a7 = this.U.a();
        Camera.Size size7 = size6;
        if (a7 != null) {
            int a8 = a7.a() * a7.b();
            int i4 = size6.width;
            int i5 = size6.height;
            a.a.a.a.a.e.e.g.d("CameraManager", "preview size " + size6.width + "x" + size6.height + " encoding size " + a7.a() + "x" + a7.b());
            size7 = size6;
            if (i4 * i5 < a8) {
                a.a.a.a.a.e.e.g.d("CameraManager", "preview size smaller than encoding size, adjust now.");
                size7 = a(parameters, a8);
            }
        }
        if (this.T) {
            a.a.a.a.a.e.e.g.d("CameraManager", "notifyNoSupportedPrvSize mIsCameraSwitched:" + this.v);
            this.W.a(size7);
        } else {
            this.W.a((Camera.Size) null);
        }
        a.a.a.a.a.e.e.g.c("CameraManager", "setCameraPreviewSize size.width:" + size7.width + ",size.height:" + size7.height);
        this.j.b(size7.width, size7.height);
        AspectFrameLayout aspectFrameLayout = this.e;
        if (aspectFrameLayout != null) {
            aspectFrameLayout.setAspectRatio(y());
        }
    }

    public void a(ViewGroup viewGroup, View view) {
        a.a.a.a.a.b.g gVar = this.i;
        if (gVar != null) {
            gVar.a(viewGroup, view);
            return;
        }
        this.f = viewGroup;
        this.g = view;
    }

    public void a(CameraStreamingSetting cameraStreamingSetting, WatermarkSetting watermarkSetting, PreviewAppearance previewAppearance, boolean z, StreamingPreviewCallback streamingPreviewCallback) {
        this.j = cameraStreamingSetting;
        this.l = watermarkSetting;
        this.A = z;
        this.k = previewAppearance;
        this.o = streamingPreviewCallback;
        u();
    }

    public void a(StreamingPreviewCallback streamingPreviewCallback, boolean z) {
        this.p = z;
        this.o = streamingPreviewCallback;
        q();
        a.a.a.a.a.b.e eVar = this.b;
        if (eVar != null) {
            if (!z) {
                streamingPreviewCallback = null;
            }
            eVar.a(streamingPreviewCallback);
        }
    }

    public void a(SurfaceTextureCallback surfaceTextureCallback) {
        a.a.a.a.a.b.e eVar = this.b;
        if (eVar != null) {
            eVar.a(surfaceTextureCallback);
            return;
        }
        a.a.a.a.a.e.e.g.c("CameraManager", "mRenderer is null, save for latter use");
        this.X.add(surfaceTextureCallback);
    }

    public void a(WatermarkSetting watermarkSetting) {
        WatermarkSetting watermarkSetting2 = this.l;
        if (watermarkSetting2 != null) {
            watermarkSetting2.release();
        }
        this.l = watermarkSetting;
        a.a.a.a.a.b.e eVar = this.b;
        if (eVar != null) {
            eVar.a(watermarkSetting);
        }
    }

    public final void a(ByteBuffer byteBuffer) {
        synchronized (this.d) {
            if (this.P != null && this.f1288c != null) {
                long currentTimeMillis = System.currentTimeMillis();
                Camera.Parameters d2 = this.f1288c.d();
                if (d2 == null) {
                    this.P.onFrameCaptured(null);
                    return;
                }
                Camera.Size previewSize = d2.getPreviewSize();
                if (previewSize == null) {
                    this.P.onFrameCaptured(null);
                    return;
                }
                int i2 = previewSize.width;
                int i3 = previewSize.height;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new YuvImage(byteBuffer.array(), d2.getPreviewFormat(), i2, i3, null).compressToJpeg(new Rect(0, 0, i2, i3), 80, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                boolean z = this.Q > 0 && this.R > 0;
                Bitmap a2 = a(!z ? a.a.a.a.a.e.h.a(byteArray, 0, byteArray.length, i2, i3, this.z) : a.a.a.a.a.e.h.a(byteArray, 0, byteArray.length, this.Q, this.R, this.z), z);
                a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
                eVar.c("CameraManager", "reqBitmap.w:" + a2.getWidth() + ",reqBitmap.h:" + a2.getHeight());
                a.a.a.a.a.e.e eVar2 = a.a.a.a.a.e.e.g;
                eVar2.c("CameraManager", "end capturing cost:" + (System.currentTimeMillis() - currentTimeMillis));
                this.P.onFrameCaptured(a2);
                this.y = null;
                return;
            }
            a.a.a.a.a.e.e eVar3 = a.a.a.a.a.e.e.g;
            eVar3.e("CameraManager", "mCamera : " + this.f1288c + ", mFrameCapturedCallback : " + this.P);
        }
    }

    public void a(boolean z) {
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
        eVar.b("CameraManager", "changeRecordingState: was " + this.O + ",now:" + z);
        this.O = z;
        if (z) {
            return;
        }
        this.B = false;
        this.C = false;
    }

    public void a(boolean z, int i2, int i3, FrameCapturedCallback frameCapturedCallback) {
        this.P = frameCapturedCallback;
        this.Q = i2;
        this.R = i3;
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
        eVar.c("CameraManager", "mCaptureWidth:" + this.Q + ",mCaptureHeight:" + this.R + ",isNeedPreviewFrameCb:" + v());
        synchronized (this.d) {
            if (v()) {
                this.S = true;
            } else {
                this.f1288c.b(new d());
            }
        }
    }

    public final void a(byte[] bArr) {
        if (this.y != null) {
            a.a.a.a.a.e.e.g.d("CameraManager", "capture request arrived. So ignore this req");
            return;
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
        this.y = allocate;
        allocate.clear();
        this.y.put(bArr);
        i iVar = this.q;
        if (iVar == null) {
            this.y.clear();
            this.y = null;
            return;
        }
        iVar.removeMessages(4);
        i iVar2 = this.q;
        iVar2.sendMessage(iVar2.obtainMessage(4, this.y));
    }

    public final void a(byte[] bArr, int i2, int i3, int i4, long j2) {
        if (this.S) {
            this.S = false;
            a(bArr);
        }
        if (this.O && !this.A && !this.C && !this.B) {
            this.B = true;
            this.W.e();
        }
        if (this.p) {
            return;
        }
        this.W.a(bArr, i2, i3, h(), i4, j2, !this.A && this.O && this.C);
    }

    public final boolean a(int i2, a.a.a.a.a.a.b bVar) {
        int i3;
        List<int[]> supportedPreviewFpsRange;
        int onPreviewFpsSelected;
        a.a.a.a.a.e.e.g.c("CameraManager", "openCameraInternal id:" + i2 + ",tid:" + Thread.currentThread().getId());
        this.U = bVar;
        synchronized (this.d) {
            try {
                b.d b2 = a.a.a.a.a.b.b.a().b(i2);
                this.f1288c = b2;
                if (b2 == null) {
                    a.a.a.a.a.e.e.g.e("CameraManager", "Unable to open camera, id:" + i2);
                    this.W.a(i2);
                    return false;
                }
                this.u = false;
                Camera.Parameters d2 = this.f1288c.d();
                if (d2 == null) {
                    a.a.a.a.a.e.e.g.e("CameraManager", "camera released");
                    return false;
                }
                this.D = d2;
                b(d2);
                if (this.j.isCAFEnabled()) {
                    if (d2.getSupportedFocusModes().contains("continuous-picture")) {
                        d2.setFocusMode("continuous-picture");
                    } else if (d2.getSupportedFocusModes().contains(this.j.getFocusMode())) {
                        d2.setFocusMode(this.j.getFocusMode());
                    }
                    c(d2);
                }
                if (this.W == null || (onPreviewFpsSelected = this.W.onPreviewFpsSelected((supportedPreviewFpsRange = d2.getSupportedPreviewFpsRange()))) < 0 || onPreviewFpsSelected >= supportedPreviewFpsRange.size()) {
                    i3 = 0;
                } else {
                    int[] iArr = supportedPreviewFpsRange.get(onPreviewFpsSelected);
                    d2.setPreviewFpsRange(iArr[0], iArr[1]);
                    i3 = iArr[1];
                    a.a.a.a.a.e.e.g.c("CameraManager", "chose external fps: " + iArr[0] + " - " + iArr[1]);
                }
                if (i3 <= 0) {
                    i3 = a.a.a.a.a.b.f.a(d2, bVar.q());
                }
                bVar.b(i3);
                boolean a2 = this.j.a();
                a.a.a.a.a.e.e.g.c("CameraManager", "hint:" + a2);
                d2.setRecordingHint(a2);
                List<Integer> supportedPreviewFormats = d2.getSupportedPreviewFormats();
                a.a.a.a.a.e.e.g.b("CameraManager", "TOTAL SUPPORTED FORMATS: " + supportedPreviewFormats.size());
                Iterator<Integer> it = supportedPreviewFormats.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Integer next = it.next();
                    a.a.a.a.a.e.e.g.b("CameraManager", "SUPPORTED FORMAT: " + next);
                    if (next.intValue() == 17) {
                        d2.setPreviewFormat(17);
                        this.w = true;
                        break;
                    }
                }
                a(d2);
                d2.setPreviewSize(this.j.getCameraPreviewWidth(), this.j.getCameraPreviewHeight());
                this.f1288c.a(d2);
                Camera.Parameters d3 = this.f1288c.d();
                if (d3 != null) {
                    Camera.Size previewSize = d3.getPreviewSize();
                    if (previewSize.width * previewSize.height != this.j.getCameraPreviewWidth() * this.j.getCameraPreviewHeight()) {
                        a.a.a.a.a.e.e.g.c("CameraManager", "updatePrvSize size.width:" + previewSize.width + ",size.height:" + previewSize.height);
                        this.j.b(previewSize.width, previewSize.height);
                    }
                } else {
                    a.a.a.a.a.e.e.g.d("CameraManager", "param is null");
                }
                if (this.b != null) {
                    this.b.a(this.l);
                    if (!this.x) {
                        boolean z = false;
                        if (a.a.a.a.a.b.b.a().c()) {
                            z = false;
                            if (this.j.isFrontCameraPreviewMirror()) {
                                z = true;
                            }
                        }
                        this.b.a(z);
                        this.x = true;
                    }
                }
                A();
                a.a.a.a.a.e.e.g.c("CameraManager", "openCameraInternal onResume");
                this.f1287a.onResume();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                this.W.a(i2);
                return false;
            }
        }
    }

    public boolean a(a.a.a.a.a.a.b bVar) {
        if (!a.a.a.a.a.e.h.e(this.h)) {
            a.a.a.a.a.e.e.g.e("CameraManager", "Fatal error. No camera!");
            return false;
        }
        this.f1287a.onPause();
        b(bVar);
        return true;
    }

    public boolean a(a.a.a.a.a.a.b bVar, CameraStreamingSetting.CAMERA_FACING_ID camera_facing_id) {
        int d2 = a.a.a.a.a.b.b.a().d();
        if (camera_facing_id == null) {
            a.a.a.a.a.e.e.g.e("CameraManager", "Invalid camera facing id");
            b(false);
            return false;
        } else if (d2 < 2) {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
            eVar.e("CameraManager", "Cannot switch camera as number of cameras is :" + d2);
            b(false);
            return false;
        } else if (this.n != null) {
            a.a.a.a.a.e.e.g.e("CameraManager", "Cannot switch camera since camera switching.");
            b(false);
            return false;
        } else {
            a.a.a.a.a.b.g gVar = this.i;
            if (gVar != null) {
                gVar.i();
            }
            a.a.a.a.a.e.e eVar2 = a.a.a.a.a.e.e.g;
            eVar2.c("CameraManager", "switchCamera current cameraid:" + this.j.getReqCameraId() + ",mRecordingEnabled=" + this.O);
            this.r = false;
            if (this.N) {
                this.W.b();
            }
            this.f1287a.queueEvent(new RunnableC0007c());
            this.f1287a.onPause();
            this.j.setCameraFacingId(camera_facing_id);
            this.v = true;
            this.x = false;
            b(bVar);
            return true;
        }
    }

    public void b(int i2) {
        this.b.a(i2);
    }

    public final void b(a.a.a.a.a.a.b bVar) {
        synchronized (this) {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
            eVar.c("CameraManager", "launchCameraStartUpThread mCameraStartUpThread:" + this.n);
            l lVar = new l(bVar);
            this.n = lVar;
            lVar.start();
            a.a.a.a.a.e.e.g.c("CameraManager", "launchCameraStartUpThread -");
        }
    }

    public final void b(Camera.Parameters parameters) {
        this.E = parameters.getMaxNumFocusAreas() > 0 && a.a.a.a.a.e.h.a("auto", parameters.getSupportedFocusModes());
        this.F = parameters.getMaxNumMeteringAreas() > 0;
        this.G = parameters.isAutoExposureLockSupported();
        this.H = parameters.isAutoWhiteBalanceLockSupported();
        this.I = parameters.getSupportedFocusModes().contains("continuous-picture");
    }

    public void b(boolean z) {
        this.N = z;
    }

    public boolean b() {
        return this.r;
    }

    public void c(int i2) {
        synchronized (this.d) {
            if (this.D != null) {
                this.D.setZoom(i2);
                this.f1288c.a(this.D);
            }
        }
    }

    public final void c(Camera.Parameters parameters) {
        if (this.I) {
            String focusMode = parameters.getFocusMode();
            if (this.M == null || !("continuous-video".equals(focusMode) || "continuous-picture".equals(focusMode))) {
                this.f1288c.a((Camera.AutoFocusMoveCallback) null);
            } else {
                this.f1288c.a((a.a.a.a.a.b.a) this.M);
            }
        }
    }

    public void c(boolean z) {
        this.C = z;
    }

    public boolean c() {
        return this.v;
    }

    @Override // a.a.a.a.a.b.g.a
    public void d(int i2) {
    }

    public void d(boolean z) {
        if (z != this.A) {
            this.A = z;
            q();
        }
    }

    public boolean d() {
        if (a.a.a.a.a.e.c.a().c()) {
            synchronized (this.d) {
                if (this.t) {
                    if (this.f1288c != null && this.r) {
                        Camera.Parameters d2 = this.f1288c.d();
                        if (d2 == null) {
                            a.a.a.a.a.e.e.g.e("CameraManager", "camera parameters is null");
                            return false;
                        }
                        List<String> supportedFlashModes = d2.getSupportedFlashModes();
                        String flashMode = d2.getFlashMode();
                        if (supportedFlashModes == null) {
                            a.a.a.a.a.e.e.g.e("CameraManager", "getSupportedFlashModes is null");
                            return false;
                        }
                        if (!"off".equals(flashMode)) {
                            if (!supportedFlashModes.contains("off")) {
                                a.a.a.a.a.e.e.g.e("CameraManager", "FLASH_MODE_OFF not supported");
                                return false;
                            }
                            if (a.a.a.a.a.e.c.a().b()) {
                                d2.setFocusMode("continuous-video");
                            }
                            d2.setFlashMode("off");
                            this.f1288c.a(d2);
                            this.t = false;
                        }
                        return true;
                    }
                    a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
                    eVar.e("CameraManager", "mCamera:" + this.f1288c + ",mIsPreviewReady=" + this.r);
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    public boolean e() {
        if (a.a.a.a.a.e.c.a().c()) {
            synchronized (this.d) {
                if (this.f1288c != null && this.r) {
                    Camera.Parameters d2 = this.f1288c.d();
                    if (d2 == null) {
                        a.a.a.a.a.e.e.g.e("CameraManager", "parameters is null");
                        return false;
                    }
                    List<String> supportedFlashModes = d2.getSupportedFlashModes();
                    if (supportedFlashModes == null) {
                        a.a.a.a.a.e.e.g.e("CameraManager", "getSupportedFlashModes is null");
                        return false;
                    }
                    if (!"torch".equals(d2.getFlashMode())) {
                        if (!supportedFlashModes.contains("torch")) {
                            a.a.a.a.a.e.e.g.e("CameraManager", "FLASH_MODE_TORCH not supported");
                            return false;
                        }
                        if (a.a.a.a.a.e.c.a().b()) {
                            d2.setFocusMode(Camera.Parameters.FOCUS_MODE_MACRO);
                        }
                        d2.setFlashMode("torch");
                        this.f1288c.a(d2);
                        this.t = true;
                    }
                    return true;
                }
                a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
                eVar.e("CameraManager", "mCamera:" + this.f1288c + ",mIsPreviewReady:" + this.r + ", mIsLightOn:" + this.t);
                return false;
            }
        }
        return false;
    }

    public boolean e(boolean z) {
        a.a.a.a.a.b.e eVar = this.b;
        if (eVar != null) {
            return eVar.a(z);
        }
        a.a.a.a.a.e.e.g.e("CameraManager", "setMirror while mRenderer is null");
        return false;
    }

    public int f() {
        b.d dVar = this.f1288c;
        if (dVar != null && this.r) {
            Camera.Parameters d2 = dVar.d();
            if (d2 == null) {
                a.a.a.a.a.e.e.g.e("CameraManager", "parameters is null");
                return 0;
            }
            return d2.getMinExposureCompensation();
        }
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
        eVar.e("CameraManager", "mCamera:" + this.f1288c + ",mIsPreviewReady:" + this.r);
        return 0;
    }

    public int g() {
        b.d dVar = this.f1288c;
        if (dVar != null && this.r) {
            Camera.Parameters d2 = dVar.d();
            if (d2 == null) {
                a.a.a.a.a.e.e.g.e("CameraManager", "parameters is null");
                return 0;
            }
            return d2.getMaxExposureCompensation();
        }
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
        eVar.e("CameraManager", "mCamera:" + this.f1288c + ",mIsPreviewReady:" + this.r);
        return 0;
    }

    public int h() {
        int i2;
        w();
        synchronized (this.d) {
            i2 = a.a.a.a.a.b.b.a().c() ? (360 - this.z) % 360 : this.z;
        }
        return i2;
    }

    public WatermarkSetting i() {
        return this.l;
    }

    public m j() {
        return this.m;
    }

    public void k() {
        boolean hasMessages = this.q.hasMessages(4);
        this.q.removeCallbacksAndMessages(null);
        if (this.S || hasMessages) {
            this.S = false;
            this.P.onFrameCaptured(null);
        }
        C();
        this.f1287a.queueEvent(new e());
        this.f1287a.onPause();
    }

    public void l() {
        i iVar = this.q;
        if (iVar != null) {
            iVar.a();
        }
        WatermarkSetting watermarkSetting = this.l;
        if (watermarkSetting != null) {
            watermarkSetting.release();
            this.l = null;
        }
        this.W = this.V;
        this.x = false;
    }

    public void m() {
        AspectFrameLayout aspectFrameLayout = this.e;
        if (aspectFrameLayout != null) {
            aspectFrameLayout.a(a.a.a.a.a.e.h.d(this.h));
            this.e.setAspectRatio(y());
        }
    }

    public boolean n() {
        Camera.Parameters parameters = this.D;
        if (parameters != null) {
            return parameters.isZoomSupported();
        }
        return false;
    }

    public int o() {
        Camera.Parameters parameters = this.D;
        if (parameters != null) {
            return parameters.getMaxZoom();
        }
        return 0;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        int b2;
        a.a.a.a.a.e.e.g.a("CameraManager", "ST onFrameAvailable");
        if (this.u) {
            a.a.a.a.a.e.e.g.e("CameraManager", "camera have been closed!!");
            return;
        }
        this.f1287a.requestRender();
        if (this.b.a()) {
            if (this.s) {
                this.s = false;
                this.W.c();
            }
            if (this.O) {
                if (!this.C) {
                    if (!this.B) {
                        this.B = true;
                        this.W.e();
                    }
                    a.a.a.a.a.e.e.g.c("CameraManager", "ignore the frame.");
                    return;
                }
                int i2 = this.m.b;
                boolean z = false;
                if (this.b != null) {
                    synchronized (a.a.a.a.a.a.h.f.d) {
                        b2 = this.b.b();
                    }
                    z = false;
                    i2 = b2;
                    if (b2 != this.m.b) {
                        z = true;
                        i2 = b2;
                    }
                }
                this.W.a(i2, System.nanoTime(), z);
            }
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (bArr == null || this.u) {
            return;
        }
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
        eVar.a("CameraManager", "onPreviewFrame + length:" + bArr.length + ",mRecordingEnabled:" + this.O);
        a(bArr, this.j.getCameraPreviewWidth(), this.j.getCameraPreviewHeight(), PLFourCC.FOURCC_NV21, System.nanoTime());
        if (this.u) {
            return;
        }
        camera.addCallbackBuffer(bArr);
    }

    public int p() {
        Camera.Parameters parameters = this.D;
        if (parameters != null) {
            return parameters.getZoom();
        }
        return 0;
    }

    public void q() {
        if (!v()) {
            a.a.a.a.a.e.e.g.d("CameraManager", "no need addCallbackBuffer and uninstall the preview callback");
            synchronized (this.d) {
                if (this.f1288c != null) {
                    this.f1288c.a((Camera.PreviewCallback) null);
                }
            }
            return;
        }
        synchronized (this.d) {
            if (this.f1288c == null) {
                a.a.a.a.a.e.e.g.d("CameraManager", "mCamera is null in preparePreviewCallback");
                return;
            }
            Camera.Parameters d2 = this.f1288c.d();
            if (d2 == null) {
                a.a.a.a.a.e.e.g.d("CameraManager", "params is null");
                return;
            }
            if (this.w) {
                Camera.Size previewSize = d2.getPreviewSize();
                int bitsPerPixel = ImageFormat.getBitsPerPixel(d2.getPreviewFormat());
                int i2 = ((previewSize.width * previewSize.height) * bitsPerPixel) / 8;
                a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
                eVar.c("CameraManager", "preview format:" + d2.getPreviewFormat() + ",bitsPerPixel:" + bitsPerPixel);
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= 2) {
                        break;
                    }
                    a.a.a.a.a.e.e eVar2 = a.a.a.a.a.e.e.g;
                    eVar2.c("CameraManager", "addCallbackBuffer size:" + i2);
                    arrayList.add(new byte[i2]);
                    i3 = i4 + 1;
                }
                this.f1288c.a(this);
                this.f1288c.a(arrayList);
            } else {
                this.W.f();
            }
        }
    }

    @Override // a.a.a.a.a.b.g.a
    public void r() {
        if (this.f1288c != null) {
            this.K = System.currentTimeMillis();
            this.f1288c.a(this.L);
        }
    }

    @Override // a.a.a.a.a.b.g.a
    public void s() {
        b.d dVar = this.f1288c;
        if (dVar != null) {
            dVar.e();
            G();
        }
    }

    @Override // a.a.a.a.a.b.g.a
    public void t() {
        G();
    }

    public final void u() {
        this.f1287a.setEGLContextClientVersion(2);
        this.b = new a.a.a.a.a.b.e(this.q);
        for (SurfaceTextureCallback surfaceTextureCallback : this.X) {
            this.b.a(surfaceTextureCallback);
        }
        this.X.clear();
        this.b.a(this.p ? this.o : null);
        this.b.a(this.k);
        this.b.a(this.l);
        this.f1287a.setRenderer(this.b);
        this.f1287a.setRenderMode(0);
    }

    public final boolean v() {
        return a.a.a.a.a.f.e.a().e();
    }

    public final void w() {
        int b2 = a.a.a.a.a.e.h.b(this.h);
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
        eVar.b("CameraManager", "handle setting camera orientation, mCameraInfo.facing:" + a.a.a.a.a.b.b.a().b().facing + ",degrees:" + b2 + ",orientation:" + a.a.a.a.a.b.b.a().b().orientation);
        this.z = a.a.a.a.a.b.b.a().c() ? (360 - ((a.a.a.a.a.b.b.a().b().orientation + b2) % 360)) % 360 : ((a.a.a.a.a.b.b.a().b().orientation - b2) + 360) % 360;
    }

    public final void x() {
        boolean d2 = this.j.d();
        int c2 = this.j.c();
        int b2 = this.j.b();
        int cameraPreviewWidth = this.j.getCameraPreviewWidth();
        int cameraPreviewHeight = this.j.getCameraPreviewHeight();
        boolean z = a.a.a.a.a.b.b.a().b().facing == 1;
        int i2 = this.z;
        boolean isPreviewAdaptToEncodingSize = this.j.isPreviewAdaptToEncodingSize();
        a.a.a.a.a.e.f a2 = this.U.a();
        int a3 = a2.a();
        int b3 = a2.b();
        a.a.a.a.a.b.e eVar = this.b;
        if (eVar != null) {
            eVar.a(d2, c2, b2, cameraPreviewWidth, cameraPreviewHeight, a3, b3, isPreviewAdaptToEncodingSize, z, i2);
        }
    }

    public final double y() {
        double d2;
        double d3;
        int cameraPreviewWidth = this.j.getCameraPreviewWidth();
        int cameraPreviewHeight = this.j.getCameraPreviewHeight();
        int c2 = this.j.c();
        int b2 = this.j.b();
        if (a.a.a.a.a.e.h.c(this.h)) {
            if (!this.j.d()) {
                return cameraPreviewWidth / cameraPreviewHeight;
            }
            d2 = c2;
            d3 = b2;
        } else if (!this.j.d()) {
            return cameraPreviewHeight / cameraPreviewWidth;
        } else {
            d2 = b2;
            d3 = c2;
        }
        return d2 / d3;
    }

    public final void z() {
        synchronized (this.d) {
            if (this.f1288c == null) {
                a.a.a.a.a.e.e.g.d("CameraManager", "Camera have been closed");
                return;
            }
            A();
            if (!this.r) {
                this.r = true;
                if (!a.a.a.a.a.f.e.a().e() && !a.a.a.a.a.f.e.a().c()) {
                    if (!a.a.a.a.a.f.e.a().d() && !a.a.a.a.a.f.e.a().b()) {
                        a.a.a.a.a.e.e.g.e("CameraManager", "Never go here! Never");
                        this.q.removeMessages(2);
                        this.q.sendMessage(this.q.obtainMessage(2));
                    }
                    this.j.b(PLFourCC.FOURCC_I420);
                    this.q.removeMessages(2);
                    this.q.sendMessage(this.q.obtainMessage(2));
                }
                this.j.b(PLFourCC.FOURCC_NV21);
                this.q.removeMessages(2);
                this.q.sendMessage(this.q.obtainMessage(2));
            }
            this.f1287a.queueEvent(new f());
        }
    }
}
