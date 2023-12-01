package com.tencent.mapsdk.internal;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.models.GeoPoint;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/p7.class */
public class p7 {
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23994c;
    private boolean e;
    private boolean f;

    /* renamed from: a  reason: collision with root package name */
    public long f23993a = com.igexin.push.config.c.j;
    public long d = 0;
    private Interpolator g = new LinearInterpolator();
    public a h = null;
    public b i = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/p7$a.class */
    public static abstract class a {
        public void a() {
        }

        public void a(float f) {
        }

        public void b() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/p7$b.class */
    public interface b {
        void a(float f);

        void a(float f, float f2, float f3, float f4);

        void a(GeoPoint geoPoint);

        void setAlpha(float f);

        void setScale(float f, float f2);
    }

    private float a(float f) {
        Interpolator interpolator = this.g;
        float f2 = f;
        if (interpolator != null) {
            f2 = interpolator.getInterpolation(f);
        }
        return f2;
    }

    private long b() {
        return SystemClock.uptimeMillis();
    }

    public void a() {
        if (!this.b && this.e && this.d == 0) {
            this.d = b();
            a aVar = this.h;
            if (aVar != null) {
                aVar.b();
            }
            this.b = true;
        }
        long b2 = b();
        float f = ((float) (b2 - this.d)) / ((float) this.f23993a);
        float f2 = f;
        if (f > 1.0f) {
            if (this.f23994c) {
                this.d = b2;
            } else {
                this.b = false;
            }
            f2 = 1.0f;
        }
        b(a(f2));
        if (this.b) {
            return;
        }
        this.f = true;
        a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    public void a(long j) {
        this.f23993a = j;
    }

    public void a(Interpolator interpolator) {
        this.g = interpolator;
    }

    public void a(a aVar) {
        this.h = aVar;
    }

    public void a(b bVar) {
        this.i = bVar;
    }

    public boolean a(boolean z) {
        if (this.f23993a <= 0 || this.e) {
            return false;
        }
        this.e = true;
        this.f23994c = z;
        return true;
    }

    public void b(float f) {
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(f);
        }
    }

    public Interpolator c() {
        return this.g;
    }

    public boolean d() {
        return this.f;
    }

    public boolean e() {
        return this.f23994c;
    }

    public boolean f() {
        return this.b;
    }

    public boolean g() {
        return this.e;
    }

    public boolean h() {
        return a(false);
    }

    public void i() {
        this.b = false;
    }
}
