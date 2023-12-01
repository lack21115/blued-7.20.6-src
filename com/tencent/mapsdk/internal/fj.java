package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.UiSettings;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/fj.class */
public class fj implements UiSettings {

    /* renamed from: a  reason: collision with root package name */
    private e0 f37450a;

    public fj(e0 e0Var) {
        this.f37450a = null;
        this.f37450a = e0Var;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public boolean isCompassEnabled() {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            return e0Var.b();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public boolean isIndoorLevelPickerEnabled() {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            return e0Var.c();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public boolean isMyLocationButtonEnabled() {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            return e0Var.d();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public boolean isRotateGesturesEnabled() {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            return e0Var.e();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public boolean isScaleViewEnabled() {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            return e0Var.f();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public boolean isScrollGesturesEnabled() {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            return e0Var.g();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public boolean isTiltGesturesEnabled() {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            return e0Var.h();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public boolean isZoomControlsEnabled() {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            return e0Var.i();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public boolean isZoomGesturesEnabled() {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            return e0Var.j();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setAllGesturesEnabled(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.a(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setCompassEnabled(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.b(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setCompassExtraPadding(int i) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.b(i);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setCompassExtraPadding(int i, int i2) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.a(i, i2);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setFlingGestureEnabled(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.c(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setGestureRotateByMapCenter(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.d(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setGestureScaleByMapCenter(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.e(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setIndoorLevelPickerEnabled(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.f(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setLogoPosition(int i) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.c(i);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setLogoPosition(int i, int[] iArr) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.a(i, iArr);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setLogoPositionWithMargin(int i, int i2, int i3, int i4, int i5) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.a(i, i2, i3, i4, i5);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setLogoScale(float f) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.a(f);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setLogoSize(int i) {
        e0 e0Var = this.f37450a;
        if (e0Var == null || e0Var == null) {
            return;
        }
        e0Var.f(i);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setMyLocationButtonEnabled(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.h(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setRotateGesturesEnabled(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.i(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setScaleViewEnabled(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.j(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setScaleViewFadeEnable(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.k(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setScaleViewPosition(int i) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.g(i);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setScaleViewPositionWithMargin(int i, int i2, int i3, int i4, int i5) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.b(i, i2, i3, i4, i5);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setScrollGesturesEnabled(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.l(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setTiltGesturesEnabled(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.m(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setZoomControlsEnabled(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.n(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public void setZoomGesturesEnabled(boolean z) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.o(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.UiSettings
    public final void setZoomPosition(int i) {
        e0 e0Var = this.f37450a;
        if (e0Var != null) {
            e0Var.h(i);
        }
    }
}
