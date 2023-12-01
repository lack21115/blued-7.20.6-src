package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.amap.api.col.p0003sl.ct;
import com.amap.api.col.p0003sl.ee;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.col.p0003sl.k;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapGridLayer;
import com.amap.api.maps.model.HeatMapGridLayerOptions;
import com.amap.api.maps.model.HeatMapLayer;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MVTTileOverlay;
import com.amap.api.maps.model.MVTTileOverlayOptions;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.MapPoi;
import com.autonavi.base.ae.gmap.bean.NativeTextGenerate;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.amap.api.col.3sl.l  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/l.class */
public final class l implements ct.a, k.a, IAMapDelegate, IAMapListener {
    private boolean A;
    private final IGLSurfaceView B;
    private eh C;
    private final IGlOverlayLayer D;
    private boolean E;
    private int F;
    private AtomicBoolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private ck K;
    private LocationSource L;
    private boolean M;
    private Marker N;
    private BaseOverlayImp O;
    private Marker P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private int U;
    private boolean V;
    private boolean W;
    private Rect X;
    private int Y;
    private MyTrafficStyle Z;
    protected boolean a;
    private Lock aA;
    private int aB;
    private int aC;
    private int aD;
    private b aE;
    private cp aF;
    private AMap.OnMultiPointClickListener aG;
    private k aH;
    private long aI;
    private a aJ;
    private a aK;
    private a aL;
    private a aM;
    private a aN;
    private a aO;
    private a aP;
    private a aQ;
    private a aR;
    private a aS;
    private a aT;
    private a aU;
    private Runnable aV;
    private a aW;
    private com.autonavi.extra.b aX;
    private String aY;
    private String aZ;
    private Thread aa;
    private Thread ab;
    private v ac;
    private boolean ad;
    private boolean ae;
    private int af;
    private CustomRenderer ag;
    private int ah;
    private int ai;
    private List<ab> aj;
    private cr ak;
    private ct al;
    private long am;
    private GLMapRender an;
    private y ao;
    private boolean ap;
    private float aq;
    private float ar;
    private float as;
    private boolean at;
    private boolean au;
    private boolean av;
    private volatile boolean aw;
    private volatile boolean ax;
    private boolean ay;
    private boolean az;
    protected MapConfig b;
    private boolean ba;
    private boolean bb;
    private int bc;
    private EAMapPlatformGestureInfo bd;
    private long be;
    private at bf;
    private IPoint[] bg;
    protected at c;
    dn d;
    protected Context e;
    protected GLMapEngine f;
    public int g;
    public int h;
    boolean i;
    protected final Handler j;
    Point k;
    protected String l;
    float[] m;
    float[] n;
    float[] o;
    float[] p;
    String q;
    String r;
    int s;
    private p t;
    private q u;
    private AMapGestureListener v;
    private au w;
    private UiSettings x;
    private IProjectionDelegate y;
    private final af z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.l$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/l$a.class */
    public static abstract class a implements Runnable {
        boolean b;
        boolean c;
        int d;
        int e;
        int f;
        int g;
        int h;
        int i;
        byte[] j;

        private a() {
            this.b = false;
            this.c = false;
            this.h = 0;
            this.i = 0;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b = false;
        }
    }

    /* renamed from: com.amap.api.col.3sl.l$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/l$b.class */
    final class b {
        b() {
        }

        public final void a(at atVar) {
            List a;
            List a2;
            if (l.this.b == null || !l.this.b.isIndoorEnable()) {
                return;
            }
            final ee e = l.this.C.e();
            if (atVar == null) {
                try {
                    List a3 = l.this.u.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (a3 != null && a3.size() > 0) {
                        synchronized (a3) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= a3.size()) {
                                    break;
                                }
                                ((AMap.OnIndoorBuildingActiveListener) a3.get(i2)).OnIndoorBuilding(atVar);
                                i = i2 + 1;
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (l.this.c != null) {
                    l.this.c.g = null;
                }
                if (e.b()) {
                    l.this.j.post(new Runnable() { // from class: com.amap.api.col.3sl.l.b.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            e.a(false);
                        }
                    });
                }
                l.this.b.maxZoomLevel = l.this.b.isSetLimitZoomLevel() ? l.this.b.getMaxZoomLevel() : 20.0f;
                try {
                    if (!l.this.z.isZoomControlsEnabled() || (a = l.this.u.a(AMapWidgetListener.class.hashCode())) == null || a.size() <= 0) {
                        return;
                    }
                    synchronized (a) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < a.size()) {
                                ((AMapWidgetListener) a.get(i4)).invalidateZoomController(l.this.b.getSZ());
                                i3 = i4 + 1;
                            }
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (atVar != null && atVar.floor_indexs != null && atVar.floor_names != null && atVar.floor_indexs.length == atVar.floor_names.length) {
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= atVar.floor_indexs.length) {
                        break;
                    } else if (atVar.activeFloorIndex == atVar.floor_indexs[i6]) {
                        atVar.activeFloorName = atVar.floor_names[i6];
                        break;
                    } else {
                        i5 = i6 + 1;
                    }
                }
            }
            if (atVar == null || l.this.c == null || l.this.c.activeFloorIndex == atVar.activeFloorIndex || !e.b()) {
                if (atVar != null && (l.this.c == null || !l.this.c.poiid.equals(atVar.poiid) || l.this.c.g == null)) {
                    l.this.c = atVar;
                    if (l.this.b != null) {
                        if (l.this.c.g == null) {
                            l.this.c.g = new Point();
                        }
                        DPoint mapGeoCenter = l.this.b.getMapGeoCenter();
                        if (mapGeoCenter != null) {
                            l.this.c.g.x = (int) mapGeoCenter.x;
                            l.this.c.g.y = (int) mapGeoCenter.y;
                        }
                    }
                }
                try {
                    List a4 = l.this.u.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                    if (a4 != null && a4.size() > 0) {
                        synchronized (a4) {
                            int i7 = 0;
                            while (true) {
                                int i8 = i7;
                                if (i8 >= a4.size()) {
                                    break;
                                }
                                ((AMap.OnIndoorBuildingActiveListener) a4.get(i8)).OnIndoorBuilding(atVar);
                                i7 = i8 + 1;
                            }
                        }
                    }
                    MapConfig mapConfig = l.this.b;
                    float f = 20.0f;
                    if (l.this.b.isSetLimitZoomLevel()) {
                        f = l.this.b.getMaxZoomLevel();
                    }
                    mapConfig.maxZoomLevel = f;
                    if (l.this.z.isZoomControlsEnabled() && (a2 = l.this.u.a(AMapWidgetListener.class.hashCode())) != null && a2.size() > 0) {
                        synchronized (a2) {
                            int i9 = 0;
                            while (true) {
                                int i10 = i9;
                                if (i10 >= a2.size()) {
                                    break;
                                }
                                ((AMapWidgetListener) a2.get(i10)).invalidateZoomController(l.this.b.getSZ());
                                i9 = i10 + 1;
                            }
                        }
                    }
                    if (l.this.z.isIndoorSwitchEnabled()) {
                        if (!e.b()) {
                            l.this.z.setIndoorSwitchEnabled(true);
                        }
                        l.this.j.post(new Runnable() { // from class: com.amap.api.col.3sl.l.b.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    e.a(l.this.c.floor_names);
                                    e.a(l.this.c.activeFloorName);
                                    if (e.b()) {
                                        return;
                                    }
                                    e.a(true);
                                } catch (Throwable th3) {
                                    th3.printStackTrace();
                                }
                            }
                        });
                    } else if (l.this.z.isIndoorSwitchEnabled() || !e.b()) {
                    } else {
                        l.this.z.setIndoorSwitchEnabled(false);
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.amap.api.col.3sl.l$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/l$c.class */
    final class c implements ee.a {
        private c() {
        }

        /* synthetic */ c(l lVar, byte b) {
            this();
        }

        @Override // com.amap.api.col.p0003sl.ee.a
        public final void a(int i) {
            if (l.this.c != null) {
                l.this.c.activeFloorIndex = l.this.c.floor_indexs[i];
                l.this.c.activeFloorName = l.this.c.floor_names[i];
                try {
                    l.this.setIndoorBuildingInfo(l.this.c);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.l$d */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/l$d.class */
    public final class d implements Runnable {
        private Context b;
        private AMap.OnCacheRemoveListener c;

        public d(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.b = context;
            this.c = onCacheRemoveListener;
        }

        public final boolean equals(Object obj) {
            return obj instanceof d;
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
            if (com.amap.api.col.p0003sl.dw.e(r0) != false) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0063 A[Catch: all -> 0x010e, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x010e, blocks: (B:20:0x004b, B:26:0x0063), top: B:81:0x004b }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x007e  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 280
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.l.d.run():void");
        }
    }

    public l(IGLSurfaceView iGLSurfaceView, Context context) {
        this(iGLSurfaceView, context, false);
    }

    public l(IGLSurfaceView iGLSurfaceView, Context context, boolean z) {
        this.t = null;
        this.u = new q();
        this.a = false;
        this.A = false;
        this.E = false;
        this.G = new AtomicBoolean(false);
        this.H = false;
        this.b = new MapConfig(true);
        this.I = false;
        this.J = false;
        this.M = false;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = 0;
        this.V = true;
        this.W = true;
        this.X = new Rect();
        this.Y = 1;
        this.Z = null;
        this.ad = false;
        this.ae = false;
        this.af = 0;
        this.ah = -1;
        this.ai = -1;
        this.aj = new ArrayList();
        this.d = null;
        this.am = -1L;
        this.ap = false;
        this.aq = 0.0f;
        this.ar = 1.0f;
        this.as = 1.0f;
        this.at = true;
        this.au = false;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = new ReentrantLock();
        this.aB = 0;
        this.i = true;
        this.j = new Handler(Looper.getMainLooper()) { // from class: com.amap.api.col.3sl.l.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int arrayList;
                ek f;
                if (message == null || l.this.G.get()) {
                    return;
                }
                try {
                    int i = message.what;
                    if (i == 2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Key验证失败：[");
                        if (message.obj != null) {
                            sb.append(message.obj);
                        } else {
                            sb.append(hp.b);
                        }
                        sb.append("]");
                        Log.w("amapsdk", sb.toString());
                        return;
                    }
                    switch (i) {
                        case 10:
                            CameraPosition cameraPosition = (CameraPosition) message.obj;
                            List<AMap.OnCameraChangeListener> a2 = l.this.u.a(AMap.OnCameraChangeListener.class.hashCode());
                            if (cameraPosition != null && a2 != null && a2.size() > 0) {
                                synchronized (a2) {
                                    for (AMap.OnCameraChangeListener onCameraChangeListener : a2) {
                                        onCameraChangeListener.onCameraChange(cameraPosition);
                                    }
                                }
                            }
                            l.this.b.addChangedCounter();
                            return;
                        case 11:
                            CameraPosition cameraPosition2 = l.this.getCameraPosition();
                            if (cameraPosition2 != null && l.this.C != null) {
                                l.this.C.a(cameraPosition2);
                            }
                            l.this.b(cameraPosition2);
                            if (l.this.av) {
                                l.f(l.this);
                                if (l.this.D != null) {
                                    l.this.D.setFlingState(false);
                                }
                                l.this.b();
                            }
                            if (l.this.T) {
                                l.this.redrawInfoWindow();
                                l.i(l.this);
                            }
                            l.this.a(cameraPosition2);
                            return;
                        case 12:
                            if (l.this.C != null) {
                                l.this.C.a(Float.valueOf(l.this.getZoomLevel()));
                                return;
                            }
                            return;
                        case 13:
                            if (l.this.C != null) {
                                l.this.C.h();
                                return;
                            }
                            return;
                        case 14:
                            List<AMap.OnMapTouchListener> a3 = l.this.u.a(AMap.OnMapTouchListener.class.hashCode());
                            if (a3 == null || a3.size() <= 0) {
                                return;
                            }
                            synchronized (a3) {
                                for (AMap.OnMapTouchListener onMapTouchListener : a3) {
                                    onMapTouchListener.onTouch((MotionEvent) message.obj);
                                }
                            }
                            return;
                        case 15:
                            Bitmap bitmap = (Bitmap) message.obj;
                            int i2 = message.arg1;
                            if (bitmap == null || l.this.C == null) {
                                List a4 = l.this.u.a(AMap.onMapPrintScreenListener.class.hashCode());
                                arrayList = a4 != null ? new ArrayList(a4) : null;
                                List a5 = l.this.u.a(AMap.OnMapScreenShotListener.class.hashCode());
                                arrayList = a5 != null ? new ArrayList(a5) : null;
                                l.this.u.a(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                                l.this.u.a(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                                if (arrayList != null && arrayList.size() > 0) {
                                    synchronized (arrayList) {
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 < arrayList.size()) {
                                                ((AMap.onMapPrintScreenListener) arrayList.get(i4)).onMapPrint(null);
                                                i3 = i4 + 1;
                                            }
                                        }
                                    }
                                }
                                if (arrayList == null || arrayList.size() <= 0) {
                                    return;
                                }
                                synchronized (arrayList) {
                                    int i5 = 0;
                                    while (true) {
                                        int i6 = i5;
                                        if (i6 < arrayList.size()) {
                                            ((AMap.OnMapScreenShotListener) arrayList.get(i6)).onMapScreenShot(null);
                                            ((AMap.OnMapScreenShotListener) arrayList.get(i6)).onMapScreenShot(null, i2);
                                            i5 = i6 + 1;
                                        }
                                    }
                                }
                                return;
                            }
                            Canvas canvas = new Canvas(bitmap);
                            if (l.this.V && (f = l.this.C.f()) != null) {
                                f.onDraw(canvas);
                            }
                            l.this.C.a(canvas);
                            List a6 = l.this.u.a(AMap.onMapPrintScreenListener.class.hashCode());
                            arrayList = a6 != null ? new ArrayList(a6) : null;
                            List a7 = l.this.u.a(AMap.OnMapScreenShotListener.class.hashCode());
                            arrayList = a7 != null ? new ArrayList(a7) : null;
                            l.this.u.a(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
                            l.this.u.a(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
                            if (arrayList != null && arrayList.size() > 0) {
                                synchronized (arrayList) {
                                    int i7 = 0;
                                    while (true) {
                                        try {
                                            int i8 = i7;
                                            if (i8 < arrayList.size()) {
                                                ((AMap.onMapPrintScreenListener) arrayList.get(i8)).onMapPrint(new BitmapDrawable(l.this.e.getResources(), bitmap));
                                                i7 = i8 + 1;
                                            }
                                        } finally {
                                        }
                                    }
                                }
                            }
                            if (arrayList == null || arrayList.size() <= 0) {
                                return;
                            }
                            synchronized (arrayList) {
                                int i9 = 0;
                                while (true) {
                                    try {
                                        int i10 = i9;
                                        if (i10 < arrayList.size()) {
                                            ((AMap.OnMapScreenShotListener) arrayList.get(i10)).onMapScreenShot(bitmap);
                                            ((AMap.OnMapScreenShotListener) arrayList.get(i10)).onMapScreenShot(bitmap, i2);
                                            i9 = i10 + 1;
                                        }
                                    } finally {
                                    }
                                }
                            }
                            return;
                        case 16:
                            List a8 = l.this.u.a(AMap.OnMapLoadedListener.class.hashCode());
                            if (a8 != null) {
                                synchronized (a8) {
                                    int i11 = 0;
                                    while (true) {
                                        int i12 = i11;
                                        if (i12 < a8.size()) {
                                            ((AMap.OnMapLoadedListener) a8.get(i12)).onMapLoaded();
                                            i11 = i12 + 1;
                                        }
                                    }
                                }
                            }
                            if (l.this.C != null) {
                                l.this.C.i();
                                return;
                            }
                            return;
                        case 17:
                            if (!l.this.f.isInMapAnimation(l.this.F) || l.this.D == null) {
                                return;
                            }
                            l.this.D.setFlingState(false);
                            return;
                        case 18:
                            if (l.this.w != null) {
                                l.this.w.b();
                                return;
                            }
                            return;
                        case 19:
                            List<AMap.OnMapClickListener> a9 = l.this.u.a(AMap.OnMapClickListener.class.hashCode());
                            if (a9 != null) {
                                DPoint obtain = DPoint.obtain();
                                l.this.getPixel2LatLng(message.arg1, message.arg2, obtain);
                                synchronized (a9) {
                                    for (AMap.OnMapClickListener onMapClickListener : a9) {
                                        onMapClickListener.onMapClick(new LatLng(obtain.y, obtain.x));
                                    }
                                }
                                obtain.recycle();
                                return;
                            }
                            return;
                        case 20:
                            List a10 = l.this.u.a(AMap.OnPOIClickListener.class.hashCode());
                            if (a10 == null || a10.size() <= 0) {
                                return;
                            }
                            synchronized (a10) {
                                for (int i13 = 0; arrayList < a10.size(); i13 = arrayList + 1) {
                                    ((AMap.OnPOIClickListener) a10.get(arrayList)).onPOIClick((Poi) message.obj);
                                }
                            }
                            return;
                        default:
                            return;
                    }
                } catch (Throwable th) {
                    iw.c(th, "AMapDelegateImp", "handleMessage");
                    th.printStackTrace();
                }
            }
        };
        this.aJ = new a() { // from class: com.amap.api.col.3sl.l.11
            @Override // com.amap.api.col.p0003sl.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setTrafficEnabled(this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aK = new a() { // from class: com.amap.api.col.3sl.l.21
            @Override // com.amap.api.col.p0003sl.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setCenterToPixel(l.this.aC, l.this.aD);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aL = new a() { // from class: com.amap.api.col.3sl.l.32
            @Override // com.amap.api.col.p0003sl.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                l.this.a(this.g, this.d, this.e, this.f);
            }
        };
        this.aM = new a() { // from class: com.amap.api.col.3sl.l.36
            @Override // com.amap.api.col.p0003sl.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                l.this.setMapCustomEnable(this.c);
            }
        };
        this.aN = new a() { // from class: com.amap.api.col.3sl.l.37
            @Override // com.amap.api.col.p0003sl.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                l.this.a(this.g, this.c);
            }
        };
        this.aO = new a() { // from class: com.amap.api.col.3sl.l.38
            @Override // com.amap.api.col.p0003sl.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setMapTextEnable(this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aP = new a() { // from class: com.amap.api.col.3sl.l.39
            @Override // com.amap.api.col.p0003sl.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setRoadArrowEnable(this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aQ = new a() { // from class: com.amap.api.col.3sl.l.40
            @Override // com.amap.api.col.p0003sl.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setNaviLabelEnable(this.c, this.h, this.i);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aR = new a() { // from class: com.amap.api.col.3sl.l.2
            @Override // com.amap.api.col.p0003sl.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setConstructingRoadEnable(this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aS = new a() { // from class: com.amap.api.col.3sl.l.3
            @Override // com.amap.api.col.p0003sl.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setTrafficStyleWithTextureData(this.j);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aT = new a() { // from class: com.amap.api.col.3sl.l.4
            @Override // com.amap.api.col.p0003sl.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                l.this.b(this.g, this.c);
            }
        };
        this.aU = new a() { // from class: com.amap.api.col.3sl.l.5
            @Override // com.amap.api.col.p0003sl.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                try {
                    l.this.setIndoorEnabled(this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aV = new Runnable() { // from class: com.amap.api.col.3sl.l.6
            @Override // java.lang.Runnable
            public final void run() {
                ek f;
                if (l.this.C == null || (f = l.this.C.f()) == null) {
                    return;
                }
                f.c();
            }
        };
        this.aW = new a() { // from class: com.amap.api.col.3sl.l.7
            @Override // com.amap.api.col.p0003sl.l.a, java.lang.Runnable
            public final void run() {
                super.run();
                l.this.c(this.g, this.c);
            }
        };
        this.aY = "";
        this.aZ = "";
        this.ba = false;
        this.bb = false;
        this.bc = 0;
        this.bd = new EAMapPlatformGestureInfo();
        this.k = new Point();
        this.be = 0L;
        this.l = null;
        this.bf = null;
        this.m = new float[16];
        this.n = new float[16];
        this.o = new float[16];
        this.bg = null;
        this.p = new float[12];
        this.q = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
        this.r = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(1.0,0,0,1.0);\n}";
        this.s = -1;
        this.e = context;
        hy a2 = hx.a(context, dw.a());
        if (a2.a == hx.c.SuccessCode) {
            dy.a(context);
            dy.a(dx.c, "init map delegate");
        }
        com.autonavi.extra.b bVar = new com.autonavi.extra.b();
        this.aX = bVar;
        bVar.a();
        this.aX.b();
        iw.a(this.e);
        dk.a().a(this.e);
        w.b = ho.c(context);
        db.a(this.e);
        this.ao = new y(this);
        GLMapRender gLMapRender = new GLMapRender(this);
        this.an = gLMapRender;
        this.B = iGLSurfaceView;
        iGLSurfaceView.setRenderer(gLMapRender);
        this.D = new z(this, this.e);
        this.f = new GLMapEngine(this.e, this);
        this.C = new eg(this.e, this, this.D);
        this.z = new af(this);
        this.C.a(new c(this, (byte) 0));
        this.aE = new b();
        this.B.setRenderMode(0);
        this.an.setRenderFps(15.0f);
        this.f.setMapListener(this);
        this.y = new ac(this);
        this.t = new p(this);
        au auVar = new au(this.e);
        this.w = auVar;
        auVar.a(this.C);
        this.w.b(new cm(this.D, context));
        this.aa = new t(this.e, this);
        this.L = new av(this.e);
        this.ak = new cr(this.e, this);
        ct ctVar = new ct(this.e);
        this.al = ctVar;
        ctVar.a(this);
        a(z);
        MapConfig mapConfig = this.b;
        k kVar = new k(this, this.e, mapConfig != null ? mapConfig.isAbroadEnable() : false);
        this.aH = kVar;
        kVar.a(this);
        if (a2.a != hx.c.SuccessCode) {
            this.b.setMapEnable(false);
        }
        this.F = this.f.getEngineIDWithType(1);
    }

    private int a(int i, Rect rect, int i2, int i3) {
        int i4;
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine == null || i < 0) {
            i4 = 0;
        } else {
            int engineIDWithType = gLMapEngine.getEngineIDWithType(i);
            if (this.f.isEngineCreated(engineIDWithType)) {
                a(engineIDWithType, rect.left, rect.top, rect.width(), rect.height(), i2, i3);
                i4 = engineIDWithType;
            } else {
                int i5 = Build.VERSION.SDK_INT >= 4 ? this.e.getResources().getDisplayMetrics().densityDpi : 0;
                float f = this.e.getResources().getDisplayMetrics().density;
                NativeTextGenerate.getInstance().setDensity(f);
                GLMapEngine.MapViewInitParam mapViewInitParam = new GLMapEngine.MapViewInitParam();
                mapViewInitParam.engineId = engineIDWithType;
                mapViewInitParam.x = rect.left;
                mapViewInitParam.y = rect.top;
                mapViewInitParam.width = rect.width();
                mapViewInitParam.height = rect.height();
                mapViewInitParam.screenWidth = i2;
                mapViewInitParam.screenHeight = i3;
                mapViewInitParam.screenScale = f;
                mapViewInitParam.textScale = this.as * f;
                mapViewInitParam.mapZoomScale = this.ar;
                mapViewInitParam.taskThreadCount = 3;
                this.f.createAMapEngineWithFrame(mapViewInitParam);
                GLMapState mapState = this.f.getMapState(engineIDWithType);
                mapState.setMapZoomer(this.b.getSZ());
                mapState.setCameraDegree(this.b.getSC());
                mapState.setMapAngle(this.b.getSR());
                mapState.setMapGeoCenter(this.b.getSX(), this.b.getSY());
                this.f.setMapState(engineIDWithType, mapState);
                this.ar = mapState.calMapZoomScalefactor(i2, i3, i5);
                this.f.setOvelayBundle(engineIDWithType, new GLOverlayBundle(engineIDWithType, this));
                i4 = engineIDWithType;
            }
        }
        this.G.set(false);
        return i4;
    }

    private void a(final double d2, final double d3) {
        this.j.post(new Runnable() { // from class: com.amap.api.col.3sl.l.9
            @Override // java.lang.Runnable
            public final void run() {
                Message obtain = Message.obtain();
                obtain.what = 19;
                obtain.arg1 = (int) d2;
                obtain.arg2 = (int) d3;
                l.this.j.sendMessage(obtain);
            }
        });
    }

    private void a(int i) {
        int i2 = this.ai;
        if (i2 != -1) {
            this.an.setRenderFps(i2);
            resetRenderTime();
        } else if (this.f.isInMapAction(i) || this.au) {
            this.an.setRenderFps(40.0f);
        } else if (this.f.isInMapAnimation(i)) {
            this.an.setRenderFps(30.0f);
            this.an.resetTickCount(15);
        } else {
            this.an.setRenderFps(15.0f);
        }
        if (this.b.isWorldMapEnable() != MapsInitializer.isLoadWorldGridMap()) {
            b();
            this.b.setWorldMapEnable(MapsInitializer.isLoadWorldGridMap());
        }
    }

    private void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.setServiceViewRect(i, i2, i3, i4, i5, i6, i7);
        }
    }

    private void a(final int i, final int i2, final int i3, final int i4, final boolean z, final boolean z2, final StyleItem[] styleItemArr) {
        synchronized (this) {
            if (this.ax && this.aw && this.a) {
                e(i3);
                queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.13
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l.this.f.setMapModeAndStyle(i, i2, i3, i4, z, z2, styleItemArr);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                return;
            }
            this.aL.g = i;
            this.aL.d = i2;
            this.aL.e = i3;
            this.aL.f = i4;
            this.aL.b = true;
        }
    }

    private void a(int i, int i2, FPoint fPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.G.get() || !this.aw || (gLMapEngine = this.f) == null || (mapState = gLMapEngine.getMapState(this.F)) == null) {
            return;
        }
        mapState.p20ToScreenPoint(i, i2, fPoint);
    }

