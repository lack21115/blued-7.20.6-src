package a.a.a.a.a.b;

import a.a.a.a.a.b.i.i;
import a.a.a.a.a.b.i.o;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qiniu.pili.droid.streaming.PreviewAppearance;
import com.qiniu.pili.droid.streaming.StreamingPreviewCallback;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/h.class */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public StreamingPreviewCallback f1312a;
    public a.a.a.a.a.a.h.g b;

    /* renamed from: c  reason: collision with root package name */
    public a.a.a.a.a.a.h.d f1313c;
    public o d;
    public i e;
    public byte[] f;
    public volatile b g;
    public volatile boolean h;
    public final Object i = new Object();
    public volatile boolean j;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/h$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f1314a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1315c;
        public final int d;
        public final int e;
        public final Object f;

        public a(int i, int i2, int i3, int i4, Object obj) {
            this.f1314a = i;
            this.b = i2;
            this.d = i3;
            this.e = i4;
            this.f1315c = ((i3 * i4) * 3) / 2;
            this.f = obj;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/h$b.class */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<h> f1316a;

        public b(h hVar) {
            this.f1316a = new WeakReference<>(hVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            h hVar = this.f1316a.get();
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
            eVar.c("SurfaceDataReader", "EncoderHandler what:" + i + ",reader=" + hVar);
            if (hVar == null) {
                a.a.a.a.a.e.e.g.d("SurfaceDataReader", "EncoderHandler.handleMessage: encoder is null");
            } else if (i == 0) {
                hVar.a((a) obj);
            } else if (i == 1) {
                hVar.b();
            } else if (i == 2) {
                hVar.b(message.arg1, (SurfaceTexture) obj);
            } else if (i == 5) {
                Looper.myLooper().quit();
            } else {
                throw new RuntimeException("Unhandled msg what=" + i);
            }
        }
    }

    public void a() {
        a.a.a.a.a.e.e.g.c("SurfaceDataReader", "stopReading +");
        synchronized (this.i) {
            if (!this.h) {
                a.a.a.a.a.e.e.g.c("SurfaceDataReader", "stopReading as not Running-");
                return;
            }
            if (this.g != null) {
                this.g.removeCallbacksAndMessages(null);
                this.g.sendMessage(this.g.obtainMessage(1));
                this.g.sendMessage(this.g.obtainMessage(5));
            }
            synchronized (this.i) {
                while (this.h) {
                    try {
                        this.i.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            a.a.a.a.a.e.e.g.c("SurfaceDataReader", "stopReading -");
        }
    }

    public void a(int i, SurfaceTexture surfaceTexture) {
        synchronized (this.i) {
            if (this.j) {
                if (surfaceTexture.getTimestamp() == 0) {
                    a.a.a.a.a.e.e.g.d("SurfaceDataReader", "HEY: got SurfaceTexture with timestamp of zero");
                    return;
                }
                this.g.sendMessage(this.g.obtainMessage(2, i, 0, surfaceTexture));
            }
        }
    }

    public final void a(a aVar) {
        this.f = new byte[aVar.f1315c];
        b(aVar);
    }

    public void a(StreamingPreviewCallback streamingPreviewCallback) {
        this.f1312a = streamingPreviewCallback;
    }

    public void a(Object obj) {
        if (this.g != null) {
            this.g.removeCallbacksAndMessages(null);
        }
        a.a.a.a.a.e.e.g.c("SurfaceDataReader", "startReading()");
        a("SrcDataReader");
        if (this.g != null) {
            this.g.sendMessage(this.g.obtainMessage(0, obj));
        }
    }

    public final void a(String str) {
        synchronized (this.i) {
            if (this.h) {
                a.a.a.a.a.e.e.g.d("SurfaceDataReader", "Reading thread running when start requested");
                return;
            }
            this.h = true;
            Thread thread = new Thread(this, str);
            thread.setPriority(10);
            thread.start();
            while (!this.j) {
                try {
                    this.i.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public final void b() {
        a.a.a.a.a.e.e.g.c("SurfaceDataReader", "handleStopRecording");
        if (this.g != null) {
            this.g.removeMessages(2);
        }
        c();
    }

    public void b(int i, SurfaceTexture surfaceTexture) {
        int a2;
        if (this.e == null || this.b == null) {
            a.a.a.a.a.e.e.g.c("SurfaceDataReader", "ERROR. handleFrameAvailable mTextureI420Reader:" + this.e + ",mInputWindowSurface:" + this.b);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (a.a.a.a.a.a.h.f.d) {
            a2 = this.d.a(0, i);
        }
        ByteBuffer[] a3 = this.e.a(a2);
        a.a.a.a.a.e.e.g.a("SurfaceDataReader", "process cost:" + (System.currentTimeMillis() - currentTimeMillis));
        if (a3 != null) {
            int i2 = 0;
            for (ByteBuffer byteBuffer : a3) {
                byteBuffer.rewind();
                byteBuffer.get(this.f, i2, byteBuffer.capacity());
                i2 += byteBuffer.capacity();
            }
        }
        this.e.a();
        StreamingPreviewCallback streamingPreviewCallback = this.f1312a;
        if (streamingPreviewCallback != null) {
            streamingPreviewCallback.onPreviewFrame(this.f, this.d.a(), this.d.b(), 0, PLFourCC.FOURCC_I420, surfaceTexture.getTimestamp());
        }
    }

    public final void b(a aVar) {
        try {
            a.a.a.a.a.a.h.d dVar = new a.a.a.a.a.a.h.d(aVar.f, 0);
            this.f1313c = dVar;
            a.a.a.a.a.a.h.g gVar = new a.a.a.a.a.a.h.g(dVar, 2, 2);
            this.b = gVar;
            gVar.d();
            int i = aVar.d;
            int i2 = aVar.e;
            int i3 = aVar.f1314a;
            int i4 = aVar.b;
            o oVar = new o();
            this.d = oVar;
            oVar.a(i, i2, true);
            this.d.a(i3, i4, 0.0f, 0.0f, 1.0f, 1.0f, PreviewAppearance.ScaleType.FULL);
            i iVar = new i();
            this.e = iVar;
            iVar.a(i, i2);
        } catch (Exception e) {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
            eVar.d("SurfaceDataReader", "exception:" + e.getMessage());
        }
    }

    public final void c() {
        a.a.a.a.a.e.e.g.c("SurfaceDataReader", "release");
        this.f1312a = null;
        a.a.a.a.a.a.h.g gVar = this.b;
        if (gVar != null) {
            gVar.g();
            this.b = null;
        }
        o oVar = this.d;
        if (oVar != null) {
            oVar.e();
            this.d = null;
        }
        i iVar = this.e;
        if (iVar != null) {
            iVar.b();
            this.e = null;
        }
        a.a.a.a.a.a.h.d dVar = this.f1313c;
        if (dVar != null) {
            dVar.b();
            this.f1313c = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Looper.prepare();
        synchronized (this.i) {
            this.g = new b(this);
            this.j = true;
            this.i.notify();
        }
        Looper.loop();
        a.a.a.a.a.e.e.g.c("SurfaceDataReader", "Encoder thread exiting");
        synchronized (this.i) {
            this.h = false;
            this.j = false;
            this.g.removeCallbacksAndMessages(null);
            this.g = null;
            this.i.notify();
        }
    }
}
