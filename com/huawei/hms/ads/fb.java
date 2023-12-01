package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Gravity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fb.class */
public class fb extends Drawable implements Animatable, Drawable.Callback {
    private static final int B = 2;
    private static final int C = 119;
    private static final String Code = "GifDrawable";
    private static final int D = 2;
    private static final int F = 5;
    private static final int I = 640;
    private static final int L = 4;
    private static final String S = "render_frame";
    private static final int V = 0;
    private static final int Z = 960;
    private Paint f;
    private String i;
    private int l;
    private int m;
    private fa o;
    private Context p;
    private fc r;
    private boolean s;
    private com.huawei.openalliance.ad.utils.s t;
    private fd v;
    private a w;

    /* renamed from: a  reason: collision with root package name */
    private final String f22479a = S + hashCode();
    private Canvas b = new Canvas();

    /* renamed from: c  reason: collision with root package name */
    private Rect f22480c = new Rect();
    private Rect d = new Rect();
    private Rect e = new Rect();
    private boolean g = false;
    private int h = 0;
    private Queue<fc> j = new ConcurrentLinkedQueue();
    private Queue<Bitmap> k = new ConcurrentLinkedQueue();
    private boolean n = false;
    private long q = 0;
    private final WeakHashMap<Drawable.Callback, Void> u = new WeakHashMap<>();

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fb$a.class */
    public interface a {
        void Code(Bitmap bitmap);
    }

    public fb(Context context, String str) {
        this.p = context.getApplicationContext();
        this.i = str;
        com.huawei.openalliance.ad.utils.s sVar = new com.huawei.openalliance.ad.utils.s("gif-thread");
        this.t = sVar;
        sVar.Code();
        setCallback(this);
    }

