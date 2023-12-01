package com.tencent.mapsdk.internal;

import android.graphics.Color;
import android.graphics.Rect;
import com.tencent.mapsdk.internal.p0;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ze.class */
public abstract class ze<D extends p0> extends v0<D> implements q4 {
    private static final AtomicInteger A = new AtomicInteger(1);
    public IndoorInfo i;
    private boolean r;
    private Object s;
    private boolean t;
    private Selectable.OnSelectedListener u;
    private float v;
    private boolean w;
    private boolean x;
    private final a1 y;
    private volatile boolean z;
    private final String g = String.valueOf(A.incrementAndGet());
    private boolean h = false;
    public float j = 1.0f;
    public int k = Color.argb(17, 0, 163, 255);
    public int l = Color.argb(255, 0, 163, 255);
    public float m = 0.0f;
    public boolean n = true;
    public boolean o = false;
    public int p = 2;
    private int q = -1;

    public ze(a1 a1Var) {
        this.y = a1Var;
    }

    public Selectable.OnSelectedListener A() {
        return this.u;
    }

    public void B() {
        if (this.z) {
            return;
        }
        this.o = true;
    }

    public boolean C() {
        return this.o;
    }

    public void D() {
        this.z = true;
    }

    public void E() {
    }

    public void F() {
    }

    public void G() {
    }

    public void H() {
    }

    public void I() {
        this.z = false;
        B();
    }

    public int a() {
        return this.q;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a */
    public Rect getBound(t4 t4Var) {
        return new Rect();
    }

    public void a(int i) {
        this.q = i;
    }

    @Override // com.tencent.mapsdk.internal.q4
    public void a(int i, int i2) {
    }

    public void a(IndoorBuilding indoorBuilding) {
        IndoorInfo indoorInfo = this.i;
        if (indoorInfo != null) {
            this.h = indoorInfo.toString().equals(indoorBuilding.toString());
            B();
        }
        n();
    }

    @Override // com.tencent.mapsdk.internal.s4
    public void a(IndoorInfo indoorInfo) {
        this.i = indoorInfo;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.mapsdk.internal.o4
    public final void a(GL10 gl10) {
        a1 a1Var;
        F();
        boolean C = C();
        E();
        if (C && (a1Var = this.y) != null) {
            a1Var.a();
        }
        this.o = false;
        G();
    }

    @Override // com.tencent.mapsdk.internal.s4
    public boolean d() {
        return this.h;
    }

    @Override // com.tencent.mapsdk.internal.s4
    public IndoorInfo f() {
        return this.i;
    }

    public int getFillColor() {
        return this.k;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    public List<Boundable<t4>> getGroupBounds() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this);
        return arrayList;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public String getId() {
        return y();
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public int getLevel() {
        return this.p;
    }

    public float getRotation() {
        return this.v;
    }

    public int getStrokeColor() {
        return this.l;
    }

    public float getStrokeWidth() {
        return this.j;
    }

    public Object getTag() {
        return this.s;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public int getZIndex() {
        return (int) this.m;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean handleOnTap() {
        return false;
    }

    public boolean isClickable() {
        return this.r;
    }

    public boolean isDraggable() {
        return this.w;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public boolean isRemoved() {
        return this.x;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public boolean isSelected() {
        return this.t;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public boolean isVisible() {
        return f() != null ? this.n && d() : this.n;
    }

    public void l() {
        if (this.i != null) {
            this.h = false;
            B();
        }
        n();
    }

    public void n() {
    }

    public boolean q() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public void releaseData() {
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public final void remove() {
        this.u = null;
        this.y.b(getId());
        H();
        this.x = true;
    }

    public void setClickable(boolean z) {
        this.r = z;
    }

    public void setDraggable(boolean z) {
        this.w = z;
    }

    public void setFillColor(int i) {
        this.k = i;
        B();
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setLevel(int i) {
        this.p = i;
        B();
    }

    public void setRotation(float f) {
        this.v = f;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public void setSelected(boolean z) {
        this.t = z;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public void setSelectedListener(Selectable.OnSelectedListener onSelectedListener) {
        this.u = onSelectedListener;
    }

    public void setStrokeColor(int i) {
        this.l = i;
        B();
    }

    public void setStrokeWidth(float f) {
        this.j = f;
        B();
    }

    public void setTag(Object obj) {
        this.s = obj;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public void setVisible(boolean z) {
        this.n = z;
        B();
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public void setZIndex(float f) {
        this.m = f;
        B();
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public void setZIndex(int i) {
        setZIndex(i);
    }

    public final String y() {
        return this.g;
    }

    public a1 z() {
        return this.y;
    }
}
