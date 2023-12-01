package a.a.a.a.a.a.j;

import a.a.a.a.a.a.h.h;
import a.a.a.a.a.a.j.f;
import a.a.a.a.a.b.i.j;
import a.a.a.a.a.b.i.o;
import a.a.a.a.a.b.i.p;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.qiniu.pili.droid.streaming.FrameCapturedCallback;
import com.qiniu.pili.droid.streaming.PreviewAppearance;
import com.qiniu.pili.droid.streaming.SurfaceTextureCallback2;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/d.class */
public class d extends a.a.a.a.a.a.j.f {

    /* renamed from: a  reason: collision with root package name */
    public h f1261a;
    public a.a.a.a.a.a.h.d b;

    /* renamed from: c  reason: collision with root package name */
    public a.a.a.a.a.a.j.e f1262c;
    public j d;
    public p e;
    public o f;
    public a.a.a.a.a.b.i.g g;
    public volatile boolean l;
    public volatile boolean n;
    public int o;
    public int p;
    public SurfaceTextureCallback2 q;
    public volatile e r;
    public WeakReference<GLSurfaceView> s;
    public List<WeakReference<View>> h = new LinkedList();
    public WeakHashMap<View, ViewGroup> i = new WeakHashMap<>();
    public WeakHashMap<View, a.a.a.a.a.b.i.d> j = new WeakHashMap<>();
    public WeakHashMap<View, Pair<Integer, Integer>> k = new WeakHashMap<>();
    public final Object m = new Object();

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/d$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WatermarkSetting f1263a;

