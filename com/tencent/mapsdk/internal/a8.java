package com.tencent.mapsdk.internal;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.models.GeoPoint;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/a8.class */
public abstract class a8 {

    /* renamed from: a  reason: collision with root package name */
    public long f37289a = com.igexin.push.config.c.j;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public long f37290c = 0;
    private boolean d = false;
    private boolean e = false;
    private Interpolator f = new LinearInterpolator();
    public a g = null;
    public b h = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/a8$a.class */
    public interface a {
        void a();

        void onAnimationStart();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/a8$b.class */
    public interface b {
        void a(float f);

        void a(float f, float f2, float f3, float f4);

        void a(int i, int i2);

        void setAlpha(float f);

        void setScale(float f, float f2);
    }

    private long b() {
        return SystemClock.uptimeMillis();
    }

    public void a() {
        a aVar;
        if (!this.b) {
            if (!this.d || this.e || (aVar = this.g) == null) {
                return;
            }
            aVar.a();
            return;
        }
        float b2 = ((float) (b() - this.f37290c)) / ((float) this.f37289a);
        if (b2 <= 1.0f) {
            a(b2, this.f);
            return;
        }
        this.b = false;
        a(1.0f, this.f);
        a aVar2 = this.g;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.e = true;
    }

    public abstract void a(float f, Interpolator interpolator);

    public void a(long j) {
        this.f37289a = j;
    }

    public void a(Interpolator interpolator) {
        this.f = interpolator;
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public void a(b bVar) {
        this.h = bVar;
    }

    public boolean a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (this.f37289a <= 0) {
            return false;
        }
        this.d = true;
        this.f37290c = b();
        this.b = true;
        a aVar = this.g;
        if (aVar != null) {
            aVar.onAnimationStart();
            return true;
        }
        return true;
    }

    public long c() {
        return this.f37289a;
    }

    public Interpolator d() {
        return this.f;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.b;
    }

    public boolean g() {
        return this.d;
    }

    public void h() {
        this.b = false;
    }
}
