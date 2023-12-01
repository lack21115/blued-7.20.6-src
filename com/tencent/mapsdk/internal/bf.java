package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.ReturnCallback;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.internal.a8;
import com.tencent.mapsdk.internal.p7;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collision;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionItem;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/bf.class */
public class bf extends ze<o0> implements o0 {
    public Object B;
    public Bitmap C;
    public boolean D;
    public final Object E;
    public float F;
    public float G;
    public boolean H;
    public float I;
    public float J;
    public float K;
    public MarkerOptions L;
    public String M;
    public GeoPoint N;
    public GeoPoint O;
    public GeoPoint P;
    public float Q;
    public float R;
    public float S;
    public boolean T;
    private boolean U;
    private int V;
    private int W;
    private boolean X;
    private GeoPoint Y;
    private yi Z;
    private ig a0;
    private AnimationListener b0;
    private a8 c0;
    private TencentMap.OnMarkerClickListener d0;
    public r4 e0;
    private boolean f0;
    private LatLng g0;
    private Collision[] h0;
    private int i0;
    private final a8.b j0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/bf$a.class */
    public class a implements a8.b {
        public a() {
        }

        @Override // com.tencent.mapsdk.internal.a8.b
        public void a(float f) {
        }

        @Override // com.tencent.mapsdk.internal.a8.b
        public void a(float f, float f2, float f3, float f4) {
            bf.this.setRotation(f);
            bf bfVar = bf.this;
            bfVar.I = f2;
            bfVar.J = f3;
            bfVar.K = f4;
            bfVar.H = true;
            if (bfVar.a0 != null) {
                bf.this.a0.b((int) bf.this.getRotation());
            }
        }

        @Override // com.tencent.mapsdk.internal.a8.b
        public void a(int i, int i2) {
            if (bf.this.Z == null || bf.this.N == null) {
                return;
            }
            GeoPoint geoPoint = new GeoPoint();
            if (!bf.this.X || bf.this.Y == null || bf.this.Z.getMap() == null) {
                bf.this.N.setLatitudeE6(i + 0);
                bf.this.N.setLongitudeE6(i2 + 0);
            } else {
                GeoPoint a2 = bf.this.Z.getMap().getProjection().a(new p5(bf.this.V, bf.this.W));
                int latitudeE6 = a2.getLatitudeE6();
                int latitudeE62 = bf.this.Y.getLatitudeE6();
                int longitudeE6 = a2.getLongitudeE6();
                int longitudeE62 = bf.this.Y.getLongitudeE6();
                geoPoint.setLatitudeE6(i + (latitudeE6 - latitudeE62));
                geoPoint.setLongitudeE6(i2 + (longitudeE6 - longitudeE62));
                p5 a3 = bf.this.Z.getMap().getProjection().a(geoPoint);
                bf.this.N.setLatitudeE6((int) a3.f23992c);
                bf.this.N.setLongitudeE6((int) a3.b);
            }
            bf bfVar = bf.this;
            MarkerOptions markerOptions = bfVar.L;
            if (markerOptions != null) {
                markerOptions.position(fa.d(bfVar.N));
            }
            if (bf.this.a0 != null) {
                bf.this.a0.a(bf.this.N);
            }
            bf bfVar2 = bf.this;
            r4 r4Var = bfVar2.e0;
            if (r4Var != null) {
                r4Var.setPosition(fa.d(bfVar2.N));
            }
        }

        @Override // com.tencent.mapsdk.internal.a8.b
        public void setAlpha(float f) {
            bf bfVar = bf.this;
            bfVar.Q = f;
            if (bfVar.a0 != null) {
                bf.this.a0.setAlpha(bf.this.Q);
                bf bfVar2 = bf.this;
                bfVar2.L.alpha(bfVar2.Q);
            }
            bf bfVar3 = bf.this;
            r4 r4Var = bfVar3.e0;
            if (r4Var != null) {
                r4Var.a(bfVar3.L);
            }
        }