    private InputStream B(String str) {
        String e;
        StringBuilder sb;
        try {
            return this.p.getResources().openRawResource(Integer.parseInt(str.substring(com.huawei.openalliance.ad.constant.bm.RES.toString().length())));
        } catch (Resources.NotFoundException e2) {
            e = e2;
            e = e();
            sb = new StringBuilder();
            sb.append("loadFile ");
            sb.append(e.getClass().getSimpleName());
            ge.I(e, sb.toString());
            return null;
        } catch (NumberFormatException e3) {
            e = e3;
            e = e();
            sb = new StringBuilder();
            sb.append("loadFile ");
            sb.append(e.getClass().getSimpleName());
            ge.I(e, sb.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        String e = e();
        ge.V(e, "replay " + com.huawei.openalliance.ad.utils.bc.Code(this.i));
        Code(this.i);
    }

    private InputStream C(String str) {
        try {
            return this.p.getAssets().open(str.substring(com.huawei.openalliance.ad.constant.bm.ASSET.toString().length()));
        } catch (IOException e) {
            String e2 = e();
            ge.I(e2, "loadFile " + e.getClass().getSimpleName());
            return null;
        }
    }

    private void C() {
        Code(false);
        this.l = 0;
        this.j.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap Code(Bitmap bitmap, boolean z) {
        int i;
        if (ge.Code()) {
            ge.Code(e(), "image pool size: %d", Integer.valueOf(this.k.size()));
        }
        Bitmap poll = this.k.poll();
        Bitmap bitmap2 = poll;
        if (poll == null) {
            ge.V(e(), "cache bitmap null");
            if (!z) {
                return bitmap.copy(bitmap.getConfig(), true);
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width < height) {
                if (width > 640) {
                    i = 640;
                    int i2 = (int) (((i * height) * 1.0f) / width);
                    ge.V(e(), "reduce image size to w: %d, h: %d src w: %d, h: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(width), Integer.valueOf(height));
                    bitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
                }
                i = width;
                int i22 = (int) (((i * height) * 1.0f) / width);
                ge.V(e(), "reduce image size to w: %d, h: %d src w: %d, h: %d", Integer.valueOf(i), Integer.valueOf(i22), Integer.valueOf(width), Integer.valueOf(height));
                bitmap2 = Bitmap.createBitmap(i, i22, Bitmap.Config.RGB_565);
            } else {
                if (width > Z) {
                    i = Z;
                    int i222 = (int) (((i * height) * 1.0f) / width);
                    ge.V(e(), "reduce image size to w: %d, h: %d src w: %d, h: %d", Integer.valueOf(i), Integer.valueOf(i222), Integer.valueOf(width), Integer.valueOf(height));
                    bitmap2 = Bitmap.createBitmap(i, i222, Bitmap.Config.RGB_565);
                }
                i = width;
                int i2222 = (int) (((i * height) * 1.0f) / width);
                ge.V(e(), "reduce image size to w: %d, h: %d src w: %d, h: %d", Integer.valueOf(i), Integer.valueOf(i2222), Integer.valueOf(width), Integer.valueOf(height));
                bitmap2 = Bitmap.createBitmap(i, i2222, Bitmap.Config.RGB_565);
            }
        }
        Code(bitmap, bitmap2);
        return bitmap2;
    }

    private void Code(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            this.b.setBitmap(bitmap2);
            this.b.drawColor(0, PorterDuff.Mode.CLEAR);
            this.d.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.e.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            this.b.drawBitmap(bitmap, this.d, this.e, (Paint) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(fc fcVar) {
        ge.V(e(), "onFrameDecoded index: %d isstop: %s", Integer.valueOf(fcVar.Code), Boolean.valueOf(F()));
        if (F()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.q;
        if (ge.Code()) {
            ge.Code(e(), "onFrameDecoded decodeInterval: %d currentFrameDuration: %d", Long.valueOf(currentTimeMillis), Integer.valueOf(this.m));
        }
        if (fcVar.Code == 1) {
            b();
        } else {
            int i = this.m;
            if (currentTimeMillis < i) {
                try {
                    Thread.sleep(i - currentTimeMillis);
                } catch (InterruptedException e) {
                    ge.Code(e(), "sleep InterruptedException");
                }
            }
        }
        V(fcVar);
    }

    private void Code(final String str) {
        this.t.Code(new Runnable() { // from class: com.huawei.hms.ads.fb.2
            @Override // java.lang.Runnable
            public void run() {
                fb.this.V(str);
            }
        });
    }

    private void Code(boolean z) {
        synchronized (this) {
            this.n = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(fc fcVar, long j) {
        int i;
        int i2 = fcVar.V.getConfig() == Bitmap.Config.RGB_565 ? 2 : 4;
        long width = fcVar.V.getWidth();
        long height = fcVar.V.getHeight();
        long j2 = i2;
        if (j > fcVar.I) {
            int ceil = (int) Math.ceil((j * 1.0d) / fcVar.I);
            i = ceil;
            if (ceil > 5) {
                i = 5;
            }
        } else {
            i = 1;
        }
        long max = width * height * j2 * Math.max(i, this.j.size());
        long V2 = com.huawei.openalliance.ad.utils.v.V();
        if (ge.Code()) {
            ge.Code(e(), "max frame mem: %d unused memory: %d", Long.valueOf(max), Long.valueOf(V2));
        }
        return max >= V2;
    }

    static /* synthetic */ int D(fb fbVar) {
        int i = fbVar.l;
        fbVar.l = i + 1;
        return i;
    }

    private void D() {
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.fb.3
            @Override // java.lang.Runnable
            public void run() {
                if (fb.this.v != null) {
                    fb.this.v.V();
                }
                fb.this.V();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F() {
        boolean z;
        synchronized (this) {
            z = this.n;
        }
        return z;
    }

    private InputStream I(String str) {
        try {
            return this.p.getContentResolver().openInputStream(Uri.parse(str));
        } catch (FileNotFoundException e) {
            String e2 = e();
            ge.I(e2, "oPIs " + e.getClass().getSimpleName());
            return null;
        }
    }

    private void I(fc fcVar) {
        if (fcVar == null || this.k.size() >= 2) {
            ge.V(e(), "drop frame");
        } else if (this.k.contains(fcVar.V) || this.k.offer(fcVar.V)) {
        } else {
            ge.I(e(), "fail to release frame to pool");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        final fa faVar;
        if (F() || (faVar = this.o) == null || faVar.I()) {
            return;
        }
        this.t.Code(new Runnable() { // from class: com.huawei.hms.ads.fb.4
            @Override // java.lang.Runnable
            public void run() {
                ge.V(fb.this.e(), "fetch next");
                long currentTimeMillis = System.currentTimeMillis();
                fc Code2 = faVar.Code();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                ge.Code(fb.this.e(), "frame fetch - decoding duration: %d gif: %s", Long.valueOf(currentTimeMillis2), Code2);
                fb fbVar = fb.this;
                if (Code2 == null) {
                    fc fcVar = (fc) fbVar.j.poll();
                    if (fcVar != null) {
                        fb.this.Code(fcVar);
                        return;
                    }
                    long currentTimeMillis3 = System.currentTimeMillis() - fb.this.q;
                    if (currentTimeMillis3 < fb.this.m) {
                        try {
                            Thread.sleep(fb.this.m - currentTimeMillis3);
                        } catch (InterruptedException e) {
                            ge.Code(fb.this.e(), "InterruptedException");
                        }
                    }
                    fb.this.a();
                    return;
                }
                boolean Code3 = fbVar.Code(Code2, currentTimeMillis2);
                ge.Code(fb.this.e(), "need reduce size: %s", Boolean.valueOf(Code3));
                fc Code4 = Code2.Code();
                Code4.V = fb.this.Code(Code2.V, Code3);
                if (!fb.this.j.offer(Code4)) {
                    ge.I(fb.this.e(), "fail to add frame to cache");
                }
                if (currentTimeMillis2 <= Code4.I) {
                    ge.V(fb.this.e(), "send to render directly");
                } else {
                    int i = (int) ((currentTimeMillis2 * 1.0d) / Code4.I);
                    int i2 = i;
                    if (i > 5) {
                        i2 = 5;
                    }
                    ge.Code(fb.this.e(), "preferred cached frame num: %d", Integer.valueOf(i2));
                    if (fb.this.j.size() < i2) {
                        fb.this.L();
                        return;
                    }
                }
                fb fbVar2 = fb.this;
                fbVar2.Code((fc) fbVar2.j.poll());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        fa faVar = this.o;
        if (faVar != null) {
            faVar.V();
            this.o = null;
        }
    }

    private void V(fc fcVar) {
        a aVar;
        I(this.r);
        this.r = fcVar;
        if (fcVar != null && (aVar = this.w) != null) {
            aVar.Code(fcVar.V);
        }
        this.m = fcVar.I;
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.fb.7
            @Override // java.lang.Runnable
            public void run() {
                if (fb.this.F()) {
                    fb.this.r = null;
                    return;
                }
                fb.this.invalidateSelf();
                fb.this.L();
            }
        }, this.f22479a, 0L);
        this.q = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str) {
        S();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InputStream C2 = str.startsWith(com.huawei.openalliance.ad.constant.bm.ASSET.toString()) ? C(str) : str.startsWith(com.huawei.openalliance.ad.constant.bm.RES.toString()) ? B(str) : str.startsWith(com.huawei.openalliance.ad.constant.bm.CONTENT.toString()) ? I(str) : Z(str);
        if (C2 != null) {
            try {
                this.o = new fa(C2, 100);
                L();
            } catch (Exception e) {
                ge.I(e(), "exception in creating gif decoder");
                D();
            }
        }
    }

    private Paint Z() {
        if (this.f == null) {
            this.f = new Paint(2);
        }
        return this.f;
    }

    private InputStream Z(String str) {
        try {
            return new FileInputStream(new File(str));
        } catch (FileNotFoundException e) {
            String e2 = e();
            ge.I(e2, "loadFile " + e.getClass().getSimpleName());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.fb.5
            @Override // java.lang.Runnable
            public void run() {
                fb.D(fb.this);
                if (fb.this.h == 0 || fb.this.l < fb.this.h) {
                    fb.this.B();
                    return;
                }
                fb.this.V();
                fb.this.d();
            }
        });
    }

    private void b() {
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.fb.6
            @Override // java.lang.Runnable
            public void run() {
                if (fb.this.v != null) {
                    fb.this.v.Code();
                }
            }
        });
    }

    private void c() {
        this.k.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ge.V(e(), "on play end");
        c();
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.fb.8
            @Override // java.lang.Runnable
            public void run() {
                if (fb.this.v != null) {
                    fb.this.v.I();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        return "GifDrawable_" + hashCode();
    }

    public void Code() {
        if (TextUtils.isEmpty(this.i)) {
            return;
        }
        String e = e();
        ge.V(e, "play " + com.huawei.openalliance.ad.utils.bc.Code(this.i));
        V();
        C();
        Code(this.i);
    }

    public void Code(int i) {
        this.h = i;
    }

    public void Code(Drawable.Callback callback) {
        this.u.put(callback, null);
        setCallback(this);
    }

    public void Code(a aVar) {
        this.w = aVar;
    }

    public void Code(fd fdVar) {
        this.v = fdVar;
    }

    public int I() {
        int size = (this.k.size() + this.j.size()) * getIntrinsicWidth() * getIntrinsicHeight() * 4;
        if (size > 0) {
            return size;
        }
        return 1;
    }

    public void V() {
        String e = e();
        ge.V(e, "stop play " + com.huawei.openalliance.ad.utils.bc.Code(this.i));
        com.huawei.openalliance.ad.utils.ba.Code(this.f22479a);
        Code(true);
        this.j.clear();
        this.t.Code(new Runnable() { // from class: com.huawei.hms.ads.fb.1
            @Override // java.lang.Runnable
            public void run() {
                fb.this.S();
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        fc fcVar = this.r;
        if (fcVar == null || fcVar.V == null) {
            return;
        }
        if (ge.Code() && this.r != null) {
            ge.Code(e(), "draw frame: %d", Integer.valueOf(this.r.Code));
        }
        if (this.s) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.f22480c);
            this.s = false;
        }
        canvas.drawBitmap(this.r.V, (Rect) null, this.f22480c, Z());
    }

    protected void finalize() {
        super.finalize();
        this.t.V();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        fc fcVar = this.r;
        return fcVar != null ? fcVar.V.getHeight() : super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        fc fcVar = this.r;
        return fcVar != null ? fcVar.V.getWidth() : super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        for (Drawable.Callback callback : this.u.keySet()) {
            if (callback != null) {
                callback.invalidateDrawable(drawable);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.s = true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        for (Drawable.Callback callback : this.u.keySet()) {
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Z().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Z().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        String e = e();
        ge.V(e, "setVisible " + z);
        if (!z) {
            stop();
        } else if (!this.g) {
            start();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        ge.V(e(), "start");
        this.g = true;
        Code();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        ge.V(e(), "stop");
        this.g = false;
        V();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        for (Drawable.Callback callback : this.u.keySet()) {
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }
}
