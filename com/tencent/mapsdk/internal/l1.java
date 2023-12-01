package com.tencent.mapsdk.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mapsdk.internal.mf;
import com.tencent.mapsdk.internal.p4;
import com.tencent.mapsdk.internal.qh;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l1.class */
public class l1 implements c5, d1, i5, l0, m5 {
    public static final String q = "key_change_style";
    private ViewGroup d;
    private TencentMapOptions e;
    private yi f;
    private sh g;
    private qh h;
    private eg i;
    private lf j;
    private mf.a k;
    private int l;
    private Bundle m;
    private List<p4> n = new CopyOnWriteArrayList();
    private boolean o = false;
    public Handler p = new a(ca.a("gesture"));

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l1$a.class */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            if (message == null || (obj = message.obj) == null) {
                return;
            }
            v5 v5Var = (v5) obj;
            int i = v5Var.f24371a;
            if (i == 0) {
                if (l1.this.g != null) {
                    l1.this.g.a(v5Var.b, v5Var.f24372c);
                }
            } else if (i == 1) {
                if (l1.this.h != null) {
                    l1.this.h.a(v5Var.d, v5Var.e);
                }
            } else if (i != 3 || c7.D != 1) {
                if (i == 2 && l1.this.isCompassEnabled()) {
                    l1.this.f.getMap().c(l1.this.f.getMapContext().d(v5Var.g) ? zd.b : zd.f24470a);
                }
            } else if (TextUtils.equals(mi.f23959c, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE) || l1.this.d == null) {
            } else {
                if (l1.this.j == null) {
                    l1 l1Var = l1.this;
                    l1Var.j = new lf(l1Var.d.getContext().getApplicationContext(), l1.this.f.getMapContext());
                    l1.this.j.a(l1.this.k);
                }
                l1.this.j.a(l1.this.d, (Bundle) null);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l1$b.class */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l1 l1Var = l1.this;
            l1Var.a(l1Var.m);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l1$c.class */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23914a;

        static {
            p4.b.values();
            int[] iArr = new int[6];
            f23914a = iArr;
            try {
                p4.b bVar = p4.b.LEFT_TOP;
                iArr[3] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f23914a;
                p4.b bVar2 = p4.b.LEFT_BOTTOM;
                iArr2[0] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f23914a;
                p4.b bVar3 = p4.b.RIGHT_BOTTOM;
                iArr3[2] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = f23914a;
                p4.b bVar4 = p4.b.RIGHT_TOP;
                iArr4[5] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/l1$d.class */
    public interface d {
        void a();
    }

    public l1(e1 e1Var, ViewGroup viewGroup, x1 x1Var) {
        this.d = null;
        this.d = viewGroup;
        if (x1Var == null) {
            return;
        }
        yi yiVar = (yi) e1Var.j();
        this.f = yiVar;
        this.e = yiVar.l();
        this.f.getMap().a(this);
        if (x1Var instanceof View) {
            View view = (View) x1Var;
            if (this.d.indexOfChild(view) < 0) {
                this.d.addView(view, 0, new FrameLayout.LayoutParams(-1, -1));
                this.d.requestLayout();
            }
        }
        qh qhVar = new qh(this.d.getContext().getApplicationContext(), this.f, this.f.getMap().R());
        this.h = qhVar;
        this.f.a(qhVar);
        eg egVar = new eg(e1Var);
        this.i = egVar;
        this.h.a(egVar);
        this.f.a(this.i);
        this.g = new sh(this.d.getContext(), this.f);
        this.n.add(this.h);
        this.n.add(this.g);
        this.n.add(this.i);
        this.f.b((c5) this);
        this.f.a((d1) this);
        this.f.a((i5) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        for (p4 p4Var : this.n) {
            p4Var.a(this.d, bundle);
        }
    }

    @Override // com.tencent.mapsdk.internal.m5
    public void a(int i) {
        if (this.m == null) {
            this.m = new Bundle();
        }
        this.m.putInt(q, i);
        e();
        v5 v5Var = new v5();
        v5Var.f24371a = 2;
        v5Var.g = i;
        a(v5Var);
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void a(int i, float f) {
        qh qhVar = this.h;
        if (qhVar != null) {
            qhVar.a(p4.a.a(i), f);
            e();
        }
    }

    @Override // com.tencent.mapsdk.internal.i5
    public void a(int i, int i2) {
        this.l = i2;
        for (p4 p4Var : this.n) {
            p4Var.a(i, i2);
        }
        e();
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void a(int i, int i2, int i3, int i4, int i5) {
        qh qhVar = this.h;
        if (qhVar != null) {
            qhVar.a(p4.b.a(i));
            this.h.a(p4.a.TOP, i2);
            this.h.a(p4.a.BOTTOM, i3);
            this.h.a(p4.a.LEFT, i4);
            this.h.a(p4.a.RIGHT, i5);
            this.h.q();
            e();
        }
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void a(int i, int[] iArr) {
        if (this.h != null) {
            p4.b a2 = p4.b.a(i);
            this.h.a(a2);
            int ordinal = a2.ordinal();
            if (ordinal == 0) {
                this.h.a(p4.a.BOTTOM, iArr[0]);
                this.h.a(p4.a.LEFT, iArr[1]);
            } else if (ordinal == 5) {
                this.h.a(p4.a.TOP, iArr[0]);
                this.h.a(p4.a.RIGHT, iArr[1]);
            } else if (ordinal == 2) {
                this.h.a(p4.a.BOTTOM, iArr[0]);
                this.h.a(p4.a.RIGHT, iArr[1]);
            } else if (ordinal == 3) {
                this.h.a(p4.a.TOP, iArr[0]);
                this.h.a(p4.a.LEFT, iArr[1]);
            }
            this.h.q();
            e();
        }
    }

    public void a(d dVar) {
        sh shVar = this.g;
        if (shVar != null) {
            shVar.a(dVar);
        }
    }

    public void a(mf.a aVar, TencentMapOptions tencentMapOptions) {
        if (tencentMapOptions == null || tencentMapOptions.getExtSurface() == null) {
            return;
        }
        this.k = aVar;
        int extSurfaceWidth = tencentMapOptions.getExtSurfaceWidth();
        int extSurfaceHeight = tencentMapOptions.getExtSurfaceHeight();
        this.d.measure(View.MeasureSpec.makeMeasureSpec(extSurfaceWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(extSurfaceHeight, 1073741824));
        a(extSurfaceWidth, extSurfaceHeight);
    }

    public void a(qh.j jVar, TencentMapOptions tencentMapOptions) {
        qh qhVar;
        if (tencentMapOptions == null || tencentMapOptions.getExtSurface() == null || (qhVar = this.h) == null) {
            return;
        }
        qhVar.a(jVar);
        int extSurfaceWidth = tencentMapOptions.getExtSurfaceWidth();
        int extSurfaceHeight = tencentMapOptions.getExtSurfaceHeight();
        this.d.measure(View.MeasureSpec.makeMeasureSpec(extSurfaceWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(extSurfaceHeight, 1073741824));
        a(extSurfaceWidth, extSurfaceHeight);
    }

    @Override // com.tencent.mapsdk.internal.c5
    public void a(v5 v5Var) {
        int i;
        if (v5Var == null || (i = v5Var.f24371a) == -1) {
            return;
        }
        this.p.sendMessage(this.p.obtainMessage(i, v5Var));
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void a(boolean z) {
        qh qhVar = this.h;
        if (qhVar != null) {
            qhVar.a(z);
        }
    }

    @Override // com.tencent.mapsdk.internal.d1
    public void a(boolean z, List<zh> list) {
        b(z, list);
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void b(int i) {
        qh qhVar = this.h;
        if (qhVar != null) {
            qhVar.a(p4.a.BOTTOM, i);
            this.h.q();
            e();
        }
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void b(int i, int i2, int i3, int i4, int i5) {
        qh qhVar = this.h;
        if (qhVar != null) {
            qhVar.b(p4.b.a(i));
            this.h.b(p4.a.TOP, i2);
            this.h.b(p4.a.BOTTOM, i3);
            this.h.b(p4.a.LEFT, i4);
            this.h.b(p4.a.RIGHT, i5);
            this.h.s();
            e();
        }
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void b(boolean z) {
        this.f.setFlingGestureEnabled(z);
    }

    public void b(boolean z, List<zh> list) {
        yi yiVar;
        if (this.h == null || (yiVar = this.f) == null || yiVar.getMap() == null) {
            return;
        }
        this.h.a(list);
        if (z) {
            this.h.e();
        }
        this.h.a(this.f.i0(), this.f.getMapContext().a());
    }

    @Override // com.tencent.mapsdk.internal.l0
    public boolean b() {
        qh qhVar = this.h;
        if (qhVar != null) {
            return qhVar.l();
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.l0
    public float c(int i) {
        qh qhVar = this.h;
        if (qhVar != null) {
            return qhVar.b(p4.a.a(i));
        }
        return 0.0f;
    }

    public void c() {
        ViewGroup viewGroup = this.d;
        yi yiVar = this.f;
        if (viewGroup == null || yiVar == null) {
            return;
        }
        Handler handler = this.p;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        yiVar.getMap().b(this);
        yiVar.b((d1) this);
        yiVar.a((c5) this);
        viewGroup.removeAllViews();
        for (p4 p4Var : this.n) {
            p4Var.a();
        }
        this.n.clear();
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void d(int i) {
        qh qhVar = this.h;
        if (qhVar != null) {
            qhVar.b(p4.b.a(i));
            e();
        }
    }

    public void e() {
        ca.b(new b());
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void e(int i) {
        qh qhVar = this.h;
        if (qhVar != null) {
            qhVar.a(p4.a.LEFT, i);
            this.h.q();
            e();
        }
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void f(int i) {
        qh qhVar = this.h;
        if (qhVar != null) {
            qhVar.a(p4.b.a(i));
            e();
        }
    }

    @Override // com.tencent.mapsdk.internal.l0
    public boolean isCompassEnabled() {
        return this.f.D();
    }

    @Override // com.tencent.mapsdk.internal.l0
    public boolean isIndoorLevelPickerEnabled() {
        eg egVar = this.i;
        if (egVar != null) {
            return egVar.h();
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.l0
    public boolean isMyLocationButtonEnabled() {
        return this.o;
    }

    @Override // com.tencent.mapsdk.internal.l0
    public boolean isRotateGesturesEnabled() {
        return this.f.M();
    }

    @Override // com.tencent.mapsdk.internal.l0
    public boolean isScrollGesturesEnabled() {
        return this.f.O();
    }

    @Override // com.tencent.mapsdk.internal.l0
    public boolean isTiltGesturesEnabled() {
        return this.f.f();
    }

    @Override // com.tencent.mapsdk.internal.l0
    public boolean isZoomControlsEnabled() {
        return this.g.f();
    }

    @Override // com.tencent.mapsdk.internal.l0
    public boolean isZoomGesturesEnabled() {
        return this.f.G();
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setAllGesturesEnabled(boolean z) {
        this.f.j(z);
        setScrollGesturesEnabled(z);
        setZoomGesturesEnabled(z);
        setTiltGesturesEnabled(z);
        setRotateGesturesEnabled(z);
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setCompassEnabled(boolean z) {
        this.f.c(z);
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setCompassExtraPadding(int i) {
        yi yiVar = this.f;
        if (yiVar != null) {
            yiVar.setCompassExtraPadding(i);
        }
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setCompassExtraPadding(int i, int i2) {
        yi yiVar = this.f;
        if (yiVar != null) {
            yiVar.setCompassExtraPadding(i, i2);
        }
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setGestureRotateByMapCenter(boolean z) {
        yi yiVar = this.f;
        if (yiVar == null || yiVar.getMap() == null) {
            return;
        }
        this.f.getMap().f(z);
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setGestureScaleByMapCenter(boolean z) {
        yi yiVar = this.f;
        if (yiVar == null || yiVar.getMap() == null) {
            return;
        }
        this.f.getMap().g(z);
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setIndoorLevelPickerEnabled(boolean z) {
        this.i.a(z);
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setLogoScale(float f) {
        qh qhVar = this.h;
        if (qhVar != null) {
            qhVar.b(f);
        }
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setLogoSize(int i) {
        qh qhVar = this.h;
        if (qhVar != null) {
            qhVar.a(i);
        }
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setMyLocationButtonEnabled(boolean z) {
        this.o = z;
        this.g.a(z);
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setRotateGesturesEnabled(boolean z) {
        this.f.d(z);
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setScaleViewEnabled(boolean z) {
        qh qhVar = this.h;
        if (qhVar != null) {
            qhVar.b(z);
        }
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setScaleViewFadeEnable(boolean z) {
        qh qhVar = this.h;
        if (qhVar != null) {
            qhVar.c(z);
        }
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setScrollGesturesEnabled(boolean z) {
        this.f.e(z);
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setTiltGesturesEnabled(boolean z) {
        this.f.b(z);
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setZoomControlsEnabled(boolean z) {
        this.g.b(z);
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setZoomGesturesEnabled(boolean z) {
        this.f.h(z);
    }

    @Override // com.tencent.mapsdk.internal.l0
    public void setZoomPosition(int i) {
        sh shVar = this.g;
        if (shVar != null) {
            shVar.a(p4.b.a(i));
        }
    }
}
