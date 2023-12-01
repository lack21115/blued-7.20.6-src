package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.a8;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b8.class */
public class b8 extends a8 {
    public boolean i;
    public List<a8> j;

    public b8(boolean z) {
        this.i = true;
        this.j = null;
        this.i = z;
        this.j = new ArrayList();
    }

    @Override // com.tencent.mapsdk.internal.a8
    public void a(float f, Interpolator interpolator) {
        int size;
        List<a8> list = this.j;
        if (list == null || (size = list.size()) == 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            a8 a8Var = this.j.get(i2);
            if (a8Var != null) {
                if (this.i) {
                    a8Var.a(f, interpolator);
                } else {
                    a8Var.a(f, a8Var.d());
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.a8
    public void a(long j) {
        int size;
        super.a(j);
        List<a8> list = this.j;
        if (list == null || (size = list.size()) == 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            a8 a8Var = this.j.get(i2);
            if (a8Var != null) {
                a8Var.a(j);
            }
            i = i2 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.a8
    public void a(a8.b bVar) {
        int size;
        super.a(bVar);
        List<a8> list = this.j;
        if (list == null || (size = list.size()) == 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            a8 a8Var = this.j.get(i2);
            if (a8Var != null) {
                a8Var.a(bVar);
            }
            i = i2 + 1;
        }
    }

    public void a(a8 a8Var) {
        if (a8Var == null) {
            return;
        }
        this.j.add(a8Var);
    }

    @Override // com.tencent.mapsdk.internal.a8
    public boolean a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        List<a8> list;
        int size;
        boolean a2 = super.a(geoPoint, geoPoint2);
        if (!a2 || (list = this.j) == null || (size = list.size()) == 0) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return a2;
            }
            a8 a8Var = this.j.get(i2);
            if (a8Var != null) {
                a2 = a2 && a8Var.a(geoPoint, geoPoint2);
            }
            i = i2 + 1;
        }
    }

    public void i() {
        List<a8> list = this.j;
        if (list == null) {
            return;
        }
        list.clear();
    }
}
