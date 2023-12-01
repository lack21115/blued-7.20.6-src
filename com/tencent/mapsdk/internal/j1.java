package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.da;
import com.tencent.mapsdk.internal.mf;
import com.tencent.mapsdk.internal.qh;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/j1.class */
public class j1 implements c1, mf.a, qh.j {

    /* renamed from: a  reason: collision with root package name */
    private final e1 f37560a;
    private Marker d;
    private Marker e;
    private Marker f;
    private da.a g;
    private TencentMap.OnMarkerDragListener h;
    private final i1 i;
    private y4 j;
    private List<x4> k;
    private a5 l;
    private v4 m;
    private Marker b = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f37561c = false;
    private final Map<Class<? extends vc>, uc> n = new HashMap();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/j1$a.class */
    public class a implements TencentMap.OnMarkerClickListener {
        public a() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener
        public boolean onMarkerClick(Marker marker) {
            if (j1.this.g == null) {
                j1 j1Var = j1.this;
                j1Var.g = da.a(j1Var.f37560a.getContext());
            }
            na.a(j1.this.f37560a.getContext(), j1.this.g);
            return false;
        }
    }

    public j1(i1 i1Var, e1 e1Var) {
        this.f37560a = e1Var;
        this.i = i1Var;
    }

    private boolean b(float f, float f2) {
        List<x4> list;
        y4 y4Var;
        TappedElement a2 = this.f37560a.f().a(f, f2);
        if (a2 == null) {
            return false;
        }
        int i = a2.type;
        if (i == 1 && (y4Var = this.j) != null) {
            y4Var.a(new u5(a2.name, fa.b(a2.pixelX, a2.pixelY)));
            return true;
        } else if (i != 6 || (list = this.k) == null) {
            a5 a5Var = this.l;
            if (a5Var != null) {
                a5Var.a();
                return false;
            }
            return false;
        } else {
            for (x4 x4Var : list) {
                if (x4Var != null) {
                    x4Var.a();
                }
            }
            return true;
        }
    }

