package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.map.lib.models.AggregationOverlayInfo;
import com.tencent.map.lib.models.AnnocationText;
import com.tencent.map.lib.models.AnnocationTextResult;
import com.tencent.map.lib.models.ArcLineOverlayInfo;
import com.tencent.map.lib.models.CircleInfo;
import com.tencent.map.lib.models.CityTrafficInfo;
import com.tencent.map.lib.models.DataSource;
import com.tencent.map.lib.models.GLModelInfo;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.GroundOverlayInfo;
import com.tencent.map.lib.models.HeatmapInfo;
import com.tencent.map.lib.models.IndoorCellInfo;
import com.tencent.map.lib.models.IntersectionOverlayInfo;
import com.tencent.map.lib.models.MapTileID;
import com.tencent.map.lib.models.MarkerInfo;
import com.tencent.map.lib.models.MaskLayer;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.lib.models.ScatterPlotInfo;
import com.tencent.map.lib.models.TrailOverlayInfo;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.engine.jni.JNI;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.gg;
import com.tencent.mapsdk.internal.rc;
import com.tencent.mapsdk.shell.events.EngineWriteDataModel;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri.class */
public class ri implements ee, ge, he, le, ne, pe, qe, com.tencent.mapsdk.internal.t1, com.tencent.mapsdk.internal.v1 {
    private static final int A = -11635864;
    private static final int B = -16777063;
    private static final int C = -16777063;
    public static final int D = 0;
    public static final int E = -1;
    public static final int F = -9;
    private static boolean G = false;
    private static final int t = 256;
    private static final int u = -14803236;
    private static final int v = -13752731;
    private static final int w = -15611905;
    private static final int x = -14650226;
    private static final int y = -11088785;
    private static final int z = -9906011;
    private JNI g;
    private volatile long h;
    private ce i;
    public kb j;
    private final jb k;
    private le l;
    private rc m;
    private long n;
    private long o;
    private float p;
    private String q;
    private final Object r;
    private final ReentrantLock s;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$a.class */
    public class a implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24064a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24065c;
        public final /* synthetic */ int d;

