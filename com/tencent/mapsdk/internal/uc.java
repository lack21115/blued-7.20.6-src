package com.tencent.mapsdk.internal;

import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mapsdk.internal.vc;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/uc.class */
public abstract class uc<T extends vc> {
    public ri b;

    /* renamed from: a  reason: collision with root package name */
    private int f24353a = 0;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<tc<T>> f24354c = new SparseArray<>();
    public SparseArray<tc<T>> d = new SparseArray<>();
    public SparseArray<tc<T>> e = new SparseArray<>();
    public SparseArray<tc<T>> f = new SparseArray<>();
    public SparseArray<tc<T>> g = new SparseArray<>();
    public SparseArray<tc<T>> h = new SparseArray<>();
    public SparseArray<tc<T>> i = new SparseArray<>();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/uc$a.class */
    public static class a implements TencentMap.IClickedObject {

        /* renamed from: a  reason: collision with root package name */
        public LatLng f24355a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f24356c;

        public a(LatLng latLng, String str, String str2) {
            this.f24355a = latLng;
            this.b = str;
            this.f24356c = str2;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.IClickedObject
        public String getIdentifier() {
            return this.b;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.IClickedObject
        public String getName() {
            return this.f24356c;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.IClickedObject
        public LatLng getPosition() {
            return this.f24355a;
        }
    }

    public uc(ri riVar) {
        this.b = riVar;
    }

    public Pair<VectorOverlay, TencentMap.IClickedObject> a(LatLng latLng, long j, String str, String str2) {
        return new Pair<>(null, null);
    }

    public tc<T> a(int i) {
        tc<T> tcVar;
        synchronized (this) {
            tcVar = this.f24354c.get(i);
        }
        return tcVar;
    }

    public tc<T> a(T t) {
        tc<T> b;
        synchronized (this) {
            b = b((uc<T>) t);
            while (true) {
                SparseArray<tc<T>> sparseArray = this.f24354c;
                int i = this.f24353a + 1;
                this.f24353a = i;
                if (sparseArray.get(i) == null) {
                    int i2 = this.f24353a;
                    b.g = i2;
                    this.f24354c.append(i2, b);
                    this.e.append(b.g, b);
                    this.b.m(true);
                }
            }
        }
        return b;
    }

    public void a() {
        synchronized (this) {
            this.i.clear();
            this.e.clear();
            this.g.clear();
            this.f24354c.clear();
        }
    }

    public abstract void a(tc tcVar);

    public abstract tc<T> b(T t);

    public void b(tc<T> tcVar) {
        synchronized (this) {
            a(tcVar);
            if (this.f24354c.get(tcVar.g) == null) {
                return;
            }
            if (this.e.get(tcVar.g) == null) {
                this.i.append(tcVar.g, tcVar);
            }
            this.f24354c.remove(tcVar.g);
            this.e.remove(tcVar.g);
            this.g.remove(tcVar.g);
            this.b.m(true);
        }
    }

    public boolean b() {
        return false;
    }

    public final void c() {
        synchronized (this) {
            g();
            SparseArray<tc<T>> sparseArray = this.h;
            this.h = this.i;
            this.i = sparseArray;
            SparseArray<tc<T>> sparseArray2 = this.f;
            this.f = this.g;
            this.g = sparseArray2;
            SparseArray<tc<T>> sparseArray3 = this.d;
            this.d = this.e;
            this.e = sparseArray3;
            sparseArray3.clear();
            this.g.clear();
            this.i.clear();
            h();
            j();
            i();
            this.h.clear();
            this.f.clear();
            this.d.clear();
            f();
        }
    }

    public void c(tc<T> tcVar) {
        synchronized (this) {
            if (this.f24354c.get(tcVar.g) == null) {
                return;
            }
            this.g.append(tcVar.g, tcVar);
            this.b.m(true);
        }
    }

    public void d() {
        synchronized (this) {
            a();
        }
    }

    public Context e() {
        ri riVar = this.b;
        if (riVar == null) {
            return null;
        }
        return riVar.o();
    }

    public void f() {
    }

    public void g() {
    }

    public abstract void h();

    public abstract void i();

    public abstract void j();
}