        public a(WatermarkSetting watermarkSetting) {
            this.f1263a = watermarkSetting;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.e != null) {
                d.this.e.a();
                d.this.e = null;
            }
            if (this.f1263a != null) {
                a.a.a.a.a.e.f a2 = d.this.w.f1271a.d().a();
                d dVar = d.this;
                dVar.a(dVar.w.o, a2.a(), a2.b(), this.f1263a);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/d$b.class */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean[] f1264a;

        public b(d dVar, boolean[] zArr) {
            this.f1264a = zArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1264a[0] = true;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/d$c.class */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f1265a;

        /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/d$c$a.class */
        public class a implements ViewTreeObserver.OnGlobalLayoutListener {
            public a() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
                eVar.c("TextureMovieTransfer", "view size monitor got width: " + c.this.f1265a.getWidth() + " height: " + c.this.f1265a.getHeight());
                d.this.n = true;
            }
        }

        public c(View view) {
            this.f1265a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1265a.getWidth() == 0 || this.f1265a.getHeight() == 0) {
                this.f1265a.getViewTreeObserver().addOnGlobalLayoutListener(new a());
                return;
            }
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f;
            eVar.c("TextureMovieTransfer", "view size already got width: " + this.f1265a.getWidth() + " height: " + this.f1265a.getHeight());
            d.this.n = true;
        }
    }

    /* renamed from: a.a.a.a.a.a.j.d$d  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/d$d.class */
    public class C0003d {

        /* renamed from: a  reason: collision with root package name */
        public View f1267a;
        public ViewGroup b;

        public C0003d(d dVar, View view, ViewGroup viewGroup) {
            this.f1267a = view;
            this.b = viewGroup;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/d$e.class */
    public static class e extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<d> f1268a;

        public e(Looper looper, d dVar) {
            super(looper);
            this.f1268a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            d dVar = this.f1268a.get();
            a.a.a.a.a.e.e.f.b("TextureMovieTransfer", "EncoderHandler what:" + i + ",encoder=" + dVar);
            if (dVar == null) {
                a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "EncoderHandler.handleMessage: encoder is null");
                return;
            }
            switch (i) {
                case 0:
                    dVar.c();
                    return;
                case 1:
                    dVar.e(((Boolean) obj).booleanValue());
                    return;
                case 2:
                    int i2 = message.arg1;
                    long longValue = ((Long) obj).longValue();
                    boolean z = true;
                    if (message.arg2 != 1) {
                        z = false;
                    }
                    dVar.b(i2, longValue, z);
                    return;
                case 3:
                    dVar.a((FrameCapturedCallback) message.obj);
                    return;
                case 4:
                    dVar.a((C0003d) message.obj);
                    return;
                case 5:
                    dVar.f((View) message.obj);
                    return;
                case 6:
                    dVar.a((f) message.obj);
                    return;
                default:
                    throw new RuntimeException("Unhandled msg what=" + i);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/j/d$f.class */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        public View f1269a;
        public boolean b;

        public f(d dVar, View view, boolean z) {
            this.f1269a = view;
            this.b = z;
        }
    }

    public void a() {
        synchronized (this.m) {
            Iterator<WeakReference<View>> it = this.h.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                it.remove();
                if (this.r != null && view != null) {
                    this.r.sendMessage(this.r.obtainMessage(5, view));
                }
            }
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(int i) {
        synchronized (this) {
            a.a.a.a.a.a.j.e eVar = this.f1262c;
            if (eVar != null) {
                eVar.a(i);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // a.a.a.a.a.a.j.f
    public void a(int i, long j, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void a(C0003d c0003d) {
        this.i.put(c0003d.f1267a, c0003d.b);
        c(c0003d.f1267a);
    }

    public final void a(f fVar) {
        boolean z;
        View view = fVar.f1269a;
        synchronized (this.m) {
            Iterator<WeakReference<View>> it = this.h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().get() == view) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            if (!fVar.b) {
                d(view);
                return;
            }
            e(view);
            boolean[] zArr = new boolean[1];
            view.post(new b(this, zArr));
            do {
            } while (!zArr[0]);
            c(view);
        }
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(f.a aVar) {
        synchronized (this) {
            if (aVar == null) {
                a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "config is null when startEncoding");
            } else if (this.t == a.a.a.a.a.f.c.RUNNING) {
                a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "startEncoding failed as already being running");
            } else if (this.t == a.a.a.a.a.f.c.STOPPING) {
                a.a.a.a.a.e.e.f.c("TextureMovieTransfer", "set pending action as START");
                this.u = a.a.a.a.a.f.a.START;
                this.x = aVar;
            } else if (this.t == a.a.a.a.a.f.c.STARTING) {
                if (this.u == a.a.a.a.a.f.a.STOP) {
                    a.a.a.a.a.e.e.f.c("TextureMovieTransfer", "set pending action as RESTART");
                    this.u = a.a.a.a.a.f.a.RESTART;
                    this.x = aVar;
                }
            } else {
                a.a.a.a.a.e.e.f.c("TextureMovieTransfer", "startEncoding +");
                this.w = aVar;
                this.t = a.a.a.a.a.f.c.STARTING;
                HandlerThread handlerThread = new HandlerThread("TextureMovieTransfer");
                handlerThread.start();
                this.r = new e(handlerThread.getLooper(), this);
                this.r.sendEmptyMessage(0);
            }
        }
    }

    public void a(View view) {
        if (view == null) {
            a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "view is null, cannot remove");
            return;
        }
        synchronized (this.m) {
            Iterator<WeakReference<View>> it = this.h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<View> next = it.next();
                if (next.get() == view) {
                    this.h.remove(next);
                    if (this.r != null) {
                        this.r.sendMessage(this.r.obtainMessage(5, view));
                    }
                }
            }
        }
    }

    public final void a(View view, a.a.a.a.a.b.i.d dVar) {
        Pair<Integer, Integer> pair = this.k.get(view);
        WeakReference<GLSurfaceView> weakReference = this.s;
        GLSurfaceView gLSurfaceView = weakReference != null ? weakReference.get() : null;
        if (pair == null || gLSurfaceView == null) {
            return;
        }
        int width = gLSurfaceView.getWidth();
        int height = gLSurfaceView.getHeight();
        int intValue = pair.first.intValue();
        int intValue2 = pair.second.intValue();
        ViewGroup viewGroup = this.i.get(view);
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (ViewGroup viewGroup2 = (ViewGroup) view.getParent(); viewGroup != null && viewGroup2 != null && viewGroup2 != viewGroup; viewGroup2 = (ViewGroup) viewGroup2.getParent()) {
            f2 += viewGroup2.getX();
            f3 += viewGroup2.getY();
        }
        dVar.a(view.getAlpha());
        dVar.a((int) view.getRotation());
        float x = view.getX();
        float f4 = intValue;
        float scaleX = ((1.0f - view.getScaleX()) * f4) / 2.0f;
        float f5 = width;
        float f6 = ((x + f2) + scaleX) / f5;
        float y = view.getY();
        float f7 = intValue2;
        float scaleY = ((1.0f - view.getScaleY()) * f7) / 2.0f;
        float f8 = height;
        dVar.b(f6, ((y + f3) + scaleY) / f8);
        dVar.a((view.getScaleX() * f4) / f5, (view.getScaleY() * f7) / f8);
    }

    public void a(View view, ViewGroup viewGroup) {
        if (view == null) {
            a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "view is null, cannot add");
            return;
        }
        synchronized (this.m) {
            Iterator<WeakReference<View>> it = this.h.iterator();
            do {
                if (!it.hasNext()) {
                    this.h.add(new WeakReference<>(view));
                    if (this.r != null) {
                        this.r.sendMessage(this.r.obtainMessage(4, new C0003d(this, view, viewGroup)));
                        return;
                    }
                    return;
                }
            } while (it.next().get() != view);
            a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "view already existed in list!");
        }
    }

    public void a(View view, boolean z) {
        if (view == null) {
            a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "view is null, cannot refresh");
        } else if (this.r != null) {
            this.r.sendMessage(this.r.obtainMessage(6, new f(this, view, z)));
        }
    }

    public final void a(FrameCapturedCallback frameCapturedCallback) {
        h hVar = this.f1261a;
        if (hVar != null) {
            frameCapturedCallback.onFrameCaptured(hVar.f());
        }
    }

    public final void a(PreviewAppearance previewAppearance, int i, int i2, WatermarkSetting watermarkSetting) {
        p pVar = new p();
        this.e = pVar;
        if (previewAppearance != null) {
            pVar.a(i, i2, previewAppearance.x, previewAppearance.y, previewAppearance.w, previewAppearance.h, watermarkSetting);
        } else {
            pVar.a(i, i2, watermarkSetting);
        }
    }

    public void a(SurfaceTextureCallback2 surfaceTextureCallback2) {
        this.q = surfaceTextureCallback2;
    }

    @Override // a.a.a.a.a.a.j.f
    public void a(WatermarkSetting watermarkSetting) {
        f.a aVar = this.w;
        if (aVar == null) {
            return;
        }
        aVar.a(watermarkSetting);
        this.r.post(new a(watermarkSetting));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00eb A[Catch: Exception -> 0x01b4, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x01b4, blocks: (B:4:0x0017, B:5:0x001a, B:7:0x0067, B:9:0x0082, B:12:0x0096, B:16:0x00b0, B:18:0x00eb, B:21:0x0125, B:22:0x0138, B:35:0x017c, B:37:0x0182, B:38:0x0194, B:39:0x0197, B:19:0x0112, B:15:0x00a2, B:24:0x013a, B:26:0x0146, B:28:0x014e, B:30:0x0165, B:31:0x016f, B:33:0x017a), top: B:53:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0112 A[Catch: Exception -> 0x01b4, TRY_ENTER, TryCatch #1 {Exception -> 0x01b4, blocks: (B:4:0x0017, B:5:0x001a, B:7:0x0067, B:9:0x0082, B:12:0x0096, B:16:0x00b0, B:18:0x00eb, B:21:0x0125, B:22:0x0138, B:35:0x017c, B:37:0x0182, B:38:0x0194, B:39:0x0197, B:19:0x0112, B:15:0x00a2, B:24:0x013a, B:26:0x0146, B:28:0x014e, B:30:0x0165, B:31:0x016f, B:33:0x017a), top: B:53:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Object r10, a.a.a.a.a.a.i.c r11) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.a.j.d.a(java.lang.Object, a.a.a.a.a.a.i.c):void");
    }

    public void a(WeakReference<GLSurfaceView> weakReference) {
        this.s = weakReference;
    }

    @Override // a.a.a.a.a.a.j.f
    public boolean a(boolean z) {
        f.a aVar = this.w;
        if (aVar != null) {
            aVar.a(z);
            return true;
        }
        a.a.a.a.a.e.e.f.e("TextureMovieTransfer", "setEncodingMirror failed.");
        return false;
    }

    public e b() {
        return this.r;
    }

    public Bitmap b(View view) {
        view.post(new c(view));
        do {
        } while (!this.n);
        this.n = false;
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        view.draw(canvas);
        return createBitmap;
    }

    public final void b(int i, long j, boolean z) {
        int d;
        a.a.a.a.a.b.i.d dVar;
        a.a.a.a.a.a.j.e eVar = this.f1262c;
        if (eVar == null) {
            a.a.a.a.a.e.e eVar2 = a.a.a.a.a.e.e.f;
            eVar2.c("TextureMovieTransfer", "ERROR. handleFrameAvailable mVideoEncoder:" + this.f1262c);
            return;
        }
        eVar.a(false);
        if (this.g == null || this.f1261a == null) {
            a.a.a.a.a.e.e eVar3 = a.a.a.a.a.e.e.f;
            eVar3.c("TextureMovieTransfer", "ERROR. handleFrameAvailable mTextureDrawer:" + this.g + ",mInputWindowSurface:" + this.f1261a);
            return;
        }
        boolean z2 = this.w.m;
        synchronized (a.a.a.a.a.a.h.f.d) {
            d = z2 ? this.d.d(i) : this.f.a(0, i);
        }
        synchronized (this.m) {
            Iterator<WeakReference<View>> it = this.h.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    a.a.a.a.a.b.i.d dVar2 = this.j.get(view);
                    if (dVar2 == null) {
                        dVar = c(view);
                    } else {
                        dVar = dVar2;
                        if (this.l) {
                            d(view);
                            dVar = dVar2;
                        }
                    }
                    d = dVar.b(d);
                } else {
                    it.remove();
                }
            }
        }
        int i2 = d;
        if (z2) {
            i2 = this.f.a(0, d);
        }
        p pVar = this.e;
        if (pVar != null) {
            pVar.a(i2);
        }
        SurfaceTextureCallback2 surfaceTextureCallback2 = this.q;
        int i3 = i2;
        if (surfaceTextureCallback2 != null) {
            int onDrawFrame = surfaceTextureCallback2.onDrawFrame(i2, this.o, this.p, a.a.a.a.a.a.h.f.f1239c);
            i3 = i2;
            if (onDrawFrame > 0) {
                i3 = onDrawFrame;
            }
        }
        this.g.b(i3);
        this.f1261a.a(j);
        this.f1261a.e();
    }

    @Override // a.a.a.a.a.a.j.f
    public void b(boolean z) {
        synchronized (this) {
            if (this.t == a.a.a.a.a.f.c.IDLE) {
                a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "stopEncoding failed as not being running");
            } else if (this.t == a.a.a.a.a.f.c.STARTING) {
                a.a.a.a.a.e.e.f.c("TextureMovieTransfer", "set pending action as STOP");
                this.u = a.a.a.a.a.f.a.STOP;
            } else if (this.t == a.a.a.a.a.f.c.STOPPING) {
                if (this.u == a.a.a.a.a.f.a.START) {
                    a.a.a.a.a.e.e.f.d("TextureMovieTransfer", "clear pending start action");
                    this.u = a.a.a.a.a.f.a.NONE;
                }
            } else {
                a.a.a.a.a.e.e.f.c("TextureMovieTransfer", "stopEncoding +");
                this.t = a.a.a.a.a.f.c.STOPPING;
                this.r.sendMessage(this.r.obtainMessage(1, Boolean.valueOf(z)));
            }
        }
    }

    public final a.a.a.a.a.b.i.d c(View view) {
        Bitmap b2 = b(view);
        this.k.put(view, new Pair<>(Integer.valueOf(view.getWidth()), Integer.valueOf(view.getHeight())));
        a.a.a.a.a.b.i.d dVar = new a.a.a.a.a.b.i.d(b2);
        dVar.a(this.o, this.p);
        a(view, dVar);
        dVar.a();
        this.j.put(view, dVar);
        return dVar;
    }

    public final void c() {
        f.a aVar = this.w;
        a(aVar.i, aVar.f1271a);
        a.a.a.a.a.a.c cVar = this.v;
        if (cVar != null) {
            cVar.d();
        }
        this.y = 0L;
        a.a.a.a.a.e.e.f.c("TextureMovieTransfer", "startEncoding -");
        synchronized (this) {
            this.t = a.a.a.a.a.f.c.RUNNING;
            e();
        }
    }

    public final void d() {
        a.a.a.a.a.e.e.f.c("TextureMovieTransfer", "releaseEncoder");
        a.a.a.a.a.a.j.e eVar = this.f1262c;
        if (eVar != null) {
            eVar.b();
            this.f1262c = null;
        }
        SurfaceTextureCallback2 surfaceTextureCallback2 = this.q;
        if (surfaceTextureCallback2 != null) {
            surfaceTextureCallback2.onSurfaceDestroyed();
        }
        h hVar = this.f1261a;
        if (hVar != null) {
            hVar.g();
            this.f1261a = null;
        }
        a.a.a.a.a.a.h.d dVar = this.b;
        if (dVar != null) {
            dVar.b();
            this.b = null;
        }
    }

    public final void d(View view) {
        a.a.a.a.a.b.i.d dVar = this.j.get(view);
        if (dVar != null) {
            a(view, dVar);
            dVar.b();
        }
    }

    public void d(boolean z) {
        this.l = z;
    }

    public final void e(View view) {
        this.i.remove(view);
        a.a.a.a.a.b.i.d remove = this.j.remove(view);
        if (remove != null) {
            remove.h();
        }
        this.k.remove(view);
    }

    public final void e(boolean z) {
        Looper.myLooper().quit();
        a.a.a.a.a.a.j.e eVar = this.f1262c;
        if (eVar != null && z) {
            eVar.a();
            this.f1262c.a(true);
        }
        d();
        a.a.a.a.a.a.c cVar = this.v;
        if (cVar != null) {
            cVar.a();
        }
        a.a.a.a.a.e.e.f.c("TextureMovieTransfer", "stopEncoding -");
        synchronized (this) {
            this.t = a.a.a.a.a.f.c.IDLE;
            e();
        }
    }

    public final void f(View view) {
        e(view);
    }
}
