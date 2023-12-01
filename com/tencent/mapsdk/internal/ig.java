package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ig.class */
public class ig extends ze {
    private qc B;
    private e1 C;
    public jg D;
    public ue E;
    public Selectable.OnSelectedListener F;
    public p5 G;
    private p7 H;
    private p7 I;
    private final p0 J;

    public ig(p0 p0Var, a1 a1Var, jg jgVar) {
        super(a1Var);
        this.G = new p5();
        this.H = null;
        this.J = p0Var;
        this.B = a1Var.w();
        this.C = a1Var.getMapContext();
        this.D = jgVar;
        this.E = new ue(jgVar);
        this.n = true;
        a(jgVar);
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void E() {
        if (this.B == null) {
            return;
        }
        if (!isVisible()) {
            ue ueVar = this.E;
            if (ueVar != null) {
                ueVar.w = -1;
                return;
            }
            return;
        }
        p7 p7Var = this.H;
        if (p7Var != null) {
            if (p7Var.d()) {
                this.H = null;
            } else {
                this.H.a();
            }
        }
        p7 p7Var2 = this.I;
        if (p7Var2 != null && !p7Var2.d()) {
            this.I.a();
        }
        ue ueVar2 = this.E;
        if (ueVar2 != null) {
            this.B.a(ueVar2);
            int i = this.E.w;
            if (i != 0) {
                a(i);
            }
        }
    }

    public void J() {
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.d(true);
        }
    }

    public float K() {
        return this.D.c();
    }

    public float L() {
        return this.D.d();
    }

    public float M() {
        ue ueVar = this.E;
        if (ueVar != null) {
            return ueVar.g();
        }
        return 0.0f;
    }

    public int N() {
        ue ueVar = this.E;
        if (ueVar != null) {
            return ueVar.w;
        }
        return -1;
    }

    public ue O() {
        return this.E;
    }

    public jg P() {
        return this.D;
    }

    public float Q() {
        ue ueVar = this.E;
        if (ueVar != null) {
            return ueVar.l();
        }
        return 0.0f;
    }

    public GeoPoint R() {
        return this.D.k();
    }

    public float S() {
        ue ueVar = this.E;
        if (ueVar != null) {
            return ueVar.p();
        }
        return 0.0f;
    }

    public int T() {
        return this.D.l();
    }

    public float U() {
        ue ueVar = this.E;
        if (ueVar != null) {
            return ueVar.r();
        }
        return 1.0f;
    }

    public float V() {
        ue ueVar = this.E;
        if (ueVar != null) {
            return ueVar.s();
        }
        return 1.0f;
    }

    public float W() {
        ue ueVar = this.E;
        if (ueVar != null) {
            return ueVar.t();
        }
        return 0.0f;
    }

    public boolean X() {
        jg jgVar = this.D;
        if (jgVar != null) {
            return jgVar.p();
        }
        return true;
    }

    public boolean Y() {
        ue ueVar = this.E;
        if (ueVar != null) {
            return ueVar.A();
        }
        return false;
    }

    public boolean Z() {
        jg jgVar = this.D;
        if (jgVar != null) {
            return jgVar.s();
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0
    public Rect a(t4 t4Var) {
        Rect rect = null;
        if (this.E != null) {
            jg jgVar = this.D;
            rect = null;
            if (jgVar != null) {
                if (jgVar.k() == null) {
                    return null;
                }
                if (Y()) {
                    GeoPoint R = R();
                    p5 p5Var = new p5(0.0d, 0.0d);
                    if (R != null) {
                        p5Var.b = R.getLongitudeE6();
                        p5Var.f23992c = R.getLatitudeE6();
                    }
                    this.G = p5Var;
                } else {
                    this.G = t4Var.a(R());
                }
                p5 p5Var2 = new p5();
                p5 p5Var3 = new p5();
                ue ueVar = this.E;
                Bitmap a2 = ueVar.a(ueVar.c());
                if (a2 == null) {
                    return null;
                }
                int width = a2.getWidth();
                int height = a2.getHeight();
                p5 p5Var4 = this.G;
                p5Var2.b = p5Var4.b;
                p5Var3.b = p5Var4.b + width;
                p5Var2.f23992c = p5Var4.f23992c;
                p5Var3.f23992c = p5Var4.f23992c + height;
                int c2 = (int) (this.D.c() * width);
                int d = (int) (this.D.d() * height);
                double d2 = p5Var2.b;
                double d3 = c2;
                p5Var2.b = d2 - d3;
                p5Var3.b -= d3;
                double d4 = p5Var2.f23992c;
                double d5 = d;
                p5Var2.f23992c = d4 - d5;
                p5Var3.f23992c -= d5;
                int i = this.D.i();
                int j = this.D.j();
                double d6 = p5Var2.b;
                double d7 = i;
                p5Var2.b = d6 + d7;
                p5Var3.b += d7;
                double d8 = p5Var2.f23992c;
                double d9 = j;
                p5Var2.f23992c = d8 + d9;
                p5Var3.f23992c += d9;
                GeoPoint a3 = t4Var.a(p5Var2);
                GeoPoint a4 = t4Var.a(p5Var3);
                rect = new Rect(a3.getLongitudeE6(), a3.getLatitudeE6(), a4.getLongitudeE6(), a4.getLatitudeE6());
            }
        }
        return rect;
    }

    public void a(GeoPoint geoPoint) {
        this.D = this.D.a(geoPoint);
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.a(geoPoint);
            this.E.d(true);
        }
    }

    public void a(jg jgVar) {
        if (jgVar == null) {
            return;
        }
        this.D = jgVar;
        ue ueVar = this.E;
        if (ueVar == null) {
            this.E = new ue(jgVar);
        } else {
            ueVar.a(jgVar);
        }
    }

    public void a(p7 p7Var) {
        this.I = p7Var;
    }

    public void a(String str, Bitmap... bitmapArr) {
        b(str, bitmapArr);
    }

    public void a0() {
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.w = 0;
        }
        p7 p7Var = this.I;
        if (p7Var != null) {
            p7Var.i();
        }
    }