        public a(int i, int i2, int i3, int i4) {
            this.f24064a = i;
            this.b = i2;
            this.f24065c = i3;
            this.d = i4;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetViewport(ri.this.h, this.f24064a, this.b, this.f24065c, this.d);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$a0.class */
    public class a0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24066a;

        public a0(String str) {
            this.f24066a = str;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeMapLoadKMLFile(ri.this.h, this.f24066a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$a1.class */
    public class a1 implements CallbackRunnable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f24067a;

        public a1(long j) {
            this.f24067a = j;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            if (ri.this.h == 0) {
                return 0;
            }
            return Integer.valueOf(ri.this.g.nativeGetEngineId(this.f24067a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$a2.class */
    public class a2 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f24068a;

        public a2(List list) {
            this.f24068a = list;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeSetIndoorCellInfo(ri.this.h, this.f24068a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$a3.class */
    public class a3 implements CallbackRunnable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ gg f24069a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f24070c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ int[] e;
        public final /* synthetic */ int[] f;

        public a3(gg ggVar, int i, boolean z, boolean z2, int[] iArr, int[] iArr2) {
            this.f24069a = ggVar;
            this.b = i;
            this.f24070c = z;
            this.d = z2;
            this.e = iArr;
            this.f = iArr2;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            return Integer.valueOf(ri.this.g.nativeCreateOrUpdateLine(ri.this.h, this.f24069a.R(), this.f24069a.W(), this.f24069a.X(), (GeoPoint[]) this.f24069a.S().toArray(new GeoPoint[0]), this.f24069a.Z(), this.f24069a.getWidth(), this.b, this.f24070c, this.d, this.f24069a.g0(), this.f24069a.isGradientEnable(), this.f24069a.getZIndex(), this.f24069a.d0(), this.f24069a.L(), this.e, this.f24069a.M(), this.f, this.f24069a.getAlpha(), this.f24069a.getLevel(), this.f24069a.isVisible()));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$a4.class */
    public class a4 implements rc.b {
        public a4() {
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeUnlockEngine(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$a5.class */
    public class a5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24072a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f24073c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public a5(String str, String str2, String str3, String str4, String str5) {
            this.f24072a = str;
            this.b = str2;
            this.f24073c = str3;
            this.d = str4;
            this.e = str5;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetLocationCompassGroupImages(ri.this.h, this.f24072a, this.b, this.f24073c, this.d, this.e);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$b.class */
    public class b implements rc.b {
        public b() {
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 == ri.this.h) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (ri.this.n == 0) {
                ri.this.g.nativeUpdateFrame(ri.this.h, 0.0d);
            } else {
                ri.this.g.nativeUpdateFrame(ri.this.h, currentTimeMillis - ri.this.n);
            }
            ri.this.n = currentTimeMillis;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$b0.class */
    public class b0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24075a;

        public b0(int i) {
            this.f24075a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeSetLanguage(ri.this.h, this.f24075a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$b1.class */
    public class b1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f24076a;
        public final /* synthetic */ MarkerInfo b;

        public b1(long j, MarkerInfo markerInfo) {
            this.f24076a = j;
            this.b = markerInfo;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeUpdateMarker(this.f24076a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$b2.class */
    public class b2 implements rc.b {
        public b2() {
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeResetIndoorCellInfo(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$b3.class */
    public class b3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ gg f24079a;

        public b3(gg ggVar) {
            this.f24079a = ggVar;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            int R;
            if (ri.this.h == 0 || (R = this.f24079a.R()) == -1) {
                return;
            }
            ri.this.g.nativeSetLineSelected(ri.this.h, R, this.f24079a.isSelected());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$b4.class */
    public class b4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24080a;
        public final /* synthetic */ int b;

        public b4(int i, int i2) {
            this.f24080a = i;
            this.b = i2;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetCompassPosition(ri.this.h, this.f24080a, this.b);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$b5.class */
    public class b5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24082a;

        public b5(boolean z) {
            this.f24082a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetLocationCompassMarkerHidden(ri.this.h, this.f24082a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$c.class */
    public class c implements CallbackRunnable<Boolean> {
        public c() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Boolean run() {
            return 0 == ri.this.h ? Boolean.FALSE : Boolean.valueOf(ri.this.g.nativeNeedDispaly(ri.this.h));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$c0.class */
    public class c0 implements CallbackRunnable<Integer> {
        public c0() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            if (ri.this.h == 0) {
                return 0;
            }
            return Integer.valueOf(ri.this.g.nativeGetLanguage(ri.this.h));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$c1.class */
    public class c1 implements CallbackRunnable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PolygonInfo f24085a;

        public c1(PolygonInfo polygonInfo) {
            this.f24085a = polygonInfo;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            if (ri.this.h == 0) {
                return 0;
            }
            return Integer.valueOf(ri.this.g.nativeAddPolygon(ri.this.h, this.f24085a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$c2.class */
    public class c2 implements CallbackRunnable<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ rc.b f24086a;

        public c2(rc.b bVar) {
            this.f24086a = bVar;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public Object run() {
            this.f24086a.a(null);
            return null;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$c3.class */
    public class c3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24087a;
        public final /* synthetic */ boolean b;

        public c3(int i, boolean z) {
            this.f24087a = i;
            this.b = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (this.f24087a == -1) {
                return;
            }
            ri.this.g.nativeDeleteLine(ri.this.h, this.f24087a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$c4.class */
    public class c4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24089a;

        public c4(String str) {
            this.f24089a = str;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetCompassImage(ri.this.h, this.f24089a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$c5.class */
    public class c5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24090a;

        public c5(boolean z) {
            this.f24090a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetLocationRedLineHidden(ri.this.h, this.f24090a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$d.class */
    public class d implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24091a;

        public d(boolean z) {
            this.f24091a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 == ri.this.h) {
                return;
            }
            ri.this.g.nativeSetNeedDisplay(ri.this.h, this.f24091a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$d0.class */
    public class d0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24092a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f24093c;

        public d0(String str, String str2, String str3) {
            this.f24092a = str;
            this.b = str2;
            this.f24093c = str3;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeResetEnginePath(ri.this.h, this.f24092a, this.b, this.f24093c);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$d1.class */
    public class d1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24094a;
        public final /* synthetic */ int b;

        public d1(int i, int i2) {
            this.f24094a = i;
            this.b = i2;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeSetMarkerMainSubRelation(ri.this.h, this.f24094a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$d2.class */
    public class d2 implements CallbackRunnable<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ rc.b f24096a;

        public d2(rc.b bVar) {
            this.f24096a = bVar;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        public Object run() {
            this.f24096a.a(null);
            return null;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$d3.class */
    public class d3 implements CallbackRunnable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24097a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f24098c;

        public d3(int i, float f, float f2) {
            this.f24097a = i;
            this.b = f;
            this.f24098c = f2;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Boolean run() {
            return Boolean.valueOf(ri.this.g.nativeOnTapLine(this.f24097a, this.b, this.f24098c));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$d4.class */
    public class d4 implements CallbackRunnable<Double> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f24099a;
        public final /* synthetic */ Rect b;

        public d4(Rect rect, Rect rect2) {
            this.f24099a = rect;
            this.b = rect2;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Double run() {
            return 0 == ri.this.h ? Double.valueOf(1.0d) : Double.valueOf(ri.this.g.nativeGetTargetScale(ri.this.h, this.f24099a, this.b));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$d5.class */
    public class d5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f24101a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LatLng f24102c;

        public d5(float f, int i, LatLng latLng) {
            this.f24101a = f;
            this.b = i;
            this.f24102c = latLng;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetLocationRedLineInfo(ri.this.h, this.f24101a, this.b, this.f24102c);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$e.class */
    public class e implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24103a;

        public e(int i) {
            this.f24103a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 == ri.this.h) {
                return;
            }
            ri.this.g.nativeSetMaxScaleLevel(ri.this.h, this.f24103a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$e0.class */
    public class e0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24104a;

        public e0(boolean z) {
            this.f24104a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSwitchEngineForeGround(ri.this.h, this.f24104a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$e1.class */
    public class e1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24105a;

        public e1(int i) {
            this.f24105a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeSetMapFontSize(ri.this.h, this.f24105a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$e2.class */
    public class e2 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackRunnable f24106a;

        public e2(CallbackRunnable callbackRunnable) {
            this.f24106a = callbackRunnable;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            this.f24106a.run();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$e3.class */
    public class e3 implements CallbackRunnable<Integer> {
        public e3() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            if (ri.this.h == 0) {
                return -1;
            }
            return Integer.valueOf(ri.this.g.nativeClearCache(ri.this.h));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$e4.class */
    public class e4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f24108a;
        public final /* synthetic */ Rect b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f24109c;

        public e4(Rect rect, Rect rect2, boolean z) {
            this.f24108a = rect;
            this.b = rect2;
            this.f24109c = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeZoomToSpan(ri.this.h, this.f24108a, this.b, this.f24109c);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$e5.class */
    public class e5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f24110a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f24111c;

        public e5(float f, float f2, boolean z) {
            this.f24110a = f;
            this.b = f2;
            this.f24111c = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeMoveBy(ri.this.h, this.f24110a, this.b, this.f24111c);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$f.class */
    public class f implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24112a;

        public f(int i) {
            this.f24112a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 == ri.this.h) {
                return;
            }
            ri.this.g.nativeSetMinScaleLevel(ri.this.h, this.f24112a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$f0.class */
    public class f0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ gg f24113a;

        public f0(gg ggVar) {
            this.f24113a = ggVar;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            int R;
            if (ri.this.h == 0 || (R = this.f24113a.R()) == -1 || this.f24113a.Y() < 0.0f) {
                return;
            }
            int O = this.f24113a.O();
            if (O == 3 || O == 0) {
                ri.this.g.nativeSetLineArrowSpacing(ri.this.h, R, this.f24113a.Y());
            } else {
                ri.this.g.nativeSetLineFootPrintSpacing(ri.this.h, R, this.f24113a.Y());
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$f1.class */
    public class f1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f24114a;

        public f1(long j) {
            this.f24114a = j;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeRemoveEngineOverlay(this.f24114a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$f2.class */
    public class f2 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24115a;

        public f2(int i) {
            this.f24115a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            ri.this.g.nativeDeleteCircle(ri.this.h, this.f24115a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$f3.class */
    public class f3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ gg f24116a;

        public f3(gg ggVar) {
            this.f24116a = ggVar;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            gg.a a0;
            int R = this.f24116a.R();
            if (R == -1 || (a0 = this.f24116a.a0()) == null) {
                return;
            }
            ri.this.g.nativeSetTurnArrow(ri.this.h, R, this.f24116a.S(), a0.f23800a, a0.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$f4.class */
    public class f4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24117a;

        public f4(boolean z) {
            this.f24117a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeIndoorBuildingEnabled(ri.this.h, this.f24117a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$f5.class */
    public class f5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GeoPoint f24118a;
        public final /* synthetic */ boolean b;

        public f5(GeoPoint geoPoint, boolean z) {
            this.f24118a = geoPoint;
            this.b = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetCenter(ri.this.h, this.f24118a, this.b);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$g.class */
    public class g implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f24120a;

        public g(float f) {
            this.f24120a = f;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 == ri.this.h) {
                return;
            }
            ri.this.g.nativeSetRotate(ri.this.h, this.f24120a, false);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$g0.class */
    public class g0 implements CallbackRunnable<bh[]> {
        public g0() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public bh[] run() {
            synchronized (ri.this.r) {
                if (ri.this.h == 0) {
                    return null;
                }
                int[] nativeFetchLackedTrafficBlocks = ri.this.g.nativeFetchLackedTrafficBlocks(ri.this.h);
                if (nativeFetchLackedTrafficBlocks == null || nativeFetchLackedTrafficBlocks.length == 0) {
                    return null;
                }
                bh[] bhVarArr = new bh[nativeFetchLackedTrafficBlocks.length / 7];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= nativeFetchLackedTrafficBlocks.length / 7) {
                        return bhVarArr;
                    }
                    bhVarArr[i2] = new bh();
                    bh bhVar = bhVarArr[i2];
                    int i3 = i2 * 7;
                    bhVar.f23638a = nativeFetchLackedTrafficBlocks[i3];
                    bhVarArr[i2].b = nativeFetchLackedTrafficBlocks[i3 + 1];
                    bhVarArr[i2].d = nativeFetchLackedTrafficBlocks[i3 + 2];
                    bhVarArr[i2].f23639c = nativeFetchLackedTrafficBlocks[i3 + 3];
                    bhVarArr[i2].f = nativeFetchLackedTrafficBlocks[i3 + 4];
                    bhVarArr[i2].e = nativeFetchLackedTrafficBlocks[i3 + 5];
                    bhVarArr[i2].g = nativeFetchLackedTrafficBlocks[i3 + 6];
                    i = i2 + 1;
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$g1.class */
    public class g1 implements CallbackRunnable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AggregationOverlayInfo f24122a;

        public g1(AggregationOverlayInfo aggregationOverlayInfo) {
            this.f24122a = aggregationOverlayInfo;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Long run() {
            if (ri.this.h == 0) {
                return 0L;
            }
            return Long.valueOf(ri.this.g.nativeAddAggregatioinOverlay(ri.this.h, this.f24122a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$g2.class */
    public class g2 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PolygonInfo f24123a;

        public g2(PolygonInfo polygonInfo) {
            this.f24123a = polygonInfo;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            JNI jni = ri.this.g;
            long j = ri.this.h;
            PolygonInfo polygonInfo = this.f24123a;
            jni.nativeUpdatePolygon(j, polygonInfo.polygonId, polygonInfo.borderLineId, polygonInfo);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$g3.class */
    public class g3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ gg f24124a;

        public g3(gg ggVar) {
            this.f24124a = ggVar;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            int R = this.f24124a.R();
            if (R == -1) {
                return;
            }
            int[] b0 = this.f24124a.b0();
            ri.this.g.nativeSetTurnArrowStyle(ri.this.h, R, b0[0], b0[1]);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$g4.class */
    public class g4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24125a;

        public g4(boolean z) {
            this.f24125a = z;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$g5.class */
    public class g5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GeoPoint f24126a;

        public g5(GeoPoint geoPoint) {
            this.f24126a = geoPoint;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 == ri.this.h || ri.this.m == null) {
                return;
            }
            ri.this.g.nativeSetCenter(ri.this.h, this.f24126a, false);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$h.class */
    public class h implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f24127a;

        public h(float f) {
            this.f24127a = f;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 == ri.this.h) {
                return;
            }
            ri.this.g.nativeSetSkew(ri.this.h, this.f24127a, false);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$h0.class */
    public class h0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24128a;

        public h0(String str) {
            this.f24128a = str;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetServerHost(ri.this.h, this.f24128a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$h1.class */
    public class h1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f24129a;
        public final /* synthetic */ AggregationOverlayInfo b;

        public h1(long j, AggregationOverlayInfo aggregationOverlayInfo) {
            this.f24129a = j;
            this.b = aggregationOverlayInfo;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeUpdateAggregatioinOverlay(ri.this.h, this.f24129a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$h2.class */
    public class h2 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24131a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f24132c;

        public h2(int i, int i2, boolean z) {
            this.f24131a = i;
            this.b = i2;
            this.f24132c = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0 || this.f24131a < 0 || ri.this.m == null) {
                return;
            }
            ri.this.g.nativeSetPolygonHidden(ri.this.h, this.f24131a, this.b, this.f24132c);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$h3.class */
    public class h3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ gg f24133a;

        public h3(gg ggVar) {
            this.f24133a = ggVar;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            int R = this.f24133a.R();
            if (R == -1) {
                return;
            }
            ri.this.g.nativeSetLineDrawArrow(ri.this.h, R, this.f24133a.c0());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$h4.class */
    public class h4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24134a;

        public h4(int i) {
            this.f24134a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeSetIndoorConfigType(ri.this.h, this.f24134a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$h5.class */
    public class h5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24135a;

        public h5(int i) {
            this.f24135a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            int i = this.f24135a;
            if (i == 1) {
                ri.this.g.nativeSetTrafficColor(ri.this.h, ri.u, ri.w, ri.z, -16777063);
            } else if (i == 2) {
                ri.this.g.nativeSetTrafficColor(ri.this.h, ri.v, ri.x, ri.A, -16777063);
            } else {
                ri.this.g.nativeSetTrafficColor(ri.this.h, ri.u, ri.w, ri.y, -16777063);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$i.class */
    public class i implements CallbackRunnable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TileOverlayCallback f24136a;
        public final /* synthetic */ boolean b;

        public i(TileOverlayCallback tileOverlayCallback, boolean z) {
            this.f24136a = tileOverlayCallback;
            this.b = z;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            if (ri.this.h == 0) {
                return -1;
            }
            return Integer.valueOf(ri.this.g.nativeAddTileOverlay(ri.this.h, this.f24136a, this.b));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$i0.class */
    public class i0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24138a;

        public i0(String str) {
            this.f24138a = str;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeMapSetSatelliteServerFullUrl(ri.this.h, this.f24138a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$i1.class */
    public class i1 implements CallbackRunnable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HeatmapInfo f24139a;

        public i1(HeatmapInfo heatmapInfo) {
            this.f24139a = heatmapInfo;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Long run() {
            if (ri.this.h == 0) {
                return 0L;
            }
            return Long.valueOf(ri.this.g.nativeAddHeatmapOverlay(ri.this.h, this.f24139a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$i2.class */
    public class i2 extends pb {
        public i2() {
        }

        @Override // com.tencent.mapsdk.internal.pb, com.tencent.mapsdk.internal.jb
        public void a(String str, byte[] bArr) {
            synchronized (ri.this.r) {
                if (ri.this.h != 0 && !TextUtils.isEmpty(str)) {
                    EngineWriteDataModel nativeWriteMapDataBlock = ri.this.g.nativeWriteMapDataBlock(ri.this.h, str, bArr);
                    if (nativeWriteMapDataBlock != null && nativeWriteMapDataBlock.resultCode != 0) {
                        com.tencent.mapsdk.internal.u.d().onReport(new ni(nativeWriteMapDataBlock));
                    }
                    ra.a(ma.b, "data-length", bArr != b7.a() ? bArr.length : 0);
                    if (ra.g(ma.b, "req-count") == ra.i(ma.b, "data-count") + ra.g(ma.b, "cancel-count")) {
                        ra.j(ma.b);
                    }
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$i3.class */
    public class i3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ gg f24141a;

        public i3(gg ggVar) {
            this.f24141a = ggVar;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            int R = this.f24141a.R();
            if (R == -1) {
                return;
            }
            ri.this.g.nativeSetLineDirectionArrowTextureName(ri.this.h, R, this.f24141a.N());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$i4.class */
    public class i4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24142a;

        public i4(int i) {
            this.f24142a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 == ri.this.h || ri.this.m == null) {
                return;
            }
            ri.this.g.nativeSetIndoorFloor(ri.this.h, this.f24142a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$i5.class */
    public class i5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GeoPoint f24143a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f24144c;

        public i5(GeoPoint geoPoint, int i, boolean z) {
            this.f24143a = geoPoint;
            this.b = i;
            this.f24144c = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetCenterMapPointAndScaleLevel(ri.this.h, this.f24143a, this.b, this.f24144c);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$j.class */
    public class j implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24145a;
        public final /* synthetic */ int b;

        public j(int i, int i2) {
            this.f24145a = i;
            this.b = i2;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeSetTileOverlayPriority(ri.this.h, this.f24145a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$j0.class */
    public class j0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24147a;

        public j0(boolean z) {
            this.f24147a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeEnablePOI(ri.this.h, this.f24147a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$j1.class */
    public class j1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f24148a;
        public final /* synthetic */ HeatmapInfo b;

        public j1(long j, HeatmapInfo heatmapInfo) {
            this.f24148a = j;
            this.b = heatmapInfo;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeUpdateHeatmapOverlay(ri.this.h, this.f24148a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$j2.class */
    public class j2 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24150a;
        public final /* synthetic */ int b;

        public j2(int i, int i2) {
            this.f24150a = i;
            this.b = i2;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0 || this.f24150a < 0 || ri.this.m == null) {
                return;
            }
            ri.this.g.nativeDeletePolygon(ri.this.h, this.f24150a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$j3.class */
    public class j3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ gg f24152a;

        public j3(gg ggVar) {
            this.f24152a = ggVar;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            int R = this.f24152a.R();
            if (R == -1) {
                return;
            }
            ri.this.g.nativeSetDrawCap(ri.this.h, R, this.f24152a.e0());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$j4.class */
    public class j4 implements CallbackRunnable<Integer> {
        public j4() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            if (0 == ri.this.h) {
                return -1;
            }
            return Integer.valueOf(ri.this.g.nativeGetIndoorCurrentFloorId(ri.this.h));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$j5.class */
    public class j5 implements CallbackRunnable<GeoPoint> {
        public j5() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public GeoPoint run() {
            if (0 == ri.this.h) {
                return null;
            }
            GeoPoint geoPoint = new GeoPoint();
            ri.this.g.nativeGetCenterMapPoint(ri.this.h, geoPoint);
            return geoPoint;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$k.class */
    public class k implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24155a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24156c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        public k(int i, int i2, int i3, int i4, int i5) {
            this.f24155a = i;
            this.b = i2;
            this.f24156c = i3;
            this.d = i4;
            this.e = i5;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeCheckTrafficBlockCache(ri.this.h, this.f24155a, this.b, this.f24156c, this.d, this.e);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$k0.class */
    public class k0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24157a;

        public k0(boolean z) {
            this.f24157a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeEnableBaseMap(ri.this.h, this.f24157a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$k1.class */
    public class k1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f24158a;

        public k1(long j) {
            this.f24158a = j;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeRemoveGLVisualizationOverlay(ri.this.h, this.f24158a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$k2.class */
    public class k2 implements CallbackRunnable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MaskLayer f24159a;

        public k2(MaskLayer maskLayer) {
            this.f24159a = maskLayer;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            if (ri.this.h == 0) {
                return 0;
            }
            return Integer.valueOf(ri.this.g.nativeAddMaskLayer(ri.this.h, this.f24159a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$k3.class */
    public class k3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ gg f24160a;

        public k3(gg ggVar) {
            this.f24160a = ggVar;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            GeoPoint P;
            int R = this.f24160a.R();
            if (R == -1 || (P = this.f24160a.P()) == null) {
                return;
            }
            ri.this.g.nativeLineInsertPoint(ri.this.h, R, P, this.f24160a.Q());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$k4.class */
    public class k4 implements CallbackRunnable<String[]> {
        public k4() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public String[] run() {
            if (0 == ri.this.h) {
                return null;
            }
            return ri.this.g.nativeGetIndoorFloorNames(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$k5.class */
    public class k5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ double f24162a;
        public final /* synthetic */ boolean b;

        public k5(double d, boolean z) {
            this.f24162a = d;
            this.b = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetScale(ri.this.h, this.f24162a, this.b);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$l.class */
    public class l implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24164a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24165c;

        public l(int i, int i2, int i3) {
            this.f24164a = i;
            this.b = i2;
            this.f24165c = i3;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetTileOverlayDataLevelRange(ri.this.h, this.f24164a, this.b, this.f24165c);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$l0.class */
    public class l0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24166a;

        public l0(boolean z) {
            this.f24166a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeEnableBuilding(ri.this.h, this.f24166a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$l1.class */
    public class l1 implements CallbackRunnable<VectorHeatAggregationUnit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f24167a;
        public final /* synthetic */ LatLng b;

        public l1(long j, LatLng latLng) {
            this.f24167a = j;
            this.b = latLng;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public VectorHeatAggregationUnit run() {
            if (ri.this.h == 0) {
                return null;
            }
            return ri.this.g.getAggregationUnit(ri.this.h, this.f24167a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$l2.class */
    public class l2 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24169a;
        public final /* synthetic */ int b;

        public l2(int i, int i2) {
            this.f24169a = i;
            this.b = i2;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeUpdateMaskLayer(ri.this.h, this.f24169a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$l3.class */
    public class l3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ gg f24171a;

        public l3(gg ggVar) {
            this.f24171a = ggVar;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            GeoPoint P;
            int R = this.f24171a.R();
            if (R == -1 || (P = this.f24171a.P()) == null) {
                return;
            }
            ri.this.g.nativeLineClearPoint(ri.this.h, R, P, this.f24171a.Q());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$l4.class */
    public class l4 implements CallbackRunnable<Boolean> {
        public l4() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Boolean run() {
            return ri.this.h == 0 ? Boolean.TRUE : Boolean.valueOf(ri.this.g.nativeIsMapDrawFinished(ri.this.h));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$l5.class */
    public class l5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24173a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24174c;

        public l5(int i, int i2, int i3) {
            this.f24173a = i;
            this.b = i2;
            this.f24174c = i3;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetMarkerScaleLevelRange(ri.this.h, this.f24173a, this.b, this.f24174c);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$m.class */
    public class m implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24175a;

        public m(int i) {
            this.f24175a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeRemoveTileOverlay(ri.this.h, this.f24175a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$m0.class */
    public class m0 implements CallbackRunnable<String> {
        public m0() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public String run() {
            return ri.this.h == 0 ? "" : ri.this.g.nativeGetMapEngineVersion(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$m1.class */
    public class m1 implements CallbackRunnable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArcLineOverlayInfo f24177a;

        public m1(ArcLineOverlayInfo arcLineOverlayInfo) {
            this.f24177a = arcLineOverlayInfo;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Long run() {
            if (ri.this.h == 0) {
                return 0L;
            }
            return Long.valueOf(ri.this.g.nativeAddArcLineOverlay(ri.this.h, this.f24177a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$m2.class */
    public class m2 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24178a;

        public m2(int i) {
            this.f24178a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeRemoveMaskLayer(ri.this.h, this.f24178a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$m3.class */
    public class m3 implements CallbackRunnable<TappedElement> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f24179a;
        public final /* synthetic */ float b;

        public m3(float f, float f2) {
            this.f24179a = f;
            this.b = f2;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public TappedElement run() {
            byte[] nativeOnTap;
            if (ri.this.h == 0 || (nativeOnTap = ri.this.g.nativeOnTap(ri.this.h, this.f24179a, this.b)) == null) {
                return null;
            }
            try {
                return TappedElement.fromBytes(nativeOnTap);
            } catch (Exception e) {
                return null;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$m4.class */
    public class m4 implements CallbackRunnable<dg> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GeoPoint f24181a;

        public m4(GeoPoint geoPoint) {
            this.f24181a = geoPoint;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public dg run() {
            if (0 == ri.this.h) {
                return null;
            }
            return new dg(ri.this.g.nativeGetActiveIndoorBuildingGUID(ri.this.h), ri.this.g.nativeGetCurIndoorName(ri.this.h, this.f24181a), ri.this.g.nativeGetIndoorFloorNames(ri.this.h), ri.this.g.nativeGetIndoorCurrentFloorId(ri.this.h));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$m5.class */
    public class m5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ double f24182a;

        public m5(double d) {
            this.f24182a = d;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 == ri.this.h || ri.this.m == null) {
                return;
            }
            ri.this.g.nativeSetScale(ri.this.h, this.f24182a, false);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$n.class */
    public class n implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24183a;

        public n(int i) {
            this.f24183a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeReloadTileOverlay(ri.this.h, this.f24183a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$n0.class */
    public class n0 implements CallbackRunnable<String> {
        public n0() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public String run() {
            return ri.this.h == 0 ? "" : ri.this.g.nativeGetDataEngineVersion(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$n1.class */
    public class n1 implements CallbackRunnable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CircleInfo f24185a;

        public n1(CircleInfo circleInfo) {
            this.f24185a = circleInfo;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            if (ri.this.h == 0 || this.f24185a == null) {
                return -1;
            }
            return Integer.valueOf(ri.this.g.nativeAddCircle(ri.this.h, this.f24185a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$n2.class */
    public class n2 implements CallbackRunnable<GeoPoint> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f24186a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f24187c;

        public n2(byte[] bArr, float f, float f2) {
            this.f24186a = bArr;
            this.b = f;
            this.f24187c = f2;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public GeoPoint run() {
            if (ri.this.h == 0) {
                return new GeoPoint();
            }
            double[] dArr = new double[2];
            ri.this.g.nativeFromScreenLocation(ri.this.h, this.f24186a, this.b, this.f24187c, dArr);
            return new GeoPoint((int) (dArr[1] * 1000000.0d), (int) (dArr[0] * 1000000.0d));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$n3.class */
    public class n3 implements CallbackRunnable<Boolean> {
        public n3() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Boolean run() {
            return ri.this.h != 0 ? Boolean.valueOf(ri.this.g.nativeNeedRedraw(ri.this.h)) : Boolean.FALSE;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$n4.class */
    public class n4 implements CallbackRunnable<Rect> {
        public n4() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Rect run() {
            if (0 == ri.this.h) {
                return null;
            }
            return ri.this.g.nativeGetIndoorBound(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$n5.class */
    public class n5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24190a;
        public final /* synthetic */ boolean b;

        public n5(int i, boolean z) {
            this.f24190a = i;
            this.b = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetScaleLevel(ri.this.h, this.f24190a, this.b);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$o.class */
    public class o implements CallbackRunnable<Boolean> {
        public o() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Boolean run() {
            return ri.this.h == 0 ? Boolean.FALSE : Boolean.valueOf(ri.this.g.nativeIsTileOverlayEnabled(ri.this.h));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$o0.class */
    public class o0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24193a;
        public final /* synthetic */ String b;

        public o0(String str, String str2) {
            this.f24193a = str;
            this.b = str2;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeSetBuildingToSpecificFloor(ri.this.h, this.f24193a, this.b);
            if (ri.this.l != null) {
                ri.this.l.d();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$o1.class */
    public class o1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f24195a;
        public final /* synthetic */ ArcLineOverlayInfo b;

        public o1(long j, ArcLineOverlayInfo arcLineOverlayInfo) {
            this.f24195a = j;
            this.b = arcLineOverlayInfo;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeUpdateArcLineOverlay(ri.this.h, this.f24195a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$o2.class */
    public class o2 implements CallbackRunnable<PointF> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f24197a;
        public final /* synthetic */ double b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ double f24198c;

        public o2(byte[] bArr, double d, double d2) {
            this.f24197a = bArr;
            this.b = d;
            this.f24198c = d2;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public PointF run() {
            if (ri.this.h == 0) {
                return new PointF();
            }
            float[] fArr = new float[2];
            ri.this.g.nativeToScreenLocation(ri.this.h, this.f24197a, this.b, this.f24198c, fArr);
            return new PointF(fArr[0], fArr[1]);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$o3.class */
    public class o3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24199a;

        public o3(boolean z) {
            this.f24199a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 != ri.this.h) {
                ri.this.g.nativeSetBuilding3DEffect(ri.this.h, this.f24199a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$o4.class */
    public class o4 implements CallbackRunnable<String> {
        public o4() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public String run() {
            if (ri.this.h == 0) {
                return null;
            }
            return ri.this.g.nativeGetActiveIndoorBuildingGUID(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$o5.class */
    public class o5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f24201a;
        public final /* synthetic */ float b;

        public o5(float f, float f2) {
            this.f24201a = f;
            this.b = f2;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeZoomIn(ri.this.h, this.f24201a, this.b);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$p.class */
    public class p implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24203a;

        public p(boolean z) {
            this.f24203a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeSetTileOverlayEnabled(ri.this.h, this.f24203a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$p0.class */
    public class p0 implements CallbackRunnable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24204a;

        public p0(String str) {
            this.f24204a = str;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            if (ri.this.h == 0) {
                return -1;
            }
            return Integer.valueOf(ri.this.g.getIndoorOutlineZoom(ri.this.h, this.f24204a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$p1.class */
    public class p1 implements CallbackRunnable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScatterPlotInfo f24205a;

        public p1(ScatterPlotInfo scatterPlotInfo) {
            this.f24205a = scatterPlotInfo;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Long run() {
            if (ri.this.h == 0) {
                return 0L;
            }
            return Long.valueOf(ri.this.g.nativeAddScatterOverlay(ri.this.h, this.f24205a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$p2.class */
    public class p2 implements CallbackRunnable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24206a;

        public p2(String str) {
            this.f24206a = str;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Boolean run() {
            return ri.this.h == 0 ? Boolean.FALSE : Boolean.valueOf(ri.this.g.nativeHasStreetRoad(ri.this.h, this.f24206a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$p3.class */
    public class p3 implements rc.b {
        public p3() {
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeLockEngine(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$p4.class */
    public class p4 implements CallbackRunnable<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GeoPoint f24208a;

        public p4(GeoPoint geoPoint) {
            this.f24208a = geoPoint;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public String run() {
            if (0 == ri.this.h) {
                return null;
            }
            return ri.this.g.nativeGetCurIndoorName(ri.this.h, this.f24208a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$p5.class */
    public class p5 implements rc.b {
        public p5() {
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeZoomOut(ri.this.h);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$q.class */
    public class q implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.tencent.mapsdk.internal.v f24210a;

        public q(com.tencent.mapsdk.internal.v vVar) {
            this.f24210a = vVar;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            com.tencent.mapsdk.internal.v vVar = this.f24210a;
            if (vVar != null) {
                vVar.z();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$q0.class */
    public class q0 implements CallbackRunnable<String> {
        public q0() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public String run() {
            if (ri.this.h == 0) {
                return null;
            }
            return ri.this.g.getMapEngineRenderStatus(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$q1.class */
    public class q1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f24212a;
        public final /* synthetic */ ScatterPlotInfo b;

        public q1(long j, ScatterPlotInfo scatterPlotInfo) {
            this.f24212a = j;
            this.b = scatterPlotInfo;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeUpdateScatterPlotOverlay(ri.this.h, this.f24212a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$q2.class */
    public class q2 implements rc.b {
        public q2() {
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeShowStreetRoad(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$q3.class */
    public class q3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f24215a;

        public q3(List list) {
            this.f24215a = list;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 != ri.this.h) {
                if (this.f24215a == null) {
                    ri.this.g.nativeSetBuildingBlackList(ri.this.h, null);
                } else {
                    ri.this.g.nativeSetBuildingBlackList(ri.this.h, (LatLngBounds[]) this.f24215a.toArray(new LatLngBounds[0]));
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$q4.class */
    public class q4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24216a;

        public q4(int i) {
            this.f24216a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetIndoorMaskColor(ri.this.h, this.f24216a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$q5.class */
    public class q5 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RectF f24217a;
        public final /* synthetic */ GeoPoint b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24218c;
        public final /* synthetic */ int d;
        public final /* synthetic */ boolean e;

        public q5(RectF rectF, GeoPoint geoPoint, int i, int i2, boolean z) {
            this.f24217a = rectF;
            this.b = geoPoint;
            this.f24218c = i;
            this.d = i2;
            this.e = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                JNI jni = ri.this.g;
                long j = ri.this.h;
                RectF rectF = this.f24217a;
                jni.nativeSetFlagOfZoomToSpanForLocation(j, rectF.top, rectF.left, rectF.bottom, rectF.right);
                ri.this.g.nativeZoomToSpanForNavigation(ri.this.h, this.b, this.f24218c, this.d, this.e);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$r.class */
    public class r implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24219a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24220c;
        public final /* synthetic */ int d;

        public r(int i, int i2, int i3, int i4) {
            this.f24219a = i;
            this.b = i2;
            this.f24220c = i3;
            this.d = i4;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeSetTrafficColor(ri.this.h, this.f24219a, this.b, this.f24220c, this.d);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$r0.class */
    public class r0 implements CallbackRunnable<CityTrafficInfo> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24221a;

        public r0(String str) {
            this.f24221a = str;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public CityTrafficInfo run() {
            if (ri.this.h == 0) {
                return null;
            }
            CityTrafficInfo cityTrafficInfo = new CityTrafficInfo();
            ri.this.g.nativeGetTrafficCityInfo(ri.this.h, this.f24221a, cityTrafficInfo);
            return cityTrafficInfo;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$r1.class */
    public class r1 implements CallbackRunnable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TrailOverlayInfo f24222a;

        public r1(TrailOverlayInfo trailOverlayInfo) {
            this.f24222a = trailOverlayInfo;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Long run() {
            if (ri.this.h == 0) {
                return 0L;
            }
            return Long.valueOf(ri.this.g.nativeAddTrailOverlay(ri.this.h, this.f24222a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$r2.class */
    public class r2 implements rc.b {
        public r2() {
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeHideStreetRoad(ri.this.h);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$r3.class */
    public class r3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GeoPoint f24224a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f24225c;
        public final /* synthetic */ boolean d;

        public r3(GeoPoint geoPoint, float f, float f2, boolean z) {
            this.f24224a = geoPoint;
            this.b = f;
            this.f24225c = f2;
            this.d = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetLocationInfo(ri.this.h, this.f24224a.getLatitudeE6() / 1000000.0d, this.f24224a.getLongitudeE6() / 1000000.0d, this.b, this.f24225c, this.d);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$r4.class */
    public class r4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f24226a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f24227c;
        public final /* synthetic */ float d;

        public r4(float f, float f2, float f3, float f4) {
            this.f24226a = f;
            this.b = f2;
            this.f24227c = f3;
            this.d = f4;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetIndoorActiveScreenArea(ri.this.h, this.f24226a, this.b, this.f24227c, this.d);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$r5.class */
    public class r5 implements CallbackRunnable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24228a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f24229c;

        public r5(boolean z, float f, float f2) {
            this.f24228a = z;
            this.b = f;
            this.f24229c = f2;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Boolean run() {
            if (ri.this.h == 0) {
                return Boolean.FALSE;
            }
            if (this.f24228a) {
                ri.this.g.nativeSetScreenCenterOffset(ri.this.h, this.b, this.f24229c, true);
            } else {
                com.tencent.mapsdk.internal.t4 projection = ri.this.m.getProjection();
                com.tencent.mapsdk.internal.p5 a2 = projection.a(ri.this.n());
                ri.this.g.nativeSetScreenCenterOffset(ri.this.h, this.b, this.f24229c, false);
                com.tencent.mapsdk.internal.p5 a3 = projection.a(ri.this.n());
                double d = a3.b;
                double d2 = a2.b;
                double d3 = a3.f23992c;
                ri.this.g.nativeSetCenter(ri.this.h, projection.a(new com.tencent.mapsdk.internal.p5(d + (d - d2), d3 + (d3 - a2.f23992c))), false);
            }
            return Boolean.TRUE;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$s.class */
    public class s implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24230a;
        public final /* synthetic */ int b;

        public s(int i, int i2) {
            this.f24230a = i;
            this.b = i2;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeBringElementAbove(ri.this.h, this.f24230a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$s0.class */
    public class s0 implements CallbackRunnable<ArrayList<MapPoi>> {
        public s0() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public ArrayList<MapPoi> run() {
            if (ri.this.h == 0) {
                return null;
            }
            return ri.this.g.nativeGetPoisInScreen(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$s1.class */
    public class s1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f24233a;
        public final /* synthetic */ TrailOverlayInfo b;

        public s1(long j, TrailOverlayInfo trailOverlayInfo) {
            this.f24233a = j;
            this.b = trailOverlayInfo;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeUpdateTrailOverlay(ri.this.h, this.f24233a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$s2.class */
    public class s2 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24235a;

        public s2(boolean z) {
            this.f24235a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeSetSatelliteEnabled(ri.this.h, this.f24235a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$s3.class */
    public class s3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24236a;
        public final /* synthetic */ boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f24237c;
        public final /* synthetic */ boolean d;

        public s3(boolean z, boolean z2, boolean z3, boolean z4) {
            this.f24236a = z;
            this.b = z2;
            this.f24237c = z3;
            this.d = z4;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetLocationFollow(ri.this.h, this.f24236a, this.b, this.f24237c, this.d);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$s4.class */
    public class s4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24238a;

        public s4(boolean z) {
            this.f24238a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetIndoorBuildingPickEnabled(ri.this.h, this.f24238a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$s5.class */
    public class s5 implements CallbackRunnable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f24239a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f24240c;
        public final /* synthetic */ boolean d;

        public s5(byte[] bArr, int i, boolean z, boolean z2) {
            this.f24239a = bArr;
            this.b = i;
            this.f24240c = z;
            this.d = z2;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            synchronized (ri.this.r) {
                if (ri.this.h == 0) {
                    return -1;
                }
                return Integer.valueOf(ri.this.g.nativeRefreshTrafficData(ri.this.h, this.f24239a, this.b, this.f24240c, this.d));
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$t.class */
    public class t implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24241a;
        public final /* synthetic */ int b;

        public t(int i, int i2) {
            this.f24241a = i;
            this.b = i2;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeBringElementBelow(ri.this.h, this.f24241a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$t0.class */
    public class t0 implements CallbackRunnable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24243a;

        public t0(int i) {
            this.f24243a = i;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Boolean run() {
            return ri.this.h == 0 ? Boolean.FALSE : Boolean.valueOf(ri.this.g.checkMapLoadFinishedTask(ri.this.h, this.f24243a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$t1.class */
    public class t1 implements CallbackRunnable<Boolean> {
        public t1() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Boolean run() {
            return ri.this.h == 0 ? Boolean.FALSE : Boolean.valueOf(ri.this.g.nativeGetAndResetDirty(ri.this.h));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$t2.class */
    public class t2 implements CallbackRunnable<Boolean> {
        public t2() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Boolean run() {
            return Boolean.valueOf(ri.this.g.nativeDrawFrame(ri.this.h));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$t3.class */
    public class t3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f24246a;

        public t3(float f) {
            this.f24246a = f;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetLocationHeading(ri.this.h, this.f24246a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$t4.class */
    public class t4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f24247a;

        public t4(String[] strArr) {
            this.f24247a = strArr;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetShowIndoorBuildingWhiteList(ri.this.h, this.f24247a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$u.class */
    public class u implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24248a;
        public final /* synthetic */ float b;

        public u(int i, float f) {
            this.f24248a = i;
            this.b = f;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeSetPriority(ri.this.h, this.f24248a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$u0.class */
    public class u0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ double[] f24250a;
        public final /* synthetic */ double[] b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24251c;

        public u0(double[] dArr, double[] dArr2, int i) {
            this.f24250a = dArr;
            this.b = dArr2;
            this.f24251c = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.setRestrictBounds(ri.this.h, this.f24250a, this.b, this.f24251c);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$u1.class */
    public class u1 implements CallbackRunnable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroundOverlayInfo f24252a;

        public u1(GroundOverlayInfo groundOverlayInfo) {
            this.f24252a = groundOverlayInfo;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Long run() {
            GroundOverlayInfo groundOverlayInfo;
            if (ri.this.h == 0 || (groundOverlayInfo = this.f24252a) == null || !groundOverlayInfo.checkValid()) {
                return 0L;
            }
            return Long.valueOf(ri.this.g.nativeAddGroundOverlay(ri.this.h, this.f24252a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$u2.class */
    public class u2 implements rc.b {
        public u2() {
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeShowTraffic(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$u3.class */
    public class u3 implements rc.b {
        public u3() {
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeHideCompass(ri.this.h);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$u4.class */
    public class u4 implements CallbackRunnable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24255a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f24256c;

        public u4(String str, float f, float f2) {
            this.f24255a = str;
            this.b = f;
            this.f24256c = f2;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            if (0 == ri.this.h) {
                return 0;
            }
            return Integer.valueOf(ri.this.g.nativeSetLocationMarkerImage(ri.this.h, this.f24255a, this.b, this.f24256c));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$v.class */
    public class v implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24257a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24258c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        public v(int i, int i2, int i3, int i4, int i5) {
            this.f24257a = i;
            this.b = i2;
            this.f24258c = i3;
            this.d = i4;
            this.e = i5;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeCheckTrafficBlockCacheForReplay(ri.this.h, this.f24257a, this.b, this.f24258c, this.d, this.e);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$v0.class */
    public class v0 implements CallbackRunnable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GeoPoint[] f24259a;
        public final /* synthetic */ PolylineOptions.Text b;

        public v0(GeoPoint[] geoPointArr, PolylineOptions.Text text) {
            this.f24259a = geoPointArr;
            this.b = text;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            if (ri.this.h == 0) {
                return -1;
            }
            return Integer.valueOf(ri.this.g.addLineText(ri.this.h, this.f24259a, this.b));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$v1.class */
    public class v1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f24261a;
        public final /* synthetic */ GroundOverlayInfo b;

        public v1(long j, GroundOverlayInfo groundOverlayInfo) {
            this.f24261a = j;
            this.b = groundOverlayInfo;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0 || this.f24261a == 0) {
                return;
            }
            ri.this.g.nativeUpdateGroundOverlay(ri.this.h, this.f24261a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$v2.class */
    public class v2 implements rc.b {
        public v2() {
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeHideTraffic(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$v3.class */
    public class v3 implements CallbackRunnable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ue f24264a;

        public v3(ue ueVar) {
            this.f24264a = ueVar;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            if (0 == ri.this.h) {
                return 0;
            }
            return Integer.valueOf(ri.this.g.nativeAddMarker(ri.this.h, this.f24264a.j(), this.f24264a.n(), this.f24264a.o(), this.f24264a.e(), this.f24264a.f(), this.f24264a.r(), this.f24264a.s(), this.f24264a.d(), this.f24264a.q(), this.f24264a.B(), this.f24264a.A(), this.f24264a.z(), this.f24264a.w(), this.f24264a.v(), this.f24264a.u(), this.f24264a.m()));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$v4.class */
    public class v4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24265a;

        public v4(int i) {
            this.f24265a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetLocationCircleColor(ri.this.h, this.f24265a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$w.class */
    public class w implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f24266a;
        public final /* synthetic */ List b;

        public w(List list, List list2) {
            this.f24266a = list;
            this.b = list2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v16, types: [byte[], byte[][]] */
        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            List list;
            List list2;
            if (0 == ri.this.h || (list = this.f24266a) == null || list.isEmpty() || (list2 = this.b) == null || list2.isEmpty()) {
                return;
            }
            int size = this.f24266a.size();
            ?? r0 = new byte[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    int size2 = this.b.size();
                    ri.this.g.nativeAddRouteNameSegments(ri.this.h, r0, size, (GeoPoint[]) this.b.toArray(new GeoPoint[size2]), size2);
                    return;
                }
                MapRouteSection mapRouteSection = (MapRouteSection) this.f24266a.get(i2);
                if (mapRouteSection != null) {
                    r0[i2] = mapRouteSection.toBytes();
                }
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$w0.class */
    public class w0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24268a;

        public w0(int i) {
            this.f24268a = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.removeLineText(ri.this.h, this.f24268a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$w1.class */
    public class w1 implements CallbackRunnable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IntersectionOverlayInfo f24269a;

        public w1(IntersectionOverlayInfo intersectionOverlayInfo) {
            this.f24269a = intersectionOverlayInfo;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Long run() {
            if (ri.this.h == 0) {
                return 0L;
            }
            return Long.valueOf(ri.this.g.nativeAddIntersectionOverlay(ri.this.h, this.f24269a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$w2.class */
    public class w2 implements CallbackRunnable<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GeoPoint f24270a;

        public w2(GeoPoint geoPoint) {
            this.f24270a = geoPoint;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public String run() {
            byte[] nativeGetCityName;
            if (ri.this.h == 0 || (nativeGetCityName = ri.this.g.nativeGetCityName(ri.this.h, this.f24270a)) == null) {
                return "";
            }
            try {
                return new String(nativeGetCityName, "GBK").trim();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$w3.class */
    public class w3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ue f24271a;

        public w3(ue ueVar) {
            this.f24271a = ueVar;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeUpdateMarkerInfo(ri.this.h, this.f24271a.i(), this.f24271a.j(), this.f24271a.n(), this.f24271a.o(), this.f24271a.e(), this.f24271a.f(), this.f24271a.r(), this.f24271a.s(), this.f24271a.d(), this.f24271a.q(), this.f24271a.B(), this.f24271a.A(), this.f24271a.z(), this.f24271a.w(), this.f24271a.v(), this.f24271a.u(), this.f24271a.m());
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$w4.class */
    public class w4 implements CallbackRunnable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24272a;

        public w4(String str) {
            this.f24272a = str;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            if (ri.this.h == 0) {
                return 0;
            }
            return Integer.valueOf(ri.this.g.nativeIsCityHasTraffic(ri.this.h, this.f24272a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$x.class */
    public class x implements rc.b {
        public x() {
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 == ri.this.h) {
                return;
            }
            ri.this.g.nativeClearRouteNameSegments(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$x0.class */
    public class x0 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24274a;
        public final /* synthetic */ PolylineOptions.Text b;

        public x0(int i, PolylineOptions.Text text) {
            this.f24274a = i;
            this.b = text;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.setLineTextStyle(ri.this.h, this.f24274a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$x1.class */
    public class x1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f24276a;
        public final /* synthetic */ IntersectionOverlayInfo b;

        public x1(long j, IntersectionOverlayInfo intersectionOverlayInfo) {
            this.f24276a = j;
            this.b = intersectionOverlayInfo;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0 || this.f24276a == 0) {
                return;
            }
            ri.this.g.nativeUpdateIntersectionOverlay(this.f24276a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$x2.class */
    public class x2 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24278a;

        public x2(String str) {
            this.f24278a = str;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.nativeUpdateMapResource(ri.this.h, this.f24278a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$x3.class */
    public class x3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int[] f24279a;
        public final /* synthetic */ int b;

        public x3(int[] iArr, int i) {
            this.f24279a = iArr;
            this.b = i;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 == ri.this.h) {
                return;
            }
            ri.this.g.nativeDeleteIcons(ri.this.h, this.f24279a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$x4.class */
    public class x4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24281a;

        public x4(boolean z) {
            this.f24281a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetLocationCircleHidden(ri.this.h, this.f24281a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$y.class */
    public class y implements CallbackRunnable<AnnocationTextResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AnnocationText f24282a;

        public y(AnnocationText annocationText) {
            this.f24282a = annocationText;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public AnnocationTextResult run() {
            if (0 == ri.this.h) {
                return null;
            }
            return ri.this.g.nativeCreateAnnotationTextBitmap(ri.this.h, this.f24282a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$y0.class */
    public class y0 implements CallbackRunnable<String> {
        public y0() {
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public String run() {
            return ri.this.h == 0 ? "" : ri.this.g.nativeGetEngineLogInfo(ri.this.h);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$y1.class */
    public class y1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f24284a;
        public final /* synthetic */ CircleInfo b;

        public y1(int i, CircleInfo circleInfo) {
            this.f24284a = i;
            this.b = circleInfo;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            ri.this.g.nativeUpdateCircle(ri.this.h, this.f24284a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$y2.class */
    public class y2 implements CallbackRunnable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ gg f24286a;

        public y2(gg ggVar) {
            this.f24286a = ggVar;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Integer run() {
            gg ggVar = this.f24286a;
            if (ggVar == null) {
                return -1;
            }
            return ggVar.R() != -1 ? Integer.valueOf(this.f24286a.R()) : Integer.valueOf(ri.this.b(this.f24286a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$y3.class */
    public class y3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int[] f24287a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f24288c;

        public y3(int[] iArr, int i, boolean z) {
            this.f24287a = iArr;
            this.b = i;
            this.f24288c = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (0 == ri.this.h) {
                return;
            }
            ri.this.g.nativeSetIconsHidden(ri.this.h, this.f24287a, this.b, this.f24288c);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$y4.class */
    public class y4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24289a;

        public y4(boolean z) {
            this.f24289a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetLocationMarkerHidden(ri.this.h, this.f24289a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$z.class */
    public class z implements CallbackRunnable<List<Integer>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Rect f24290a;
        public final /* synthetic */ int b;

        public z(Rect rect, int i) {
            this.f24290a = rect;
            this.b = i;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public List<Integer> run() {
            ArrayList arrayList = null;
            if (0 == ri.this.h) {
                return null;
            }
            int[] iArr = new int[100];
            int nativeQueryCityCodeList = ri.this.g.nativeQueryCityCodeList(ri.this.h, this.f24290a, this.b, iArr, 100);
            if (nativeQueryCityCodeList > 0) {
                ArrayList arrayList2 = new ArrayList(nativeQueryCityCodeList);
                int i = 0;
                while (true) {
                    int i2 = i;
                    arrayList = arrayList2;
                    if (i2 >= nativeQueryCityCodeList) {
                        break;
                    }
                    arrayList2.add(Integer.valueOf(iArr[i2]));
                    i = i2 + 1;
                }
            }
            return arrayList;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$z0.class */
    public class z0 implements CallbackRunnable<Long> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MarkerInfo f24292a;

        public z0(MarkerInfo markerInfo) {
            this.f24292a = markerInfo;
        }

        @Override // com.tencent.map.tools.CallbackRunnable
        /* renamed from: a */
        public Long run() {
            if (ri.this.h == 0) {
                return 0L;
            }
            return Long.valueOf(ri.this.g.nativeAddMarker2(ri.this.h, this.f24292a));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$z1.class */
    public class z1 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TrafficStyle f24293a;

        public z1(TrafficStyle trafficStyle) {
            this.f24293a = trafficStyle;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h == 0) {
                return;
            }
            ri.this.g.setTrafficStyle(ri.this.h, this.f24293a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$z2.class */
    public class z2 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ gg f24294a;

        public z2(gg ggVar) {
            this.f24294a = ggVar;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            gg ggVar = this.f24294a;
            if (ggVar == null || ggVar.R() == -1) {
                return;
            }
            ri.this.b(this.f24294a);
            ri.this.k(this.f24294a);
            ri.this.j(this.f24294a);
            ri.this.f(this.f24294a);
            if (this.f24294a.f0()) {
                ri.this.c(this.f24294a);
            } else {
                ri.this.d(this.f24294a);
            }
            ri.this.g(this.f24294a);
            if (!f7.b(this.f24294a.N())) {
                ri.this.e(this.f24294a);
            }
            ri.this.i(this.f24294a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$z3.class */
    public class z3 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f24295a;

        public z3(boolean z) {
            this.f24295a = z;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetCompassVisible(ri.this.h, this.f24295a);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ri$z4.class */
    public class z4 implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24296a;

        public z4(String str) {
            this.f24296a = str;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (ri.this.h != 0) {
                ri.this.g.nativeSetLocationCompassMarkerImage(ri.this.h, this.f24296a);
            }
        }
    }

    public ri(Context context, rc rcVar) {
        i2 i2Var = new i2();
        this.k = i2Var;
        this.n = 0L;
        this.o = 0L;
        this.p = 1.0f;
        this.q = null;
        this.r = new Object();
        this.s = new ReentrantLock();
        this.g = new JNI();
        kb kbVar = new kb();
        this.j = kbVar;
        kbVar.a(i2Var);
        this.m = rcVar;
        this.p = context.getResources().getDisplayMetrics().density;
        if (G) {
            ka.a(context, mi.f23958a);
        }
    }

    public static boolean P() {
        return G;
    }

    private <T> T a(CallbackRunnable<T> callbackRunnable, T t5) {
        if (callbackRunnable != null && this.m != null) {
            if (this.h == 0) {
                return t5;
            }
            this.m.a(new e2(callbackRunnable));
        }
        return t5;
    }

    private void a(rc.b bVar) {
        if (bVar == null || this.m == null || this.h == 0) {
            return;
        }
        c(new c2(bVar), (c2) null);
    }

    private void a(double[] dArr, int i6, double d6, double d7, double d8) {
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= 4) {
                return;
            }
            int i9 = i6 + i8;
            int i10 = i9 + 12;
            dArr[i10] = dArr[i10] + (dArr[i9] * d6) + (dArr[i9 + 4] * d7) + (dArr[i9 + 8] * d8);
            i7 = i8 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int b(com.tencent.mapsdk.internal.gg r12) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.ri.b(com.tencent.mapsdk.internal.gg):int");
    }

    private <T> T b(CallbackRunnable<T> callbackRunnable, T t5) {
        return (callbackRunnable == null || this.m == null) ? t5 : this.h == 0 ? t5 : Thread.currentThread().getName().contains(hj.r) ? (T) e((CallbackRunnable<CallbackRunnable<T>>) callbackRunnable, (CallbackRunnable<T>) t5) : (T) a((CallbackRunnable<CallbackRunnable<T>>) callbackRunnable, (CallbackRunnable<T>) t5);
    }

    private void b(rc.b bVar) {
        if (bVar == null || this.m == null || this.h == 0) {
            return;
        }
        d(new d2(bVar), (d2) null);
    }

    private <T> T c(CallbackRunnable<T> callbackRunnable, T t5) {
        if (callbackRunnable == null || this.m == null) {
            return t5;
        }
        if (this.h == 0) {
            return t5;
        }
        try {
            i();
            return (T) b((CallbackRunnable<CallbackRunnable<T>>) callbackRunnable, (CallbackRunnable<T>) t5);
        } catch (Exception e6) {
            na.b(ma.f, "safeCallEngine", e6);
            return t5;
        } finally {
            j();
        }
    }

    private <T> T d(CallbackRunnable<T> callbackRunnable, T t5) {
        if (callbackRunnable == null || this.m == null) {
            return t5;
        }
        if (this.h == 0) {
            return t5;
        }
        try {
            i();
            return (T) e((CallbackRunnable<CallbackRunnable<T>>) callbackRunnable, (CallbackRunnable<T>) t5);
        } catch (Exception e6) {
            na.b(ma.f, "safeCallSyncEngine", e6);
            return t5;
        } finally {
            j();
        }
    }

    private <T> T e(CallbackRunnable<T> callbackRunnable, T t5) {
        return (callbackRunnable == null || this.m == null) ? t5 : this.h == 0 ? t5 : callbackRunnable.run();
    }

    private void i() {
    }

    private void j() {
    }

    public static void o(boolean z5) {
        G = z5;
    }

    public float A() {
        if (0 == this.h) {
            return 0.0f;
        }
        return this.g.nativeMapSightGetOnScreenHeight(this.h);
    }

    public int B() {
        if (0 == this.h) {
            return 1;
        }
        return this.g.nativeGetMapStyle(this.h);
    }

    public float C() {
        if (0 == this.h) {
            return 0.0f;
        }
        return this.g.nativeGetRotate(this.h);
    }

    public float D() {
        if (0 == this.h) {
            return 1.0f;
        }
        return (float) this.g.nativeGetScale(this.h);
    }

    public int E() {
        if (0 == this.h) {
            return 20;
        }
        return this.g.nativeGetScaleLevel(this.h);
    }

    public float F() {
        if (0 == this.h) {
            return 0.0f;
        }
        return this.g.nativeGetSkew(this.h);
    }

    public float[] G() {
        return this.g.nativeGLProjectMatrix();
    }

    public float[] H() {
        double[] nativeGLViewMatrix = this.g.nativeGLViewMatrix();
        if (nativeGLViewMatrix == null || nativeGLViewMatrix.length == 0) {
            return null;
        }
        PointF b6 = this.m.getProjection().b(fa.d(this.m.S().n()));
        a(nativeGLViewMatrix, 0, b6.x, -b6.y, 0.0d);
        float[] fArr = new float[nativeGLViewMatrix.length];
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= nativeGLViewMatrix.length) {
                return fArr;
            }
            fArr[i7] = new BigDecimal(nativeGLViewMatrix[i7]).floatValue();
            i6 = i7 + 1;
        }
    }

    public float I() {
        return this.g.nativeGLViewScaleRatio();
    }

    public int[] J() {
        return this.g.nativeGLViewport();
    }

    public void K() {
        if (0 == this.h) {
            return;
        }
        a(new u3());
    }

    public void L() {
        a(new r2());
    }

    public void M() {
        a(new v2());
    }

    @Deprecated
    public boolean N() {
        return ((Boolean) d((CallbackRunnable<l4>) new l4(), (l4) Boolean.TRUE)).booleanValue();
    }

    public boolean O() {
        return ((Boolean) d((CallbackRunnable<n3>) new n3(), (n3) Boolean.FALSE)).booleanValue();
    }

    public boolean Q() {
        return ((Boolean) d((CallbackRunnable<o>) new o(), (o) Boolean.FALSE)).booleanValue();
    }

    public boolean R() {
        return ((Boolean) d((CallbackRunnable<c>) new c(), (c) Boolean.FALSE)).booleanValue();
    }

    public boolean S() {
        return ((Boolean) d((CallbackRunnable<t2>) new t2(), (t2) Boolean.FALSE)).booleanValue();
    }

    public void T() {
        this.m.K();
    }

    public void U() {
        a(new b2());
    }

    public void V() {
        a(new q2());
    }

    public void W() {
        a(new u2());
    }

    public void X() {
        a(new b());
    }

    public void Y() {
        rc rcVar;
        if (0 == this.h || (rcVar = this.m) == null) {
            return;
        }
        rcVar.a(new p5());
    }

    public double a(Rect rect, Rect rect2) {
        return ((Double) d((CallbackRunnable<d4>) new d4(rect, rect2), (d4) Double.valueOf(1.0d))).doubleValue();
    }

    public int a(long j6) {
        try {
            i();
            if (this.h == 0) {
                j();
                return 0;
            }
            return this.g.nativeGetGLModelSkeletonAnimationCount(this.h, j6);
        } finally {
            j();
        }
    }

    public int a(TileOverlayCallback tileOverlayCallback, boolean z5) {
        return ((Integer) d((CallbackRunnable<i>) new i(tileOverlayCallback, z5), (i) (-1))).intValue();
    }

    public int a(CircleInfo circleInfo) {
        return ((Integer) d((CallbackRunnable<n1>) new n1(circleInfo), (n1) (-1))).intValue();
    }

    public int a(MaskLayer maskLayer) {
        return ((Integer) d((CallbackRunnable<k2>) new k2(maskLayer), (k2) 0)).intValue();
    }

    public int a(PolygonInfo polygonInfo) {
        return ((Integer) d((CallbackRunnable<c1>) new c1(polygonInfo), (c1) 0)).intValue();
    }

    public int a(gg ggVar) {
        return ((Integer) d((CallbackRunnable<y2>) new y2(ggVar), (y2) (-1))).intValue();
    }

    public int a(ue ueVar) {
        return ((Integer) d((CallbackRunnable<v3>) new v3(ueVar), (v3) 0)).intValue();
    }

    public int a(String str, float f6, float f7) {
        if (0 == this.h) {
            return 0;
        }
        return ((Integer) d((CallbackRunnable<u4>) new u4(str, f6, f7), (u4) 0)).intValue();
    }

    public int a(byte[] bArr, int i6, boolean z5, boolean z6) {
        return ((Integer) d((CallbackRunnable<s5>) new s5(bArr, i6, z5, z6), (s5) (-1))).intValue();
    }

    public int a(GeoPoint[] geoPointArr, PolylineOptions.Text text) {
        return ((Integer) d((CallbackRunnable<v0>) new v0(geoPointArr, text), (v0) (-1))).intValue();
    }

    public long a(AggregationOverlayInfo aggregationOverlayInfo) {
        return ((Long) d((CallbackRunnable<g1>) new g1(aggregationOverlayInfo), (g1) 0L)).longValue();
    }

    public long a(ArcLineOverlayInfo arcLineOverlayInfo) {
        return ((Long) d((CallbackRunnable<m1>) new m1(arcLineOverlayInfo), (m1) 0L)).longValue();
    }

    public long a(GLModelInfo gLModelInfo) {
        try {
            i();
            if (this.h == 0) {
                j();
                return 0L;
            }
            return this.g.nativeAddGLModel(this.h, gLModelInfo);
        } finally {
            j();
        }
    }

    public long a(GroundOverlayInfo groundOverlayInfo) {
        return ((Long) d((CallbackRunnable<u1>) new u1(groundOverlayInfo), (u1) 0L)).longValue();
    }

    public long a(HeatmapInfo heatmapInfo) {
        return ((Long) d((CallbackRunnable<i1>) new i1(heatmapInfo), (i1) 0L)).longValue();
    }

    public long a(IntersectionOverlayInfo intersectionOverlayInfo) {
        return ((Long) d((CallbackRunnable<w1>) new w1(intersectionOverlayInfo), (w1) 0L)).longValue();
    }

    public long a(MarkerInfo markerInfo) {
        return ((Long) d((CallbackRunnable<z0>) new z0(markerInfo), (z0) 0L)).longValue();
    }

    public long a(ScatterPlotInfo scatterPlotInfo) {
        return ((Long) d((CallbackRunnable<p1>) new p1(scatterPlotInfo), (p1) 0L)).longValue();
    }

    public long a(TrailOverlayInfo trailOverlayInfo) {
        return ((Long) d((CallbackRunnable<r1>) new r1(trailOverlayInfo), (r1) 0L)).longValue();
    }

    public PointF a(byte[] bArr, double d6, double d7) {
        return (PointF) e((CallbackRunnable<o2>) new o2(bArr, d6, d7), (o2) new PointF());
    }

    public AnnocationTextResult a(AnnocationText annocationText) {
        return (AnnocationTextResult) d(new y(annocationText), (y) null);
    }

    public GeoPoint a(byte[] bArr, float f6, float f7) {
        return (GeoPoint) e((CallbackRunnable<n2>) new n2(bArr, f6, f7), (n2) new GeoPoint());
    }

    public TappedElement a(float f6, float f7) {
        return (TappedElement) d(new m3(f6, f7), (m3) null);
    }

    public VectorHeatAggregationUnit a(long j6, LatLng latLng) {
        return (VectorHeatAggregationUnit) d(new l1(j6, latLng), (l1) null);
    }

    public String a(GeoPoint geoPoint) {
        return (String) d((CallbackRunnable<w2>) new w2(geoPoint), (w2) "");
    }

    public List<Integer> a(Rect rect, int i6) {
        return (List) d(new z(rect, i6), (z) null);
    }

    @Override // com.tencent.mapsdk.internal.v1
    public void a() {
        b(new p3());
    }

    public void a(double d6) {
        a(new m5(d6));
    }

    public void a(double d6, boolean z5) {
        rc rcVar;
        if (0 == this.h || (rcVar = this.m) == null) {
            return;
        }
        rcVar.a(new k5(d6, z5));
    }

    public void a(float f6) {
        if (0 == this.h || this.m == null) {
            return;
        }
        a(new t3(f6));
    }

    public void a(float f6, float f7, float f8, float f9) {
        if (0 == this.h) {
            return;
        }
        a(new r4(f6, f7, f8, f9));
    }

    @Override // com.tencent.mapsdk.internal.ee
    public void a(float f6, float f7, long j6, String str, String str2) {
        rc rcVar = this.m;
        if (rcVar != null) {
            rcVar.a(f6, f7, j6, str, str2);
        }
    }

    public void a(float f6, float f7, boolean z5) {
        rc rcVar;
        if (0 == this.h || (rcVar = this.m) == null) {
            return;
        }
        rcVar.a(new e5(f6, f7, z5));
    }

    public void a(float f6, int i6, LatLng latLng) {
        if (0 == this.h) {
            return;
        }
        a(new d5(f6, i6, latLng));
    }

    @Override // com.tencent.mapsdk.internal.qe
    public void a(int i6) {
        rc rcVar = this.m;
        if (rcVar != null) {
            a(new q(rcVar.b()));
        }
    }

    public void a(int i6, float f6) {
        a(new u(i6, f6));
    }

    public void a(int i6, int i7) {
        a(new s(i6, i7));
    }

    public void a(int i6, int i7, int i8) {
        if (0 == this.h || this.m == null) {
            return;
        }
        a(new l5(i6, i7, i8));
    }

    public void a(int i6, int i7, int i8, int i9) {
        a(new r(i7, i6, i8, i9));
    }

    public void a(int i6, int i7, int i8, int i9, int i10) {
        b(new k(i6, i7, i8, i9, i10));
    }

    public void a(int i6, int i7, boolean z5) {
        a(new h2(i6, i7, z5));
    }

    public void a(int i6, CircleInfo circleInfo) {
        if (this.h == 0 || circleInfo == null) {
            return;
        }
        a(new y1(i6, circleInfo));
    }

    public void a(int i6, PolylineOptions.Text text) {
        a(new x0(i6, text));
    }

    public void a(int i6, boolean z5) {
        a(new c3(i6, z5));
    }

    public void a(long j6, int i6, float f6, boolean z5) {
        try {
            i();
            if (this.h == 0) {
                return;
            }
            this.g.nativeStartGLModelSkeletonAnimation(this.h, j6, i6, f6, z5);
        } finally {
            j();
        }
    }

    public void a(long j6, AggregationOverlayInfo aggregationOverlayInfo) {
        a(new h1(j6, aggregationOverlayInfo));
    }

    public void a(long j6, ArcLineOverlayInfo arcLineOverlayInfo) {
        a(new o1(j6, arcLineOverlayInfo));
    }

    public void a(long j6, GLModelInfo gLModelInfo) {
        try {
            i();
            if (this.h == 0) {
                return;
            }
            this.g.nativeUpdateGLModel(this.h, j6, gLModelInfo);
        } finally {
            j();
        }
    }

    public void a(long j6, GroundOverlayInfo groundOverlayInfo) {
        a(new v1(j6, groundOverlayInfo));
    }

    public void a(long j6, HeatmapInfo heatmapInfo) {
        a(new j1(j6, heatmapInfo));
    }

    public void a(long j6, IntersectionOverlayInfo intersectionOverlayInfo) {
        a(new x1(j6, intersectionOverlayInfo));
    }

    public void a(long j6, MarkerInfo markerInfo) {
        a(new b1(j6, markerInfo));
    }

    public void a(long j6, ScatterPlotInfo scatterPlotInfo) {
        a(new q1(j6, scatterPlotInfo));
    }

    public void a(long j6, TrailOverlayInfo trailOverlayInfo) {
        a(new s1(j6, trailOverlayInfo));
    }

    public void a(Rect rect, Rect rect2, boolean z5) {
        if (0 == this.h || this.m == null) {
            return;
        }
        a(new e4(rect, rect2, z5));
    }

    public void a(GeoPoint geoPoint, float f6, float f7, boolean z5) {
        if (0 == this.h || this.m == null) {
            return;
        }
        a(new r3(geoPoint, f6, f7, z5));
    }

    public void a(GeoPoint geoPoint, int i6, boolean z5) {
        rc rcVar;
        if (0 == this.h || (rcVar = this.m) == null) {
            return;
        }
        rcVar.a(new i5(geoPoint, i6, z5));
    }

    public void a(GeoPoint geoPoint, RectF rectF, int i6, int i7, boolean z5) {
        rc rcVar;
        if (0 == this.h || (rcVar = this.m) == null) {
            return;
        }
        rcVar.a(new q5(rectF, geoPoint, i6, i7, z5));
    }

    public void a(GeoPoint geoPoint, boolean z5) {
        rc rcVar;
        if (0 == this.h || (rcVar = this.m) == null) {
            return;
        }
        rcVar.a(new f5(geoPoint, z5));
    }

    public void a(ce ceVar) {
        this.i = ceVar;
    }

    public void a(le leVar) {
        this.l = leVar;
    }

    public void a(me meVar) {
        this.g.setMapCallbackGetGLContext(meVar);
    }

    public void a(TrafficStyle trafficStyle) {
        a(new z1(trafficStyle));
    }

    @Override // com.tencent.mapsdk.internal.t1
    public void a(String str) {
        this.q = str;
    }

    @Override // com.tencent.mapsdk.internal.ge
    public void a(String str, hb hbVar) {
        DataSource dataSource = DataSource.get(hbVar.b);
        na.a(ma.b, "onCancelDownload DataSource:" + dataSource + " uri:" + str);
        if (dataSource == DataSource.TILE_OVERLAY) {
            MapTileID mapTileID = (MapTileID) hbVar.d;
            int tileTag = mapTileID.getTileTag();
            na.a(ma.b, "onCancelDownload tileOverlayId:" + tileTag);
            kg a6 = this.m.d0().a(tileTag);
            if (a6 != null) {
                na.c(ma.b, "onCancelDownload found TileOverlay");
                a6.L().a(str);
                ra.i(ma.b, "cancel-count");
                ra.i(ma.b, "C/" + mapTileID.getX() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + mapTileID.getY() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + mapTileID.getZ());
                return;
            }
        }
        this.j.a(str);
    }

    public void a(String str, String str2) {
        a(new o0(str, str2));
    }

    public void a(String str, String str2, String str3) {
        a(new d0(str, str2, str3));
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        if (0 == this.h) {
            return;
        }
        a(new a5(str, str2, str3, str4, str5));
    }

    public void a(List<LatLngBounds> list) {
        a(new q3(list));
    }

    public void a(List<MapRouteSection> list, List<GeoPoint> list2) {
        a(new w(list, list2));
    }

    public void a(boolean z5) {
        a(new k0(z5));
    }

    public void a(boolean z5, boolean z6, boolean z7, boolean z8) {
        if (0 == this.h || this.m == null) {
            return;
        }
        a(new s3(z5, z6, z7, z8));
    }

    public void a(double[] dArr, double[] dArr2, int i6) {
        a(new u0(dArr, dArr2, i6));
    }

    public void a(int[] iArr, int i6) {
        a(new x3(iArr, i6));
    }

    public void a(int[] iArr, int i6, boolean z5) {
        a(new y3(iArr, i6, z5));
    }

    public void a(String[] strArr) {
        if (this.h == 0) {
            return;
        }
        a(new t4(strArr));
    }

    public boolean a(int i6, float f6, float f7) {
        if (i6 == -1) {
            return false;
        }
        return ((Boolean) d((CallbackRunnable<d3>) new d3(i6, f6, f7), (d3) Boolean.FALSE)).booleanValue();
    }

    public boolean a(Context context, be beVar, com.tencent.mapsdk.internal.w wVar, String str, String str2, String str3, float f6) {
        int[] iArr = new int[1];
        try {
            i();
            this.g.initCallback(beVar, wVar, this, this, this, this, this.m.h(), this, this, this, this);
            JNI jni = this.g;
            float d6 = g7.d(context);
            float d7 = g7.d(context);
            Language language = Language.zh;
            this.h = jni.nativeInitEngine(str, str2, str3, d6, 256, d7, iArr, false, 0);
            if (iArr[0] == 0) {
                this.g.nativeSetCenter(this.h, new GeoPoint(39984186, 116307503), false);
                this.g.registerCallback(this.h);
                this.g.nativeSetTrafficColor(this.h, u, w, y, -16777063);
                j();
                return true;
            }
            na.c("init engine fail:" + iArr[0]);
            this.h = 0L;
            j();
            return false;
        } catch (Throwable th) {
            j();
            throw th;
        }
    }

    public CityTrafficInfo b(String str) {
        return (CityTrafficInfo) d(new r0(str), (r0) null);
    }

    public dg b(GeoPoint geoPoint) {
        GeoPoint geoPoint2 = geoPoint;
        if (geoPoint == null) {
            geoPoint2 = new GeoPoint();
        }
        return (dg) d(new m4(geoPoint2), (m4) null);
    }

    @Override // com.tencent.mapsdk.internal.t1
    public String b() {
        return (String) d((CallbackRunnable<y0>) new y0(), (y0) "");
    }

    public void b(float f6) {
        a(new g(f6));
    }

    public void b(float f6, float f7) {
        this.g.scheduleClickOnNextRender(this.h, f6, f7);
    }

    public void b(float f6, float f7, boolean z5) {
        if (0 == this.h || this.m == null) {
            return;
        }
        a((CallbackRunnable<r5>) new r5(z5, f6, f7), (r5) Boolean.FALSE);
    }

    public void b(int i6, int i7) {
        a(new t(i6, i7));
    }

    public void b(int i6, int i7, int i8) {
        if (this.h == 0 || this.m == null) {
            return;
        }
        a(new l(i6, i7, i8));
    }

    public void b(int i6, int i7, int i8, int i9) {
        if (0 == this.h || this.m == null) {
            return;
        }
        a(new a(i6, i7, i8, i9));
    }

    public void b(int i6, int i7, int i8, int i9, int i10) {
        b(new v(i6, i7, i8, i9, i10));
    }

    public void b(int i6, boolean z5) {
        if (0 == this.h) {
            return;
        }
        this.g.nativeSetMapStyle(this.h, i6, z5);
    }

    public void b(PolygonInfo polygonInfo) {
        a(new g2(polygonInfo));
    }

    public void b(ue ueVar) {
        if (0 == this.h) {
            return;
        }
        a(new w3(ueVar));
    }

    @Override // com.tencent.mapsdk.internal.he
    public void b(String str, hb hbVar) {
        DataSource dataSource = DataSource.get(hbVar.b);
        na.a(ma.b, "onRequestDownload DataSource:" + dataSource + " uri:" + str);
        if (dataSource == DataSource.TILE_OVERLAY) {
            MapTileID mapTileID = (MapTileID) hbVar.d;
            int tileTag = mapTileID.getTileTag();
            na.a(ma.b, "onRequestDownload tileOverlayId:" + tileTag);
            kg a6 = this.m.d0().a(tileTag);
            if (a6 != null) {
                na.c(ma.b, "onRequestDownload found TileOverlay");
                kb L = a6.L();
                L.a(this.k);
                L.a(str, a6.K(), hbVar.f23832c);
                ra.i(ma.b, "req-count");
                ra.i(ma.b, "R/" + mapTileID.getX() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + mapTileID.getY() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + mapTileID.getZ());
                return;
            }
        }
        this.j.a(str, this.m.q0());
    }

    public void b(List<IndoorCellInfo> list) {
        a(new a2(list));
    }

    public void b(boolean z5) {
        a(new l0(z5));
    }

    public boolean b(int i6) {
        return ((Boolean) d((CallbackRunnable<t0>) new t0(i6), (t0) Boolean.FALSE)).booleanValue();
    }

    public float[] b(long j6) {
        try {
            i();
            if (this.h == 0) {
                j();
                return new float[0];
            }
            return this.g.nativeGetGLModelSkeletonAnimationDuration(this.h, j6);
        } finally {
            j();
        }
    }

    public int c(String str) {
        return ((Integer) d((CallbackRunnable<p0>) new p0(str), (p0) (-1))).intValue();
    }

    public String c(GeoPoint geoPoint) {
        return (String) d(new p4(geoPoint), (p4) null);
    }

    @Override // com.tencent.mapsdk.internal.v1
    public void c() {
        b(new a4());
    }

    public void c(float f6) {
        a(new h(f6));
    }

    public void c(float f6, float f7) {
        rc rcVar;
        if (0 == this.h || (rcVar = this.m) == null) {
            return;
        }
        rcVar.a(new o5(f6, f7));
    }

    public void c(int i6) {
        if (this.h == 0 || i6 < 0 || this.m == null) {
            return;
        }
        a(new f2(i6));
    }

    public void c(int i6, int i7) {
        a(new j2(i6, i7));
    }

    public void c(int i6, boolean z5) {
        rc rcVar;
        if (0 == this.h || (rcVar = this.m) == null) {
            return;
        }
        rcVar.a(new n5(i6, z5));
    }

    public void c(gg ggVar) {
        if (this.h == 0) {
            return;
        }
        a(new l3(ggVar));
    }

    public void c(boolean z5) {
        a(new j0(z5));
    }

    public String[] c(long j6) {
        try {
            i();
            if (this.h == 0) {
                j();
                return new String[0];
            }
            return this.g.nativeGetGLModelSkeletonAnimationName(this.h, j6);
        } finally {
            j();
        }
    }

    public int d(long j6) {
        return ((Integer) d((CallbackRunnable<a1>) new a1(j6), (a1) 0)).intValue();
    }

    @Override // com.tencent.mapsdk.internal.le
    public void d() {
        le leVar = this.l;
        if (leVar != null) {
            leVar.d();
        }
    }

    public void d(int i6) {
        if (this.h == 0 || this.m == null) {
            return;
        }
        a(new n(i6));
    }

    public void d(int i6, int i7) {
        if (0 == this.h) {
            return;
        }
        a(new b4(i6, i7));
    }

    public void d(GeoPoint geoPoint) {
        this.m.a(new g5(geoPoint));
    }

    public void d(gg ggVar) {
        if (this.h == 0) {
            return;
        }
        a(new k3(ggVar));
    }

    public void d(boolean z5) {
        a(new o3(z5));
    }

    public boolean d(String str) {
        return ((Boolean) d((CallbackRunnable<p2>) new p2(str), (p2) Boolean.FALSE)).booleanValue();
    }

    @Override // com.tencent.mapsdk.internal.v1
    public int e() {
        return ((Integer) d((CallbackRunnable<e3>) new e3(), (e3) (-1))).intValue();
    }

    public int e(String str) {
        return ((Integer) d((CallbackRunnable<w4>) new w4(str), (w4) 0)).intValue();
    }

    public void e(int i6) {
        a(new w0(i6));
    }

    public void e(int i6, int i7) {
        a(new d1(i6, i7));
    }

    public void e(long j6) {
        a(new f1(j6));
    }

    public void e(gg ggVar) {
        if (this.h == 0) {
            return;
        }
        a(new i3(ggVar));
    }

    public void e(boolean z5) {
        if (0 == this.h) {
            return;
        }
        a(new z3(z5));
    }

    @Override // com.tencent.mapsdk.internal.t1
    public String f() {
        String str = this.q;
        this.q = null;
        return str;
    }

    public void f(int i6) {
        a(new m2(i6));
    }

    public void f(int i6, int i7) {
        a(new j(i6, i7));
    }

    public void f(long j6) {
        a(new k1(j6));
    }

    public void f(gg ggVar) {
        if (this.h == 0) {
            return;
        }
        a(new h3(ggVar));
    }

    public void f(String str) {
        a(new a0(str));
    }

    public void f(boolean z5) {
        if (this.h == 0) {
            return;
        }
        a(new s4(z5));
    }

    public void g() {
        a(new x());
    }

    public void g(int i6) {
        if (this.h == 0 || this.m == null) {
            return;
        }
        a(new m(i6));
    }

    public void g(int i6, int i7) {
        a(new l2(i6, i7));
    }

    public void g(long j6) {
        try {
            i();
            if (this.h == 0) {
                return;
            }
            this.g.nativeStopGLModelSkeletonAnimation(this.h, j6);
        } finally {
            j();
        }
    }

    public void g(gg ggVar) {
        if (this.h == 0) {
            return;
        }
        a(new j3(ggVar));
    }

    public void g(String str) {
        a(new x2(str));
    }

    public void g(boolean z5) {
        if (this.h == 0 || this.m == null) {
            return;
        }
        a(new f4(z5));
    }

    public void h() {
        try {
            i();
            kb kbVar = this.j;
            if (kbVar != null) {
                kbVar.b(this.k);
                this.j.a();
            }
            if (this.h != 0) {
                long j6 = this.h;
                synchronized (this.r) {
                    this.h = 0L;
                    this.g.nativeDestroyEngine(j6);
                }
            }
            this.m = null;
            this.g.destory();
        } finally {
            j();
        }
    }

    public void h(int i6) {
        a(new h4(i6));
    }

    public void h(gg ggVar) {
        a(new b3(ggVar));
    }

    public void h(String str) {
        if (0 == this.h) {
            return;
        }
        a(new c4(str));
    }

    public void h(boolean z5) {
        if (0 == this.h || this.m == null) {
            return;
        }
        a(new g4(z5));
    }

    public void i(int i6) {
        a(new i4(i6));
    }

    public void i(gg ggVar) {
        a(new f0(ggVar));
    }

    public void i(String str) {
        if (0 == this.h) {
            return;
        }
        a(new z4(str));
    }

    public void i(boolean z5) {
        if (0 == this.h) {
            return;
        }
        a(new x4(z5));
    }

    public void j(int i6) {
        if (0 == this.h) {
            return;
        }
        a(new q4(i6));
    }

    public void j(gg ggVar) {
        a(new f3(ggVar));
    }

    public void j(String str) {
        if (this.h == 0) {
            return;
        }
        a(new h0(str));
    }

    public void j(boolean z5) {
        if (0 == this.h) {
            return;
        }
        a(new b5(z5));
    }

    public void k(int i6) {
        a(new b0(i6));
    }

    public void k(gg ggVar) {
        if (this.h == 0) {
            return;
        }
        a(new g3(ggVar));
    }

    public void k(String str) {
        if (this.h == 0) {
            return;
        }
        a(new i0(str));
    }

    public void k(boolean z5) {
        if (0 == this.h) {
            return;
        }
        a(new y4(z5));
    }

    public bh[] k() {
        return (bh[]) d(new g0(), (g0) null);
    }

    public void l(int i6) {
        if (0 == this.h) {
            return;
        }
        a(new v4(i6));
    }

    public void l(gg ggVar) {
        a(new z2(ggVar));
    }

    public void l(boolean z5) {
        if (0 == this.h) {
            return;
        }
        a(new c5(z5));
    }

    public boolean l() {
        if (this.h == 0) {
            return false;
        }
        if (System.currentTimeMillis() - this.o > 560) {
            this.g.nativeClearDownloadURLCache(this.h);
            this.o = System.currentTimeMillis();
        }
        return this.g.nativeGenerateTextures(this.h);
    }

    public void m(int i6) {
        a(new e1(i6));
    }

    public void m(boolean z5) {
        a(new d(z5));
    }

    public boolean m() {
        return ((Boolean) d((CallbackRunnable<t1>) new t1(), (t1) Boolean.FALSE)).booleanValue();
    }

    public GeoPoint n() {
        return (GeoPoint) d((CallbackRunnable<j5>) new j5(), (j5) new GeoPoint());
    }

    public void n(int i6) {
        a(new e(i6));
    }

    public void n(boolean z5) {
        a(new s2(z5));
    }

    public Context o() {
        rc rcVar = this.m;
        if (rcVar == null) {
            return null;
        }
        return rcVar.getContext();
    }

    public void o(int i6) {
        a(new f(i6));
    }

    @Override // com.tencent.mapsdk.internal.ne
    public void onMapCameraChangeStopped() {
        rc rcVar = this.m;
        if (rcVar != null) {
            rcVar.r0();
        }
    }

    @Override // com.tencent.mapsdk.internal.ne
    public void onMapCameraChanged() {
        rc rcVar = this.m;
        if (rcVar != null) {
            rcVar.s0();
        }
    }

    @Override // com.tencent.mapsdk.internal.pe
    public void onMapLoaded() {
        rc rcVar = this.m;
        if (rcVar != null) {
            rcVar.t0();
        }
    }

    public String p() {
        return (String) d(new o4(), (o4) null);
    }

    public void p(int i6) {
        a(new h5(i6));
    }

    public void p(boolean z5) {
        a(new p(z5));
    }

    public String q() {
        return (String) d((CallbackRunnable<n0>) new n0(), (n0) "");
    }

    public void q(boolean z5) {
        if (this.h == 0) {
            return;
        }
        a(new e0(z5));
    }

    public Object r() {
        return this.r;
    }

    public long s() {
        return this.h;
    }

    public Rect t() {
        return (Rect) d(new n4(), (n4) null);
    }

    public int u() {
        return ((Integer) d((CallbackRunnable<j4>) new j4(), (j4) (-1))).intValue();
    }

    public String[] v() {
        return (String[]) d(new k4(), (k4) null);
    }

    public int w() {
        return ((Integer) d((CallbackRunnable<c0>) new c0(), (c0) 0)).intValue();
    }

    public String x() {
        return (String) d(new q0(), (q0) null);
    }

    public String y() {
        return (String) d((CallbackRunnable<m0>) new m0(), (m0) "");
    }

    public ArrayList<MapPoi> z() {
        return (ArrayList) d(new s0(), (s0) null);
    }
}
