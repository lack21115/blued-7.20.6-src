package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/k8.class */
public abstract class k8 implements Cloneable {
    public ArrayList<a> b = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/k8$a.class */
    public interface a {
        void a(k8 k8Var);

        void b(k8 k8Var);

        void c(k8 k8Var);

        void d(k8 k8Var);
    }

    public abstract k8 a(long j);

    public void a() {
    }

    public abstract void a(Interpolator interpolator);

    public void a(a aVar) {
        if (this.b == null) {
            this.b = new ArrayList<>();
        }
        this.b.add(aVar);
    }

    @Override // 
    /* renamed from: b */
    public k8 clone() {
        try {
            k8 k8Var = (k8) super.clone();
            ArrayList<a> arrayList = this.b;
            if (arrayList != null) {
                k8Var.b = new ArrayList<>();
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    k8Var.b.add(arrayList.get(i2));
                    i = i2 + 1;
                }
            }
            return k8Var;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public abstract void b(long j);

    public void b(a aVar) {
        ArrayList<a> arrayList = this.b;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(aVar);
        if (this.b.size() == 0) {
            this.b = null;
        }
    }

    public void c() {
    }

    public abstract long d();

    public ArrayList<a> e() {
        return this.b;
    }

    public abstract long f();

    public abstract boolean g();

    public boolean h() {
        return g();
    }

    public void i() {
        ArrayList<a> arrayList = this.b;
        if (arrayList != null) {
            arrayList.clear();
            this.b = null;
        }
    }

    public void j() {
    }
}
