package com.tencent.mapsdk.internal;

import android.location.Location;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c0.class */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public i0 f23645a;

    public c0(i0 i0Var) {
        this.f23645a = null;
        this.f23645a = i0Var;
    }

    public void a() {
        i0 i0Var = this.f23645a;
        if (i0Var != null) {
            i0Var.c();
        }
    }

    public final void a(LocationSource locationSource) {
        i0 i0Var = this.f23645a;
        if (i0Var != null) {
            i0Var.setLocationSource(locationSource);
        }
    }

    public void a(MyLocationStyle myLocationStyle) {
        i0 i0Var = this.f23645a;
        if (i0Var != null) {
            i0Var.setMyLocationStyle(myLocationStyle);
        }
    }

    public void b() {
        i0 i0Var = this.f23645a;
        if (i0Var != null) {
            i0Var.b();
        }
    }

    public void c() {
        if (this.f23645a != null) {
            this.f23645a = null;
        }
    }

    public final Location d() {
        i0 i0Var = this.f23645a;
        if (i0Var != null) {
            return i0Var.getMyLocation();
        }
        return null;
    }

    public boolean e() {
        i0 i0Var = this.f23645a;
        if (i0Var != null) {
            return i0Var.d();
        }
        return false;
    }

    public void f() {
        i0 i0Var = this.f23645a;
        if (i0Var != null) {
            i0Var.a();
        }
    }
}
