package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.mapsdk.internal.n5;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.TencentMapProtocol;
import com.tencent.tencentmap.mapsdk.maps.TencentMapResource;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/q1.class */
public abstract class q1 implements TencentMapContext {
    private static final Map<Class<? extends TencentMapComponent.Component>, TencentMapComponent.Component> i = new ConcurrentHashMap();
    private static final Set<a> j;
    private static final String k = "map-context.cache";
    private static final String l = "navi_marker_location.png";
    private static final String m = "color_texture_flat_style.png";

    /* renamed from: a  reason: collision with root package name */
    private final Context f37710a;
    private final TencentMapOptions b;

    /* renamed from: c  reason: collision with root package name */
    private final r1 f37711c;
    private f6 d;
    private w6 e;
    private boolean f = false;
    private volatile boolean g = true;
    private mc h;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/q1$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Class<? extends TencentMapComponent.Component> f37712a;
        public Class<? extends TencentMapComponent.Component> b;

        public a(Class<? extends TencentMapComponent.Component> cls, Class<? extends TencentMapComponent.Component> cls2) {
            this.f37712a = cls;
            this.b = cls2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            Class<? extends TencentMapComponent.Component> cls = this.f37712a;
            if (cls != null) {
                if (!cls.equals(aVar.f37712a)) {
                    return false;
                }
            } else if (aVar.f37712a != null) {
                return false;
            }
            Class<? extends TencentMapComponent.Component> cls2 = this.b;
            Class<? extends TencentMapComponent.Component> cls3 = aVar.b;
            return cls2 != null ? cls2.equals(cls3) : cls3 == null;
        }

