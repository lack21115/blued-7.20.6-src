package a.a.a.a.a.k.d;

import android.view.Choreographer;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/a.class */
public final class a implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final a f1355a = new a();
    public static final long b = TimeUnit.NANOSECONDS.convert(1, TimeUnit.SECONDS);

    /* renamed from: c  reason: collision with root package name */
    public static final long f1356c = TimeUnit.NANOSECONDS.convert(10, TimeUnit.SECONDS);
    public static long d = 0;
    public static long e = 0;
    public static int f = 0;
    public static int g = 0;
    public static boolean h = false;

    public void a() {
        if (h) {
            h = false;
            g = 0;
            f = 0;
            e = 0L;
            d = 0L;
        }
    }

    public void b() {
        h = true;
    }

    public int c() {
        d();
        return g;
    }

    public final void d() {
        if (g == 0 || e - d >= f1356c) {
            g = Math.round(((float) (f * b)) / ((float) (e - d)));
            d = e;
            f = 0;
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        f++;
        if (d == 0) {
            d = j;
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        e = j;
        if (h) {
            Choreographer.getInstance().removeFrameCallback(this);
        } else {
            Choreographer.getInstance().postFrameCallback(this);
        }
    }
}