    private void a(MotionEvent motionEvent) throws RemoteException {
        if (!this.M || this.P == null) {
            return;
        }
        int x = (int) motionEvent.getX();
        int y = (int) (motionEvent.getY() - 60.0f);
        if (this.P.getPosition() != null) {
            DPoint obtain = DPoint.obtain();
            getPixel2LatLng(x, y, obtain);
            LatLng latLng = new LatLng(obtain.y, obtain.x);
            obtain.recycle();
            this.P.setPosition(latLng);
            try {
                List a2 = this.u.a(AMap.OnMarkerDragListener.class.hashCode());
                if (a2 == null || a2.size() <= 0) {
                    return;
                }
                synchronized (a2) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < a2.size()) {
                            ((AMap.OnMarkerDragListener) a2.get(i2)).onMarkerDrag(this.P);
                            i = i2 + 1;
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    private void a(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        abstractCameraUpdateMessage.isUseAnchor = this.I;
        if (this.I) {
            abstractCameraUpdateMessage.anchorX = this.b.getAnchorX();
            abstractCameraUpdateMessage.anchorY = this.b.getAnchorY();
        }
        if (abstractCameraUpdateMessage.width == 0) {
            abstractCameraUpdateMessage.width = getMapWidth();
        }
        if (abstractCameraUpdateMessage.height == 0) {
            abstractCameraUpdateMessage.height = getMapHeight();
        }
        abstractCameraUpdateMessage.mapConfig = this.b;
    }

    private void a(GLMapState gLMapState, int i, int i2, DPoint dPoint) {
        if (!this.aw || this.f == null) {
            return;
        }
        Point point = new Point();
        gLMapState.screenToP20Point(i, i2, point);
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(point.x, point.y, 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        pixelsToLatLong.recycle();
    }

    private void a(boolean z) {
        com.autonavi.extra.b bVar = this.aX;
        if (bVar != null) {
            Object j = bVar.j();
            if (j != null && (j instanceof Boolean)) {
                MapConfig mapConfig = this.b;
                if (mapConfig != null) {
                    mapConfig.setAbroadEnable(z && ((Boolean) j).booleanValue());
                }
                if (z && ((Boolean) j).booleanValue()) {
                    MapsInitializer.setSupportRecycleView(false);
                }
            }
            Object j2 = this.aX.j();
            if (j2 != null && (j2 instanceof Boolean)) {
                this.C.a(((Boolean) j2).booleanValue());
            }
            Object j3 = this.aX.j();
            if (j2 == null || !(j2 instanceof Integer)) {
                return;
            }
            this.af = ((Integer) j3).intValue();
        }
    }

    private void a(boolean z, byte[] bArr, boolean z2) {
        StyleItem[] styleItemArr;
        cz czVar;
        try {
            this.b.setCustomStyleEnable(z);
            if (this.b.isHideLogoEnable()) {
                this.z.setLogoEnable(!z);
            }
            if (!z) {
                c(this.F, false);
                a(this.F, this.b.getMapStyleMode(), this.b.getMapStyleTime(), this.b.getMapStyleState(), true, false, (StyleItem[]) null);
                return;
            }
            c(this.F, true);
            cy cyVar = new cy();
            if (this.Z != null && this.Z.getTrafficRoadBackgroundColor() != -1) {
                cyVar.a(this.Z.getTrafficRoadBackgroundColor());
            }
            boolean z3 = false;
            if (this.b.isProFunctionAuthEnable()) {
                z3 = false;
                if (!TextUtils.isEmpty(this.b.getCustomTextureResourcePath())) {
                    z3 = true;
                }
            }
            if (bArr != null) {
                cz a2 = cyVar.a(bArr, z3);
                styleItemArr = null;
                czVar = a2;
                if (a2 != null) {
                    StyleItem[] c2 = a2.c();
                    styleItemArr = c2;
                    czVar = a2;
                    if (c2 != null) {
                        this.b.setUseProFunction(true);
                        styleItemArr = c2;
                        czVar = a2;
                    }
                }
            } else {
                styleItemArr = null;
                czVar = null;
            }
            StyleItem[] styleItemArr2 = styleItemArr;
            if (styleItemArr == null) {
                cz a3 = cyVar.a(this.b.getCustomStylePath(), z3);
                styleItemArr2 = styleItemArr;
                czVar = a3;
                if (a3 != null) {
                    styleItemArr2 = a3.c();
                    czVar = a3;
                }
            }
            if (cyVar.a() != 0) {
                this.b.setCustomBackgroundColor(cyVar.a());
            }
            if (czVar == null || czVar.d() == null) {
                a(styleItemArr2, z2);
            } else if (this.al != null) {
                this.al.a((String) czVar.d());
                this.al.a(czVar);
                this.al.b();
            }
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    private void a(StyleItem[] styleItemArr, boolean z) {
        if (!(z || (styleItemArr != null && styleItemArr.length > 0))) {
            dt.a(this.e, false);
            return;
        }
        a(this.F, 0, 0, 0, true, true, styleItemArr);
        dt.a(this.e, true);
    }

    private boolean a(int i, int i2) {
        AbstractCameraUpdateMessage a2;
        if (this.aw && ((int) c()) < this.b.getMaxZoomLevel()) {
            try {
                if (this.I || this.z.isZoomInByScreenCenter()) {
                    a2 = ak.a(1.0f, (Point) null);
                } else {
                    this.k.x = i;
                    this.k.y = i2;
                    a2 = ak.a(1.0f, this.k);
                }
                animateCamera(a2);
            } catch (Throwable th) {
                iw.c(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
            return true;
        }
        return false;
    }

    private static boolean a(LatLngBounds latLngBounds) {
        return (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null) ? false : true;
    }

    private boolean a(boolean z, boolean z2) {
        if (z) {
            if (this.bb) {
                dc.a("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setCustomMapStyle将不会生效");
                return true;
            }
            this.ba = true;
        }
        if (z2) {
            if (this.ba) {
                dc.a("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setWorldVectorMapStyle将不会生效");
                return true;
            }
            this.bb = true;
            return false;
        }
        return false;
    }

    private void b(final int i) {
        queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.12
            @Override // java.lang.Runnable
            public final void run() {
                if (!l.this.aw || l.this.f == null) {
                    return;
                }
                l.this.f.setHighlightSubwayEnable(i, false);
            }
        });
    }

    private void b(final MotionEvent motionEvent) {
        queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.8
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (l.this.b == null || !l.this.b.isTouchPoiEnable()) {
                        return;
                    }
                    l.this.f.addGestureSingleTapMessage(motionEvent.getX(), motionEvent.getY());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CameraPosition cameraPosition) {
        if (!this.b.getMapLanguage().equals("en")) {
            if (this.W) {
                return;
            }
            this.W = true;
            b(this.F, true);
            return;
        }
        boolean c2 = c(cameraPosition);
        if (c2 != this.W) {
            this.W = c2;
            b(this.F, c2);
        }
    }

    private void b(boolean z) {
        this.at = z;
    }

    private float c() {
        if (this.b != null) {
            return getMapConfig().getSZ();
        }
        return 0.0f;
    }

    private void c(int i) {
        GLMapRender gLMapRender = this.an;
        if (gLMapRender != null) {
            gLMapRender.renderPause();
        }
        f(i);
    }

    private boolean c(MotionEvent motionEvent) {
        try {
            List<AMap.OnPolylineClickListener> a2 = this.u.a(AMap.OnPolylineClickListener.class.hashCode());
            if (a2 == null || a2.size() <= 0) {
                return false;
            }
            DPoint obtain = DPoint.obtain();
            getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
            LatLng latLng = new LatLng(obtain.y, obtain.x);
            obtain.recycle();
            Polyline hitOverlay = this.D.getHitOverlay(latLng, 2);
            if (hitOverlay != null) {
                synchronized (a2) {
                    for (AMap.OnPolylineClickListener onPolylineClickListener : a2) {
                        onPolylineClickListener.onPolylineClick(hitOverlay);
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean c(CameraPosition cameraPosition) {
        MapConfig mapConfig;
        boolean z = false;
        if (cameraPosition.zoom < 6.0f) {
            return false;
        }
        if (cameraPosition.isAbroad) {
            z = true;
        } else {
            if (this.b != null) {
                try {
                    return !dp.a(mapConfig.getGeoRectangle().getClipRect());
                } catch (Throwable th) {
                    th.printStackTrace();
                    dw.a(th);
                    return false;
                }
            }
        }
        return z;
    }

    private void d() {
        if (this.aw) {
            this.ao.a();
            this.ap = true;
            this.au = true;
            try {
                stopAnimation();
            } catch (RemoteException e) {
            }
        }
    }

    private void d(int i) {
        f(i);
        GLMapRender gLMapRender = this.an;
        if (gLMapRender != null) {
            gLMapRender.renderResume();
        }
    }

    private boolean d(MotionEvent motionEvent) throws RemoteException {
        LatLng position;
        DPoint obtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.y, obtain.x);
        obtain.recycle();
        BaseOverlay hitBaseOverlay = this.D.getHitBaseOverlay(latLng, 1);
        if ((hitBaseOverlay instanceof Marker) && ((Marker) hitBaseOverlay).getId().contains("MARKER")) {
            try {
                Marker marker = (Marker) hitBaseOverlay;
                this.D.set2Top(marker.getId());
                List<AMap.OnMarkerClickListener> a2 = this.u.a(AMap.OnMarkerClickListener.class.hashCode());
                boolean z = true;
                if (a2 != null) {
                    z = true;
                    if (a2.size() > 0) {
                        synchronized (a2) {
                            if (a2.size() == 1) {
                                z = ((AMap.OnMarkerClickListener) a2.get(0)).onMarkerClick(marker);
                                if (z) {
                                    return true;
                                }
                            } else {
                                z = false;
                                for (AMap.OnMarkerClickListener onMarkerClickListener : a2) {
                                    z |= onMarkerClickListener.onMarkerClick(marker);
                                }
                                if (z) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                this.D.showInfoWindow(marker.getId());
                if (!marker.isViewMode() && (position = marker.getPosition()) != null) {
                    IPoint obtain2 = IPoint.obtain();
                    latlon2Geo(position.latitude, position.longitude, obtain2);
                    moveCamera(ak.a((Point) obtain2));
                }
                return z;
            } catch (Throwable th) {
                iw.c(th, "AMapDelegateImp", "onMarkerTap");
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private void e() {
        this.ap = true;
        this.au = false;
        if (this.R) {
            this.R = false;
        }
        if (this.Q) {
            this.Q = false;
        }
        if (this.S) {
            this.S = false;
        }
        try {
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
            th.printStackTrace();
        }
        if (this.M) {
            List a2 = this.u.a(AMap.OnMarkerDragListener.class.hashCode());
            if (a2 != null && a2.size() > 0 && (this.N != null || this.P != null)) {
                synchronized (a2) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= a2.size()) {
                            break;
                        }
                        ((AMap.OnMarkerDragListener) a2.get(i2)).onMarkerDragEnd(this.P);
                        i = i2 + 1;
                    }
                }
                this.N = null;
                this.P = null;
            }
            this.M = false;
        }
    }

    private void e(int i) {
        eh ehVar = this.C;
        if (ehVar != null) {
            if (i == 0) {
                if (ehVar.b()) {
                    this.C.g(Boolean.FALSE);
                    this.C.c();
                }
            } else if (ehVar.b()) {
            } else {
                this.C.g(Boolean.TRUE);
                this.C.c();
            }
        }
    }

    private boolean e(MotionEvent motionEvent) {
        if (this.D == null || this.aG == null) {
            return false;
        }
        DPoint obtain = DPoint.obtain();
        if (this.f != null) {
            getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
            MultiPointItem multiPointItem = this.D.getMultiPointItem(new LatLng(obtain.y, obtain.x));
            if (multiPointItem == null) {
                return false;
            }
            boolean onPointClick = this.aG.onPointClick(multiPointItem);
            obtain.recycle();
            return onPointClick;
        }
        return false;
    }

    private void f() {
        GLMapState newMapState;
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine == null || (newMapState = gLMapEngine.getNewMapState(this.F)) == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        newMapState.recalculate();
        newMapState.getMapGeoCenter(obtain);
        this.b.setSX(obtain.x);
        this.b.setSY(obtain.y);
        this.b.setSZ(newMapState.getMapZoomer());
        this.b.setSC(newMapState.getCameraDegree());
        this.b.setSR(newMapState.getMapAngle());
        newMapState.recycle();
        obtain.recycle();
    }

    private void f(final int i) {
        queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.14
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    l.this.f.clearAllMessages(i);
                    l.this.f.clearAnimations(i, true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private boolean f(MotionEvent motionEvent) throws RemoteException {
        try {
            List a2 = this.u.a(AMap.OnInfoWindowClickListener.class.hashCode());
            BaseOverlay a3 = this.w.a(motionEvent);
            if (a3 == null || !(a3 instanceof Marker)) {
                return false;
            }
            synchronized (a2) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < a2.size()) {
                        ((AMap.OnInfoWindowClickListener) a2.get(i2)).onInfoWindowClick((Marker) a3);
                        i = i2 + 1;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    static /* synthetic */ boolean f(l lVar) {
        lVar.av = false;
        return false;
    }

    private LatLng g() {
        MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapConfig.getSX(), this.b.getSY(), 20);
            LatLng latLng = new LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false);
            pixelsToLatLong.recycle();
            return latLng;
        }
        return null;
    }

    private boolean g(int i) {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.getSrvViewStateBoolValue(i, 7);
        }
        return false;
    }

    private void h() {
        synchronized (this) {
            synchronized (this.aj) {
                int size = this.aj.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < size) {
                        this.aj.get(i2).a().recycle();
                        i = i2 + 1;
                    } else {
                        this.aj.clear();
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006f A[Catch: all -> 0x00d2, TryCatch #0 {all -> 0x00d2, blocks: (B:20:0x004d, B:22:0x006f, B:24:0x0076, B:26:0x0080, B:29:0x00a1, B:36:0x00ce, B:27:0x008a, B:30:0x00ab, B:32:0x00bb, B:34:0x00c3, B:19:0x0045), top: B:41:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ab A[Catch: all -> 0x00d2, TRY_ENTER, TryCatch #0 {all -> 0x00d2, blocks: (B:20:0x004d, B:22:0x006f, B:24:0x0076, B:26:0x0080, B:29:0x00a1, B:36:0x00ce, B:27:0x008a, B:30:0x00ab, B:32:0x00bb, B:34:0x00c3, B:19:0x0045), top: B:41:0x0045 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h(int r10) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.l.h(int):void");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private void i() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    static /* synthetic */ boolean i(l lVar) {
        lVar.T = false;
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j() {
        /*
            Method dump skipped, instructions count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.l.j():void");
    }

    private void k() {
        if (!this.J) {
            this.j.sendEmptyMessage(16);
            this.J = true;
            b();
        }
        long j = this.be;
        if (j < 2) {
            this.be = j + 1;
            return;
        }
        final ec d2 = this.C.d();
        if (d2 == null || d2.getVisibility() == 8) {
            return;
        }
        dt.a(this.e, System.currentTimeMillis() - this.aI);
        this.j.post(new Runnable() { // from class: com.amap.api.col.3sl.l.10
            @Override // java.lang.Runnable
            public final void run() {
                if (l.this.H) {
                    return;
                }
                try {
                    if (l.this.c != null) {
                        l.this.setIndoorBuildingInfo(l.this.c);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                d2.a();
            }
        });
        this.f.setStyleChangeGradualEnable(this.F, true);
    }

    private void l() {
        GLMapRender gLMapRender = this.an;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    private void m() {
        GLMapRender gLMapRender;
        if (!this.aw || (gLMapRender = this.an) == null || gLMapRender.isRenderPause()) {
            return;
        }
        requestRender();
    }

    private void n() {
        if (this.ad) {
            return;
        }
        try {
            this.aa.setName("AuthThread");
            this.aa.start();
            this.ad = true;
        } catch (Throwable th) {
            th.printStackTrace();
            dw.a(th);
        }
    }

    private void o() {
        if (this.ae) {
            return;
        }
        try {
            if (this.ab == null) {
                this.ab = new r(this.e, this);
            }
            this.ab.setName("AuthProThread");
            this.ab.start();
            this.ae = true;
        } catch (Throwable th) {
            th.printStackTrace();
            dw.a(th);
        }
    }

    private void p() {
        try {
            LatLngBounds limitLatLngBounds = this.b.getLimitLatLngBounds();
            if (this.f != null && a(limitLatLngBounds)) {
                GLMapState gLMapState = new GLMapState(this.F, this.f.getNativeInstance());
                IPoint obtain = IPoint.obtain();
                GLMapState.lonlat2Geo(limitLatLngBounds.northeast.longitude, limitLatLngBounds.northeast.latitude, obtain);
                IPoint obtain2 = IPoint.obtain();
                GLMapState.lonlat2Geo(limitLatLngBounds.southwest.longitude, limitLatLngBounds.southwest.latitude, obtain2);
                this.b.setLimitIPoints(new IPoint[]{obtain, obtain2});
                gLMapState.recycle();
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.b.setLimitIPoints((IPoint[]) null);
    }

    private void q() {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a();
        }
    }

    private void r() {
        cp cpVar = this.aF;
        if (cpVar != null) {
            cpVar.a();
            this.aF = null;
        }
    }

    public final Size a(Size size) {
        Size size2 = new Size(getMapWidth(), getMapHeight());
        a(getNativeEngineID(), 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(size.getWidth(), size.getHeight());
        getGLMapView().setLayoutParams(layoutParams);
        this.C.f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        b(false);
        return size2;
    }

    @Override // com.amap.api.col.p0003sl.k.a
    public final void a() {
        com.autonavi.extra.b bVar = this.aX;
        if (bVar != null) {
            bVar.i();
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        synchronized (this) {
            a(i, i2, i3, i4, false, false, (StyleItem[]) null);
        }
    }

    public final void a(final int i, final boolean z) {
        if (this.aw && this.ax) {
            resetRenderTime();
            queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.15
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        l.this.f.setBuildingEnable(i, z);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        this.aN.c = z;
        this.aN.b = true;
        this.aN.g = i;
    }

    protected final void a(CameraPosition cameraPosition) {
        MapConfig mapConfig = this.b;
        if (mapConfig == null || mapConfig.getChangedCounter() == 0) {
            return;
        }
        try {
            if (!this.au && this.f.getAnimateionsCount() == 0 && this.f.getStateMessageCount() == 0) {
                if (this.v != null) {
                    this.v.onMapStable();
                }
                if (this.B.isEnabled()) {
                    try {
                        List<AMap.OnCameraChangeListener> a2 = this.u.a(AMap.OnCameraChangeListener.class.hashCode());
                        if (a2 != null && a2.size() != 0) {
                            CameraPosition cameraPosition2 = cameraPosition;
                            if (cameraPosition == null) {
                                cameraPosition2 = getCameraPosition();
                            }
                            synchronized (a2) {
                                for (AMap.OnCameraChangeListener onCameraChangeListener : a2) {
                                    onCameraChangeListener.onCameraChangeFinish(cameraPosition2);
                                }
                            }
                        }
                    } catch (Throwable th) {
                    }
                    this.b.resetChangedCounter();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            dw.a(th2);
        }
    }

    @Override // com.amap.api.col.p0003sl.ct.a
    public final void a(String str, cz czVar) {
        setCustomTextureResourcePath(str);
        if (!this.b.isCustomStyleEnable() || czVar == null) {
            return;
        }
        a(czVar.c(), false);
    }

    public final void accelerateNetworkInChinese(boolean z) {
        com.autonavi.extra.b bVar = this.aX;
        if (bVar != null) {
            bVar.i();
        }
    }

    public final void addAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), (Integer) aMapAppResourceRequestListener);
        }
    }

    public final Arc addArc(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            ArcOptions m8838clone = arcOptions.m8838clone();
            String createId = this.D.createId("ARC");
            Arc arc = new Arc(this.D, m8838clone, createId);
            Arc arc2 = arc;
            if (this.D != null) {
                arc2 = (Arc) this.D.addOverlayObject(createId, arc, m8838clone);
            }
            return arc2;
        } catch (Throwable th) {
            dw.a(th);
            return null;
        }
    }

    public final BuildingOverlay addBuildingOverlay() {
        try {
            dt.h(this.e);
            String createId = this.D.createId("BUILDINGOVERLAY");
            BuildingOverlay buildingOverlay = new BuildingOverlay(this.D, createId);
            Field declaredField = buildingOverlay.getClass().getDeclaredField("buildingOverlayTotalOptions");
            if (declaredField == null) {
                return null;
            }
            resetRenderTime();
            declaredField.setAccessible(true);
            Object obj = declaredField.get(buildingOverlay);
            BuildingOverlay buildingOverlay2 = buildingOverlay;
            if (this.D != null) {
                buildingOverlay2 = buildingOverlay;
                if (obj instanceof BaseOptions) {
                    buildingOverlay2 = (BuildingOverlay) this.D.addOverlayObject(createId, buildingOverlay, (BaseOptions) obj);
                }
            }
            return buildingOverlay2;
        } catch (Exception e) {
            e.printStackTrace();
            dw.a(e);
            return null;
        }
    }

    public final Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            CircleOptions m8844clone = circleOptions.m8844clone();
            String createId = this.D.createId("CIRCLE");
            Circle circle = new Circle(this.D, m8844clone, createId);
            Circle circle2 = circle;
            if (this.D != null) {
                circle2 = (Circle) this.D.addOverlayObject(createId, circle, m8844clone);
            }
            return circle2;
        } catch (Throwable th) {
            dw.a(th);
            return null;
        }
    }

    public final CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        final CrossVectorOverlay crossVectorOverlay = new CrossVectorOverlay(this.F, getContext(), this);
        if (crossOverlayOptions != null) {
            crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        }
        queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.34
            @Override // java.lang.Runnable
            public final void run() {
                GLOverlayBundle overlayBundle;
                if (l.this.f == null || (overlayBundle = l.this.f.getOverlayBundle(l.this.F)) == null) {
                    return;
                }
                overlayBundle.addOverlay(crossVectorOverlay);
            }
        });
        crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        return new CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    public final GL3DModel addGLModel(GL3DModelOptions gL3DModelOptions) {
        resetRenderTime();
        String createId = this.D.createId("GL3DMODEL");
        GL3DModel gL3DModel = new GL3DModel(this.D, gL3DModelOptions, createId);
        this.D.addOverlayObject(createId, gL3DModel, gL3DModelOptions);
        return gL3DModel;
    }

    public final void addGestureMapMessage(int i, AbstractGestureMapMessage abstractGestureMapMessage) {
        if (!this.aw || this.f == null) {
            return;
        }
        try {
            abstractGestureMapMessage.isUseAnchor = this.I;
            abstractGestureMapMessage.anchorX = this.b.getAnchorX();
            abstractGestureMapMessage.anchorY = this.b.getAnchorY();
            this.f.addGestureMessage(i, abstractGestureMapMessage, this.z.isGestureScaleByMapCenter(), this.b.getAnchorX(), this.b.getAnchorY());
        } catch (RemoteException e) {
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            GroundOverlayOptions m8846clone = groundOverlayOptions.m8846clone();
            String createId = this.D.createId("GROUNDOVERLAY");
            GroundOverlay groundOverlay = new GroundOverlay(this.D, m8846clone, createId);
            GroundOverlay groundOverlay2 = groundOverlay;
            if (this.D != null) {
                groundOverlay2 = (GroundOverlay) this.D.addOverlayObject(createId, groundOverlay, m8846clone);
            }
            return groundOverlay2;
        } catch (Throwable th) {
            dw.a(th);
            return null;
        }
    }

    public final HeatMapGridLayer addHeatMapGridLayer(HeatMapGridLayerOptions heatMapGridLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            if (heatMapGridLayerOptions == null) {
                return null;
            }
            String createId = this.D.createId("HEATMAPGRIDLAYER");
            return (HeatMapGridLayer) this.D.addOverlayObject(createId, new HeatMapGridLayer(this.D, heatMapGridLayerOptions, createId), heatMapGridLayerOptions);
        } catch (Throwable th) {
            dw.a(th);
            return null;
        }
    }

    public final HeatMapLayer addHeatMapLayer(HeatMapLayerOptions heatMapLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            if (heatMapLayerOptions == null) {
                return null;
            }
            String createId = this.D.createId("HEATMAPLAYER");
            return (HeatMapLayer) this.D.addOverlayObject(createId, new HeatMapLayer(this.D, heatMapLayerOptions, createId), heatMapLayerOptions);
        } catch (Throwable th) {
            dw.a(th);
            return null;
        }
    }

    public final MVTTileOverlay addMVTTileOverlay(MVTTileOverlayOptions mVTTileOverlayOptions) throws RemoteException {
        try {
            String createId = this.D.createId("MVTTILEOVERLAY");
            MVTTileOverlay mVTTileOverlay = new MVTTileOverlay(this.D, mVTTileOverlayOptions, createId);
            this.D.addOverlayObject(createId, mVTTileOverlay, mVTTileOverlayOptions);
            return mVTTileOverlay;
        } catch (Throwable th) {
            dw.a(th);
            return null;
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        try {
            resetRenderTime();
            MarkerOptions m8855clone = markerOptions.m8855clone();
            String createId = this.D.createId("MARKER");
            Marker marker = new Marker(this.D, m8855clone, createId);
            this.D.addOverlayObject(createId, marker, m8855clone);
            return marker;
        } catch (Throwable th) {
            dw.a(th);
            String str = dx.d;
            dy.a(str, "addMarker failed " + th.getMessage(), markerOptions);
            return null;
        }
    }

    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException {
        try {
            resetRenderTime();
            ArrayList<Marker> arrayList2 = new ArrayList<>();
            final LatLngBounds.Builder builder = LatLngBounds.builder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                MarkerOptions markerOptions = arrayList.get(i2);
                if (arrayList.get(i2) != null) {
                    arrayList2.add(addMarker(markerOptions));
                    if (markerOptions.getPosition() != null) {
                        builder.include(markerOptions.getPosition());
                    }
                }
                i = i2 + 1;
            }
            if (z && arrayList2.size() > 0) {
                getMainHandler().postDelayed(new Runnable() { // from class: com.amap.api.col.3sl.l.18
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l.this.moveCamera(ak.a(builder.build(), 50));
                        } catch (Throwable th) {
                        }
                    }
                }, 50L);
            }
            return arrayList2;
        } catch (Throwable th) {
            dw.a(th);
            String str = dx.d;
            dy.a(str, "addMarkers failed " + th.getMessage(), arrayList);
            return null;
        }
    }

    public final MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        if (multiPointOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            MultiPointOverlayOptions m8856clone = multiPointOverlayOptions.m8856clone();
            String createId = this.D.createId("MULTIOVERLAY");
            MultiPointOverlay multiPointOverlay = new MultiPointOverlay(this.D, m8856clone, createId);
            MultiPointOverlay multiPointOverlay2 = multiPointOverlay;
            if (this.D != null) {
                multiPointOverlay2 = (MultiPointOverlay) this.D.addOverlayObject(createId, multiPointOverlay, m8856clone);
            }
            return multiPointOverlay2;
        } catch (Throwable th) {
            return null;
        }
    }

    public final RouteOverlay addNaviRouteOverlay() {
        return null;
    }

    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            NavigateArrowOptions m8859clone = navigateArrowOptions.m8859clone();
            String createId = this.D.createId("NAVIGATEARROW");
            NavigateArrow navigateArrow = new NavigateArrow(this.D, m8859clone, createId);
            NavigateArrow navigateArrow2 = navigateArrow;
            if (this.D != null) {
                navigateArrow2 = (NavigateArrow) this.D.addOverlayObject(createId, navigateArrow, m8859clone);
            }
            return navigateArrow2;
        } catch (Throwable th) {
            dw.a(th);
            return null;
        }
    }

    public final void addOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), (Integer) onCameraChangeListener);
        }
    }

    public final void addOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), (Integer) onIndoorBuildingActiveListener);
        }
    }

    public final void addOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), (Integer) onInfoWindowClickListener);
        }
    }

    public final void addOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), (Integer) onMapClickListener);
        }
    }

    public final void addOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), (Integer) onMapLoadedListener);
        }
    }

    public final void addOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), (Integer) onMapLongClickListener);
        }
    }

    public final void addOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), (Integer) onMapTouchListener);
        }
    }

    public final void addOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), (Integer) onMarkerClickListener);
        }
    }

    public final void addOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), (Integer) onMarkerDragListener);
        }
    }

    public final void addOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), (Integer) onMyLocationChangeListener);
        }
    }

    public final void addOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), (Integer) onPOIClickListener);
        }
    }

    public final void addOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), (Integer) onPolylineClickListener);
        }
    }

    public final void addOverlayTexture(int i, GLTextureProperty gLTextureProperty) {
        GLOverlayBundle overlayBundle;
        try {
            if (this.f == null || (overlayBundle = this.f.getOverlayBundle(i)) == null || gLTextureProperty == null || gLTextureProperty.mBitmap == null) {
                return;
            }
            this.f.addOverlayTexture(i, gLTextureProperty);
            overlayBundle.addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        if (particleOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            dt.c(this.e);
            String createId = this.D.createId("PARTICLEOVERLAY");
            return (ParticleOverlay) this.D.addOverlayObject(createId, new ParticleOverlay(this.D, particleOverlayOptions, createId), particleOverlayOptions);
        } catch (Throwable th) {
            dw.a(th);
            th.printStackTrace();
            return null;
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            PolygonOptions m8863clone = polygonOptions.m8863clone();
            String createId = this.D.createId("POLYGON");
            Polygon polygon = new Polygon(this.D, m8863clone, createId);
            Polygon polygon2 = polygon;
            if (this.D != null) {
                polygon2 = (Polygon) this.D.addOverlayObject(createId, polygon, m8863clone);
            }
            return polygon2;
        } catch (Throwable th) {
            dw.a(th);
            String str = dx.d;
            dy.a(str, "addPolygon failed " + th.getMessage(), polygonOptions);
            return null;
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            String createId = this.D.createId("POLYLINE");
            return (Polyline) this.D.addOverlayObject(createId, new Polyline(this.D, polylineOptions, createId), polylineOptions);
        } catch (Throwable th) {
            dw.a(th);
            String str = dx.d;
            dy.a(str, "addPolyline failed " + th.getMessage(), polylineOptions);
            return null;
        }
    }

    public final Text addText(TextOptions textOptions) throws RemoteException {
        try {
            resetRenderTime();
            String createId = this.D.createId("TEXT");
            TextOptions m8868clone = textOptions.m8868clone();
            MarkerOptions a2 = cn.a(m8868clone);
            Marker marker = new Marker(this.D, a2, createId);
            marker.setObject(m8868clone.getObject());
            this.D.addOverlayObject(createId, marker, a2);
            return new Text(marker, m8868clone);
        } catch (Throwable th) {
            dw.a(th);
            return null;
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        try {
            TileProvider tileProvider = tileOverlayOptions.getTileProvider();
            if (tileProvider != null && (tileProvider instanceof HeatmapTileProvider)) {
                dt.a(this.e);
            }
            String createId = this.D.createId("TILEOVERLAY");
            TileOverlay tileOverlay = new TileOverlay(this.D, tileOverlayOptions, createId);
            this.D.addOverlayObject(createId, tileOverlay, tileOverlayOptions);
            return tileOverlay;
        } catch (Throwable th) {
            dw.a(th);
            return null;
        }
    }

    public final void afterAnimation() {
        redrawInfoWindow();
    }

    public final void afterDrawFrame(int i, GLMapState gLMapState) {
        float mapZoomer = gLMapState.getMapZoomer();
        GLMapEngine gLMapEngine = this.f;
        if (!(gLMapEngine != null && (gLMapEngine.isInMapAction(i) || this.f.isInMapAnimation(i)))) {
            int i2 = this.ai;
            if (i2 != -1) {
                this.an.setRenderFps(i2);
            } else {
                this.an.setRenderFps(15.0f);
            }
            if (this.aq != mapZoomer) {
                this.aq = mapZoomer;
            }
        }
        if (this.az) {
            return;
        }
        this.az = true;
    }

    public final void afterDrawLabel(int i, GLMapState gLMapState) {
        j();
        com.autonavi.extra.b bVar = this.aX;
        if (bVar != null) {
            bVar.e();
        }
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.bc = this.D.draw(1, this.af, this.i) ? this.bc : this.bc + 1;
        GLMapEngine gLMapEngine2 = this.f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    public final void afterRendererOver(int i, GLMapState gLMapState) {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.D.draw(2, this.af, this.i);
        GLMapEngine gLMapEngine2 = this.f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
        CustomRenderer customRenderer = this.ag;
        if (customRenderer != null) {
            customRenderer.onDrawFrame(null);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
    }

    public final void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        animateCameraWithDurationAndCallback(abstractCameraUpdateMessage, 250L, (AMap.CancelableCallback) null);
    }

    public final void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate, 250L, cancelableCallback);
    }

    public final void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j, AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate.getCameraUpdateFactoryDelegate(), j, cancelableCallback);
    }

    public final void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j, AMap.CancelableCallback cancelableCallback) {
        if (abstractCameraUpdateMessage == null || this.G.get() || this.f == null) {
            return;
        }
        abstractCameraUpdateMessage.mCallback = cancelableCallback;
        abstractCameraUpdateMessage.mDuration = j;
        if (this.H || getMapHeight() == 0 || getMapWidth() == 0) {
            try {
                moveCamera(abstractCameraUpdateMessage);
                if (abstractCameraUpdateMessage.mCallback != null) {
                    abstractCameraUpdateMessage.mCallback.onFinish();
                    return;
                }
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                dw.a(th);
                return;
            }
        }
        try {
            this.f.interruptAnimation();
            resetRenderTime();
            a(abstractCameraUpdateMessage);
            this.f.addMessage(abstractCameraUpdateMessage, true);
        } catch (Throwable th2) {
            dw.a(th2);
            th2.printStackTrace();
        }
    }

    final void b() {
        this.j.obtainMessage(17, 1, 0).sendToTarget();
    }

    public final void b(final int i, final boolean z) {
        if (this.aw && this.ax) {
            resetRenderTime();
            queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.16
                @Override // java.lang.Runnable
                public final void run() {
                    if (l.this.f != null) {
                        if (z) {
                            l.this.f.setAllContentEnable(i, true);
                        } else {
                            l.this.f.setAllContentEnable(i, false);
                        }
                        l.this.f.setSimple3DEnable(i, false);
                    }
                }
            });
            return;
        }
        this.aT.c = z;
        this.aT.b = true;
        this.aT.g = i;
    }

    public final void b(Size size) {
        a(getNativeEngineID(), 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        getGLMapView().setLayoutParams(layoutParams);
        this.C.f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        b(true);
    }

    public final void beforeDrawLabel(int i, GLMapState gLMapState) {
        j();
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.bc = this.D.draw(0, this.af, this.i) ? this.bc : this.bc + 1;
        GLMapEngine gLMapEngine2 = this.f;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    public final void c(final int i, final boolean z) {
        if (this.aw && this.ax) {
            resetRenderTime();
            queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.17
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (z) {
                            l.this.f.setBuildingTextureEnable(i, true);
                        } else {
                            l.this.f.setBuildingTextureEnable(i, false);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        this.aW.c = z;
        this.aW.b = true;
        this.aW.g = i;
    }

    public final Pair<Float, LatLng> calculateZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null && i == i2 && i2 == i3 && i3 == i4 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new Pair<>(Float.valueOf(getMaxZoomLevel()), latLng);
        }
        MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.aw || this.G.get()) {
            DPoint obtain = DPoint.obtain();
            GLMapState.geo2LonLat((int) mapConfig.getSX(), (int) mapConfig.getSY(), obtain);
            Pair<Float, LatLng> pair = new Pair<>(Float.valueOf(mapConfig.getSZ()), new LatLng(obtain.y, obtain.x));
            obtain.recycle();
            return pair;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        GLMapState gLMapState = new GLMapState(this.F, this.f.getNativeInstance());
        Pair<Float, IPoint> a2 = dw.a((IMapConfig) mapConfig, i, i2, i3, i4, builder.build(), getMapWidth(), getMapHeight());
        gLMapState.recycle();
        if (a2 != null) {
            DPoint obtain2 = DPoint.obtain();
            GLMapState.geo2LonLat(((IPoint) a2.second).x, ((IPoint) a2.second).y, obtain2);
            Pair<Float, LatLng> pair2 = new Pair<>(a2.first, new LatLng(obtain2.y, obtain2.x));
            obtain2.recycle();
            return pair2;
        }
        return null;
    }

    public final boolean canShowIndoorSwitch() {
        at atVar;
        if (getZoomLevel() < 17.0f || (atVar = this.c) == null || atVar.g == null) {
            return false;
        }
        FPoint obtain = FPoint.obtain();
        a(this.c.g.x, this.c.g.y, obtain);
        return this.X.contains((int) obtain.x, (int) obtain.y);
    }

    public final boolean canStopMapRender() {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            gLMapEngine.canStopMapRender(this.F);
            return true;
        }
        return true;
    }

    public final void changeGLOverlayIndex() {
        this.D.changeOverlayIndex();
    }

    public final void changeLogoIconStyle(String str, boolean z, int i) {
        eh ehVar = this.C;
        if (ehVar != null) {
            ehVar.a(str, Boolean.valueOf(z), Integer.valueOf(i));
        }
        af afVar = this.z;
        if (afVar != null) {
            afVar.requestRefreshLogo();
        }
    }

    public final void changeMapLogo(int i, boolean z) {
        if (this.G.get()) {
            return;
        }
        try {
            List a2 = this.u.a(AMapWidgetListener.class.hashCode());
            if (a2 == null || a2.size() <= 0) {
                return;
            }
            this.C.g(Boolean.valueOf(!z));
        } catch (Throwable th) {
        }
    }

    public final void changeSize(int i, int i2) {
        MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            this.g = i;
            this.h = i2;
            mapConfig.setMapWidth(i);
            this.b.setMapHeight(i2);
        }
    }

    public final void changeSurface(int i, GL10 gl10, int i2, int i3) {
        WindowManager windowManager;
        String str = dx.c;
        dy.a(str, "changeSurface " + i2 + " " + i3);
        this.az = false;
        if (!this.aw) {
            createSurface(i, gl10, null);
        }
        y yVar = this.ao;
        if (yVar != null && this.e != null && ((this.g != yVar.b() || this.h != this.ao.c()) && (windowManager = (WindowManager) this.e.getSystemService("window")) != null)) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (defaultDisplay != null) {
                defaultDisplay.getRealMetrics(displayMetrics);
                this.ao.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }
        this.g = i2;
        this.h = i3;
        this.X = new Rect(0, 0, i2, i3);
        this.F = a(i, new Rect(0, 0, this.g, this.h), this.g, this.h);
        dy.a(dx.c, "create engine with frame complete");
        if (!this.ax) {
            MapConfig mapConfig = this.b;
            if (mapConfig != null) {
                mapConfig.setMapZoomScale(this.ar);
                this.b.setMapWidth(i2);
                this.b.setMapHeight(i3);
            }
            this.f.setIndoorEnable(this.F, false);
            this.f.setSimple3DEnable(this.F, false);
            this.f.setStyleChangeGradualEnable(this.F, false);
            this.f.initMapOpenLayer("{\"bounds\" : [{\"x2\" : 235405312,\"x1\" : 188874751,\"y2\" : 85065727,\"y1\" : 122421247}],\"sublyr\" : [{\"type\" : 4,\"sid\" : 9000006,\"zlevel\" : 2}],\"id\" : 9006,\"minzoom\" : 6,\"update_period\" : 90,\"maxzoom\" : 20,\"cachemode\" : 2,\"url\" : \"http://mpsapi.amap.com/ws/mps/lyrdata/ugc/\"}");
            GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
            AeUtil.initIntersectionRes(this.e, initParam);
            this.f.setVectorOverlayPath(initParam.mIntersectionResPath);
        }
        synchronized (this) {
            this.ax = true;
        }
        if (this.I) {
            this.b.setAnchorX(Math.max(1, Math.min(this.aC, i2 - 1)));
            this.b.setAnchorY(Math.max(1, Math.min(this.aD, i3 - 1)));
        } else {
            this.b.setAnchorX(i2 >> 1);
            this.b.setAnchorY(i3 >> 1);
        }
        this.f.setProjectionCenter(this.F, this.b.getAnchorX(), this.b.getAnchorY());
        this.a = true;
        if (this.aT.b) {
            this.aT.run();
        }
        if (this.aL.b) {
            this.aL.run();
        }
        if (this.aM.b) {
            this.aM.run();
        }
        if (this.aJ.b) {
            this.aJ.run();
        }
        if (this.aN.b) {
            this.aN.run();
        }
        if (this.aW.b) {
            this.aW.run();
        }
        if (this.aO.b) {
            this.aO.run();
        }
        if (this.aP.b) {
            this.aP.run();
        }
        if (this.aQ.b) {
            this.aQ.run();
        }
        if (this.aU.b) {
            this.aU.run();
        }
        if (this.aK.b) {
            this.aK.run();
        }
        if (this.aR.b) {
            this.aR.run();
        }
        a aVar = this.aS;
        if (aVar != null) {
            aVar.run();
        }
        CustomRenderer customRenderer = this.ag;
        if (customRenderer != null) {
            customRenderer.onSurfaceChanged(gl10, i2, i3);
        }
        com.autonavi.extra.b bVar = this.aX;
        if (bVar != null) {
            bVar.d();
        }
        Handler handler = this.j;
        if (handler != null) {
            handler.post(this.aV);
        }
        redrawInfoWindow();
    }

    public final void changeSurface(GL10 gl10, int i, int i2) {
        try {
            changeSurface(1, gl10, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            dw.a(th);
        }
    }

    public final void checkMapState(IGLMapState iGLMapState) {
        if (this.b == null || this.G.get()) {
            return;
        }
        LatLngBounds limitLatLngBounds = this.b.getLimitLatLngBounds();
        try {
            if (limitLatLngBounds == null) {
                if (this.b.isSetLimitZoomLevel()) {
                    iGLMapState.setMapZoomer(Math.max(this.b.getMinZoomLevel(), Math.min(iGLMapState.getMapZoomer(), this.b.getMaxZoomLevel())));
                    return;
                }
                return;
            }
            IPoint[] limitIPoints = this.b.getLimitIPoints();
            IPoint[] iPointArr = limitIPoints;
            if (limitIPoints == null) {
                IPoint obtain = IPoint.obtain();
                GLMapState.lonlat2Geo(limitLatLngBounds.northeast.longitude, limitLatLngBounds.northeast.latitude, obtain);
                IPoint obtain2 = IPoint.obtain();
                GLMapState.lonlat2Geo(limitLatLngBounds.southwest.longitude, limitLatLngBounds.southwest.latitude, obtain2);
                iPointArr = new IPoint[2];
                iPointArr[0] = obtain;
                iPointArr[1] = obtain2;
                this.b.setLimitIPoints(iPointArr);
            }
            float a2 = dw.a((IMapConfig) this.b, iPointArr[0].x, iPointArr[0].y, iPointArr[1].x, iPointArr[1].y, getMapWidth(), getMapHeight());
            float mapZoomer = iGLMapState.getMapZoomer();
            if (this.b.isSetLimitZoomLevel()) {
                float maxZoomLevel = this.b.getMaxZoomLevel();
                float minZoomLevel = this.b.getMinZoomLevel();
                a2 = a2 > maxZoomLevel ? maxZoomLevel : Math.max(a2, Math.min(mapZoomer, maxZoomLevel));
                if (a2 < minZoomLevel) {
                    a2 = minZoomLevel;
                }
            } else if (a2 <= 0.0f || mapZoomer >= a2) {
                a2 = mapZoomer;
            }
            iGLMapState.setMapZoomer(a2);
            IPoint obtain3 = IPoint.obtain();
            iGLMapState.getMapGeoCenter(obtain3);
            int[] a3 = dw.a(iPointArr[0].x, iPointArr[0].y, iPointArr[1].x, iPointArr[1].y, (IMapConfig) this.b, iGLMapState, obtain3.x, obtain3.y);
            iGLMapState.setMapGeoCenter(a3[0], a3[1]);
            obtain3.recycle();
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final float checkZoomLevel(float f) throws RemoteException {
        return dw.a((IMapConfig) this.b, f);
    }

    public final void clear() throws RemoteException {
        try {
            clear(false);
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImp", "clear");
            dw.a(th);
            th.printStackTrace();
        }
    }

    public final void clear(boolean z) throws RemoteException {
        try {
            hideInfoWindow();
            String str = null;
            String str2 = "";
            if (this.K != null) {
                if (z) {
                    str = this.K.d();
                    str2 = this.K.e();
                } else {
                    this.K.f();
                    str2 = "";
                    str = null;
                }
            }
            this.D.clear(str, str2);
            queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.19
                @Override // java.lang.Runnable
                public final void run() {
                    if (l.this.f == null || l.this.G.get()) {
                        return;
                    }
                    l.this.f.removeNativeAllOverlay(l.this.F);
                }
            });
            resetRenderTime();
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImp", "clear");
            dw.a(th);
            th.printStackTrace();
        }
    }

    public final void clearTileCache() {
        this.D.clearTileCache();
    }

    public final long createGLOverlay(int i) {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.createOverlay(this.F, i);
        }
        return 0L;
    }

    public final String createId(String str) {
        IGlOverlayLayer iGlOverlayLayer = this.D;
        if (iGlOverlayLayer != null) {
            return iGlOverlayLayer.createId(str);
        }
        return null;
    }

    public final void createSurface(int i, GL10 gl10, EGLConfig eGLConfig) {
        synchronized (this) {
            dy.a(dx.c, "createSurface");
            this.aI = System.currentTimeMillis();
            if (this.Y == 3) {
                this.C.d().a(ec.b);
            } else {
                this.C.d().a(ec.a);
            }
            this.ax = false;
            this.g = this.B.getWidth();
            this.h = this.B.getHeight();
            this.az = false;
            AeUtil.loadLib(this.e);
            dy.a(dx.c, "load lib complete");
            AeUtil.initCrashHandle(this.e);
            GLMapEngine.InitParam initResource = AeUtil.initResource(this.e);
            dy.a(dx.c, "load res complete");
            this.f.createAMapInstance(initResource);
            dy.a(dx.c, "create engine complete");
            this.aF = new cp();
            dy.a(dx.c, "init shader complete");
            if (this.aX != null) {
                this.aX.i();
            }
            this.aw = true;
            this.l = gl10.glGetString(GL10.GL_RENDERER);
            GLMapState mapState = this.f.getMapState(this.F);
            if (mapState != null && mapState.getNativeInstance() != 0) {
                mapState.setMapGeoCenter((int) this.b.getSX(), (int) this.b.getSY());
                mapState.setMapAngle(this.b.getSR());
                mapState.setMapZoomer(this.b.getSZ());
                mapState.setCameraDegree(this.b.getSC());
            }
            n();
            if (MapsInitializer.isTerrainEnable() && this.ac == null) {
                v vVar = new v(this.e, this);
                this.ac = vVar;
                vVar.a(0L);
            }
            if (this.ag != null) {
                this.ag.onSurfaceCreated(gl10, eGLConfig);
            }
            if (this.aX != null) {
                this.aX.c();
            }
            this.D.onCreateAMapInstance();
        }
    }

    public final void createSurface(GL10 gl10, EGLConfig eGLConfig) {
        try {
            this.am = Thread.currentThread().getId();
        } catch (Throwable th) {
            th.printStackTrace();
            dw.a(th);
        }
        try {
            createSurface(1, gl10, eGLConfig);
        } catch (Throwable th2) {
            th2.printStackTrace();
            dw.a(th2);
        }
    }

    public final void destroy() {
        this.G.set(true);
        dy.a(dx.c, "destroy map");
        try {
            if (this.L != null) {
                this.L.deactivate();
            }
            this.L = null;
            this.aE = null;
            if (this.an != null) {
                this.an.renderPause();
            }
            if (this.D != null) {
                this.D.destroy();
            }
            h();
            if (this.aa != null) {
                this.aa.interrupt();
                this.aa = null;
            }
            if (this.ab != null) {
                this.ab.interrupt();
                this.ab = null;
            }
            if (this.ac != null) {
                this.ac.a();
                this.ac = null;
            }
            if (this.ak != null) {
                this.ak.a();
                this.ak = null;
            }
            if (this.al != null) {
                this.al.a((ct.a) null);
                this.al.a();
                this.al = null;
            }
            dk.b();
            if (this.f != null) {
                this.f.setMapListener((IAMapListener) null);
                this.f.releaseNetworkState();
                queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.33
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l.this.destroySurface(l.this.F);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            dw.a(th);
                        }
                    }
                });
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (this.f == null || i2 >= 50) {
                        break;
                    }
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e) {
                        dw.a(e);
                    }
                    i = i2 + 1;
                }
            }
            if (this.B != null) {
                try {
                    this.B.onDetachedGLThread();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    dw.a(e2);
                }
            }
            if (this.C != null) {
                this.C.g();
                this.C = null;
            }
            if (this.K != null) {
                this.K.c();
                this.K = null;
            }
            this.L = null;
            this.t = null;
            q();
            this.Z = null;
            dy.a();
            iw.b();
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImp", "destroy");
            dw.a(th);
            th.printStackTrace();
        }
    }

    public final void destroySurface(int i) {
        this.aA.lock();
        try {
            if (this.aw) {
                EGL14.eglGetCurrentContext();
                EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
                r();
                if (this.f != null) {
                    if (this.f.getOverlayBundle(this.F) != null) {
                        this.f.getOverlayBundle(this.F).removeAll(true);
                    }
                    this.f.destroyAMapEngine();
                    this.f = null;
                    if (this.bc > 0) {
                        dt.a(this.e, this.bc);
                    }
                    dy.a(dx.c, "destroy engine complete");
                }
                if (this.aX != null) {
                    this.aX.f();
                }
            }
            this.aw = false;
            this.ax = false;
            this.az = false;
        } catch (Throwable th) {
            try {
                dw.a(th);
            } finally {
                this.aA.unlock();
            }
        }
    }

    public final void drawFrame(GL10 gl10) {
        if (this.G.get() || this.f == null || EGL14.eglGetCurrentContext() == EGL14.EGL_NO_CONTEXT) {
            return;
        }
        MapConfig mapConfig = this.b;
        if (mapConfig != null && !mapConfig.isMapEnable()) {
            GLES20.glClear(16640);
            return;
        }
        a(this.F);
        this.f.renderAMap();
        this.f.pushRendererState();
        k kVar = this.aH;
        if (kVar != null) {
            kVar.a();
        }
        i();
        k();
        if (!this.ay) {
            this.ay = true;
        }
        this.f.popRendererState();
        if (dn.a()) {
            try {
                if (this.B instanceof o) {
                    if (this.d == null) {
                        this.d = new dn();
                    }
                    this.d.e();
                    if (!this.d.f() || this.d.d()) {
                        return;
                    }
                    if (this.d.a(((o) this.B).getBitmap())) {
                        if (dn.b()) {
                            removecache();
                        }
                        if (dn.c()) {
                            dn.g();
                        }
                        dy.b(dx.g, "pure screen: found pure check");
                    }
                }
            } catch (Throwable th) {
                iw.c(th, "AMapDelegateImp", "PureScreenCheckTool.checkBlackScreen");
            }
        }
    }

    public final void geo2Latlng(int i, int i2, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i, i2, 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        pixelsToLatLong.recycle();
    }

    public final void geo2Map(int i, int i2, FPoint fPoint) {
        fPoint.x = (int) (i - this.b.getSX());
        fPoint.y = (int) (i2 - this.b.getSY());
    }

    public final com.autonavi.extra.b getAMapExtraInterfaceManager() {
        return this.aX;
    }

    public final Projection getAMapProjection() throws RemoteException {
        return new Projection(this.y);
    }

    public final UiSettings getAMapUiSettings() throws RemoteException {
        if (this.x == null) {
            this.x = new UiSettings(this.z);
        }
        return this.x;
    }

    public final AMapCameraInfo getCamerInfo() {
        return null;
    }

    public final float getCameraAngle() {
        return getCameraDegree(this.F);
    }

    public final float getCameraDegree(int i) {
        MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            return mapConfig.getSC();
        }
        return 0.0f;
    }

    public final CameraPosition getCameraPosition() throws RemoteException {
        return getCameraPositionPrj(this.I);
    }

    public final CameraPosition getCameraPositionPrj(boolean z) {
        LatLng g;
        try {
            if (this.b == null) {
                return null;
            }
            if (!this.aw || this.H || this.f == null) {
                DPoint obtain = DPoint.obtain();
                geo2Latlng((int) this.b.getSX(), (int) this.b.getSY(), obtain);
                LatLng latLng = new LatLng(obtain.y, obtain.x);
                obtain.recycle();
                return CameraPosition.builder().target(latLng).bearing(this.b.getSR()).tilt(this.b.getSC()).zoom(this.b.getSZ()).build();
            }
            if (z) {
                DPoint obtain2 = DPoint.obtain();
                getPixel2LatLng(this.b.getAnchorX(), this.b.getAnchorY(), obtain2);
                g = new LatLng(obtain2.y, obtain2.x, false);
                obtain2.recycle();
            } else {
                g = g();
            }
            return CameraPosition.builder().target(g).bearing(this.b.getSR()).tilt(this.b.getSC()).zoom(this.b.getSZ()).build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Context getContext() {
        return this.e;
    }

    public final String getCurrentWorldVectorMapStyle() {
        try {
            if (this.aX != null) {
                Object j = this.aX.j();
                return j instanceof String ? (String) j : "";
            }
            return "";
        } catch (Throwable th) {
            dw.a(th);
            return "";
        }
    }

    public final k getCustomStyleManager() {
        return this.aH;
    }

    public final int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        GLMapEngine gLMapEngine = this.f;
        return gLMapEngine != null ? gLMapEngine.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo) : this.F;
    }

    public final float[] getFinalMatrix() {
        MapConfig mapConfig = this.b;
        return mapConfig != null ? mapConfig.getMvpMatrix() : this.m;
    }

    public final GLMapEngine getGLMapEngine() {
        return this.f;
    }

    public final View getGLMapView() {
        View view = this.B;
        if (view instanceof View) {
            return view;
        }
        return null;
    }

    public final void getGeoCenter(int i, IPoint iPoint) {
        MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            iPoint.x = (int) mapConfig.getSX();
            iPoint.y = (int) this.b.getSY();
        }
    }

    public final IGlOverlayLayer getGlOverlayLayer() {
        return this.D;
    }

    public final long getGlOverlayMgrPtr() {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.getGlOverlayMgrPtr(this.F);
        }
        return 0L;
    }

    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return null;
    }

    public final au getInfoWindowDelegate() {
        return this.w;
    }

    public final void getLatLng2Map(double d2, double d3, FPoint fPoint) {
        IPoint obtain = IPoint.obtain();
        latlon2Geo(d2, d3, obtain);
        geo2Map(obtain.x, obtain.y, fPoint);
        obtain.recycle();
    }

    public final void getLatLng2Pixel(double d2, double d3, IPoint iPoint) {
        if (this.G.get() || !this.aw || this.f == null) {
            return;
        }
        try {
            Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d3, 20);
            FPoint obtain = FPoint.obtain();
            a(latLongToPixels.x, latLongToPixels.y, obtain);
            if (obtain.x == -10000.0f && obtain.y == -10000.0f) {
                GLMapState newMapState = this.f.getNewMapState(this.F);
                newMapState.setCameraDegree(0.0f);
                newMapState.recalculate();
                newMapState.p20ToScreenPoint(latLongToPixels.x, latLongToPixels.y, obtain);
                newMapState.recycle();
            }
            iPoint.x = (int) obtain.x;
            iPoint.y = (int) obtain.y;
            obtain.recycle();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void getLatLngRect(DPoint[] dPointArr) {
        try {
            Rectangle geoRectangle = this.b.getGeoRectangle();
            if (geoRectangle == null) {
                return;
            }
            IPoint[] clipRect = geoRectangle.getClipRect();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 4) {
                    return;
                }
                GLMapState.geo2LonLat(clipRect[i2].x, clipRect[i2].y, dPointArr[i2]);
                i = i2 + 1;
            }
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final float getLogoMarginRate(int i) {
        eh ehVar = this.C;
        if (ehVar != null) {
            return ehVar.a(i);
        }
        return 0.0f;
    }

    public final int getLogoPosition() {
        try {
            return this.z.getLogoPosition();
        } catch (RemoteException e) {
            iw.c(e, "AMapDelegateImp", "getLogoPosition");
            e.printStackTrace();
            return 0;
        }
    }

    public final Handler getMainHandler() {
        return this.j;
    }

    public final float getMapAngle(int i) {
        MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            return mapConfig.getSR();
        }
        return 0.0f;
    }

    public final LatLngBounds getMapBounds(LatLng latLng, float f, float f2, float f3) {
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.G.get()) {
            return null;
        }
        float a2 = dw.a((IMapConfig) this.b, f);
        GLMapState gLMapState = new GLMapState(this.F, this.f.getNativeInstance());
        if (latLng != null) {
            IPoint obtain = IPoint.obtain();
            latlon2Geo(latLng.latitude, latLng.longitude, obtain);
            gLMapState.setCameraDegree(f3);
            gLMapState.setMapAngle(f2);
            gLMapState.setMapGeoCenter(obtain.x, obtain.y);
            gLMapState.setMapZoomer(a2);
            gLMapState.recalculate();
            obtain.recycle();
        }
        DPoint obtain2 = DPoint.obtain();
        a(gLMapState, 0, 0, obtain2);
        LatLng latLng2 = new LatLng(obtain2.y, obtain2.x, false);
        a(gLMapState, mapWidth, mapHeight, obtain2);
        LatLng latLng3 = new LatLng(obtain2.y, obtain2.x, false);
        obtain2.recycle();
        gLMapState.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    public final MapConfig getMapConfig() {
        return this.b;
    }

    public final String getMapContentApprovalNumber() {
        MapConfig mapConfig = this.b;
        if (mapConfig == null || mapConfig.isCustomStyleEnable()) {
            return null;
        }
        dt.d(this.e);
        String a2 = dm.a(this.e, "approval_number", "mc", "");
        return !TextUtils.isEmpty(a2) ? a2 : "GS(2021)5875号 | GS(2020)2189号";
    }

    public final int getMapHeight() {
        return this.h;
    }

    public final void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        try {
            this.u.a(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()), (Integer) onmapprintscreenlistener);
            this.U = 20;
            this.V = true;
            resetRenderTime();
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final GLMapState getMapProjection() {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.getMapState(this.F);
        }
        return null;
    }

    public final List<Marker> getMapScreenMarkers() throws RemoteException {
        if (dw.a(getMapWidth(), getMapHeight()) && !this.G.get()) {
            return this.D.getMapScreenMarkers();
        }
        return new ArrayList();
    }

    public final void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener, boolean z) {
        try {
            this.u.a(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()), (Integer) onMapScreenShotListener);
            this.U = 20;
            this.V = z;
            resetRenderTime();
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final int getMapTextZIndex() throws RemoteException {
        return this.af;
    }

    public final int getMapType() throws RemoteException {
        return this.Y;
    }

    public final int getMapWidth() {
        return this.g;
    }

    public final float getMapZoomScale() {
        return this.ar;
    }

    public final int getMaskLayerType() {
        return this.ah;
    }

    public final float getMaxZoomLevel() {
        try {
            if (this.b != null) {
                return this.b.getMaxZoomLevel();
            }
            return 20.0f;
        } catch (Throwable th) {
            dw.a(th);
            return 20.0f;
        }
    }

    public final float getMinZoomLevel() {
        try {
            if (this.b != null) {
                return this.b.getMinZoomLevel();
            }
            return 3.0f;
        } catch (Throwable th) {
            dw.a(th);
            return 3.0f;
        }
    }

    public final Location getMyLocation() throws RemoteException {
        if (this.L != null) {
            return this.t.a;
        }
        return null;
    }

    public final MyLocationStyle getMyLocationStyle() throws RemoteException {
        ck ckVar = this.K;
        if (ckVar != null) {
            return ckVar.a();
        }
        return null;
    }

    public final int getNativeEngineID() {
        return this.F;
    }

    public final long getNativeMapController() {
        GLMapEngine gLMapEngine = this.f;
        if (gLMapEngine != null) {
            return gLMapEngine.getNativeMapController(this.F);
        }
        return 0L;
    }

    public final AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException {
        try {
            List a2 = this.u.a(AMap.OnCameraChangeListener.class.hashCode());
            if (a2 != null || a2.size() == 0) {
                return null;
            }
            return (AMap.OnCameraChangeListener) a2.get(0);
        } catch (Throwable th) {
            return null;
        }
    }

    public final void getPixel2Geo(int i, int i2, IPoint iPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.G.get() || !this.aw || (gLMapEngine = this.f) == null || (mapState = gLMapEngine.getMapState(this.F)) == null) {
            return;
        }
        mapState.screenToP20Point(i, i2, iPoint);
    }

    public final void getPixel2LatLng(int i, int i2, DPoint dPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.G.get() || !this.aw || (gLMapEngine = this.f) == null || (mapState = gLMapEngine.getMapState(this.F)) == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        mapState.screenToP20Point(i, i2, obtain);
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(obtain.x, obtain.y, 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        obtain.recycle();
        pixelsToLatLong.recycle();
    }

    public final float getPreciseLevel(int i) {
        MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            return mapConfig.getSZ();
        }
        return 0.0f;
    }

    public final IProjectionDelegate getProjection() throws RemoteException {
        return this.y;
    }

    public final float[] getProjectionMatrix() {
        MapConfig mapConfig = this.b;
        return mapConfig != null ? mapConfig.getProjectionMatrix() : this.o;
    }

    public final Rect getRect() {
        return this.X;
    }

    public final int getRenderMode() {
        return this.B.getRenderMode();
    }

    public final int getSX() {
        MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            return (int) mapConfig.getSX();
        }
        return -1;
    }

    public final int getSY() {
        MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            return (int) mapConfig.getSY();
        }
        return -1;
    }

    public final String getSatelliteImageApprovalNumber() {
        dt.e(this.e);
        String a2 = dm.a(this.e, "approval_number", "si", "");
        return !TextUtils.isEmpty(a2) ? a2 : "GS(2021)1328号";
    }

    public final float getScalePerPixel() throws RemoteException {
        try {
            return ((float) ((((Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, getZoomLevel()) * 256.0d))) * getMapZoomScale();
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImp", "getScalePerPixel");
            dw.a(th);
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final float getSkyHeight() {
        return this.b.getSkyHeight();
    }

    public final String getTerrainApprovalNumber() {
        dt.f(this.e);
        String a2 = dm.a(this.e, "approval_number", "te", "");
        return !TextUtils.isEmpty(a2) ? a2 : "GS(2021)6352号";
    }

    public final IUiSettingsDelegate getUiSettings() {
        return this.z;
    }

    public final float getUnitLengthByZoom(int i) {
        GLMapState gLMapState = new GLMapState(this.F, this.f.getNativeInstance());
        gLMapState.setMapZoomer(i);
        gLMapState.recalculate();
        float gLUnitWithWin = gLMapState.getGLUnitWithWin(1);
        gLMapState.recycle();
        return gLUnitWithWin;
    }

    public final View getView() throws RemoteException {
        eh ehVar = this.C;
        if (ehVar != null) {
            return ehVar.j();
        }
        return null;
    }

    public final float[] getViewMatrix() {
        MapConfig mapConfig = this.b;
        return mapConfig != null ? mapConfig.getViewMatrix() : this.n;
    }

    public final Point getWaterMarkerPositon() {
        eh ehVar = this.C;
        return ehVar != null ? ehVar.a() : new Point();
    }

    public final String getWorldVectorMapLanguage() {
        return this.aY;
    }

    public final String getWorldVectorMapStyle() {
        return this.aZ;
    }

    public final float getZoomLevel() {
        return c();
    }

    public final float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        try {
            MapConfig mapConfig = getMapConfig();
            if (latLng == null || latLng2 == null || !this.aw || this.G.get()) {
                return mapConfig.getSZ();
            }
            Pair<Float, IPoint> a2 = dw.a((IMapConfig) mapConfig, 0, 0, 0, 0, new LatLngBounds.Builder().include(latLng).include(latLng2).build(), getMapWidth(), getMapHeight());
            if (a2 != null) {
                return ((Float) a2.first).floatValue();
            }
            GLMapState gLMapState = new GLMapState(this.F, this.f.getNativeInstance());
            float mapZoomer = gLMapState.getMapZoomer();
            gLMapState.recycle();
            return mapZoomer;
        } catch (Throwable th) {
            dw.a(th);
            return 0.0f;
        }
    }

    public final void hideInfoWindow() {
        au auVar = this.w;
        if (auVar != null) {
            auVar.c();
        }
    }

    public final boolean isIndoorEnabled() throws RemoteException {
        return this.b.isIndoorEnable();
    }

    public final boolean isLockMapAngle(int i) {
        return g(i);
    }

    public final boolean isLockMapCameraDegree(int i) {
        return false;
    }

    public final boolean isMaploaded() {
        return this.J;
    }

    public final boolean isMyLocationEnabled() throws RemoteException {
        return this.E;
    }

    public final boolean isTouchPoiEnable() {
        MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            return mapConfig.isTouchPoiEnable();
        }
        return true;
    }

    public final boolean isTrafficEnabled() throws RemoteException {
        return this.b.isTrafficEnabled();
    }

    public final boolean isUseAnchor() {
        return this.I;
    }

    public final void latlon2Geo(double d2, double d3, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d3, 20);
        iPoint.x = latLongToPixels.x;
        iPoint.y = latLongToPixels.y;
    }

    public final void loadWorldVectorMap(boolean z) {
        MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            mapConfig.setAbroadEnable(z);
        }
    }

    public final void map2Geo(float f, float f2, IPoint iPoint) {
        iPoint.x = (int) (f + this.b.getSX());
        iPoint.y = (int) (f2 + this.b.getSY());
    }

    public final void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        try {
            moveCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        if (this.f == null || this.G.get()) {
            return;
        }
        AbstractCameraUpdateMessage abstractCameraUpdateMessage2 = abstractCameraUpdateMessage;
        try {
            if (this.H) {
                abstractCameraUpdateMessage2 = abstractCameraUpdateMessage;
                if (this.f.getStateMessageCount() > 0) {
                    abstractCameraUpdateMessage2 = ak.c();
                    abstractCameraUpdateMessage2.nowType = AbstractCameraUpdateMessage.Type.changeGeoCenterZoomTiltBearing;
                    abstractCameraUpdateMessage2.geoPoint = new DPoint(this.b.getSX(), this.b.getSY());
                    abstractCameraUpdateMessage2.zoom = this.b.getSZ();
                    abstractCameraUpdateMessage2.bearing = this.b.getSR();
                    abstractCameraUpdateMessage2.tilt = this.b.getSC();
                    this.f.addMessage(abstractCameraUpdateMessage, false);
                    while (this.f.getStateMessageCount() > 0) {
                        AbstractCameraUpdateMessage stateMessage = this.f.getStateMessage();
                        if (stateMessage != null) {
                            stateMessage.mergeCameraUpdateDelegate(abstractCameraUpdateMessage2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            dw.a(th);
            abstractCameraUpdateMessage2 = abstractCameraUpdateMessage;
        }
        resetRenderTime();
        this.f.clearAnimations(this.F, false);
        abstractCameraUpdateMessage2.isChangeFinished = true;
        a(abstractCameraUpdateMessage2);
        this.f.addMessage(abstractCameraUpdateMessage2, false);
    }

    public final void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam) {
        q qVar = this.u;
        if (qVar == null) {
            return;
        }
        for (AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener : qVar.a(AMap.AMapAppResourceRequestListener.class.hashCode())) {
            if (aMapAppResourceRequestListener != null) {
                aMapAppResourceRequestListener.onRequest(aMapAppRequestParam);
            }
        }
    }

    public final void onActivityPause() {
        this.H = true;
        c(this.F);
    }

    public final void onActivityResume() {
        this.H = false;
        d(this.F);
    }

    public final void onChangeFinish() {
        Message obtainMessage = this.j.obtainMessage();
        obtainMessage.what = 11;
        this.j.sendMessage(obtainMessage);
    }

    public final boolean onDoubleTap(int i, MotionEvent motionEvent) {
        if (this.aw) {
            a((int) motionEvent.getX(), (int) motionEvent.getY());
            return false;
        }
        return false;
    }

    public final void onFling() {
        IGlOverlayLayer iGlOverlayLayer = this.D;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(true);
        }
        this.T = true;
    }

    public final void onIndoorBuildingActivity(int i, byte[] bArr) {
        at atVar;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    at atVar2 = new at();
                    byte b2 = bArr[0];
                    atVar2.a = new String(bArr, 1, b2, "utf-8");
                    int i2 = b2 + 1;
                    int i3 = i2 + 1;
                    byte b3 = bArr[i2];
                    atVar2.b = new String(bArr, i3, b3, "utf-8");
                    int i4 = i3 + b3;
                    int i5 = i4 + 1;
                    byte b4 = bArr[i4];
                    atVar2.activeFloorName = new String(bArr, i5, b4, "utf-8");
                    int i6 = i5 + b4;
                    atVar2.activeFloorIndex = GLConvertUtil.getInt(bArr, i6);
                    int i7 = i6 + 4;
                    int i8 = i7 + 1;
                    byte b5 = bArr[i7];
                    atVar2.poiid = new String(bArr, i8, b5, "utf-8");
                    int i9 = i8 + b5;
                    int i10 = i9 + 1;
                    byte b6 = bArr[i9];
                    atVar2.h = new String(bArr, i10, b6, "utf-8");
                    int i11 = i10 + b6;
                    atVar2.c = GLConvertUtil.getInt(bArr, i11);
                    int i12 = i11 + 4;
                    atVar2.floor_indexs = new int[atVar2.c];
                    atVar2.floor_names = new String[atVar2.c];
                    atVar2.d = new String[atVar2.c];
                    int i13 = 0;
                    while (true) {
                        int i14 = i13;
                        if (i14 >= atVar2.c) {
                            break;
                        }
                        atVar2.floor_indexs[i14] = GLConvertUtil.getInt(bArr, i12);
                        int i15 = i12 + 4;
                        int i16 = i15 + 1;
                        byte b7 = bArr[i15];
                        int i17 = i16;
                        if (b7 > 0) {
                            atVar2.floor_names[i14] = new String(bArr, i16, b7, "utf-8");
                            i17 = i16 + b7;
                        }
                        int i18 = i17 + 1;
                        byte b8 = bArr[i17];
                        i12 = i18;
                        if (b8 > 0) {
                            atVar2.d[i14] = new String(bArr, i18, b8, "utf-8");
                            i12 = i18 + b8;
                        }
                        i13 = i14 + 1;
                    }
                    atVar2.e = GLConvertUtil.getInt(bArr, i12);
                    int i19 = i12 + 4;
                    atVar = atVar2;
                    if (atVar2.e > 0) {
                        atVar2.f = new int[atVar2.e];
                        int i20 = 0;
                        while (true) {
                            int i21 = i20;
                            atVar = atVar2;
                            if (i21 >= atVar2.e) {
                                break;
                            }
                            atVar2.f[i21] = GLConvertUtil.getInt(bArr, i19);
                            i19 += 4;
                            i20 = i21 + 1;
                        }
                    }
                    this.bf = atVar;
                    post(new Runnable() { // from class: com.amap.api.col.3sl.l.31
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (l.this.aE != null) {
                                l.this.aE.a(l.this.bf);
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                dw.a(th);
                th.printStackTrace();
                return;
            }
        }
        atVar = null;
        this.bf = atVar;
        post(new Runnable() { // from class: com.amap.api.col.3sl.l.31
            @Override // java.lang.Runnable
            public final void run() {
                if (l.this.aE != null) {
                    l.this.aE.a(l.this.bf);
                }
            }
        });
    }

    public final void onLongPress(int i, MotionEvent motionEvent) {
        try {
            this.Q = false;
            b(i);
            BaseOverlay hitBaseOverlay = this.D.getHitBaseOverlay(motionEvent, 1);
            if (hitBaseOverlay instanceof Marker) {
                this.P = (Marker) hitBaseOverlay;
            }
            if (this.P == null || !this.P.isDraggable()) {
                List a2 = this.u.a(AMap.OnMapLongClickListener.class.hashCode());
                if (a2 != null && a2.size() > 0) {
                    DPoint obtain = DPoint.obtain();
                    getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                    synchronized (a2) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= a2.size()) {
                                break;
                            }
                            ((AMap.OnMapLongClickListener) a2.get(i3)).onMapLongClick(new LatLng(obtain.y, obtain.x));
                            i2 = i3 + 1;
                        }
                    }
                    this.R = true;
                    obtain.recycle();
                }
            } else {
                LatLng position = this.P.getPosition();
                if (position != null) {
                    IPoint obtain2 = IPoint.obtain();
                    getLatLng2Pixel(position.latitude, position.longitude, obtain2);
                    obtain2.y -= 60;
                    DPoint obtain3 = DPoint.obtain();
                    getPixel2LatLng(obtain2.x, obtain2.y, obtain3);
                    this.P.setPosition(new LatLng(obtain3.y, obtain3.x));
                    this.D.set2Top(this.P.getId());
                    List a3 = this.u.a(AMap.OnMarkerDragListener.class.hashCode());
                    if (a3 != null && a3.size() > 0) {
                        synchronized (a3) {
                            int i4 = 0;
                            while (true) {
                                int i5 = i4;
                                if (i5 >= a3.size()) {
                                    break;
                                }
                                ((AMap.OnMarkerDragListener) a3.get(i5)).onMarkerDragStart(this.P);
                                i4 = i5 + 1;
                            }
                        }
                    }
                    this.M = true;
                    obtain2.recycle();
                    obtain3.recycle();
                }
            }
            this.an.resetTickCount(30);
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImp", "onLongPress");
            th.printStackTrace();
        }
    }

    public final void onMapBlankClick(double d2, double d3) {
        a(d2, d3);
    }

    public final void onMapPOIClick(MapPoi mapPoi) {
        List a2 = this.u.a(AMap.OnPOIClickListener.class.hashCode());
        if (a2 == null || a2.size() <= 0 || mapPoi == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 20;
        obtain.obj = new Poi(mapPoi.getName(), new LatLng(mapPoi.getLatitude(), mapPoi.getLongitude()), mapPoi.getPoiid());
        this.j.sendMessage(obtain);
    }

    public final void onPause() {
        f();
        IGlOverlayLayer iGlOverlayLayer = this.D;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(false);
        }
    }

    public final void onResume() {
        try {
            this.an.setRenderFps(15.0f);
            this.B.setRenderMode(0);
            if (this.D != null) {
                this.D.setFlingState(true);
            }
            if (this.K != null) {
                this.K.b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean onSingleTapConfirmed(int i, MotionEvent motionEvent) {
        if (this.aw) {
            try {
                b(i);
                if (f(motionEvent) || d(motionEvent) || e(motionEvent)) {
                    return true;
                }
                c(motionEvent);
                b(motionEvent);
                return true;
            } catch (Throwable th) {
                iw.c(th, "AMapDelegateImp", "onSingleTapUp");
                th.printStackTrace();
                return true;
            }
        }
        return false;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.H && this.aw && this.at) {
            this.bd.mGestureState = 3;
            this.bd.mGestureType = 8;
            this.bd.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            getEngineIDWithGestureInfo(this.bd);
            l();
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                m();
                d();
            } else if (action == 1) {
                e();
            }
            if (motionEvent.getAction() == 2 && this.M) {
                try {
                    a(motionEvent);
                    return true;
                } catch (Throwable th) {
                    iw.c(th, "AMapDelegateImp", "onDragMarker");
                    th.printStackTrace();
                    return true;
                }
            }
            if (this.ap) {
                try {
                    this.ao.a(motionEvent);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                List a2 = this.u.a(AMap.OnMapTouchListener.class.hashCode());
                if (a2 == null || a2.size() <= 0) {
                    return true;
                }
                this.j.removeMessages(14);
                Message obtainMessage = this.j.obtainMessage();
                obtainMessage.what = 14;
                obtainMessage.obj = MotionEvent.obtain(motionEvent);
                obtainMessage.sendToTarget();
                return true;
            } catch (Throwable th3) {
                return true;
            }
        }
        return false;
    }

    public final void pixel2Map(int i, int i2, PointF pointF) {
        if (!this.aw || this.H || this.f == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        getPixel2Geo(i, i2, obtain);
        pointF.x = obtain.x - ((float) this.b.getSX());
        pointF.y = obtain.y - ((float) this.b.getSY());
        obtain.recycle();
    }

    public final void post(Runnable runnable) {
        IGLSurfaceView iGLSurfaceView = this.B;
        if (iGLSurfaceView != null) {
            iGLSurfaceView.post(runnable);
        }
    }

    public final void queueEvent(Runnable runnable) {
        try {
            long id = Thread.currentThread().getId();
            if (id != -1 && id == this.am) {
                runnable.run();
            } else if (this.f != null) {
                this.B.queueEvent(runnable);
            }
        }
    }

    public final void redrawInfoWindow() {
        if (!this.G.get() && this.aw) {
            this.j.sendEmptyMessage(18);
        }
    }

    public final void refreshLogo() {
        eh ehVar = this.C;
        if (ehVar != null) {
            ehVar.c();
        }
    }

    public final void reloadMap() {
    }

    public final void reloadMapCustomStyle() {
        k kVar = this.aH;
        if (kVar != null) {
            kVar.b();
        }
    }

    public final void removeAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        q qVar = this.u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), aMapAppResourceRequestListener);
        }
    }

    public final void removeEngineGLOverlay(final BaseMapOverlay baseMapOverlay) {
        if (this.f != null) {
            queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.35
                @Override // java.lang.Runnable
                public final void run() {
                    l.this.f.getOverlayBundle(l.this.F).removeOverlay(baseMapOverlay);
                }
            });
        }
    }

    public final boolean removeGLModel(String str) {
        try {
            this.D.removeOverlay(str);
            return false;
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImp", "removeGLModel");
            th.printStackTrace();
            return false;
        }
    }

    public final boolean removeGLOverlay(String str) throws RemoteException {
        resetRenderTime();
        return this.D.removeOverlay(str);
    }

    public final void removeOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    public final void removeOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    public final void removeOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    public final void removeOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    public final void removeOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        q qVar = this.u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    public final void removeOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    public final void removeOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    public final void removeOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    public final void removeOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        q qVar = this.u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    public final void removeOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    public final void removeOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    public final void removeOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.b(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    public final void removecache() throws RemoteException {
        removecache(null);
    }

    public final void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException {
        if (this.j == null || this.f == null) {
            return;
        }
        try {
            d dVar = new d(this.e, onCacheRemoveListener);
            this.j.removeCallbacks(dVar);
            this.j.post(dVar);
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImp", "removecache");
            th.printStackTrace();
            dw.a(th);
        }
    }

    public final void renderSurface(GL10 gl10) {
        drawFrame(gl10);
    }

    public final void requestRender() {
        GLMapRender gLMapRender = this.an;
        if (gLMapRender == null || gLMapRender.isRenderPause()) {
            return;
        }
        this.B.requestRender();
    }

    public final void resetMinMaxZoomPreference() {
        List a2;
        this.b.resetMinMaxZoomPreference();
        try {
            if (!this.z.isZoomControlsEnabled() || !this.b.isNeedUpdateZoomControllerState() || (a2 = this.u.a(AMapWidgetListener.class.hashCode())) == null || a2.size() <= 0) {
                return;
            }
            synchronized (a2) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < a2.size()) {
                        ((AMapWidgetListener) a2.get(i2)).invalidateZoomController(this.b.getSZ());
                        i = i2 + 1;
                    }
                }
            }
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final void resetRenderTime() {
        GLMapRender gLMapRender = this.an;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    public final void resetRenderTimeLongLong() {
        GLMapRender gLMapRender = this.an;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(30);
        }
    }

    public final void set3DBuildingEnabled(boolean z) throws RemoteException {
        try {
            c(this.F);
            a(this.F, z);
            d(this.F);
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        y yVar = this.ao;
        if (yVar != null) {
            this.v = aMapGestureListener;
            yVar.a(aMapGestureListener);
        }
    }

    public final void setCenterToPixel(int i, int i2) throws RemoteException {
        this.I = true;
        this.aC = i;
        this.aD = i2;
        if (this.ax && this.aw) {
            if (this.b.getAnchorX() == this.aC && this.b.getAnchorY() == this.aD) {
                return;
            }
            this.b.setAnchorX(this.aC);
            this.b.setAnchorY(this.aD);
            queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.29
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        l.this.b.setAnchorX(Math.max(0, Math.min(l.this.aC, l.this.g)));
                        l.this.b.setAnchorY(Math.max(0, Math.min(l.this.aD, l.this.h)));
                        l.this.f.setProjectionCenter(l.this.F, l.this.b.getAnchorX(), l.this.b.getAnchorY());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public final void setConstructingRoadEnable(final boolean z) {
        try {
            if (this.aw && this.ax) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.27
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l.this.f.setMapOpenLayerEnable(z);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                return;
            }
            this.aR.c = z;
            this.aR.b = true;
            this.aR.g = this.F;
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        if (customMapStyleOptions != null) {
            try {
                if (a(true, false)) {
                    return;
                }
                if (customMapStyleOptions.isEnable() && (customMapStyleOptions.getStyleId() != null || customMapStyleOptions.getStyleTexturePath() != null || customMapStyleOptions.getStyleTextureData() != null || customMapStyleOptions.getStyleResDataPath() != null || customMapStyleOptions.getStyleResData() != null)) {
                    o();
                }
                this.aH.c();
                this.aH.a(customMapStyleOptions);
                if (this.aX != null) {
                    this.aX.i();
                }
            } catch (Throwable th) {
                dw.a(th);
                return;
            }
        }
        resetRenderTime();
    }

    public final void setCustomMapStyle(boolean z, byte[] bArr) {
        a(z, bArr, false);
    }

    public final void setCustomMapStyleID(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.b.getCustomStyleID())) {
            return;
        }
        this.b.setCustomStyleID(str);
        this.A = true;
    }

    public final void setCustomMapStylePath(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.b.getCustomStylePath())) {
            return;
        }
        this.b.setCustomStylePath(str);
        this.A = true;
    }

    public final void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException {
        this.ag = customRenderer;
    }

    public final void setCustomTextureResourcePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.setCustomTextureResourcePath(str);
    }

    public final void setGestureStatus(int i, int i2) {
        if (this.aB == 0 || i2 != 5) {
            this.aB = i2;
        }
    }

    public final void setHideLogoEnble(boolean z) {
        MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            mapConfig.setHideLogoEnble(z);
            if (this.b.isCustomStyleEnable()) {
                this.z.setLogoEnable(!z);
            }
        }
    }

    public final void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException {
        if (this.G.get() || indoorBuildingInfo == null || indoorBuildingInfo.activeFloorName == null || indoorBuildingInfo.poiid == null) {
            return;
        }
        this.c = (at) indoorBuildingInfo;
        resetRenderTime();
        queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.30
            @Override // java.lang.Runnable
            public final void run() {
                if (l.this.f != null) {
                    l.this.f.setIndoorBuildingToBeActive(l.this.F, l.this.c.activeFloorName, l.this.c.activeFloorIndex, l.this.c.poiid);
                }
            }
        });
    }

    public final void setIndoorEnabled(final boolean z) throws RemoteException {
        List a2;
        try {
            if (!this.aw || this.G.get()) {
                this.aU.c = z;
                this.aU.b = true;
                this.aU.g = this.F;
                return;
            }
            this.b.setIndoorEnable(z);
            resetRenderTime();
            if (!z) {
                if (this.f != null) {
                    this.f.setIndoorEnable(this.F, false);
                }
                this.b.maxZoomLevel = this.b.isSetLimitZoomLevel() ? this.b.getMaxZoomLevel() : 20.0f;
                try {
                    if (this.z.isZoomControlsEnabled() && (a2 = this.u.a(AMapWidgetListener.class.hashCode())) != null && a2.size() > 0) {
                        synchronized (a2) {
                            for (int i = 0; i < a2.size(); i++) {
                                ((AMapWidgetListener) a2.get(i)).invalidateZoomController(this.b.getSZ());
                            }
                        }
                    }
                } catch (Throwable th) {
                }
            } else if (this.f != null) {
                this.f.setIndoorEnable(this.F, true);
            }
            dt.c(this.e, z);
            if (this.z.isIndoorSwitchEnabled()) {
                this.j.post(new Runnable() { // from class: com.amap.api.col.3sl.l.22
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (z) {
                            l.this.showIndoorSwitchControlsEnabled(true);
                        } else if (l.this.C != null) {
                            l.this.C.i(Boolean.FALSE);
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            dw.a(th2);
        }
    }

    public final void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws RemoteException {
        au auVar;
        if (this.G.get() || (auVar = this.w) == null) {
            return;
        }
        auVar.a(commonInfoWindowAdapter);
    }

    public final void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        au auVar;
        if (this.G.get() || (auVar = this.w) == null) {
            return;
        }
        auVar.a(infoWindowAdapter);
    }

    public final void setLoadOfflineData(final boolean z) throws RemoteException {
        queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.23
            @Override // java.lang.Runnable
            public final void run() {
                if (l.this.f != null) {
                    l.this.f.setOfflineDataEnable(l.this.F, z);
                }
            }
        });
    }

    public final void setLocationSource(LocationSource locationSource) throws RemoteException {
        try {
            if (this.G.get()) {
                return;
            }
            if (this.L != null && (this.L instanceof av)) {
                this.L.deactivate();
            }
            this.L = locationSource;
            if (locationSource != null) {
                this.C.h(Boolean.TRUE);
            } else {
                this.C.h(Boolean.FALSE);
            }
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
            dw.a(th);
        }
    }

    public final void setLogoBottomMargin(int i) {
        eh ehVar = this.C;
        if (ehVar != null) {
            ehVar.c(Integer.valueOf(i));
        }
    }

    public final void setLogoLeftMargin(int i) {
        eh ehVar = this.C;
        if (ehVar != null) {
            ehVar.d(Integer.valueOf(i));
        }
    }

    public final void setLogoMarginRate(int i, float f) {
        eh ehVar = this.C;
        if (ehVar != null) {
            ehVar.a(Integer.valueOf(i), Float.valueOf(f));
        }
    }

    public final void setLogoPosition(int i) {
        eh ehVar = this.C;
        if (ehVar != null) {
            ehVar.b(Integer.valueOf(i));
        }
    }

    public final void setMapCustomEnable(boolean z) {
        if (z) {
            o();
        }
        setMapCustomEnable(z, false);
    }

    public final void setMapCustomEnable(boolean z, boolean z2) {
        if (!this.aw || this.G.get()) {
            this.aM.b = true;
            this.aM.c = z;
            return;
        }
        boolean z3 = z2 ? z2 : false;
        if (TextUtils.isEmpty(this.b.getCustomStylePath()) && TextUtils.isEmpty(this.b.getCustomStyleID())) {
            return;
        }
        if (z) {
            try {
                if (this.b.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.b.getCustomStyleID()) && this.ak != null) {
                    this.ak.a(this.b.getCustomStyleID());
                    this.ak.b();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                dw.a(th);
                return;
            }
        }
        if (z2 || this.A || (this.b.isCustomStyleEnable() ^ z)) {
            a(z, (byte[]) null, z3);
        }
        this.A = false;
    }

    public final void setMapEnable(boolean z) {
        MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            mapConfig.setMapEnable(z);
        }
    }

    public final void setMapLanguage(String str) {
        MapConfig mapConfig;
        if (TextUtils.isEmpty(str) || (mapConfig = this.b) == null || mapConfig.isCustomStyleEnable() || this.b.getMapLanguage().equals(str)) {
            return;
        }
        if (!str.equals("en")) {
            this.b.setMapLanguage(AMap.CHINESE);
            this.af = 0;
        } else {
            if (this.Y != 1) {
                try {
                    setMapType(1);
                } catch (Throwable th) {
                    dw.a(th);
                    th.printStackTrace();
                }
            }
            this.b.setMapLanguage("en");
            this.af = -10000;
        }
        try {
            b(getCameraPosition());
        } catch (Throwable th2) {
            dw.a(th2);
            th2.printStackTrace();
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.b.setLimitLatLngBounds(latLngBounds);
            p();
        } catch (Throwable th) {
            th.printStackTrace();
            dw.a(th);
        }
    }

    public final void setMapTextEnable(final boolean z) throws RemoteException {
        try {
            if (this.aw && this.ax) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.24
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l.this.f.setLabelEnable(l.this.F, z);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                return;
            }
            this.aO.c = z;
            this.aO.b = true;
            this.aO.g = this.F;
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final void setMapTextZIndex(int i) throws RemoteException {
        this.af = i;
        this.i = false;
    }

    public final void setMapType(int i) throws RemoteException {
        MapConfig mapConfig;
        if (i != this.Y || ((mapConfig = this.b) != null && mapConfig.isCustomStyleEnable())) {
            this.Y = i;
            h(i);
        }
    }

    public final void setMapWidgetListener(AMapWidgetListener aMapWidgetListener) {
        try {
            if (this.u != null) {
                this.u.a(AMapWidgetListener.class.hashCode(), (int) aMapWidgetListener);
            }
        } catch (Throwable th) {
        }
    }

    public final void setMaskLayerParams(int i, int i2, int i3, int i4, int i5, long j) {
    }

    public final void setMaxZoomLevel(float f) {
        this.b.setMaxZoomLevel(f);
    }

    public final void setMinZoomLevel(float f) {
        this.b.setMinZoomLevel(f);
    }

    public final void setMyLocationEnabled(boolean z) throws RemoteException {
        if (this.G.get()) {
            return;
        }
        try {
            if (this.C != null) {
                if (this.L == null) {
                    this.C.h(Boolean.FALSE);
                } else if (z) {
                    this.L.activate(this.t);
                    this.C.h(Boolean.TRUE);
                    if (this.K == null) {
                        this.K = new ck(this, this.e);
                    }
                } else {
                    if (this.K != null) {
                        this.K.c();
                        this.K = null;
                    }
                    this.L.deactivate();
                }
            }
            if (!z) {
                this.z.setMyLocationButtonEnabled(z);
            }
            this.E = z;
            resetRenderTime();
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImp", "setMyLocationEnabled");
            th.printStackTrace();
            dw.a(th);
        }
    }

    public final void setMyLocationRotateAngle(float f) throws RemoteException {
        try {
            if (this.K != null) {
                this.K.a(f);
            }
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (this.G.get()) {
            return;
        }
        try {
            if (this.K == null) {
                this.K = new ck(this, this.e);
            }
            if (this.K != null) {
                if (myLocationStyle.getInterval() < 1000) {
                    myLocationStyle.interval(1000L);
                }
                if (this.L != null && (this.L instanceof av)) {
                    ((av) this.L).a(myLocationStyle.getInterval());
                    ((av) this.L).a(myLocationStyle.getMyLocationType());
                }
                this.K.a(myLocationStyle);
            }
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final void setMyLocationType(int i) throws RemoteException {
        try {
            if (this.K == null || this.K.a() == null) {
                return;
            }
            this.K.a().myLocationType(i);
            setMyLocationStyle(this.K.a());
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final void setNaviLabelEnable(final boolean z, final int i, final int i2) throws RemoteException {
        try {
            if (this.aw && this.ax) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.26
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l.this.f.setNaviLabelEnable(l.this.F, z, i, i2);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                return;
            }
            this.aQ.c = z;
            this.aQ.h = i;
            this.aQ.i = i2;
            this.aQ.b = true;
            this.aQ.g = this.F;
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(AMap.OnCameraChangeListener.class.hashCode(), (int) onCameraChangeListener);
        }
    }

    public final void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(AMap.OnIndoorBuildingActiveListener.class.hashCode(), (int) onIndoorBuildingActiveListener);
        }
    }

    public final void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(AMap.OnInfoWindowClickListener.class.hashCode(), (int) onInfoWindowClickListener);
        }
    }

    public final void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(AMap.OnMapClickListener.class.hashCode(), (int) onMapClickListener);
        }
    }

    public final void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(AMap.OnMapLongClickListener.class.hashCode(), (int) onMapLongClickListener);
        }
    }

    public final void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(AMap.OnMapTouchListener.class.hashCode(), (int) onMapTouchListener);
        }
    }

    public final void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(AMap.OnMapLoadedListener.class.hashCode(), (int) onMapLoadedListener);
        }
    }

    public final void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(AMap.OnMarkerClickListener.class.hashCode(), (int) onMarkerClickListener);
        }
    }

    public final void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(AMap.OnMarkerDragListener.class.hashCode(), (int) onMarkerDragListener);
        }
    }

    public final void setOnMultiPointClickListener(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        this.aG = onMultiPointClickListener;
    }

    public final void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(AMap.OnMyLocationChangeListener.class.hashCode(), (int) onMyLocationChangeListener);
        }
    }

    public final void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(AMap.OnPOIClickListener.class.hashCode(), (int) onPOIClickListener);
        }
    }

    public final void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        q qVar = this.u;
        if (qVar != null) {
            qVar.a(AMap.OnPolylineClickListener.class.hashCode(), (int) onPolylineClickListener);
        }
    }

    public final void setRenderFps(int i) {
        try {
            if (i == -1) {
                this.ai = i;
            } else {
                this.ai = Math.max(10, Math.min(i, 40));
            }
            dt.g(this.e);
        } catch (Throwable th) {
            dw.a(th);
            th.printStackTrace();
        }
    }

    public final void setRenderMode(int i) {
        try {
            if (this.B != null) {
                this.B.setRenderMode(i);
            }
        } catch (Throwable th) {
        }
    }

    public final void setRoadArrowEnable(final boolean z) throws RemoteException {
        try {
            if (this.aw && this.ax) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.25
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l.this.f.setRoadArrowEnable(l.this.F, z);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                return;
            }
            this.aP.c = z;
            this.aP.b = true;
            this.aP.g = this.F;
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final void setRunLowFrame(boolean z) {
        if (z) {
            return;
        }
        try {
            if (this.ai == -1) {
                m();
            }
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final void setTerrainAuth(boolean z) {
        GLMapEngine gLMapEngine;
        if (this.G.get() || (gLMapEngine = this.f) == null) {
            return;
        }
        gLMapEngine.setTerrainAuth(z);
    }

    public final void setTouchPoiEnable(boolean z) {
        MapConfig mapConfig = this.b;
        if (mapConfig != null) {
            mapConfig.setTouchPoiEnable(z);
        }
    }

    public final void setTrafficEnabled(final boolean z) throws RemoteException {
        try {
            if (this.aw && !this.G.get()) {
                queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.20
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (l.this.b.isTrafficEnabled() != z) {
                                l.this.b.setTrafficEnabled(z);
                                l.this.an.setTrafficMode(z);
                                l.this.f.setTrafficEnable(l.this.F, z);
                                l.this.resetRenderTime();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            dw.a(th);
                        }
                    }
                });
                return;
            }
            this.aJ.c = z;
            this.aJ.b = true;
            this.aJ.g = this.F;
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final void setTrafficStyleWithTextureData(final byte[] bArr) {
        if (this.G.get()) {
            return;
        }
        try {
            if (this.aw && this.ax && bArr != null) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.col.3sl.l.28
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            l.this.f.setTrafficStyleWithTextureData(l.this.F, bArr);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                return;
            }
            this.aS.j = bArr;
            this.aS.b = true;
            this.aS.g = this.F;
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final void setVisibilityEx(int i) {
        IGLSurfaceView iGLSurfaceView = this.B;
        if (iGLSurfaceView != null) {
            try {
                iGLSurfaceView.setVisibility(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void setWorldVectorMapStyle(String str) {
        if (a(false, true) || TextUtils.isEmpty(str) || this.b == null || this.aZ.equals(str)) {
            return;
        }
        this.aZ = str;
        com.autonavi.extra.b bVar = this.aX;
        if (bVar != null) {
            bVar.i();
        }
        resetRenderTime();
    }

    public final void setZOrderOnTop(boolean z) throws RemoteException {
    }

    public final void setZoomPosition(int i) {
        eh ehVar;
        if (this.G.get() || (ehVar = this.C) == null) {
            return;
        }
        ehVar.a(Integer.valueOf(i));
    }

    public final void setZoomScaleParam(float f) {
        this.ar = f;
    }

    public final void showCompassEnabled(boolean z) {
        eh ehVar;
        if (this.G.get() || (ehVar = this.C) == null) {
            return;
        }
        ehVar.d(Boolean.valueOf(z));
    }

    public final void showIndoorSwitchControlsEnabled(boolean z) {
        eh ehVar;
        if (this.G.get() || (ehVar = this.C) == null) {
            return;
        }
        ehVar.a(Boolean.valueOf(z));
    }

    public final void showInfoWindow(BaseOverlay baseOverlay) throws RemoteException {
        au auVar;
        if (baseOverlay == null || (auVar = this.w) == null) {
            return;
        }
        try {
            auVar.a(baseOverlay);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
        au auVar;
        if (baseOverlayImp == null || (auVar = this.w) == null) {
            return;
        }
        try {
            auVar.a(baseOverlayImp);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void showLogoEnabled(boolean z) {
        if (this.G.get()) {
            return;
        }
        this.C.f(Boolean.valueOf(z));
    }

    public final void showMyLocationButtonEnabled(boolean z) {
        eh ehVar;
        if (this.G.get() || (ehVar = this.C) == null) {
            return;
        }
        ehVar.c(Boolean.valueOf(z));
    }

    public final void showMyLocationOverlay(Location location) throws RemoteException {
        if (location == null) {
            return;
        }
        try {
            if (this.E && this.L != null) {
                if (this.K == null) {
                    this.K = new ck(this, this.e);
                }
                if (location.getLongitude() != 0.0d && location.getLatitude() != 0.0d) {
                    this.K.a(location);
                }
                List a2 = this.u.a(AMap.OnMyLocationChangeListener.class.hashCode());
                if (a2 != null && a2.size() > 0) {
                    synchronized (a2) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= a2.size()) {
                                break;
                            }
                            ((AMap.OnMyLocationChangeListener) a2.get(i2)).onMyLocationChange(location);
                            i = i2 + 1;
                        }
                    }
                }
                resetRenderTime();
                return;
            }
            if (this.K != null) {
                this.K.c();
            }
            this.K = null;
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImp", "showMyLocationOverlay");
            th.printStackTrace();
        }
    }

    public final void showScaleEnabled(boolean z) {
        eh ehVar;
        if (this.G.get() || (ehVar = this.C) == null) {
            return;
        }
        ehVar.e(Boolean.valueOf(z));
    }

    public final void showZoomControlsEnabled(boolean z) {
        eh ehVar;
        if (this.G.get() || (ehVar = this.C) == null) {
            return;
        }
        ehVar.b(Boolean.valueOf(z));
    }

    public final void stopAnimation() throws RemoteException {
        try {
            if (this.f != null) {
                this.f.interruptAnimation();
            }
            resetRenderTime();
        } catch (Throwable th) {
            dw.a(th);
        }
    }

    public final float toMapLenWithWin(int i) {
        GLMapEngine gLMapEngine;
        if (!this.aw || this.H || (gLMapEngine = this.f) == null) {
            return 0.0f;
        }
        return gLMapEngine.getMapState(this.F).getGLUnitWithWin(i);
    }

    public final void zoomOut(int i) {
        if (this.aw && ((int) c()) > this.b.getMinZoomLevel()) {
            try {
                animateCamera(ak.b());
            } catch (Throwable th) {
                iw.c(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
        }
    }
}