        public int hashCode() {
            Class<? extends TencentMapComponent.Component> cls = this.f37712a;
            int i = 0;
            int hashCode = cls != null ? cls.hashCode() : 0;
            Class<? extends TencentMapComponent.Component> cls2 = this.b;
            if (cls2 != null) {
                i = cls2.hashCode();
            }
            return (hashCode * 31) + i;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/q1$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f37713a;

        /* renamed from: c  reason: collision with root package name */
        public String f37714c;
        public String d;
        public String f;
        public String b = c7.N();
        public String e = c7.E();

        public b(TencentMapOptions tencentMapOptions) {
            this.f = "undefined";
            this.f37713a = c7.t();
            if (tencentMapOptions != null) {
                if (!TextUtils.isEmpty(tencentMapOptions.getMapKey())) {
                    this.f37713a = tencentMapOptions.getMapKey();
                }
                if (!TextUtils.isEmpty(tencentMapOptions.getSubKey())) {
                    this.f37714c = tencentMapOptions.getSubKey();
                }
                if (!TextUtils.isEmpty(tencentMapOptions.getSubId())) {
                    this.d = tencentMapOptions.getSubId();
                }
                this.f = tencentMapOptions.getCustomUserId();
            }
        }

        public String a() {
            return this.f;
        }

        public String b() {
            return TextUtils.isEmpty(this.f37714c) ? this.f37713a : this.f37714c;
        }

        public String c() {
            return xa.a(e());
        }

        public String d() {
            return xa.a(f());
        }

        public String e() {
            return this.f37713a + "-" + this.b + "-" + this.f37714c + "-" + this.d;
        }

        public String f() {
            return this.e + "-" + this.f37713a + "-" + this.b + "-" + this.f37714c + "-" + this.d;
        }

        public String g() {
            return this.f37713a;
        }

        public String h() {
            return this.b;
        }

        public String i() {
            return this.e;
        }

        public String j() {
            return this.f37714c;
        }

        public String k() {
            return this.d;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        j = hashSet;
        hashSet.add(new a(TencentMapProtocol.class, n2.class));
        hashSet.add(new a(OfflineMapComponent.class, d2.class));
    }

    public q1(Context context, TencentMapOptions tencentMapOptions, r1 r1Var) {
        this.f37710a = context.getApplicationContext();
        this.b = tencentMapOptions;
        this.f37711c = r1Var;
        BitmapDescriptorFactory.attachMapContext(this);
        jc.a(tencentMapOptions);
    }

    private void F() {
        Map<Class<? extends TencentMapComponent.Component>, Class<? extends TencentMapComponent.Component>> C = C();
        if (C != null) {
            for (Map.Entry<Class<? extends TencentMapComponent.Component>, Class<? extends TencentMapComponent.Component>> entry : C.entrySet()) {
                j.add(new a(entry.getKey(), entry.getValue()));
            }
        }
        for (a aVar : j) {
            Class<? extends TencentMapComponent.Component> cls = aVar.f37712a;
            Map<Class<? extends TencentMapComponent.Component>, TencentMapComponent.Component> map = i;
            TencentMapComponent.Component component = map.get(cls);
            Class<? extends TencentMapComponent.Component> cls2 = aVar.b;
            TencentMapComponent.Component component2 = component;
            if (component == null) {
                component2 = component;
                if (cls2 != null) {
                    component2 = component;
                    if (cls.isAssignableFrom(cls2)) {
                        component2 = (TencentMapComponent.Component) e7.a(cls2, new Object[0]);
                        if (component2 instanceof p1) {
                            ((p1) component2).a(getContext());
                        }
                        map.put(cls, component2);
                    }
                }
            }
            if (component2 instanceof p1) {
                ((p1) component2).a(this);
            }
        }
    }

    private void G() {
        for (Map.Entry<Class<? extends TencentMapComponent.Component>, TencentMapComponent.Component> entry : i.entrySet()) {
            TencentMapComponent.Component value = entry.getValue();
            if (value instanceof p1) {
                p1 p1Var = (p1) value;
                p1Var.b(this);
                if (p1Var.getMapContext() == null) {
                    i.remove(entry.getKey());
                }
            }
        }
        c7.P();
    }

    private void b(Bundle bundle) {
        a(bundle);
        if (bundle == null || bundle.size() <= 0) {
            return;
        }
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        ga.b(ga.b(ga.e, k), obtain.marshall());
        obtain.recycle();
    }

    private void z() {
        f6 f6Var = new f6(this);
        this.d = f6Var;
        f6Var.c();
        this.e = this.d.a();
    }

    public boolean A() {
        return this.f;
    }

    public boolean B() {
        return this.g;
    }

    public Map<Class<? extends TencentMapComponent.Component>, Class<? extends TencentMapComponent.Component>> C() {
        return null;
    }

    public void D() {
        b q = q();
        c7.a(this.f37710a, q.f37713a, q.b, q.f);
        z();
        F();
    }

    public void E() {
        this.d.a(this.e.s());
        b(new Bundle());
        G();
        BitmapDescriptorFactory.detachMapContext(this);
    }

    public Bundle a(Context context) {
        byte[] h;
        File file = new File(ga.e, k);
        if (!file.exists() || (h = ga.h(file)) == null || h.length <= 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(h, 0, h.length);
        Bundle bundle = new Bundle();
        bundle.readFromParcel(obtain);
        ga.d(file);
        obtain.recycle();
        return bundle;
    }

    public <T extends TencentMapComponent.Component> T a(Class<T> cls, Bundle bundle) {
        T t = (T) i.get(cls);
        if (t instanceof p1) {
            ((p1) t).a(this, bundle);
        }
        return t;
    }

    public abstract void a(Bundle bundle);

    public void a(boolean z) {
        this.f = z;
    }

    public abstract boolean a();

    public void b(boolean z) {
        this.g = z;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(float f, int i2) {
        return new BitmapDescriptor(new n5(getContext(), i2).b(f));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(int i2) {
        n5 n5Var = new n5(getContext(), i2);
        if (i2 == 5) {
            return new BitmapDescriptor(n5Var);
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(int i2, int i3) {
        return new BitmapDescriptor(new n5(getContext(), i3).a(i2));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(Bitmap bitmap, int i2) {
        return new BitmapDescriptor(new n5(getContext(), i2).b(bitmap));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(Parcelable parcelable, int i2) {
        n5 n5Var = new n5(getContext(), i2);
        if (i2 == 9) {
            if (parcelable instanceof n5.a) {
                return new BitmapDescriptor(n5Var.a((n5.a) parcelable));
            }
            return null;
        } else if (i2 == 7 && (parcelable instanceof Bitmap)) {
            return new BitmapDescriptor(n5Var.b((Bitmap) parcelable));
        } else {
            return null;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(String str, int i2) {
        n5 n5Var = new n5(getContext(), i2);
        if (i2 == 2) {
            return new BitmapDescriptor(n5Var.b(str));
        }
        if (i2 == 3) {
            return new BitmapDescriptor(n5Var.c(str));
        }
        if (i2 == 4) {
            return new BitmapDescriptor(n5Var.d(str));
        }
        if (i2 == 8) {
            return new BitmapDescriptor(n5Var.e(str));
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public BitmapDescriptor createBitmapDescriptor(Bitmap[] bitmapArr, int i2) {
        n5 n5Var = new n5(getContext(), i2);
        n5Var.a(bitmapArr);
        return new BitmapDescriptor(n5Var);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapContext
    public Context getContext() {
        return this.f37710a;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public MyLocationStyle getDefaultMyLocationStyle() {
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.icon(createBitmapDescriptor(l, 2));
        return myLocationStyle;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public <T extends TencentMapComponent.Component> T getMapComponent(Class<T> cls) {
        return (T) a(cls, null);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapContext
    public TencentMapComponent getMapComponent() {
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapContext
    public TencentMapResource getMapResource() {
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
    public TencentMapServiceProtocol getMapServiceProtocol() {
        return (TencentMapServiceProtocol) getMapComponent(TencentMapProtocol.class);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public int getScreenPixels() {
        return c7.L();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapResource
    public Typeface getTypeface() {
        return this.b.getTypeface();
    }

    public MapDelegate j() {
        return this.f37711c;
    }

    public File m() {
        return x().b();
    }

    public abstract String n();

    public abstract v1 o();

    public abstract String p();

    public b q() {
        return new b(r());
    }

    public TencentMapOptions r() {
        return this.b;
    }

    public TencentMapProtocol s() {
        return (TencentMapProtocol) getMapComponent(TencentMapProtocol.class);
    }

    public MapViewType t() {
        return this.b.getMapViewType();
    }

    public OverSeaSource u() {
        return this.b.getOverSeaSource();
    }

    public p2 v() {
        TencentMapProtocol s = s();
        return s instanceof n2 ? ((n2) s).h().a() : n2.g();
    }

    public w6 w() {
        return this.e;
    }

    public mc x() {
        if (this.h == null) {
            this.h = mc.a(this.f37710a, this.b);
        }
        return this.h;
    }

    public abstract String y();
}
