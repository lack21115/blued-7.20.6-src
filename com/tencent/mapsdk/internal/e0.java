package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/e0.class */
public class e0 {

    /* renamed from: a  reason: collision with root package name */
    private l0 f23711a;

    public e0(l0 l0Var) {
        this.f23711a = null;
        this.f23711a = l0Var;
    }

    public float a(int i) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            return l0Var.c(i);
        }
        return 0.0f;
    }

    public void a() {
        if (this.f23711a != null) {
            this.f23711a = null;
        }
    }

    public void a(float f) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setLogoScale(f);
        }
    }

    public void a(int i, float f) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.a(i, f);
        }
    }

    public void a(int i, int i2) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setCompassExtraPadding(i, i2);
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.a(i, i2, i3, i4, i5);
        }
    }

    public void a(int i, int[] iArr) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.a(i, iArr);
        }
    }

    public void a(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setAllGesturesEnabled(z);
        }
    }

    @Deprecated
    public void b(int i) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setCompassExtraPadding(i);
        }
    }

    public void b(int i, int i2, int i3, int i4, int i5) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.b(i, i2, i3, i4, i5);
        }
    }

    public void b(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setCompassEnabled(z);
        }
    }

    public boolean b() {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            return l0Var.isCompassEnabled();
        }
        return false;
    }

    public void c(int i) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.f(i);
        }
    }

    public void c(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.b(z);
        }
    }

    public boolean c() {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            return l0Var.isIndoorLevelPickerEnabled();
        }
        return false;
    }

    public void d(int i) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.b(i);
        }
    }

    public void d(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setGestureRotateByMapCenter(z);
        }
    }

    public boolean d() {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            return l0Var.isMyLocationButtonEnabled();
        }
        return false;
    }

    public void e(int i) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.e(i);
        }
    }

    public void e(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setGestureScaleByMapCenter(z);
        }
    }

    public boolean e() {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            return l0Var.isRotateGesturesEnabled();
        }
        return false;
    }

    public void f(int i) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setLogoSize(i);
        }
    }

    public void f(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setIndoorLevelPickerEnabled(z);
        }
    }

    public boolean f() {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            return l0Var.b();
        }
        return false;
    }

    public void g(int i) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.d(i);
        }
    }

    public void g(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.a(z);
        }
    }

    public boolean g() {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            return l0Var.isScrollGesturesEnabled();
        }
        return false;
    }

    public void h(int i) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setZoomPosition(i);
        }
    }

    public void h(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setMyLocationButtonEnabled(z);
        }
    }

    public boolean h() {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            return l0Var.isTiltGesturesEnabled();
        }
        return false;
    }

    public void i(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setRotateGesturesEnabled(z);
        }
    }

    public boolean i() {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            return l0Var.isZoomControlsEnabled();
        }
        return false;
    }

    public void j(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setScaleViewEnabled(z);
        }
    }

    public boolean j() {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            return l0Var.isZoomGesturesEnabled();
        }
        return false;
    }

    public void k(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setScaleViewFadeEnable(z);
        }
    }

    public void l(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setScrollGesturesEnabled(z);
        }
    }

    public void m(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setTiltGesturesEnabled(z);
        }
    }

    public void n(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setZoomControlsEnabled(z);
        }
    }

    public void o(boolean z) {
        l0 l0Var = this.f23711a;
        if (l0Var != null) {
            l0Var.setZoomGesturesEnabled(z);
        }
    }
}
