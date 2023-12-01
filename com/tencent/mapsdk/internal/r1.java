package com.tencent.mapsdk.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.mapsdk.internal.ca;
import com.tencent.mapsdk.internal.o1;
import com.tencent.mapsdk.internal.q1;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/r1.class */
public abstract class r1<C extends q1, M extends o1> implements MapDelegate<C, M, x1> {
    private C g;
    private M h;
    private x1 i;
    private ViewGroup j;
    public final Context k;
    public TencentMapOptions l;
    private ca.e m;

    public r1(Context context, TencentMapOptions tencentMapOptions, ViewGroup viewGroup) {
        this.k = context;
        this.j = viewGroup;
        this.l = tencentMapOptions;
        if (this.m == null) {
            this.m = ca.b();
        }
        ca.b(this.m);
        na.a(new pa(context, tencentMapOptions));
        ra.h(qa.W);
        ra.h(qa.y);
        if (tencentMapOptions != null) {
            ra.b(qa.W, "options", (Object) ra.a(context, tencentMapOptions.toString()));
        }
    }

    public ViewGroup F() {
        return this.j;
    }

    public void L() {
    }

    public void P() {
    }

    public void Q() {
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    /* renamed from: R */
    public M getMap() {
        return this.h;
    }

    @Override // com.tencent.mapsdk.core.MapDelegate
    /* renamed from: S */
    public C getMapContext() {
        return this.g;
    }

    public MapViewType T() {
        return this.g.t();
    }

    public final M a(C c2) {
        return b(c2);
    }

    @Override // com.tencent.mapsdk.core.MapDelegate
    /* renamed from: a */
    public final x1 createMapView(C c2, ViewGroup viewGroup) {
        return b((r1<C, M>) c2, viewGroup);
    }

    public void a(float f) {
        x1 x1Var = this.i;
        if (x1Var != null) {
            x1Var.a(f);
        }
    }

    public abstract M b(C c2);

    public abstract C b(Context context, TencentMapOptions tencentMapOptions);

    public abstract x1 b(C c2, ViewGroup viewGroup);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mapsdk.core.MapDelegate
    public /* synthetic */ TencentMap createMap(TencentMapContext tencentMapContext) {
        return a((r1<C, M>) ((q1) tencentMapContext));
    }

    @Override // com.tencent.mapsdk.core.MapDelegate
    public x1 getMapRenderView() {
        return this.i;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean isOpaque() {
        x1 x1Var = this.i;
        if (x1Var != null) {
            return x1Var.z();
        }
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean isTouchable() {
        M m = this.h;
        return m != null && m.g();
    }

    public void k(boolean z) {
        C c2 = this.g;
        if (c2 != null) {
            c2.b(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onCreated() {
        ra.h(qa.K);
        this.g = b(this.k, this.l);
        z();
        ra.i(qa.K);
        ra.h(qa.L);
        this.i = createMapView(this.g, this.j);
        Q();
        View view = this.i.getView();
        view.setEnabled(true);
        view.setClickable(true);
        ra.i(qa.L);
        ra.h(qa.J);
        this.h = a((r1<C, M>) this.g);
        P();
        this.h.a(this.g.a(this.k));
        L();
        ra.i(qa.J);
        ra.i(qa.y);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onDestroy() {
        ViewGroup viewGroup = this.j;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        M m = this.h;
        if (m != null) {
            m.b();
        }
        C c2 = this.g;
        if (c2 != null) {
            c2.E();
        }
        ca.a(this.m);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onPause() {
        M m = this.h;
        if (m != null) {
            m.c();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onRestart() {
        M m = this.h;
        if (m != null) {
            m.a();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onResume() {
        M m = this.h;
        if (m != null) {
            m.e();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        x1 x1Var = this.i;
        if (x1Var != null) {
            x1Var.onSizeChanged(i, i2, i3, i4);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onStart() {
        M m = this.h;
        if (m != null) {
            m.d();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onStop() {
        M m = this.h;
        if (m != null) {
            m.f();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onSurfaceChanged(Object obj, int i, int i2) {
        x1 x1Var = this.i;
        if (x1Var != null) {
            x1Var.onSurfaceChanged(obj, i, i2);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onUpdateOptions(TencentMapOptions tencentMapOptions) {
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void setOnTop(boolean z) {
        M m = this.h;
        if (m != null) {
            m.a(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void setOpaque(boolean z) {
        x1 x1Var = this.i;
        if (x1Var != null) {
            x1Var.setMapOpaque(z);
        }
    }

    public void z() {
        C c2 = this.g;
        if (c2 != null) {
            c2.D();
        }
    }
}