        @Override // com.tencent.mapsdk.internal.a8.b
        public void setScale(float f, float f2) {
            bf.this.a(f, f2);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/bf$b.class */
    public class b extends p7.a {
        public b() {
        }

        @Override // com.tencent.mapsdk.internal.p7.a
        public void a(float f) {
            MarkerOptions markerOptions;
            super.a(f);
            if (bf.this.a0 == null || bf.this.Z == null || (markerOptions = bf.this.L) == null) {
                return;
            }
            BitmapDescriptor icon = markerOptions.getIcon();
            int activeSize = icon.getFormater().activeSize();
            na.a(ma.f23952c, "current Marker iconLooper getValue:" + f);
            int round = Math.round(((float) activeSize) * f);
            na.a(ma.f23952c, "current Marker iconLooper activeIndex:" + round);
            if (round != bf.this.i0) {
                bf bfVar = bf.this;
                bfVar.a(bfVar.Z.getContext(), icon.getFormater());
                icon.getFormater().nextActiveIndex();
                bf.this.i0 = round;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/bf$c.class */
    public class c implements ReturnCallback<Boolean, Collision> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Collision f23636a;

        public c(Collision collision) {
            this.f23636a = collision;
        }

        @Override // com.tencent.map.tools.ReturnCallback
        /* renamed from: a */
        public Boolean callback(Collision collision) {
            return Boolean.valueOf(collision == this.f23636a);
        }
    }

    public bf(yi yiVar) {
        super(yiVar);
        this.B = null;
        this.C = null;
        this.D = false;
        this.E = new Object();
        this.F = 0.5f;
        this.G = 0.5f;
        this.H = false;
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = -1.0f;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = 1.0f;
        this.R = 1.0f;
        this.S = 1.0f;
        this.T = false;
        this.U = false;
        this.V = 0;
        this.W = 0;
        this.X = false;
        this.Y = null;
        this.Z = null;
        this.b0 = null;
        this.c0 = null;
        this.j0 = new a();
        this.Z = yiVar;
        setClickable(true);
    }

    private boolean J() {
        MarkerOptions markerOptions = this.L;
        if (markerOptions == null || !markerOptions.isInfoWindowEnable()) {
            return false;
        }
        r4 r4Var = this.e0;
        return ((r4Var == null || r4Var.o() == null) && f7.b(markerOptions.getTitle()) && f7.b(markerOptions.getSnippet())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, float f2) {
        int anchorU;
        if (f >= 0.0f) {
            this.R = f;
        }
        if (f2 >= 0.0f) {
            this.S = f2;
        }
        ig igVar = this.a0;
        if (igVar != null) {
            igVar.setScale(this.R, this.S);
            int height = getHeight(this.Z.getContext());
            float width = getWidth(this.Z.getContext());
            float f3 = this.R * width;
            if (f3 >= width) {
                float f4 = f3 - width;
                anchorU = (int) ((0.5f * f4) - (getAnchorU() * f4));
            } else {
                float f5 = width - f3;
                anchorU = (int) ((getAnchorU() * f5) - (f5 * 0.5f));
            }
            float f6 = height;
            this.L.infoWindowOffset(anchorU, (int) (getAnchorV() * (f6 - (this.S * f6))));
        }
        if (this.e0 != null) {
            refreshInfoWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, BitmapDescriptor.BitmapFormator bitmapFormator) {
        if (bitmapFormator != null) {
            Bitmap bitmap = bitmapFormator.getBitmap(context);
            String str = this.M;
            if (str == null || !str.equals(bitmapFormator.getBitmapId())) {
                a(bitmapFormator.getBitmapId());
                a(bitmap);
            }
        }
    }

    private void a(String str) {
        synchronized (this.E) {
            this.M = str;
        }
    }

    private void b(MarkerOptions markerOptions) {
        Bitmap bitmap;
        String str;
        if (this.Z == null || markerOptions == null || this.a0 != null) {
            return;
        }
        jg jgVar = new jg();
        jgVar.a(GeoPoint.from(markerOptions.getPosition())).a(markerOptions.getAlpha()).a(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        String a2 = xa.a();
        Bitmap bitmap2 = null;
        try {
            bitmap = markerOptions.getIcon().getBitmap(this.Z.getContext());
            bitmap2 = bitmap;
            str = markerOptions.getIcon().getFormater().getBitmapId();
        } catch (NullPointerException e) {
            e.printStackTrace();
            bitmap = bitmap2;
            str = a2;
        }
        jgVar.a(str, bitmap).c((int) markerOptions.getRotation()).f(markerOptions.isFlat()).d((int) markerOptions.getZIndex()).e(this.U).a(false).b(isCollisionBy(MarkerCollisionItem.POI)).c(markerOptions.isClockwise()).d(markerOptions.isFastLoad()).b(markerOptions.getLevel());
        this.a0 = new ig(this, this.Z, jgVar);
        setIconLooper(markerOptions.getIcon(), markerOptions.isIconLooperEnable(), markerOptions.getIconLooperDuration());
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void E() {
        r4 r4Var;
        ig igVar;
        if (this.Z == null) {
            return;
        }
        if (!isVisible()) {
            releaseData();
            return;
        }
        U();
        K();
        yi yiVar = this.Z;
        if (yiVar == null || yiVar.getMap() == null) {
            return;
        }
        if (this.Z.getMap().F() != null && (igVar = this.a0) != null) {
            igVar.E();
        }
        if (this.f0 && ((r4Var = this.e0) == null || !r4Var.r())) {
            showInfoWindow();
        }
        r4 r4Var2 = this.e0;
        if (r4Var2 == null || !r4Var2.r()) {
            return;
        }
        this.e0.a((GL10) null);
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void H() {
        yi yiVar = this.Z;
        if (yiVar != null) {
            if (getId().equals(yiVar.I())) {
                yiVar.a("", false);
            }
        }
        ig igVar = this.a0;
        if (igVar != null) {
            igVar.a0();
        }
        r4 r4Var = this.e0;
        if (r4Var != null) {
            r4Var.remove();
        }
        this.Z = null;
    }

    public boolean K() {
        a8 a8Var;
        if (this.Z == null || (a8Var = this.c0) == null) {
            return false;
        }
        a8Var.a();
        boolean f = this.c0.f();
        this.X = f;
        if (!f || this.Z.getMap() == null) {
            return true;
        }
        this.Z.getMap().v0();
        return true;
    }

    public int L() {
        Bitmap bitmap = this.C;
        if (bitmap == null || this.a0 == null) {
            return 0;
        }
        float width = bitmap.getWidth();
        return (int) ((this.a0.K() * width) - (width * 0.5f));
    }

    public Rect M() {
        yi yiVar;
        return (this.a0 == null || (yiVar = this.Z) == null || yiVar.getMap() == null) ? new Rect() : this.a0.a(this.Z.getMap().getProjection());
    }

    public String N() {
        return "GLMarkerOverlay-" + y();
    }

    public Boundable<t4> O() {
        return this.a0;
    }

    @Override // com.tencent.mapsdk.internal.v0
    /* renamed from: P */
    public o0 x() {
        return this;
    }

    public boolean Q() {
        return this.X;
    }

    public boolean R() {
        return this.U;
    }

    public boolean S() {
        if (this.Z == null) {
            return false;
        }
        Rect g = g();
        int X = this.Z.X();
        int V = this.Z.V();
        boolean z = false;
        if (g.left >= 0) {
            z = false;
            if (g.top >= 0) {
                z = false;
                if (g.right <= X) {
                    z = false;
                    if (g.bottom <= V) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public void T() {
        synchronized (this.E) {
            Bitmap bitmap = this.C;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.D = true;
            }
        }
    }

    public void U() {
        yi yiVar = this.Z;
        if (yiVar == null || !this.T) {
            return;
        }
        a(yiVar.c());
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.q4, com.tencent.mapsdk.internal.o0
    public int a() {
        ig igVar = this.a0;
        return igVar != null ? igVar.a() : super.a();
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a */
    public Rect getBound(t4 t4Var) {
        return M();
    }

    @Override // com.tencent.mapsdk.internal.o0
    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        b(bitmap);
        T();
    }

    public void a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return;
        }
        GeoPoint geoPoint2 = this.N;
        if (geoPoint2 == null) {
            this.N = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        } else {
            geoPoint2.setLatitudeE6(geoPoint.getLatitudeE6());
            this.N.setLongitudeE6(geoPoint.getLongitudeE6());
        }
        ig igVar = this.a0;
        if (igVar != null) {
            igVar.a(this.N);
        }
        r4 r4Var = this.e0;
        if (r4Var != null) {
            r4Var.setPosition(fa.d(this.N));
        }
    }

    @Override // com.tencent.mapsdk.internal.o0
    public void a(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        this.d0 = onMarkerClickListener;
    }

    @Override // com.tencent.mapsdk.internal.o0
    public void a(BitmapDescriptor bitmapDescriptor, BitmapDescriptor bitmapDescriptor2) {
        yi yiVar = this.Z;
        if (yiVar == null) {
            return;
        }
        BitmapDescriptor bitmapDescriptor3 = bitmapDescriptor;
        if (bitmapDescriptor == null) {
            bitmapDescriptor3 = bitmapDescriptor;
            if (bitmapDescriptor2 != null) {
                bitmapDescriptor3 = bitmapDescriptor2;
            }
        }
        if (bitmapDescriptor3 == null) {
            return;
        }
        if (this.a0 != null) {
            a(yiVar.getContext(), bitmapDescriptor3.getFormater());
        }
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.icon(bitmapDescriptor3);
        }
        r4 r4Var = this.e0;
        if (r4Var != null) {
            r4Var.u();
        }
    }

    @Override // com.tencent.mapsdk.internal.o0
    public void a(LatLng latLng) {
        r4 r4Var;
        yi yiVar = this.Z;
        setPosition(latLng);
        if (!getId().equals(yiVar != null ? yiVar.I() : "") || (r4Var = this.e0) == null) {
            return;
        }
        r4Var.setPosition(latLng);
    }

    @Override // com.tencent.mapsdk.internal.o0
    public void a(boolean z) {
        this.T = z;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b */
    public Rect getScreenBound(t4 t4Var) {
        ig igVar = this.a0;
        Rect rect = null;
        if (igVar == null) {
            return null;
        }
        Rect b2 = igVar.b(t4Var);
        r4 r4Var = this.e0;
        if (r4Var != null) {
            rect = r4Var.getScreenBound(t4Var);
        }
        if (b2 == null) {
            return rect;
        }
        if (rect == null) {
            return b2;
        }
        return new Rect(Math.min(b2.left, rect.left), Math.min(b2.top, rect.top), Math.max(b2.right, rect.right), Math.max(b2.bottom, rect.bottom));
    }

    @Override // com.tencent.mapsdk.internal.o0
    public List<Boundable<t4>> b() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(O());
        r4 r4Var = this.e0;
        if (r4Var != null && r4Var.r()) {
            arrayList.add(this.e0);
        }
        return arrayList;
    }

    public void b(Bitmap bitmap) {
        synchronized (this.E) {
            this.C = bitmap;
            if (this.M == null) {
                this.M = bitmap.toString();
            }
            ig igVar = this.a0;
            if (igVar != null) {
                igVar.b(this.M, this.C);
            }
        }
    }

    public void b(a8 a8Var) {
        this.c0 = a8Var;
        if (a8Var != null) {
            a8Var.a(this.j0);
        }
    }

    @Override // com.tencent.mapsdk.internal.o0
    @Deprecated
    public void c(boolean z) {
        yi yiVar = this.Z;
        if (yiVar != null) {
            yiVar.setOnTapMapViewInfoWindowHidden(z);
        }
    }

    public int f(boolean z) {
        Bitmap bitmap = this.C;
        if (bitmap == null || this.a0 == null) {
            return 0;
        }
        int height = bitmap.getHeight();
        return (int) (!z ? height * this.a0.L() : height * (1.0f - this.a0.L()));
    }

    @Override // com.tencent.mapsdk.internal.o0
    public Rect g() {
        yi yiVar;
        return (this.a0 == null || (yiVar = this.Z) == null || yiVar.getMap() == null) ? new Rect() : this.a0.b(this.Z.getMap().getProjection());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable
    public float getAlpha() {
        return this.Q;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Anchorable
    public float getAnchorU() {
        return this.L.getAnchorU();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Anchorable
    public float getAnchorV() {
        return this.L.getAnchorV();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Accessible
    public String getContentDescription() {
        MarkerOptions markerOptions = this.L;
        if (markerOptions == null) {
            return null;
        }
        return markerOptions.getContentDescription();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    @Deprecated
    public int getDisplayLevel() {
        return getLevel();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable
    public float getEqualScale() {
        return this.R;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public int getHeight(Context context) {
        Bitmap bitmap;
        BitmapDescriptor icon = this.L.getIcon();
        if (icon == null || (bitmap = icon.getFormater().getBitmap(context)) == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    @Deprecated
    public TencentMap.OnMarkerDragListener getOnDragListener() {
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public MarkerOptions getOptions() {
        return this.L;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public LatLng getPosition() {
        return this.g0;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable
    public float[] getScale() {
        return new float[]{this.R, this.S};
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public String getSnippet() {
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            return markerOptions.getSnippet();
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public Object getTag() {
        return this.B;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public String getTitle() {
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            return markerOptions.getTitle();
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public int getWidth(Context context) {
        Bitmap bitmap;
        BitmapDescriptor icon = this.L.getIcon();
        if (icon == null || (bitmap = icon.getFormater().getBitmap(context)) == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    @Override // com.tencent.mapsdk.internal.o0
    public boolean h() {
        return R();
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean handleOnTap() {
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void hideInfoWindow() {
        yi yiVar = this.Z;
        if (yiVar == null) {
            return;
        }
        yiVar.a("", true);
        yiVar.getMap().v0();
        synchronized (yiVar.I) {
            r4 r4Var = this.e0;
            if (r4Var == null) {
                return;
            }
            r4Var.e(false);
            this.f0 = false;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable
    public boolean isCollisionBy(Collision collision) {
        Collision[] collisionArr = this.h0;
        if (collisionArr != null) {
            return Util.where(collisionArr, new c(collision));
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public boolean isFastLoad() {
        ig igVar = this.a0;
        if (igVar == null) {
            return false;
        }
        return igVar.isFastLoad();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public boolean isInMapCenterState() {
        return this.T;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    @Deprecated
    public boolean isInfoWindowAutoOverturn() {
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public boolean isInfoWindowEnable() {
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            return markerOptions.isInfoWindowEnable();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public boolean isInfoWindowShown() {
        r4 r4Var;
        if (this.Z == null || this.L == null || (r4Var = this.e0) == null) {
            return false;
        }
        return r4Var.r();
    }

    @Override // com.tencent.mapsdk.internal.o0
    public r4 j() {
        return this.e0;
    }

    @Override // com.tencent.mapsdk.internal.o0
    public TencentMap.OnMarkerClickListener m() {
        return this.d0;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.q4
    public void n() {
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean onTap(float f, float f2) {
        ig igVar;
        TencentMap.OnMarkerClickListener onMarkerClickListener;
        if (this.Z == null || !isClickable() || (igVar = this.a0) == null) {
            return false;
        }
        boolean onTap = igVar.onTap(f, f2);
        if (onTap && (onMarkerClickListener = this.d0) != null) {
            onMarkerClickListener.onMarkerClick(this);
        }
        return onTap;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    @Deprecated
    public boolean onTapMapViewBubbleHidden() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.q4
    public boolean q() {
        Object obj = this.B;
        return obj != null && mf.j.equals(obj.toString());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void refreshInfoWindow() {
        r4 r4Var;
        if (isInfoWindowEnable() && (r4Var = this.e0) != null && r4Var.r()) {
            this.e0.u();
        }
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public void releaseData() {
        r4 r4Var = this.e0;
        if (r4Var != null) {
            r4Var.remove();
            this.e0 = null;
        }
        ig igVar = this.a0;
        if (igVar != null) {
            igVar.a0();
        }
    }

    @Override // com.tencent.mapsdk.internal.o0
    public Point s() {
        return new Point(this.V, this.W);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Alphable
    public void setAlpha(float f) {
        this.Q = f;
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.alpha(f);
        }
        ig igVar = this.a0;
        if (igVar != null) {
            igVar.setAlpha(f);
        }
        B();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Anchorable
    public void setAnchor(float f, float f2) {
        float f3;
        float f4;
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.anchor(f, f2);
        }
        if (f > 1.0f) {
            f3 = 1.0f;
        } else {
            f3 = f;
            if (f < 0.0f) {
                f3 = 0.0f;
            }
        }
        if (f2 > 1.0f) {
            f4 = 1.0f;
        } else {
            f4 = f2;
            if (f2 < 0.0f) {
                f4 = 0.0f;
            }
        }
        this.F = f3;
        this.G = f4;
        ig igVar = this.a0;
        if (igVar != null) {
            igVar.setAnchor(f3, f4);
        }
        r4 r4Var = this.e0;
        if (r4Var != null) {
            r4Var.setAnchor(this.F, this.G);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public void setAnimation(Animation animation) {
        j7 a2;
        yi yiVar = this.Z;
        if (yiVar == null || (a2 = i8.a(yiVar.getMapContext(), animation)) == null) {
            return;
        }
        b(a2.f23872a);
    }

    @Override // com.tencent.mapsdk.internal.o0
    public void setAnimationListener(AnimationListener animationListener) {
        this.b0 = animationListener;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable
    public void setCollisions(Collision... collisionArr) {
        this.h0 = collisionArr;
        ig igVar = this.a0;
        if (igVar == null) {
            return;
        }
        igVar.g(isCollisionBy(MarkerCollisionItem.POI));
        igVar.f(false);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Accessible
    public void setContentDescription(String str) {
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.contentDescription(str);
        }
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.tencentmap.mapsdk.maps.interfaces.Draggable
    public void setDraggable(boolean z) {
        super.setDraggable(z);
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.draggable(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable
    public void setEqualScale(float f) {
        a(f, f);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void setFastLoad(boolean z) {
        ig igVar = this.a0;
        if (igVar == null) {
            return;
        }
        igVar.setFastLoad(z);
        B();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void setFixingPoint(int i, int i2) {
        this.V = i;
        this.W = i2;
        if (this.a0 != null) {
            setFixingPointEnable(true);
            this.a0.a(new GeoPoint(this.W, this.V));
        }
        r4 r4Var = this.e0;
        if (r4Var != null) {
            r4Var.setFixingPoint(i, i2);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void setFixingPointEnable(boolean z) {
        this.U = z;
        ig igVar = this.a0;
        if (igVar != null) {
            igVar.h(z);
        }
        r4 r4Var = this.e0;
        if (r4Var != null) {
            if (z) {
                r4Var.setFixingPoint(this.V, this.W);
            } else {
                r4Var.setFixingPointEnable(false);
            }
        }
        B();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        yi yiVar = this.Z;
        if (yiVar == null) {
            return;
        }
        a(bitmapDescriptor, BitmapDescriptorFactory.defaultMarker(yiVar.getMapContext()));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void setIconLooper(BitmapDescriptor bitmapDescriptor, boolean z, int i) {
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.icon(bitmapDescriptor);
            this.L.iconLooper(z, i);
        }
        boolean isIconLooperEnable = this.L.isIconLooperEnable();
        int activeSize = this.L.getIcon().getFormater().activeSize();
        na.a(ma.f23952c, "iconLooper totalSize:" + activeSize);
        if (activeSize > 1) {
            this.i0 = -1;
            p7 p7Var = new p7();
            p7Var.a(this.L.getIconLooperDuration());
            p7Var.a(new b());
            this.a0.a(p7Var);
            p7Var.a(isIconLooperEnable);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void setInMapCenterState(boolean z) {
        a(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void setInfoWindowAnchor(float f, float f2) {
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.infoWindowAnchor(f, f2);
        }
        r4 r4Var = this.e0;
        if (r4Var != null) {
            r4Var.u();
        }
        B();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void setInfoWindowEnable(boolean z) {
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.infoWindowEnable(z);
        }
        r4 r4Var = this.e0;
        if (r4Var == null || !r4Var.r()) {
            return;
        }
        this.e0.e(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void setInfoWindowOffset(int i, int i2) {
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.infoWindowOffset(i, i2);
        }
        r4 r4Var = this.e0;
        if (r4Var != null) {
            r4Var.u();
        }
        B();
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setLevel(int i) {
        super.setLevel(i);
        ig igVar = this.a0;
        if (igVar != null) {
            igVar.setLevel(i);
        }
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.level(i);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void setMarkerOptions(MarkerOptions markerOptions) {
        if (this.Z == null || markerOptions == null) {
            return;
        }
        this.L = markerOptions;
        D();
        setTitle(markerOptions.getTitle());
        setDraggable(markerOptions.isDraggable());
        setPosition(markerOptions.getPosition());
        setSnippet(markerOptions.getSnippet());
        setAnchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        setVisible(markerOptions.isVisible());
        setRotation(markerOptions.getRotation());
        setIcon(markerOptions.getIcon());
        setAlpha(markerOptions.getAlpha());
        setZIndex(markerOptions.getZIndex());
        setLevel(markerOptions.getLevel());
        a(markerOptions.getIndoorInfo());
        setTag(markerOptions.getTag());
        setCollisions(markerOptions.getCollisions());
        b(getOptions());
        I();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    @Deprecated
    public void setOnTapMapViewBubbleHidden(boolean z) {
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void setPosition(LatLng latLng) {
        this.g0 = latLng;
        if (latLng != null) {
            a(GeoPoint.from(latLng));
        }
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.position(latLng);
        }
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.tencentmap.mapsdk.maps.interfaces.Rotatable
    public void setRotation(float f) {
        super.setRotation(f);
        ig igVar = this.a0;
        if (igVar != null) {
            igVar.b((int) getRotation());
        }
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.rotation(f);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Scalable
    public void setScale(float f, float f2) {
        a(f, f2);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void setSnippet(String str) {
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.snippet(str);
        }
        r4 r4Var = this.e0;
        if (r4Var != null) {
            r4Var.u();
        }
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public void setTag(Object obj) {
        this.B = obj;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void setTitle(String str) {
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.title(str);
        }
        r4 r4Var = this.e0;
        if (r4Var != null) {
            r4Var.u();
        }
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public void setVisible(boolean z) {
        super.setVisible(z);
        ig igVar = this.a0;
        if (igVar != null) {
            igVar.setVisible(z);
        }
        yi yiVar = this.Z;
        if (yiVar == null || yiVar.getMap() == null) {
            return;
        }
        this.Z.getMap().v0();
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public void setZIndex(float f) {
        this.m = f;
        MarkerOptions markerOptions = this.L;
        if (markerOptions != null) {
            markerOptions.zIndex(f);
        }
        ig igVar = this.a0;
        if (igVar != null) {
            igVar.setZIndex((int) f);
        }
        B();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Marker
    public void showInfoWindow() {
        yi yiVar = this.Z;
        MarkerOptions markerOptions = this.L;
        if (yiVar == null || markerOptions == null) {
            return;
        }
        synchronized (yiVar.I) {
            if (!yiVar.d1) {
                for (Marker marker : yiVar.A().Z().e()) {
                    if (marker != null && marker.isInfoWindowShown()) {
                        marker.hideInfoWindow();
                    }
                }
            }
            r4 r4Var = this.e0;
            if (r4Var != null) {
                r4Var.u();
            } else if (markerOptions.isViewInfowindow()) {
                this.e0 = new ef(yiVar, this);
            } else {
                this.e0 = new af(yiVar, this);
            }
            if (this.U) {
                this.e0.setFixingPoint(this.V, this.W);
            }
            if (J()) {
                this.e0.e(true);
                this.f0 = true;
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public void startAnimation(Animation animation) {
        setAnimation(animation);
        startAnimation();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public boolean startAnimation() {
        yi yiVar = this.Z;
        if (yiVar == null || this.c0 == null) {
            return false;
        }
        GeoPoint geoPoint = this.N;
        GeoPoint geoPoint2 = geoPoint;
        if (this.U) {
            geoPoint2 = geoPoint;
            if (yiVar.getMap() != null) {
                geoPoint2 = this.Z.getMap().getProjection().a(new p5(this.V, this.W));
                this.Y = new GeoPoint(geoPoint2);
            }
        }
        return this.c0.a(geoPoint2, this.P);
    }

    @Override // com.tencent.mapsdk.internal.o0
    public TencentMap.InfoWindowAdapter t() {
        yi yiVar = this.Z;
        if (yiVar != null) {
            return yiVar.W();
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.o0
    public List<LatLng> v() {
        VectorMap map;
        Rect bound;
        yi yiVar = this.Z;
        if (yiVar == null || (map = yiVar.getMap()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Rect M = M();
        if (M != null) {
            LatLng latLng = new LatLng(M.top / 1000000.0d, M.left / 1000000.0d);
            LatLng latLng2 = new LatLng(M.bottom / 1000000.0d, M.left / 1000000.0d);
            LatLng latLng3 = new LatLng(M.top / 1000000.0d, M.right / 1000000.0d);
            LatLng latLng4 = new LatLng(M.bottom / 1000000.0d, M.right / 1000000.0d);
            arrayList.add(latLng);
            arrayList.add(latLng2);
            arrayList.add(latLng3);
            arrayList.add(latLng4);
        }
        r4 r4Var = this.e0;
        if (r4Var != null && r4Var.r() && (bound = r4Var.getBound(map.getProjection())) != null) {
            LatLng latLng5 = new LatLng(bound.top / 1000000.0d, bound.left / 1000000.0d);
            LatLng latLng6 = new LatLng(bound.bottom / 1000000.0d, bound.left / 1000000.0d);
            LatLng latLng7 = new LatLng(bound.top / 1000000.0d, bound.right / 1000000.0d);
            LatLng latLng8 = new LatLng(bound.bottom / 1000000.0d, bound.right / 1000000.0d);
            arrayList.add(latLng5);
            arrayList.add(latLng6);
            arrayList.add(latLng7);
            arrayList.add(latLng8);
        }
        return arrayList;
    }
}
