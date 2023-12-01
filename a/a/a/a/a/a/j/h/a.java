package a.a.a.a.a.a.j.h;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.f;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/h/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public Handler f1227a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public int f1228c;
    public volatile boolean d;
    public Context f;
    public a.a.a.a.a.b.c g;
    public a.a.a.a.a.a.b h;
    public volatile boolean e = true;
    public int i = 200;
    public boolean j = true;
    public final Object k = new Object();
    public Runnable l = new RunnableC0004a();
    public Runnable m = new b();
    public Runnable n = new c();

    /* renamed from: a.a.a.a.a.a.j.h.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/h/a$a.class */
    public class RunnableC0004a implements Runnable {
        public RunnableC0004a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.f1313c.c("PictureStreamingManager", "starting picture streaming +");
            if (a.this.g != null) {
                a.this.g.k();
            }
            a aVar = a.this;
            String str = aVar.b;
            a.this.a(str != null ? a.a(str, aVar.h.a()) : aVar.a(aVar.f1228c, aVar.h.a()));
            a.this.f1227a.post(a.this.n);
            synchronized (a.this.k) {
                a.this.d = true;
                a.this.k.notify();
            }
            e.f1313c.c("PictureStreamingManager", "starting picture streaming -");
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/h/a$b.class */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.f1313c.c("PictureStreamingManager", "stopping picture streaming +");
            a.this.f1227a.getLooper().quit();
            a.this.b();
            if (a.this.j && a.this.g != null) {
                a.this.g.a(a.this.h);
                a.this.g.a(true);
            }
            synchronized (a.this.k) {
                a.this.d = false;
                a.this.k.notify();
            }
            e.f1313c.c("PictureStreamingManager", "stopping picture streaming -");
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/h/a$c.class */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
            a.this.f1227a.postDelayed(this, a.this.i);
        }
    }

    public a(Context context, a.a.a.a.a.b.c cVar, a.a.a.a.a.a.b bVar) {
        this.f = context;
        this.g = cVar;
        this.h = bVar;
    }

    public static Bitmap a(String str, f fVar) {
        if (fVar == null || fVar.a() <= 0 || fVar.b() <= 0) {
            return BitmapFactory.decodeFile(str);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i = options.outWidth;
        int i2 = options.outHeight;
        e.f.c("PictureStreamingManager", "loadSuitableBitmap, bitmap size = " + i + "x" + i2);
        int a2 = i / fVar.a();
        int b2 = i2 / fVar.b();
        if (a2 >= b2) {
            a2 = b2;
        }
        if (a2 <= 0) {
            a2 = 1;
        }
        options.inSampleSize = a2;
        e.f.c("PictureStreamingManager", "loadSuitableBitmap, inSampleSize = " + a2);
        return BitmapFactory.decodeFile(str, options);
    }

    public final Bitmap a(int i, f fVar) {
        if (fVar == null || fVar.a() <= 0 || fVar.b() <= 0) {
            return BitmapFactory.decodeResource(this.f.getResources(), i);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(this.f.getResources(), i, options);
        options.inJustDecodeBounds = false;
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        e.f.c("PictureStreamingManager", "loadSuitableBitmap, bitmap size = " + i2 + "x" + i3);
        int a2 = i2 / fVar.a();
        int b2 = i3 / fVar.b();
        if (a2 >= b2) {
            a2 = b2;
        }
        if (a2 <= 0) {
            a2 = 1;
        }
        options.inSampleSize = a2;
        e.f.c("PictureStreamingManager", "loadSuitableBitmap, inSampleSize = " + a2);
        return BitmapFactory.decodeResource(this.f.getResources(), i, options);
    }

    public abstract void a();

    public void a(float f) {
        if (f <= 0.0f || f > 30.0f) {
            e.d.e("PictureStreamingManager", "Error: fps range: 0-30");
        }
        this.i = (int) (1000.0f / f);
    }

    public void a(int i) {
        if (i <= 0) {
            e.d.e("PictureStreamingManager", "Error: resourceId error!");
            return;
        }
        this.b = null;
        this.f1228c = i;
        if (c()) {
            b(a(i, this.h.a()));
        }
    }

    public abstract void a(Bitmap bitmap);

    public void a(String str) {
        if (str == null) {
            e.d.e("PictureStreamingManager", "Error: filePath cannot be empty!");
            return;
        }
        this.f1228c = -1;
        this.b = str;
        if (c()) {
            b(a(str, this.h.a()));
        }
    }

    public void a(boolean z) {
        this.e = z;
    }

    public abstract void b();

    public abstract void b(Bitmap bitmap);

    public void b(boolean z) {
        synchronized (this) {
            if (!this.d) {
                e.f1313c.d("PictureStreamingManager", "not working !!!");
                return;
            }
            this.j = z;
            this.f1227a.post(this.m);
            synchronized (this.k) {
                if (this.d) {
                    try {
                        this.k.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    public void e() {
        synchronized (this) {
            if (this.d) {
                e.f1313c.d("PictureStreamingManager", "already working !!!");
                return;
            }
            if (this.f != null && this.h != null) {
                HandlerThread handlerThread = new HandlerThread("PictureStreamingManager");
                handlerThread.start();
                Handler handler = new Handler(handlerThread.getLooper());
                this.f1227a = handler;
                handler.post(this.l);
                synchronized (this.k) {
                    if (!this.d) {
                        try {
                            this.k.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return;
            }
            e.f1313c.d("PictureStreamingManager", "something is null !!!");
        }
    }
}