    public Pair<VectorOverlay, TencentMap.IClickedObject> a(LatLng latLng, long j, String str, String str2) {
        uc ucVar = this.n.get(ed.class);
        return ucVar != null ? ucVar.a(latLng, j, str, str2) : new Pair<>(null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <O extends vc, L extends tc<O>> L a(O o) {
        qd ddVar;
        e1 e1Var = this.f37560a;
        if (o == null || e1Var == null) {
            return null;
        }
        uc ucVar = this.n.get(o.getClass());
        uc ucVar2 = ucVar;
        if (ucVar == null) {
            if (o.getClass() == rd.class) {
                ddVar = new qd(e1Var.f());
            } else if (o.getClass() == cd.class) {
                ddVar = new bd(e1Var.f());
            } else if (o.getClass() == yc.class) {
                ddVar = new zc(e1Var.f());
            } else if (o.getClass() == id.class) {
                ddVar = new hd(e1Var.f());
            } else if (o.getClass() == ld.class) {
                ddVar = new kd(e1Var.f());
            } else if (o.getClass() == od.class) {
                ddVar = new md(e1Var.f());
            } else if (o.getClass() == ud.class) {
                ddVar = new td(e1Var.f());
            } else if (o.getClass() == xd.class) {
                ddVar = new wd(e1Var.f());
            } else {
                ddVar = ucVar;
                if (o.getClass() == ed.class) {
                    ddVar = new dd(e1Var.f());
                }
            }
            this.n.put(o.getClass(), ddVar);
            ucVar2 = ddVar;
        }
        return (L) ucVar2.a((uc) o);
    }

    public <O extends vc, L extends tc<O>> L a(Class<L> cls, int i) {
        L l;
        uc ucVar = this.n.get(((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[0]);
        if (ucVar == null || (l = (L) ucVar.a(i)) == null) {
            return null;
        }
        return l;
    }

    @Override // com.tencent.mapsdk.internal.c1
    public void a() {
        this.f37561c = false;
        this.b = null;
    }

    public <O extends vc, L extends tc<O>> void a(int i, O o) {
        tc a2;
        uc ucVar = this.n.get(o.getClass());
        if (ucVar == null || (a2 = ucVar.a(i)) == null) {
            return;
        }
        a2.a((tc) o);
        ucVar.c(a2);
    }

    @Override // com.tencent.mapsdk.internal.mf.a
    public void a(Bitmap bitmap, int i, int i2) {
        Marker marker = this.f;
        if (marker == null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.anchor(0.5f, 0.5f);
            markerOptions.tag(mf.j);
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(this.f37560a, bitmap));
            Marker a2 = this.i.a(markerOptions);
            this.f = a2;
            a2.setFixingPoint(i / 2, i2 / 2);
            this.f.setClickable(false);
        } else {
            marker.setIcon(BitmapDescriptorFactory.fromBitmap(this.f37560a, bitmap));
            this.f.setFixingPoint(i / 2, i2 / 2);
        }
        ha.a(bitmap);
    }

    @Override // com.tencent.mapsdk.internal.c1
    public void a(MotionEvent motionEvent) {
        if (this.f37560a == null || !this.f37561c || this.b == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.b.setPosition(fa.d(this.f37560a.getProjection().a(new p5((int) motionEvent.getX(), (int) motionEvent.getY()))));
                TencentMap.OnMarkerDragListener onMarkerDragListener = this.h;
                if (onMarkerDragListener != null) {
                    onMarkerDragListener.onMarkerDrag(this.b);
                    return;
                }
                return;
            } else if (action != 3 && action != 4) {
                return;
            }
        }
        this.f37561c = false;
        TencentMap.OnMarkerDragListener onMarkerDragListener2 = this.h;
        if (onMarkerDragListener2 != null) {
            onMarkerDragListener2.onMarkerDragEnd(this.b);
        }
        this.b = null;
    }

    @Override // com.tencent.mapsdk.internal.qh.j
    public void a(View view, Rect rect, boolean z) {
        Bitmap a2;
        if (view == null || rect == null || (a2 = b7.a(view)) == null) {
            return;
        }
        if (this.e == null) {
            MarkerOptions visible = new MarkerOptions().anchor(0.0f, 0.0f).visible(false);
            visible.tag(mf.j);
            visible.fastLoad(true);
            Marker a3 = this.i.a(visible);
            this.e = a3;
            a3.setClickable(false);
        }
        this.e.setFixingPoint(rect.left, rect.top);
        this.e.setIcon(BitmapDescriptorFactory.fromBitmap(this.f37560a, a2));
        this.e.setVisible(z);
        ha.a(a2);
    }

    public void a(a5 a5Var) {
        this.l = a5Var;
    }

    @Override // com.tencent.mapsdk.internal.qh.j
    public void a(qh qhVar) {
        Marker marker = this.e;
        if (marker != null) {
            marker.setVisible(true);
        }
        Marker marker2 = this.d;
        if (marker2 != null) {
            marker2.setVisible(true);
        }
    }

    public void a(u4 u4Var) {
        b(u4Var);
    }

    public void a(u4 u4Var, u4 u4Var2) {
        b(u4Var);
    }

    public void a(v4 v4Var) {
        this.m = v4Var;
    }

    public void a(x4 x4Var) {
        if (x4Var == null) {
            return;
        }
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(x4Var);
    }

    public void a(y4 y4Var) {
        this.j = y4Var;
    }

    public void a(TencentMap.OnMarkerDragListener onMarkerDragListener) {
        this.h = onMarkerDragListener;
    }

    @Override // com.tencent.mapsdk.internal.c1
    public void a(String str) {
        if (str.trim().length() == 0) {
            this.b = null;
            this.f37561c = false;
            return;
        }
        Marker marker = (Marker) this.i.a(str, w0.class);
        this.b = marker;
        if (marker != null) {
            e1 e1Var = this.f37560a;
            if ((e1Var instanceof q1) && a((q1) e1Var, marker)) {
                return;
            }
            if (!this.b.isDraggable()) {
                this.b = null;
                this.f37561c = false;
                return;
            }
            this.f37561c = true;
            TencentMap.OnMarkerDragListener onMarkerDragListener = this.h;
            if (onMarkerDragListener != null) {
                onMarkerDragListener.onMarkerDragStart(this.b);
            }
        }
    }

    public boolean a(float f, float f2) {
        if (this.i.a(f, f2)) {
            return true;
        }
        return b(f, f2);
    }

    public <O extends vc, L extends tc<O>> boolean a(int i, Class<L> cls) {
        tc a2 = a(cls, i);
        if (a2 != null) {
            a2.remove();
            return true;
        }
        return false;
    }

    public boolean a(q1 q1Var, Marker marker) {
        if (marker == null || marker != this.d) {
            return false;
        }
        return g6.a(q1Var);
    }

    @Deprecated
    public boolean a(GL10 gl10) {
        this.i.a(gl10);
        return true;
    }

    public void b() {
        Collection<uc> values;
        Map<Class<? extends vc>, uc> map = this.n;
        if (map == null || (values = map.values()) == null || values.isEmpty()) {
            return;
        }
        for (uc ucVar : values) {
            ucVar.c();
        }
    }

    @Override // com.tencent.mapsdk.internal.qh.j
    public void b(View view, Rect rect, boolean z) {
        Bitmap a2;
        if (view == null || rect == null || (a2 = b7.a(view)) == null) {
            return;
        }
        if (this.d == null) {
            MarkerOptions visible = new MarkerOptions().anchor(0.0f, 0.0f).visible(false);
            visible.tag(mf.j);
            visible.fastLoad(true);
            Marker a3 = this.i.a(visible);
            this.d = a3;
            w0 w0Var = (w0) this.i.a(a3.getId(), w0.class);
            if (w0Var != null) {
                w0Var.x().a(new a());
            }
        }
        this.d.setFixingPoint(rect.left, rect.top);
        this.d.setIcon(BitmapDescriptorFactory.fromBitmap(this.f37560a, a2));
        this.d.setVisible(z);
        ha.a(a2);
    }

    @Override // com.tencent.mapsdk.internal.qh.j
    public void b(qh qhVar) {
        Marker marker = this.e;
        if (marker != null) {
            marker.setVisible(false);
        }
        if (qhVar == null || this.d == null || qhVar.u()) {
            return;
        }
        this.d.setVisible(false);
    }

    public void b(u4 u4Var) {
        this.i.a(u4Var);
    }

    public void b(u4 u4Var, u4 u4Var2) {
        b(u4Var);
    }

    public void b(x4 x4Var) {
        List<x4> list;
        if (x4Var == null || (list = this.k) == null) {
            return;
        }
        list.remove(x4Var);
    }

    public i1 c() {
        return this.i;
    }

    public void c(u4 u4Var) {
        b(u4Var);
    }

    public boolean c(float f, float f2) {
        TappedElement a2 = this.f37560a.f().a(f, f2);
        if (a2 != null && a2.type == 3) {
            v4 v4Var = this.m;
            if (v4Var != null) {
                v4Var.j();
                return true;
            }
            return true;
        }
        return false;
    }

    public void d(u4 u4Var) {
        this.i.b(u4Var);
    }

    public boolean d() {
        uc ucVar = this.n.get(ed.class);
        if (ucVar != null) {
            return ucVar.b();
        }
        return false;
    }

    public boolean d(float f, float f2) {
        TappedElement a2 = this.f37560a.f().a(f, f2);
        return a2 != null && a2.type == 6;
    }

    public void e() {
        Collection<uc> values;
        Map<Class<? extends vc>, uc> map = this.n;
        if (map != null && (values = map.values()) != null && !values.isEmpty()) {
            for (uc ucVar : values) {
                ucVar.d();
            }
        }
        a();
    }
}