    @Override // com.tencent.mapsdk.internal.v0
    public Rect b(t4 t4Var) {
        jg jgVar;
        int i;
        if (this.E == null || (jgVar = this.D) == null || jgVar.k() == null) {
            return null;
        }
        if (Y()) {
            GeoPoint R = R();
            p5 p5Var = new p5(0.0d, 0.0d);
            if (R != null) {
                p5Var.b = R.getLongitudeE6();
                p5Var.f23992c = R.getLatitudeE6();
            }
            this.G = p5Var;
        } else {
            this.G = t4Var.a(R());
        }
        p5 p5Var2 = new p5();
        p5 p5Var3 = new p5();
        ue ueVar = this.E;
        Bitmap a2 = ueVar.a(ueVar.c());
        int i2 = 0;
        if (a2 != null) {
            i2 = a2.getWidth();
            i = a2.getHeight();
        } else {
            i = 0;
        }
        p5 p5Var4 = this.G;
        p5Var2.b = p5Var4.b;
        p5Var3.b = p5Var4.b + i2;
        p5Var2.f23992c = p5Var4.f23992c;
        p5Var3.f23992c = p5Var4.f23992c + i;
        int c2 = (int) (this.D.c() * i2);
        int d = (int) (this.D.d() * i);
        double d2 = p5Var2.b;
        double d3 = c2;
        p5Var2.b = d2 - d3;
        p5Var3.b -= d3;
        double d4 = p5Var2.f23992c;
        double d5 = d;
        p5Var2.f23992c = d4 - d5;
        p5Var3.f23992c -= d5;
        int i3 = this.D.i();
        int j = this.D.j();
        double d6 = p5Var2.b;
        double d7 = i3;
        p5Var2.b = d6 + d7;
        p5Var3.b += d7;
        double d8 = p5Var2.f23992c;
        double d9 = j;
        p5Var2.f23992c = d8 + d9;
        p5Var3.f23992c += d9;
        return new Rect((int) p5Var2.b, (int) p5Var2.f23992c, (int) p5Var3.b, (int) p5Var3.f23992c);
    }

    public void b(int i) {
        this.D = this.D.c(i);
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.e(i);
            this.E.d(true);
        }
    }

    public void b(int i, int i2) {
        this.D.a(i, i2);
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.b(i, i2);
            this.E.d(true);
        }
    }

    public void b(p7 p7Var) {
        if (p7Var == null) {
            return;
        }
        this.H = p7Var;
        p7Var.h();
    }

    public void b(String str, Bitmap... bitmapArr) {
        this.D = this.D.a(str, bitmapArr);
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.a(str, bitmapArr);
            this.E.d(true);
        }
    }

    public boolean b0() {
        jg jgVar = this.D;
        if (jgVar != null) {
            jgVar.t();
            return false;
        }
        return false;
    }

    public void f(boolean z) {
        jg jgVar = this.D;
        if (jgVar != null) {
            jgVar.a(z);
        }
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.a(z);
            this.E.d(true);
        }
    }

    public void g(boolean z) {
        jg jgVar = this.D;
        if (jgVar != null) {
            jgVar.b(z);
        }
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.b(z);
            this.E.d(true);
        }
    }

    public float getAlpha() {
        return this.D.a();
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public int getZIndex() {
        return this.D.m();
    }

    public void h(boolean z) {
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.f(z);
            this.E.d(true);
        }
    }

    public void i(boolean z) {
        this.D.g(z);
    }

    public boolean isFastLoad() {
        ue ueVar = this.E;
        if (ueVar == null) {
            return false;
        }
        return ueVar.z();
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public boolean isSelected() {
        return this.E.c() == 1;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean onTap(float f, float f2) {
        e1 e1Var;
        Selectable.OnSelectedListener onSelectedListener;
        if (!isVisible() || this.D.k() == null || (e1Var = this.C) == null) {
            return false;
        }
        TappedElement a2 = e1Var.f().a(f, f2);
        boolean z = a2 != null && a2.itemId == ((long) N());
        if (z) {
            this.E.b(1);
        } else {
            this.E.b(0);
        }
        if (z && (onSelectedListener = this.F) != null) {
            onSelectedListener.onSelected(this);
        }
        return z;
    }

    public void setAlpha(float f) {
        this.D = this.D.a(f);
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.a(f);
            this.E.d(true);
        }
    }

    public void setAnchor(float f, float f2) {
        this.D = this.D.a(f, f2);
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.a(f, f2);
            this.E.d(true);
        }
    }

    public void setFastLoad(boolean z) {
        ue ueVar = this.E;
        if (ueVar == null) {
            return;
        }
        ueVar.e(z);
        this.E.d(true);
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setLevel(int i) {
        this.D = this.D.b(i);
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.d(i);
            this.E.d(true);
        }
    }

    public void setScale(float f, float f2) {
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.b(f, f2);
            this.E.d(true);
        }
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public void setSelected(boolean z) {
        if (z) {
            this.E.b(1);
        } else {
            this.E.b(0);
        }
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public void setSelectedListener(Selectable.OnSelectedListener onSelectedListener) {
        this.F = onSelectedListener;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public void setZIndex(int i) {
        this.D = this.D.d(i);
        ue ueVar = this.E;
        if (ueVar != null) {
            ueVar.f(i);
            this.E.d(true);
        }
    }

    @Override // com.tencent.mapsdk.internal.v0
    public p0 x() {
        return this.J;
    }
}
