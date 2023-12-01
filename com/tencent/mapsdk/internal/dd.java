package com.tencent.mapsdk.internal;

import android.util.Pair;
import com.tencent.map.lib.models.CommonParamsModelClass;
import com.tencent.mapsdk.internal.uc;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/dd.class */
public class dd extends uc<ed> {
    public dd(ri riVar) {
        super(riVar);
    }

    @Override // com.tencent.mapsdk.internal.uc
    public Pair<VectorOverlay, TencentMap.IClickedObject> a(LatLng latLng, long j, String str, String str2) {
        Pair<VectorOverlay, TencentMap.IClickedObject> pair = new Pair<>(null, null);
        if (j > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f38045c.size()) {
                    break;
                }
                fd fdVar = (fd) this.f38045c.valueAt(i2);
                if (fdVar.x() == j) {
                    uc.a aVar = new uc.a(latLng, str, str2);
                    fdVar.a(aVar);
                    return new Pair<>(fdVar, aVar);
                }
                i = i2 + 1;
            }
        }
        return pair;
    }

    @Override // com.tencent.mapsdk.internal.uc
    public fd a(ed edVar) {
        fd fdVar;
        synchronized (this) {
            fdVar = (fd) super.a((dd) edVar);
        }
        return fdVar;
    }

    public List<CommonParamsModelClass.AnimationInfo> a(long j) {
        int a2 = this.b.a(j);
        if (a2 <= 0) {
            return null;
        }
        float[] b = this.b.b(j);
        String[] c2 = this.b.c(j);
        if (b == null || c2 == null || b.length != c2.length || b.length != a2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2) {
                return arrayList;
            }
            arrayList.add(new CommonParamsModelClass.AnimationInfo(i2, c2[i2], b[i2]));
            i = i2 + 1;
        }
    }

    public void a(long j, int i, float f, boolean z) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f38045c.size()) {
                return;
            }
            if (((fd) this.f38045c.valueAt(i3)).x() == j) {
                this.b.a(j, i, f, z);
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void a(tc tcVar) {
        ((fd) tcVar).y();
    }

    @Override // com.tencent.mapsdk.internal.uc
    public tc<ed> b(ed edVar) {
        return new fd(this, edVar);
    }

    public void b(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f38045c.size()) {
                return;
            }
            if (((fd) this.f38045c.valueAt(i2)).x() == j) {
                this.b.g(j);
            }
            i = i2 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.uc
    public boolean b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f38045c.size()) {
                return false;
            }
            if (((fd) this.f38045c.valueAt(i2)).isClickEnabled()) {
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void f() {
        if (this.b.m()) {
            this.b.T();
        }
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void g() {
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void h() {
        int size = this.d.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            fd fdVar = (fd) this.d.get(this.d.keyAt(i2));
            ArrayList arrayList = new ArrayList();
            if (fdVar.f().a().isBuildingHidden() && fdVar.f().a().getLatLngBounds() != null) {
                arrayList.add(fdVar.f().a().getLatLngBounds());
            }
            this.b.a(arrayList);
            fdVar.a(this.b.a(fdVar.f()));
            i = i2 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void i() {
        int size = this.h.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.b.f(((tc) this.h.get(this.h.keyAt(i2))).x());
            i = i2 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void j() {
        int size = this.f.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            fd fdVar = (fd) this.f.get(this.f.keyAt(i2));
            ArrayList arrayList = new ArrayList();
            if (fdVar.f().a().isBuildingHidden() && fdVar.f().a().getLatLngBounds() != null) {
                arrayList.add(fdVar.f().a().getLatLngBounds());
            }
            this.b.a(arrayList);
            this.b.a(fdVar.x(), fdVar.f());
            i = i2 + 1;
        }
    }

    public dd k() {
        return this;
    }
}
