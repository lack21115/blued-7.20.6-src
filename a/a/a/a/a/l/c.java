package a.a.a.a.a.l;

import a.a.a.a.a.a.h.d;
import a.a.a.a.a.a.h.f;
import a.a.a.a.a.a.h.h;
import a.a.a.a.a.e.e;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.opengl.GLES11Ext;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.qiniu.pili.droid.streaming.PLScreenYUVCapturerListener;
import com.qiniu.pili.droid.streaming.ScreenSetting;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/l/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public MediaProjectionManager f1445a;
    public a.a.a.a.a.l.b b;

    /* renamed from: c  reason: collision with root package name */
    public ScreenSetting f1446c;
    public PLScreenYUVCapturerListener d;
    public d e;
    public h f;
    public Surface g;
    public SurfaceTexture h;
    public Surface i;
    public SurfaceTexture j;
    public a.a.a.a.a.b.i.q.a k;
    public a.a.a.a.a.b.i.a l;
    public final float[] m = new float[16];
    public int n;
    public boolean o;
    public boolean p;
    public volatile HandlerC0018c q;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/l/c$a.class */
    public class a implements SurfaceTexture.OnFrameAvailableListener {
        public a() {
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            if (c.this.p) {
                c.this.q.sendEmptyMessage(1);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/l/c$b.class */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d.onPrepared();
        }
    }

    /* renamed from: a.a.a.a.a.l.c$c  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/l/c$c.class */
    public static class HandlerC0018c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<c> f1449a;

        public HandlerC0018c(Looper looper, c cVar) {
            super(looper);
            this.f1449a = new WeakReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            c cVar = this.f1449a.get();
            e eVar = e.g;
            eVar.c("ScreenYUVCapturerCore", "GLHandler what:" + i + ",capturer=" + cVar);
            if (cVar == null) {
                e.g.d("ScreenYUVCapturerCore", "GLHandler.handleMessage: recoder is null");
            } else if (i == 0) {
                cVar.e();
            } else if (i == 1) {
                cVar.f();
            } else if (i == 2) {
                cVar.g();
            } else {
                throw new RuntimeException("Unhandled msg what=" + i);
            }
        }
    }

    public void a() {
        e.g.c("ScreenYUVCapturerCore", "start +");
        if (j()) {
            if (this.b == null || this.i == null) {
                h();
            } else if (d()) {
                e.g.d("ScreenYUVCapturerCore", "you are screen capturing now, can not start again!");
            } else {
                this.b.a(this.i);
                this.p = true;
                e.g.c("ScreenYUVCapturerCore", "start -");
            }
        }
    }

    public void a(Activity activity) {
        e.g.c("ScreenYUVCapturerCore", "requestScreenCapture +");
        if (j()) {
            if (d()) {
                e.g.d("ScreenYUVCapturerCore", "you are screen capturing now, can not request again!");
                return;
            }
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) activity.getSystemService(Context.MEDIA_PROJECTION_SERVICE);
            this.f1445a = mediaProjectionManager;
            activity.startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 2008);
            e.g.c("ScreenYUVCapturerCore", "requestScreenCapture -");
        }
    }

    public void a(ScreenSetting screenSetting, PLScreenYUVCapturerListener pLScreenYUVCapturerListener) {
        synchronized (this) {
            e.g.c("ScreenYUVCapturerCore", "prepare +");
            if (screenSetting == null) {
                throw new IllegalArgumentException("Error!!! screenSetting cannot be null");
            }
            if (pLScreenYUVCapturerListener == null) {
                throw new IllegalArgumentException("Error!!! screenYUVCaptureListener cannot be null");
            }
            e eVar = e.d;
            eVar.c("ScreenYUVCapturerCore", "prepare, screenSetting = " + screenSetting);
            if (this.o) {
                e.g.d("ScreenYUVCapturerCore", "you have prepared already!");
                return;
            }
            this.f1446c = screenSetting;
            this.d = pLScreenYUVCapturerListener;
            HandlerThread handlerThread = new HandlerThread("ScreenYUVCapturerCore");
            handlerThread.start();
            this.q = new HandlerC0018c(handlerThread.getLooper(), this);
            this.q.sendEmptyMessage(0);
            e.g.c("ScreenYUVCapturerCore", "prepare -");
        }
    }

    public boolean a(int i, int i2, Intent intent) {
        e.g.c("ScreenYUVCapturerCore", "onActivityResult +");
        if (j()) {
            if (i != 2008 || intent == null) {
                e.g.e("ScreenYUVCapturerCore", "param error, screen recorder init failed!");
                return false;
            }
            MediaProjection mediaProjection = this.f1445a.getMediaProjection(i2, intent);
            if (mediaProjection == null) {
                e.g.e("ScreenYUVCapturerCore", "something is wrong, screen recorder init failed!");
                return false;
            }
            ScreenSetting screenSetting = this.f1446c;
            if (screenSetting == null) {
                e.g.e("ScreenYUVCapturerCore", "please invoke prepare interface first!");
                return false;
            }
            this.b = new a.a.a.a.a.l.b(screenSetting.getWidth(), this.f1446c.getHeight(), this.f1446c.getDpi(), mediaProjection);
            this.d.onReady();
            e.g.c("ScreenYUVCapturerCore", "onActivityResult -");
            return true;
        }
        return false;
    }

    public void b() {
        e.g.c("ScreenYUVCapturerCore", "stop +");
        a.a.a.a.a.l.b bVar = this.b;
        if (bVar == null) {
            h();
            return;
        }
        bVar.a();
        this.p = false;
        e.g.c("ScreenYUVCapturerCore", "stop -");
    }

    public void c() {
        e.g.c("ScreenYUVCapturerCore", "release +");
        if (d()) {
            b();
        }
        this.q.sendEmptyMessage(2);
        this.o = false;
        e.g.c("ScreenYUVCapturerCore", "release -");
    }

    public boolean d() {
        return this.p;
    }

    public final void e() {
        this.e = new d(null, 1);
        this.h = new SurfaceTexture(1);
        Surface surface = new Surface(this.h);
        this.g = surface;
        h hVar = new h(this.e, surface, true);
        this.f = hVar;
        hVar.d();
        this.n = f.a((int) GLES11Ext.GL_TEXTURE_EXTERNAL_OES);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.n);
        this.j = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(this.f1446c.getWidth(), this.f1446c.getHeight());
        this.i = new Surface(this.j);
        this.j.setOnFrameAvailableListener(new a());
        this.k = new a.a.a.a.a.b.i.q.a();
        a.a.a.a.a.b.i.a aVar = new a.a.a.a.a.b.i.a();
        this.l = aVar;
        aVar.a(0, this.f1446c.getWidth(), this.f1446c.getHeight());
        this.o = true;
        new Handler(Looper.getMainLooper()).post(new b());
    }

    public final void f() {
        this.j.updateTexImage();
        this.j.getTransformMatrix(this.m);
        ByteBuffer a2 = this.k.a(this.l.b(this.n, this.m), this.f1446c.getWidth(), this.f1446c.getHeight());
        this.d.onFrameAvailable(a2, a2.capacity(), this.f1446c.getWidth(), this.f1446c.getHeight());
    }

    public final void g() {
        this.q.getLooper().quit();
        h hVar = this.f;
        if (hVar != null) {
            hVar.g();
            this.f = null;
        }
        d dVar = this.e;
        if (dVar != null) {
            dVar.b();
            this.e = null;
        }
        SurfaceTexture surfaceTexture = this.j;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.j = null;
        }
        Surface surface = this.i;
        if (surface != null) {
            surface.release();
            this.i = null;
        }
        Surface surface2 = this.g;
        if (surface2 != null) {
            surface2.release();
            this.g = null;
        }
        SurfaceTexture surfaceTexture2 = this.h;
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
            this.h = null;
        }
    }

    public final void h() {
        this.d.onError(2);
        e.g.e("ScreenYUVCapturerCore", "please make sure you have prepared by the callback onPrepared()");
    }

    public final void i() {
        this.d.onError(1);
        e.g.e("ScreenYUVCapturerCore", "failed to requestScreenYUVCapture, Android version < LOLLIPOP !");
    }

    public final boolean j() {
        if (Build.VERSION.SDK_INT < 21) {
            i();
            return false;
        } else if (this.o) {
            return true;
        } else {
            h();
            return false;
        }
    }
}
